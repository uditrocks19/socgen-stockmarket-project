package repostory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entitiy.Address;
@Repository

public interface AddressRepository  extends CrudRepository<Address,Integer>{

}
