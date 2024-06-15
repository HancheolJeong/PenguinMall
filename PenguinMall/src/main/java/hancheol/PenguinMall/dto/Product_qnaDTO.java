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
public class Product_qnaDTO {
    @NotNull
    @Id
    private String id; //id
    
    @NotNull
    private String title; // 제목
    
    @NotNull
    private String question; // 질문
    
    @NotNull
    private String answer; // 답변
    
    @NotNull
    private int pid; // product.id 참조
    
    @NotNull
    private String cid; // customer.id 참조
}
