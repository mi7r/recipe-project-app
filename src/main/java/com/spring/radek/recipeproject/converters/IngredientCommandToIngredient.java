package com.spring.radek.recipeproject.converters;

import com.spring.radek.recipeproject.commands.IngredientCommand;
import com.spring.radek.recipeproject.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source != null) {
            final Ingredient ingredient = new Ingredient();
            ingredient.setId(source.getId());
            ingredient.setAmount(source.getAmount());
            ingredient.setDescription(source.getDescription());
            ingredient.setUom(uomConverter.convert(source.getUomCommand()));
            return ingredient;
        }
        return null;
    }
}
