package com.bytedance.msdk.gb.c;

import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static Function<SparseArray<Object>, Object> d;

    public static void d(Function<SparseArray<Object>, Object> function) {
        d = function;
    }

    public static String d() {
        Function<SparseArray<Object>, Object> function = d;
        if (function != null) {
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(10004).d(String.class).hc());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    public static String hc() {
        Function<SparseArray<Object>, Object> function = d;
        if (function != null) {
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(10005).d(String.class).hc());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    public static String b() {
        Function<SparseArray<Object>, Object> function = d;
        if (function != null) {
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(10006).d(String.class).hc());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }
}
