/**
 * 
 */
package com.capitalOne.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author aberehamwodajie
 *
 * Mar 4, 2017
 */
public class Transactions {
	@JsonProperty("transaction-id")
   private String transaction_id;
	
	@JsonProperty("account-id")
   private String accountId;  
	
	@JsonProperty("raw-merchant")
   private String rawMerchant;
   private String  merchant;
   
	@JsonProperty("is-pending")
   private boolean isPending; 
   
	
	@JsonProperty("transaction-time")
   private String transactionTime;
   private Integer amount; //
   
	@JsonProperty("previous-transaction-id")
   private String previousTransactionId;
   private String categorization;
   
	@JsonProperty("memo-only-for-testing")
   private String memoOnlyForTesting;
	
	@JsonProperty("payee-name-only-for-testing")
   private String payeeNameOnlyForTesting;
	
	@JsonProperty("clear-date")
   private long clearDate;

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getRawMerchant() {
		return rawMerchant;
	}

	public void setRawMerchant(String rawMerchant) {
		this.rawMerchant = rawMerchant;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public boolean isPending() {
		return isPending;
	}

	public void setPending(boolean isPending) {
		this.isPending = isPending;
	}

	

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPreviousTransactionId() {
		return previousTransactionId;
	}

	public void setPreviousTransactionId(String previousTransactionId) {
		this.previousTransactionId = previousTransactionId;
	}

	public String getCategorization() {
		return categorization;
	}

	public void setCategorization(String categorization) {
		this.categorization = categorization;
	}

	public String getMemoOnlyForTesting() {
		return memoOnlyForTesting;
	}

	public void setMemoOnlyForTesting(String memoOnlyForTesting) {
		this.memoOnlyForTesting = memoOnlyForTesting;
	}

	public String getPayeeNameOnlyForTesting() {
		return payeeNameOnlyForTesting;
	}

	public void setPayeeNameOnlyForTesting(String payeeNameOnlyForTesting) {
		this.payeeNameOnlyForTesting = payeeNameOnlyForTesting;
	}

	public long getClearDate() {
		return clearDate;
	}

	public void setClearDate(long clearDate) {
		this.clearDate = clearDate;
	}
  
}
