package com.stockapp.companyservice.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockapp.companyservice.entities.Company;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    List<Company> findByNameContainingIgnoreCase(String pattern);


    List<Company>  findByStockExchangeNamesContainingIgnoreCase(String title);


    Optional<Company> findByCompanyCode(String companyCode);
}