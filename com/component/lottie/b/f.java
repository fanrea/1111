package com.component.lottie.b;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import com.baidu.mobads.container.l.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class f {
    private static final String a = "TraceCompat";
    private static long b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static Method f;

    static {
        if (Build.VERSION.SDK_INT >= 18 && Build.VERSION.SDK_INT < 29) {
            try {
                b = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                c = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                d = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                e = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                f = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            } catch (Exception e2) {
                g.h(a).c("Unable to initialize via reflection.", e2);
            }
        }
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT >= 29) {
            return Trace.isEnabled();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                Boolean bool = (Boolean) c.invoke(null, Long.valueOf(b));
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception e2) {
                Log.v(a, "Unable to invoke isTagEnabled() via reflection.");
            }
        }
        return false;
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static void a(String str, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.beginAsyncSection(str, i);
        } else if (Build.VERSION.SDK_INT >= 18) {
            try {
                d.invoke(null, Long.valueOf(b), str, Integer.valueOf(i));
            } catch (Exception e2) {
                Log.v(a, "Unable to invoke asyncTraceBegin() via reflection.");
            }
        }
    }

    public static void b(String str, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.endAsyncSection(str, i);
        } else if (Build.VERSION.SDK_INT >= 18) {
            try {
                e.invoke(null, Long.valueOf(b), str, Integer.valueOf(i));
            } catch (Exception e2) {
                Log.v(a, "Unable to invoke endAsyncSection() via reflection.");
            }
        }
    }

    public static void c(String str, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.setCounter(str, i);
        } else if (Build.VERSION.SDK_INT >= 18) {
            try {
                f.invoke(null, Long.valueOf(b), str, Integer.valueOf(i));
            } catch (Exception e2) {
                Log.v(a, "Unable to invoke traceCounter() via reflection.");
            }
        }
    }

    private f() {
    }
}
