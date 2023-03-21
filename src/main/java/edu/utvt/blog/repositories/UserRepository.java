package edu.utvt.blog.repositories;

import edu.utvt.blog.entities.User;
import edu.utvt.blog.entities.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<UserDto> findByName(String name);

    public List<UserDto> findByNameContaining(String name);
}
