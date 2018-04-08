package com.webapps.recipe.converters;

import com.webapps.recipe.command.IngredientCommand;
import com.webapps.recipe.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommandTest) {

    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        return null;
    }
}
