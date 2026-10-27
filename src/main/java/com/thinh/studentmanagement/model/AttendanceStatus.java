package com.thinh.studentmanagement.model;

public enum AttendanceStatus {
    PRESENT,
    LATE,
    EARLY_LEAVE,
    ABSENT,
    OFFICAL_ABSENCE;

    public String getJapaneseName() {
        switch (this) {
            case PRESENT:
                return "出席";
            case LATE:
                return "遅刻";
            case EARLY_LEAVE:
                return "早退";
            case ABSENT:
                return "欠席";
            case OFFICAL_ABSENCE:
                return "公欠";
            default:
                return "";
        }
    }
}