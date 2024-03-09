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
    Integer id;

    String name;
    Integer price;
    Integer quantity;
    Integer discount_rate;
    String category;
    String subcategory;
    String image_path;
    String info;
    Integer allowance;
    String seller_id; // seller.id 참조
}
