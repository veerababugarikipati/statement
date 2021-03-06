/**
 * 
 */
package com.nagarro.statement.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author veerababu
 *
 */
@ControllerAdvice
public class GenericExceptionHandler extends RuntimeException  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8220232625441979828L;
	Logger logger = LoggerFactory.getLogger(GenericExceptionHandler.class);


	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex)
	{
		logger.error("Exception raised",ex);
	    
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("error");
	    modelAndView.addObject("message", ExceptionUtils.getRootCause(ex));
	    return modelAndView;
	}
   

}
