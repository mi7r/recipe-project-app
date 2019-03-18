package com.spring.radek.recipeproject.converters;

import com.spring.radek.recipeproject.commands.IngredientCommand;
import com.spring.radek.recipeproject.commands.UnitOfMeasureCommand;
import com.spring.radek.recipeproject.domain.Ingredient;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    public static final Long ID_VALUE = 1L;
    public static final BigDecimal AMOUNT = new BigDecimal(1);
    public static final String DESCRIPTION = "description";
    public static final Long UOM_ID = 2L;

    IngredientCommandToIngredient converter;


    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() {
        IngredientCommand ingredientCommand = new IngredientCommand();
        UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();

        ingredientCommand.setId(ID_VALUE);
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setAmount(AMOUNT);
        uomCommand.setId(UOM_ID);
        ingredientCommand.setUomCommand(uomCommand);

        Ingredient ingredient = converter.convert(ingredientCommand);

        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    @Test
    public void convertWithNullUOM() {
        IngredientCommand ingredientCommand = new IngredientCommand();
        UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();

        ingredientCommand.setId(ID_VALUE);
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setAmount(AMOUNT);

        Ingredient ingredient = converter.convert(ingredientCommand);

        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());

    }
}