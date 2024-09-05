package com.hexa.springannotation.com.hexa.springannotation1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
    	Student s1 = (Student)context.getBean("stud1");
    	Student s2 = (Student)context.getBean("stud2");
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        
        
        Result r1 = s1.getRes();
        System.out.println(r1.toString());
        
        context.close();  // not working with ApplicationContext
    }
}
