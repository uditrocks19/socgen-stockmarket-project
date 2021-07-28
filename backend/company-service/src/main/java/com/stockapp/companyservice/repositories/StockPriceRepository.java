package com.stockapp.companyservice.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stockapp.companyservice.entities.StockPrice;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Integer> {


    List<StockPrice> findByCompanyIdAndStockExchangeId(int companyId, int stockExchangeId);

    List<StockPrice> findByCompanyId(int companyId);

    List<StockPrice> findByStockExchangeId(int exchangeId);



}