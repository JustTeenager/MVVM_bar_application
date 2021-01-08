package com.example.mvvm_test_application.model;


import com.google.gson.annotations.SerializedName;

public class Cocktail {

    @SerializedName("name")
    private String name;
    @SerializedName("alcoholable")
    private String alcoholable;
    @SerializedName("structure")
    private String structure;
    @SerializedName("hasIce")
    private boolean hasIce;
    @SerializedName("type")
    private String type;
    @SerializedName("urlSite")
    private String urlSite;
    @SerializedName("urlImage")
    private String urlImage;

    public Cocktail(String name, String alcoholable, String structure, boolean hasIce, String type, String urlSite, String urlImage) {
        this.name = name;
        this.alcoholable = alcoholable;
        this.structure = structure;
        this.hasIce = hasIce;
        this.type=type;
        this.urlSite =urlSite;
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public String getAlcoholable() {
        return alcoholable;
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

    public void setAlcoholable(String alcoholable) {
        this.alcoholable = alcoholable;
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
