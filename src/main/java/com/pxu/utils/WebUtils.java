package com.pxu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author
 * @Date:2022/10/15-22:14
 */
public class WebUtils {
    /**
     * 把map中的值注入到对应的javaBean属性中
     * @param value 通过键值对的形式调用setXxx方法
     * @param bean 实体类
     * @param <T> 设置泛型
     * @return 注入属性值后的实体类bean
     */
    public static <T>T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue){
        try {
            if(strInt != null){
                return Integer.parseInt(strInt);
            }else {
                return defaultValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
