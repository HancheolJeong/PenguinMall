package hancheol.PenguinMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hancheol.PenguinMall.entity.User;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, String>{
    Optional<User> findById(String id);
    //List<Customer> queryByName(String name);
}
