/**
 * 
 */
package com.capitalOne.transaction.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.capitalOne.transaction.dao.TransactionRepositoryImpl;
import com.capitalOne.transaction.dto.Common;
import com.capitalOne.transaction.dto.MonthRequestBody;
import com.capitalOne.transaction.dto.MonthlyBudget;
import com.capitalOne.transaction.dto.Transactions;
import com.capitalOne.transaction.dto.TransactionsResponseBody;

/**
 * @author Abereham Wodajie
 *
 *         Mar 4, 2017
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepositoryImpl transactionRepository;

	private static final Logger LOG = LoggerFactory.getLogger(TransactionServiceImpl.class);

	// This method retrieves all transactions
	public TransactionsResponseBody getAllTransactions(Common common) {
		
		if(common.getArgs().getToken() == null || common.getArgs().getToken().isEmpty() || common.getArgs().getUid() == 0){
			throw new IllegalArgumentException("The 'Uid or token' parameter must not be null or empty");
		}

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		HttpEntity<Common> request = new HttpEntity<Common>(common, headers);
		LOG.debug("Calling end point repository: ");

		return transactionRepository.getAllTransactions(request);
	}

	// This method retrieves monthly transactions
	public TransactionsResponseBody getProjectedTransactionsForMonthResponse(MonthRequestBody monthRequestBody) {

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		HttpEntity<MonthRequestBody> request = new HttpEntity<MonthRequestBody>(monthRequestBody, headers);
		LOG.debug("Calling the remote service: get all monthly transactions");

		return transactionRepository.getProjectedTransactionsForMonthResponse(request);
	}

	// This method retrieves monthly expense and average expense
	public Map<String, MonthlyBudget> getMonthlyBudget(Common common) {

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		HttpEntity<Common> request = new HttpEntity<Common>(common, headers);
		LOG.debug("Calling end point repository: ");

		List<Transactions> listOfTransactions = transactionRepository.getAllTransactions(request).getTransactions();
		// HashMap makes it more efficient but TreeMap is used to get sorted result 		
		Map<String, MonthlyBudget> map = new TreeMap<String, MonthlyBudget>();
		long totalSpent = 0;
		long totalIncome = 0;

		for (Transactions transaction : listOfTransactions) {

			String date = transaction.getTransactionTime().substring(0, 7);
			long amount = transaction.getAmount();
			MonthlyBudget budget = null;
			if (map.containsKey(date)) {
				budget = map.get(date);
				if (amount < 0) {
					budget.setSpent(budget.getSpent() + amount);
					totalSpent += amount;
				} else {
					budget.setIncome(budget.getIncome() + amount);
					totalIncome += amount;
				}
			} else {
				if (amount < 0) {
					budget = new MonthlyBudget(amount, 0);
					totalSpent += amount;
				} else {
					budget = new MonthlyBudget(0, amount);
					totalIncome += amount;
				}

			}
			map.put(date, budget);

		}
		LOG.debug("map size: " + map.size());
		// calculating average
		int size = map.size();
		long spent = (long) ((float) totalSpent / size);
		long income = (long) ((float) totalIncome / size);
		MonthlyBudget averageBudget = new MonthlyBudget(spent, income);

		map.put("average", averageBudget);

		return map;
	}

	//Returns monthly expense ignoring daunts 
	public Map<String, MonthlyBudget> ignoreDonuts(Common common) {

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		HttpEntity<Common> request = new HttpEntity<Common>(common, headers);
		LOG.debug("Calling end point repository: ");

		List<Transactions> listOfTransactions = transactionRepository.getAllTransactions(request).getTransactions();
        // HashMap makes it more efficient but TreeMap is used to get sorted result 																		
		Map<String, MonthlyBudget> map = new TreeMap<String, MonthlyBudget>(); 
		long totalSpent = 0;
		long totalIncome = 0;

		for (Transactions transaction : listOfTransactions) {

			String date = transaction.getTransactionTime().substring(0, 7);
			long amount = transaction.getAmount();
			MonthlyBudget budget = null;
			String merchant = transaction.getMerchant();

			if (!(merchant.equals("Krispy Kreme Donuts") || merchant.equals("Krispy Kreme Donuts"))) {

				if (map.containsKey(date)) {
					budget = map.get(date);
					if (amount < 0) {
						budget.setSpent(budget.getSpent() + amount);
						totalSpent += amount;
					} else {
						budget.setIncome(budget.getIncome() + amount);
						totalIncome += amount;
					}
				} else {
					if (amount < 0) {
						budget = new MonthlyBudget(amount, 0);
						totalSpent += amount;
					} else {
						budget = new MonthlyBudget(0, amount);
						totalIncome += amount;
					}

				}
				map.put(date, budget);
			}

		}
		LOG.debug("map size: " + map.size());
		// calculating average
		int size = map.size();
		long spent = (long) ((float) totalSpent / size);
		long income = (long) ((float) totalIncome / size);
		MonthlyBudget averageBudget = new MonthlyBudget(spent, income);
		map.put("average", averageBudget);

		return map;
	}

}
