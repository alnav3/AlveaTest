package com.alvea.test.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.alvea.test.controller.dto.PriceDto;


public interface PriceService {

	Optional<PriceDto> findPrice(Long brandId, Long productId, LocalDateTime applicationDate);


}
