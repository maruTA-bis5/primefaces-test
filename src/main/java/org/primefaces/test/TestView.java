package org.primefaces.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Data;
import lombok.Value;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
    
    private List<RowData> data = new ArrayList<>();

    private List<RowData> selection = new ArrayList<>();

    public void onAddRow() {
        data.add(new RowData());
    }

    @Value
    public static class RowData implements Serializable {
        RowData() {
            this.uuid = UUID.randomUUID().toString();
        }
        private String uuid;
    }

}
