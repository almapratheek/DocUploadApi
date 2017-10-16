package com.capone.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DocObject {
    @JsonProperty("name")
    public String imgName;
    @JsonProperty("data")
    public String imgValue;

    public DocObject(){}

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public void setImgValue(String imgValue) {
        this.imgValue = imgValue;
    }
}
