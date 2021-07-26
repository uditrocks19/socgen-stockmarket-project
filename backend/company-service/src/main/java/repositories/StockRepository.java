package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {

}
