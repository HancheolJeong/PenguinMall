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
@Table(name="wishlist")
public class Wishlist extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // id

    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Product product; // 참조되는 상품

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "id")
    private User user; // 고객 참조
}
