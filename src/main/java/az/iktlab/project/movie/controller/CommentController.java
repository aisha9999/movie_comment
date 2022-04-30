package az.iktlab.project.movie.controller;

import az.iktlab.project.movie.dto.CommentDto;
import az.iktlab.project.movie.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public void addComment(@RequestBody CommentDto dto) {
        commentService.addComment(dto);
    }

    @GetMapping("/all")
    public List<CommentDto> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/{id}")
    public CommentDto getById(@PathVariable Long id) {
        return commentService.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CommentDto dto) {
        commentService.update(id, dto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        commentService.delete(id);
    }

}
