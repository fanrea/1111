package com.netease.htprotect.p008O;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.netease.htprotect.p008O.InterfaceC0963oO;

/* renamed from: com.netease.htprotect.〇O.〇o8OOoO0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o8OOoO0 {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m705O8oO888(Context context) throws PackageManager.NameNotFoundException {
        String strMo709Ooo = null;
        try {
            context.getPackageManager().getPackageInfo("com.mdid.msa", 0);
        } catch (Exception unused) {
        }
        if (!m706Ooo(context)) {
            return null;
        }
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        O8O00oo o8O00oo = new O8O00oo();
        if (context.bindService(intent, o8O00oo, 1)) {
            try {
            } catch (Exception unused2) {
            } catch (Throwable th) {
                try {
                    context.unbindService(o8O00oo);
                } catch (Exception unused3) {
                }
                throw th;
            }
            if (o8O00oo.f236O8oO888) {
                throw new IllegalStateException();
            }
            o8O00oo.f236O8oO888 = true;
            strMo709Ooo = InterfaceC0963oO.O8oO888.m711O8oO888((IBinder) o8O00oo.f237Ooo.take()).mo709Ooo();
            context.unbindService(o8O00oo);
        }
        return strMo709Ooo;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static boolean m706Ooo(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.setAction("com.bun.msa.action.start.service");
            intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
