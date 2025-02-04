package com.learnreactivespring.learnreactivespring.Model;

import java.util.List;

public class Invoice {
    private String id;
    private List<Integer> numbers;

    public Invoice(String id, List<Integer> numbers) {
        this.id = id;
        this.numbers = numbers;
    }
}
