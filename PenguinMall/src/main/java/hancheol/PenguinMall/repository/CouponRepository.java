package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Coupon;
import java.util.List;
public interface CouponRepository extends JpaRepository<Coupon, String>{
    //List<Coupon> findByName(String name);
    //List<Coupon> queryByName(String name);
}
