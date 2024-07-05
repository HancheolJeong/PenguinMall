package hancheol.PenguinMall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="login_history")
public class Login_History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 로그인기록 ID
    LocalDateTime login_time; // 로그인시간
    Integer cid; // 고객 ID
}
