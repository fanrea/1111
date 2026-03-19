package com.netease.htprotect.p008O;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.netease.htprotect.p008O.O8;

/* renamed from: com.netease.htprotect.〇O.o0o8〇, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o0o8 {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m671O8oO888(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0);
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            O8O00oo o8O00oo = new O8O00oo();
            if (context.bindService(intent, o8O00oo, 1)) {
                try {
                    if (o8O00oo.f236O8oO888) {
                        throw new IllegalStateException();
                    }
                    o8O00oo.f236O8oO888 = true;
                    String strMo687O8oO888 = O8.O8oO888.m688O8oO888((IBinder) o8O00oo.f237Ooo.take()).mo687O8oO888();
                    try {
                        context.unbindService(o8O00oo);
                        return strMo687O8oO888;
                    } catch (Exception unused) {
                        return strMo687O8oO888;
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
