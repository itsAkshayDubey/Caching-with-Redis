package com.akshay.demo.cachingdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.demo.cachingdemo.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

}
