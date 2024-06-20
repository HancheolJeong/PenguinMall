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
@Table(name="review")
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // 리뷰id
    String title; // 제목
    String content; // 내용
    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "id")
    private User user; // 고객 참조

    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Product product; // 참조되는 상품

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review_img> imgs; // 리뷰이미지 리스트
}
