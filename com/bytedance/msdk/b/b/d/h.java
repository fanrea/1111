package com.bytedance.msdk.b.b.d;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.b.b.d.d;
import com.bytedance.msdk.gb.j;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h implements d.InterfaceC0214d {
    private int b;
    private int c;
    private List<d> d;
    private com.bytedance.msdk.b.an.d.hc hc;

    static /* synthetic */ int an(h hVar) {
        int i = hVar.c;
        hVar.c = i + 1;
        return i;
    }

    static /* synthetic */ int c(h hVar) {
        int i = hVar.b;
        hVar.b = i + 1;
        return i;
    }

    public h(List<d> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList;
        this.b = 0;
        this.c = 0;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    @Override // com.bytedance.msdk.b.b.d.d.InterfaceC0214d
    public void d(com.bytedance.msdk.b.an.d.hc hcVar) {
        if (this.hc != hcVar && hcVar != null) {
            this.hc = hcVar;
        }
        if (j.d(this.d)) {
            return;
        }
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.b.b.d.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.b == 0 && h.this.hc != null) {
                    h.this.hc.hc(SystemClock.elapsedRealtime());
                }
                if (h.this.d.size() > h.this.b) {
                    ((d) h.this.d.get(h.c(h.this))).d(h.this);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.b.b.d.d.InterfaceC0214d
    public com.bytedance.msdk.b.an.d.hc d() {
        return this.hc;
    }

    @Override // com.bytedance.msdk.b.b.d.d.InterfaceC0214d
    public void d(String str) {
        com.bytedance.msdk.b.an.d.hc hcVar;
        if (!TextUtils.isEmpty(str) && (hcVar = this.hc) != null) {
            hcVar.hc(str);
        }
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.b.b.d.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.d.size() > h.this.c) {
                    ((d) h.this.d.get(h.an(h.this))).hc(h.this);
                }
            }
        });
    }
}
