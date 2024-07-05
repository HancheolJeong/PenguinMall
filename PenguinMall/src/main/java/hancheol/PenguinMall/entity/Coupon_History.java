package hancheol.PenguinMall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="coupon_history")
public class Coupon_History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 쿠폰기록 ID

    LocalDateTime using_time; // 사용한시간
    Integer cid; // 쿠폰 ID
    String uid; // 사용자 ID
}
