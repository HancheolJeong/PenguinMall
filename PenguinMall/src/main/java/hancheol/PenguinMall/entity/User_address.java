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
@Table(name="user_address")
public class User_address extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id;

    String postal_code; // 우편번호
    String address; // 주소
    String address_detail; // 상세 주소
    String address_alias; // 주소목록
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private User user; // 고객 참조
}
