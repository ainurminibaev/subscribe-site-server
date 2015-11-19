package ru.jblab.subscribe.model.enums;

/**
 * Created by ainurminibaev on 19.11.15.
 */
public enum ArchiveType {
    A1("Портал");

    private String name;

    ArchiveType(String val) {
        name = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
