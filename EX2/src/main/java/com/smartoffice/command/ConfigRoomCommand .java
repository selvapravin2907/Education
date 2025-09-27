package com.smartoffice.command;

import com.smartoffice.core.OfficeConfig;

public class ConfigRoomCommand implements Command {
    private final int count;

    public ConfigRoomCommand(int count) {
        this.count = count;
    }

    @Override
    public void execute() {
        if (count < 1) {
            System.out.println("Invalid room count. Please enter a valid positive number.");
            return;
        }
        OfficeConfig.getInstance().configureRooms(count);
    }
}