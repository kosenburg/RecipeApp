package com.webapps.recipe.converters;

import com.webapps.recipe.command.NotesCommand;
import com.webapps.recipe.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesToNotesCommandTest {
    private static final Long ID = new Long(1L);
    private static final String NOTES = "notes";

    private NotesToNotesCommand converter;
    @Before
    public void setUp() throws Exception {
        converter = new NotesToNotesCommand();
    }

    @Test
    public void testNullObj() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    public void convert() {
        Notes notes = new Notes();
        notes.setId(ID);
        notes.setRecipeNotes(NOTES);

        NotesCommand notesCommand =converter.convert(notes);

        assertEquals(ID, notesCommand.getId());
        assertEquals(NOTES, notesCommand.getRecipeNotes());
    }
}