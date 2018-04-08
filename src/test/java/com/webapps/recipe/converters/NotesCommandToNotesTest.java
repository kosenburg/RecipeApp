package com.webapps.recipe.converters;

import com.webapps.recipe.command.NotesCommand;
import com.webapps.recipe.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {
    private static final Long ID = new Long(1L);
    private static final String NOTES = "notes";

    private NotesCommandToNotes converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullObj() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convert() {
        // given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID);
        notesCommand.setRecipeNotes(NOTES);

        // when
        Notes notes = converter.convert(notesCommand);

        // then
        assertEquals(ID, notes.getId());
        assertEquals(NOTES, notes.getRecipeNotes());
    }
}