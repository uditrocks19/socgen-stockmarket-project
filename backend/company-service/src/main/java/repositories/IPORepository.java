package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.IPO;

public interface IPORepository extends JpaRepository<IPO,Integer> {

	IPO findByCompanyId(int companyId);
	List<IPO> findAllByOrderByDateTimeAsc();
	Optional<IPO> findById(int id);
	
}
