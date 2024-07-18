package controllers;

import dataSources.authorization.Authentication;
import dataSources.authorization.AuthenticationImpl;
import dto.UserDto;
import entitys.User;

import java.util.Scanner;

public class TerminalController {

    public static UserDto registration() {
        Authentication auth = new AuthenticationImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите ваше имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите роль (ADMIN | USER): "); // бутофория, не получаетя считаь роль для загрузки нужной ветки
        String role = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        return auth.setUser(new User(login, name , role), password);
    }
}
