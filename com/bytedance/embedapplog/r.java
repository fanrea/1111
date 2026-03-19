package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.e;
import com.bytedance.embedapplog.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class r extends js<e> {
    r() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.embedapplog.js
    protected tc.hc<e, String> d() {
        return new tc.hc<e, String>() { // from class: com.bytedance.embedapplog.r.1
            @Override // com.bytedance.embedapplog.tc.hc
            /* renamed from: hc, reason: merged with bridge method [inline-methods] */
            public e d(IBinder iBinder) {
                return e.d.d(iBinder);
            }

            @Override // com.bytedance.embedapplog.tc.hc
            public String d(e eVar) {
                if (eVar == null) {
                    return null;
                }
                return eVar.b();
            }
        };
    }

    @Override // com.bytedance.embedapplog.js
    protected Intent b(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
