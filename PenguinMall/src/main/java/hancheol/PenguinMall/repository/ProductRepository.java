package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Product;
import java.util.List;

/**
 * 
 */
public interface ProductRepository extends JpaRepository<Product, String>{ // 두번째인자는 보통 entity의 키로 한다고 하네요
    // 조회
    Product findById(Integer id);
    List<Product> findByName(String name);
    List<Product> queryByName(String name);

}
