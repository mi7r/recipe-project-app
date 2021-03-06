package com.spring.radek.recipeproject.converters;

import com.spring.radek.recipeproject.commands.IngredientCommand;
import com.spring.radek.recipeproject.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source != null) {
            final IngredientCommand ingredientCommand = new IngredientCommand();
            ingredientCommand.setId(source.getId());
            if (source.getRecipe() != null){
                ingredientCommand.setRecipeId(source.getRecipe().getId());
            }
            ingredientCommand.setAmount(source.getAmount());
            ingredientCommand.setDescription(source.getDescription());
            ingredientCommand.setUomCommand(uomConverter.convert(source.getUom()));
            return ingredientCommand;
        }
        return null;
    }
}
