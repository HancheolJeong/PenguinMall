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
@Table(name="customer")
public class Customer extends BaseEntity{
    @Id
    String id; // 고객 ID
    String pw; // 패스워드
    String name; // 이름
    String phone_number; // 휴대폰번호
    String email; // 이메일
    Integer email_sub; // 이메일 수신여부 default 0
    String nickname; //별명
    String grade; // 등급
    Integer drop_user; // 탈퇴여부

}
