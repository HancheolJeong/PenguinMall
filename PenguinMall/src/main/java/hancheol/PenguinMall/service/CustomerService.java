package hancheol.PenguinMall.service;


import hancheol.PenguinMall.dto.CustomerDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;
public interface CustomerService {
    public CompletableFuture<CustomerDTO> saveProduct(CustomerDTO productDTO);
    CustomerDTO findProductById(String id);
    List<CustomerDTO> findAllProducts();
    CustomerDTO updateProduct(String id, CustomerDTO productDTO);
    void deleteProduct(String id);
}
