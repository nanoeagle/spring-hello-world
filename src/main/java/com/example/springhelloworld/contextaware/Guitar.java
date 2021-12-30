package com.example.springhelloworld.contextaware;

import org.springframework.stereotype.Component;

@Component("gopher")
public class Guitar {
    private String brand ="Martin";

    public void play() {
        System.out.println("Cm Eb Fm Ab Bb");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}