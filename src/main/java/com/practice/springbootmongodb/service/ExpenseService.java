package com.practice.springbootmongodb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.springbootmongodb.model.Expense;
import com.practice.springbootmongodb.repository.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository er;

	public ExpenseService(ExpenseRepository er) {
		super();
		this.er = er;
	}

	public void addExpense(Expense ex) {
		er.insert(ex);
	}

	public void updateExpense(Expense ex) {
		Expense savedEx = er.findById(ex.getId()).orElseThrow(
				() -> new RuntimeException(""
						+ "Failed to find by ID" + ex.getId()));

		savedEx.setExpAmount(ex.getExpAmount());
		savedEx.setExpanceName(ex.getExpanceName());
		savedEx.setExpCategory(ex.getExpCategory());
		er.save(savedEx);
	}

	public List<Expense> getAllExpense() {
		return er.findAll();
	}

	public Expense getExpenseByName(String name) {
		return er.findByName(name).orElseThrow(() -> new RuntimeException(
				"Failed to find expense by name" + name));

	}

	public void deleteExpense(String id) {
		er.deleteById(id);
	}
}
