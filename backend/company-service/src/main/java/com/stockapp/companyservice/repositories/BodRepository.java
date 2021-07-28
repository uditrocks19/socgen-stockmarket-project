package com.stockapp.companyservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockapp.companyservice.entities.BoardOfDirectors;

import java.util.Optional;

@Repository
public interface BodRepository extends JpaRepository<BoardOfDirectors,Integer> {
    Optional<BoardOfDirectors> findByName(String bod);
}