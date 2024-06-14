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
@Table(name="review_img")
public class Review_img extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 또는 GenerationType.AUTO 등
    Integer id; // id
    String image_path; // 이미지 경로
    Integer sequence; // 이미지 순서
    Integer rid; // review.id 참조

}
