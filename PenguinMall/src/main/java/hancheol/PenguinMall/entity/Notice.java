package hancheol.PenguinMall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="notice")
public class Notice extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 공지사항 ID
    
    String title; // 제목
    String content; // 내용

    @ManyToOne
    @JoinColumn(name = "mid", referencedColumnName = "id")
    private User user; // 매니저 참조

    @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Notice_image> notices; // 공지사항 이미지 리스트
}
