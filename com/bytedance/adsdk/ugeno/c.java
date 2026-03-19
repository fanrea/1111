package com.bytedance.adsdk.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.u.gb;
import com.bytedance.adsdk.ugeno.u.tc;
import com.bytedance.adsdk.ugeno.u.u;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static volatile c d;
    private com.bytedance.adsdk.ugeno.b.hc.c an;
    private com.bytedance.adsdk.ugeno.b.b b;
    private d c;
    private com.bytedance.adsdk.ugeno.b.d.d h;
    private List<com.bytedance.adsdk.ugeno.b.hc> hc;
    private com.bytedance.adsdk.ugeno.c.d u;

    public static c d() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    private c() {
    }

    public void d(Context context, com.bytedance.adsdk.ugeno.b.b bVar, d dVar) {
        this.b = bVar;
        this.c = dVar;
        an();
    }

    public d hc() {
        return this.c;
    }

    private void an() {
        ArrayList arrayList = new ArrayList();
        this.hc = arrayList;
        com.bytedance.adsdk.ugeno.b.b bVar = this.b;
        if (bVar != null) {
            arrayList.addAll(bVar.d());
        }
        com.bytedance.adsdk.ugeno.b.c.d(this.hc);
    }

    public void d(com.bytedance.adsdk.ugeno.c.d dVar) {
        this.u = dVar;
    }

    public com.bytedance.adsdk.ugeno.c.d b() {
        return this.u;
    }

    public void d(gb gbVar) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.u.d().d());
        if (gbVar != null) {
            arrayList.addAll(gbVar.d());
        }
        tc.d(arrayList);
    }

    public void d(com.bytedance.adsdk.ugeno.u.b bVar) {
        ArrayList arrayList = new ArrayList(new u().d());
        if (bVar != null) {
            arrayList.addAll(bVar.d());
        }
        com.bytedance.adsdk.ugeno.u.c.d(arrayList);
    }

    public void d(com.bytedance.adsdk.ugeno.b.hc.c cVar) {
        this.an = cVar;
    }

    public com.bytedance.adsdk.ugeno.b.hc.c c() {
        return this.an;
    }

    public void d(com.bytedance.adsdk.ugeno.b.d.d dVar) {
        this.h = dVar;
    }

    public com.bytedance.adsdk.ugeno.b.d.d u() {
        return this.h;
    }
}
