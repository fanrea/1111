package com.bytedance.msdk.b.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.msdk.api.c.cb;
import com.bytedance.msdk.gb.k;
import com.bytedance.msdk.gb.rf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo extends hc implements com.bytedance.msdk.d.hc.u {
    private View cb;
    private boolean d;
    private boolean hc;
    private com.bytedance.msdk.api.c.d.tt.c rf;
    private com.bytedance.msdk.api.c.d.tt.b w;
    private com.bytedance.msdk.api.c.d.tt.hc yo;

    public View an() {
        return null;
    }

    public uo(Context context) {
        super(context);
        this.d = false;
        this.hc = false;
    }

    public void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.c.mk mkVar, com.bytedance.msdk.api.c.d.tt.b bVar) {
        d(hcVar);
        this.b.d(mkVar);
        this.w = bVar;
        this.tt = this;
        this.b.j().put("ad_load_timeout", Integer.valueOf(hcVar.w()));
        if (com.bytedance.msdk.core.hc.hc().zw()) {
            com.bytedance.msdk.api.c.tc.d(new cb() { // from class: com.bytedance.msdk.b.c.uo.1
                @Override // com.bytedance.msdk.api.c.cb
                public void d() {
                    uo.this.tt();
                }
            });
        } else {
            tt();
        }
    }

    public void d(com.bytedance.msdk.api.c.d.tt.hc hcVar) {
        this.yo = hcVar;
    }

    public void d(com.bytedance.msdk.api.c.d.tt.c cVar) {
        this.rf = cVar;
    }

    public boolean sy() {
        List<com.bytedance.msdk.core.tc.tc> listHc;
        try {
            listHc = hc();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            listHc = null;
        }
        return k.d(this.b.h(), this.b.tc(), this.b.gb(), this.an, this.mq, this.u, this.an.u(), listHc);
    }

    public View de() throws JSONException {
        Context context = this.gb != null ? this.gb.get() : null;
        if (this.cb == null && context != null) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            hc(frameLayout);
            this.cb = frameLayout;
            d(this.c);
        }
        return this.cb;
    }

    public void d(final ViewGroup viewGroup) {
        final String[] strArr = new String[1];
        final boolean zUs = com.bytedance.msdk.core.hc.hc().us();
        if (zUs) {
            strArr[0] = rf.d();
        }
        com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.c.uo.2
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                uo.this.hc(viewGroup);
                if (zUs) {
                    com.bytedance.msdk.u.an.d(uo.this.c, uo.this.an, strArr[0], 2);
                }
            }
        });
    }

    protected void v() {
        if (this.c.rs() && com.bytedance.msdk.core.u.d.d.d().c(this.u, this.c.ph(), rf())) {
            com.bytedance.msdk.core.u.d.d.d().d(this.c.ph(), this.an, this.b.j(), true, this.b.s(), this.b.ba(), this.gb.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(ViewGroup viewGroup) throws JSONException {
        boolean z;
        List<com.bytedance.msdk.core.u.hc.h> listD;
        com.bytedance.msdk.hc.b bVar;
        com.bytedance.msdk.u.an.d(this.an);
        List<com.bytedance.msdk.core.tc.tc> listHc = null;
        if (this.mq) {
            com.bytedance.msdk.u.an.d((List<com.bytedance.msdk.hc.b>) null, this.an, 0);
            b(new com.bytedance.msdk.api.d(40052, com.bytedance.msdk.api.d.d(40052)));
            return;
        }
        int iHc = hc(this.u);
        if (iHc != 0) {
            com.bytedance.msdk.u.an.d((List<com.bytedance.msdk.hc.b>) null, this.an, iHc);
            b(new com.bytedance.msdk.api.d(iHc, com.bytedance.msdk.api.d.d(iHc)));
            return;
        }
        List<com.bytedance.msdk.hc.b> listJh = this.b.jh();
        if (viewGroup != null) {
            try {
                listHc = hc();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
            if (listHc == null || listHc.size() <= 0) {
                z = false;
            } else {
                HashMap<String, com.bytedance.msdk.hc.b> mapHc = hc(listJh);
                for (com.bytedance.msdk.core.tc.tc tcVar : listHc) {
                    if (tcVar != null) {
                        String strYo = tcVar.yo();
                        com.bytedance.msdk.hc.b bVar2 = mapHc.get(strYo);
                        if (bVar2 != null && bVar2.ba(this.u) && !bVar2.xp()) {
                            d(bVar2, viewGroup);
                        } else if (tcVar.jh() && com.bytedance.msdk.core.u.d.d.d().c(this.u, strYo, rf()) && com.bytedance.msdk.core.u.d.d.d().d(strYo, this.an, false) == 3 && (listD = com.bytedance.msdk.core.u.d.d.d().d(strYo, this.an, rf())) != null && listD.size() > 0 && (bVar = listD.get(0).d) != null && bVar.ba(this.u) && !bVar.xp()) {
                            com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.u, "show") + "adSlotId：" + bVar.ph() + "，广告类型：" + com.bytedance.msdk.hc.d.d(bVar.t()) + ",isReady()：" + bVar.ba(this.u));
                            hc(bVar);
                            d(bVar, viewGroup);
                        }
                        z = true;
                        break;
                    }
                }
                z = false;
            }
            boolean z2 = z;
            if (!z && listJh != null && listJh.size() > 0) {
                Iterator<com.bytedance.msdk.hc.b> it = listJh.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.bytedance.msdk.hc.b next = it.next();
                    if (next != null && next.ba(this.u) && !next.xp()) {
                        d(next, viewGroup);
                        z2 = true;
                        break;
                    }
                }
            }
            if (z2) {
                this.mq = true;
                if (this.c != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.c);
                    d(arrayList);
                }
                com.bytedance.msdk.u.an.d(this.c, this.an, false, 0);
                return;
            }
            com.bytedance.msdk.u.an.d(listJh, this.an, 0);
            b(new com.bytedance.msdk.api.d(40052, com.bytedance.msdk.api.d.d(40052)));
            return;
        }
        com.bytedance.msdk.u.an.d(listJh, this.an, 0);
        b(new com.bytedance.msdk.api.d(40052, com.bytedance.msdk.api.d.d(40052)));
    }

    private void d(com.bytedance.msdk.hc.b bVar, ViewGroup viewGroup) {
        this.c = bVar;
        if (this.hc) {
            this.c.m();
        }
        if (this.uo != null) {
            this.c.d(this.uo);
        }
        if (this.k != null) {
            this.c.d(this.k);
        }
        this.b.d(this.c);
        this.c.u(true);
        this.c.d(this.tt);
        if (this.c.rs() && com.bytedance.msdk.core.u.d.d.d().c(this.u, this.c.ph(), rf())) {
            com.bytedance.msdk.b.gb.u.d(this.c, this.u, this.c.ph());
        }
        com.bytedance.msdk.core.u.d.d.d().d(this.b.jh(), this.u, this.an, rf(), this.c);
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.u, "show") + "展示的广告类型：" + com.bytedance.msdk.hc.d.d(this.c.t()) + ",slotId：" + this.c.ph() + ",slotType:" + this.c.hg());
        com.bytedance.msdk.core.gb.uo.d().hc(this.u);
        com.bytedance.msdk.core.gb.mq.d().hc(this.u, this.c.ph());
        this.c.d(viewGroup);
    }

    @Override // com.bytedance.msdk.b.c.hc
    public void d() {
        if (this.c == null) {
            com.bytedance.msdk.core.u.d.d.d().d(this.b.jh(), this.u, this.an, this.an.u(), this.c);
        }
        super.d();
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void hc(com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.api.c.d.tt.b bVar = this.w;
        if (bVar != null) {
            bVar.d(dVar);
        }
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void h() {
        com.bytedance.msdk.api.c.d.tt.b bVar = this.w;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.bytedance.msdk.d.hc.u
    public void k_() {
        com.bytedance.msdk.api.c.d.tt.c cVar = this.rf;
        if (cVar != null) {
            cVar.d();
        }
    }

    @Override // com.bytedance.msdk.d.hc.u
    public void l_() {
        com.bytedance.msdk.api.c.d.tt.c cVar = this.rf;
        if (cVar != null) {
            cVar.hc();
        }
    }

    @Override // com.bytedance.msdk.d.hc.u
    public Activity getActivity() {
        com.bytedance.msdk.api.c.d.tt.c cVar = this.rf;
        if (cVar != null) {
            return cVar.getActivity();
        }
        return null;
    }

    @Override // com.bytedance.msdk.d.hc.u
    public void b() {
        com.bytedance.msdk.api.c.d.tt.c cVar = this.rf;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.bytedance.msdk.api.c.d.tt.hc
    public void c() {
        com.bytedance.msdk.api.c.d.tt.hc hcVar = this.yo;
        if (hcVar != null) {
            hcVar.c();
        }
        String strHc = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = -1;
        if (rf.d(this.c)) {
            strHc = rf.hc();
            jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        }
        com.bytedance.msdk.core.hc.d.u(this.an.v());
        com.bytedance.msdk.u.an.hc(this.c, this.an, 0, strHc, jCurrentTimeMillis2, this.c.z());
    }

    @Override // com.bytedance.msdk.api.c.d.tt.hc
    public void u() {
        com.bytedance.msdk.api.c.d.tt.hc hcVar = this.yo;
        if (hcVar != null) {
            hcVar.u();
        }
        com.bytedance.msdk.core.gb.uo.d().h(this.u);
        if (this.c != null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.u, "show_listen") + "adSlotId：" + this.c.ph() + "，广告类型：" + com.bytedance.msdk.hc.d.d(this.c.t()));
            com.bytedance.msdk.core.gb.mk.d().hc(this.u, this.c.ph());
        }
        if (this.c != null) {
            com.bytedance.msdk.core.b.b.d(this.c.nr(), this.u, this.c.ph());
        }
        v();
        String strHc = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = -1;
        if (rf.d(this.c)) {
            strHc = rf.hc();
            jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        }
        com.bytedance.msdk.u.an.d(this.c, this.an, 0, strHc, jCurrentTimeMillis2, false);
        com.bytedance.msdk.core.hc.d.h(this.an.v());
        com.bytedance.msdk.core.hc.d.b(this.an.v());
        com.bytedance.msdk.core.tt.c.d(1, this.an.v(), this.c.el(), this.c.kb());
        com.bytedance.msdk.core.h.b.d(this.u, this.c);
    }

    @Override // com.bytedance.msdk.api.c.d.tt.hc
    public void d(com.bytedance.msdk.api.d dVar) {
        String strHc;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (rf.d(this.c)) {
            strHc = rf.hc();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strHc = null;
            jCurrentTimeMillis = -1;
        }
        com.bytedance.msdk.u.an.d(this.c, this.an, dVar, 1, 0, strHc, jCurrentTimeMillis);
        b(dVar);
    }

    @Override // com.bytedance.msdk.api.c.d.tt.hc
    public void d(int i) {
        com.bytedance.msdk.api.c.d.tt.hc hcVar = this.yo;
        if (hcVar != null) {
            hcVar.d(1);
        }
        com.bytedance.msdk.core.u.hc.c.d().d(this.gb.get(), this.u, rf());
    }

    @Override // com.bytedance.msdk.api.c.d.tt.hc
    public void hc(int i) {
        com.bytedance.msdk.api.c.d.tt.hc hcVar = this.yo;
        if (hcVar != null) {
            hcVar.hc(i);
        }
        com.bytedance.msdk.core.u.hc.c.d().d(this.gb.get(), this.u, rf());
    }

    public void d(ViewGroup viewGroup, Activity activity) {
        if (this.c != null) {
            this.c.d(viewGroup, activity);
        }
    }

    private void b(final com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.c.uo.3
            @Override // java.lang.Runnable
            public void run() {
                if (uo.this.yo != null) {
                    uo.this.yo.d(dVar);
                }
            }
        });
    }

    public void np() {
        this.hc = true;
    }
}
