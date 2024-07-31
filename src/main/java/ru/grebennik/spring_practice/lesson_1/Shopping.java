package ru.grebennik.spring_practice.lesson_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class Shopping {

    private Refrigerator refrigerator;

    // Внедряем зависимость через конструктор
    public Shopping(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }

    // Метод проверяет, что покупки (груши и бананы) могут полностью поместиться в холодильник
    public boolean fillTheRefrigerator(Pear pear, Banana banana) {

        // Создаём экземпляры класса String через контекст, т.к. где-то нужно было использовать bean
        // с областью видимости prototype
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        String negativeResultPear = context.getBean("negativeResult", String.class);
        String negativeResultBanana = context.getBean("negativeResult", String.class);

        negativeResultPear = "Вы пытаетесь положить в холодильник слишком много груш! Он не закроется!\n" +
                "Попробуйте другое количество.";
        negativeResultBanana = "Вы пытаетесь положить в холодильник слишком много бананов! Он и так занят грушами!\n" +
                "Попробуйте другое количество фруктов.\n";

        int freeFruitVolume = this.refrigerator.getMaxFruitVolume();    // Объём свободного места для фруктов в холодильнике
        boolean result = true;      // Получилось поместить все фрукты в холодильник или нет

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество приобретённых груш: ");
        pear.setAmont(in.nextInt());

        // Проверяем, поместятся ли груши в холодильник
        if(pear.getAmont()>freeFruitVolume) {
            System.out.println(negativeResultPear);
            result = false;
            return result;
        } else {
            this.refrigerator.setContainer(pear.getFruitName(), pear.getAmont());
            freeFruitVolume -= pear.getAmont();
        };

        System.out.println("Введите количество приобретённых бананов: ");
        banana.setAmont(in.nextInt());

        // Проверяем, поместятся ли бананы в холодильник (после размещения груш)
        if(banana.getAmont()>freeFruitVolume) {
            System.out.println(negativeResultBanana);
            result = false;
        } else {
            this.refrigerator.setContainer(banana.getFruitName(), banana.getAmont());
        }
        context.close();
        return result;
    };


    public static void start(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Banana banana = context.getBean("bananaBean", Banana.class);
        Pear pear = context.getBean("pearBean", Pear.class);
        Shopping shopping = context.getBean("shoppingBean", Shopping.class);

        boolean result = false;

        // Пока общее кол-во вводимых груш и бананов превышает объём холодильника, цикл повторяется
        while(!result) {
            result = shopping.fillTheRefrigerator(pear, banana);
        }

        context.close();

        System.out.println("Покупки успешно уложены в холодильник.");
    };
}
