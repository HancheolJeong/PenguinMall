package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Product;
import java.util.List;

/**
 * 
 */
public interface ProductRepository extends JpaRepository<Product, String>{
    // 조회
    Product findById(Integer id);
    List<Product> findByName(String name);
    List<Product> queryByName(String name);

}
