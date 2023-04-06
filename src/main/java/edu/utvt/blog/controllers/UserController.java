package edu.utvt.blog.controllers;

import edu.utvt.blog.entities.User;
import edu.utvt.blog.entities.dto.UserDto;
import edu.utvt.blog.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/all")
    public List<User> findAllOther() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") Long id) {
        return ResponseEntity.of(this.userService.findById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.created(null).body(this.userService.update(id, user));
    }

    @PostMapping("/create")
    public ResponseEntity<User> save(@RequestBody User user) {
        System.out.println(user.getName());
        return ResponseEntity.created(null).body(this.userService.save(user));
    }

    @GetMapping("/find")
    public ResponseEntity<UserDto> find(@RequestParam String name) {
        return ResponseEntity.of(this.userService.findByName(name));
    }

    @GetMapping("/findContainName")
    public List<UserDto> findContain(@RequestParam String name) {
        return this.userService.findByNameContaining(name);
    }
}
