package edu.utvt.blog.services.implementation;

import edu.utvt.blog.entities.User;
import edu.utvt.blog.entities.dto.UserDto;
import edu.utvt.blog.repositories.UserRepository;
import edu.utvt.blog.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    @Transactional
    public Optional<User> findById(Long id){
        return this.userRepository.findById(id);
    }

    @Transactional
    public User save(User user) {
        return this.userRepository.saveAndFlush(user);
    }

    @Transactional
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Transactional
    public User update(Long id, User data) {
        Optional<User> user = null;
        user = this.userRepository.findById(id);

        if (user.isPresent()) {
            user.get().setName(data.getName());
            user.get().setEmail(data.getEmail());
            user.get().setPassword(data.getPassword());
            this.userRepository.save(user.get());
        }

        return user.orElseThrow();
    }

    @Transactional
    public Optional<UserDto> findByName(String name) {
        return this.userRepository.findByName(name);
    }

    @Transactional
    public List<UserDto> findByNameContaining(String name) {
        return this.userRepository.findByNameContaining(name);
    }
}
