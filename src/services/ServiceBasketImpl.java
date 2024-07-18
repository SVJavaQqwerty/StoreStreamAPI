package services;

import dataSources.basket.Basket;
import dataSources.basket.BasketImpl;
import dto.ProductDto;

import java.util.ArrayList;

public class ServiceBasketImpl implements ServiceBasket{

    Basket basket = new BasketImpl();
    ServiceProduct serviceProduct = new ServiceProductImpl();

    @Override
    public void setProductBasket(Integer id, Integer count) {
        basket.setProductBasket(new ProductDto(serviceProduct.getProduct(id).getProduct(), count));
    }

    @Override
    public void deleteProductBasket(Integer id, Integer count) {

    }

    @Override
    public ArrayList<ProductDto> getAllProductBasket() {
        return basket.getAllProductBasket();
    }
}
