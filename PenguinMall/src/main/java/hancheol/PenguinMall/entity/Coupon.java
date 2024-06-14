package hancheol.PenguinMall.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 쿠폰ID

    String name; // 쿠폰명
    Integer discount_rate; // 할인률
    Integer min_order_price; // 최소주문금액

}
