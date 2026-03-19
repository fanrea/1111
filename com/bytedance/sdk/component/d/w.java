package com.bytedance.sdk.component.d;

import com.bytedance.sdk.component.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class w {
    static de d;
    private volatile boolean an;
    private final com.bytedance.sdk.component.uo.b b;
    private final tc c;
    private final d hc;
    private final List<k> u;

    public static tc d(com.bytedance.sdk.component.uo.b bVar) {
        return new tc(bVar);
    }

    public <T> void d(String str, T t) {
        hc();
        this.hc.d(str, (String) t);
    }

    public w d(String str, u<?, ?> uVar) {
        return d(str, (String) null, uVar);
    }

    public w d(String str, String str2, u<?, ?> uVar) {
        hc();
        this.hc.h.d(str, uVar);
        return this;
    }

    public w d(String str, c.hc hcVar) {
        return d(str, (String) null, hcVar);
    }

    public w d(String str, String str2, c.hc hcVar) {
        hc();
        this.hc.h.d(str, hcVar);
        return this;
    }

    public void d() {
        if (this.an) {
            return;
        }
        this.hc.hc();
        this.an = true;
        Iterator<k> it = this.u.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    w(tc tcVar) {
        de deVar;
        ArrayList arrayList = new ArrayList();
        this.u = arrayList;
        this.an = false;
        this.c = tcVar;
        sy syVarD = (!tcVar.gb || (deVar = d) == null) ? null : deVar.d(tcVar.mk);
        if (tcVar.d != null && tcVar.hc == null) {
            this.hc = new yi();
        } else {
            this.hc = tcVar.hc;
        }
        this.hc.d(tcVar, syVarD);
        this.b = tcVar.d;
        arrayList.add(tcVar.tc);
        tt.d(tcVar.an);
        np.d(tcVar.h);
    }

    private void hc() {
        if (this.an) {
            tt.d(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
