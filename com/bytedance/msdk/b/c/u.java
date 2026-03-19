package com.bytedance.msdk.b.c;

import android.content.Context;
import com.bytedance.msdk.core.u.hc.c;
import com.bytedance.msdk.gb.us;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends hc implements com.bytedance.msdk.core.u.hc.b {
    private List<com.bytedance.msdk.core.tc.tc> cb;
    private final int d;
    private c.b hc;

    public u(Context context, int i) {
        super(context);
        this.d = i;
    }

    @Override // com.bytedance.msdk.core.u.hc.b
    public void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.hc.b bVar, c.b bVar2) throws JSONException {
        this.hc = bVar2;
        d(hcVar);
        this.b.d(true);
        this.b.c(true);
        this.b.rf().d(hcVar.d());
        this.h = d(this.h, bVar);
        this.b.d(this.h);
        this.an.an(1);
        com.bytedance.msdk.core.tc.hc hcVarD = com.bytedance.msdk.core.b.b.d(this.an, this.h);
        if (hcVarD != null) {
            this.h = hcVarD;
            this.b.d(this.h);
        }
        if (this.h == null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- 预缓存补充请求未发起，mRitConfig为null");
            c.b bVar3 = this.hc;
            if (bVar3 != null) {
                bVar3.d(this.u, false, 0, null);
                return;
            }
            return;
        }
        List<com.bytedance.msdk.core.tc.tc> listY = this.h.y();
        if (listY == null || listY.size() <= 0) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- 预缓存补充请求未发起，过滤后的waterfall为空");
            c.b bVar4 = this.hc;
            if (bVar4 != null) {
                bVar4.d(this.u, false, 0, null);
                return;
            }
            return;
        }
        this.h.an((long) (this.h.hv() * this.h.b()));
        this.h.u((long) (this.h.r() * this.h.hc()));
        this.h.hc(false);
        this.h.d(false);
        List<com.bytedance.msdk.core.tc.tc> listY2 = this.h.y();
        this.cb = listY2;
        us.d(listY2, this.e);
        if (com.bytedance.msdk.d.u.b.hc()) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- 预缓存补充请求，过滤后的waterfall：");
            for (com.bytedance.msdk.core.tc.tc tcVar : this.cb) {
                com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.u) + "waterfall: " + tcVar.e() + "adnSlotId: " + tcVar.yo() + ", loadSort: " + tcVar.np() + ", showSort: " + tcVar.yi() + ", eCpm: " + tcVar.v());
            }
        }
        tt();
    }

    @Override // com.bytedance.msdk.b.c.hc
    protected com.bytedance.msdk.b.b.d.h tt() {
        ArrayList arrayList = new ArrayList();
        int i = this.d;
        if (i == 3) {
            arrayList.add(new com.bytedance.msdk.b.b.d.tt());
        } else if (i == 4) {
            arrayList.add(new com.bytedance.msdk.b.b.d.tc(this.b, this.h, this.cb));
        } else {
            arrayList.add(new com.bytedance.msdk.b.b.d.hc());
        }
        com.bytedance.msdk.b.b.d.h hVar = new com.bytedance.msdk.b.b.d.h(arrayList);
        hVar.d(this.b);
        return hVar;
    }

    private com.bytedance.msdk.core.tc.hc d(com.bytedance.msdk.core.tc.hc hcVar, com.bytedance.msdk.hc.b bVar) {
        if (hcVar == null || bVar == null) {
            return null;
        }
        double dKb = bVar.kb();
        com.bytedance.msdk.d.u.b.hc("TMe", "筛选预缓存 ecpm ".concat(String.valueOf(dKb)));
        com.bytedance.msdk.core.tc.hc hcVarClone = hcVar.clone();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (com.bytedance.msdk.core.tc.tc tcVar : hcVarClone.y()) {
            if (tcVar != null && tcVar.mt() && tcVar.v() > dKb) {
                copyOnWriteArrayList.add(tcVar);
            }
        }
        if (hcVarClone.mk()) {
            hcVarClone.hc(copyOnWriteArrayList);
        } else {
            hcVarClone.d(copyOnWriteArrayList);
        }
        return hcVarClone;
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void h() {
        super.h();
        c.b bVar = this.hc;
        if (bVar != null) {
            bVar.d(this.h != null ? this.h.fs() : "", true, 0, this.b.gb());
        }
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void hc(com.bytedance.msdk.api.d dVar) {
        super.hc(dVar);
        if (this.hc != null) {
            int i = 10003;
            if (dVar == null) {
                i = 20005;
            } else if (dVar.d != 10003) {
                int i2 = dVar.d;
                i = 20005;
            }
            this.hc.d(this.h != null ? this.h.fs() : "", false, i, null);
        }
    }
}
