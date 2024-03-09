package hancheol.PenguinMall.controller;

import hancheol.PenguinMall.dto.ProductDTO;
import hancheol.PenguinMall.entity.Product;
import hancheol.PenguinMall.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        LOGGER.info("Saving new product: {}", productDTO);
        return productService.saveProduct(productDTO);
    }



}
