package org.primefaces.test;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;

@Named
@ViewScoped
public class TestView implements Serializable {

    private MenuModel menuModel = new DefaultMenuModel();
    
    @PostConstruct
    void initialize() {
        menuModel.getElements().add(DefaultMenuItem.builder()
            .icon("pi pi-file")
            .value("Open")
            .build());
        Submenu otherMenu = DefaultSubMenu.builder()
            .label("Other")
            .addElement(DefaultMenuItem.builder()
                .value("TypeA")
                .build())
            .addElement(DefaultMenuItem.builder()
                .value("TypeB")
                .build())
            .build();
        Submenu subMenu = DefaultSubMenu.builder()
            .icon("pi pi-briefcase")
            .label("New")
            .addElement(DefaultMenuItem.builder()
                .value("Project")
                .build())
            .addElement(otherMenu)
            .build();
        menuModel.getElements().add(subMenu);
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }
}
