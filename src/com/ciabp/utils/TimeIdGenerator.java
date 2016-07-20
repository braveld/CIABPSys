package com.ciabp.utils;

public class TimeIdGenerator {

    private static int seq = 0;
    private static final int MAX = 5555;

    public static synchronized long generateId() {
    	seq++;
    	if (seq >= MAX) {
            seq = 0;
        }
        return System.currentTimeMillis()*MAX+seq;
    }
}
