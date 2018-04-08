package com.webapps.recipe.converters;

import com.webapps.recipe.command.UnitOfMeasureCommand;
import com.webapps.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UnitOfMeasureToUnitOfMeasureCommandTest {
    private static final Long ID = new Long(1L);
    private static final String DESC = "desc";

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        // given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID);
        unitOfMeasure.setDescription(DESC);

        // when
        UnitOfMeasureCommand unitOfMeasureCommand = converter.convert(unitOfMeasure);

        // then
        assertEquals(ID, unitOfMeasureCommand.getId());
        assertEquals(DESC, unitOfMeasureCommand.getDescription());
    }
}