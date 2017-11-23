package com.vinc.service.order.repository;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 12:06 2017/3/17
 */
public class KeyUtis {

    public static final String STOCK_LOCK = "lock:stock:";

    public static final String USER_ORDER_PRFIX = "user:order:";

    public static final String PRODCUT_STOCK_PREFIX = "product:stock:";

    public static final String ORDER_PREFIX = "order:";


    public static String userOrderList(Integer uid) {
        return USER_ORDER_PRFIX + uid;
    }

    public static String productStock(int pid) {
        return PRODCUT_STOCK_PREFIX + pid;
    }

    public static String stockLock(int pid) {
        return STOCK_LOCK + pid;
    }

    public static String order(Integer id) {
        return ORDER_PREFIX + id;
    }
}
