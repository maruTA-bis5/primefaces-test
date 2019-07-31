package org.primefaces.test;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class TestView implements Serializable {

    private Byte byteValue;

    public void setByteValue(Byte byteValue) {
        this.byteValue = byteValue;
    }

    public Byte getByteValue() {
        return byteValue;
    }

    public void onSubmit() {
        PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage("Input: " + getByteValue()));
    }
}
