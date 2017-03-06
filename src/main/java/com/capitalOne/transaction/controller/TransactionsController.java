/**
 * 
 */
package com.capitalOne.transaction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capitalOne.transaction.dto.Common;
import com.capitalOne.transaction.dto.TransactionsResponseBody;
import com.capitalOne.transaction.service.TransactionServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author aberehamwodajie
 *
 *         Mar 4, 2017
 */

@RestController
@Api(tags = "Transactions")
@RequestMapping("/capitalOne")
public class TransactionsController {

	@Autowired
	private TransactionServiceImpl transactionService;

	private static final Logger LOG = LoggerFactory.getLogger(TransactionsController.class);

	@ApiOperation(value = "Get all customer Transactionss", notes = "Get all Transactions ")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Fields are with validation errors") })
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/transactions", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public TransactionsResponseBody getAllTransactions(@RequestBody Common request) {

		LOG.debug("Calling service: @Transactions Controller ");
		return transactionService.getAllTransactions(request);
	}

}
