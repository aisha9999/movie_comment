package az.iktlab.project.movie.dao.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommentEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "text", nullable = false, length = 512)
    private String text;

    @Column(name = "movie_id", nullable = false,unique = true)
    private Long movieId;

    @Column(name = "user_id", nullable = false,unique = true)
    private Long userId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
