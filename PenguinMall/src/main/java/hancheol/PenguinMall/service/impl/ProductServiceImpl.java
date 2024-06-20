package hancheol.PenguinMall.service.impl;

import hancheol.PenguinMall.dto.*;
import hancheol.PenguinMall.entity.Product;
import hancheol.PenguinMall.repository.ProductRepository;
import hancheol.PenguinMall.service.ProductService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Async
    @Override
    public CompletableFuture<ProductDTO> saveProduct(ProductDTO productDTO)
    {
        Product product = mapProductDtoToProduct(productDTO);

        // 엔티티 저장 id랑 create_dt는 알아서 저장된다. seller_id는 참조키!
        product = productRepository.save(product);
        productDTO.setId(product.getId());
        return CompletableFuture.completedFuture(productDTO);
    }

    @Async
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
            productDTO.setSeller_id(product.getSid());
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Async
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
        productDTO.setSeller_id(product.getSid());
        productDTO.setCreate_dt(product.getCreate_dt());
        return productDTO;

    }

    @Async
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
        product.setSid(productDTO.getSeller_id());
        product = productRepository.save(product);

        productDTO.setId(product.getId());
        return productDTO;
    }
    @Async
    @Override
    public void deleteProduct(String id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

    @Override
    public Product_imgDetailDTO getProductImageDetails(Integer productId) {
        Product product = productRepository.findById(productId);
        Product_imgDetailDTO dto = new Product_imgDetailDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setDiscount_rate(product.getDiscount_rate());
        dto.setCategory(product.getCategory());
        dto.setSubcategory(product.getSubcategory());
        dto.setImage_path(product.getImage_path());
        dto.setInfo(product.getInfo());
        dto.setAllowance(product.getAllowance());
        dto.setSeller_id(product.getSid());
        dto.setCreate_dt(product.getCreate_dt());
//        dto.setImagePaths(product.getImages().stream().map(Product_img::getImage_path).collect(Collectors.toList()));
        List<Product_imgDTO> images = product.getImages().stream()
                .map(img -> {
                    Product_imgDTO imgDTO = new Product_imgDTO();
                    imgDTO.setId(String.valueOf(img.getId()));  // ID가 Integer라면 String으로 변환
                    imgDTO.setSequence(img.getSequence());
                    imgDTO.setImage_path(img.getImg_path());
                    imgDTO.setPid(product.getId());  // 상품 ID를 pid 필드에 설정
                    return imgDTO;
                }).collect(Collectors.toList());
        dto.setImagePaths(images);  // 변환된 이미지 DTO 리스트 설정
        return dto;
    }

    @Override
    public ProductContentDetailDTO getProductContentDetails(Integer productId) {
        Product product = productRepository.findById(productId);
        ProductContentDetailDTO dto = new ProductContentDetailDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setDiscount_rate(product.getDiscount_rate());
        dto.setCategory(product.getCategory());
        dto.setSubcategory(product.getSubcategory());
        dto.setImage_path(product.getImage_path());
        dto.setInfo(product.getInfo());
        dto.setAllowance(product.getAllowance());
        dto.setSeller_id(product.getSid());
        dto.setCreate_dt(product.getCreate_dt());
//        dto.setImagePaths(product.getImages().stream().map(Product_img::getImage_path).collect(Collectors.toList()));
        List<Product_imgDTO> images = product.getImages().stream()
                .map(img -> {
                    Product_imgDTO imgDTO = new Product_imgDTO();
                    imgDTO.setId(String.valueOf(img.getId()));  // ID가 Integer라면 String으로 변환
                    imgDTO.setSequence(img.getSequence());
                    imgDTO.setImage_path(img.getImg_path());
                    imgDTO.setPid(product.getId());  // 상품 ID를 pid 필드에 설정
                    return imgDTO;
                }).collect(Collectors.toList());
        dto.setImagePaths(images);  // 변환된 이미지 DTO 리스트 설정

        List<Product_qnaDTO> qnas = product.getQnas().stream()
                .map(qna -> {
                    Product_qnaDTO qnaDTO = new Product_qnaDTO();
                    qnaDTO.setId(String.valueOf(qna.getId()));  // ID가 Integer라면 String으로 변환
                    qnaDTO.setTitle(qna.getTitle());
                    qnaDTO.setQuestion(qna.getQuestion());
                    qnaDTO.setAnswer(qna.getAnswer());
                    qnaDTO.setCid(qna.getCid());
                    qnaDTO.setPid(product.getId());  // 상품 ID를 pid 필드에 설정
                    return qnaDTO;
                }).collect(Collectors.toList());
        dto.setProduct_qnas(qnas);  // 변환된 이미지 DTO 리스트 설정

        List<ReviewDTO> reviews = product.getReviews().stream()
                .map(rv -> {
                    ReviewDTO reviewDTO = new ReviewDTO();
                    reviewDTO.setId(rv.getId());
                    reviewDTO.setTitle(rv.getTitle());
                    reviewDTO.setContent(rv.getContent());
                    reviewDTO.setCid(rv.getCid());
                    reviewDTO.setPid(product.getId());  // 상품 ID를 pid 필드에 설정
                    return reviewDTO;
                }).collect(Collectors.toList());
        dto.setReviews(reviews);  // 변환된 이미지 DTO 리스트 설정
        return dto;
    }

    private Product mapProductDtoToProduct(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setDiscount_rate(dto.getDiscount_rate());
        product.setCategory(dto.getCategory());
        product.setSubcategory(dto.getSubcategory());
        product.setImage_path(dto.getImage_path());
        product.setInfo(dto.getInfo());
        product.setAllowance(dto.getAllowance());
        product.setSid(dto.getSeller_id());
        return product;
    }

    private ProductDTO mapProductToProductDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setDiscount_rate(product.getDiscount_rate());
        dto.setCategory(product.getCategory());
        dto.setSubcategory(product.getSubcategory());
        dto.setImage_path(product.getImage_path());
        dto.setInfo(product.getInfo());
        dto.setAllowance(product.getAllowance());
        dto.setSeller_id(product.getSid());
        dto.setCreate_dt(product.getCreate_dt());
        return dto;
    }
}
