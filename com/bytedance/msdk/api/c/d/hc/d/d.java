package com.bytedance.msdk.api.c.d.hc.d;

import android.view.View;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d extends com.bytedance.msdk.api.c.d.hc.hc.d {
    public abstract View hc();

    public final View d() {
        try {
            return hc();
        } catch (Exception e) {
            mq.d(e);
            return null;
        }
    }
}
