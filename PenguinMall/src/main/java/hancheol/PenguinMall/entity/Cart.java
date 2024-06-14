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
    Integer pid; // product.id 참조
    String cid; // customer.id 참조
}
