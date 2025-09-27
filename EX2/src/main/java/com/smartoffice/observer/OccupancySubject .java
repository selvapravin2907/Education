package com.smartoffice.observer;

import com.smartoffice.core.MeetingRoom;
import java.util.*;

public class OccupancySubject {
    private List<OccupancyObserver> observers = new ArrayList<>();
    public void addObserver(OccupancyObserver obs) { observers.add(obs); }
    public void notifyObservers(boolean isOccupied) {
        for (OccupancyObserver obs : observers) {
            obs.onOccupancyChange((MeetingRoom)this, isOccupied);
        }
    }
}