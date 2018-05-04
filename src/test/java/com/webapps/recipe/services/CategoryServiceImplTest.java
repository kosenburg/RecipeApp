package com.webapps.recipe.services;

import com.webapps.recipe.command.CategoryCommand;
import com.webapps.recipe.converters.CategoryToCategoryCommand;
import com.webapps.recipe.domain.Category;
import com.webapps.recipe.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class CategoryServiceImplTest {
    CategoryService service;
    CategoryToCategoryCommand categoryToCategoryCommand = new CategoryToCategoryCommand();

    @Mock
    CategoryRepository categoryRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        service = new CategoryServiceImpl(categoryRepository,categoryToCategoryCommand);

    }

    @Test
    public void getAllCategories() {
        Set<Category> categories = new HashSet<>();

        Category category = new Category();
        category.setId(1L);
        categories.add(category);

        Category category2 =new Category();
        category2.setId(2L);
        categories.add(category2);

        when(categoryRepository.findAll()).thenReturn(categories);

        Set<CategoryCommand> categoryCommand = service.listAllCategories();

        assertEquals(2, categoryCommand.size());
        verify(categoryRepository, times(1)).findAll();
    }


//    TODO:Fix this test case at breakpoint
    @Test
    public void getCommandById() {
        Long id = 1L;
        Category category = new Category();
        category.setId(id);

        Optional<Category> categoryOptional = Optional.of(category);

        when(categoryRepository.findById(anyLong())).thenReturn(categoryOptional);

        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(id);

        when(categoryToCategoryCommand.convert(any())).thenReturn(categoryCommand);

        CategoryCommand returnedCommand = service.findCommandById(id);

        assertNotNull("Null recipe command returned", returnedCommand);
        verify(categoryRepository, times(1)).findById(anyLong());
        verify(categoryRepository, never()).findAll();

        assertEquals(category.getId(), returnedCommand.getId());
        assertEquals(category.getId(), returnedCommand.getId());


    }

    @Test
    public void findById() {
        Long id = 1L;
    }




}