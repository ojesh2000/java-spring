package com.app.aopdemo.models;

public class MyClass {
    private String name;
    private int value;

    public MyClass(){}

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public MyClass(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
