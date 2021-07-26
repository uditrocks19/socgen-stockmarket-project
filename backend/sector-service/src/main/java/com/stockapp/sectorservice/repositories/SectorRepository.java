package com.stockapp.sectorservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockapp.sectorservice.entity.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Integer> {

    Sector findByName(String sectorName);
}