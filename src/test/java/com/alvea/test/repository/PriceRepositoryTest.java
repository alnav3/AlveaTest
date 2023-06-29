package com.alvea.test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.alvea.test.entity.Price;

@DataJpaTest
public class PriceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PriceRepository priceRepository;

    @Test
    public void testFindTopByBrandIdAndProductIdAndDate_case1() {
        // Given
        LocalDateTime requestDateTime = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

        // When
        Optional<Price> result = priceRepository.findTopByBrandIdAndProductIdAndDate(1L, 35455L, requestDateTime);

        // Then
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getPriceList()).isEqualTo(1);
        assertThat(result.get().getPrice()).isEqualTo(35.5);
    }

    @Test
    public void testFindTopByBrandIdAndProductIdAndDate_case2() {
        // Given
        LocalDateTime requestDateTime = LocalDateTime.of(2020, 6, 14, 16, 0, 0);

        // When
        Optional<Price> result = priceRepository.findTopByBrandIdAndProductIdAndDate(1L, 35455L, requestDateTime);

        // Then
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getPriceList()).isEqualTo(2);
        assertThat(result.get().getPrice()).isEqualTo(25.45);
    }

    @Test
    public void testFindTopByBrandIdAndProductIdAndDate_case3() {
        // Given
        LocalDateTime requestDateTime = LocalDateTime.of(2020, 6, 14, 21, 0, 0);

        // When
        Optional<Price> result = priceRepository.findTopByBrandIdAndProductIdAndDate(1L, 35455L, requestDateTime);

        // Then
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getPriceList()).isEqualTo(1);
        assertThat(result.get().getPrice()).isEqualTo(35.50);
    }

    @Test
    public void testFindTopByBrandIdAndProductIdAndDate_case4() {
        // Given
        LocalDateTime requestDateTime = LocalDateTime.of(2020, 6, 15, 10, 0, 0);

        // When
        Optional<Price> result = priceRepository.findTopByBrandIdAndProductIdAndDate(1L, 35455L, requestDateTime);

        // Then
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getPriceList()).isEqualTo(3);
        assertThat(result.get().getPrice()).isEqualTo(30.50);
    }

    @Test
    public void testFindTopByBrandIdAndProductIdAndDate_case5() {
        // Given
        LocalDateTime requestDateTime = LocalDateTime.of(2020, 6, 16, 21, 0, 0);

        // When
        Optional<Price> result = priceRepository.findTopByBrandIdAndProductIdAndDate(1L, 35455L, requestDateTime);

        // Then
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getPriceList()).isEqualTo(4);
        assertThat(result.get().getPrice()).isEqualTo(38.95);
    }

}

