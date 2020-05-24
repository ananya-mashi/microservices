package com.ananya.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversBean {
private int id;
private String from;
private String to;
private BigDecimal conversionMultiple;
private BigDecimal q;
private BigDecimal total;
private int port;

public CurrencyConversBean(){
	
}
public CurrencyConversBean(int id, String from, String to, BigDecimal conversionMultiple, BigDecimal q,
		BigDecimal total, int port) {
	super();
	this.id = id;
	this.from = from;
	this.to = to;
	this.conversionMultiple = conversionMultiple;
	this.q = q;
	this.total = total;
	this.port = port;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public void setTo(String to) {
	this.to = to;
}
public BigDecimal getConversionMultiple() {
	return conversionMultiple;
}
public void setConversionMultiple(BigDecimal conversionMultiple) {
	this.conversionMultiple = conversionMultiple;
}
public BigDecimal getQ() {
	return q;
}
public void setQ(BigDecimal q) {
	this.q = q;
}
public BigDecimal getTotal() {
	return total;
}
public void setTotal(BigDecimal total) {
	this.total = total;
}
public int getPort() {
	return port;
}
public void setPort(int port) {
	this.port = port;
}


}
