package com.mybatis.task10.demo;

public class CreateForm {

    private int id;

    private String name;

    private String address;

    public CreateForm(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
