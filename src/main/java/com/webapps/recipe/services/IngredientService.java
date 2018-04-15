package com.webapps.recipe.services;

import com.webapps.recipe.command.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(long l, long anyLong);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(Long recipeId, Long idToDelete);
}
