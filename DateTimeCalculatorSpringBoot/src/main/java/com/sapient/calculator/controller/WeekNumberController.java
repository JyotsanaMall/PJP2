package com.sapient.calculator.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sapient.calculator.entity.History;
import com.sapient.calculator.entity.WeekNumber;
import com.sapient.calculator.operation.Conversion;
import com.sapient.calculator.operation.WeekNumberOperation;
import com.sapient.calculator.repository.HistoryRepository;
import com.sapient.calculator.repository.WeekNumberRepository;

import javassist.NotFoundException;

@RestController
public class WeekNumberController {
	
	@Autowired
	WeekNumberRepository weekNumberRepository;
	
	@Autowired
	WeekNumber weekNumber;
	
	@Autowired
	HistoryRepository historyRepository;
	
	@Autowired
	History history;
	
	@GetMapping("/week-number/all")
	public List<WeekNumber> findAll() {
		return weekNumberRepository.findAll();
	}
	
	@GetMapping("/week-number/{id}")
	public WeekNumber findById(@PathVariable Long id) throws NotFoundException {
		return weekNumberRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found " +id));
	}
	
	@PostMapping("/week-number")
	public ResponseEntity<Object> createDayOfWeek(@PathVariable String date) {
		weekNumber.setDate(date);
		weekNumber.setWeekNumber(WeekNumberOperation.getWeekNumber(Conversion.stringToDate(date)));
		
		history.setMenuOption("Week Number");
		history.setInitialDate(date);
		history.setAns(String.valueOf(weekNumber.getWeekNumber()));
		
		historyRepository.save(history);
		
		URI location = ServletUriComponentsBuilder
					   .fromCurrentRequest()
					   .path("/{id}")
					   .buildAndExpand(weekNumber.getId())
					   .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/week-number/{id}")
	public void deleteById(@PathVariable Long id) {
		weekNumberRepository.deleteById(id);
	}
}
