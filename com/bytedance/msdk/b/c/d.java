package com.bytedance.msdk.b.c;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.b.c.tc;
import com.bytedance.msdk.gb.cb;
import com.bytedance.msdk.gb.rf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends c {
    com.bytedance.msdk.d.hc.hc d;
    com.bytedance.msdk.d.hc.b hc;
    private com.bytedance.msdk.api.c.d.an.hc jh;
    private com.bytedance.msdk.api.c.d.an.d sy;

    public d(Context context) {
        super(context);
        this.d = new com.bytedance.msdk.d.hc.hc() { // from class: com.bytedance.msdk.b.c.d.3
            /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
            @Override // com.bytedance.msdk.api.c.d.c.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void g_() {
                /*
                    Method dump skipped, instructions count: 378
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.c.d.AnonymousClass3.g_():void");
            }

            @Override // com.bytedance.msdk.api.c.d.c.d
            public void d(com.bytedance.msdk.api.d dVar) {
                String strHc;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (rf.d(d.this.c)) {
                    strHc = rf.hc();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strHc = null;
                    jCurrentTimeMillis = -1;
                }
                com.bytedance.msdk.u.an.d(d.this.c, d.this.an, dVar, 1, d.this.sy() ? 1 : 0, strHc, jCurrentTimeMillis);
                d.this.d(dVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
            @Override // com.bytedance.msdk.api.c.d.c.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void h_() {
                /*
                    r10 = this;
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    r0.np()
                    boolean r0 = com.bytedance.msdk.gb.cb.d()
                    r1 = 0
                    if (r0 == 0) goto L67
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.hc.b r0 = r0.c
                    if (r0 == 0) goto L4b
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.hc.b r0 = r0.c
                    java.lang.String r0 = r0.nw()
                    java.lang.String r2 = "pangle"
                    boolean r0 = r2.equals(r0)
                    if (r0 == 0) goto L4b
                    boolean r0 = com.bytedance.msdk.gb.cb.b()
                    if (r0 != 0) goto L40
                    java.lang.String r7 = com.bytedance.msdk.gb.rf.d()
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.hc.b r2 = r0.c
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.api.d.hc r3 = r0.an
                    r4 = 5
                    r5 = 1
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    boolean r6 = r0.sy()
                    com.bytedance.msdk.u.an.d(r2, r3, r4, r5, r6, r7)
                    return
                L40:
                    boolean r0 = com.bytedance.msdk.gb.cb.gb()
                    if (r0 == 0) goto L4b
                    java.lang.String r0 = com.bytedance.msdk.gb.rf.d()
                    goto L4c
                L4b:
                    r0 = r1
                L4c:
                    com.bytedance.msdk.b.c.d r2 = com.bytedance.msdk.b.c.d.this
                    boolean r2 = r2.yi()
                    if (r2 != 0) goto L65
                    com.bytedance.msdk.b.c.d r2 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.api.c.d.an.d r2 = com.bytedance.msdk.b.c.d.d(r2)
                    if (r2 == 0) goto L65
                    com.bytedance.msdk.b.c.d r2 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.api.c.d.an.d r2 = com.bytedance.msdk.b.c.d.d(r2)
                    r2.hc()
                L65:
                    r8 = r0
                    goto L79
                L67:
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.api.c.d.an.d r0 = com.bytedance.msdk.b.c.d.d(r0)
                    if (r0 == 0) goto L78
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.api.c.d.an.d r0 = com.bytedance.msdk.b.c.d.d(r0)
                    r0.hc()
                L78:
                    r8 = r1
                L79:
                    long r2 = java.lang.System.currentTimeMillis()
                    r4 = -1
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.hc.b r0 = r0.c
                    boolean r0 = com.bytedance.msdk.gb.rf.d(r0)
                    if (r0 == 0) goto L92
                    java.lang.String r1 = com.bytedance.msdk.gb.rf.hc()
                    long r4 = java.lang.System.currentTimeMillis()
                    long r4 = r4 - r2
                L92:
                    r6 = r4
                    r5 = r1
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    java.lang.String r0 = r0.u
                    com.bytedance.msdk.core.hc.d.u(r0)
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.hc.b r2 = r0.c
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.api.d.hc r3 = r0.an
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    boolean r4 = r0.sy()
                    com.bytedance.msdk.b.c.d r0 = com.bytedance.msdk.b.c.d.this
                    com.bytedance.msdk.hc.b r0 = r0.c
                    boolean r9 = r0.z()
                    com.bytedance.msdk.u.an.hc(r2, r3, r4, r5, r6, r8, r9)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.c.d.AnonymousClass3.h_():void");
            }

            @Override // com.bytedance.msdk.api.c.d.c.d
            public void b() {
                d.this.v();
                if (d.this.cb) {
                    if (cb.d()) {
                        if (d.this.c != null && "pangle".equals(d.this.c.nw())) {
                            if (!cb.b()) {
                                com.bytedance.msdk.u.an.d(d.this.c, d.this.an, 2, 1, d.this.sy() ? 1 : 0, rf.d());
                                return;
                            }
                            com.bytedance.msdk.u.an.d(d.this.c, d.this.an, 2, 0, d.this.sy() ? 1 : 0, (String) null);
                        }
                        if (d.this.yi()) {
                            return;
                        }
                        d.this.he();
                        if (d.this.sy != null) {
                            d.this.sy.b();
                            return;
                        }
                        return;
                    }
                    d.this.he();
                    if (d.this.sy != null) {
                        d.this.sy.b();
                    }
                }
            }

            @Override // com.bytedance.msdk.api.c.d.c.d
            public void c() {
                if (cb.d()) {
                    if (d.this.c != null && "pangle".equals(d.this.c.nw())) {
                        if (!cb.b()) {
                            com.bytedance.msdk.u.an.d(d.this.c, d.this.an, 1, 1, d.this.sy() ? 1 : 0, rf.d());
                            return;
                        }
                        com.bytedance.msdk.u.an.d(d.this.c, d.this.an, 1, 0, d.this.sy() ? 1 : 0, (String) null);
                    }
                    if (d.this.yi()) {
                        return;
                    }
                    d.this.he();
                    if (d.this.sy != null) {
                        d.this.sy.c();
                        return;
                    }
                    return;
                }
                d.this.he();
                if (d.this.sy != null) {
                    d.this.sy.c();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.c.d
            public void u() {
                String strHc;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (rf.d(d.this.c)) {
                    strHc = rf.hc();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strHc = null;
                    jCurrentTimeMillis = -1;
                }
                com.bytedance.msdk.u.an.d(d.this.c, d.this.an, (com.bytedance.msdk.api.d) null, 2, d.this.sy() ? 1 : 0, strHc, jCurrentTimeMillis);
                if (d.this.sy != null) {
                    d.this.sy.u();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.c.d
            public void an() {
                if (cb.d()) {
                    if (d.this.c != null && "pangle".equals(d.this.c.nw())) {
                        if (!cb.b()) {
                            com.bytedance.msdk.u.an.d(d.this.c, d.this.an, 3, 1, d.this.sy() ? 1 : 0, rf.d());
                            return;
                        }
                        com.bytedance.msdk.u.an.d(d.this.c, d.this.an, 3, 0, d.this.sy() ? 1 : 0, (String) null);
                    }
                    if (d.this.yi()) {
                        return;
                    }
                    d.this.he();
                    if (d.this.sy != null) {
                        d.this.sy.an();
                        return;
                    }
                    return;
                }
                d.this.he();
                if (d.this.sy != null) {
                    d.this.sy.an();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.c.d
            public void d(com.bytedance.msdk.api.b.d dVar) {
                if (d.this.sy != null) {
                    d.this.sy.d(mq.d(d.this.an, dVar, d.this.c));
                }
            }
        };
        this.hc = new com.bytedance.msdk.d.hc.b() { // from class: com.bytedance.msdk.b.c.d.4
            @Override // com.bytedance.msdk.api.c.d.u.d
            public void d() {
                d.this.de();
                if (d.this.sy != null) {
                    d.this.sy.d();
                }
                com.bytedance.msdk.core.gb.uo.d().h(d.this.u);
                if (d.this.c != null) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(d.this.u, "show_listen") + "adSlotId：" + d.this.c.ph() + "，广告类型：" + com.bytedance.msdk.hc.d.d(d.this.c.t()));
                    com.bytedance.msdk.core.gb.mk.d().hc(d.this.u, d.this.c.ph());
                }
                d dVar = d.this;
                dVar.d(dVar.b);
                d dVar2 = d.this;
                dVar2.b(dVar2.c);
                if (d.this.c != null) {
                    com.bytedance.msdk.core.b.b.d(d.this.c.nr(), d.this.u, d.this.c.ph());
                }
                String strHc = null;
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jCurrentTimeMillis2 = -1;
                if (rf.d(d.this.c)) {
                    strHc = rf.hc();
                    jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                }
                com.bytedance.msdk.u.an.d(d.this.c, d.this.an, d.this.sy() ? 1 : 0, strHc, jCurrentTimeMillis2, false);
                com.bytedance.msdk.core.h.b.d(d.this.u, d.this.c);
            }

            @Override // com.bytedance.msdk.api.c.d.u.d
            public void d(com.bytedance.msdk.api.d dVar) {
                String strHc;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (rf.d(d.this.c)) {
                    strHc = rf.hc();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strHc = null;
                    jCurrentTimeMillis = -1;
                }
                com.bytedance.msdk.u.an.d(d.this.c, d.this.an, dVar, 1, d.this.sy() ? 1 : 0, strHc, jCurrentTimeMillis);
                d.this.d(dVar);
            }

            @Override // com.bytedance.msdk.api.c.d.u.d
            public void hc() {
                d.this.np();
                if (d.this.sy != null) {
                    d.this.sy.hc();
                }
                String strHc = null;
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jCurrentTimeMillis2 = -1;
                if (rf.d(d.this.c)) {
                    strHc = rf.hc();
                    jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                }
                com.bytedance.msdk.hc.b bVar = d.this.c;
                com.bytedance.msdk.api.d.hc hcVar = d.this.an;
                boolean zSy = d.this.sy();
                boolean z = d.this.c.z();
                com.bytedance.msdk.u.an.hc(bVar, hcVar, zSy ? 1 : 0, strHc, jCurrentTimeMillis2, z);
            }

            @Override // com.bytedance.msdk.api.c.d.u.d
            public void b() {
                d.this.v();
                if (d.this.cb) {
                    d.this.he();
                    if (d.this.sy != null) {
                        d.this.sy.b();
                    }
                }
            }

            @Override // com.bytedance.msdk.api.c.d.u.d
            public void c() {
                if (d.this.sy != null) {
                    d.this.sy.h();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.u.d
            public void u() {
                if (d.this.sy != null) {
                    d.this.sy.gb();
                }
            }
        };
    }

    public void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.c.d.an.hc hcVar2) {
        super.hc(hcVar);
        this.an = hcVar;
        this.jh = hcVar2;
        this.tt = this.d;
        tt();
    }

    public void d(Activity activity) {
        d(activity, (Object) null, (String) null);
    }

    @Override // com.bytedance.msdk.b.c.c
    public void d(Activity activity, Object obj, String str) {
        if (activity == null) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "activity can not be null !");
        } else {
            hc(activity, obj, str);
            d(this.c);
        }
    }

    private void hc(Activity activity, Object obj, String str) {
        super.d(activity, obj, str, new tc.d() { // from class: com.bytedance.msdk.b.c.d.1
            @Override // com.bytedance.msdk.b.c.tc.d
            public void d() {
                d.this.d(new com.bytedance.msdk.api.d(40052, com.bytedance.msdk.api.d.d(40052)));
            }
        });
    }

    public void d(com.bytedance.msdk.api.c.d.an.d dVar) {
        this.sy = dVar;
    }

    @Override // com.bytedance.msdk.b.c.tc, com.bytedance.msdk.b.c.hc
    public void d() {
        if (this.c == null) {
            com.bytedance.msdk.core.u.d.d.d().d(this.b.jh(), this.u, this.an, rf(), this.c);
        }
        super.d();
        this.sy = null;
        this.jh = null;
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void h() {
        com.bytedance.msdk.api.c.d.an.hc hcVar = this.jh;
        if (hcVar != null) {
            hcVar.d();
        }
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void hc(com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.api.c.d.an.hc hcVar = this.jh;
        if (hcVar != null) {
            hcVar.d(dVar);
        }
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void gb() {
        com.bytedance.msdk.api.c.d.an.hc hcVar = this.jh;
        if (hcVar != null) {
            hcVar.hc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.c.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.sy != null) {
                    d.this.sy.d(dVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.b.c.c, com.bytedance.msdk.b.c.tc
    public void d(com.bytedance.msdk.hc.b bVar, Activity activity, Object obj, String str) {
        if (bVar != null) {
            if (bVar.nv() == 1) {
                this.tt = this.hc;
            } else if (bVar.nv() == 2) {
                this.tt = this.d;
            }
        }
        super.d(bVar, activity, obj, str);
    }
}
