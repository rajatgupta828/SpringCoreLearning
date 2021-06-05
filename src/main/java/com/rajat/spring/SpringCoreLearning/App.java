package com.rajat.spring.SpringCoreLearning;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class App 
{
    public static void main( String[] args )
    {
        //BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        Car car = (Car)context.getBean("car");
        System.out.println("I am " + car.getName());
        car.driving();
        System.out.print("My Tyres are : " + car.getTyre().getCompany() + " of size : " + car.getTyre().getSize());
        
    }  
}
