package com.netease.htprotect.p008O;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.netease.htprotect.p008O.o0o0;

/* renamed from: com.netease.htprotect.〇O.〇o〇0O〇0O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o0O0O {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m713O8oO888(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            O8O00oo o8O00oo = new O8O00oo();
            if (context.bindService(intent, o8O00oo, 1)) {
                try {
                    if (o8O00oo.f236O8oO888) {
                        throw new IllegalStateException();
                    }
                    o8O00oo.f236O8oO888 = true;
                    String strMo701O8 = o0o0.O8oO888.m703O8oO888((IBinder) o8O00oo.f237Ooo.take()).mo701O8();
                    try {
                        context.unbindService(o8O00oo);
                        return strMo701O8;
                    } catch (Exception unused) {
                        return strMo701O8;
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
