package com.kutayyaman.issuemanagement.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class TPage<T> {

    private int number; //kacinci sayfa
    private int size;   //sayfada kac tane var
    private Sort sort;
    private int totalPages;
    private Long totalElements;
    private List<T> content;

    public TPage(Page page, List<T> content){

        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.content = content;
    }

}
