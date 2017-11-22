package com.vinc.data.datasource;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * Created by wangaixu@chuchujie.com on 2017/11/22.
 */

@Intercepts({
        @Signature(method = "query", type = Executor.class, args = {
                MappedStatement.class, Object.class, RowBounds.class,
                ResultHandler.class}),
        @Signature(method = "update", type = Executor.class, args = {
                MappedStatement.class, Object.class})})
@Slf4j
public class DataSourceInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        log.info("sqlid :{}", mappedStatement.getId());
        DataSourceKey dataSourceKey = DataSourceHolder.get();
        if (dataSourceKey == null) {
            if (SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())) {
                DataSourceHolder.set(DataSourceKey.SlAVE);
            } else {
                DataSourceHolder.set(DataSourceKey.MASTER);
            }
        }
        Object proceed;
        try {
            proceed = invocation.proceed();
        } finally {
            DataSourceHolder.clear();
        }
        return proceed;
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        log.info("properties====:{}", properties);
    }
}
