package com.spring.radek.recipeproject.converters;

import com.spring.radek.recipeproject.commands.NotesCommand;
import com.spring.radek.recipeproject.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if (source != null) {
            final NotesCommand notesCommand = new NotesCommand();
            notesCommand.setId(source.getId());
            notesCommand.setRecipeNotes(source.getRecipeNotes());
            return notesCommand;
        }
        return null;
    }
}
