package com.alvea.test.jpa.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alvea.test.jpa.entity.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

	@Query("SELECT p FROM Price p WHERE p.brand.id=:brandId AND p.productId = :productId "
			+ "AND :date BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC LIMIT 1")
	Optional<Price> findTopByBrandIdAndProductIdAndDate(@Param("brandId") Long brandId,
			@Param("productId") Long productId, @Param("date") LocalDateTime date);


}
