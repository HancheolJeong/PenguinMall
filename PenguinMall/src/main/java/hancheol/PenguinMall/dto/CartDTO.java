package hancheol.PenguinMall.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CartDTO {
    @NotNull
    @Id
    private int id; // id

    @NotNull
    @Min(value=1)
    @Max(value=1000)
    private int quantity; // 수량

    @NotNull
    private int product_id; // product.id 참조

    @NotNull
    private String cid; // customer.id 참조

}
