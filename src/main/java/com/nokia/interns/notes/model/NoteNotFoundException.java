package com.nokia.interns.notes.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nokia.interns.notes.serializer.ExceptionSerializer;

@JsonSerialize(using = ExceptionSerializer.class)
public class NoteNotFoundException extends Exception {
    public NoteNotFoundException(Long id) {
        super(String.format("Notatka o ID %d nie istnieje!", id));
    }
}
