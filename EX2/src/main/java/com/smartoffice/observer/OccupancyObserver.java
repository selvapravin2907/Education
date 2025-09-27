package com.smartoffice.observer;

import com.smartoffice.core.MeetingRoom;

public interface OccupancyObserver {
    void onOccupancyChange(MeetingRoom room, boolean isOccupied);
}