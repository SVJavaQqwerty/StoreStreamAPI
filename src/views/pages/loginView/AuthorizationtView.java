package views.pages.loginView;

import dataSources.authorization.Authentication;
import dataSources.authorization.AuthenticationImpl;
import dto.UserDto;
import enums.Role;
import views.TerminalView;

import java.util.ArrayList;
import java.util.Scanner;

public class AuthorizationtView extends TerminalView {

    UserDto user;
    ArrayList<TerminalView> actionUser;
    ArrayList<TerminalView> actionAdmin;

    public AuthorizationtView(ArrayList<TerminalView> actionUser, ArrayList<TerminalView> actionAdmin) {
        super("Авторизация", new ArrayList<>());
        this.actionAdmin = actionAdmin;
        this.actionUser = actionUser;
    }

    @Override
    public void action() {
        Authentication auth = new AuthenticationImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();


        user = auth.getUser(login, password);

        if(Role.ADMIN == user.getRole()) {
            super.actions = actionAdmin;
        } else {
            super.actions = actionUser;
        }
    }

}
