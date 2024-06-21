package hancheol.PenguinMall.service.impl;
import hancheol.PenguinMall.dto.*;
import hancheol.PenguinMall.entity.Product;
import hancheol.PenguinMall.entity.User;
import hancheol.PenguinMall.repository.UserRepository;
import hancheol.PenguinMall.service.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.passwordEncoder = passwordEncoder;
    }

    @Async
    @Override
    public CompletableFuture<UserDTO> saveCustomer(UserDTO userDTO)
    {
        userDTO.setPw(bCryptPasswordEncoder.encode(userDTO.getPw()));
        User user = mapUserDtoToUser(userDTO);
        user = userRepository.save(user);
        userDTO = mapUserToUserDto(user);
        return CompletableFuture.completedFuture(userDTO);
    }


    @Override
    public UserInfoDTO getUserInfoDTO(String id) {
        Optional<User> tmpUser = userRepository.findById(id);
        User user = tmpUser.orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(user.getId());
        dto.setName(user.getName()); // 이름으로 설정
        dto.setPhone_number(user.getPhone_number());
        dto.setEmail(user.getEmail());
        dto.setEmail_sub(user.getEmail_sub());
        dto.setNickname(user.getNickname());
        dto.setRole(user.getRole());
        dto.setDrop_user(user.getDrop_user());

        // 사용자 주소 목록을 DTO로 변환
        List<User_addressDTO> addresses = user.getAddresses().stream()
                .map(adr -> {
                    User_addressDTO aDto = new User_addressDTO();
                    aDto.setId(adr.getId());
                    aDto.setPostal_code(adr.getPostal_code());
                    aDto.setAddress(adr.getAddress());
                    aDto.setAddress_detail(adr.getAddress_detail());
                    aDto.setAddress_alias(adr.getAddress_alias());
                    aDto.setCid(user.getId().toString());  // User의 ID를 CID로 설정
                    return aDto;
                }).collect(Collectors.toList());
        dto.setAddresses(addresses);

        return dto;
    }


    @Async
    @Override
    public CompletableFuture<UserInfoDTO> getUserInfoDTO2(String id) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<User> tmpUser = userRepository.findById(id);
            User user = tmpUser.orElseThrow(() -> new RuntimeException("User not found with id: " + id));

            UserInfoDTO dto = new UserInfoDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setPhone_number(user.getPhone_number());
            dto.setEmail(user.getEmail());
            dto.setEmail_sub(user.getEmail_sub());
            dto.setNickname(user.getNickname());
            dto.setRole(user.getRole());
            dto.setDrop_user(user.getDrop_user());

            List<User_addressDTO> addresses = user.getAddresses().stream()
                    .map(adr -> {
                        User_addressDTO aDto = new User_addressDTO();
                        aDto.setId(adr.getId());
                        aDto.setPostal_code(adr.getPostal_code());
                        aDto.setAddress(adr.getAddress());
                        aDto.setAddress_detail(adr.getAddress_detail());
                        aDto.setAddress_alias(adr.getAddress_alias());
                        aDto.setCid(user.getId().toString());
                        return aDto;
                    }).collect(Collectors.toList());
            dto.setAddresses(addresses);

            return dto;
        });
    }

    @Async
    @Override
    public CompletableFuture<UserInfoDTO> getUserInfoDTO3(String id) {
        User user = (User) userRepository.findById(id).orElse(null);

        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setPhone_number(user.getPhone_number());
        dto.setEmail(user.getEmail());
        dto.setEmail_sub(user.getEmail_sub());
        dto.setNickname(user.getNickname());
        dto.setRole(user.getRole());
        dto.setDrop_user(user.getDrop_user());

        List<User_addressDTO> addresses = user.getAddresses().stream()
                .map(adr -> {
                    User_addressDTO aDto = new User_addressDTO();
                    aDto.setId(adr.getId());
                    aDto.setPostal_code(adr.getPostal_code());
                    aDto.setAddress(adr.getAddress());
                    aDto.setAddress_detail(adr.getAddress_detail());
                    aDto.setAddress_alias(adr.getAddress_alias());
                    aDto.setCid(user.getId().toString());
                    return aDto;
                }).collect(Collectors.toList());
        dto.setAddresses(addresses);

        return CompletableFuture.completedFuture(dto);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        userRepository.deleteById(id);
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
