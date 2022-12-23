package handler;

import javax.swing.*;
import java.awt.*;

public class Book extends JPanel {
    private int numberOfPages;
    private int currentPageNum;
    
    public Book() {
        super();
        this.setLayout(new CardLayout());
        numberOfPages = 0;
        currentPageNum = 1;
    }

    public void addPage(JLabel page) {
        this.add(page, Integer.toString(numberOfPages+1));
        System.out.println("\\" + numberOfPages + "\\" + currentPageNum);
        numberOfPages++;
    }

    public void showPage(int pageNum) {
        ((CardLayout) this.getLayout()).show(this, Integer.toString(pageNum));
        currentPageNum = pageNum;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
