package com.server.controller;

import com.server.bean.Car;
import com.server.bean.MyBeanPostProcessor;
import com.server.bean.MyInstantiationAwareBeanPostProcessor;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

/**
 * @author liulei
 * @Description bean生命周期
 * @create 2017/9/6 8:53
 */
public class BeanLifeCycle {
    public static void main(String[] args) {
        beanFactory();
    }

    private static void beanFactory() {
        Resource resource = new ClassPathResource("beans.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);

        factory.addBeanPostProcessor(new MyBeanPostProcessor());

        factory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car myCar = (Car) factory.getBean("myCar");
        System.out.println("获取到myCar对象: " + myCar.getColor());
        myCar.setColor("我改变了颜色");

        Car car = (Car) factory.getBean("myCar");

        System.out.println("两次获取对象,是否相等: " + (myCar == car));

        factory.destroySingletons();
    }

}
