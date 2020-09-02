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

import com.sapient.calculator.entity.DayOfWeek;
import com.sapient.calculator.entity.History;
import com.sapient.calculator.operation.Conversion;
import com.sapient.calculator.operation.DayOfWeekOperation;
import com.sapient.calculator.repository.DayOfWeekRepository;
import com.sapient.calculator.repository.HistoryRepository;

import javassist.NotFoundException;

@RestController
public class DayOfWeekController {
	
	@Autowired
	DayOfWeekRepository dayOfWeekRepository;
	
	@Autowired
	DayOfWeek dayOfWeek;
	
	@Autowired
	HistoryRepository historyRepository;
	
	@Autowired
	History history;
	
	@GetMapping("/day-of-week/all")
	public List<DayOfWeek> findAll() {
		return dayOfWeekRepository.findAll();
	}
	
	@GetMapping("/day-of-week/{id}")
	public DayOfWeek findById(@PathVariable Long id) throws NotFoundException {
		return dayOfWeekRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found " +id));
	}
	
	@PostMapping("/day-of-week")
	public ResponseEntity<Object> createDayOfWeek(@PathVariable String date) {
		dayOfWeek.setDate(date);
		dayOfWeek.setDayOfWeek(DayOfWeekOperation.getDayOfWeek(Conversion.stringToDate(date)));
		
		history.setMenuOption("Day Of Week");
		history.setInitialDate(date);
		history.setAns(dayOfWeek.getDayOfWeek());
		
		historyRepository.save(history);
		
		URI location = ServletUriComponentsBuilder
					   .fromCurrentRequest()
					   .path("/{id}")
					   .buildAndExpand(dayOfWeek.getId())
					   .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/day-of-week/{id}")
	public void deleteById(@PathVariable Long id) {
		dayOfWeekRepository.deleteById(id);
	}
}
