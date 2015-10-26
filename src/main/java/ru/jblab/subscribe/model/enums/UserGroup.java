package ru.jblab.subscribe.model.enums;

/**
 * Created by ainurminibaev on 26.08.14.
 */
public enum UserGroup {
    ADMIN("Администратор", 1), ELDER("Староста", 2), STUDENT("Студент", 3);
    String title;
    int level;

    UserGroup(String title, int level) {
        this.title = title;
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public int getLevel() {
        return level;
    }
}
