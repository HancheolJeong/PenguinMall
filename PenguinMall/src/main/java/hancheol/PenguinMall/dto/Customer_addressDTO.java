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
public class Customer_addressDTO {
    @NotNull
    @Id
    private int id; // id

    @NotNull
    private String postal_code; // 우편번호

    @NotNull
    private String address; // 주소

    @NotNull
    private String address_detail; // 상세 주소

    @NotNull
    private String cid; // customer.id
}
