package com.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.entity.Expense;
import com.expensetracker.repository.ExpenseTrackerRepository;

@Service
public class ExpenseTrackerServiceImpl implements ExpenseTrackerService {

	@Autowired
	private ExpenseTrackerRepository expenseRepository;

	@Override
	public Integer saveExpense(Expense expense) {
		return expenseRepository.save(expense).getEid();
	}

}
