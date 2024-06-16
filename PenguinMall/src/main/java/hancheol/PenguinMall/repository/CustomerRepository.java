package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Customer;
import java.util.List;
public interface CustomerRepository extends JpaRepository<Customer, String>{
    //List<Customer> findByName(String name);
    //List<Customer> queryByName(String name);
}
