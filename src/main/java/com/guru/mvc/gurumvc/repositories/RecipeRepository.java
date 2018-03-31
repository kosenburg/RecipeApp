package com.guru.mvc.gurumvc.repositories;

import com.guru.mvc.gurumvc.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
