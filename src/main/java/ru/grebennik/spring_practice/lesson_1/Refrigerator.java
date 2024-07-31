package ru.grebennik.spring_practice.lesson_1;

import java.util.Map;

public class Refrigerator {
    private Map<String, Integer> container;
    private int maxFruitVolume;

    public Refrigerator(Map<String, Integer> container, int maxFruitVolume) {
        this.container = container;
        this.maxFruitVolume = maxFruitVolume;
    }

    public Map<String, Integer> getContainer() {
        return container;
    }

    public void setContainer(String fruit, int amount) {
        this.container.put(fruit, amount);
    }

    public int getMaxFruitVolume() {
        return maxFruitVolume;
    }

    public void setMaxFruitVolume(int maxFruitVolume) {
        this.maxFruitVolume = maxFruitVolume;
    }


}
