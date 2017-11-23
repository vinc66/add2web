package com.vinc.service.order.datasource;

/**
 * Created by wangaixu@chuchujie.com on 2017/11/22.
 */
public enum DataSourceKey {

    MASTER("master"), SlAVE("slave");

    private final String value;

    DataSourceKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
