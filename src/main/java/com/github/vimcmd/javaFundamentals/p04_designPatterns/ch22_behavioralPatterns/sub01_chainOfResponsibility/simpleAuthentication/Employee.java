package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub01_chainOfResponsibility.simpleAuthentication;

// # 5 # class, which message entity will be handled

public class Employee {

    private int id;
    private String login;
    private String password;

    public Employee(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        int result = id + ((login == null) ? 0 : login.hashCode());
        result = 31 * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Employee other = (Employee) obj; // NOTE: possible ClassCastException!
        if (id != other.id) {
            return false;
        }
        if (login == null && other.login != null) {
            return false;
        } else if (!login.equals(other.getLogin())) {
            return false;
        }

        if (password == null && other.getPassword() != null) {
            return false;
        } else if (!password.equals(other.getPassword())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
