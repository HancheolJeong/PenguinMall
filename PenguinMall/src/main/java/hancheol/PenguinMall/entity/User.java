package hancheol.PenguinMall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="user")
public class User extends BaseEntity{
    @Id
    String id; // 고객 ID
    String pw; // 패스워드
    String name; // 이름
    String phone_number; // 휴대폰번호
    String email; // 이메일
    Integer email_sub; // 이메일 수신여부 default 0
    String nickname; //별명
    String role; // 역할
    Integer drop_user; // 탈퇴여부

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User_address> addresses; // 주소 리스트 (소비자, 판매자, 관리자)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cart> carts; // 장바구니 리스트 (소비자, 판매자, 관리자)
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews; // 리뷰 리스트 (소비자, 판매자, 관리자)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Wishlist> wishlists; // 좋아요 리스트 (소비자, 판매자, 관리자)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User_coupon> coupons; // 쿠폰 리스트 (소비자, 판매자, 관리자)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Checkout> checkouts; // 구매상태 리스트 (소비자, 판매자, 관리자)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product_qna> qnas; // 질문 리스트 (소비자, 판매자, 관리자)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products; // 상품 리스트 (판매자, 관리자)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Notice> notices; // 상품 리스트 (관리자)

}
