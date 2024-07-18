package views.pages.userView;

import services.ServiceBasket;
import views.TerminalView;

import java.util.ArrayList;
import java.util.Scanner;

public class UserAddToBasket extends TerminalView {
    final ServiceBasket serviceBasket;

    public UserAddToBasket(ServiceBasket serviceBasket) {
        super("Добавление в корзину", new ArrayList<>());
        this.serviceBasket = serviceBasket;
    }


    @Override
    public void action() {
        System.out.println("Введите id продукта");
        Scanner scanner = new Scanner(System.in);
        Integer id = Integer.valueOf(scanner.nextLine());

        System.out.println("Введите количество продукта");
        Integer count = Integer.valueOf(scanner.nextLine());
        serviceBasket.setProductBasket(id, count);

    }
}
