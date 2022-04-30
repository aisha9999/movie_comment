package az.iktlab.project.movie.service;

import az.iktlab.project.movie.dto.CommentDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CommentService {
    void addComment(CommentDto dto);

    List<CommentDto> getAll();

    CommentDto getById(Long id);

    void update(Long id, CommentDto dto);

    void delete(@RequestParam Long id);
}
