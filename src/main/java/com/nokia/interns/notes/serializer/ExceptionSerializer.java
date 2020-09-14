package com.nokia.interns.notes.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;

public class ExceptionSerializer extends StdSerializer<Exception> {
    public ExceptionSerializer() {
        this(null);
    }

    public ExceptionSerializer(Class<Exception> c) {
        super(c);
    }

    @Override
    public void serialize(Exception e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("timestamp", LocalDateTime.now().toString());
        jsonGenerator.writeStringField("exception", e.getClass().getSimpleName());
        jsonGenerator.writeStringField("message", e.getMessage());
        jsonGenerator.writeEndObject();
    }
}
