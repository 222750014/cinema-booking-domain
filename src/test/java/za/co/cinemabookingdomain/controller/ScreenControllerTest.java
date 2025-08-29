package za.co.cinemabookingdomain.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.cinemabookingdomain.Domain.Screen;
import za.co.cinemabookingdomain.Service.ScreenService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest (ScreenController.class)
    public class ScreenControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private ScreenService screenService;

        @Autowired
        private ObjectMapper objectMapper;

        private Screen screen1;
        private Screen screen2;

        @BeforeEach
        public void setup() {
            screen1 = new Screen.Builder()
                    .setType("3D")
                    .setCapacity(200)
                    .setScreenNumber(6)
                    .build();

            screen2 = new Screen.Builder()
                    .setType("Standard")
                    .setCapacity(200)
                    .setScreenNumber(4)
                    .build();
        }

        @Test
        public void testGetAllScreens() throws Exception {
            List<Screen> screens = Arrays.asList(screen1, screen2);

            when(screenService.getAllScreens()).thenReturn(screens);

            mockMvc.perform(get("/api/screens"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()", is(screens.size())))
                    .andExpect(jsonPath("$[0].type", is(screen1.getType())))
                    .andExpect(jsonPath("$[1].capacity", is(screen2.getCapacity())));
        }

        @Test
        public void testGetScreenById_found() throws Exception {
            when(screenService.getScreenById(1L)).thenReturn(Optional.of(screen1));

            mockMvc.perform(get("/api/screens/{id}", 1))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.type", is(screen1.getType())))
                    .andExpect(jsonPath("$.capacity", is(screen1.getCapacity())));
        }

        @Test
        public void testGetScreenById_notFound() throws Exception {
            when(screenService.getScreenById(99L)).thenReturn(Optional.empty());

            mockMvc.perform(get("/api/screens/{id}", 99))
                    .andExpect(status().isNotFound());
        }

        @Test
        public void testCreateScreen() throws Exception {
            when(screenService.saveScreen(any(Screen.class))).thenReturn(screen1);

            mockMvc.perform(post("/api/screens")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(screen1)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.type", is(screen1.getType())))
                    .andExpect(jsonPath("$.capacity", is(screen1.getCapacity())));
        }

        @Test
        public void testDeleteScreen_found() throws Exception {
            when(screenService.getScreenById(1L)).thenReturn(Optional.of(screen1));

            mockMvc.perform(delete("/api/screens/{id}", 1))
                    .andExpect(status().isNoContent());
        }

        @Test
        public void testDeleteScreen_notFound() throws Exception {
            when(screenService.getScreenById(99L)).thenReturn(Optional.empty());

            mockMvc.perform(delete("/api/screens/{id}", 99))
                    .andExpect(status().isNotFound());
        }

        @Test
        public void testGetScreensByType() throws Exception {
            List<Screen> imaxScreens = Arrays.asList(screen1);

            when(screenService.getScreensByType("3D")).thenReturn(3DScreens);

            mockMvc.perform(get("/api/screens/type/{type}", "3D"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()", is(3DScreens.size())))
                    .andExpect(jsonPath("$[0].type", is("3D")));
        }
    }


