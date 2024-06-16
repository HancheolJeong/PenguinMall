package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Product_img;
import java.util.List;
public interface Product_imgRepository extends JpaRepository<Product_img, String>{
    //List<Product_img> findByName(String name);
    //List<Product_img> queryByName(String name);
}
