package com.sapient.calculator.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import org.springframework.stereotype.Component;

@Component
@Entity
public class WeekNumber {

	@Id
	@GeneratedValue
	private Long id;
	private String date;
	private int weekNumber;
	
	@Override
	public String toString() {
		return "WeekNumber [id=" + id + ", date=" + date + ", weekNumber=" + weekNumber + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}
}
