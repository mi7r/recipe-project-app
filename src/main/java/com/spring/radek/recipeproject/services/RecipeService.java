package com.spring.radek.recipeproject.services;

import com.spring.radek.recipeproject.domain.Recipe;

import java.util.Set;



public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}
