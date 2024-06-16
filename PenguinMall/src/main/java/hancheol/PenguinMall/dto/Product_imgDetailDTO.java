package hancheol.PenguinMall.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 계층 간 데이터 전송을 위해 사용되는 객체
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product_imgDetailDTO {
    @NotNull
    @Id
    private int id;

    @NotNull
    private String name;

    @NotNull
    @Min(value = 100)
    @Max(value = 2147483647)
    private int price;

    @NotNull
    @Min(value = 100)
    @Max(value = 2147483647)
    private int quantity;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private int discount_rate;

    @NotNull
    private String category;

    @NotNull
    private String subcategory;

    @NotNull
    private String image_path;

    @NotNull
    private String info;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    private int allowance;

    @NotNull
    private LocalDateTime create_dt;

    @NotNull
    private String seller_id; // seller.id 참조

    private List<Product_imgDTO> imagePaths; // 이미지 경로 리스트
}
