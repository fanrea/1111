package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.ic;
import com.bytedance.embedapplog.tc;
import com.bytedance.embedapplog.w;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class mb extends js<w> {
    mb() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.embedapplog.js, com.bytedance.embedapplog.ic
    public ic.d hc(Context context) {
        d(context, context.getPackageName());
        return super.hc(context);
    }

    @Override // com.bytedance.embedapplog.js
    protected tc.hc<w, String> d() {
        return new tc.hc<w, String>() { // from class: com.bytedance.embedapplog.mb.1
            @Override // com.bytedance.embedapplog.tc.hc
            /* renamed from: hc, reason: merged with bridge method [inline-methods] */
            public w d(IBinder iBinder) {
                return w.d.d(iBinder);
            }

            @Override // com.bytedance.embedapplog.tc.hc
            public String d(w wVar) {
                if (wVar == null) {
                    return null;
                }
                return wVar.d();
            }
        };
    }

    @Override // com.bytedance.embedapplog.js
    protected Intent b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    private void d(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            um.d(e);
        }
    }
}
