package com.baidu.mobads.container.util.f;

import android.app.KeyguardManager;
import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class w {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (keyguardManager == null) {
                return;
            }
            String str = (String) keyguardManager.getClass().getMethod("obtainOaid", new Class[0]).invoke(keyguardManager, new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                z.a(str);
                z.a(2592000000L, str);
            }
        } catch (Throwable th) {
        }
    }
}
