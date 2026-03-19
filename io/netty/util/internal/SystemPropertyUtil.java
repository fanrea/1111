package io.netty.util.internal;

import com.component.a.g.b;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SystemPropertyUtil {
    private static boolean loggedException;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SystemPropertyUtil.class);
    private static boolean initializedLogger = true;
    private static final Pattern INTEGER_PATTERN = Pattern.compile("-?[0-9]+");

    public static boolean contains(String str) {
        return get(str) != null;
    }

    public static String get(String str) {
        return get(str, null);
    }

    public static String get(final String str, String str2) {
        if (str == null) {
            throw new NullPointerException("key");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("key must not be empty.");
        }
        String property = null;
        try {
            if (System.getSecurityManager() == null) {
                property = System.getProperty(str);
            } else {
                property = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.util.internal.SystemPropertyUtil.1
                    @Override // java.security.PrivilegedAction
                    public final String run() {
                        return System.getProperty(str);
                    }
                });
            }
        } catch (Exception e) {
            if (!loggedException) {
                log("Unable to retrieve a system property '" + str + "'; default values will be used.", e);
                loggedException = true;
            }
        }
        return property == null ? str2 : property;
    }

    public static boolean getBoolean(String str, boolean z) {
        String str2 = get(str);
        if (str2 == null) {
            return z;
        }
        String lowerCase = str2.trim().toLowerCase();
        if (lowerCase.isEmpty() || "true".equals(lowerCase) || "yes".equals(lowerCase) || "1".equals(lowerCase)) {
            return true;
        }
        if ("false".equals(lowerCase) || b.t.equals(lowerCase) || "0".equals(lowerCase)) {
            return false;
        }
        log("Unable to parse the boolean system property '" + str + "':" + lowerCase + " - using the default value: " + z);
        return z;
    }

    public static int getInt(String str, int i) {
        String str2 = get(str);
        if (str2 == null) {
            return i;
        }
        String lowerCase = str2.trim().toLowerCase();
        if (INTEGER_PATTERN.matcher(lowerCase).matches()) {
            try {
                return Integer.parseInt(lowerCase);
            } catch (Exception unused) {
            }
        }
        log("Unable to parse the integer system property '" + str + "':" + lowerCase + " - using the default value: " + i);
        return i;
    }

    public static long getLong(String str, long j) {
        String str2 = get(str);
        if (str2 == null) {
            return j;
        }
        String lowerCase = str2.trim().toLowerCase();
        if (INTEGER_PATTERN.matcher(lowerCase).matches()) {
            try {
                return Long.parseLong(lowerCase);
            } catch (Exception unused) {
            }
        }
        log("Unable to parse the long integer system property '" + str + "':" + lowerCase + " - using the default value: " + j);
        return j;
    }

    private static void log(String str) {
        if (initializedLogger) {
            logger.warn(str);
        } else {
            Logger.getLogger(SystemPropertyUtil.class.getName()).log(Level.WARNING, str);
        }
    }

    private static void log(String str, Exception exc) {
        if (initializedLogger) {
            logger.warn(str, (Throwable) exc);
        } else {
            Logger.getLogger(SystemPropertyUtil.class.getName()).log(Level.WARNING, str, (Throwable) exc);
        }
    }

    private SystemPropertyUtil() {
    }
}
