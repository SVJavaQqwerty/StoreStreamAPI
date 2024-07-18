package views.pages.userView;

import services.ServiceProduct;
import views.TerminalView;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomCategorySelection extends TerminalView {

    private ServiceProduct serviceProduct;

    public CustomCategorySelection(ServiceProduct serviceProduct, ArrayList<TerminalView> actions) {
        super("Выберите категорию(каталог)", actions);
        this.serviceProduct = serviceProduct;
    }

    @Override
    public void action() {
        ArrayList<String> category = new ArrayList<>(serviceProduct.getCategory());

        for (int i = 0; i < category.size(); i++) {
            System.out.println((i + 1) + " - " + category.get(i));
        }

        System.out.println((category.size() + 1) + " - без категории");

        Scanner scanner = new Scanner(System.in);


        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index == category.size()){
            super.setCategory("");
        } else {
        super.setCategory(category.get(index));
        }

        System.out.println("Выйти из меню любой символ");
    }
}
