package org.primefaces.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.convert.ClientConverter;

@FacesConverter(value="halfup")
public class HalfUpConverter implements Converter, ClientConverter {

    @Override
    public String getConverterId() {
        return "halfup";
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        BigDecimal decimalValue = new BigDecimal(value);
        return decimalValue.setScale(0, RoundingMode.HALF_UP);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        return ((BigDecimal)value).toString();
    }

}