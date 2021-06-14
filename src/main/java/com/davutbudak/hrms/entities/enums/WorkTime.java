package com.davutbudak.hrms.entities.enums;

public enum WorkTime {
    FULL_TIME("Full time"),
    PART_TIME("Part time");

    private String name;

    WorkTime(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
