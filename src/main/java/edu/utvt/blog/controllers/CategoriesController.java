package edu.utvt.blog.controllers;

import edu.utvt.blog.entities.Categories;
import edu.utvt.blog.entities.dto.CategoriesDto;
import edu.utvt.blog.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<List<Categories>> findAll() {
        return ResponseEntity.ok().body(categoriesService.findAll());
    }

    @GetMapping("/all")
    public List<Categories> findAllOther() {
        return categoriesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> get(@PathVariable("id") Long id) {
        return ResponseEntity.of(this.categoriesService.findById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Categories> update(@PathVariable Long id, @RequestBody Categories categories) {
        return ResponseEntity.created(null).body(this.categoriesService.update(id, categories));
    }

    @PostMapping("/create")
    public ResponseEntity<Categories> save(@RequestBody Categories category) {
        System.out.println(category.getName());
        return ResponseEntity.created(null).body(this.categoriesService.save(category));
    }

    @GetMapping("/find")
    public ResponseEntity<CategoriesDto> find(@RequestParam String name) {
        return ResponseEntity.of(this.categoriesService.findByName(name));
    }

    @GetMapping("/findContainName")
    public List<CategoriesDto> findContain(@RequestParam String name) {
        return this.categoriesService.findByNameContaining(name);
    }
}
