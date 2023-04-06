package edu.utvt.blog.controllers;

import edu.utvt.blog.entities.Post;
import edu.utvt.blog.entities.User;
import edu.utvt.blog.entities.dto.PostDto;
import edu.utvt.blog.entities.dto.UserDto;
import edu.utvt.blog.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok().body(postService.findAll());
    }

    @GetMapping("/all")
    public List<Post> findAllOther() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> get(@PathVariable("id") Long id) {
        return ResponseEntity.of(this.postService.findById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody Post post) {
        return ResponseEntity.created(null).body(this.postService.update(id, post));
    }

    @PostMapping("/create")
    public ResponseEntity<Post> save(@RequestBody Post post) {
        System.out.println(post.getTitle());
        return ResponseEntity.created(null).body(this.postService.save(post));
    }

    @GetMapping("/find")
    public ResponseEntity<PostDto> find(@RequestParam String title) {
        return ResponseEntity.of(this.postService.findByTitle(title));
    }

    @GetMapping("/findContainName")
    public List<PostDto> findContain(@RequestParam String title) {
        return this.postService.findByTitleContaining(title);
    }
}
