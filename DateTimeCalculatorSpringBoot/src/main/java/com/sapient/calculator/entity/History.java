package com.sapient.calculator.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import org.springframework.stereotype.Component;

@Component
@Entity
public class History {

	@Id
	@GeneratedValue
	private Long id;
	private String menuOption;
	private String initialDate;
	private String finalDate;
	private String ans;
	
	public History() {
		this.menuOption = "N.A";
		this.initialDate = "N.A";
		this.finalDate = "N.A";
		this.ans = "N.A";
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", menuOption=" + menuOption + ", initialDate=" + initialDate + ", finalDate="
				+ finalDate + ", ans=" + ans + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuOption() {
		return menuOption;
	}

	public void setMenuOption(String menuOption) {
		this.menuOption = menuOption;
	}

	public String getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}

	public String getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}
}
