package com.webapps.recipe.converters;

import com.webapps.recipe.domain.Category;
import com.webapps.recipe.repositories.CategoryRepository;
import com.webapps.recipe.services.CategoryService;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<String,Category> {

    private CategoryRepository categoryRepository;
    private CategoryService categoryService;

    @Synchronized
    @Nullable
    @Override
    public Category convert(String source) {
        if (source == null){
            return null;
        }

        Long parsedLong = Long.parseLong(source);



        return null;
    }
}