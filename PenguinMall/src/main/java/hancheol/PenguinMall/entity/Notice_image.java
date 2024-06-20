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
@Table(name="notice_image")
public class Notice_image extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 고유 ID

    Integer sequence; // 이미지 순서
    String Image_path; // 이미지 경로

    @ManyToOne
    @JoinColumn(name = "nid", referencedColumnName = "id")
    private Notice notice; // 고객 참조
}
