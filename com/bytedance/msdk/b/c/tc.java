package com.bytedance.msdk.b.c;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.gb.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class tc extends hc {
    private Object d;
    protected com.bytedance.msdk.d.hc.an rf;
    protected boolean w;
    protected boolean yo;

    public interface d {
        void d();
    }

    protected boolean sy() {
        return false;
    }

    public tc(Context context) {
        super(context);
        this.w = false;
        this.yo = false;
        this.d = null;
    }

    public boolean yi() {
        return this.w;
    }

    public void d(boolean z) {
        this.w = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020 A[PHI: r4
  0x0020: PHI (r4v3 boolean) = (r4v2 boolean), (r4v0 boolean) binds: [B:31:0x0070, B:7:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(com.bytedance.msdk.b.an.d.hc r14) {
        /*
            r13 = this;
            com.bytedance.msdk.hc.b r0 = r13.c
            int r0 = r0.el()
            r1 = 0
            r2 = 8
            r3 = 10
            r4 = 1
            if (r0 == r3) goto L22
            com.bytedance.msdk.hc.b r0 = r13.c
            int r0 = r0.el()
            if (r0 == r2) goto L22
            com.bytedance.msdk.hc.b r0 = r13.c
            int r0 = r0.el()
            r5 = 7
            if (r0 != r5) goto L20
            goto L22
        L20:
            r9 = r4
            goto L73
        L22:
            com.bytedance.msdk.hc.b r0 = r13.c
            boolean r0 = r0.cw()
            if (r0 == 0) goto L46
            com.bytedance.msdk.hc.b r0 = r13.c
            boolean r0 = r0.xn()
            if (r0 == 0) goto L46
            com.bytedance.msdk.core.u.hc.c r0 = com.bytedance.msdk.core.u.hc.c.d()
            java.lang.String r5 = r13.u
            com.bytedance.msdk.api.d.hc r6 = r13.an
            int r6 = r6.u()
            boolean r0 = r0.b(r5, r6)
            if (r0 == 0) goto L46
            r0 = r1
            goto L47
        L46:
            r0 = r4
        L47:
            com.bytedance.msdk.api.d.hc r5 = r13.an
            if (r5 == 0) goto L68
            com.bytedance.msdk.api.d.hc r5 = r13.an
            int r5 = r5.de()
            if (r5 == r3) goto L5b
            com.bytedance.msdk.api.d.hc r3 = r13.an
            int r3 = r3.de()
            if (r3 != r2) goto L68
        L5b:
            com.bytedance.msdk.core.tc.hc r2 = r13.h
            if (r2 == 0) goto L68
            com.bytedance.msdk.core.tc.hc r2 = r13.h
            int r2 = r2.uo()
            if (r2 == 0) goto L68
            goto L69
        L68:
            r4 = r0
        L69:
            com.bytedance.msdk.hc.b r0 = r13.c
            int r0 = r0.t()
            r2 = 4
            if (r0 != r2) goto L20
            r9 = r1
        L73:
            com.bytedance.msdk.hc.b r0 = r13.c
            boolean r0 = r0.rs()
            if (r0 == 0) goto Lbf
            com.bytedance.msdk.core.u.d.d r0 = com.bytedance.msdk.core.u.d.d.d()
            java.lang.String r1 = r13.u
            com.bytedance.msdk.hc.b r2 = r13.c
            java.lang.String r2 = r2.ph()
            com.bytedance.msdk.api.d.hc r3 = r13.an
            int r3 = r3.u()
            boolean r0 = r0.c(r1, r2, r3)
            if (r0 == 0) goto Lbf
            com.bytedance.msdk.core.u.d.d r5 = com.bytedance.msdk.core.u.d.d.d()
            com.bytedance.msdk.hc.b r0 = r13.c
            java.lang.String r6 = r0.ph()
            com.bytedance.msdk.api.d.hc r7 = r13.an
            r0 = 0
            if (r14 == 0) goto La8
            java.util.Map r1 = r14.j()
            r8 = r1
            goto La9
        La8:
            r8 = r0
        La9:
            if (r14 == 0) goto Lb1
            com.bytedance.msdk.api.c.mk r14 = r14.s()
            r10 = r14
            goto Lb2
        Lb1:
            r10 = r0
        Lb2:
            r11 = 0
            java.lang.ref.SoftReference<android.content.Context> r14 = r13.gb
            java.lang.Object r14 = r14.get()
            r12 = r14
            android.content.Context r12 = (android.content.Context) r12
            r5.d(r6, r7, r8, r9, r10, r11, r12)
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.c.tc.d(com.bytedance.msdk.b.an.d.hc):void");
    }

    public void he() {
        if (this.an.ra() || this.c == null || this.c.t() == 4) {
            return;
        }
        com.bytedance.msdk.core.u.hc.c.d().d(this.gb.get(), this.u, this.an.u());
    }

    public void b(final com.bytedance.msdk.hc.b bVar) {
        if (this.an.ra()) {
            return;
        }
        com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.c.tc.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.hc.b bVar2 = bVar;
                if (bVar2 == null || !bVar2.cw() || !bVar.xn() || (tc.this.c instanceof com.bytedance.msdk.api.c.d.hc.hc)) {
                    return;
                }
                com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.hc(tc.this.u, bVar.ph()) + "在show时触发了预加载【" + bVar.nw() + "】, loadSort: " + bVar.ho() + ", showSort: " + bVar.gu());
                tc.this.yo = true;
                com.bytedance.msdk.core.u.hc.c.d().hc(tc.this.gb.get(), tc.this.u, tc.this.an.u());
            }
        });
    }

    @Override // com.bytedance.msdk.b.c.hc
    public void d() {
        super.d();
        this.rf = null;
    }

    public void d(Activity activity, Object obj, String str, d dVar) throws JSONException {
        List<com.bytedance.msdk.core.tc.tc> listHc = null;
        if (!sy()) {
            com.bytedance.msdk.u.an.d(this.an);
            if (this.mq) {
                com.bytedance.msdk.u.an.d((List<com.bytedance.msdk.hc.b>) null, this.an, 0);
                if (dVar != null) {
                    dVar.d();
                    return;
                }
                return;
            }
        }
        int iHc = hc(this.u);
        if (iHc != 0) {
            com.bytedance.msdk.u.an.d((List<com.bytedance.msdk.hc.b>) null, this.an, iHc);
            if (dVar != null) {
                dVar.d();
                return;
            }
            return;
        }
        boolean zUo = uo();
        List<com.bytedance.msdk.hc.b> listJh = this.b.jh();
        try {
            listHc = hc();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        List<com.bytedance.msdk.core.tc.tc> list = listHc;
        if (list == null || list.size() <= 0 || !d(list, listJh, zUo, activity, obj, str)) {
            if (listJh != null && listJh.size() > 0) {
                for (com.bytedance.msdk.hc.b bVar : listJh) {
                    if (bVar != null && (!zUo || bVar.xn())) {
                        if (hc(bVar, activity, obj, str)) {
                            return;
                        }
                    }
                }
                if (zUo && this.c == null) {
                    for (com.bytedance.msdk.hc.b bVar2 : listJh) {
                        if (bVar2 != null && hc(bVar2, activity, obj, str)) {
                            return;
                        }
                    }
                }
            }
            com.bytedance.msdk.u.an.d(listJh, this.an, 0);
            if (dVar != null) {
                dVar.d();
            }
        }
    }

    private boolean c(com.bytedance.msdk.hc.b bVar) {
        return !bVar.wz() || bVar.np() == 1;
    }

    private boolean hc(com.bytedance.msdk.hc.b bVar, Activity activity, Object obj, String str) {
        if (!bVar.ba(this.u) || bVar.xp()) {
            return false;
        }
        if (sy()) {
            if (c(bVar) && !com.bytedance.msdk.core.admanager.d.d(bVar.nw(), bVar.el(), bVar.nv())) {
                com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.hc(this.u, bVar.ph()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.hc.d.d(bVar.t()) + ",isReady()：" + bVar.ba(this.u));
                d(bVar, activity, obj, str);
                return true;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.hc(this.u, bVar.ph()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.hc.d.d(bVar.t()) + ",isReady()：" + bVar.ba(this.u));
        d(bVar, activity, obj, str);
        return true;
    }

    private boolean b(com.bytedance.msdk.hc.b bVar, Activity activity, Object obj, String str) {
        if (!bVar.ba(this.u) || bVar.xp()) {
            return false;
        }
        if (sy()) {
            if (c(bVar) && !com.bytedance.msdk.core.admanager.d.d(bVar.nw(), bVar.el(), bVar.nv())) {
                com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.hc(this.u, bVar.ph()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.hc.d.d(bVar.t()) + ",isReady()：" + bVar.ba(this.u));
                hc(bVar);
                d(bVar, activity, obj, str);
                return true;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- cache 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.hc(this.u, bVar.ph()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.hc.d.d(bVar.t()) + ",isReady()：" + bVar.ba(this.u));
        hc(bVar);
        d(bVar, activity, obj, str);
        return true;
    }

    public void d(com.bytedance.msdk.hc.b bVar, final Activity activity, final Object obj, final String str) {
        this.c = bVar;
        com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.c.tc.2
            @Override // java.lang.Runnable
            public void run() {
                if (tc.this.c != null) {
                    if (tc.this.d != null) {
                        tc.this.c.d(tc.this.d);
                    }
                    if (tc.this.uo != null) {
                        tc.this.c.d(tc.this.uo);
                    }
                    if (tc.this.k != null) {
                        tc.this.c.d(tc.this.k);
                    }
                    tc.this.b.d(tc.this.c);
                    tc.this.c.u(true);
                    tc.this.c.d(tc.this.tt);
                    tc.this.c.hc(tc.this.rf);
                    if (tc.this.c.rs() && com.bytedance.msdk.core.u.d.d.d().c(tc.this.u, tc.this.c.ph(), tc.this.rf())) {
                        com.bytedance.msdk.b.gb.u.d(tc.this.c, tc.this.u, tc.this.c.ph());
                    }
                    List<com.bytedance.msdk.hc.b> listJh = tc.this.b.jh();
                    com.bytedance.msdk.core.u.d.d.d().d(listJh, tc.this.u, tc.this.an, tc.this.an.u(), tc.this.c);
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(tc.this.u, "show") + "展示的广告类型：" + com.bytedance.msdk.hc.d.d(tc.this.c.t()) + ",slotId：" + tc.this.c.ph() + ",slotType:" + tc.this.c.hg() + ",isReady()：" + tc.this.c.ba(tc.this.u) + "，是否为缓存广告:" + tc.this.c.xn());
                    tc.this.c.d(activity, obj, str);
                    com.bytedance.msdk.core.gb.uo.d().hc(tc.this.u);
                    com.bytedance.msdk.core.gb.mq.d().hc(tc.this.u, tc.this.c.ph());
                    tc.this.mq = true;
                    if (tc.this.c != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(tc.this.c);
                        if (tc.this.an.de() == 7 || tc.this.an.de() == 10) {
                            com.bytedance.msdk.b.u.d.d().d(tc.this.an, com.bytedance.msdk.b.u.d.d(tc.this.an, arrayList, listJh));
                        }
                        tc.this.d((List<com.bytedance.msdk.hc.b>) arrayList);
                    }
                    com.bytedance.msdk.u.an.d(tc.this.c, tc.this.an, false, tc.this.sy() ? 1 : 0);
                }
            }
        });
    }

    private boolean d(List<com.bytedance.msdk.core.tc.tc> list, List<com.bytedance.msdk.hc.b> list2, boolean z, Activity activity, Object obj, String str) {
        List<com.bytedance.msdk.core.u.hc.h> listD;
        com.bytedance.msdk.hc.b bVar;
        List<com.bytedance.msdk.core.u.hc.h> listD2;
        com.bytedance.msdk.hc.b bVar2;
        HashMap<String, com.bytedance.msdk.hc.b> mapHc = hc(list2);
        for (com.bytedance.msdk.core.tc.tc tcVar : list) {
            if (tcVar != null) {
                String strYo = tcVar.yo();
                com.bytedance.msdk.hc.b bVar3 = mapHc.get(strYo);
                if (bVar3 != null) {
                    if (z) {
                        if (bVar3.xn() && hc(bVar3, activity, obj, str)) {
                            return true;
                        }
                    } else if (hc(bVar3, activity, obj, str)) {
                        return true;
                    }
                }
                if (tcVar.jh() && com.bytedance.msdk.core.u.d.d.d().c(this.u, strYo, this.an.u()) && com.bytedance.msdk.core.u.d.d.d().d(strYo, this.an, false) == 3 && (listD2 = com.bytedance.msdk.core.u.d.d.d().d(strYo, this.an, this.an.u())) != null && listD2.size() > 0 && (bVar2 = listD2.get(0).d) != null) {
                    if (z) {
                        if (bVar2.xn() && b(bVar2, activity, obj, str)) {
                            return true;
                        }
                    } else if (b(bVar2, activity, obj, str)) {
                        return true;
                    }
                }
            }
        }
        if (z && this.c == null) {
            for (com.bytedance.msdk.core.tc.tc tcVar2 : list) {
                if (tcVar2 != null) {
                    String strYo2 = tcVar2.yo();
                    com.bytedance.msdk.hc.b bVar4 = mapHc.get(strYo2);
                    if (bVar4 != null && hc(bVar4, activity, obj, str)) {
                        return true;
                    }
                    if (tcVar2.jh() && com.bytedance.msdk.core.u.d.d.d().c(this.u, strYo2, this.an.u()) && com.bytedance.msdk.core.u.d.d.d().d(strYo2, this.an, false) == 3 && (listD = com.bytedance.msdk.core.u.d.d.d().d(strYo2, this.an, this.an.u())) != null && listD.size() > 0 && (bVar = listD.get(0).d) != null && b(bVar, activity, obj, str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean vv() {
        List<com.bytedance.msdk.core.tc.tc> listHc;
        try {
            listHc = hc();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            listHc = null;
        }
        return k.d(this.b.h(), this.b.tc(), this.b.gb(), this.an, this.mq, this.u, this.an.u(), listHc);
    }

    public void d(Object obj) {
        this.d = obj;
        if (this.c != null) {
            this.c.d(obj);
        }
    }
}
