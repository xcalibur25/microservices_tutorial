package com.yash.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger=LoggerFactory.getLogger(CircuitBreakerController.class);
	@GetMapping("/sample-api")
	//@Retry(name = "sample-api",fallbackMethod = "hardcodedResponse") //retry 3 times.
	@CircuitBreaker(name = "default",fallbackMethod = "hardcodedResponse")
	@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	//10s->10000 calls to api
	public String sampleApi() {
		logger.info("Sample Api Called Received");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/somedummy-url", String.class);
		return forEntity.getBody();
	}
	
	//we need to add a parameter of type Throwable
	//we can have different fallback method for different kinds of exception
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}

}
