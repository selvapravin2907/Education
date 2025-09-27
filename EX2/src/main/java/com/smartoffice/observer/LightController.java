package com.smartoffice.observer;

import com.smartoffice.core.MeetingRoom;

public class LightController implements OccupancyObserver {
    @Override
    public void onOccupancyChange(MeetingRoom room, boolean isOccupied) {
        if (isOccupied) {
            System.out.println("Lights ON for " + room.getName());
        } else {
            System.out.println("Lights OFF for " + room.getName());
        }
    }
}