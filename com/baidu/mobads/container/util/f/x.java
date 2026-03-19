package com.baidu.mobads.container.util.f;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mobads.container.util.DeviceUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class x {
    public static boolean a() {
        boolean zEqualsIgnoreCase;
        try {
            String strB = DeviceUtils.getInstance().b();
            if (TextUtils.isEmpty(strB)) {
                zEqualsIgnoreCase = false;
            } else {
                zEqualsIgnoreCase = strB.equalsIgnoreCase(com.bytedance.common.utility.DeviceUtils.ROM_SAMSUNG);
            }
            try {
                if (com.baidu.mobads.container.util.x.a(null).a() < 29) {
                    return false;
                }
                return zEqualsIgnoreCase;
            } catch (Throwable th) {
                return zEqualsIgnoreCase;
            }
        } catch (Throwable th2) {
            return false;
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        try {
            context.bindService(intent, new y(context), 1);
        } catch (Throwable th) {
            z.a(context, "sam-serror1" + th.getMessage(), "");
        }
    }
}
