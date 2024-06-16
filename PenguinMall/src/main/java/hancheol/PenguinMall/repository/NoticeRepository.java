package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Notice;
import java.util.List;
public interface NoticeRepository extends JpaRepository<Notice, String>{
    //List<Notice> findByName(String name);
    //List<Notice> queryByName(String name);
}
