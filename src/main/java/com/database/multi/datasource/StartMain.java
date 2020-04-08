package com.database.multi.datasource;

import com.database.multi.datasource.config.DynamicDataSourceConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @author Yu
 * @since 2020/4/5
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages="com.database.multi.datasource.mapper")
@Import(DynamicDataSourceConfiguration.class)
public class StartMain {

    public static void main(String[] args) {
        SpringApplication.run(StartMain.class);
    }

}
