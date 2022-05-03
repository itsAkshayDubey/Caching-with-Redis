package com.akshay.demo.cachingdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.akshay.demo.cachingdemo.entity.Invoice;
import com.akshay.demo.cachingdemo.exception.InvoiceNotFoundException;
import com.akshay.demo.cachingdemo.repo.InvoiceRepository;
import com.akshay.demo.cachingdemo.service.intf.InvoiceService;

@Service
public class InvoiceServiceImplementation implements InvoiceService{

	@Autowired
	private InvoiceRepository invoiceRepo;

	@Override
	public Invoice saveInvoice(Invoice inv) {
		return invoiceRepo.save(inv);
	}

	@Override
	@CachePut(value="Invoice", key="#invId")
	public Invoice updateInvoice(Invoice inv, Integer invId) {
		Invoice invoice = invoiceRepo.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
		invoice.setInvoiceAmount(inv.getInvoiceAmount());
		invoice.setInvoiceName(inv.getInvoiceName());
		return invoiceRepo.save(invoice);
	}

	@Override
	@CacheEvict(value="Invoice", key="#invId")
	public void deleteInvoice(Integer invId) {
		Invoice invoice = invoiceRepo.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
		invoiceRepo.delete(invoice);
	}

	@Override
	@Cacheable(value="Invoice", key="#invId")
	public Invoice getOneInvoice(Integer invId) {
		
		return invoiceRepo.findById(invId)
				.orElseThrow(()->new InvoiceNotFoundException("Invoice not found"));
	}

	@Override
	@Cacheable(value="Invoice")
	public List<Invoice> getAllInvoices() {
		return invoiceRepo.findAll();
	}

}
