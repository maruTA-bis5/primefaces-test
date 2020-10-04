package org.primefaces.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.inject.Model;

@Model
public class TestView {

    public enum TestEnum {
        FIRST, SECOND, THIRD;
    }
    
    private List<TestEnum> selection = new ArrayList<>();

    public List<TestEnum> getSelection() {
        return selection;
    }

    public void setSelection(List<TestEnum> selection) {
        this.selection = selection;
    }

    private Set<TestEnum> parameter = new HashSet<>();

    public Set<TestEnum> getParameter() {
        return parameter;
    }

    public void setParameter(Set<TestEnum> parameter) {
        this.parameter = parameter;
    }

    public List<TestEnum> getSelectableItems() {
        return Arrays.asList(TestEnum.values());
    }

    public String submit() {
        return "test.xhtml?faces-redirect=true&parameter=" + selection.stream().map(TestEnum::toString).collect(Collectors.joining(","));
    }
}
