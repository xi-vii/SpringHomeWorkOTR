package ru.grebennik.spring_practice.lesson_1;

public class Pear implements Fruits{
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
