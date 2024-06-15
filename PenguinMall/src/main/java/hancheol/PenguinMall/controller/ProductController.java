package hancheol.PenguinMall.controller;
import org.springframework.http.ResponseEntity;
import hancheol.PenguinMall.dto.ProductDTO;
import hancheol.PenguinMall.entity.Product;
import hancheol.PenguinMall.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @PostMapping("product")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        LOGGER.info("Saving new product: {}", productDTO);
        return productService.saveProduct(productDTO);
    }

    @GetMapping("product")
    public ResponseEntity<List<ProductDTO>> findAllProducts() {
        LOGGER.info("Fetching all products");
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("product/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable String id) {
        try {
            LOGGER.info("Fetching product with ID: {}", id);
            return ResponseEntity.ok(productService.findProductById(id));
        } catch (RuntimeException e) {
            LOGGER.error("Error fetching product with ID: {}", id, e);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable String id, @RequestBody ProductDTO productDTO) {
        try {
            LOGGER.info("Updating product with ID: {}", id);
            return ResponseEntity.ok(productService.updateProduct(id, productDTO));
        } catch (RuntimeException e) {
            LOGGER.error("Error updating product with ID: {}", id, e);
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        try {
            LOGGER.info("Deleting product with ID: {}", id);
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            LOGGER.error("Error deleting product with ID: {}", id, e);
            return ResponseEntity.notFound().build();
        }
    }
}
