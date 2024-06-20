package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.User_coupon;

public interface User_couponRepository extends JpaRepository<User_coupon, String>{

    //List<Customer_coupon> findByName(String name);
    //List<Customer_coupon> queryByName(String name);
}
