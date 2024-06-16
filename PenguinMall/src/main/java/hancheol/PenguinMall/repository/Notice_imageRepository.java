package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Notice_image;
import java.util.List;
public interface Notice_imageRepository extends JpaRepository<Notice_image, String>{
    //List<Notice_image> findByName(String name);
    //List<Notice_image> queryByName(String name);
}
