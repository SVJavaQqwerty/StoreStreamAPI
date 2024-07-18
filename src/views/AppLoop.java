package views;

import java.util.Scanner;

public class AppLoop {
    public final TerminalView terminalView;


    public int getChildrenSize(){
        return terminalView.actions.size();
    }

    public int getOptionalSize() {
        int optionalSize = 0;
        if(terminalView.hesNextPage) optionalSize++;
        optionalSize += terminalView.availableComporators.size();
        return optionalSize;
    }

    public AppLoop(TerminalView terminalView) {
        this.terminalView = terminalView;
    }

    public void run() {
        while (true) {
            terminalView.action();
            display();
            final int fullSize = getChildrenSize() + getOptionalSize() + 1;
            Scanner scanner = new Scanner(System.in);
            try {

                Integer value = Integer.valueOf(scanner.nextLine());

                if(value < 0 || value > fullSize) {
                    System.out.println("Не верное значение");
                } else if(value == fullSize) {
                    break;
                } else if (value < getChildrenSize() + 1) {
                    TerminalView selectedView = terminalView.actions.get(value - 1);
                    new AppLoop(selectedView).run();
                } else {
                    if(value == getChildrenSize() + 1 && terminalView.hesNextPage) {
                        terminalView.incrementNowPage();
                        new AppLoop(terminalView).run();
                    } else {
                        terminalView.setNowPage(0);
                        int comporatorIndex = value - getChildrenSize() - 1 - (terminalView.hesNextPage ? 1 : 0);
                        terminalView.selectedComparator = terminalView.availableComporators.get(comporatorIndex);
                        new AppLoop(terminalView).run();
                    }
                }
            } catch (Exception e) {
                System.out.println("Не верное значение");
            }
        }
    }

    public void display() {
        int currentIndex = 1;
        System.out.println(terminalView.title);
        System.out.println("Выберете вариант (от 1 до " + (getChildrenSize() + 1) + ")");
        for(int i = 0; i < getChildrenSize(); i++){
            TerminalView view = terminalView.actions.get(i);
            System.out.println(currentIndex + " - " + view.title);
            currentIndex++;
        }
        if(terminalView.hesNextPage) {
            System.out.println(currentIndex + " - Следующая страница");
            currentIndex++;
        }

        for(int i = 0; i < terminalView.availableComporators.size(); i++){
            System.out.println(currentIndex + " - " + terminalView.availableComporators.get(i).getName());
            currentIndex++;
        }

        System.out.println((getChildrenSize() + getOptionalSize() + 1) + " - назад");
    }
}
