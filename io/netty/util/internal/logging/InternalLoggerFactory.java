package io.netty.util.internal.logging;

import io.netty.util.internal.ThreadLocalRandom;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class InternalLoggerFactory {
    private static volatile InternalLoggerFactory defaultFactory = newDefaultFactory(InternalLoggerFactory.class.getName());

    protected abstract InternalLogger newInstance(String str);

    static {
        try {
            Class.forName(ThreadLocalRandom.class.getName(), true, InternalLoggerFactory.class.getClassLoader());
        } catch (Exception unused) {
        }
    }

    private static InternalLoggerFactory newDefaultFactory(String str) {
        try {
            try {
                Slf4JLoggerFactory slf4JLoggerFactory = new Slf4JLoggerFactory(true);
                slf4JLoggerFactory.newInstance(str).debug("Using SLF4J as the default logging framework");
                return slf4JLoggerFactory;
            } catch (Throwable unused) {
                JdkLoggerFactory jdkLoggerFactory = new JdkLoggerFactory();
                jdkLoggerFactory.newInstance(str).debug("Using java.util.logging as the default logging framework");
                return jdkLoggerFactory;
            }
        } catch (Throwable unused2) {
            Log4JLoggerFactory log4JLoggerFactory = new Log4JLoggerFactory();
            log4JLoggerFactory.newInstance(str).debug("Using Log4J as the default logging framework");
            return log4JLoggerFactory;
        }
    }

    public static InternalLoggerFactory getDefaultFactory() {
        return defaultFactory;
    }

    public static void setDefaultFactory(InternalLoggerFactory internalLoggerFactory) {
        if (internalLoggerFactory == null) {
            throw new NullPointerException("defaultFactory");
        }
        defaultFactory = internalLoggerFactory;
    }

    public static InternalLogger getInstance(Class<?> cls) {
        return getInstance(cls.getName());
    }

    public static InternalLogger getInstance(String str) {
        return getDefaultFactory().newInstance(str);
    }
}
