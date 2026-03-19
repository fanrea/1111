package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.pm.Signature;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.implements, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cimplements {
    public static Signature[] a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Throwable unused) {
            return null;
        }
    }
}
