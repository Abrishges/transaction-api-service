/**
 * 
 */
package com.capitalOne.transaction.dao;

import org.springframework.http.HttpEntity;

import com.capitalOne.transaction.dto.Common;
import com.capitalOne.transaction.dto.MonthRequestBody;
import com.capitalOne.transaction.dto.TransactionsResponseBody;

/**
 * @author aberehamwodajie
 *
 * Mar 5, 2017
 */
public interface TransactionRepository {
	public TransactionsResponseBody getAllTransactions(HttpEntity<Common> request );
	public TransactionsResponseBody getProjectedTransactionsForMonthResponse(HttpEntity<MonthRequestBody> request);
}
