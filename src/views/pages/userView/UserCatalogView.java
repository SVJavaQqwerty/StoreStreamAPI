package views.pages.userView;

import dataSources.comporators.AppComporator;
import dataSources.comporators.PriceComporator;
import dataSources.predicates.PredicateProductAvailable;
import dto.ProductDto;
import services.ServiceProduct;
import views.PageNable;
import views.TerminalView;

import java.util.ArrayList;
import java.util.Objects;

public class UserCatalogView extends TerminalView implements PageNable {

    final ServiceProduct serviceProduct;


    public UserCatalogView(ServiceProduct serviceProduct, ArrayList<TerminalView> action, ArrayList<AppComporator<ProductDto>> comporators) {
        super("Каталог", action);
        this.serviceProduct = serviceProduct;
        availableComporators.addAll(comporators);
        if(!availableComporators.isEmpty()) {
            selectedComparator = availableComporators.get(0);
        }
    }

    @Override
    public void action() {
        PriceComporator comporator = new PriceComporator();
        PredicateProductAvailable predicate = new PredicateProductAvailable();
        ArrayList<ProductDto> catalog = new ArrayList<>();
        if(!Objects.equals(this.getCategory(), "")){
            catalog = (ArrayList<ProductDto>) serviceProduct.getAllProductDataBase(this.getNowPage(), pageLimit, selectedComparator.getComparator(), predicate, getCategory());
        } else {
            catalog = (ArrayList<ProductDto>) serviceProduct.getAllProductDataBase(this.getNowPage(), pageLimit, selectedComparator.getComparator(), predicate);
        }
        hesNextPage = catalog.size() == pageLimit;

        catalog.stream().forEach(System.out::println);
        System.out.println();
    }

}
