package com.capone.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ProductObject {

    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("PackageUnits")
    public String packageUnits;
    @JsonProperty("price")
    public double price;
    @JsonProperty("pictureName")
    public String pictureName;

    public ProductObject(String description, String name, String packageUnits, double price, String pictureName) {
        this.description = description;
        this.name = name;
        this.packageUnits = packageUnits;
        this.price = price;
        this.pictureName = pictureName;
    }

    public ProductObject() {}

}
