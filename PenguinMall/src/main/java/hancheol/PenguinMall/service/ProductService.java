package hancheol.PenguinMall.service;

import hancheol.PenguinMall.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);
    ProductDTO findProductById(String id);
    List<ProductDTO> findAllProducts();
    ProductDTO updateProduct(String id, ProductDTO productDTO);
    void deleteProduct(String id);
}
