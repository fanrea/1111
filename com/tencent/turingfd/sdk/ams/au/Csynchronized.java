package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.synchronized, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Csynchronized {

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.synchronized$do, reason: invalid class name */
    public static class Cdo implements CanisMinor {
        public final String[] a;
        public volatile int b = 0;

        public Cdo(String[] strArr) {
            this.a = strArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x01fe  */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0206  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x00fb A[PHI: r1
  0x00fb: PHI (r1v54 int) = (r1v33 int), (r1v34 int), (r1v37 int), (r1v40 int), (r1v43 int), (r1v46 int), (r1v34 int), (r1v47 int) binds: [B:75:0x00f9, B:92:0x017a, B:100:0x01df, B:98:0x01c1, B:94:0x0185, B:96:0x01a3, B:88:0x0174, B:90:0x0177] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x00fe  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.tencent.turingfd.sdk.ams.au.CanisMinor.Cdo a(byte[] r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 599
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Csynchronized.Cdo.a(byte[]):com.tencent.turingfd.sdk.ams.au.CanisMinor$do");
        }
    }

    public static String a(Context context) {
        return Build.VERSION.SDK_INT >= 14 ? System.getProperty("http.proxyHost") : Proxy.getHost(context);
    }

    public static int b(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return Proxy.getPort(context);
        }
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
