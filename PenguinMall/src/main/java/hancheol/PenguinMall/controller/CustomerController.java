package hancheol.PenguinMall.controller;
import hancheol.PenguinMall.dto.CustomerDTO;
import hancheol.PenguinMall.dto.ProductContentDetailDTO;
import hancheol.PenguinMall.dto.Product_imgDetailDTO;
import hancheol.PenguinMall.service.CustomerService;
import org.springframework.http.ResponseEntity;
import hancheol.PenguinMall.dto.ProductDTO;
import hancheol.PenguinMall.entity.Product;
import hancheol.PenguinMall.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Controller
@ResponseBody
public class CustomerController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @PostMapping("/join")
    public CompletableFuture<ResponseEntity<Boolean>> login(@RequestBody String id, String pw) {
        LOGGER.info("Attempting login for: {}", id);
        return customerService.checkLogin(id, pw)
                .thenApply(success -> {
                    if (success) {
                        return ResponseEntity.ok(true); // Successfully logged in
                    } else {
                        return ResponseEntity.status(401).body(false); // Unauthorized access
                    }
                })
                .exceptionally(e -> {
                    LOGGER.error("Login failed: ", e);
                    return ResponseEntity.status(500).build(); // Internal server error
                });

    }

    @PostMapping("/customer")
    public CompletableFuture<ResponseEntity<CustomerDTO>> saveProduct(@RequestBody CustomerDTO customerDTO) {
        LOGGER.info("Saving new customer: {}", customerDTO);
        return customerService.saveCustomer(customerDTO)
                .thenApply(ResponseEntity::ok)// CompletableFuture의 결과와 ProductDTO 객체가 준비되면 HTTP Status Code 200과 ProductDTO를 가지고 있는 ResponseEntity 객체를 생성한다
                .exceptionally(e -> ResponseEntity.notFound().build()); // 예외가 발생했을 때, HTTP Status Code 404를 반환하는 ResponseEntity 객체를 생성한다. 이는 클라이언트에게 해당 요청이 실패했음을 알립니다.
    }

}
