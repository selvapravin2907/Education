package com.smartoffice.core;

import java.time.*;
import com.smartoffice.util.TimeUtils;

public class Booking {
    private MeetingRoom room;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean expired = false;
    private Instant createdAt;

    public Booking(MeetingRoom room, String start, int durationMinutes) {
        this.room = room;
        this.startTime = LocalTime.parse(start);
        this.endTime = startTime.plusMinutes(durationMinutes);
        this.createdAt = Instant.now();
    }

    public boolean isExpired() {
        return LocalTime.now().isAfter(endTime) || expired;
    }

    public boolean isAutoReleaseDue() {
        // If not occupied within 5 mins, auto-release
        return Duration.between(createdAt, Instant.now()).toMinutes() >= 5;
    }
}