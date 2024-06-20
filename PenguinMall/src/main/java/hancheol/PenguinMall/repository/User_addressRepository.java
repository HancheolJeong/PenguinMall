package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.User_address;

public interface Customer_addressRepository extends JpaRepository<User_address, String>{
    //List<Customer_address> findByName(String name);
    //List<Customer_address> queryByName(String name);
}
