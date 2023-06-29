package com.alvea.test.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.alvea.test.controller.dto.PriceDto;
import com.alvea.test.jpa.entity.Price;
import com.alvea.test.jpa.repository.PriceRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceServiceTest {

    @Autowired
    private PriceService priceService;

    @MockBean
    private PriceRepository priceRepository;
    
    @Test
    public void testFindPrice_ExistingPrice() {
    	
        // Test case for an existing price
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applicationDate = LocalDateTime.of(2023, 6, 28, 10, 0, 0);
        
        Price price = new Price();
        price.setProductId(productId);
        
        Mockito.when(priceRepository.findTopByBrandIdAndProductIdAndDate(brandId, productId, applicationDate))
        .thenReturn(Optional.of(price));
        
        
        Optional<PriceDto> result = priceService.findPrice(brandId, productId, applicationDate);

        assertTrue(result.isPresent());
        assertTrue(result.get().getProductId().equals(35455L));
    }

    @Test
    public void testFindPrice_NoPrice() {
        // Test case for no matching price
        Long brandId = 1L;
        Long productId = 999L; // Assuming this product ID does not exist
        LocalDateTime applicationDate = LocalDateTime.of(2023, 6, 28, 10, 0, 0);

        Optional<PriceDto> result = priceService.findPrice(brandId, productId, applicationDate);

        assertFalse(result.isPresent());
    }



}

