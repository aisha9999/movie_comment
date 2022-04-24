package az.iktlab.project.movie.dao.repository;

import az.iktlab.project.movie.dao.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<CommentEntity,Long> {
}
