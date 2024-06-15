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
public class CheckoutDTO {
    @NotNull
    @Id
    private int id; //주문번호
    
    @NotNull
    @Min(value = 100)
    @Max(value = 10000000)
    private int price; //가격
    
    @NotNull
    @Min(value = 1)
    @Max(value = 1000)
    private int quantity; // 수량

    @NotNull
    private String state; // 주문 배송상태
    
    @NotNull
    private int refund; // 환불신청 X : 0, O: 1
    
    @NotNull
    private String request; // 배달요청사항
    
    @NotNull
    private Integer pid; // product.id 참조
    
    @NotNull
    private  String cid; // customer.id 참조
}
