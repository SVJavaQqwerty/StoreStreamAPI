package entitys;

import java.util.Objects;

public class Product implements Comparable<Product>{
    public static final Integer MAX_VALUE = 999_999_999;
    private String id; // максимально 999_999_999
    private String name;
    private String description;
    private boolean availability;
    private Integer price;
    private String category;


    public Product(Integer id, String name, String description, boolean availability, Integer price, String category) {
        this.id = parsId(String.valueOf(id));
        this.name = name;
        this.description = description;
        this.availability = availability;
        this.price = price;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStringId() {
        return id;
    }

    public Integer getIntegerId() {
        return Integer.parseInt(id);
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

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", availability=" + availability +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return availability == product.availability && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, availability);
    }

    @Override
    public int compareTo(Product o) {
        return Integer.parseInt(id) - Integer.parseInt(o.id);
    }

    private String parsId(String id) {
        StringBuilder str = new StringBuilder();
        int count = id.length();
        if(count < 9) {
            int delta = 9 - count;
            for(int i = delta; i > 0; i--){
                str.append("0");
            }
            str.append(id);
        } else {
            str.append(id);
        }
        return str.toString();
    }
}
