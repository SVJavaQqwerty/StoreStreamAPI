package dto;

import dataSources.authorization.utils.Password;
import entitys.User;
import enums.Role;

public class UserDto {
    private String login;
    private String name;
    private Role role;
    private Password password;

    public UserDto() {
    }

    public UserDto(String login, String name, String role, Password password) {
        this.login = login;
        this.name = name;
        this.role = Role.valueOf(role);
        this.password = password;
    }

    public UserDto(User user, String password) {
        this.login = user.getLogin();
        this.name = user.getName();
        this.role = user.getRole();
        this.password = new Password(password);
    }

    public UserDto(User user) {
        this.login = user.getLogin();
        this.name = user.getName();
        this.role = user.getRole();
    }



    public User getUser() {
        return new User(this.getLogin(), this.name, this.role);
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public Password getPassword() {
        return password;
    }
}
