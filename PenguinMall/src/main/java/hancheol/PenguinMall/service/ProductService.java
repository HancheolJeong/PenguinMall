package hancheol.PenguinMall.service;

import hancheol.PenguinMall.dto.ProductDTO;
import hancheol.PenguinMall.dto.Product_imgDetailDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ProductService {
    public CompletableFuture<ProductDTO> saveProduct(ProductDTO productDTO);
    ProductDTO findProductById(String id);
    List<ProductDTO> findAllProducts();
    ProductDTO updateProduct(String id, ProductDTO productDTO);
    void deleteProduct(String id);

    Product_imgDetailDTO getProductImageDetails(Integer productId);
}
