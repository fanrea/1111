package com.android.gdt.qone.codez.jni;

import android.content.Context;
import com.android.gdt.qone.uin.U;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class X {
    public static String a(String str, String str2, String str3, String str4, String str5) {
        if (!U.a) {
            return "";
        }
        try {
            return uk(str, str2, str3, str4, str5);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    private static native boolean i(Context context, String[] strArr, String str, int i);

    private static native String lk(String str);

    private static native int r(String str, int i);

    private static native String uk(String str, String str2, String str3, String str4, String str5);

    private static native void v();

    public static String a(String str) {
        if (!U.a) {
            return "";
        }
        try {
            return lk(str);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }
}
