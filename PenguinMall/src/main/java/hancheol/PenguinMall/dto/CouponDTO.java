package hancheol.PenguinMall.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;
/**
 * 계층 간 데이터 전송을 위해 사용되는 객체
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CouponDTO {
    @NotNull
    @Id
    private int id;

    @NotNull
    private String name; // 쿠폰명

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private int discount_rate; // 할인률

    @NotNull
    @Min(value = 100)
    @Max(value = 10000000)
    private int min_order_price; // 최소주문금액
}
