package dto;

import entitys.Product;

public class ProductDto {
    // Data Transfer Object
    private Integer id;
    private String strId;
    private String name;
    private String description;
    private boolean availability;
    private Integer price;
    private String category;
    private Integer count;

    public ProductDto() {
    }

    public ProductDto(Product p, Integer count) {
        this.id = p.getIntegerId();
        this.strId = p.getStringId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.availability = p.getAvailability();
        this.price = p.getPrice();
        this.category = p.getCategory();
        this.count = count;
    }

    public ProductDto(String name, String description, boolean availability, Integer price, String category, Integer count) {
        this.name = name;
        this.description = description;
        this.availability = availability;
        this.price = price;
        this.category = category;
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product getProduct() {
        return new Product(this.id, this.name, this.description, this.availability, this.price, this.category);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIntegerId() {
        return id;
    }

    public void setIntegerId(Integer id) {
        this.id = id;
    }

    public String getStringId() {
        return strId;
    }

    public void setStringId(String strId) {
        this.strId = strId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getString() {
        // id; product: id, name, availability; count
        return id + ";product:" + strId + "," + name + "," + description + "," + availability + "," + price + "," + category + ";" + count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", strId='" + strId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", availability=" + availability +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
