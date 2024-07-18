package dataSources.order;

import dto.OrderDto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderDataSourceImpl implements OrderDataSource{

    @Override
    public void createOrder(OrderDto order) {

        try (FileWriter writer = new FileWriter("order.txt")) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(order.toString());
            bufferedWriter.close();

            System.out.println("file save");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
