package com.ananya.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{q}")
	public CurrencyConversBean convert(@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal q){
		
		Map<String,String> uriVariables=new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		ResponseEntity<CurrencyConversBean> responseEntity=new RestTemplate()
				.getForEntity("http://localhost:8000/currency-exchange/from/{from}"
				+ "/to/{to}",CurrencyConversBean.class,uriVariables);
		
		CurrencyConversBean res=responseEntity.getBody();
		
				return new CurrencyConversBean(res.getId(),from,to,res.getConversionMultiple()
						,q,q.multiply(res.getConversionMultiple()),res.getPort());
				}
	

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{q}")
	public CurrencyConversBean convertFeign(@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal q){
		
	
		CurrencyConversBean res=proxy.retrieveValue(from, to);
		
				logger.info("{}",res);
		
				return new CurrencyConversBean(res.getId(),from,to,res.getConversionMultiple()
						,q,q.multiply(res.getConversionMultiple()), res.getPort());
				}
}
