package com.vinc.service.order.datasource;

/**
 * Created by wangaixu@chuchujie.com on 2017/11/22.
 */
public class DataSourceHolder {

    private static final ThreadLocal<DataSourceKey> threadLocal = new ThreadLocal();

    public static void set(DataSourceKey dataSourceKey) {
        threadLocal.set(dataSourceKey);
    }

    public static DataSourceKey get() {
        return threadLocal.get();
    }

    //threadlocal 如果不及时清理容易有内存泄漏的风险
    public static void clear() {
        threadLocal.remove();
    }


}
