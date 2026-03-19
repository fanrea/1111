package com.bytedance.msdk.core.d.d.hc;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.core.d.d.d.hc;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.hc.b;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d implements com.bytedance.msdk.core.d.d.d.d {
    public Function<SparseArray<Object>, Object> b;
    private hc c;
    public com.bytedance.msdk.api.d.hc d;
    public tc hc;

    protected abstract void d(Context context);

    @Override // com.bytedance.msdk.core.d.d.d.d
    public final void d(Context context, Function<SparseArray<Object>, Object> function, com.bytedance.msdk.api.d.hc hcVar, tc tcVar, hc hcVar2) {
        if (function == null || hcVar == null || tcVar == null || hcVar2 == null) {
            return;
        }
        this.c = hcVar2;
        this.hc = tcVar;
        this.d = hcVar;
        this.b = function;
        d(context);
    }

    public final void d(int i, String str) {
        hc hcVar = this.c;
        if (hcVar != null) {
            hcVar.d(i, str);
        }
    }

    public void d(List<b> list) {
        hc hcVar = this.c;
        if (hcVar != null) {
            hcVar.d(list);
        }
    }

    public void d(b bVar, com.bytedance.msdk.api.d dVar) {
        hc hcVar = this.c;
        if (hcVar != null) {
            hcVar.d(bVar, dVar);
        }
    }

    public boolean d() {
        tc tcVar = this.hc;
        if (tcVar == null) {
            return false;
        }
        int iTc = tcVar.tc();
        return iTc == 1 || iTc == 3;
    }

    public String hc() {
        tc tcVar = this.hc;
        return (tcVar == null || !tcVar.s() || this.hc.zw() == null) ? "" : this.hc.zw().tc();
    }

    public boolean b() {
        return ((com.bytedance.msdk.h.d.d.d().c() == 1) && this.hc.us()) || ((com.bytedance.msdk.h.d.d.d().u() == 1) && (this.hc.rf() == 0));
    }
}
