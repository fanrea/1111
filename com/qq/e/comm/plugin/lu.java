package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class lu {
    static void a(boolean z, String str) throws vu {
        if (!z) {
            throw new vu(str);
        }
    }

    static <T> T a(T t) throws vu {
        if (t != null) {
            return t;
        }
        throw new vu("argument is null");
    }

    static <T> T a(T t, String str) throws vu {
        if (t != null) {
            return t;
        }
        throw new vu(str);
    }
}
