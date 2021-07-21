package repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entitiy.Address;
@Repository

public interface AddressRepository  extends JpaRepository<Address,Integer>{

}
