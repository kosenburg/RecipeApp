package com.webapps.recipe.converters;

import com.webapps.recipe.command.CategoryCommand;
import com.webapps.recipe.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {
    private static final Long ID = new Long(1L);
    private static final String DESC = "desc";

    private CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {
        // given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID);
        categoryCommand.setDescription(DESC);

        // when
        Category category = converter.convert(categoryCommand);


        // then
        assertEquals(ID, category.getId());
        assertEquals(DESC, category.getDescription());


    }
}