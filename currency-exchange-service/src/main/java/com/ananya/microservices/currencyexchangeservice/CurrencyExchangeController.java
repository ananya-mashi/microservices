package com.ananya.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/anan")
	public List<ExchangeValue> retriee(){
		List<ExchangeValue> exchValue	=repository.findAll();
		return exchValue;
	}
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
		public ExchangeValue retrieveValue(
				@PathVariable String from,@PathVariable String to){
		
		//ExchangeValue exchValue=new ExchangeValue(from,to,1000L,BigDecimal.valueOf(72));
		ExchangeValue exchValue	=repository.findByFromAndTo(from,to);
		exchValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		logger.info("{}",exchValue);
		return exchValue;
		}

}
