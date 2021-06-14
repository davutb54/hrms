package com.davutbudak.hrms.entities.enums;

public enum WorkPlace {
    OFFICE("Office"),
    REMOTE("Remote");

    private String name;

    WorkPlace(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
