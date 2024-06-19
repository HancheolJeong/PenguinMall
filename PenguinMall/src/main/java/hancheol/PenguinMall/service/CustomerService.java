package hancheol.PenguinMall.service;


import hancheol.PenguinMall.dto.CustomerDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;
public interface CustomerService {
    public CompletableFuture<CustomerDTO> saveCustomer(CustomerDTO customerDTO);
    public CompletableFuture<Boolean> checkLogin(String id, String pw);
//    CustomerDTO findCustomerById(String id);
//    List<CustomerDTO> findAllCustomers();
//    CustomerDTO updateCustomer(String id, CustomerDTO productDTO);
//    void deleteCustomer(String id);
}
