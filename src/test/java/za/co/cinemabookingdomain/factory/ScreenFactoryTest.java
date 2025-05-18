package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.Domain.Screen;
import static org.junit.jupiter.api.Assertions.*;

public class ScreenFactoryTest {
    @Test
    public void testCreateScreen() {

        Screen screen = ScreenFactory.createScreen("3D", 200, 6);

        assertEquals("3D", screen.getType());
        assertEquals(200, screen.getCapacity());
        assertEquals(6, screen.getScreenNumber());
    }


}
