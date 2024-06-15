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
public class CustomerDTO {
    @NotNull
    @Id
    private String id; //id

    @NotNull
    private String pw; //패스워드

    @NotNull
    private String name; //이름
    
    @NotNull
    private String phone_number; //휴대폰번호
    
    @NotNull
    private String email; // 이메일
    
    @NotNull
    private int email_sub; // 이메일 수신여부 default 0
    
    @NotNull
    private String nickname; // 별명
    
    @NotNull
    private String grade; //별명
    
    @NotNull
    private int drop; // 탈퇴여부
}
