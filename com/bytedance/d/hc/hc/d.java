package com.bytedance.d.hc.hc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.d.hc.gb.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d d;
    private SQLiteDatabase b;
    private com.bytedance.d.hc.hc.hc.hc hc;

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

    public void d(Context context) {
        try {
            this.b = new hc(context).getWritableDatabase();
        } catch (Throwable th) {
            tc.hc(th);
        }
        this.hc = new com.bytedance.d.hc.hc.hc.hc();
    }

    public synchronized void d(com.bytedance.d.hc.hc.d.d dVar) {
        com.bytedance.d.hc.hc.hc.hc hcVar = this.hc;
        if (hcVar != null) {
            hcVar.insert(this.b, dVar);
        }
    }

    public synchronized boolean d(String str) {
        com.bytedance.d.hc.hc.hc.hc hcVar = this.hc;
        if (hcVar == null) {
            return false;
        }
        return hcVar.d(this.b, str);
    }
}
