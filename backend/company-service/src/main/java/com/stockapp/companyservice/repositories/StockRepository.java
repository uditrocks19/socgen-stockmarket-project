package com.stockapp.companyservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockapp.companyservice.entities.Stock;



@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
}