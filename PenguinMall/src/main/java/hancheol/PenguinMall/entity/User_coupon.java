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
@Table(name="user_coupon")
public class User_coupon extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 고유 ID
    Integer amount; // 수량
    Date expiration_date; // 만료날짜

    @ManyToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "id")
    private Coupon coupon; // 고객 참조

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "id")
    private User user; // 고객 참조
}
