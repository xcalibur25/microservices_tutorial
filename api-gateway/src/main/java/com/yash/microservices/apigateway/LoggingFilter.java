package com.yash.microservices.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

	private Logger logger=LoggerFactory.getLogger(LoggingFilter.class);
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		//{} will be replaced by the value exchange.getRequest().getPath()
		logger.info("Path of request received ->{} ",exchange.getRequest().getPath());
		//we are logging and letting the chain continue.
		return chain.filter(exchange);
	}

}
