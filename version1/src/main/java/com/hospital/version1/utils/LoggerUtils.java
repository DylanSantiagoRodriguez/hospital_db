package com.hospital.version1.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {

    private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.class);

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarn(String message) {
        logger.warn(message);
    }

    public static void logError(String message, Exception e) {
        logger.error(message, e);
    }
}
