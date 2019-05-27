package com.spring.radek.recipeproject.services;

import com.spring.radek.recipeproject.commands.CategoryCommand;

import java.util.Set;

public interface CategoryService {

    Set<CategoryCommand> listAllCategories();

}
