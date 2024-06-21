package hancheol.PenguinMall.service;


import hancheol.PenguinMall.dto.UserDTO;
import hancheol.PenguinMall.dto.UserInfoDTO;

import java.util.concurrent.CompletableFuture;
public interface UserService {
    public CompletableFuture<UserDTO> saveCustomer(UserDTO userDTO);

//    public CompletableFuture<UserInfoDTO> getUserInfoDTO(String id);
public UserInfoDTO getUserInfoDTO(String id);
    public CompletableFuture<UserInfoDTO> getUserInfoDTO2(String id);
    public CompletableFuture<UserInfoDTO> getUserInfoDTO3(String id);

    public void deleteUser(String id);

//    CustomerDTO findCustomerById(String id);
//    List<CustomerDTO> findAllCustomers();
//    CustomerDTO updateCustomer(String id, CustomerDTO productDTO);
//    void deleteCustomer(String id);
}
