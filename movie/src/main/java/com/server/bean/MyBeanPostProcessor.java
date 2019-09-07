package com.server.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author liulei
 * @Description bean实现处理器
 * @create 2017/9/5 21:14
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("bean之前初始化....");
            Car car = (Car) bean;
            if (car.getColor() == null) {
                System.out.println("给car设置颜色");
                car.setColor("红花花");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("bean之hou初始化....");
            Car car = (Car) bean;
            if (car.getColor() != null) {
                System.out.println("给car设置颜色");
                car.setColor("去你娘的biangbiang面");
            }
        }
        return bean;
    }
}
