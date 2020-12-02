package com.example.aop.anotation;

import java.lang.annotation.*;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/6/7 10:12 下午
 */

@Documented //将该自定义注解添加到 javadoc 文档中
@Target({ElementType.METHOD}) //该注解是作用在方法上的
@Retention(RetentionPolicy.RUNTIME) //作用时机为运行时
public @interface Log {

    /**
     * 方法英文名称，格式为：类名.方法名
     */
    String key() default "";

    /**
     * 方法中文名称，必填
     */
    String name();

    /**
     * 描述信息，非必填
     */
    String description() default "";
}
