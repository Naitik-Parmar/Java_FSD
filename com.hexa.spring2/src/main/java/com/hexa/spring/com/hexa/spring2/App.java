package com.hexa.spring.com.hexa.spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Employee e1 = (Employee) context.getBean("emp1");
        Result res=e1.getRes();
        Employee e2 = (Employee) context.getBean("emp2");
        System.out.println(e1.toString());
        System.out.println(res.toString());
        System.out.println(e2.toString());
        
    }
}
