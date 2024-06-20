package hancheol.PenguinMall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * 데이터베이스 테이블에 직접 매핑되는 객체
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="product")
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 상품id

    String name; // 상품명
    Integer price; // 가격
    Integer quantity; // 재고량
    Integer discount_rate; // 할인률
    String category; // 카테고리
    String subcategory; // 세부카테고리
    String image_path; // 상세이미지경로
    String info; // 상품정보

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    Integer allowance; //판매허용여부 default 0

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product_img> images; // 상품 이미지 리스트

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product_qna> qnas; // 질문과 답변 리스트

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews; // 리뷰 리스트

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Wishlist> wishlists; // 좋아요 리스트

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cart> carts; // 장바구니 리스트

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Checkout> checkouts; // 구매상태 리스트


    @ManyToOne
    @JoinColumn(name = "sid", referencedColumnName = "id")
    private User user; // 판매자 참조

}
