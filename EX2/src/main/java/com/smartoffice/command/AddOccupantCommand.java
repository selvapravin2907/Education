package com.smartoffice.command;

import com.smartoffice.core.OfficeConfig;
import com.smartoffice.core.MeetingRoom;

public class AddOccupantCommand implements Command {
    private final int roomNum;
    private final int occupantCount;

    public AddOccupantCommand(int roomNum, int occupantCount) {
        this.roomNum = roomNum;
        this.occupantCount = occupantCount;
    }

    @Override
    public void execute() {
        MeetingRoom room = OfficeConfig.getInstance().getRoom(roomNum);
        if (room == null) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return;
        }
        room.addOccupants(occupantCount);
    }
}