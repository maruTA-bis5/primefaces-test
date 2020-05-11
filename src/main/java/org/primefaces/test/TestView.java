package org.primefaces.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TestView implements Serializable {
    
    private List<TestRecord> records = new ArrayList<>();
    
    @PostConstruct  
    public void init() {
        records.add(new TestRecord("record1"));
        records.add(new TestRecord("record2"));
        records.add(new TestRecord("record3"));
    }

    public List<TestRecord> getRecords() {
        return records;
    }

    public void setRecords(List<TestRecord> records) {
        this.records = records;
    }

    public static class TestRecord implements Serializable {
        private String value;

        public TestRecord() {
            this(null);
        }

        public TestRecord(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
