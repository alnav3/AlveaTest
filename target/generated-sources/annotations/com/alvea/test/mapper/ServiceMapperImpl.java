package com.alvea.test.mapper;

import com.alvea.test.controller.dto.PriceDto;
import com.alvea.test.entity.Brand;
import com.alvea.test.entity.Price;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T15:54:46+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public PriceDto priceToPriceDto(Price price) {
        if ( price == null ) {
            return null;
        }

        PriceDto priceDto = new PriceDto();

        priceDto.setBrandId( priceBrandBrandId( price ) );
        priceDto.setEndDate( price.getEndDate() );
        priceDto.setPrice( price.getPrice() );
        priceDto.setPriceList( price.getPriceList() );
        priceDto.setProductId( price.getProductId() );
        priceDto.setStartDate( price.getStartDate() );

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
