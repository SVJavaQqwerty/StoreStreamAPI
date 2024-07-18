package dataSources.basket;

import dataSources.dataCatalog.DataToStore;
import dataSources.dataCatalog.ProductFromMapImpl;
import dto.ProductDto;

import java.util.ArrayList;
import java.util.Objects;

public class BasketImpl implements Basket{

    ArrayList<ProductDto> productDtos = new ArrayList<>();
    DataToStore products = new ProductFromMapImpl();

    @Override
    public void setProductBasket(ProductDto product) {
        if(products.changeQuantity(product.getIntegerId(), -product.getCount())){
            productDtos.add(product);
        }
    }

    @Override
    public void deleteProductBasket(ProductDto product) {

        for (ProductDto s : productDtos) {
            if(Objects.equals(s.getIntegerId(), product.getIntegerId())) {
                if(Objects.equals(s.getCount(), product.getCount())){
                    productDtos.remove(product);
                } else if(s.getCount() > product.getCount()) {
                    productDtos.remove(s);
                    product.setCount(s.getCount() - product.getCount());
                    productDtos.add(product);
                }
            }
        }

    }

    @Override
    public ArrayList<ProductDto> getAllProductBasket() {
        return productDtos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Basket{ products=");
        for(ProductDto i : productDtos){
            sb.append(i.toString());
        }
        sb.append("}");
        return sb.toString();
    }
}
