package hancheol.PenguinMall.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="product_img")
public class Product_img{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 고유 ID

    Integer sequence; // 이미지순서

    private String img_path; // 이미지경로
    //Integer pid; // product.id 참조

    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Product product; // 참조되는 상품
}
