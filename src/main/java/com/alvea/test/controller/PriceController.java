package com.alvea.test.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alvea.test.controller.dto.PriceDto;
import com.alvea.test.controller.dto.PriceEntryDto;
import com.alvea.test.service.PriceService;


@RestController
public class PriceController {

	@Autowired
	private PriceService priceService;

	@PostMapping("/price")
	public @ResponseBody ResponseEntity<PriceDto> getPrice(@RequestBody PriceEntryDto entry) {
		Optional<PriceDto> price = priceService.findPrice(entry.getBrandId(), entry.getProductId(), entry.getApplicationDate());
		return price.isPresent() ? ResponseEntity.ok(price.get()) : ResponseEntity.noContent().build();
	}

}
