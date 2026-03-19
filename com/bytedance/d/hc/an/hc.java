package com.bytedance.d.hc.an;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.d.hc.gb;
import com.bytedance.d.hc.gb.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends d {
    hc(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String strU = gb.d().u();
        if (TextUtils.isEmpty(strU) || "0".equals(strU)) {
            d(b());
            tc.d("[DeviceIdTask] did is null, continue check.");
        } else {
            gb.b().d(strU);
            tc.d("[DeviceIdTask] did is ".concat(String.valueOf(strU)));
        }
    }
}
