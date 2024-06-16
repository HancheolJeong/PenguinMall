package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Review_img;
import java.util.List;
public interface Review_imgRepository extends JpaRepository<Review_img, String>{
    //List<Review_img> findByName(String name);
    //List<Review_img> queryByName(String name);
}
