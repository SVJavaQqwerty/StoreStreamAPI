package services;

import dataSources.order.OrderDataSource;
import dataSources.order.OrderDataSourceImpl;
import dto.OrderDto;

public class ServiceOrderImpl implements ServiceOrder{

    OrderDataSource orderDataSource = new OrderDataSourceImpl();

    @Override
    public void createOrder(OrderDto order) {
        orderDataSource.createOrder(order);
    }
}
