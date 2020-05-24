package com.ananya.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ananya.microservices.limitsservice.bean.LimitsConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigController {
	  @Autowired
	  private Config con;
		@GetMapping("/limits")
		public LimitsConfiguration retrievLimit(){
			return new LimitsConfiguration(1000,1);
			
		}
		@GetMapping("/limits/config")
		public LimitsConfiguration retrievLimitFromConfig(){
			return new LimitsConfiguration(con.getMax(),con.getMin());
			
		}
		
		@GetMapping("/fault-tolerance-example")
		@HystrixCommand(fallbackMethod="fallbackRetieveConfig")
		public LimitsConfiguration retrieveConfig(){
			throw new RuntimeException("Not available");
		}
		public LimitsConfiguration fallbackRetieveConfig(){
			return new LimitsConfiguration(9999,9);
			
		}
}
