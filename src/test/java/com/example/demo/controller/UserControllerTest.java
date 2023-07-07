package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:test.properties")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final static String VALID_PASSWORD = "abcd123";

    private final static String INVALID_PASSWORD = "abCD%EF1";

    private final static String ACCOUNT = "account";

    private final static String PASSWORD = "password";

    private final static String SUCCESS = "success";

    private final static String REGISTER_URL = "/api/user";

    private final static ObjectMapper mapper = new ObjectMapper();

    private static String validRequest;

    private static String invalidRequest;

    @BeforeAll
    public static void setup() throws JsonProcessingException {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put(ACCOUNT, "test@gmail.com");
        reqMap.put(PASSWORD, VALID_PASSWORD);

        validRequest = mapper.writeValueAsString(reqMap);

        reqMap.put(PASSWORD, INVALID_PASSWORD);
        invalidRequest = mapper.writeValueAsString(reqMap);
    }

    @Test
    public void register_with_valid_password() throws Exception {
        this.mockMvc.perform(buildRequest(validRequest))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(SUCCESS)));
    }

    @Test
    public void register_with_invalid_password() throws Exception {
        this.mockMvc.perform(buildRequest(invalidRequest))
                .andExpect(status().isBadRequest());
    }

    private RequestBuilder buildRequest(String req) {
        return post(REGISTER_URL).content(req).contentType(MediaType.APPLICATION_JSON);
    }

}
