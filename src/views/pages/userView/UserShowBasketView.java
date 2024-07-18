package views.pages.userView;

import services.ServiceBasket;
import views.TerminalView;

import java.util.ArrayList;

public class UserShowBasketView extends TerminalView {

    private final ServiceBasket basket;

    public UserShowBasketView(ServiceBasket basket) {
        super("Просмотр корзины", new ArrayList<TerminalView>());
        this.basket = basket;
    }

    @Override
    public void action() {
        basket.getAllProductBasket().stream().forEach(System.out::println);
    }
}
