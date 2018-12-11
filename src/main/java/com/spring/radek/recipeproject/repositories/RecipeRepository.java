package com.spring.radek.recipeproject.repositories;

import com.spring.radek.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
