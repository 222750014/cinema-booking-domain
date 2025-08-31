package za.co.cinemabookingdomain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import za.co.cinemabookingdomain.domain.Screen;
import za.co.cinemabookingdomain.service.ScreenService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ScreenController.class)
public class ScreenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ScreenService screenService; // pure Mockito mock

    @Autowired
    private ObjectMapper objectMapper;

    private Screen screen1;
    private Screen screen2;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize @Mock

        screen1 = new Screen.Builder()
                .setType("3D")
                .setCapacity(200)
                .setScreenNumber(6)
                .build();

        screen2 = new Screen.Builder()
                .setType("Standard")
                .setCapacity(150)
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
        doNothing().when(screenService).deleteScreenById(1L);

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
        List<Screen> screens3D = Arrays.asList(screen1);
        when(screenService.getScreensByType("3D")).thenReturn(screens3D);

        mockMvc.perform(get("/api/screens/type/{type}", "3D"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(screens3D.size())))
                .andExpect(jsonPath("$[0].type", is("3D")));
    }
}
