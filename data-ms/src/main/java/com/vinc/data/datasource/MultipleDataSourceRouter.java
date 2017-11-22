package com.vinc.data.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

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
            if (dataSourceKey == null)
                key = DataSourceKey.MASTER.getValue();
            else
                key = dataSourceKey.getValue();
            log.info("切换数据源:{}", key);
        } finally {
            DataSourceHolder.clear();
            log.info("清空 DataSourceHolder");
        }
        return key;
    }
}
