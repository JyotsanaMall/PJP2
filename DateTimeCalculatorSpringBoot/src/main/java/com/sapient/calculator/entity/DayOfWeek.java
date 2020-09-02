package com.sapient.calculator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class DayOfWeek {
	@Id
	@GeneratedValue
	private Long id;
	private String date;
	private String dayOfWeek;
	
	@Override
	public String toString() {
		return "DayOfWeek [id=" + id + ", date=" + date + ", dayOfWeek=" + dayOfWeek + "]";
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
	
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
}
