package edu.utvt.blog.repositories;

import edu.utvt.blog.entities.Categories;
import edu.utvt.blog.entities.dto.CategoriesDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    public Optional<CategoriesDto> findByName(String name);

    public List<CategoriesDto> findByNameContaining(String name);
}
