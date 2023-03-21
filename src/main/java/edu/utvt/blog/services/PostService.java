package edu.utvt.blog.services;

import edu.utvt.blog.entities.Post;
import edu.utvt.blog.entities.dto.PostDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public List<Post> findAll();

    @Transactional
    public Optional<Post> findById(Long id);

    public Post save(Post post);

    public void deleteById(Long id);

    public Post update(Long id, Post post);

    public Optional<PostDto> findByTitle(String title);

    public List<PostDto> findByTitleContaining(String title);
}
