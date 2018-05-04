package com.webapps.recipe.converters;

import com.webapps.recipe.domain.Category;
import com.webapps.recipe.repositories.CategoryRepository;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryConverter implements Converter<String, Category> {

    private CategoryRepository categoryRepository;

    @Synchronized
    @Nullable
    @Override
    public Category convert(String source) {
        Optional<Category> optional = categoryRepository.findById(Long.parseLong(source));
       return optional.get();
    }
}