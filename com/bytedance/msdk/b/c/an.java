package com.bytedance.msdk.b.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.gb.k;
import com.bytedance.msdk.gb.rf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends hc implements com.bytedance.msdk.d.hc.d {
    private boolean cb;
    private com.bytedance.msdk.api.c.d.d.d d;
    private com.bytedance.msdk.api.c.d.d.hc hc;
    private com.bytedance.msdk.api.c.d.d.c w;

    public an(Context context) {
        super(context);
        this.cb = false;
    }

    public void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.c.d.d.hc hcVar2) {
        d(hcVar);
        this.tt = this;
        this.hc = hcVar2;
        tt();
    }

    public void d(com.bytedance.msdk.api.c.d.d.c cVar) {
        this.w = cVar;
    }

    public void d(com.bytedance.msdk.api.c.d.d.d dVar) {
        this.d = dVar;
    }

    private View d(Context context, com.bytedance.msdk.hc.b bVar) {
        this.c = bVar;
        this.b.d(this.c);
        this.c.u(true);
        this.c.d(this.tt);
        if (this.c.rs() && com.bytedance.msdk.core.u.d.d.d().c(this.u, this.c.ph(), this.an.u())) {
            com.bytedance.msdk.b.gb.u.d(this.c, this.u, this.c.ph());
        }
        d(false);
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.u, "show") + "展示的广告类型：" + com.bytedance.msdk.hc.d.d(this.c.t()) + ",slotId：" + this.c.ph() + ",slotType:" + this.c.hg());
        final View viewTt = this.c.tt();
        if (!this.c.wz() && this.c.nv() == 4 && this.c.y() == 2 && !this.c.ey()) {
            com.bytedance.msdk.api.c.d.d.c cVar = this.w;
            if (cVar != null) {
                try {
                    viewTt = cVar.d(b(this.c));
                    if (viewTt == null) {
                        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()返回null，将无法展示该广告");
                    }
                } catch (Throwable th) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()发生异常，将无法展示该广告，信息如下：");
                    com.bytedance.sdk.component.utils.mq.d(th);
                }
            } else {
                com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- banner混出自渲染信息流，但未提供GMNativeToBannerListener，将无法展示该广告");
            }
        }
        if (this.c.jh() && context != null) {
            this.c.d((Activity) context, new com.bytedance.sdk.openadsdk.jh.d.hc.d.d(null) { // from class: com.bytedance.msdk.b.c.an.1
                public void d(int i, String str, boolean z) {
                    View view = viewTt;
                    if (view != null) {
                        View view2 = (View) view.getParent();
                        if (view2 instanceof ViewGroup) {
                            ((ViewGroup) view2).removeViewInLayout(viewTt);
                        }
                    }
                }
            });
        }
        return viewTt;
    }

    public synchronized View d(Context context) {
        List<com.bytedance.msdk.core.tc.tc> listHc;
        View viewD;
        com.bytedance.msdk.hc.b next;
        List<com.bytedance.msdk.core.u.hc.h> listD;
        com.bytedance.msdk.hc.b bVar;
        com.bytedance.msdk.u.an.d(this.an);
        if (this.mq) {
            com.bytedance.msdk.u.an.d((List<com.bytedance.msdk.hc.b>) null, this.an, 0);
            b(new com.bytedance.msdk.api.d(40052, com.bytedance.msdk.api.d.d(40052)));
            return null;
        }
        int iHc = hc(this.u);
        if (iHc != 0) {
            com.bytedance.msdk.u.an.d((List<com.bytedance.msdk.hc.b>) null, this.an, iHc);
            b(new com.bytedance.msdk.api.d(iHc, com.bytedance.msdk.api.d.d(iHc)));
            return null;
        }
        List<com.bytedance.msdk.hc.b> listJh = this.b.jh();
        try {
            listHc = hc();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            listHc = null;
        }
        if (listHc != null && listHc.size() > 0) {
            HashMap<String, com.bytedance.msdk.hc.b> mapHc = hc(listJh);
            viewD = null;
            for (com.bytedance.msdk.core.tc.tc tcVar : listHc) {
                if (tcVar != null) {
                    String strYo = tcVar.yo();
                    com.bytedance.msdk.hc.b bVar2 = mapHc.get(strYo);
                    if (bVar2 != null && bVar2.ba(this.u) && !bVar2.xp() && (viewD = d(context, bVar2)) != null) {
                        break;
                    }
                    if (tcVar.jh() && com.bytedance.msdk.core.u.d.d.d().c(this.u, strYo, this.an.u()) && com.bytedance.msdk.core.u.d.d.d().d(strYo, this.an, false) == 3 && (listD = com.bytedance.msdk.core.u.d.d.d().d(strYo, this.an, this.an.u())) != null && listD.size() > 0 && (bVar = listD.get(0).d) != null && bVar.ba(this.u) && !bVar.xp()) {
                        hc(bVar);
                        viewD = d(context, bVar);
                        if (viewD != null) {
                            break;
                        }
                    }
                }
            }
        } else {
            viewD = null;
        }
        if (viewD == null && listJh != null && listJh.size() > 0) {
            Iterator<com.bytedance.msdk.hc.b> it = listJh.iterator();
            while (it.hasNext() && ((next = it.next()) == null || !next.ba(this.u) || next.xp() || (viewD = d(context, next)) == null)) {
            }
        }
        if (viewD != null) {
            this.mq = true;
            List<com.bytedance.msdk.hc.b> listJh2 = this.b.jh();
            com.bytedance.msdk.core.u.d.d.d().d(listJh2, this.u, this.an, this.an.u(), this.c);
            if (this.c != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.c);
                com.bytedance.msdk.b.u.d.d().d(this.an, com.bytedance.msdk.b.u.d.d(this.an, arrayList, listJh2));
                d(arrayList);
            }
            com.bytedance.msdk.u.an.d(this.c, this.an, false, 0);
            if (this.d != null && this.c != null && this.c.t() == 2) {
                com.bytedance.msdk.d.u.b.d("ADMOB_EVENT", com.bytedance.msdk.d.u.u.hc(this.u, this.c.ph()) + "mTTAdBannerListener-->Admob--->onAdShow......");
                com.bytedance.msdk.core.gb.uo.d().h(this.u);
                com.bytedance.msdk.core.gb.uo.d().hc(this.u);
                this.d.hc(null);
                if (this.c != null) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.u, "show_listen") + "adSlotId：" + this.c.ph() + "，广告类型：" + com.bytedance.msdk.hc.d.d(this.c.t()));
                    com.bytedance.msdk.core.gb.mk.d().hc(this.u, this.c.ph());
                    com.bytedance.msdk.core.gb.mq.d().hc(this.u, this.c.ph());
                }
                if (this.c != null) {
                    com.bytedance.msdk.core.b.b.d(this.c.nr(), this.u, this.c.ph());
                }
                d(true);
                com.bytedance.msdk.u.an.d(this.c, this.an, 0, (String) null, 0L, false);
                com.bytedance.msdk.core.h.b.d(this.u, this.c);
            }
            return viewD;
        }
        com.bytedance.msdk.u.an.d(listJh, this.an, 0);
        b(new com.bytedance.msdk.api.d(40052, com.bytedance.msdk.api.d.d(40052)));
        return null;
    }

    private void d(boolean z) {
        if (this.c != null && this.c.rs() && com.bytedance.msdk.core.u.d.d.d().c(this.u, this.c.ph(), this.an.u())) {
            com.bytedance.msdk.core.u.d.d.d().d(this.c.ph(), this.an, this.b.j(), z, this.b.s(), this.b.ba(), this.gb.get());
        }
    }

    public boolean b() {
        List<com.bytedance.msdk.core.tc.tc> listHc;
        try {
            listHc = hc();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            listHc = null;
        }
        return k.d(this.b.h(), this.b.tc(), this.b.gb(), this.an, this.mq, this.u, this.an.u(), listHc);
    }

    public int c() {
        if (this.c != null) {
            return this.c.ar();
        }
        return 0;
    }

    public void u() {
        if (this.c != null) {
            this.c.w();
        }
    }

    public void an() {
        if (this.c != null) {
            this.c.cb();
        }
    }

    @Override // com.bytedance.msdk.b.c.hc
    public void d() {
        if (!this.mq) {
            com.bytedance.msdk.core.u.d.d.d().d(this.b.jh(), this.u, this.an, this.an.u(), this.c);
        }
        super.d();
        this.d = null;
        this.hc = null;
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void hc(com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.api.c.d.d.hc hcVar = this.hc;
        if (hcVar != null) {
            hcVar.d(dVar);
        }
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void h() {
        com.bytedance.msdk.api.c.d.d.hc hcVar = this.hc;
        if (hcVar != null) {
            hcVar.d();
        }
    }

    @Override // com.bytedance.msdk.api.c.d.d.d
    public void f_() {
        com.bytedance.msdk.api.c.d.d.d dVar = this.d;
        if (dVar != null) {
            dVar.f_();
        }
    }

    @Override // com.bytedance.msdk.api.c.d.d.d
    public void d(View view) {
        com.bytedance.msdk.api.c.d.d.d dVar = this.d;
        if (dVar != null) {
            dVar.d(view);
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

    @Override // com.bytedance.msdk.api.c.d.d.d
    public void hc(View view) {
        this.cb = true;
        if (this.d != null) {
            com.bytedance.msdk.core.gb.uo.d().h(this.u);
            com.bytedance.msdk.core.gb.uo.d().hc(this.u);
            this.d.hc(view);
        }
        if (this.c != null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.u, "show_listen") + "adSlotId：" + this.c.ph() + "，广告类型：" + com.bytedance.msdk.hc.d.d(this.c.t()));
            com.bytedance.msdk.core.gb.mk.d().hc(this.u, this.c.ph());
            com.bytedance.msdk.core.gb.mq.d().hc(this.u, this.c.ph());
        }
        if (this.c != null) {
            com.bytedance.msdk.core.b.b.d(this.c.nr(), this.u, this.c.ph());
        }
        d(true);
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

    @Override // com.bytedance.msdk.api.c.d.d.d
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

    private void b(final com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.c.an.2
            @Override // java.lang.Runnable
            public void run() {
                if (an.this.d != null) {
                    an.this.d.d(dVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.b.c.hc
    public com.bytedance.msdk.api.b e() {
        if (this.cb) {
            return super.e();
        }
        return null;
    }

    public void d(Activity activity, com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
        if (this.c != null) {
            this.c.d(activity, dVar);
        }
    }

    public void d(Dialog dialog, Integer[] numArr) {
        if (this.c != null) {
            this.c.d(dialog, numArr);
        }
    }

    public com.bytedance.sdk.openadsdk.w.b.hc.h d(Activity activity) {
        if (this.c != null) {
            return this.c.d(activity);
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.w.b.hc.c sy() {
        if (this.c != null) {
            return this.c.vg();
        }
        return null;
    }

    private com.bytedance.msdk.api.c.d.d.b b(final com.bytedance.msdk.hc.b bVar) {
        return new com.bytedance.msdk.api.c.d.d.b() { // from class: com.bytedance.msdk.b.c.an.3
            @Override // com.bytedance.msdk.api.c.d.d.b
            public String d() {
                return bVar.nk();
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public String hc() {
                return bVar.ec();
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public String b() {
                return bVar.jm();
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public String c() {
                return bVar.ed();
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public double u() {
                return bVar.eu();
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public List<String> an() {
                return bVar.ic();
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public String h() {
                return bVar.qv();
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public int gb() {
                return bVar.ar();
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public int tt() {
                return bVar.qr();
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public void d(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.c.d.h.tc tcVar) {
                bVar.d(activity, viewGroup, list, list2, list3, tcVar, null);
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public com.bytedance.msdk.api.c.d.h.d tc() {
                if (!bVar.gv()) {
                    return null;
                }
                com.bytedance.msdk.api.c.d.h.d dVar = new com.bytedance.msdk.api.c.d.h.d();
                dVar.c(bVar.qy());
                dVar.u(bVar.nf());
                dVar.d(bVar.gw());
                dVar.an(bVar.fy());
                dVar.h(bVar.zv());
                dVar.gb(bVar.um());
                dVar.d(bVar.fv());
                dVar.hc(bVar.pq());
                dVar.b(bVar.ru());
                dVar.d(bVar.wl());
                dVar.hc(bVar.q());
                return dVar;
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public boolean mk() {
                return bVar.jh();
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public com.bytedance.msdk.api.c.hc d(Activity activity) {
                return d(activity, (Map<String, Object>) null);
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public com.bytedance.msdk.api.c.hc d(Activity activity, Map<String, Object> map) {
                final com.bytedance.sdk.openadsdk.w.b.hc.h hVarD = bVar.d(activity);
                return new com.bytedance.msdk.api.c.hc() { // from class: com.bytedance.msdk.b.c.an.3.1
                    @Override // com.bytedance.msdk.api.c.hc
                    public void d() {
                        com.bytedance.sdk.openadsdk.w.b.hc.h hVar = hVarD;
                        if (hVar != null) {
                            hVar.d();
                        }
                    }

                    @Override // com.bytedance.msdk.api.c.hc
                    public void d(final com.bytedance.msdk.api.c.h hVar) {
                        com.bytedance.sdk.openadsdk.w.b.hc.h hVar2 = hVarD;
                        if (hVar2 != null) {
                            hVar2.d(new com.bytedance.sdk.openadsdk.jh.d.hc.d.d(null) { // from class: com.bytedance.msdk.b.c.an.3.1.1
                                public void d() {
                                    com.bytedance.msdk.api.c.h hVar3 = hVar;
                                    if (hVar3 != null) {
                                        hVar3.hc();
                                    }
                                }

                                public void d(int i, String str, boolean z) {
                                    com.bytedance.msdk.api.c.h hVar3 = hVar;
                                    if (hVar3 != null) {
                                        hVar3.d(i, str);
                                    }
                                }

                                public void hc() {
                                    com.bytedance.msdk.api.c.h hVar3 = hVar;
                                    if (hVar3 != null) {
                                        hVar3.d();
                                    }
                                }
                            });
                        }
                    }
                };
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public void d(Activity activity, com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
                com.bytedance.msdk.hc.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.d(activity, dVar);
                }
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public void d(Dialog dialog, Integer[] numArr) {
                com.bytedance.msdk.hc.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.d(dialog, numArr);
                }
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public com.bytedance.sdk.openadsdk.w.b.hc.h hc(Activity activity) {
                com.bytedance.msdk.hc.b bVar2 = bVar;
                if (bVar2 != null) {
                    return bVar2.d(activity);
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public com.bytedance.sdk.openadsdk.w.b.hc.h hc(Dialog dialog, Integer[] numArr) {
                com.bytedance.msdk.hc.b bVar2 = bVar;
                if (bVar2 != null) {
                    return bVar2.hc(dialog, numArr);
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.c.d.d.b
            public com.bytedance.sdk.openadsdk.w.b.hc.c mq() {
                com.bytedance.msdk.hc.b bVar2 = bVar;
                if (bVar2 != null) {
                    return bVar2.vg();
                }
                return null;
            }
        };
    }

    public void c(String str) {
        if (this.c != null) {
            this.c.mt(str);
        }
    }

    public void d(com.bytedance.sdk.openadsdk.w.b.d.b bVar) {
        if (this.c != null) {
            this.c.d(bVar);
        }
    }

    public void d(com.bytedance.sdk.openadsdk.he.d.hc.d.b bVar) {
        if (this.c != null) {
            this.c.d(bVar);
        }
    }

    public void hc(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
        if (this.c != null) {
            this.c.d(hcVar);
        }
    }
}
