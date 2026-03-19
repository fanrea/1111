package com.baidu.mobads.container.activity;

import android.app.Activity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    private static volatile d a;
    private c b;

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public void a(Activity activity, String str) {
        if (this.b != null) {
            this.b.a(activity, str);
        }
    }

    public void a(c cVar) {
        this.b = cVar;
    }

    public void b() {
        this.b = null;
    }
}
