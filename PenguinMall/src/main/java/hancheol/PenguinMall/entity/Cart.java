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
@Table(name="cart")
public class Cart extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id; // 고유 ID
    Integer quantity; // 수량
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product; // 참조되는 상품

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "id")
    private User user; // 고객 참조
}
