package com.practice.springbootmongodb.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springbootmongodb.model.Expense;
import com.practice.springbootmongodb.service.ExpenseService;

@RestController
@RequestMapping("/api/exp")
public class ExpenseController {
	private final ExpenseService es;

	public ExpenseController(ExpenseService es) {
		super();
		this.es = es;
	}

	@PostMapping("addExp")
	public ResponseEntity addExpense(@RequestBody Expense ex) {
		es.addExpense(ex);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("updt")
	public ResponseEntity updateExpense(@RequestBody Expense ex) {
		es.updateExpense(ex);
		return ResponseEntity.ok().build();
	}

	@GetMapping("getAllExp")
	public ResponseEntity<List<Expense>> getAllExpense() {
		return ResponseEntity.ok(es.getAllExpense());
	}

	@GetMapping("expbyname/{name}")
	public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
		return ResponseEntity.ok(es.getExpenseByName(name));
	}

	@DeleteMapping("del/{id}")
	public ResponseEntity deleteExpense(@PathVariable String id) {
		es.deleteExpense(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}