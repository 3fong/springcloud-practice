package com.server.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author liulei
 * @Description 车
 * @create 2017/9/5 13:46
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String color;

    public Car() {
        System.out.println("无参构造方法");
    }

    public Car(String color) {
        this.color = color;
        System.out.println("带....参构造方法");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("setColor ");
        this.color = color;
    }

    private BeanFactory beanFactory;
    private String beanName;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory ");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("setBeanName ");
        this.beanName = beanName;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy ");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet ");
    }

    public void myInit() {
        System.out.println("自定义初始化方法 myInit ");
    }

    public void myDestory() {
        System.out.println("自定义销毁方法");
    }
}
