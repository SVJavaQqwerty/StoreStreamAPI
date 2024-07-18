package views;

import enums.Role;

import java.util.Scanner;

public class AppLoopNew {
    public final TerminalView terminalView;

    public AppLoopNew(TerminalView terminalView) {
        this.terminalView = terminalView;
    }

    public void run() {
        while (true) {
            terminalView.action();
            display();
            final int fullSize = getCountElement();
            Scanner scanner = new Scanner(System.in);
            try {

                Integer value = Integer.valueOf(scanner.nextLine());
                if (value < 0 || value > fullSize) {
                    System.out.println("Не верное значение");
                } else if (value == fullSize) {
                    break;
                } else if (value <= terminalView.getCountAction()) {
                    TerminalView selectedView = terminalView.getActions(value - 1);
                    if(null != terminalView.getCategory()) {
                        selectedView.setCategory(terminalView.getCategory());
                        new AppLoopNew(selectedView).run();
                    }
                    new AppLoopNew(selectedView).run();
                } else if (value <= terminalView.getCountAction() + terminalView.getCountAvailableComparators()) {
                    terminalView.setNowPage(0);
                    int comporatorIndex = value - terminalView.getCountAction() - 1;
                    terminalView.selectedComparator = terminalView.availableComporators.get(comporatorIndex);
                    new AppLoopNew(terminalView).run();
                } else if (value == terminalView.getCountAction() + terminalView.getCountAvailableComparators() + 1 && terminalView.getHesNextPage()) {
                    terminalView.incrementNowPage();
                    new AppLoopNew(terminalView).run();
                } else if (value == terminalView.getCountAction() + terminalView.getCountAvailableComparators() + 2 && (terminalView.getNowPage() != 0)) {
                    terminalView.decrementNowPage();
                    new AppLoopNew(terminalView).run();
                }

            } catch (Exception e) {
                System.out.println("-----------");
            }
        }
    }

    public void display() {
        int count = getCountElement();
        int currentIndex = 1;
        System.out.println(terminalView.title);
        System.out.println("Выберете вариант (от 1 до " + count + ")");

        for (int i = 0; i < terminalView.getCountAction(); i++) {
            TerminalView view = terminalView.getActions(i);
            System.out.println(currentIndex + " - " + view.getTitle());
            currentIndex++;
        }

        for (int i = 0; i < terminalView.getCountAvailableComparators(); i++) {
            System.out.println(currentIndex + " - " + terminalView.getComparator(i).getName());
            currentIndex++;
        }

        if (terminalView.getHesNextPage()) {
            System.out.println(currentIndex + " - Следующая страница");
            currentIndex++;
        }

        if (terminalView.getNowPage() != 0) {
            System.out.println(currentIndex + " - Предыдущая страница");
            currentIndex++;
        }

        System.out.println(count + " - назад");

    }

    private int getCountElement() {
        int count = 1;

        count += terminalView.getCountAction();

        if (terminalView.getHesNextPage()) {
            count++;
        }

        if (terminalView.getNowPage() != 0) {
            count++;
        }
        count += terminalView.availableComporators.size();
        return count;
    }


}
