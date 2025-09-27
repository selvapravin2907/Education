package com.smartoffice.command;

import com.smartoffice.core.OfficeConfig;
import com.smartoffice.core.MeetingRoom;

public class CancelRoomCommand implements Command {
    private final int roomNum;

    public CancelRoomCommand(int roomNum) {
        this.roomNum = roomNum;
    }

    @Override
    public void execute() {
        MeetingRoom room = OfficeConfig.getInstance().getRoom(roomNum);
        if (room == null) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return;
        }
        room.cancelBooking();
    }
}