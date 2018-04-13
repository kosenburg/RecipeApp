package com.webapps.recipe.converters;

import com.webapps.recipe.command.IngredientCommand;
import com.webapps.recipe.command.UnitOfMeasureCommand;
import com.webapps.recipe.domain.Ingredient;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {
    private static final BigDecimal AMT = new BigDecimal(1);
    private static final Long ID = new Long(1L);
    private static final String DESC = "desc";
    private static final Long UOM_ID = new Long(2L);


    private IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullObj() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() {

        // given
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setAmount(AMT);
        ingredientCommand.setDescription(DESC);
        ingredientCommand.setId(ID);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        ingredientCommand.setUom(unitOfMeasureCommand);

        // when
        Ingredient ingredient = converter.convert(ingredientCommand);

        // then
        assertEquals(AMT, ingredient.getAmount());
        assertEquals(DESC, ingredient.getDescription());
        assertEquals(ID, ingredient.getId());
        assertEquals(UOM_ID, ingredient.getUom().getId());

    }

    @Test
    public void convertWithEmptyUom() {
        // given
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setAmount(AMT);
        ingredientCommand.setDescription(DESC);
        ingredientCommand.setId(ID);
        ingredientCommand.setUom(null);

        // when
        Ingredient ingredient = converter.convert(ingredientCommand);

        // then
        assertEquals(AMT, ingredient.getAmount());
        assertEquals(DESC, ingredient.getDescription());
        assertEquals(ID, ingredient.getId());
        assertNull(ingredient.getUom());
    }
}