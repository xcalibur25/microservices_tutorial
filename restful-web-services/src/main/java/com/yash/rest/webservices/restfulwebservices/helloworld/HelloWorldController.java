package com.yash.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource;  

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	// automatically getting converted into JSON
	/*
	 * The reqquest goes to dispatcher servlet .The dispatcher servlet finds the
	 * hello world controller and the specific method hello world bean.It\ calls
	 * it,gets the bean,invokes the conversion on it, converts it into json and
	 * returns the response back.
	 */
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World,%s", name));
	}

	// Based on Accept-Language header you decide the Locale
	/*
	 * @GetMapping(path = "/hello-world-internalized") public String
	 * helloWorldInternalized(@RequestHeader(name = "Accept-Language",required =
	 * false) Locale locale) { return
	 * messageSource.getMessage("good.morning.message",null, locale); }
	 */

	
	//there is no need to everytime get the locale from the request header.we can get it from LocalContextHolder
	//public String helloWorldInternalized(@RequestHeader(name = "Accept-Language",required = false) Locale locale) {
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
