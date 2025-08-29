package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private LocalDate date;

    public void onDateChanged(AjaxBehaviorEvent event) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date selected", String.valueOf(date)));
    }
}
