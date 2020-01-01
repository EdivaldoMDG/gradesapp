package com.example.schoolapp;

public class Student {

    private String name;
    private String teste1;
    private String teste2;

    public Student(String name, String teste1, String teste2){
        this.name = name;
        this.teste1 = teste1;
        this.teste2 = teste2;
    }

    public String getName() {
        return name;
    }

    public String getTeste1() {
        return teste1;
    }

    public String getTeste2() {
        return teste2;
    }

}
