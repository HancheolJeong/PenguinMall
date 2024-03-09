package hancheol.PenguinMall.service.impl;

import hancheol.PenguinMall.dto.ProductDTO;
import hancheol.PenguinMall.entity.Product;
import hancheol.PenguinMall.repository.ProductRepository;
import hancheol.PenguinMall.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO)
    {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setDiscount_rate(productDTO.getDiscount_rate());
        product.setCategory(productDTO.getCategory());
        product.setSubcategory(productDTO.getSubcategory());
        product.setImage_path(productDTO.getImage_path());
        product.setInfo(productDTO.getInfo());
        product.setAllowance(productDTO.getAllowance());
        product.setSeller_id(productDTO.getSeller_id());

        // 엔티티 저장 id랑 create_dt는 알아서 저장된다. seller_id는 참조키!
        product = productRepository.save(product);

        productDTO.setId(product.getId());
        return productDTO;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setQuantity(product.getQuantity());
            productDTO.setDiscount_rate(product.getDiscount_rate());
            productDTO.setCategory(product.getCategory());
            productDTO.setSubcategory(product.getSubcategory());
            productDTO.setImage_path(product.getImage_path());
            productDTO.setInfo(product.getInfo());
            productDTO.setAllowance(product.getAllowance());
            productDTO.setSeller_id(product.getSeller_id());
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public ProductDTO findProductById(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setDiscount_rate(product.getDiscount_rate());
        productDTO.setCategory(product.getCategory());
        productDTO.setSubcategory(product.getSubcategory());
        productDTO.setImage_path(product.getImage_path());
        productDTO.setInfo(product.getInfo());
        productDTO.setAllowance(product.getAllowance());
        productDTO.setSeller_id(product.getSeller_id());
        productDTO.setCreate_dt(product.getCreate_dt());
        return productDTO;

    }

    @Override
    public ProductDTO updateProduct(String id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setDiscount_rate(productDTO.getDiscount_rate());
        product.setCategory(productDTO.getCategory());
        product.setSubcategory(productDTO.getSubcategory());
        product.setImage_path(productDTO.getImage_path());
        product.setInfo(productDTO.getInfo());
        product.setAllowance(productDTO.getAllowance());
        product.setSeller_id(productDTO.getSeller_id());
        product = productRepository.save(product);

        productDTO.setId(product.getId());
        return productDTO;
    }

    @Override
    public void deleteProduct(String id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }
}
