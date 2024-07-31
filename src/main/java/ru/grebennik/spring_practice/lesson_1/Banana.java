package ru.grebennik.spring_practice.lesson_1;

public class Banana implements Fruits{
    private int amount;

    public Banana() {
    }

    @Override
    public String getFruitName() {
        return "banana";
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
