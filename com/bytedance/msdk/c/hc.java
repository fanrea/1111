package com.bytedance.msdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.gb.c.b;
import com.bytedance.sdk.component.hc.d.c;
import com.bytedance.sdk.component.tt.d;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static volatile hc d;
    private final com.bytedance.sdk.component.tt.d b;
    private Context hc;

    public static hc d() {
        if (d == null) {
            synchronized (hc.class) {
                if (d == null) {
                    d = new hc(com.bytedance.msdk.core.hc.getContext());
                }
            }
        }
        return d;
    }

    private hc(Context context) {
        this.hc = context == null ? com.bytedance.msdk.core.hc.getContext() : context.getApplicationContext();
        d.C0286d c0286dD = new d.C0286d().d(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).hc(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).b(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).d(true);
        if (b.d() && b.d != null) {
            Object obj = b.d.get("case_id");
            if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                c0286dD.d(new b.d());
            }
        }
        com.bytedance.sdk.component.tt.d dVarD = c0286dD.d();
        this.b = dVarD;
        c cVarD = dVarD.an().d();
        if (cVarD != null) {
            cVarD.d(16);
        }
    }

    public com.bytedance.sdk.component.tt.d hc() {
        return this.b;
    }
}
