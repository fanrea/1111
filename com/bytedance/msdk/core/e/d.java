package com.bytedance.msdk.core.e;

import android.text.TextUtils;
import com.bytedance.msdk.core.tc.hc;
import com.bytedance.msdk.core.tc.tc;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static hc d(hc hcVar, String str) {
        if (hcVar == null || TextUtils.isEmpty(str) || hcVar.y() == null || hcVar.y().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<tc> it = hcVar.y().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            tc next = it.next();
            if (str.equals(next.yo())) {
                arrayList.add(next.u());
                break;
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        tc tcVar = arrayList.get(0);
        if (tcVar != null && tcVar.s() && !"pangle".equals(tcVar.e())) {
            Iterator<tc> it2 = hcVar.y().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                tc next2 = it2.next();
                if (next2.s() && "pangle".equals(next2.e())) {
                    arrayList.add(next2.u());
                    break;
                }
            }
        }
        hc hcVarE = hcVar.e();
        if (hcVarE.mk()) {
            hcVarE.hc(arrayList);
        } else {
            hcVarE.d(arrayList);
        }
        tc tcVar2 = arrayList.get(0);
        tcVar2.u(0);
        if (tcVar2.rf() == 0) {
            hcVarE.c(tcVar2.v());
        }
        if (tcVar2.rf() == 2) {
            hcVarE.d(true);
        }
        if (tcVar2.rf() == 1 || tcVar2.rf() == 3) {
            hcVarE.hc(true);
        }
        hcVarE.mq(0);
        return hcVarE;
    }

    public static String d(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("gm_test_slot_")) {
                return str.substring(13);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
