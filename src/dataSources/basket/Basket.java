package dataSources.basket;

import dto.ProductDto;

import java.util.ArrayList;

public interface Basket {

    void setProductBasket(ProductDto product);

    void deleteProductBasket(ProductDto product);

    ArrayList<ProductDto> getAllProductBasket();
}
