package com.vinc.core.util;

import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.UUID;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:05 2017/3/14
 */
public final class IDGenerator {
    public IDGenerator() {
    }

    public static String generate() {
        return UUID.randomUUID().toString();
    }

    public static int generate(String id) {
        return StringUtils.isEmpty(id)? NumberUtils.INTEGER_ZERO.intValue(): Hashing.murmur3_32().hashUnencodedChars(id).asInt();
    }
}
