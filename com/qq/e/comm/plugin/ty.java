package com.qq.e.comm.plugin;

import android.content.Context;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ty {
    static j20 a = new j20();

    static String a(String str) throws UnsupportedEncodingException {
        return (String) pro.getobjresult(354, 1, str);
    }

    static void a(Context context) {
        pro.getVresult(355, 1, context);
    }

    private static void a(Context context, String str) {
        pro.getVresult(356, 1, context, str);
    }

    private static void a(boolean z, String str, String str2, String str3) {
        pro.getVresult(357, 1, Boolean.valueOf(z), str, str2, str3);
    }

    static boolean a(Context context, String str, String str2) {
        return pro.getZresult(358, 1, context, str, str2);
    }

    private static final boolean a(Context context, String str, String str2, String str3) {
        return pro.getZresult(359, 1, context, str, str2, str3);
    }

    private static Pair<String, String> b(Context context, String str) {
        return (Pair) pro.getobjresult(360, 1, context, str);
    }

    static b<bu> b(Context context) {
        return (b) pro.getobjresult(361, 1, context);
    }

    static boolean b(Context context, String str, String str2) {
        return pro.getZresult(362, 1, context, str, str2);
    }

    private static boolean b(Context context, String str, String str2, String str3) {
        return pro.getZresult(363, 1, context, str, str2, str3);
    }

    static b<tx> c(Context context) {
        return (b) pro.getobjresult(364, 1, context);
    }

    static boolean c(Context context, String str, String str2) {
        return pro.getZresult(365, 1, context, str, str2);
    }

    /* compiled from: A */
    static class b<T> {
        private final String a;
        private final T b;

        private b(String str, T t) {
            this.a = str;
            this.b = t;
        }

        public String b() {
            return this.a;
        }

        public T a() {
            return this.b;
        }
    }
}
