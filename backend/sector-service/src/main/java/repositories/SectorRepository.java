package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Sector;

public interface SectorRepository extends JpaRepository<Sector, Integer> {

    Sector findByName(String sectorName);
}