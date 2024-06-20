package hancheol.PenguinMall.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

/**
 * 계층 간 데이터 전송을 위해 사용되는 객체
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User_couponDTO {
    @NotNull
    @Id
    private int id; // id
    
    @NotNull
    private int amount; // 수량
    
    private Date expiration_date; // 만료날짜
    
    private String cid; // customer.id 참조
    
    private int coupon_id; // coupon.id 참조
    
}
