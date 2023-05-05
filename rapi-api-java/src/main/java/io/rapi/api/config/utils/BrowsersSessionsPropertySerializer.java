package main.java.io.rapi.api.config.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class BrowsersSessionsPropertySerializer<T> extends StdSerializer<T> {

    public BrowsersSessionsPropertySerializer() {
        this(null);
    }

    public BrowsersSessionsPropertySerializer(Class<T> t) {
        super(t);
    }

    @Override
    public void serialize(T data, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartArray();
        jgen.writeObject(data);
        jgen.writeEndArray();
    }
}
