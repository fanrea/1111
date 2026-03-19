package com.bytedance.adsdk.ugeno.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    int an;
    int cb;
    int e;
    int gb;
    int h;
    float mk;
    int mq;
    float tc;
    int tt;
    int u;
    int uo;
    boolean w;
    boolean yo;
    int d = Integer.MAX_VALUE;
    int hc = Integer.MAX_VALUE;
    int b = Integer.MIN_VALUE;
    int c = Integer.MIN_VALUE;
    List<Integer> k = new ArrayList();

    b() {
    }

    public int d() {
        return this.h;
    }

    public int hc() {
        return this.gb - this.tt;
    }

    void d(View view, int i, int i2, int i3, int i4) {
        hc hcVar = (hc) view.getLayoutParams();
        this.d = Math.min(this.d, (view.getLeft() - hcVar.uo()) - i);
        this.hc = Math.min(this.hc, (view.getTop() - hcVar.k()) - i2);
        this.b = Math.max(this.b, view.getRight() + hcVar.e() + i3);
        this.c = Math.max(this.c, view.getBottom() + hcVar.cb() + i4);
    }
}
