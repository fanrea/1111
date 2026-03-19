package com.bytedance.msdk.b.h.d;

import android.text.TextUtils;
import com.bytedance.msdk.b.gb.an;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.gb.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements d {
    @Override // com.bytedance.msdk.b.h.d.d
    public boolean d(com.bytedance.msdk.b.an.d.hc hcVar, com.bytedance.msdk.hc.b bVar, List<tc> list) {
        if (bVar == null || hcVar == null) {
            return false;
        }
        if (hcVar.uo().an(an.d(hcVar.mq(), bVar)) == 0) {
            return true;
        }
        return d(bVar, list);
    }

    protected boolean d(com.bytedance.msdk.hc.b bVar, List<tc> list) {
        if (bVar == null || TextUtils.isEmpty(bVar.ph()) || !bVar.p() || j.d(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList);
        return !j.hc(arrayList) && bVar.ph().equals(((tc) arrayList.get(0)).yo());
    }
}
