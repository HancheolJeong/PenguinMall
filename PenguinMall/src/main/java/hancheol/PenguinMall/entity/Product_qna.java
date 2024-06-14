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
@Table(name="product_qna")
public class Product_qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // id
    String title; // 제목
    String question; // 질문
    String answer; // 답변
    Integer pid; // product.id 참조
    String cid; // customer.id 참조
}
