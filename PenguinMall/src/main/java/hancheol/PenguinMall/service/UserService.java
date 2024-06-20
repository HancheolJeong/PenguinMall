package hancheol.PenguinMall.service;


import hancheol.PenguinMall.dto.UserDTO;

import java.util.concurrent.CompletableFuture;
public interface UserService {
    public CompletableFuture<UserDTO> saveCustomer(UserDTO userDTO);
    public CompletableFuture<UserDTO> checkLogin(String id, String pw);
//    CustomerDTO findCustomerById(String id);
//    List<CustomerDTO> findAllCustomers();
//    CustomerDTO updateCustomer(String id, CustomerDTO productDTO);
//    void deleteCustomer(String id);
}
