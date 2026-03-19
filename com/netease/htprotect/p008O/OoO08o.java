package com.netease.htprotect.p008O;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.netease.htprotect.p008O.C80o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class OoO08o {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m654O8oO888(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            O8O00oo o8O00oo = new O8O00oo();
            if (context.bindService(intent, o8O00oo, 1)) {
                try {
                    if (o8O00oo.f236O8oO888) {
                        throw new IllegalStateException();
                    }
                    o8O00oo.f236O8oO888 = true;
                    String strMo680O8oO888 = C80o.O8oO888.m681O8oO888((IBinder) o8O00oo.f237Ooo.take()).mo680O8oO888();
                    try {
                        context.unbindService(o8O00oo);
                        return strMo680O8oO888;
                    } catch (Exception unused) {
                        return strMo680O8oO888;
                    }
                } catch (Exception unused2) {
                    context.unbindService(o8O00oo);
                } catch (Throwable th) {
                    try {
                        context.unbindService(o8O00oo);
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused4) {
        }
        return null;
    }
}
