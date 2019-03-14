package com.spring.radek.recipeproject.converters;

import com.spring.radek.recipeproject.commands.UnitOfMeasureCommand;
import com.spring.radek.recipeproject.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source != null) {
            final UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
            uomCommand.setId(source.getId());
            uomCommand.setDescription(source.getDescription());
            return uomCommand;
        }
        return null;
    }
}
