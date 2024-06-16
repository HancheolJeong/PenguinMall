package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Customer_address;
import java.util.List;
public interface Customer_addressRepository extends JpaRepository<Customer_address, String>{
    //List<Customer_address> findByName(String name);
    //List<Customer_address> queryByName(String name);
}
