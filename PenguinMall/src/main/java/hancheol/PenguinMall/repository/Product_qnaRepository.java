package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Product_qna;
import java.util.List;
public interface Product_qnaRepository extends JpaRepository<Product_qna, String>{
    //List<Product_qna> findByName(String name);
    //List<Product_qna> queryByName(String name);
}
