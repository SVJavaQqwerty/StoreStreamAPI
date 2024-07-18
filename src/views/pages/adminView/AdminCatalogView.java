package views.pages.adminView;

import dto.ProductDto;
import services.ServiceProduct;
import views.PageNable;
import views.TerminalView;

import java.util.ArrayList;

public class AdminCatalogView extends TerminalView implements PageNable {

    final ServiceProduct serviceProduct;

    public AdminCatalogView(ServiceProduct serviceProduct) {
        super("Каталог", new ArrayList<>());
        this.serviceProduct = serviceProduct;
    }

    @Override
    public void action() {
        ArrayList<ProductDto> catalog = (ArrayList<ProductDto>) serviceProduct.getAllProductDataBase(this.getNowPage(), pageLimit);

        hesNextPage = catalog.size() == pageLimit;

        catalog.forEach(System.out::println);
        System.out.println();

    }

}
