package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.exception.InvalidInputException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
/**
 * Skeleton template for a controller test using MockMvc.
 *
 * You can use annotations from JUnit 5 such as @ParameterizedTest, @ValueSauce,
 * @CsvSource and @MethodSource for your test data.
 *
 * Example usage of mockMvc for a GET request
 * mockMvc.perform(get("/path-to-your-endpoint").param("your-query-param", param-value))
 *                 .andExpect(status().whateverStatusCodeYouExpect())
 *                 .andExpect(content().string("string-you-expect-in-response")).
 *                 .andExpect(jsonPath("$.jsonField").value("json-value-you-expect"));
 */
@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerTest {
    @Autowired
    private MockMvc mockMvc;

        @Test
        public void testRemoveFirstLastCharacter_eloquent() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/remove").param("originalString", "eloquent"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("loquen"));
        }

        @Test
        public void testRemoveFirstLastCharacter_country() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/remove").param("originalString", "country"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("ountr"));
        }

        @Test
        public void testRemoveFirstLastCharacter_person() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/remove").param("originalString", "person"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("erso"));
        }

        @Test
        public void testRemoveFirstLastCharacter_twoChars() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/remove").param("originalString", "ab"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(""));
        }

        @Test
        public void testRemoveFirstLastCharacter_threeChars() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/remove").param("originalString", "xyz"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("y"));
        }

        @Test
        public void testRemoveFirstLastCharacter_specialChars() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/remove").param("originalString", "123%qwerty+"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("23%qwerty"));
        }

        @Test
        public void testRemoveFirstLastCharacter_singleChar() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/remove").param("originalString", "a"))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void testRemoveFirstLastCharacter_emptyString() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/remove").param("originalString", ""))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void testRemoveFirstLastCharacter_nullString() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/remove"))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }
    }

