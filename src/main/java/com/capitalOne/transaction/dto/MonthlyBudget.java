/**
 * 
 */
package com.capitalOne.transaction.dto;

/**
 * @author aberehamwodajie
 *
 * Mar 6, 2017
 */
public class MonthlyBudget {
	
	private long spent;
	private long income;
	
	public MonthlyBudget(long spent, long income) {
		super();
		this.spent = spent;
		this.income = income;
	}
	
	public long getSpent() {
		return spent;
	}
	public void setSpent(long spent) {
		this.spent = spent;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
}
