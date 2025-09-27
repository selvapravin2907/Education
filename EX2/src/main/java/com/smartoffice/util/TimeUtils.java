package com.smartoffice.util;

import java.time.LocalTime;

public class TimeUtils {
    public static boolean isAfterNow(LocalTime t) {
        return t.isAfter(LocalTime.now());
    }
}