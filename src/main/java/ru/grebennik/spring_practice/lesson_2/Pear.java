package ru.grebennik.spring_practice.lesson_2;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Pear implements Fruits {
    private int amount;

    public Pear() {
    }

    @Override
    public String getFruitName() {
        return "pear";
    }

    @Override
    public void setAmont(int amount) {
        this.amount = amount;
    }

    @Override
    public int getAmont() {
        return this.amount;
    }

}
