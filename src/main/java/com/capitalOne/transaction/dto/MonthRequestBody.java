/**
 * 
 */
package com.capitalOne.transaction.dto;


/**
 * @author aberehamwodajie
 *
 * Mar 4, 2017
 */
public class MonthRequestBody {
	
	private Args args;
	
	private long year;
	private long month;
	
	public Args getArgs() {
		return args;
	}
	public void setArgs(Args args) {
		this.args = args;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public long getMonth() {
		return month;
	}
	public void setMonth(long month) {
		this.month = month;
	}
	
}
