package com.alvea.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BRAND")
public class Brand {

	@Id
	private Long brandId;

	private String name;

	public Long getBrandId() {
		return brandId;
	}

	public String getName() {
		return name;
	}
}
