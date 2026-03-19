package com.sigmob.sdk.videocache;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o {
    public static <T> T a(T reference) {
        reference.getClass();
        return reference;
    }

    public static <T> T a(T reference, String errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(errorMessage);
    }

    static void a(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    static void a(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void a(Object... references) {
        for (Object obj : references) {
            obj.getClass();
        }
    }
}
