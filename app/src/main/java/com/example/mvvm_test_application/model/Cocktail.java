package com.example.mvvm_test_application.model;

public class Cocktail {

    private String name;
    private int alchoholable;
    private String structure;
    private boolean hasIce;

    public Cocktail(String name, int alchoholable, String structure, boolean hasIce) {
        this.name = name;
        this.alchoholable = alchoholable;
        this.structure = structure;
        this.hasIce = hasIce;
    }

    public String getName() {
        return name;
    }

    public int getAlchoholable() {
        return alchoholable;
    }

    public String getStructure() {
        return structure;
    }

    public boolean isHasIce() {
        return hasIce;
    }
}
