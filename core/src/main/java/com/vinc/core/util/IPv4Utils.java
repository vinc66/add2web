package com.vinc.core.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:05 2017/3/14
 */
public final class IPv4Utils {
    public IPv4Utils() {
    }

    public static long ip2Long(String ipAddress) {
        String[] ipSplit = StringUtils.split(ipAddress, ".");
        if(ipSplit.length == 4) {
            long[] ipArr = new long[]{NumberUtils.toLong(ipSplit[0]), NumberUtils.toLong(ipSplit[1]), NumberUtils.toLong(ipSplit[2]), NumberUtils.toLong(ipSplit[3])};
            return (ipArr[0] << 24) + (ipArr[1] << 16) + (ipArr[2] << 8) + ipArr[3];
        } else {
            return NumberUtils.LONG_ZERO.longValue();
        }
    }

    public static boolean isGlobal(String ipAddress) {
//        try {
//            if(InetAddressValidator.getInstance().isValidInet4Address(ipAddress)) {
//                InetAddress inetAddress = InetAddress.getByName(ipAddress);
//                return !inetAddress.isAnyLocalAddress() && !inetAddress.isLinkLocalAddress() && !inetAddress.isMulticastAddress() && !inetAddress.isLoopbackAddress() && !inetAddress.isSiteLocalAddress();
//            }
//        } catch (Exception var2) {
//            ;
//        }

        return false;
    }
}
