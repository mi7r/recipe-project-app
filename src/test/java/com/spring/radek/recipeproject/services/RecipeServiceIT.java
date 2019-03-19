package com.spring.radek.recipeproject.services;

import com.spring.radek.recipeproject.commands.RecipeCommand;
import com.spring.radek.recipeproject.converters.RecipeCommandToRecipe;
import com.spring.radek.recipeproject.converters.RecipeToRecipeCommand;
import com.spring.radek.recipeproject.domain.Recipe;
import com.spring.radek.recipeproject.repositories.RecipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {

    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Transactional
    @Test
    public void testSaveOfDescription() {
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        assertNotNull(testRecipeCommand);
        testRecipeCommand.setDescription(NEW_DESCRIPTION);
        RecipeCommand savedRecipe = recipeService.saveRecipeCommand(testRecipeCommand);

        assertEquals(NEW_DESCRIPTION, savedRecipe.getDescription());
        assertEquals(testRecipe.getId(), savedRecipe.getId());
        assertEquals(testRecipe.getCategories().size(), savedRecipe.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(), savedRecipe.getIngredients().size());
    }
}