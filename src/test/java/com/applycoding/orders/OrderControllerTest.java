package com.applycoding.orders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired MockMvc mvc;

    @Test
    void createsAndFetchesOrder() throws Exception {
        mvc.perform(post("/api/orders").contentType(MediaType.APPLICATION_JSON)
                .content("{\"item\":\"widget\",\"quantity\":2}"))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.item").value("widget"));
        mvc.perform(get("/api/orders")).andExpect(status().isOk());
    }

    @Test
    void rejectsInvalidOrder() throws Exception {
        mvc.perform(post("/api/orders").contentType(MediaType.APPLICATION_JSON)
                .content("{\"item\":\"\",\"quantity\":0}"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void returns404ForMissingOrder() throws Exception {
        mvc.perform(get("/api/orders/999")).andExpect(status().isNotFound());
    }
}
