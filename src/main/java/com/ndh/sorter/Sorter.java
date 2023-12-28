package com.ndh.sorter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Sorter {

    private String sortName;

    private String sortBy;

    private List<String> brand;

    private String brands;
    public Sorter() {
    }

    public Sorter(String sortName, String sortBy,List<String> brand) {
        this.sortName = sortName;
        this.sortBy = sortBy;
        this.brand = brand;

    }
}
