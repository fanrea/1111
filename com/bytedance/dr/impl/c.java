package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.n5;
import com.bytedance.dr.OaidApi;
import com.bytedance.dr.aidl.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c extends b<com.bytedance.dr.aidl.f> {

    public class a implements n5.b<com.bytedance.dr.aidl.f, String> {
        public a(c cVar) {
        }

        @Override // com.bytedance.bdtracker.n5.b
        public com.bytedance.dr.aidl.f a(IBinder iBinder) {
            return f.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.n5.b
        public String a(com.bytedance.dr.aidl.f fVar) {
            com.bytedance.dr.aidl.f fVar2 = fVar;
            if (fVar2 == null) {
                return null;
            }
            return ((f.a.C0196a) fVar2).a();
        }
    }

    public c() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public n5.b<com.bytedance.dr.aidl.f, String> a() {
        return new a(this);
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Common";
    }

    @Override // com.bytedance.dr.impl.b, com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            LoggerImpl.global().error(1, "startMsaklServer failed", e, new Object[0]);
        }
        return super.getOaid(context);
    }
}
