package hancheol.PenguinMall.controller;
import hancheol.PenguinMall.dto.ProductDTO;
import hancheol.PenguinMall.dto.UserDTO;
import hancheol.PenguinMall.dto.UserInfoDTO;
import hancheol.PenguinMall.service.UserService;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@ResponseBody
public class UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/register")
    public CompletableFuture<ResponseEntity<UserDTO>> saveUser(@RequestBody UserDTO userDTO) {
        LOGGER.info("Saving new User: {}", userDTO);
        return userService.saveCustomer(userDTO)
                .thenApply(ResponseEntity::ok)// CompletableFuture의 결과와 ProductDTO 객체가 준비되면 HTTP Status Code 200과 ProductDTO를 가지고 있는 ResponseEntity 객체를 생성한다
                .exceptionally(e -> ResponseEntity.notFound().build()); // 예외가 발생했을 때, HTTP Status Code 404를 반환하는 ResponseEntity 객체를 생성한다. 이는 클라이언트에게 해당 요청이 실패했음을 알립니다.
    }

    @GetMapping("/user3")
    public CompletableFuture<ResponseEntity<UserInfoDTO>> loadUser2() {
//        try {
//            String username = SecurityContextHolder.getContext().getAuthentication().getName();
//            LOGGER.info("Loading User: {}", username);
//            // 비동기 방식으로 UserInfoDTO를 조회하고 결과를 ResponseEntity로 감싸서 반환합니다.
//            return userService.getUserInfoDTO2(username)
//                    .thenApply(ResponseEntity::ok)  // 성공적으로 DTO를 받아왔을 때 HTTP 200 상태 코드와 함께 반환
//                    .exceptionally(ex -> {
//                        LOGGER.error("Error Loading User: {}", ex.getMessage());
//                        return ResponseEntity.internalServerError().build();  // 예외 발생 시 HTTP 500 상태 코드 반환
//                    });
//        } catch (RuntimeException e) {
//            LOGGER.error("Error Loading User", e);
//            // CompletableFuture를 즉시 에러 상태로 반환합니다.
//            return CompletableFuture.completedFuture(ResponseEntity.internalServerError().build());
//        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        LOGGER.info("Loading User: {}", username);
        return userService.getUserInfoDTO3(username)
                .thenApply(ResponseEntity::ok)// CompletableFuture의 결과와 ProductDTO 객체가 준비되면 HTTP Status Code 200과 ProductDTO를 가지고 있는 ResponseEntity 객체를 생성한다
                .exceptionally(e -> ResponseEntity.notFound().build()); // 예외가 발생했을 때, HTTP Status Code 404를 반환하는 ResponseEntity 객체를 생성한다. 이는 클라이언트에게 해당 요청이 실패했음을 알립니다.
    }

    /*
    * 사용자 정보를 시큐리티에서 가져옵니다.
     */
    @GetMapping("/user")
    public ResponseEntity<UserInfoDTO> loadUser() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            LOGGER.info("Loading User: {}", username);
            UserInfoDTO userInfo = userService.getUserInfoDTO(username);
            return ResponseEntity.ok(userInfo);
        } catch (RuntimeException e) {
            LOGGER.error("Error Loading User", e);
            return ResponseEntity.status(500).build();
        }
    }

}
