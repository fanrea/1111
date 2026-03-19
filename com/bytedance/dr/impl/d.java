package com.bytedance.dr.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdtracker.n5;
import com.bytedance.dr.OaidApi;
import com.bytedance.dr.aidl.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends b<com.bytedance.dr.aidl.a> {
    public final Context c;

    public class a implements n5.b<com.bytedance.dr.aidl.a, String> {
        public a() {
        }

        @Override // com.bytedance.bdtracker.n5.b
        public com.bytedance.dr.aidl.a a(IBinder iBinder) {
            return a.AbstractBinderC0190a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.n5.b
        public String a(com.bytedance.dr.aidl.a aVar) {
            com.bytedance.dr.aidl.a aVar2 = aVar;
            if (aVar2 == null) {
                return null;
            }
            return ((a.AbstractBinderC0190a.C0191a) aVar2).a(d.this.c.getPackageName());
        }
    }

    public d(Context context) {
        super("com.coolpad.deviceidsupport");
        this.c = context;
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public n5.b<com.bytedance.dr.aidl.a, String> a() {
        return new a();
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "coolpad";
    }

    @Override // com.bytedance.dr.impl.b, com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
                if (!TextUtils.isEmpty(string)) {
                    OaidApi.a aVar = new OaidApi.a();
                    aVar.a = string;
                    return aVar;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.getOaid(context);
    }
}
