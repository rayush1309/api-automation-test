package com.qa.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private Integer id;
    private String title;
    private double price;
    private String description;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

/*
Interview mein kya explain karna hai?
@JsonIgnoreProperties(ignoreUnknown = true) Jackson ko instruction deta hai ki JSON response mein aisi fields milne par, jo POJO mein defined nahi hain, deserialization fail na kare.

Example: API id, title, price, category aur thumbnail return karti hai, lekin tumhari Product POJO mein sirf id, title aur price hain. Annotation ke saath Jackson unmapped fields ignore kar sakta hai.

Important distinction: Isse unknown fields ignore hoti hain; ye guarantee nahi karta ki required fields present hain. Required fields ko assertions ya schema validation se verify karna chahiye.
 */