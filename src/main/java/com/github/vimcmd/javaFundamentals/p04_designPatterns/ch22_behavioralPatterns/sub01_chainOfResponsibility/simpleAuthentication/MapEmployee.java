package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub01_chainOfResponsibility.simpleAuthentication;

import java.util.HashMap;

// # 6 # map of handled entity implementations

public class MapEmployee {

    private HashMap<Integer, Employee> users = new HashMap<>();

    public MapEmployee() {
        users.put(1, new Employee(10, "admin", "veryStrongPassword1"));
        users.put(2, new Employee(20, "employee", "moderatePassword2"));
        users.put(3, new Employee(30, "user", "qwerty"));
    }

    public HashMap<Integer, Employee> getUsers() {
        return users;
    }

    public boolean containsUser(Employee employee) {
        return users.containsValue(employee);
    }
}
