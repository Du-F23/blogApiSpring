package edu.utvt.blog.services.implementation;

import edu.utvt.blog.entities.Categories;
import edu.utvt.blog.entities.dto.CategoriesDto;
import edu.utvt.blog.repositories.CategoriesRepository;
import edu.utvt.blog.services.CategoriesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesImplementation implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Transactional
    public List<Categories> findAll() {
        return this.categoriesRepository.findAll();
    }

    @Transactional
    public Optional<Categories> findById(Long id) {
        return this.categoriesRepository.findById(id);
    }

    @Transactional
    public Categories save(Categories categories) {
        return this.categoriesRepository.saveAndFlush(categories);
    }

    @Transactional
    public void deleteById(Long id) {
        this.categoriesRepository.deleteById(id);
    }

    @Transactional
    public Categories update(Long id, Categories data) {
        Optional<Categories> categories = null;
        categories = this.categoriesRepository.findById(id);

        if (categories.isPresent()) {
            categories.get().setName(data.getName());
            categories.get().setDescription(data.getDescription());
            this.categoriesRepository.save(categories.get());
        }

        return categories.orElseThrow();
    }

    @Transactional
    public Optional<CategoriesDto> findByName(String name) {
        return this.categoriesRepository.findByName(name);
    }

    @Transactional
    public List<CategoriesDto> findByNameContaining(String name) {
        return this.categoriesRepository.findByNameContaining(name);
    }
}
