package com.bytedance.msdk.b.h;

import android.text.TextUtils;
import com.bytedance.msdk.core.tc.hc;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.u;
import com.bytedance.msdk.hc.b;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static void d(hc hcVar, com.bytedance.msdk.b.an.d.hc hcVar2, List<tc> list) {
        if (hcVar == null || hcVar2 == null || list == null || list.size() == 0) {
            return;
        }
        Iterator<b> it = hcVar2.gb().iterator();
        while (it.hasNext()) {
            b next = it.next();
            boolean z = true;
            Iterator<tc> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                tc next2 = it2.next();
                if (next != null && next2 != null && next.ph().equals(next2.yo())) {
                    z = false;
                    break;
                }
            }
            if (z) {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", u.d(hcVar) + "已经响应的广告: " + next.ph() + "  没有在severBidding的waterFall列表中，需要被移除掉");
                hcVar2.gb().remove(next);
                hcVar2.tt().add(next);
            }
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", u.d(hcVar) + "已经响应的广告被serverBidding过滤完还剩: " + hcVar2.gb().size());
    }

    public static boolean d(com.bytedance.msdk.b.an.d.d dVar, List<tc> list, String str) {
        if (list == null || dVar == null || TextUtils.isEmpty(str) || dVar.hc() != 1) {
            return false;
        }
        Iterator<tc> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().yo())) {
                return false;
            }
        }
        return true;
    }
}
