package com.apm.insight.m;

import android.os.Handler;
import android.text.TextUtils;
import com.apm.insight.g;
import com.apm.insight.o.q;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c extends a {
    c(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (g.c().b()) {
            q.a((Object) "[DeviceIdTask] did is done, stop check.");
            return;
        }
        String strD = g.a().d();
        if (TextUtils.isEmpty(strD) || "0".equals(strD)) {
            a(c());
            str = "[DeviceIdTask] did is null, continue check.";
        } else {
            g.c().a(strD);
            str = "[DeviceIdTask] did is " + strD;
        }
        q.a((Object) str);
    }
}
