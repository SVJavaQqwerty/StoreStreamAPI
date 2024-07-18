package views.pages.adminView;

import dto.ProductDto;
import services.ServiceProduct;
import views.TerminalView;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminAddProductView extends TerminalView {

    private final ServiceProduct serviceProduct;

    public AdminAddProductView(ServiceProduct serviceProduct, ArrayList<TerminalView> actions) {
        super("Добавить новый товар", actions);
        this.serviceProduct = serviceProduct;
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);

        ProductDto productDto = new ProductDto();
        System.out.println("Введите название продукта: ");
        productDto.setName(scanner.nextLine());

        System.out.println("Введите описание продукта: ");
        productDto.setDescription(scanner.nextLine());

        System.out.println("Видимость продукта в каталоге: ");
        productDto.setAvailability(Boolean.valueOf(scanner.nextLine()));

        System.out.println("Введите количество доступного продукта: ");
        productDto.setCount(Integer.parseInt(scanner.nextLine()));

        System.out.println("Введите стоимость продукта: ");
        productDto.setPrice(Integer.parseInt(scanner.nextLine()));

        System.out.println("Введите категорию продукта: ");
        productDto.setCategory(scanner.nextLine());

        serviceProduct.setProductDataBase(productDto);

    }
}
