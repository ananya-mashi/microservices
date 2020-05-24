package com.ananya.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.PathVariable;
@Entity
public class ExchangeValue {
	
@Column(name="c_from")
private String from;
@Column(name="c_to")
private String to;
 
@Id
private int id;
@Column(name="portt")
private Integer port;

public void setPort(Integer port) {
	this.port = port;
}
private BigDecimal conversionMultiple;
public ExchangeValue(){
	
}
public ExchangeValue(String from, String to, int id, BigDecimal conversionMultiple) {
	super();
	this.from = from;
	this.to = to;
	this.id = id;
	this.conversionMultiple = conversionMultiple;
}
public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
}
public String getTo() {
	return to;
}
public long setTo(String to) {
 	return id;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public Integer getPort() {
	return port;
}
public BigDecimal getConversionMultiple() {
	return conversionMultiple;
}
public void setConversionMultiple(BigDecimal conversionMultiple) {
	this.conversionMultiple = conversionMultiple;
}


}
