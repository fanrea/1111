package com.bytedance.msdk.b.d.d;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b extends com.bytedance.msdk.hc.b {
    protected Function<SparseArray<Object>, Object> tc;
    protected com.bytedance.msdk.b.b.hc.d.d.hc tt;

    @Override // com.bytedance.msdk.hc.b
    public boolean u() {
        return false;
    }

    public b(com.bytedance.msdk.b.b.hc.d.d.hc hcVar, Function<SparseArray<Object>, Object> function) {
        this.tt = hcVar;
        this.tc = function;
    }

    @Override // com.bytedance.msdk.hc.b
    public Integer an() {
        com.bytedance.msdk.b.b.hc.d.d.hc hcVar = this.tt;
        if (hcVar != null) {
            return hcVar.tc();
        }
        return super.an();
    }

    @Override // com.bytedance.msdk.hc.b
    public void w() {
        super.w();
        com.bytedance.msdk.b.b.hc.d.d.hc hcVar = this.tt;
        if (hcVar != null) {
            hcVar.mq();
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void cb() {
        super.cb();
        com.bytedance.msdk.b.b.hc.d.d.hc hcVar = this.tt;
        if (hcVar != null) {
            hcVar.mk();
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void yo() {
        super.yo();
        com.bytedance.msdk.b.b.hc.d.d.hc hcVar = this.tt;
        if (hcVar != null) {
            hcVar.uo();
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        int i = 10001;
        try {
            Object obj = map.get("bidding_lose_reason_NUM");
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            if (iIntValue > 0) {
                i = iIntValue;
            }
        } catch (Exception unused) {
        }
        d(false, -1.0d, i, null);
    }

    @Override // com.bytedance.msdk.hc.b
    public void hc(Map<String, Object> map) {
        d(true, kb(), -1, null);
    }

    public void d(boolean z, double d, int i, Map<String, Object> map) {
        com.bytedance.msdk.b.b.hc.d.d.hc hcVar = this.tt;
        if (hcVar != null) {
            hcVar.d(z, d, i, map);
        }
    }
}
