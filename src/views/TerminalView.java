package views;

import dataSources.comporators.AppComporator;
import dto.ProductDto;

import java.util.ArrayList;

public abstract class TerminalView {
    public final String title;
    public ArrayList<TerminalView> actions;
    private int nowPage = 0;
    public boolean hesNextPage = false;
    public final ArrayList<AppComporator<ProductDto>> availableComporators = new ArrayList<>() ;
    public AppComporator<ProductDto> selectedComparator;
    private String category = "";

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TerminalView(String title, ArrayList<TerminalView> actions) {
        this.title = title;
        this.actions = actions;
    }


    public void action(){};

    public int getCountAction() {
        return actions.size();
    }

    public TerminalView getActions(int id){
        return actions.get(id);
    }

    public String getTitle(){
        return title;
    }

    public int getCountAvailableComparators(){
        return  availableComporators.size();
    }

    public AppComporator getComparator(int id) {
        return availableComporators.get(id);
    }

    public boolean getHesNextPage() {
        return hesNextPage;
    }

    public int incrementNowPage() {
        return ++nowPage;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int decrementNowPage() {
        return --nowPage;
    }
}
