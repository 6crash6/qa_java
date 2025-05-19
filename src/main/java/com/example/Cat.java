package com.example;

import java.util.List;


public class Cat {
    private Predator predator;


    public Cat(Feline feline) {
        this.predator = feline;
    }

    // Возвращает звук, который издает кошка
    public String getSound() {
        return "Мяу";
    }


     // Возвращает список пищи, которую ест кошка.
    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
