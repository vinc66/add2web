package com.vinc.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:04 2017/3/14
 */
public final class ConfigUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigUtils.class);
    private static Properties PROPERTIES = new Properties();

    public static Properties getProperties() {
        return PROPERTIES;
    }

    public static void addProperties(Properties properties) {
        if(properties != null) {
            getProperties().putAll(properties);
        }

    }

    public static String getProperty(String key) {
        return getProperty(key, (String)null);
    }

    public static String getProperty(String key, String defaultValue) {
        String value = System.getProperty(key);
        if(value == null || value.length() == 0) {
            Properties properties = getProperties();
            value = properties.getProperty(key, defaultValue);
        }

        return value;
    }

    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        LOGGER.debug("Loading properties file resource [{}]", fileName);
        if(fileName.startsWith("/")) {
            try {
                FileInputStream list = new FileInputStream(fileName);
                Throwable e = null;

                try {
                    properties.load(list);
                } catch (Throwable var34) {
                    e = var34;
                    throw var34;
                } finally {
                    if(list != null) {
                        if(e != null) {
                            try {
                                list.close();
                            } catch (Throwable var33) {
                                e.addSuppressed(var33);
                            }
                        } else {
                            list.close();
                        }
                    }

                }
            } catch (Throwable var39) {
                LOGGER.warn("Failed to load [" + fileName + "] file" + var39.getMessage(), var39);
            }
        } else {
            ArrayList list1 = new ArrayList();

            try {
                Enumeration e2 = ConfigUtils.class.getClassLoader().getResources(fileName);

                while(e2.hasMoreElements()) {
                    list1.add(e2.nextElement());
                }
            } catch (Throwable var37) {
                LOGGER.warn("Fail to load [" + fileName + "] file" + var37.getMessage(), var37);
            }

            Iterator e3 = list1.iterator();

            while(e3.hasNext()) {
                URL url = (URL)e3.next();

                try {
                    InputStream e1 = url.openStream();
                    Throwable var6 = null;

                    try {
                        Properties p = new Properties();
                        p.load(e1);
                        properties.putAll(p);
                    } catch (Throwable var32) {
                        var6 = var32;
                        throw var32;
                    } finally {
                        if(e1 != null) {
                            if(var6 != null) {
                                try {
                                    e1.close();
                                } catch (Throwable var31) {
                                    var6.addSuppressed(var31);
                                }
                            } else {
                                e1.close();
                            }
                        }

                    }
                } catch (Throwable var36) {
                    LOGGER.warn("Fail to load " + fileName + " file from " + url + "(ingore this file): " + var36.getMessage(), var36);
                }
            }
        }

        addProperties(properties);
        return properties;
    }

    private ConfigUtils() {
    }

    static {
        loadProperties("bootstrap.properties");
    }
}
