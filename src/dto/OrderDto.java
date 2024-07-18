package dto;

import java.util.ArrayList;

public class OrderDto {
    String name;
    String phone;
    String address;
    String deliveryTime;
    String paymentType;
    ArrayList<ProductDto> basket;

    public OrderDto() {
    }

    public OrderDto(String name, String phone, String address, String deliveryTime, String paymentType, ArrayList<ProductDto> basket) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.deliveryTime = deliveryTime;
        this.paymentType = paymentType;
        this.basket = basket;
    }

    public ArrayList<ProductDto> getBasket() {
        return basket;
    }

    public void setBasket(ArrayList<ProductDto> basket) {
        this.basket = basket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", basket=" + basket +
                '}';
    }
}
