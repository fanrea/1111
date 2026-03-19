package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.ic;
import com.bytedance.embedapplog.kb;
import com.bytedance.embedapplog.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class p extends js<kb> {
    final tj d;
    final ox hc;

    @Override // com.bytedance.embedapplog.js, com.bytedance.embedapplog.ic
    public /* bridge */ /* synthetic */ boolean d(Context context) {
        return super.d(context);
    }

    p() {
        super("com.hihonor.id");
        this.d = new tj();
        this.hc = new ox();
    }

    @Override // com.bytedance.embedapplog.js
    protected tc.hc<kb, String> d() {
        return new tc.hc<kb, String>() { // from class: com.bytedance.embedapplog.p.1
            @Override // com.bytedance.embedapplog.tc.hc
            /* renamed from: hc, reason: merged with bridge method [inline-methods] */
            public kb d(IBinder iBinder) {
                return kb.d.d(iBinder);
            }

            @Override // com.bytedance.embedapplog.tc.hc
            public String d(kb kbVar) {
                if (kbVar == null) {
                    com.bytedance.sdk.component.utils.mq.c("honor# ", "service is null");
                    return null;
                }
                kbVar.d(p.this.d);
                kbVar.hc(p.this.hc);
                return "";
            }
        };
    }

    @Override // com.bytedance.embedapplog.js
    protected Intent b(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.bytedance.embedapplog.js, com.bytedance.embedapplog.ic
    public ic.d hc(Context context) {
        new tc(context, b(context), d()).d();
        ic.d dVar = new ic.d();
        dVar.hc = this.d.hc();
        dVar.b = this.hc.hc();
        return dVar;
    }
}
