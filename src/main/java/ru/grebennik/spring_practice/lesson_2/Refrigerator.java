package ru.grebennik.spring_practice.lesson_2;

import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public class Refrigerator {
    private Map<String, Integer> container;
    private int maxFruitVolume;

    public Refrigerator(@Value(value ="#{${container}}") Map<String, Integer> container,    // {'pear': 0, 'banana': 0}
                        @Value(value ="#{${refrigeratorMaxVolume}}") int maxFruitVolume) {
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
