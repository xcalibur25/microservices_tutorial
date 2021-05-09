package com.yash.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "currency-exchange",url = "localhost:8000")
public interface CurrencyExchangeProxy {
	//we have created Currencyconversion bean matching the reponse of CurrencyExchange
	@GetMapping("/currency-exchage/from/{from}/to/{to}")
	public CurrencyConversion retrieveCurrencyExchangeValue(@PathVariable String from, @PathVariable String to) ;
}
