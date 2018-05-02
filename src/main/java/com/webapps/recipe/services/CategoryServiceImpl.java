package com.webapps.recipe.services;

import com.webapps.recipe.command.CategoryCommand;
import com.webapps.recipe.repositories.CategoryRepository;
import com.webapps.recipe.converters.CategoryToCategoryCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryToCategoryCommand categoryToCategoryCommand;


    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryToCategoryCommand categoryToCategoryCommand) {
        this.categoryRepository = categoryRepository;
        this.categoryToCategoryCommand = categoryToCategoryCommand;
    }

    @Override
    public Set<CategoryCommand> listAllCategories() {

            return StreamSupport.stream(categoryRepository.findAll()
                    .spliterator(), false)
                    .map(categoryToCategoryCommand::convert)
                    .collect(Collectors.toSet());
        }
    }

