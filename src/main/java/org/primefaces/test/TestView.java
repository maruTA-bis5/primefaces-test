package org.primefaces.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
    
    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;

    private List<CategoryRow> categories;
    
    @PostConstruct  
    public void init() {
        string = "Welcome to PrimeFaces!!!";

        categories = new ArrayList<>();
        CategoryRow cat1 = new CategoryRow();
        cat1.setCategoryName("Category A");
        categories.add(cat1);
        CategoryRow cat2 = new CategoryRow();
        cat2.setCategoryName("Category B");
        categories.add(cat2);
        CategoryRow cat3 = new CategoryRow();
        cat3.setCategoryName("Category C");
        categories.add(cat3);
    }

    @Data
    public static class CategoryRow {

        private String id = java.util.UUID.randomUUID().toString();
        private String categoryName;
        private List<ItemRow> items = new ArrayList<>(TestView.createItemRows());

    }

    @Data
    public static class ItemRow {

        private String itemName;
        private String color;
        private int stock;

    }

    private static List<ItemRow> createItemRows() {
        ItemRow item1 = new ItemRow();
        item1.setItemName("Item A");
        item1.setColor("Red");
        item1.setStock(100);
        ItemRow item2 = new ItemRow();
        item2.setItemName("Item B");
        item2.setColor("White");
        item2.setStock(200);
        ItemRow item3 = new ItemRow();
        item3.setItemName("Item C");
        item3.setColor("Purple");
        item3.setStock(300);
        return List.of(item1, item2, item3);
    }
}
