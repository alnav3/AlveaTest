package com.alvea.test.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.alvea.test.controller.dto.PriceDto;
import com.alvea.test.controller.dto.PriceEntryDto;
import com.alvea.test.service.PriceService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PriceService priceService;

    @Test
    public void getPrice_returnPriceDetails() throws Exception {
        // given
        PriceDto priceDto = new PriceDto();
        priceDto.setBrandId(1L);
        priceDto.setProductId(35455L);
        priceDto.setPrice(35.50);

        given(priceService.findPrice(any(Long.class), any(Long.class), any(LocalDateTime.class)))
                .willReturn(Optional.of(priceDto));

        PriceEntryDto entryDto = new PriceEntryDto();
        entryDto.setBrandId(1L);
        entryDto.setProductId(35455L);
        entryDto.setApplicationDate(LocalDateTime.now());

        // when & then
        mockMvc.perform(post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(entryDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(priceDto.getBrandId()))
                .andExpect(jsonPath("$.productId").value(priceDto.getProductId()))
                .andExpect(jsonPath("$.price").value(priceDto.getPrice()));
    }

    @Test
    public void getPrice_returnNoContent() throws Exception {
        // given
        given(priceService.findPrice(any(Long.class), any(Long.class), any(LocalDateTime.class)))
                .willReturn(Optional.empty());

        PriceEntryDto entryDto = new PriceEntryDto();
        entryDto.setBrandId(1L);
        entryDto.setProductId(35455L);
        entryDto.setApplicationDate(LocalDateTime.now());

        // when & then
        mockMvc.perform(post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(entryDto)))
                .andExpect(status().isNoContent());
    }
}

