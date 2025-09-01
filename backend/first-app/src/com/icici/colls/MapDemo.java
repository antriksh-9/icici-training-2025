package com.icici.colls;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Fruit> fruitMap = new HashMap<>();

        fruitMap.put("apple", new Fruit("apple"));
    } 
}
