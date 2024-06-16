package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.Wishlist;
import java.util.List;
public interface WishlistRepository extends JpaRepository<Wishlist, String>{
    //List<Wishlist> findByName(String name);
    //List<Wishlist> queryByName(String name);
}
