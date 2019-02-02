package ru.ilka.jogger.entity;

public enum Role {
    ADMIN(1, "ADMIN"),
    USER(2, "USER");

    private final Integer id;
    private final String name;

    Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
