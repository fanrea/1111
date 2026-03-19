package com.baidu.mobads.container.util.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.DeviceUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class aa {
    public static boolean a() {
        boolean zEqualsIgnoreCase;
        try {
            String strB = DeviceUtils.getInstance().b();
            if (TextUtils.isEmpty(strB)) {
                zEqualsIgnoreCase = false;
            } else {
                zEqualsIgnoreCase = strB.equalsIgnoreCase("vivo");
            }
            try {
                if (com.baidu.mobads.container.util.x.a(null).a() < 23) {
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
        try {
            com.baidu.mobads.container.d.b.a().a(new ab(context));
        } catch (Throwable th) {
            z.a(context, "vivo-errror" + th.getMessage(), "");
        }
    }
}
