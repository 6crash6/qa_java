package com.example;

import java.util.List;

public class Feline extends Animal implements Predator {
    private int kittens; // Добавляем поле для хранения количества котят

    public Feline() {
        this.kittens = 1; // Инициализируем начальное значение
    }

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    // Метод установки количества котят
    public void setKittens(int kittens) {
        if (kittens >= 0) {
            this.kittens = kittens;
        } else {
            throw new IllegalArgumentException("Количество котят не может быть отрицательным");
        }
    }

    // Метод получения количества котят
    public int getKittens() {
        return kittens;
    }

    // Метод получения пищи для разных типов животных
    public List<String> getFood(String animalKind) throws Exception {
        if ("Хищник".equals(animalKind)) {
            return List.of("Животные", "Птицы", "Рыба");
        } else if ("Травоядное".equals(animalKind)) {
            return List.of("Трава", "Различные растения");
        } else {
            throw new Exception("Неизвестный тип животного");
        }
    }
}
