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
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.capitalOne.transaction.dto.Common;
import com.capitalOne.transaction.dto.TransactionsResponseBody;

/**
 * @author aberehamwodajie
 *
 *         Mar 5, 2017
 */
// @Respository
@Component
public class TransactionRepositoryImpl implements TransactionRepository {

	private static final Logger LOG = LoggerFactory.getLogger(TransactionRepositoryImpl.class);

	@Value("${transactions.getallurl}")
	private String getallurl;

	public TransactionsResponseBody getAllTransactions(HttpEntity<Common> request) {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		ResponseEntity<TransactionsResponseBody> response = null;

		try {
			LOG.debug("getallurl: " + getallurl);
			String url = "xx";
			response = restTemplate.postForEntity(url, request, TransactionsResponseBody.class);
			LOG.debug("Successfuly get all data: ");
		} catch (HttpStatusCodeException exception) {
			int statusCode = exception.getStatusCode().value();
			LOG.debug("Status code:" + statusCode);
			// throw new NoHandlerFoundException("No Handler found", getallurl,
			// null);
		}

		LOG.debug("response: " + response.toString());

		TransactionsResponseBody responseBody = response.getBody();

		return responseBody;
	}

}
