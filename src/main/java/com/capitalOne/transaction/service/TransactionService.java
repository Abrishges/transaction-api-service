/**
 * 
 */
package com.capitalOne.transaction.service;

import com.capitalOne.transaction.dto.Common;
import com.capitalOne.transaction.dto.MonthRequestBody;
import com.capitalOne.transaction.dto.TransactionsResponseBody;

/**
 * @author aberehamwodajie
 *
 * Mar 5, 2017
 */
public interface TransactionService {
	public TransactionsResponseBody getAllTransactions(Common common);
	public TransactionsResponseBody getProjectedTransactionsForMonthResponse(MonthRequestBody monthRequestBody);
}
