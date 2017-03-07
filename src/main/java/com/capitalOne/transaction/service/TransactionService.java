/**
 * 
 */
package com.capitalOne.transaction.service;

import java.util.List;
import java.util.Map;

import com.capitalOne.transaction.dto.Common;
import com.capitalOne.transaction.dto.MonthRequestBody;
import com.capitalOne.transaction.dto.MonthlyBudget;
import com.capitalOne.transaction.dto.Transactions;
import com.capitalOne.transaction.dto.TransactionsResponseBody;

/**
 * @author aberehamwodajie
 *
 * Mar 5, 2017
 */
public interface TransactionService {
	public TransactionsResponseBody getAllTransactions(Common common);
	public TransactionsResponseBody getProjectedTransactionsForMonthResponse(MonthRequestBody monthRequestBody);
	public Map<String, MonthlyBudget> getMonthlyBudget(Common common);
	public Map<String, MonthlyBudget> ignoreDonuts(Common common);
	public Map<String, List<Transactions>> ignoreCcPayments(Common common);
}
