package services;

import dataSources.predicates.PredicateProductAvailable;
import dto.ProductDto;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface ServiceProduct {

    ProductDto getProduct(Integer id);

    void setProductDataBase(ProductDto product);

    List<ProductDto> getAllProductDataBase(Integer page, Integer strings);

    List<ProductDto> getAllProductDataBase(Integer page, Integer strings, Comparator<ProductDto> comparator);

    List<ProductDto> getAllProductDataBase(Integer page, Integer strings, Comparator<ProductDto> comparator, Predicate<ProductDto> predicate);

    List<ProductDto> getAllProductDataBase(Integer page, Integer limit, Comparator<ProductDto> comparator, PredicateProductAvailable predicate, String category);

    void addCountByIdProduct(Integer id, Integer count);

    void putCountByIdProduct(Integer id, Integer count);

    List<String> getCategory();
}
