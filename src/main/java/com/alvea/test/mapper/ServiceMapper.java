package com.alvea.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alvea.test.controller.dto.PriceDto;
import com.alvea.test.jpa.entity.Price;


@Mapper
public interface ServiceMapper {

	@Mapping(source="brand.brandId",target="brandId")
	PriceDto priceToPriceDto(Price price);

}
