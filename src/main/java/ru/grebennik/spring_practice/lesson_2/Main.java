package ru.grebennik.spring_practice.lesson_2;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextForLesson2.xml");

        Shopping.start(context);

        context.close();
    }
}
