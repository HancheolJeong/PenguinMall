package hancheol.PenguinMall.entity;

import jakarta.persistence.*;
import lombok.*;

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
    Integer allowance; //판매허용여부 default 0
    String seller_id; // seller.id 참조
}
