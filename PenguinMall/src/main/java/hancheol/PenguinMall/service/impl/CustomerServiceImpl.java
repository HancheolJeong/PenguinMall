package hancheol.PenguinMall.service.impl;
import hancheol.PenguinMall.dto.*;
import hancheol.PenguinMall.entity.User;
import hancheol.PenguinMall.repository.UserRepository;
import hancheol.PenguinMall.service.CustomerService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public CustomerServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.passwordEncoder = passwordEncoder;
    }

    @Async
    @Override
    public CompletableFuture<UserDTO> saveCustomer(UserDTO userDTO)
    {
//        String encryptedPassword = passwordEncoder.encode(customerDTO.getPw());
//        customerDTO.setPw(encryptedPassword);
        LOGGER.info("Saving customer with ID: {}", userDTO.getId());
        userDTO.setPw(bCryptPasswordEncoder.encode(userDTO.getPw()));
        User user = mapCustomerDtoToCustomer(userDTO);
        // 엔티티 저장 id랑 create_dt는 알아서 저장된다. seller_id는 참조키!
        user = userRepository.save(user);
        userDTO = mapCustomerToCustomerDto(user);
        return CompletableFuture.completedFuture(userDTO);
    }

    @Async
    @Override
    public CompletableFuture<UserDTO> checkLogin(String id, String pw) {

        return CompletableFuture.supplyAsync(() -> {
            Optional<User> customerOpt = userRepository.findById(id);
            if (customerOpt.isPresent()) {
                User user = customerOpt.get();
                // 비밀번호 검증은 입력된 평문 비밀번호와 저장된 해시된 비밀번호를 비교
                if (bCryptPasswordEncoder.matches(pw, user.getPw())) {
                    // 비밀번호가 일치하면 CustomerDTO 반환
                    return mapCustomerToCustomerDto(user);
                }
            }
            // 사용자가 없거나 비밀번호가 일치하지 않으면 null 반환
            return null;
        });
    }
    private User mapCustomerDtoToCustomer(UserDTO dto) {
        User product = new User();
        product.setId(String.valueOf(dto.getId()));
        product.setPw(dto.getPw());
        product.setName(dto.getName());
        product.setPhone_number(dto.getPhone_number());
        product.setEmail(dto.getEmail());
        product.setEmail_sub(dto.getEmail_sub());
        product.setNickname(dto.getNickname());
        product.setRole(dto.getRole());
        product.setDrop_user(dto.getDrop_user());
        return product;
    }

    private UserDTO mapCustomerToCustomerDto(User user) {
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
