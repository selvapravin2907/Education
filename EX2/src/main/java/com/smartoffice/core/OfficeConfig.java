package com.smartoffice.core;

import java.util.*;

public class OfficeConfig {
    private static OfficeConfig instance;
    private Map<Integer, MeetingRoom> rooms = new HashMap<>();
    private int maxRoomCapacity = 10; // Default

    private OfficeConfig() {}

    public static synchronized OfficeConfig getInstance() {
        if (instance == null) instance = new OfficeConfig();
        return instance;
    }

    public void configureRooms(int count) {
        rooms.clear();
        for (int i = 1; i <= count; i++) {
            rooms.put(i, new MeetingRoom(i, "Room " + i, maxRoomCapacity));
        }
        System.out.printf("Office configured with %d meeting rooms:\n", count);
        for (int i = 1; i <= count; i++) {
            System.out.print("Room " + i);
            if (i < count) System.out.print(", ");
        }
        System.out.println(".");
    }

    public void setRoomMaxCapacity(int roomNum, int capacity) {
        MeetingRoom room = rooms.get(roomNum);
        if (room == null) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return;
        }
        if (capacity < 1) {
            System.out.println("Invalid capacity. Please enter a valid positive number.");
            return;
        }
        room.setMaxCapacity(capacity);
        System.out.printf("Room %d maximum capacity set to %d.\n", roomNum, capacity);
    }

    public MeetingRoom getRoom(int roomNum) {
        return rooms.get(roomNum);
    }

    public Collection<MeetingRoom> getAllRooms() {
        return rooms.values();
    }

    public boolean roomExists(int roomNum) {
        return rooms.containsKey(roomNum);
    }
}