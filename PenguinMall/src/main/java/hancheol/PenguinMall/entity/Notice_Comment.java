package hancheol.PenguinMall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="notice_comment")
public class Notice_Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 쿠폰기록 ID

    String comment; // 댓글
    Integer nid; // notice.id
    String cid; // user.id

}
