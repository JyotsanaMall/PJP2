package com.sapient.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.calculator.entity.History;
import com.sapient.calculator.repository.HistoryRepository;

@RestController
public class HistoryController {
	
	@Autowired
	HistoryRepository historyRepository;
	
	@Autowired
	History history;
	
	@GetMapping("/history")
	public List<History> findAll() {
		return historyRepository.findAll();
	}
	
	@DeleteMapping("/history/{id}")
	public void deleteById(@PathVariable Long id) {
		historyRepository.deleteById(id);
	}
}
