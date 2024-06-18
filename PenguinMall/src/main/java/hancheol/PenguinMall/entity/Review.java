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
@Table(name="review")
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 리뷰id
    String title; // 제목
    String content; // 내용
    String cid; // customer.id 참조
//    Integer pid; // product.id 참조

    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Product product; // 참조되는 상품
}
