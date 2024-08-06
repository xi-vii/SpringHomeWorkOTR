package ru.grebennik.spring_practice.lesson_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Scanner;

public class Shopping {

    private Refrigerator refrigerator;

    // Внедряем зависимость через конструктор
    @Autowired
    public Shopping(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }

    // Метод проверяет, что покупки (груши и бананы) могут полностью поместиться в холодильник
    public boolean fillTheRefrigerator(Pear pear, Banana banana, ClassPathXmlApplicationContext context) {

        String negativeResultPear = "Вы пытаетесь положить в холодильник слишком много груш! Он не закроется!\n" +
                "Попробуйте другое количество.\n";
        String negativeResultBanana = "Вы пытаетесь положить в холодильник слишком много бананов! Он и так занят грушами!\n" +
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
        }

        System.out.println("Введите количество приобретённых бананов: ");
        banana.setAmont(in.nextInt());

        // Проверяем, поместятся ли бананы в холодильник (после размещения груш)
        if(banana.getAmont()>freeFruitVolume) {
            System.out.println(negativeResultBanana);
            result = false;
        } else {
            this.refrigerator.setContainer(banana.getFruitName(), banana.getAmont());
        }
        return result;
    }


    public static void start(ClassPathXmlApplicationContext context){

        Banana banana = context.getBean("bananaBean", Banana.class);
        Pear pear = context.getBean("pearBean", Pear.class);
        Shopping shopping = context.getBean("shoppingBean", Shopping.class);

        boolean result = false;

        // Пока общее кол-во вводимых груш и бананов превышает объём холодильника, цикл повторяется
        while(!result) {
            result = shopping.fillTheRefrigerator(pear, banana, context);
        }

    }

    @PostConstruct
    public void init() {
        System.out.println("Приступим к укладке покупок\n");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Покупки успешно уложены в холодильник.");
    }
}
