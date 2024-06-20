package hancheol.PenguinMall.service.impl;

import hancheol.PenguinMall.dto.UserDTO;
import hancheol.PenguinMall.dto.UserDetailDTO;
import hancheol.PenguinMall.entity.User;
import hancheol.PenguinMall.repository.UserRepository;
import hancheol.PenguinMall.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class UserServiceImpl implements UserDetailsService, CustomerService {
    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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

    @Async
    @Override
    public CompletableFuture<UserDTO> saveCustomer(UserDTO userDTO)
    {
//        String encryptedPassword = passwordEncoder.encode(customerDTO.getPw());
//        customerDTO.setPw(encryptedPassword);
        LOGGER.info("Saving customer with ID: {}", userDTO.getId());
        userDTO.setPw(bCryptPasswordEncoder.encode(userDTO.getPw()));
        User user = mapUserDtoToUser(userDTO);
        // 엔티티 저장 id랑 create_dt는 알아서 저장된다. seller_id는 참조키!
        user = userRepository.save(user);
        userDTO = mapUserToUserDto(user);
        return CompletableFuture.completedFuture(userDTO);
    }

    @Override
    public CompletableFuture<UserDTO> checkLogin(String id, String pw) {
        return null;
    }

    private User mapUserDtoToUser(UserDTO dto) {
        User user = new User();
        user.setId(String.valueOf(dto.getId()));
        user.setPw(dto.getPw());
        user.setName(dto.getName());
        user.setPhone_number(dto.getPhone_number());
        user.setEmail(dto.getEmail());
        user.setEmail_sub(dto.getEmail_sub());
        user.setNickname(dto.getNickname());
        user.setRole(dto.getRole());
        user.setDrop_user(dto.getDrop_user());
        return user;
    }

    private UserDTO mapUserToUserDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setPw(user.getPw());
        dto.setName(user.getName());
        dto.setPhone_number(user.getPhone_number());
        dto.setEmail(user.getEmail());
        dto.setEmail_sub(user.getEmail_sub());
        dto.setNickname(user.getNickname());
        dto.setRole(user.getRole());
        dto.setDrop_user(user.getDrop_user());
        return dto;
    }
}
