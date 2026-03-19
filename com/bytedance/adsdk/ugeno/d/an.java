package com.bytedance.adsdk.ugeno.d;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private Context b;
    private com.bytedance.adsdk.ugeno.hc.b c;
    private List<b> d;
    private List<d> hc;

    public an(Context context, com.bytedance.adsdk.ugeno.hc.b bVar, List<b> list) {
        this.c = bVar;
        this.b = context;
        this.d = list;
        c();
    }

    private void c() {
        this.hc = new ArrayList();
        List<b> list = this.d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.d.size(); i++) {
            b bVar = this.d.get(i);
            if (bVar != null) {
                this.hc.add(new d(this.b, this.c, bVar));
            }
        }
    }

    public void d() {
        List<d> list = this.hc;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d dVar : this.hc) {
            if (dVar != null) {
                dVar.c();
            }
        }
    }

    public void hc() {
        List<d> list = this.hc;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d dVar : this.hc) {
            if (dVar != null) {
                dVar.d();
            }
        }
    }

    public void b() {
        List<d> list = this.hc;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d dVar : this.hc) {
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    public void d(Canvas canvas) {
        List<d> list = this.hc;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d dVar : this.hc) {
            if (dVar != null) {
                dVar.d(canvas);
            }
        }
    }

    public void d(int i, int i2) {
        List<d> list = this.hc;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d dVar : this.hc) {
            if (dVar != null) {
                dVar.d(i, i2);
            }
        }
    }

    public d d(String str) {
        List<d> list = this.hc;
        if (list != null && !list.isEmpty()) {
            for (d dVar : this.hc) {
                if (dVar != null && TextUtils.equals(dVar.u(), str)) {
                    return dVar;
                }
            }
        }
        return null;
    }
}
