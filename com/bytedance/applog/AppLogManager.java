package com.bytedance.applog;

import com.bytedance.bdtracker.b;
import com.bytedance.bdtracker.l0;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class AppLogManager {
    public static IAppLogInstance getInstance(String str) {
        if (l0.b.c(str)) {
            return null;
        }
        return b.a(str);
    }
}
