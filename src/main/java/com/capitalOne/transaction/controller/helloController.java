/**
 * 
 */
package com.capitalOne.transaction.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aberehamwodajie
 *
 * Mar 5, 2017
 */
@RestController
@RequestMapping("/capital")
public class helloController {
	

	@RequestMapping("/hello")
	public @ResponseBody  String home() {
		return "Hello World!";
	}


}
