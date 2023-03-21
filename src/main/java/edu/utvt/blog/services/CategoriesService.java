package edu.utvt.blog.services;

import edu.utvt.blog.entities.Categories;
import edu.utvt.blog.entities.dto.CategoriesDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface CategoriesService {
    public List<Categories> findAll();

    @Transactional
    public Optional<Categories> findById(Long id);

    public Categories save(Categories categories);

    public void deleteById(Long id);

    public Categories update(Long id, Categories post);

    public Optional<CategoriesDto> findByName(String name);

    public List<CategoriesDto> findByNameContaining(String name);
}
