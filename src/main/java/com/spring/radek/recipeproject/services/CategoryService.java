package com.spring.radek.recipeproject.services;

import com.spring.radek.recipeproject.commands.CategoryCommand;
import com.spring.radek.recipeproject.domain.Category;

import java.util.Set;

public interface CategoryService {

    Set<CategoryCommand> listAllCategories();

}
