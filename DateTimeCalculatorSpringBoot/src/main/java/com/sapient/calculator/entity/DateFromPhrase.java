package com.sapient.calculator.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import org.springframework.stereotype.Component;

@Component
@Entity
public class DateFromPhrase {

	@Id
	@GeneratedValue
	private Long id;
	private String phrase;
	private String today;
	private String finalDate;
	
	@Override
	public String toString() {
		return "DateFromPhrase [id=" + id + ", phrase=" + phrase + ", today=" + today + ", finalDate=" + finalDate
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}
}
