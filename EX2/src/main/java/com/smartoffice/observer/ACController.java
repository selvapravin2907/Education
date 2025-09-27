package com.smartoffice.observer;

import com.smartoffice.core.MeetingRoom;

public class ACController implements OccupancyObserver {
    @Override
    public void onOccupancyChange(MeetingRoom room, boolean isOccupied) {
        if (isOccupied) {
            System.out.println("AC ON for " + room.getName());
        } else {
            System.out.println("AC OFF for " + room.getName());
        }
    }
}