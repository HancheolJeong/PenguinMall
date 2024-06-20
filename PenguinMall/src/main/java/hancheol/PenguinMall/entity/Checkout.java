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
@Table(name="checkout")
public class Checkout extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 주문번호

    Integer price; // 가격
    Integer quantity; //수량
    String state; // 주문/배송상태
    Integer refund; // 환불신청 X : 0 환불신청 O : 1
    String request; // 배달요청사항
    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Product product; // 참조되는 상품

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "id")
    private User user; // 고객 참조
}
