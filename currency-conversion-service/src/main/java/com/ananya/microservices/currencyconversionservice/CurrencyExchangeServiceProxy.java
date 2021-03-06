package com.ananya.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="currency-conversion-service",url="localhost:8000") //for one instance
//@FeignClient(name="currency-conversion-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-conversion-service")
public interface CurrencyExchangeServiceProxy {
	
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversBean retrieveValue(
			@PathVariable("from") String from,@PathVariable("to") String to);
	

}
