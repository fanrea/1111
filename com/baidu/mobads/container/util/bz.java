package com.baidu.mobads.container.util;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bz {
    private static bz a;
    private AtomicBoolean b = new AtomicBoolean(false);
    private Context c;

    public static bz a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new bz();
                }
            }
        }
        return a;
    }

    public void a(Context context) {
        if (this.b.get()) {
            return;
        }
        this.c = context.getApplicationContext();
        this.b.set(true);
        try {
            com.baidu.mobads.container.d.b.a().a(new ca(this));
        } catch (Throwable th) {
        }
    }
}
