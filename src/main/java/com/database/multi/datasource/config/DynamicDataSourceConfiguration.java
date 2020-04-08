package com.database.multi.datasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yu
 * @since 2020/4/5
 */

@Configuration
public class DynamicDataSourceConfiguration {

    @ConfigurationProperties(prefix = "spring.datasource.druid.master-test")
    @Bean("masterDataSource")
    public DataSource masterDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @ConfigurationProperties(prefix = "spring.datasource.druid.slave-test")
    @Bean("slaveDataSource")
    public DataSource slaveDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource){
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("master_test", masterDataSource);
        targetDataSources.put("slave_test", slaveDataSource);
        return new DynamicDataSource(masterDataSource(), targetDataSources);
    }


}
