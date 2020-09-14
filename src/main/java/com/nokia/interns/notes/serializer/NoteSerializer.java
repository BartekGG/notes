package com.nokia.interns.notes.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nokia.interns.notes.model.Note;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class NoteSerializer extends StdSerializer<Note> {
    public NoteSerializer() {
        this(null);
    }

    public NoteSerializer(Class<Note> c) {
        super(c);
    }

    @Override
    public void serialize(Note note, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", note.getId());
        jsonGenerator.writeStringField("title", note.getTitle());
        jsonGenerator.writeStringField("contents", note.getContents());
        jsonGenerator.writeStringField("date", note.getDate().format(DateTimeFormatter.BASIC_ISO_DATE));
        jsonGenerator.writeStringField("priority", note.getPriority().toString());
        jsonGenerator.writeEndObject();
    }
}
