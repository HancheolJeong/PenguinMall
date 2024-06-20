package hancheol.PenguinMall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="customer_coupon")
public class Customer_coupon extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 고유 ID
    Integer amount; // 수량
    Date expiration_date; // 만료날짜
    String cid; // customer.id
    Integer coupon_id; // coupon.id
}
