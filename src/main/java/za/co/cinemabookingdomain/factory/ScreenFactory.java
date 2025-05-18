package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Screen;

public class ScreenFactory {
    public static Screen createScreen(String type, int capacity, int screenNumber){
        return new Screen.Builder()
                .setType()
                .setCapacity()
                .setScreenNumber()
                .build();

    }
}
