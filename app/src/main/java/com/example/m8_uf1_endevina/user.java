package com.example.m8_uf1_endevina;

import java.io.Serializable;

public class user implements Serializable {
    private String name;
    private int tries;

    //Getters y Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    //Constructor
    public user(String name, int tries) {
        this.name = name;
        this.tries = tries;
    }

    //ToString

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", tries=" + tries +
                '}';
    }
}
