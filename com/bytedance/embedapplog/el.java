package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.tc;
import com.bytedance.embedapplog.uo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class el extends js<uo> {
    el() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.js
    protected tc.hc<uo, String> d() {
        return new tc.hc<uo, String>() { // from class: com.bytedance.embedapplog.el.1
            @Override // com.bytedance.embedapplog.tc.hc
            /* renamed from: hc, reason: merged with bridge method [inline-methods] */
            public uo d(IBinder iBinder) {
                return uo.d.d(iBinder);
            }

            @Override // com.bytedance.embedapplog.tc.hc
            public String d(uo uoVar) {
                return uoVar.d();
            }
        };
    }

    @Override // com.bytedance.embedapplog.js
    protected Intent b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
