package hancheol.PenguinMall.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * 계층 간 데이터 전송을 위해 사용되는 객체
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Notice_imageDTO {
    @NotNull
    @Id
    private String id; //id
    
    @NotNull
    private int sequence; // 이미지 순서
    
    @NotNull
    private String image_path; // 이미지 경로
    
    @NotNull
    private int nid; // notice.id 참조
}
