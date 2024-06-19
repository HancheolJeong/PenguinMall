package hancheol.PenguinMall.service.impl;
import hancheol.PenguinMall.dto.*;
import hancheol.PenguinMall.entity.Customer;
import hancheol.PenguinMall.repository.CustomerRepository;
import hancheol.PenguinMall.service.CustomerService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public CustomerServiceImpl(CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.passwordEncoder = passwordEncoder;
    }

    @Async
    @Override
    public CompletableFuture<CustomerDTO> saveCustomer(CustomerDTO customerDTO)
    {
//        String encryptedPassword = passwordEncoder.encode(customerDTO.getPw());
//        customerDTO.setPw(encryptedPassword);
        LOGGER.info("Saving customer with ID: {}", customerDTO.getId());
        customerDTO.setPw(bCryptPasswordEncoder.encode(customerDTO.getPw()));
        Customer customer = mapCustomerDtoToCustomer(customerDTO);
        // 엔티티 저장 id랑 create_dt는 알아서 저장된다. seller_id는 참조키!
        customer = customerRepository.save(customer);
        customerDTO = mapCustomerToCustomerDto(customer);
        return CompletableFuture.completedFuture(customerDTO);
    }

    @Async
    @Override
    public CompletableFuture<Boolean> checkLogin(String id, String pw) {

//        Boolean isExist = customerRepository.existsById(id);
//        if(isExist)
//        {
//            return false;
//        }

        return CompletableFuture.supplyAsync(() -> {
            Optional<Customer> customerOpt = customerRepository.findById(id);
            if (customerOpt.isPresent()) {
                Customer customer = customerOpt.get();
                if (customer.getPw().equals(pw)) {
                    return true;
                }
            }
            return false;
        });
    }
    private Customer mapCustomerDtoToCustomer(CustomerDTO dto) {
        Customer product = new Customer();
        product.setId(String.valueOf(dto.getId()));
        product.setPw(dto.getPw());
        product.setName(dto.getName());
        product.setPhone_number(dto.getPhone_number());
        product.setEmail(dto.getEmail());
        product.setEmail_sub(dto.getEmail_sub());
        product.setNickname(dto.getNickname());
        product.setGrade(dto.getGrade());
        product.setDrop_user(dto.getDrop_user());
        return product;
    }

    private CustomerDTO mapCustomerToCustomerDto(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setPw(customer.getPw());
        dto.setName(customer.getName());
        dto.setPhone_number(customer.getPhone_number());
        dto.setEmail(customer.getEmail());
        dto.setEmail_sub(customer.getEmail_sub());
        dto.setNickname(customer.getNickname());
        dto.setGrade(customer.getGrade());
        dto.setDrop_user(customer.getDrop_user());
        return dto;
    }
}
