package services;

import dataSources.dataCatalog.DataToStore;
import dataSources.dataCatalog.ProductFromMapImpl;
import dataSources.predicates.PredicateProductAvailable;
import dto.ProductDto;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ServiceProductImpl implements ServiceProduct{

    DataToStore data = new ProductFromMapImpl();



    @Override
    public void setProductDataBase(ProductDto product) {
        data.setProduct(product);
    }

    @Override
    public List<ProductDto> getAllProductDataBase(Integer page, Integer strings) {
        return data.getProducts(page, strings);
    }

    @Override
    public List<ProductDto> getAllProductDataBase(Integer page, Integer strings, Comparator<ProductDto> comparator){
        return data.getProducts(page, strings, comparator);
    }

    @Override
    public List<ProductDto> getAllProductDataBase(Integer page, Integer strings, Comparator<ProductDto> comparator, Predicate<ProductDto> predicate){
        return data.getProducts(page, strings, comparator, predicate);
    }

    @Override
    public List<ProductDto> getAllProductDataBase(Integer page, Integer strings, Comparator<ProductDto> comparator, PredicateProductAvailable predicate, String category) {
        return data.getProducts(page, strings, comparator, predicate, category);
    }

    @Override
    public ProductDto getProduct(Integer id) {
        return data.getProductById(id);
    }

    @Override
    public void addCountByIdProduct(Integer id, Integer count) {
        data.changeQuantity(id, count);
    }

    @Override
    public void putCountByIdProduct(Integer id, Integer count) {

    }

    @Override
    public List<String> getCategory() {
        return data.getUniqCategory();
    }
}
