package dataSources.predicates;

import dto.ProductDto;

import java.util.function.Predicate;

public class PredicateProductAvailable implements Predicate<ProductDto> {
    @Override
    public boolean test(ProductDto productDto) {
        return productDto.isAvailability();
    }
}
