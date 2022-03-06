package model;

import java.time.LocalDate;

public class Value {
	private Double amount;
	private LocalDate date;
	private String description;
	private String type;
	
	public Value(Double amount, LocalDate date, String description, String type) {
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
