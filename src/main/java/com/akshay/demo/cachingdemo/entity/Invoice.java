package com.akshay.demo.cachingdemo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Invoice implements Serializable{

	private static final long serialVersionUID = -4439114469417994311L;

	@Id
	@GeneratedValue
	private Integer invoiceId;
	private String invoiceName;
	private Double invoiceAmount;
	
	Invoice(){}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public Double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Invoice(Integer invoiceId, String invoiceName, Double invoiceAmount) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceName = invoiceName;
		this.invoiceAmount = invoiceAmount;
	}

}
