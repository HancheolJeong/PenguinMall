package hancheol.PenguinMall.service.impl;

import hancheol.PenguinMall.dto.ProductDTO;
import hancheol.PenguinMall.dto.UserDetailDTO;
import hancheol.PenguinMall.entity.Product;
import hancheol.PenguinMall.entity.User;
import hancheol.PenguinMall.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    public UserDetailService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    /**
     * 로그인 기능을 제공하는 함수
     */
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
