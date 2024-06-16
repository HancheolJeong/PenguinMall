package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Seller;
import java.util.List;
public interface SellerRepository extends JpaRepository<Seller, String>{
    //List<Seller> findByName(String name);
    //List<Seller> queryByName(String name);
}
