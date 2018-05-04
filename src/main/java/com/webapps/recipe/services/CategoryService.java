package com.webapps.recipe.services;

import com.webapps.recipe.command.CategoryCommand;
import com.webapps.recipe.domain.Category;

import java.util.Set;

public interface CategoryService {
        Set<CategoryCommand> listAllCategories();
        CategoryCommand findCommandById(long l);
        Category findById(long l);



}
