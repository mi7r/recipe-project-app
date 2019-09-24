package com.spring.radek.recipeproject.converters;

import com.spring.radek.recipeproject.commands.RecipeCommand;
import com.spring.radek.recipeproject.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommendToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter,
                                 IngredientCommandToIngredient ingredientConverter,
                                 NotesCommendToNotes notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setDescription(source.getDescription());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setDirections(source.getDirections());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setImage(source.getImage());

        recipe.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getIngredients() != null && !source.getIngredients().isEmpty()) {
            source.getIngredients().forEach(ingredient -> recipe
                    .getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        if (source.getCategories() != null && !source.getCategories().isEmpty()) {
            source.getCategories().forEach(category -> recipe
                    .getCategories().add(categoryConverter.convert(category)));
        }
        return recipe;
    }

}
