package views.pages.userView;

import dto.OrderDto;
import services.ServiceBasket;
import services.ServiceOrder;
import views.TerminalView;

import java.util.ArrayList;
import java.util.Scanner;

public class UserOrderView extends TerminalView {

    private final ServiceBasket serviceBasket;
    private final ServiceOrder serviceOrder;
    public UserOrderView(ServiceBasket serviceBasket, ServiceOrder serviceOrder) {
        super("Оформление заказа", new ArrayList<TerminalView>());
        this.serviceBasket = serviceBasket;
        this.serviceOrder = serviceOrder;
    }

    @Override
    public void action() {

        OrderDto order = new OrderDto();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваше имя: ");
        order.setName(scanner.nextLine());
        System.out.println("Введите ваш телефон: ");
        order.setPhone(scanner.nextLine());
        System.out.println("Введите желаемое время доставки: ");
        order.setDeliveryTime(scanner.nextLine());
        System.out.println("Введите адрес доставки: ");
        order.setAddress(scanner.nextLine());
        System.out.println("Введите способ оплаты: ");
        order.setPaymentType(scanner.nextLine());
        order.setBasket(serviceBasket.getAllProductBasket());
        serviceOrder.createOrder(order);

    }
}
