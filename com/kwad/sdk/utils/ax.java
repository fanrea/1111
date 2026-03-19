package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.util.Collection;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ax {
    private static void a(RuntimeException runtimeException) {
        com.kwad.sdk.core.d.c.printStackTrace(runtimeException);
    }

    public static <T> T checkNotNull(T t) {
        return (T) f(t, "");
    }

    public static <T> T f(T t, String str) {
        if (t == null) {
            a(new NullPointerException("Argument cannot be null " + str));
        }
        return t;
    }

    public static String iA(String str) {
        return aD(str, "");
    }

    public static String aD(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            a(new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }

    public static <T extends Collection<Y>, Y> T d(T t) {
        if (t == null || t.isEmpty()) {
            a(new IllegalArgumentException("Must not be null or empty."));
        }
        return t;
    }

    public static void d(Object... objArr) {
        for (int i = 0; i < 2; i++) {
            checkNotNull(objArr[i]);
        }
    }

    public static void checkArgument(boolean z) {
        checkArgument(z, "");
    }

    public static void checkArgument(boolean z, Object obj) {
        if (z) {
            return;
        }
        a(new IllegalArgumentException("Expression cannot be false " + obj));
    }
}
