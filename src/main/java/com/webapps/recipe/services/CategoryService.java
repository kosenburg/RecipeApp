package com.webapps.recipe.services;

import com.webapps.recipe.command.CategoryCommand;

import java.util.Set;

public interface CategoryService {
        Set<CategoryCommand> listAllCategories();


}
