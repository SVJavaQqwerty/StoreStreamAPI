package dataSources.dataCatalog;

import dataSources.predicates.PredicateProductAvailable;
import dto.ProductDto;
import entitys.Product;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductFromMapImpl implements DataToStore{

    private String file = "product.txt"; // файл дампа каталога
    private HashMap<Integer, HashMap<Product, Integer>> catalog = new HashMap<>();

    public ProductFromMapImpl() {
        loadToFile();
    }

    @Override
    public ProductDto getProductById(Integer id) {
        HashMap<Product, Integer> element = catalog.get(id);
        if(element != null) {
            return new ProductDto(element.entrySet().stream().findFirst().get().getKey(),
                    element.entrySet().stream().findFirst().get().getValue());
        }
        return null;
    }

    @Override
    public List<ProductDto> getProducts(Integer page, Integer strings, Comparator<ProductDto> comparator, PredicateProductAvailable predicate, String category) {
        return catalog.entrySet().stream().map(s ->  new ProductDto(s.getValue().entrySet().stream().findFirst().get().getKey(),
                s.getValue().entrySet().stream().findFirst().get().getValue())).filter(predicate).filter(s -> s.getCategory().equals(category)).sorted(comparator).skip((long) page * strings).limit(strings).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProducts(Integer page, Integer strings, Comparator<ProductDto> comparator, Predicate<ProductDto> predicate){
        return catalog.entrySet().stream().map(s ->  new ProductDto(s.getValue().entrySet().stream().findFirst().get().getKey(),
                s.getValue().entrySet().stream().findFirst().get().getValue())).filter(predicate).sorted(comparator).skip((long) page * strings).limit(strings).collect(Collectors.toList());
    }


    @Override
    public List<ProductDto> getProducts(Integer page, Integer strings) {
        return catalog.entrySet().stream().skip((long) page * strings).limit(strings).map(s ->  new ProductDto(s.getValue().entrySet().stream().findFirst().get().getKey(),
                s.getValue().entrySet().stream().findFirst().get().getValue())).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProducts(Integer page, Integer strings, Comparator<ProductDto> comparator) {
        return catalog.entrySet().stream().map(s ->  new ProductDto(s.getValue().entrySet().stream().findFirst().get().getKey(),
                s.getValue().entrySet().stream().findFirst().get().getValue())).sorted(comparator).skip((long) page * strings).limit(strings).collect(Collectors.toList());
    }

    @Override
    public boolean changeQuantity(Integer id, Integer count) {
        // Принимает количество в виде множества целых чисел
        HashMap<Product, Integer> element = catalog.get(id);

        if(element != null) {
            Product product = element.entrySet().stream().findFirst().get().getKey();
            Integer oldCount = element.entrySet().stream().findFirst().get().getValue();
            if(count < 0) {
                if (oldCount >= Math.abs(count)) {
                    if(oldCount + count == 0){
                        product.setAvailability(false);
                    }
                    element.put(product, oldCount + count);
                    catalog.put(product.getIntegerId(), element);
                    beackUp();
                } else {
                    System.out.println("Указанное количество не доступно!");
                }
            } else {
                element.put(product, oldCount + count);
                catalog.put(product.getIntegerId(), element);
                beackUp();
            }
        }
        return false;
    }

    @Override
    public boolean setProduct(ProductDto product) {
        Integer id = createId();
        if(id != -1) {
            product.setIntegerId(id);
            if(! catalog.containsKey(product.getIntegerId())) {
                HashMap<Product, Integer> productNew = new HashMap<>();
                productNew.put(product.getProduct(), product.getCount());
                catalog.put(product.getIntegerId(), productNew);
                beackUp();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean isProductById(Integer id) {
        return catalog.get(id).entrySet().stream().findFirst().isPresent();
    }

    @Override
    public boolean getAvailabilityById(Integer id) {
        if(catalog.get(id).entrySet().stream().findFirst().isPresent()) {
            return catalog.get(id).entrySet().stream().findFirst().get().getKey().getAvailability();
        } else {
            return false;
        }
    }

    @Override
    public List<String> getUniqCategory() {
        ArrayList<String> category = (ArrayList<String>) catalog.entrySet().stream().map(s -> s.getValue().entrySet().stream().findFirst().get().getKey().getCategory()).collect(Collectors.toList());
        HashSet<String> categoryUniqValue = new HashSet<>(category);
        return new ArrayList<>(categoryUniqValue);
    }

    private Integer createId() {
        for(int i = 1; i <= Product.MAX_VALUE; i++) {
            if (! catalog.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }


    private void beackUp() {
        try(FileWriter writer = new FileWriter(file)){
            BufferedWriter bw = new BufferedWriter(writer);
            for(Map.Entry<Integer, HashMap<Product, Integer>> line : catalog.entrySet()){
                Map.Entry<Product, Integer> element = line.getValue().entrySet().stream().findFirst().get();
                Product product = element.getKey();
                Integer count = element.getValue();

                ProductDto productDto = new ProductDto(product, count);
                bw.write(productDto.getString() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private void loadToFile() {
        // 671;product:000000671,Товар_7,true;2
        try (FileReader reader = new FileReader(file)){
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(";");
                String[] p = line[1].split(":")[1].split(",");
                Product product = new Product(Integer.parseInt(line[0]),p[1], p[2], Boolean.parseBoolean(p[3]), Integer.parseInt(p[4]), p[5]);
                HashMap<Product, Integer> map = new HashMap<>();
                map.put(product,Integer.parseInt(line[2]));

                catalog.put(Integer.parseInt(line[0]), map);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
