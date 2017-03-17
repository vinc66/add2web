package com.vinc.data.repository.redis;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 12:06 2017/3/17
 */
public class KeyUtis {

    public static final String CATE_PREFIX = "category:";

    public static final String BOOK_PRFIX = "book:";

    public static final String SLOT_PRFIX = "slot:";

    public static String getSlot(String id) {
        return SLOT_PRFIX + id;
    }


    public static String getBook(String id) {
        return BOOK_PRFIX + id;
    }

    public static String getCategory(String id) {
        return CATE_PREFIX + id;
    }


}
