package com.bytedance.msdk.b.b.d;

import android.text.TextUtils;
import com.bytedance.msdk.gb.j;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc extends hc {
    private final com.bytedance.msdk.core.tc.hc an;
    private final HashSet<String> gb = new HashSet<>();
    private final List<com.bytedance.msdk.core.tc.tc> h;
    private final com.bytedance.msdk.b.an.d.hc u;

    public tc(com.bytedance.msdk.b.an.d.hc hcVar, com.bytedance.msdk.core.tc.hc hcVar2, List<com.bytedance.msdk.core.tc.tc> list) {
        this.u = hcVar;
        this.an = hcVar2;
        this.h = list;
    }

    @Override // com.bytedance.msdk.b.b.d.hc
    public boolean hc(com.bytedance.msdk.core.tc.tc tcVar, int i) {
        com.bytedance.msdk.core.tc.tc tcVarAn;
        if (i == 1) {
            com.bytedance.msdk.core.tc.tc tcVarAn2 = an();
            if (tcVarAn2 != null && tcVar != null && TextUtils.equals(tcVarAn2.yo(), tcVar.yo())) {
                b();
                return true;
            }
        } else if (i == 2) {
            if (tcVar != null) {
                this.gb.add(tcVar.yo());
                com.bytedance.msdk.hc.b bVar = null;
                CopyOnWriteArrayList<com.bytedance.msdk.hc.b> copyOnWriteArrayListGb = this.u.gb();
                if (copyOnWriteArrayListGb != null && copyOnWriteArrayListGb.size() > 0) {
                    bVar = copyOnWriteArrayListGb.get(0);
                }
                if (bVar != null && (tcVarAn = an()) != null && TextUtils.equals(tcVarAn.yo(), bVar.ph())) {
                    b();
                    return true;
                }
            }
            if (this.hc.gb()) {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "全部广告完成响应...");
                if (j.d(this.u.gb())) {
                    d(new com.bytedance.msdk.api.d(20005, com.bytedance.msdk.api.d.d(20005)));
                }
                return true;
            }
        } else if (this.hc.u()) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.hc.u() + "  allWtfFinish:" + this.hc.gb());
            if (!j.d(this.u.gb())) {
                b();
            } else {
                d(new com.bytedance.msdk.api.d(10003, com.bytedance.msdk.api.d.d(10003)));
            }
            return true;
        }
        return false;
    }

    private com.bytedance.msdk.core.tc.tc an() {
        List<com.bytedance.msdk.core.tc.tc> list = this.h;
        if (list == null) {
            return null;
        }
        for (com.bytedance.msdk.core.tc.tc tcVar : list) {
            if (tcVar != null) {
                if (!this.gb.contains(tcVar.yo())) {
                    return tcVar;
                }
            }
        }
        return null;
    }
}
