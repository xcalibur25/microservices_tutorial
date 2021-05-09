package com.yash.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	//spring jpa will query the data byFromAndTo and get the CurrencyExchange.
	CurrencyExchange findByFromAndTo(String from,String to);
	
}
