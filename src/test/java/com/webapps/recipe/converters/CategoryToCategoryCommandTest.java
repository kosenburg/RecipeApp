package com.webapps.recipe.converters;

import com.webapps.recipe.command.CategoryCommand;
import com.webapps.recipe.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {
    private static final Long ID = new Long(1L);
    private static final String DESC = "desc";

    private CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() {
        // given
        Category category = new Category();
        category.setId(ID);
        category.setDescription(DESC);

        // when
        CategoryCommand categoryCommand = converter.convert(category);

        // then
        assertEquals(ID, categoryCommand.getId());
        assertEquals(DESC, categoryCommand.getDescription());
    }
}