package com.webapps.recipe.services;

import com.webapps.recipe.command.RecipeCommand;
import com.webapps.recipe.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(long l);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    RecipeCommand findCommandById(long l);
    void deleteById(long l);
}
