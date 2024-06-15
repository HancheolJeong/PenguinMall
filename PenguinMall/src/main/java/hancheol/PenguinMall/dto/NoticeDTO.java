package hancheol.PenguinMall.dto;

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
public class NoticeDTO {
    @NotNull
    @Id
    private String id; //id
    
    @NotNull
    private String title; // 제목
    
    @NotNull
    private String content; // 내용
}
