package com.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


public class PersonTest2 {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml")); //beans 按眉 积己

		PersonService person1 = (PersonService) factory.getBean("personService1"); //按眉 龋免
		person1.sayHello();
		System.out.println();

		PersonService person2 = (PersonService) factory.getBean("personService2");
		person2.sayHello();
	}

}
