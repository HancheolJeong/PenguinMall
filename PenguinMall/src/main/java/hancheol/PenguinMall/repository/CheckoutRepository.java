package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Checkout;
import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout, String>{

    //List<Checkout> findByName(String name);
    //List<Checkout> queryByName(String name);
}
