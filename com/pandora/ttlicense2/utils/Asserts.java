package com.pandora.ttlicense2.utils;

import android.os.Looper;
import io.netty.util.internal.StringUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Asserts {
    public static void checkMainThread() {
        checkThread(Looper.getMainLooper());
    }

    public static void checkThread(Looper looper) {
        checkNotNull(looper);
        if (Thread.currentThread() != looper.getThread()) {
            throw new IllegalThreadStateException(String.format("You must call this method in %s thread!", looper.getThread()));
        }
    }

    public static void checkState(int currentState, int... validStates) {
        for (int i : validStates) {
            if (currentState == i) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i2 : validStates) {
            sb.append(i2).append(",");
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        throw new IllegalStateException(String.format("Thread:%s. Current state is %s, You can only call this method in %s", Thread.currentThread().getName(), Integer.valueOf(currentState), sb.toString()));
    }

    public static void checkState(boolean legalState) {
        if (!legalState) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean legalState, String illegalMsg) {
        if (!legalState) {
            throw new IllegalStateException(illegalMsg);
        }
    }

    public static void checkArgument(boolean legalArgument) {
        if (!legalArgument) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    public static <T> T checkNotNull(T t, String msg) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(msg);
    }

    public static <T> T checkOneOf(T o, T... ts) {
        ts.getClass();
        for (T t : ts) {
            if (o == t) {
                return o;
            }
        }
        StringBuilder sb = new StringBuilder(91);
        for (T t2 : ts) {
            sb.append(t2).append(StringUtil.COMMA);
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        throw new IllegalArgumentException(o + " must be one of " + ((Object) sb));
    }
}
