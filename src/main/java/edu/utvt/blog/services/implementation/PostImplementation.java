package edu.utvt.blog.services.implementation;

import edu.utvt.blog.entities.Post;
import edu.utvt.blog.entities.dto.PostDto;
import edu.utvt.blog.repositories.PostRepository;
import edu.utvt.blog.services.PostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Transactional
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    @Transactional
    public Optional<Post> findById(Long id) {
        return this.postRepository.findById(id);
    }

    @Transactional
    public Post save(Post post) {
        return this.postRepository.saveAndFlush(post);
    }

    @Transactional
    public void deleteById(Long id) {
        this.postRepository.deleteById(id);
    }

    @Transactional
    public Post update(Long id, Post data) {
        Optional<Post> post = null;
        post = this.postRepository.findById(id);

        if (post.isPresent()) {
            post.get().setTitle(data.getTitle());
            post.get().setContent(data.getContent());
            post.get().setLinks(data.getLinks());
            post.get().setStatus(data.getStatus());
            post.get().setUser(data.getUsuario());
            post.get().setCategories(data.getCategories());
            this.postRepository.save(post.get());
        }

        return post.orElseThrow();
    }

    @Transactional
    public Optional<PostDto> findByTitle(String title) {
        return this.postRepository.findByTitle(title);
    }

    @Transactional
    public List<PostDto> findByTitleContaining(String title) {
        return this.postRepository.findByTitleContaining(title);
    }
}
