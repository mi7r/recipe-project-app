package com.spring.radek.recipeproject.converters;

import com.spring.radek.recipeproject.commands.NotesCommand;
import com.spring.radek.recipeproject.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommendToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if (source != null) {
            final Notes notes = new Notes();
            notes.setId(source.getId());
            notes.setRecipeNotes(source.getRecipeNotes());
            return notes;
        }
        return null;
    }
}
