package com.smartoffice.command;

import com.smartoffice.core.OfficeConfig;

import java.util.regex.*;

public class CommandInvoker {
    public void executeCommand(String input) {
        input = input.trim();
        try {
            if (input.startsWith("Config room count")) {
                Matcher m = Pattern.compile("Config room count (\\d+)").matcher(input);
                if (m.matches()) {
                    new ConfigRoomCommand(Integer.parseInt(m.group(1))).execute();
                }
            } else if (input.startsWith("Config room max capacity")) {
                Matcher m = Pattern.compile("Config room max capacity (\\d+) (\\d+)").matcher(input);
                if (m.matches()) {
                    int roomNum = Integer.parseInt(m.group(1));
                    int cap = Integer.parseInt(m.group(2));
                    OfficeConfig.getInstance().setRoomMaxCapacity(roomNum, cap);
                }
            } else if (input.startsWith("Block room")) {
                Matcher m = Pattern.compile("Block room (\\d+) (\\d{2}:\\d{2}) (\\d+)").matcher(input);
                if (m.matches()) {
                    int roomNum = Integer.parseInt(m.group(1));
                    String time = m.group(2);
                    int dur = Integer.parseInt(m.group(3));
                    new BookRoomCommand(roomNum, time, dur).execute();
                }
            } else if (input.startsWith("Cancel room")) {
                Matcher m = Pattern.compile("Cancel room (\\d+)").matcher(input);
                if (m.matches()) {
                    int roomNum = Integer.parseInt(m.group(1));
                    new CancelRoomCommand(roomNum).execute();
                }
            } else if (input.startsWith("Add occupant")) {
                Matcher m = Pattern.compile("Add occupant (\\d+) (\\d+)").matcher(input);
                if (m.matches()) {
                    int roomNum = Integer.parseInt(m.group(1));
                    int occ = Integer.parseInt(m.group(2));
                    new AddOccupantCommand(roomNum, occ).execute();
                }
            } else if (input.equalsIgnoreCase("status")) {
                OfficeConfig.getInstance().getAllRooms().forEach(r -> {
                    System.out.printf("%s: booked=%s, occupants=%d\n", r.getName(), r.getBooking() != null, r.getOccupants());
                });
            } else {
                System.out.println("Unknown command.");
            }
        } catch (Exception e) {
            System.out.println("Error processing command: " + e.getMessage());
        }
    }
}