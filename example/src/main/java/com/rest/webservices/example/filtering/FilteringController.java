package com.rest.webservices.example.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	/*@GetMapping("/filter-static")
	public newBean retrieve(){
		return new newBean("value1","value2","value3");
	}*/
	
	
	//f1 and f2
	@GetMapping("/filterf1f2")
	public MappingJacksonValue retrieveList(){
		newBean nb=new newBean("value1","value2","value3");
	
		FilterProvider filters =new SimpleFilterProvider().addFilter("newBeanFilter",
				SimpleBeanPropertyFilter.filterOutAllExcept("f1","f2"));
		MappingJacksonValue map=new MappingJacksonValue(nb);
		map.setFilters(filters);
		return map;
	}
	@GetMapping("/filterf2f3")
	public MappingJacksonValue retrieveList2(){
	newBean nb=new newBean("value1","value2","value3");
	
		FilterProvider filters =new SimpleFilterProvider().addFilter("newBeanFilter"
				,SimpleBeanPropertyFilter.filterOutAllExcept("f2","f3"));
		MappingJacksonValue map=new MappingJacksonValue(nb);
		map.setFilters(filters);
		return map;
	}

}
