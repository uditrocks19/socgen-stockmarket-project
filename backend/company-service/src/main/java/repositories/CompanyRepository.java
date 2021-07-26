package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

	List<Company>findByNameContainingIgnoreCase(String pattern);
	 @Query(value="select * from company where id in (select company_id from stock where exchange_id= :exchangeId);", nativeQuery=true)
	    List<Company> findCompanyByExchange(@Param("exchangeId") int exchangeId);
}
