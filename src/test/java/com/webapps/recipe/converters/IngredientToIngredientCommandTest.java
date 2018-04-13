package com.webapps.recipe.converters;

import com.webapps.recipe.command.IngredientCommand;
import com.webapps.recipe.domain.Ingredient;
import com.webapps.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {
    private static final BigDecimal AMT = new BigDecimal(1);
    private static final Long ID = new Long(1L);
    private static final String DESC = "desc";
    private static final Long UOM_ID = new Long(2L);


    private IngredientToIngredientCommand converter;
    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullObj() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convert() {

        // given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setDescription(DESC);
        ingredient.setAmount(AMT);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredient.setUom(unitOfMeasure);

        // when
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        // then
        assertEquals(ID, ingredientCommand.getId());
        assertEquals(DESC, ingredientCommand.getDescription());
        assertEquals(AMT, ingredientCommand.getAmount());
        assertEquals(UOM_ID, ingredientCommand.getUom().getId());

    }

    @Test
    public void convertWithEmptyUom() {
        // given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setDescription(DESC);
        ingredient.setAmount(AMT);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredient.setUom(null);

        // when
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        // then
        assertEquals(ID, ingredientCommand.getId());
        assertEquals(DESC, ingredientCommand.getDescription());
        assertEquals(AMT, ingredientCommand.getAmount());
    }
}