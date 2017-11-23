package com.vinc.service.order.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by wangaixu@chuchujie.com on 2017/11/22.
 */

@Slf4j
public class MultipleDataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String key;
        try {
            DataSourceKey dataSourceKey = DataSourceHolder.get();
            key = dataSourceKey == null ?DataSourceKey.MASTER.getValue() : dataSourceKey.getValue();
            log.info("切换数据源:{}", key);
        } finally {
            DataSourceHolder.clear();
        }
        return key;
    }
}
