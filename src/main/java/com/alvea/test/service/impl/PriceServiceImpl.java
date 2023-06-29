package com.alvea.test.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvea.test.controller.dto.PriceDto;
import com.alvea.test.jpa.entity.Price;
import com.alvea.test.jpa.repository.PriceRepository;
import com.alvea.test.mapper.ServiceMapper;
import com.alvea.test.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;

	private ServiceMapper serviceMapper = Mappers.getMapper(ServiceMapper.class);

	@Override
	public Optional<PriceDto> findPrice(Long brandId, Long productId, LocalDateTime applicationDate) {
		Optional<Price> price = priceRepository.findTopByBrandIdAndProductIdAndDate(brandId, productId,
				applicationDate);
		return price.isPresent()? Optional.of(serviceMapper.priceToPriceDto(price.get())):Optional.empty();
	}
}
