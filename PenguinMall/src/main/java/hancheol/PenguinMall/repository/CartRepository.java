package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Cart;
import java.util.List;
public interface CartRepository extends JpaRepository<Cart, String>{
    //List<Cart> findByName(String name);
    //List<Cart> queryByName(String name);
}
