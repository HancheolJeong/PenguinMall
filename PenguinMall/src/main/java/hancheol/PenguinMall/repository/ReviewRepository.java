package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Review;
import java.util.List;
public interface ReviewRepository extends JpaRepository<Review, String>{
    //List<Review> findByName(String name);
    //List<Review> queryByName(String name);
}
