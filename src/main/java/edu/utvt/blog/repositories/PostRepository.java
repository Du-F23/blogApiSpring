package edu.utvt.blog.repositories;

import edu.utvt.blog.entities.Post;
import edu.utvt.blog.entities.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<PostDto> findByTitle(String title);

    List<PostDto> findByTitleContaining(String title);
}
