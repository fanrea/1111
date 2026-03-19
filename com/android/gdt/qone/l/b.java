package com.android.gdt.qone.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class b {
    public static String a(Context context) {
        String strB;
        if (!a.a) {
            throw new RuntimeException("SDK Need Init First!");
        }
        i iVar = i.f;
        if (context != null && context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (iVar) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot run on MainThread");
            }
            if (iVar.a == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                try {
                    if (context.bindService(intent, iVar.e, 1)) {
                        synchronized (iVar.d) {
                            try {
                                iVar.d.wait(com.alipay.sdk.m.u.b.a);
                            } finally {
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
                if (iVar.a == null) {
                    strB = "";
                } else {
                    try {
                        strB = iVar.b(context);
                    } catch (Exception e) {
                        e.printStackTrace();
                        strB = "";
                    }
                }
            } else {
                try {
                    strB = iVar.b(context);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    strB = "";
                }
            }
        }
        return strB;
    }
}
