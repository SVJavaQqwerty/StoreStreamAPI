package dataSources.order;

import dto.OrderDto;

public interface OrderDataSource {

    void createOrder(OrderDto order);

}
