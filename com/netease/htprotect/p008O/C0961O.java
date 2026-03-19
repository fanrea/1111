package com.netease.htprotect.p008O;

import android.content.Context;

/* renamed from: com.netease.htprotect.〇O.〇O〇, reason: invalid class name and case insensitive filesystem */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class C0961O {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m698O8oO888(Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            return (String) cls.getMethod("getOAID", Context.class).invoke(cls.newInstance(), context);
        } catch (Exception unused) {
            return null;
        }
    }
}
