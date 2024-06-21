package hancheol.PenguinMall.dto;

import hancheol.PenguinMall.entity.User_coupon;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

/**
 * 계층 간 데이터 전송을 위해 사용되는 객체
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserInfoDTO {
    @NotNull
    @Id
    private String id; //id

    @NotNull
    private String pw; //패스워드

    @NotNull
    private String name; //이름

    @NotNull
    private String phone_number; //휴대폰번호

    @NotNull
    private String email; // 이메일

    @NotNull
    private int email_sub; // 이메일 수신여부 default 0

    @NotNull
    private String nickname; // 별명

    @NotNull
    private String role; //등급

    @NotNull
    private int drop_user; // 탈퇴여부

    private List<User_addressDTO> addresses; // 이미지 경로 리스트

    private List<CartDTO> carts; // 장바구리 리스트

    private List<ReviewDTO> reviews; //리뷰 리스트

    private List<WishlistDTO> wishlists; // 좋아요 리스트

    private List<User_couponDTO> coupons; // 쿠폰 리스트

    private List<CheckoutDTO> checkouts; // 구매목록 리스트

    private List<Product_qnaDTO> qnas; // 질문과답변 리스트

    private List<ProductDTO> products; // 상품 리스트

    private List<NoticeDTO> notices; // 공지사항 리스트


}
