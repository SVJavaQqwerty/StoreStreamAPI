package dataSources.comporators;



import dto.ProductDto;

import java.util.Comparator;

public class PriceComporator implements Comparator<ProductDto> {
    private boolean isAsc; // desc

    public PriceComporator() {
        isAsc = true;
    }

    public PriceComporator(boolean isAsc) {
        this.isAsc = isAsc;
    }

    @Override
    public int compare(ProductDto p1, ProductDto p2) {
        if(isAsc) {
            return p1.getPrice() - p2.getPrice();
        } else {
            return p2.getPrice() - p1.getPrice();
        }
    }
}
