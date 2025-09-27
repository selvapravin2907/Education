package com.smartoffice.core;

import com.smartoffice.observer.*;

import java.time.LocalTime;
import java.util.*;

public class MeetingRoom extends OccupancySubject {
    private int id;
    private String name;
    private int maxCapacity;
    private int occupants = 0;
    private Booking currentBooking;

    public MeetingRoom(int id, String name, int maxCapacity) {
        this.id = id;
        this.name = name;
        this.maxCapacity = maxCapacity;
        addObserver(new LightController());
        addObserver(new ACController());
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int capacity) { this.maxCapacity = capacity; }
    public int getOccupants() { return occupants; }
    public Booking getBooking() { return currentBooking; }
    public boolean isOccupied() { return occupants >= 2; }

    public boolean book(String start, int durationMins) {
        if (currentBooking != null && !currentBooking.isExpired()) {
            System.out.println(name + " is already booked during this time. Cannot book.");
            return false;
        }
        currentBooking = new Booking(this, start, durationMins);
        System.out.printf("%s booked from %s for %d minutes.\n", name, start, durationMins);
        return true;
    }

    public boolean cancelBooking() {
        if (currentBooking == null || currentBooking.isExpired()) {
            System.out.println(name + " is not booked. Cannot cancel booking.");
            return false;
        }
        currentBooking = null;
        System.out.printf("Booking for %s cancelled successfully.\n", name);
        return true;
    }

    public void addOccupants(int count) {
        if (count < 0 || count > maxCapacity) {
            System.out.println("Invalid occupant count.");
            return;
        }
        occupants = count;
        if (isOccupied()) {
            System.out.printf("%s is now occupied by %d persons. AC and lights turned on.\n", name, occupants);
        } else if (occupants == 0) {
            System.out.printf("%s is now unoccupied. AC and lights turned off.\n", name);
            if (currentBooking != null && !currentBooking.isExpired()) {
                System.out.printf("%s is now unoccupied. Booking released. AC and lights off.\n", name);
                currentBooking = null;
            }
        } else {
            System.out.printf("%s occupancy insufficient to mark as occupied.\n", name);
        }
        notifyObservers(isOccupied());
    }

    public void checkAutoRelease() {
        if (currentBooking != null && !currentBooking.isExpired() && !isOccupied()) {
            if (currentBooking.isAutoReleaseDue()) {
                System.out.printf("%s is now unoccupied. Booking released. AC and lights off.\n", name);
                currentBooking = null;
                notifyObservers(false);
            }
        }
    }
}