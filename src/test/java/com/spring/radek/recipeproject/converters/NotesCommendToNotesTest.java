package com.spring.radek.recipeproject.converters;

import com.spring.radek.recipeproject.commands.NotesCommand;
import com.spring.radek.recipeproject.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesCommendToNotesTest {
    public static final Long ID_VALUE = 1L;
    public static final String RECIPE_NOTES = "notes";

    NotesCommendToNotes converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesCommendToNotes();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convert() {
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        Notes notes = converter.convert(notesCommand);

        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());

    }
}