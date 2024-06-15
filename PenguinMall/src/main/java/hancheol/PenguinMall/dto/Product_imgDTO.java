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
public class Product_imgDTO {
    @NotNull
    @Id
    private String id; //id
    
    @NotNull
    private int sequence; // 이미지 순서
    
    @NotNull
    private String image_path; // 이미지 경로
    
    @NotNull
    private int pid; // product.id 참조
}
