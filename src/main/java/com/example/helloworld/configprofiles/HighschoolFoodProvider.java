package com.example.helloworld.configprofiles;

import java.util.*;

public class HighschoolFoodProvider implements FoodProviderService {

    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Coke"));
        lunchSet.add(new Food("Hamburger"));
        lunchSet.add(new Food("French Fries"));
        lunchSet.forEach(System.out::println);
        return lunchSet;
    }
}