package dataSources.dataCatalog;

import dataSources.predicates.PredicateProductAvailable;
import dto.ProductDto;
import entitys.Product;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public interface DataToStore {
    // Вернуть продукт по ID
    ProductDto getProductById(Integer id);

    // Вернуть продукты каталога
    List<ProductDto> getProducts(Integer page, Integer strings, Comparator<ProductDto> comparator, PredicateProductAvailable predicate, String category);

    List<ProductDto> getProducts(Integer page, Integer strings, Comparator<ProductDto> comparator, Predicate<ProductDto> predicate);

    List<ProductDto> getProducts(Integer page, Integer strings, Comparator<ProductDto> comparator);

    List<ProductDto> getProducts(Integer page, Integer strings);
    // изменить количество продуктов в каталоге (добавление в карзину, возврат из корзины, поступление на реализацию)
    // count может быть +/-

    boolean changeQuantity(Integer id, Integer count);
    // Добавить новый продукт

    boolean setProduct(ProductDto product);
    // Существует ли продукт с таким ID

    boolean isProductById(Integer id);
    // Доступность продукта по Id

    boolean getAvailabilityById(Integer id);

    List<String> getUniqCategory();
}
