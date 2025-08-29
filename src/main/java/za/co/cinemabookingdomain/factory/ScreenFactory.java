package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Screen;

public class ScreenFactory {
    public static Screen createScreen(String type, int capacity, int screenNumber){
        if (type==null || type.isEmpty()){
            return null;
        }
        if (capacity > 0 ){
            return null;
        }
        if (screenNumber > 0 ){
            return null;
        }
        return new Screen.Builder()
                .setType(type)
                .setCapacity(capacity)
                .setScreenNumber(screenNumber)
                .build();
    }
}