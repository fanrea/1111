package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdtracker.n5;
import com.bytedance.dr.aidl.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class l extends b<com.bytedance.dr.aidl.b> {

    public class a implements n5.b<com.bytedance.dr.aidl.b, String> {
        public a(l lVar) {
        }

        @Override // com.bytedance.bdtracker.n5.b
        public com.bytedance.dr.aidl.b a(IBinder iBinder) {
            return b.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.n5.b
        public String a(com.bytedance.dr.aidl.b bVar) {
            return ((b.a.C0192a) bVar).a();
        }
    }

    public l() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public n5.b<com.bytedance.dr.aidl.b, String> a() {
        return new a(this);
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Samsung";
    }
}
