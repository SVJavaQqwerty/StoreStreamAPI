package services;

import dto.ProductDto;

import java.util.ArrayList;

public interface ServiceBasket {

    void setProductBasket(Integer id, Integer count);

    void deleteProductBasket(Integer id, Integer count);

    ArrayList<ProductDto> getAllProductBasket();

}
