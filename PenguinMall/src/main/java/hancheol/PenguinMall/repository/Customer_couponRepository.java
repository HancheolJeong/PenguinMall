package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Customer_coupon;
import java.util.List;
public interface Customer_couponRepository extends JpaRepository<Customer_coupon, String>{

    //List<Customer_coupon> findByName(String name);
    //List<Customer_coupon> queryByName(String name);
}
