package com.example.mvvm_test_application.model;

public class Cocktail {

    private String name;
    private int alchoholable;
    private String structure;
    private boolean hasIce;
    private String type;
    private String urlSite;
    private String urlImage;

    public Cocktail(String name, int alchoholable, String structure, boolean hasIce,String type, String urlSite, String urlImage) {
        this.name = name;
        this.alchoholable = alchoholable;
        this.structure = structure;
        this.hasIce = hasIce;
        this.type=type;
        this.urlSite =urlSite;
        this.urlImage = urlImage;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAlchoholable(int alchoholable) {
        this.alchoholable = alchoholable;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setHasIce(boolean hasIce) {
        this.hasIce = hasIce;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlSite() {
        return urlSite;
    }

    public void setUrlSite(String urlSite) {
        this.urlSite = urlSite;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
