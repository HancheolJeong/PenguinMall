package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Customer;
import java.util.List;
import java.util.Optional;
public interface CustomerRepository extends JpaRepository<Customer, String>{
    Optional<Customer> findById(String id);
    //List<Customer> queryByName(String name);
}
