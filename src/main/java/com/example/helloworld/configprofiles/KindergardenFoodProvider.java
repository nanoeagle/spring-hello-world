package com.example.helloworld.configprofiles;

import java.util.*;

public class KindergardenFoodProvider implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Biscuits"));
        lunchSet.forEach(System.out::println);
        return lunchSet;
    }
}