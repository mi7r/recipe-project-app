package com.spring.radek.recipeproject.repositories;

import com.spring.radek.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
