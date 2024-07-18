package dataSources.comporators;

import java.util.Comparator;

public class AppComporator<T> {

    String name;
    Comparator<T> comporator;

    public AppComporator(String name, Comparator<T> comporator) {
        this.name = name;
        this.comporator = comporator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Comparator<T> getComparator() {
        return comporator;
    }

    public void setComporator(Comparator<T> comporator) {
        this.comporator = comporator;
    }
}
