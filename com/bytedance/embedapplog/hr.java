package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.k;
import com.bytedance.embedapplog.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class hr extends js<k> {
    hr() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.js
    protected tc.hc<k, String> d() {
        return new tc.hc<k, String>() { // from class: com.bytedance.embedapplog.hr.1
            @Override // com.bytedance.embedapplog.tc.hc
            /* renamed from: hc, reason: merged with bridge method [inline-methods] */
            public k d(IBinder iBinder) {
                return k.d.d(iBinder);
            }

            @Override // com.bytedance.embedapplog.tc.hc
            public String d(k kVar) {
                if (kVar == null) {
                    return null;
                }
                return kVar.d();
            }
        };
    }

    @Override // com.bytedance.embedapplog.js
    protected Intent b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
