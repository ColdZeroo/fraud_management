package com.lacentrale.fraudmanagement.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.model.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class JsonIO {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public Advertisement readJsonFile() {
        objectMapper.registerModule(new Jdk8Module());
        try {
            ClassLoader classLoader = JsonIO.class.getClassLoader();
            InputStream resource = classLoader.getResourceAsStream("annonce.json");
            if (resource != null)
                return objectMapper.readValue(resource, Advertisement.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String writeResponse(Response response) {
        try {
            return objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
