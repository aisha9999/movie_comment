package az.iktlab.project.movie.service;

import az.iktlab.project.movie.dao.entity.CommentEntity;
import az.iktlab.project.movie.dao.repository.CommentRepo;
import az.iktlab.project.movie.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;

    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public void addComment(CommentDto dto) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.builder()
                .id(dto.getId())
                .text(dto.getText())
                .movieId(dto.getMovieId())
                .userId(dto.getUserId())
                .build();
        commentRepo.save(commentEntity);
    }

    @Override
    public List<CommentDto> getAll() {
        List<CommentEntity> commentEntities = commentRepo.findAll();
        return commentEntities.stream()
                .map(commentEntity -> new CommentDto().builder()
                        .id(commentEntity.getId())
                        .text(commentEntity.getText())
                        .movieId(commentEntity.getMovieId())
                        .userId(commentEntity.getUserId())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public CommentDto getById(Long id) {
        CommentEntity commentEntity = commentRepo.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        return CommentDto.builder()
                .id(commentEntity.getId())
                .text(commentEntity.getText())
                .movieId(commentEntity.getMovieId())
                .userId(commentEntity.getUserId())
                .build();
    }

    @Override
    public void update(Long id, CommentDto dto) {
        CommentEntity commentEntity = commentRepo.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        commentEntity.setId(dto.getId());
        commentRepo.save(commentEntity);
    }

    @Override
    public void delete(Long id) {
        commentRepo.deleteById(id);

    }
}
