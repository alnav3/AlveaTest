package com.alvea.test.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "PRICE")
public class Price {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    
    private LocalDateTime startDate;
    
    private LocalDateTime endDate;
    
    private Integer priceList;
    
    private Long productId;
    
    private Integer priority;
    
    private double price;
    
    private String currency;

	public Long getId() {
		return id;
	}

	public Brand getBrand() {
		return brand;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}


	public LocalDateTime getEndDate() {
		return endDate;
	}


	public Integer getPriceList() {
		return priceList;
	}


	public Integer getPriority() {
		return priority;
	}


	public double getPrice() {
		return price;
	}


	public String getCurrency() {
		return currency;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}


}

