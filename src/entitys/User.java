package entitys;

import enums.Role;

public class User {
    private String login;
    private String name;
    private Role role;


    public User(String login, String role) {
        this.login = login;
        this.role = Role.valueOf(role);

    }

    public User(String login, Role role) {
        this.login = login;
        this.role = role;
    }

    public User(String login, String name, String role) {
        this.login = login;
        this.name = name;
        this.role = Role.valueOf(role);

    }

    public User(String login, String name, Role role) {
        this.login = login;
        this.name = name;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = Role.valueOf(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

