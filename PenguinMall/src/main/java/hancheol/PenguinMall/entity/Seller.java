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
@Table(name="seller")
public class Seller extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 판매자id
    String pw; // 패스워드
    String name; //이름
    String phone_number; // 휴대폰번호
    String email; // 이메일
    Integer email_sub; // 이메일 수신여부 default 0
    String nickname; // 별명
    Integer allowance; // 판재마허용 default 0

}
