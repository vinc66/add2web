package com.vinc.data.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 16:23 2017/3/14
 */
public class MultipleDataSourceRouter extends AbstractRoutingDataSource {
    public MultipleDataSourceRouter() {
    }

    protected Object determineCurrentLookupKey() {
        return DBContextHolder.getDataSourceKey();
    }
}
