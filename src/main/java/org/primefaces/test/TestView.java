package org.primefaces.test;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class TestView implements Serializable {
    
    private String testString;
    
    @PostConstruct  
    public void init() {
        testString = "Welcome to PrimeFaces!!!";
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }    

    public void onCommandButtonClick() {
        PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage("Command Action Successful!"));
    }
}
