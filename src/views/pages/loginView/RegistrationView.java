package views.pages.loginView;

import controllers.TerminalController;
import dto.UserDto;
import enums.Role;
import views.TerminalView;

import java.util.ArrayList;

public class RegistrationView extends TerminalView {

    UserDto user;
    ArrayList<TerminalView> actionUser;
    ArrayList<TerminalView> actionAdmin;

    public RegistrationView(ArrayList<TerminalView> actionUser, ArrayList<TerminalView> actionAdmin) {
        super("Регистрация", new ArrayList<>());
        this.actionAdmin = actionAdmin;
        this.actionUser = actionUser;
    }


    public void action() {
        UserDto user = TerminalController.registration();
        if (user != null) {
            if (Role.ADMIN == user.getRole()) {
                super.actions = actionAdmin;
            } else {
                super.actions = actionUser;
            }
        }
    }
}
