package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane;
    private Feline feline;

    public Lion(String sex, Feline feline) throws Exception {

        // Проверяем, что объект Feline не null
        if (feline == null) {
            throw new NullPointerException("Feline cannot be null");
        }
        this.feline = feline;

        // Устанавливаем значение hasMane в зависимости от пола
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    // Возвращаем количество котят у льва.
    public int getKittens() {
        return feline.getKittens();
    }

    // Проверяем наличие гривы у льва.
    public boolean doesHaveMane() {
        return hasMane;
    }

     // Возвращаем список пищи, которую ест лев.
     // @throws Exception если возникает ошибка при получении списка пищи
    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }

     // Возвращаем семейство, к которому принадлежит лев.
    public String getFamily() {
        return feline.getFamily();
    }
}
