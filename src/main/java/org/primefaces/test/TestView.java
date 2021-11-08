package org.primefaces.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
    
    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;
    
    private TreeNode rootNode = new DefaultTreeNode();

    @PostConstruct  
    public void init() {
        string = "Welcome to PrimeFaces!!!";

        TreeNode first = new DefaultTreeNode(new Record("Node 1"));
        first.setExpanded(true);
        first.getChildren().add(new DefaultTreeNode(new Record("ChildNode 1-1")));
        rootNode.getChildren().add(first);
        TreeNode second = new DefaultTreeNode(new Record("Node 2"));
        rootNode.getChildren().add(second);
    }

    @Data
    public static class Record implements Serializable {
        private String title;
        private String note;

        public Record() { } 
        public Record(String title) {
            this.title = title;
        }
    }

}
