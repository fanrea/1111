package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Persimmon {
    public static boolean a(Context context) {
        Context context2;
        PackageInfo packageInfo;
        if (context.getPackageManager() == null) {
            return false;
        }
        String strA = Cfinally.a(Cfinally.l);
        try {
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            synchronized (Ccase.class) {
                context2 = Ccase.a;
            }
            if (context2 != null && (packageInfo = context2.getPackageManager().getPackageInfo(strA, 0)) != null && strA.equals(packageInfo.packageName)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int b(Context context) {
        boolean z;
        String str;
        String[] strArrSplit;
        System.currentTimeMillis();
        boolean z2 = false;
        int iA = Cthis.a(0, a(context), 0);
        System.currentTimeMillis();
        try {
            str = new String(Cstrictfp.a(Cfinally.a(Cfinally.n)));
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\n")) == null || strArrSplit.length == 0) {
            z = false;
        } else {
            String packageName = context.getPackageName();
            for (String str2 : strArrSplit) {
                if (a(packageName, str2)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        int iA2 = Cthis.a(iA, z, 1);
        System.currentTimeMillis();
        Object obj = new Object();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        atomicReference.set(Boolean.FALSE);
        Handler handler = new Handler(context.getMainLooper());
        System.currentTimeMillis();
        handler.post(new Pear(atomicBoolean, atomicReference, obj));
        synchronized (obj) {
            try {
                obj.wait(100L);
            } catch (InterruptedException unused2) {
            }
        }
        atomicBoolean.set(true);
        int iA3 = Cthis.a(iA2, ((Boolean) atomicReference.get()).booleanValue(), 2);
        System.currentTimeMillis();
        try {
            ClassLoader.getSystemClassLoader().loadClass(Cfinally.a(Cfinally.E0));
            z2 = true;
        } catch (Throwable unused3) {
        }
        return Cthis.a(iA3, z2, 3);
    }

    public static boolean a(String str, String str2) {
        int iIndexOf;
        if (str2 == null || (iIndexOf = str2.indexOf(47)) == -1) {
            return false;
        }
        String strTrim = str2.substring(iIndexOf).trim();
        if (!strTrim.startsWith("/data/")) {
            return false;
        }
        if (strTrim.startsWith("/data/data/" + str + "/")) {
            return false;
        }
        boolean zEndsWith = strTrim.endsWith(".so");
        return (zEndsWith || (!zEndsWith && strTrim.endsWith(".jar"))) && str2.contains(Cfinally.a(Cfinally.m));
    }
}
