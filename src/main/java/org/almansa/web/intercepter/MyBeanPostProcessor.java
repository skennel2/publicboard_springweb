package org.almansa.web.intercepter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcessor를 구현한 클래스를 빈으로 등록하면 빈생성 전, 후로 가로채서 전처리, 후처리를 할수 있다. 
 * 사용을 위한 별다른 설정은 필요없다.
 * @author skennel
 *
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {        
        System.out.println("Bean '" + beanName + "' created : " + bean.toString());
        return bean;
    }

    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {        
        return bean;
    }
}
