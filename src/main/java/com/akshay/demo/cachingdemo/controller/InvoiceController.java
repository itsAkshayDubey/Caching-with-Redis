package com.akshay.demo.cachingdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.demo.cachingdemo.entity.Invoice;
import com.akshay.demo.cachingdemo.service.intf.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@PostMapping("/save-inv")
	public Invoice saveInvoice(@RequestBody Invoice invoice) {
		return invoiceService.saveInvoice(invoice);
	}
	
	@GetMapping("all-inv")
	public ResponseEntity<List<Invoice>> getAllInvoices(){
		return ResponseEntity.ok(invoiceService.getAllInvoices());
	}
	
	@GetMapping("/get/{id}")
	public Invoice getInvoice(@PathVariable int id) {
		return invoiceService.getOneInvoice(id);
	}
	
	@PutMapping("/modify/{id}")
	public Invoice modiInvoice(@RequestBody Invoice invoice, @PathVariable int id) {
		return invoiceService.updateInvoice(invoice, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteInvoice(@PathVariable int id) {
		invoiceService.deleteInvoice(id);
		return "Invoice with id "+id+" deleted successfully.";
		
	}
	
	
}
