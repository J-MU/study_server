package com.example.demo.beanfind;

import com.example.demo.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for (String beanName : beanDefinitionName) {
            Object bean = ac.getBean(beanName);
            System.out.println("beanName = " + beanName + "object = "+bean);
        }
    }

    @Test
    @DisplayName("어플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for (String beanName : beanDefinitionName) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean=ac.getBean(beanName);
                System.out.println("beanName = " + beanName + "object = " + bean);
            }
        }
    }


}
