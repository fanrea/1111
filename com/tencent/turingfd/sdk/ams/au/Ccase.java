package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.case, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Ccase {
    public static Context a;

    public static synchronized boolean a(Context context) {
        if (a != null) {
            return true;
        }
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        a = applicationContext;
        return true;
    }

    public static synchronized Context a() {
        return a;
    }
}
