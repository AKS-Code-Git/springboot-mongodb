package com.practice.springbootmongodb.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("expense")
public class Expense {
	@Id
	private String id;
	@Field(name = "name")
	@Indexed(unique = true)
	private String expanceName;
	@Field(name = "category")
	private ExpenseCategory expCategory;
	@Field(name = "amount")
	private BigDecimal expAmount;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the expanceName
	 */
	public String getExpanceName() {
		return expanceName;
	}

	/**
	 * @param expanceName the expanceName to set
	 */
	public void setExpanceName(String expanceName) {
		this.expanceName = expanceName;
	}

	/**
	 * @return the expCategory
	 */
	public ExpenseCategory getExpCategory() {
		return expCategory;
	}

	/**
	 * @param expCategory the expCategory to set
	 */
	public void setExpCategory(ExpenseCategory expCategory) {
		this.expCategory = expCategory;
	}

	/**
	 * @return the expAmount
	 */
	public BigDecimal getExpAmount() {
		return expAmount;
	}

	/**
	 * @param expAmount the expAmount to set
	 */
	public void setExpAmount(BigDecimal expAmount) {
		this.expAmount = expAmount;
	}

}
