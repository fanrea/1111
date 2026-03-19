package com.bytedance.sdk.component.hc.d.d;

import com.bytedance.sdk.component.b.hc.v;
import com.bytedance.sdk.component.hc.d.d.d.an;
import com.bytedance.sdk.component.hc.d.d.hc.b;
import com.bytedance.sdk.component.hc.d.mq;
import com.bytedance.sdk.component.utils.mq;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d d;
    private static AtomicBoolean hc = new AtomicBoolean(true);

    private d() {
    }

    public static d d() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    public void d(boolean z) {
        mq.d("NetClientAdapter", "set useOkHttp:".concat(String.valueOf(z)));
        hc.set(z);
    }

    public boolean hc() {
        AtomicBoolean atomicBoolean = hc;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    public static com.bytedance.sdk.component.hc.d.mq d(mq.d dVar) {
        return new b(dVar);
    }

    public static com.bytedance.sdk.component.hc.d.mq d(v.d dVar) {
        return new an(dVar);
    }
}
