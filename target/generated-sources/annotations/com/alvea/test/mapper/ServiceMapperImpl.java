package com.alvea.test.mapper;

import com.alvea.test.controller.dto.PriceDto;
import com.alvea.test.jpa.entity.Brand;
import com.alvea.test.jpa.entity.Price;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T18:55:58+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230622-1425, environment: Java 17.0.7 (Eclipse Adoptium)"
)
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public PriceDto priceToPriceDto(Price price) {
        if ( price == null ) {
            return null;
        }

        PriceDto priceDto = new PriceDto();

        priceDto.setBrandId( priceBrandBrandId( price ) );
        priceDto.setProductId( price.getProductId() );
        priceDto.setPriceList( price.getPriceList() );
        priceDto.setStartDate( price.getStartDate() );
        priceDto.setEndDate( price.getEndDate() );
        priceDto.setPrice( price.getPrice() );

        return priceDto;
    }

    private Long priceBrandBrandId(Price price) {
        if ( price == null ) {
            return null;
        }
        Brand brand = price.getBrand();
        if ( brand == null ) {
            return null;
        }
        Long brandId = brand.getBrandId();
        if ( brandId == null ) {
            return null;
        }
        return brandId;
    }
}
