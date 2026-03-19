package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.embedapplog.ic;
import com.bytedance.embedapplog.mq;
import com.bytedance.embedapplog.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class o extends js<mq> {
    private final Context d;

    @Override // com.bytedance.embedapplog.js, com.bytedance.embedapplog.ic
    public /* bridge */ /* synthetic */ boolean d(Context context) {
        return super.d(context);
    }

    o(Context context) {
        super("com.coolpad.deviceidsupport");
        this.d = context;
    }

    @Override // com.bytedance.embedapplog.js
    protected tc.hc<mq, String> d() {
        return new tc.hc<mq, String>() { // from class: com.bytedance.embedapplog.o.1
            @Override // com.bytedance.embedapplog.tc.hc
            /* renamed from: hc, reason: merged with bridge method [inline-methods] */
            public mq d(IBinder iBinder) {
                return mq.d.d(iBinder);
            }

            @Override // com.bytedance.embedapplog.tc.hc
            public String d(mq mqVar) {
                if (mqVar == null) {
                    return null;
                }
                return mqVar.hc(o.this.d.getPackageName());
            }
        };
    }

    @Override // com.bytedance.embedapplog.js
    protected Intent b(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.bytedance.embedapplog.js, com.bytedance.embedapplog.ic
    public ic.d hc(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
                if (!TextUtils.isEmpty(string)) {
                    ic.d dVar = new ic.d();
                    dVar.hc = string;
                    return dVar;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        return super.hc(context);
    }
}
