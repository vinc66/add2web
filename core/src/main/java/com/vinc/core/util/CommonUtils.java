package com.vinc.core.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:04 2017/3/14
 */

public final class CommonUtils {
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();

    public CommonUtils() {
    }

    public static String format(double value) {
        return NUMBER_FORMAT.format(value);
    }

    public static Double halfUp(Double value, Integer scale) {
        BigDecimal bValue = new BigDecimal(value.toString());
        return Double.valueOf(bValue.setScale(scale.intValue(), 4).doubleValue());
    }

    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < (long) unit) {
            return bytes + " B";
        } else {
            int exp = (int) (Math.log((double) bytes) / Math.log((double) unit));
            String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
            return String.format("%.1f %sB", new Object[]{Double.valueOf((double) bytes / Math.pow((double) unit, (double) exp)), pre});
        }
    }

    public static Map<String, Object> bean2Map(Object instance) {
        return (Map) Arrays.stream(instance.getClass().getFields()).collect(Collectors.toMap(Field::getName, (field) -> {
            try {
                Object e = field.get(instance);
                return e != null ? e : "";
            } catch (Exception var3) {
                return "";
            }
        }));
    }

    static {
        NUMBER_FORMAT.setGroupingUsed(true);
        NUMBER_FORMAT.setMaximumFractionDigits(2);
    }
}
