/**
 * 
 */
package com.capitalOne.transaction.service;

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
import com.capitalOne.transaction.dto.TransactionsResponseBody;

/**
 * @author Abereham Wodajie
 *
 *         Mar 4, 2017
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepositoryImpl  transactionRepository;

	private static final Logger LOG = LoggerFactory.getLogger(TransactionServiceImpl.class);

    //This method retrieves all transactions
	public TransactionsResponseBody getAllTransactions(Common common) {

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");		
		HttpEntity<Common> request = new HttpEntity<Common>(common, headers);		
		LOG.debug("Calling end point repository: ");
		
		return transactionRepository.getAllTransactions(request);
	}
	
	//This method retrieves monthly transactions
	public TransactionsResponseBody getProjectedTransactionsForMonthResponse(MonthRequestBody monthRequestBody) {

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		HttpEntity<MonthRequestBody> request = new HttpEntity<MonthRequestBody>(monthRequestBody, headers);
		LOG.debug("Calling the remote service: get all monthly transactions");

		return transactionRepository.getProjectedTransactionsForMonthResponse(request);
	}

}
