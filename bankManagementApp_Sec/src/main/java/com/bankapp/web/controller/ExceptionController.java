package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.bankapp.web.exceptions.AccountNotFoundException;
import com.bankapp.web.exceptions.CustomerNotFoundException;
import com.bankapp.web.exceptions.NotSufficientBalanceException;

@ControllerAdvice
public class ExceptionController {

	private Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	@ExceptionHandler(AccountNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest request, Exception e) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		
		System.out.println(e.getMessage());
		
		mv.addObject("message", e.getMessage());
		
		return mv;
		
	}

	@ExceptionHandler(NotSufficientBalanceException.class)
	public ModelAndView handleNotSufficientBalance(HttpServletRequest request, Exception e) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		
		System.out.println(e.getMessage());
		
		mv.addObject("message", e.getMessage());
		
		return mv;
		
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ModelAndView handleCustomerNotFound(HttpServletRequest request, Exception e) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		
		System.out.println(e.getMessage());
		
		mv.addObject("message", e.getMessage());
		
		return mv;
		
	}

	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleNumberFormatError(HttpServletRequest request, Exception e) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		
		System.out.println(e.getMessage());
		
		mv.addObject("message", e.getMessage());
		
		return mv;
	
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleError404(HttpServletRequest request, Exception e) {
		
		logger.info("Request: " + request.getRequestURL() + " raised " + e);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("404");
		
		mv.addObject("message", "The Resource you are looking for is not found!");
		
		return mv;

	}

	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handleDataAccessException() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dberror");
		
		mv.addObject("message", "pls try after some time");
		
		return mv;
	
	}

}
