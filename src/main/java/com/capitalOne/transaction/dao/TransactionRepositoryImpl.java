/**
 * 
 */
package com.capitalOne.transaction.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.capitalOne.transaction.dto.Common;
import com.capitalOne.transaction.dto.MonthRequestBody;
import com.capitalOne.transaction.dto.TransactionsResponseBody;

/**
 * @author Abereham Wodajie
 *
 *         Mar 5, 2017
 */
//@Component
@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	private static final Logger LOG = LoggerFactory.getLogger(TransactionRepositoryImpl.class);

	@Value("${transactions.getallurl}")
	private String getallurl;

	@Value("${transactions.getmonthlyurl}")
	private String monthlyurl;

	// This method retrieves all transactions
	public TransactionsResponseBody getAllTransactions(HttpEntity<Common> request) {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		ResponseEntity<TransactionsResponseBody> response = null;

		try {
			LOG.debug("getallurl: " + getallurl);
			response = restTemplate.postForEntity(getallurl, request, TransactionsResponseBody.class);
			LOG.debug("Successfuly get all data: ");
		} catch (HttpStatusCodeException exception) {
			int statusCode = exception.getStatusCode().value();
			LOG.debug("Status code:" + statusCode);
			// intercepted by customer Exception
		}
        LOG.debug("End of calling ");
		TransactionsResponseBody responseBody = response.getBody();

		return responseBody;
	}

	// This method retrieves monthly transactions
	public TransactionsResponseBody getProjectedTransactionsForMonthResponse(HttpEntity<MonthRequestBody> request) {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		ResponseEntity<TransactionsResponseBody> response = null;
		try {
			response = restTemplate.postForEntity(monthlyurl, request, TransactionsResponseBody.class);
		} catch (HttpStatusCodeException exception) {
			// intercepted by customer Exception
			int statusCode = exception.getStatusCode().value();
			LOG.debug("Status code:" + statusCode);
		}

		TransactionsResponseBody responseBody = response.getBody();
		LOG.debug("End of calling the remote server");

		return responseBody;
	}

}
