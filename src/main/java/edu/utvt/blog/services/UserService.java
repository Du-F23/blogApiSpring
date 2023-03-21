package edu.utvt.blog.services;

import edu.utvt.blog.entities.Post;
import edu.utvt.blog.entities.User;
import edu.utvt.blog.entities.dto.PostDto;
import edu.utvt.blog.entities.dto.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();

    @Transactional
    public Optional<User> findById(Long id);

    public User save(User user);

    public void deleteById(Long id);

    public User update(Long id, User user);

    public Optional<UserDto> findByName(String name);

    public List<UserDto> findByNameContaining(String name);
}
