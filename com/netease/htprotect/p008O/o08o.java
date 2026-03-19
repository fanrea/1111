package com.netease.htprotect.p008O;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.netease.htprotect.p008O.InterfaceC0960O;
import java.security.MessageDigest;

/* renamed from: com.netease.htprotect.〇O.o〇0〇8o〇, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o08o {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static synchronized String m674O8oO888(Context context) {
        String strM676O8oO888 = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        if (!m678Ooo(context)) {
            return null;
        }
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            O8O00oo o8O00oo = new O8O00oo();
            if (context.bindService(intent, o8O00oo, 1)) {
                try {
                } catch (Exception unused) {
                } catch (Throwable th) {
                    try {
                        context.unbindService(o8O00oo);
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
                if (o8O00oo.f236O8oO888) {
                    throw new IllegalStateException();
                }
                o8O00oo.f236O8oO888 = true;
                strM676O8oO888 = m676O8oO888(InterfaceC0960O.O8oO888.m686O8oO888((IBinder) o8O00oo.f237Ooo.take()), context);
                context.unbindService(o8O00oo);
            }
        } catch (Exception unused3) {
        }
        return strM676O8oO888;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m675O8oO888(Signature signature) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(signature.toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m676O8oO888(InterfaceC0960O interfaceC0960O, Context context) {
        String strMo684O8oO888;
        if (interfaceC0960O == null) {
            return null;
        }
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArrM677O8oO888 = m677O8oO888(context, packageName);
            strMo684O8oO888 = interfaceC0960O.mo684O8oO888(packageName, (signatureArrM677O8oO888 == null || signatureArrM677O8oO888.length <= 0) ? null : m675O8oO888(signatureArrM677O8oO888[0]), "OUID");
        } catch (Exception unused) {
            strMo684O8oO888 = null;
        }
        if (TextUtils.isEmpty(strMo684O8oO888)) {
            return null;
        }
        return strMo684O8oO888;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static Signature[] m677O8oO888(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static boolean m678Ooo(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
        } catch (Exception unused) {
        }
        return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode > 0;
    }
}
