package ru.grebennik.spring_practice.lesson_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Shopping.start(context);

        context.close();
    }
}
