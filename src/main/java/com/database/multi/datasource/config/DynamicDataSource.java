package com.database.multi.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author Yu
 * @since 2020/4/5
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSourceKeyLookupKey();
    }

    public static void setDataSourceLookupKey(String lookupKey){
        contextHolder.set(lookupKey);
    }

    public String getDataSourceKeyLookupKey() {
        return contextHolder.get();
    }

    public static void clear(){
        contextHolder.remove();
    }
}
