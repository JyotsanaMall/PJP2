package com.sapient.calculator.controller;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sapient.calculator.entity.DateFromPhrase;
import com.sapient.calculator.entity.History;
import com.sapient.calculator.operation.Conversion;
import com.sapient.calculator.operation.DateFromPhraseOperation;
import com.sapient.calculator.repository.DateFromPhraseRepository;
import com.sapient.calculator.repository.HistoryRepository;

import javassist.NotFoundException;

@RestController
public class DateFromPhraseController {
	
	@Autowired
	DateFromPhraseRepository dateFromPhraseRepository;
	
	@Autowired
	DateFromPhrase dateFromPhrase;
	
	@Autowired
	HistoryRepository historyRepository;
	
	@Autowired
	History history;
	
	@GetMapping("/date-from-phrase/all")
	public List<DateFromPhrase> findAll() {
		return dateFromPhraseRepository.findAll();
	}
	
	@GetMapping("/date-from-phrase/{id}")
	public DateFromPhrase findById(@PathVariable Long id) throws NotFoundException {
		return dateFromPhraseRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found " +id));
	}
	
	@PostMapping("/date-from-phrase")
	public ResponseEntity<Object> createDayOfWeek(@PathVariable String phrase) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		dateFromPhrase.setPhrase(phrase);
		dateFromPhrase.setToday(Conversion.dateToString(cal));
		dateFromPhrase.setFinalDate(DateFromPhraseOperation.getDateFromPhrase(phrase, cal));
		
		history.setMenuOption("Date From Phrase");
		history.setInitialDate(dateFromPhrase.getToday());
		history.setFinalDate(dateFromPhrase.getFinalDate());
		
		historyRepository.save(history);
		
		URI location = ServletUriComponentsBuilder
					   .fromCurrentRequest()
					   .path("/{id}")
					   .buildAndExpand(dateFromPhrase.getId())
					   .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/date-from-phrase/{id}")
	public void deleteById(@PathVariable Long id) {
		dateFromPhraseRepository.deleteById(id);
	}
}
