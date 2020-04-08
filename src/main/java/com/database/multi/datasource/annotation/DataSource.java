package com.database.multi.datasource.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Indication that should be find the datasource according to the lookup key from multi {@link DataSource dataSources}
 * @see
 * @author Yu
 * @since 2020/4/5
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    /**
     * lookup key
     * @return
     */
    String name() default "";


}
