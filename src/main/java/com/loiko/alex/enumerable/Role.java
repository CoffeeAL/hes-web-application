package com.loiko.alex.enumerable;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
public enum Role {

    ADMIN("Admin"),
    USER("User");

    String name;

    Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{name = " + name + "}";
    }
}