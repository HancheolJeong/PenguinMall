package hancheol.PenguinMall.service.impl;

import hancheol.PenguinMall.dto.UserDetailDTO;
import hancheol.PenguinMall.entity.User;
import hancheol.PenguinMall.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> tmp_customer = userRepository.findById(username);
        User user = tmp_customer.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        if (user != null)
        {
            return new UserDetailDTO(user);
        }

        return null;

    }
}
