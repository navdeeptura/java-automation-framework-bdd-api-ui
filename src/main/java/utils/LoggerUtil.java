package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 * Provides a centralized utility to get Log4j2 Logger instances.
 * This eliminates repeated boilerplate and ensures consistent logging style.
 * Also supports contextual logging via MDC (Mapped Diagnostic Context).
 */
public class LoggerUtil {

    /**
     * Returns a Logger instance associated with the provided class.
     * @param clazz the class requesting the logger
     * @return a Log4j2 Logger
     */
    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }

    /**
     * Adds contextual information to the logger (e.g., testId, browser).
     * @param key MDC key (e.g., "testId")
     * @param value MDC value (e.g., "Test001")
     */
    public static void setContext(String key, String value) {
        ThreadContext.put(key, value);
    }

    /**
     * Clears all context data for the current thread.
     * Important to call after test execution to avoid context leaks.
     */
    public static void clearContext() {
        ThreadContext.clearAll();
    }
} 
