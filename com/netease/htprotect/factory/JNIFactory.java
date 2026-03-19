package com.netease.htprotect.factory;

import android.content.Context;
import com.netease.htprotect.HTProtectConfig;
import com.netease.htprotect.callback.HTPCallback;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class JNIFactory {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static JNIFactory f50O8oO888;

    private JNIFactory() {
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static JNIFactory m518O8oO888() {
        if (f50O8oO888 == null) {
            f50O8oO888 = new JNIFactory();
        }
        return f50O8oO888;
    }

    public native byte[] aebd1811194e82d9(String str);

    public native String d0f149b4da6ec477(int i, String str);

    public native String d8f5300ec791da421(String str, int i);

    public native byte[] e3aa07afb863c1kva(byte[] bArr);

    public native String e9edd62242ad7aecf(String str, int i);

    public native void f190da6241bff18bf();

    public native void hccd63688a790ca65(Context context, String str, HTPCallback hTPCallback, HTProtectConfig hTProtectConfig);

    public native byte[] r25d273c7ad4065c1(String str, int i, boolean z);

    public native byte[] r25d273c7ad4065c3(byte[] bArr, int i, int i2, boolean z, int i3, boolean z2);

    public native String r316e12523620efb7(String str, int i);

    public native int t76euy9fu8bv485zh(String str, String str2, String str3, String str4, String str5, int i, String str6);

    public native void u233ace17d63ca9e(boolean z, int i, int i2, int i3, int i4, int i5);

    public native String w3facf96be4b4fd19(int i, String str);
}
