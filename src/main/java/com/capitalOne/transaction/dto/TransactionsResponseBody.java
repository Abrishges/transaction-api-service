/**
 * 
 */
package com.capitalOne.transaction.dto;

import java.util.List;

/**
 * @author Abereham Wodajie
 *
 *         Mar 4, 2017
 */
public class TransactionsResponseBody {
	private String error;
	private List<Transactions> transactions;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

}
