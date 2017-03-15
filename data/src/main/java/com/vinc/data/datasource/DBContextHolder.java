package com.vinc.data.datasource;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 16:24 2017/3/14
 */
public class DBContextHolder {
    public static final String DATA_SOURCE_VI = "vi";
    public static final String DATA_SOURCE_BI = "bi";
    private static final ThreadLocal<String> dataSourceHolder = new ThreadLocal();

    public DBContextHolder() {
    }

    public static void setDataSourceKey(String dataSource) {
        dataSourceHolder.set(dataSource);
    }

    public static String getDataSourceKey() {
        return (String)dataSourceHolder.get();
    }

    public static void clearDataSourceKey() {
        dataSourceHolder.remove();
    }
}
