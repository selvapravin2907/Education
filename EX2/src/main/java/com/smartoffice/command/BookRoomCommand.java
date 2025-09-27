package com.smartoffice.command;

import com.smartoffice.core.OfficeConfig;
import com.smartoffice.core.MeetingRoom;

public class BookRoomCommand implements Command {
    private final int roomNum;
    private final String time;
    private final int duration;

    public BookRoomCommand(int roomNum, String time, int duration) {
        this.roomNum = roomNum;
        this.time = time;
        this.duration = duration;
    }

    @Override
    public void execute() {
        MeetingRoom room = OfficeConfig.getInstance().getRoom(roomNum);
        if (room == null) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return;
        }
        room.book(time, duration);
    }
}