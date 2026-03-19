package com.bytedance.msdk.d.b;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.api.c.k;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.msdk.d.d.c {
    private b d;

    @Override // com.bytedance.msdk.d.d.c
    public int an() {
        return 0;
    }

    @Override // com.bytedance.msdk.d.d.c
    public void c() {
    }

    @Override // com.bytedance.msdk.d.d.c
    public int d(com.bytedance.msdk.api.c.b bVar) {
        return 0;
    }

    @Override // com.bytedance.msdk.d.d.c
    public void h() {
    }

    @Override // com.bytedance.msdk.d.d.c
    public Map<String, Object> hc(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.msdk.d.d.c
    public long u() {
        return 0L;
    }

    @Override // com.bytedance.msdk.d.d.c
    public String d() {
        return hc() + ".0";
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // com.bytedance.msdk.d.d.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String d(android.content.Context r19, java.util.Map<java.lang.String, java.lang.Object> r20) {
        /*
            Method dump skipped, instructions count: 611
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.d.b.d.d(android.content.Context, java.util.Map):java.lang.String");
    }

    private void gb() {
        tt();
    }

    @Override // com.bytedance.msdk.d.d.c
    public String hc() {
        return com.bytedance.sdk.gromore.init.d.b();
    }

    @Override // com.bytedance.msdk.d.d.c
    public String b() {
        return com.bytedance.sdk.gromore.init.d.c();
    }

    private void tt() {
        hc.hc(hc.d(hc.d(), "personal_ads_type", this.d.h() ? "0" : "1"));
    }

    @Override // com.bytedance.msdk.d.d.c
    public void d(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Object obj = map.get(com.bytedance.msdk.d.d.d.u);
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (iIntValue == 0 || iIntValue == 1) {
            com.bytedance.sdk.gromore.init.d.d(iIntValue);
        }
    }

    @Override // com.bytedance.msdk.d.d.c
    public void d(k kVar, SparseArray<Object> sparseArray) {
        this.d.hc(sparseArray);
        gb();
    }

    @Override // com.bytedance.msdk.d.d.hc
    public void d(Context context, Map<String, Object> map, com.bytedance.msdk.d.d.b bVar) {
        this.d = com.bytedance.msdk.core.d.mk().hc();
        tt();
        bVar.d();
    }
}
