package com.bytedance.msdk.b.c;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.b.c.tc;
import com.bytedance.msdk.gb.cb;
import com.bytedance.msdk.gb.rf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb extends c implements com.bytedance.msdk.d.hc.hc {
    private com.bytedance.msdk.api.c.d.c.hc d;
    private com.bytedance.msdk.api.c.d.c.d hc;

    public gb(Context context) {
        super(context);
    }

    public void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.c.d.c.hc hcVar2) {
        super.hc(hcVar);
        this.d = hcVar2;
        this.an = hcVar;
        this.tt = this;
        tt();
    }

    public void d(Activity activity) {
        hc(activity, null, null);
    }

    public void hc(Activity activity, Object obj, String str) {
        d(activity, obj, str);
    }

    @Override // com.bytedance.msdk.b.c.c
    protected void d(Activity activity, Object obj, String str) {
        super.d(activity, obj, str, new tc.d() { // from class: com.bytedance.msdk.b.c.gb.1
            @Override // com.bytedance.msdk.b.c.tc.d
            public void d() {
                gb.this.b(new com.bytedance.msdk.api.d(40052, com.bytedance.msdk.api.d.d(40052)));
            }
        });
        if (this.hc == null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "注意：未设置GMFullVideoAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        d(this.c);
    }

    public void d(com.bytedance.msdk.api.c.d.c.d dVar) {
        this.hc = dVar;
    }

    @Override // com.bytedance.msdk.b.c.tc, com.bytedance.msdk.b.c.hc
    public void d() {
        if (this.c == null) {
            com.bytedance.msdk.core.u.d.d.d().d(this.b.jh(), this.u, this.an, rf(), this.c);
        }
        super.d();
        this.hc = null;
        this.d = null;
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void h() {
        com.bytedance.msdk.api.c.d.c.hc hcVar = this.d;
        if (hcVar != null) {
            hcVar.d();
        }
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void hc(com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.api.c.d.c.hc hcVar = this.d;
        if (hcVar != null) {
            hcVar.d(dVar);
        }
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void gb() {
        com.bytedance.msdk.api.c.d.c.hc hcVar = this.d;
        if (hcVar != null) {
            hcVar.hc();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    @Override // com.bytedance.msdk.api.c.d.c.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g_() {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.c.gb.g_():void");
    }

    @Override // com.bytedance.msdk.api.c.d.c.d
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
        com.bytedance.msdk.u.an.d(this.c, this.an, dVar, 1, sy() ? 1 : 0, strHc, jCurrentTimeMillis);
        b(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    @Override // com.bytedance.msdk.api.c.d.c.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h_() {
        /*
            r10 = this;
            r10.np()
            boolean r0 = com.bytedance.msdk.gb.cb.d()
            r1 = 0
            if (r0 == 0) goto L4f
            com.bytedance.msdk.hc.b r0 = r10.c
            if (r0 == 0) goto L3f
            com.bytedance.msdk.hc.b r0 = r10.c
            java.lang.String r0 = r0.nw()
            java.lang.String r2 = "pangle"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L3f
            boolean r0 = com.bytedance.msdk.gb.cb.b()
            if (r0 != 0) goto L34
            java.lang.String r7 = com.bytedance.msdk.gb.rf.d()
            com.bytedance.msdk.hc.b r2 = r10.c
            com.bytedance.msdk.api.d.hc r3 = r10.an
            r4 = 5
            r5 = 1
            boolean r6 = r10.sy()
            com.bytedance.msdk.u.an.d(r2, r3, r4, r5, r6, r7)
            return
        L34:
            boolean r0 = com.bytedance.msdk.gb.cb.gb()
            if (r0 == 0) goto L3f
            java.lang.String r0 = com.bytedance.msdk.gb.rf.d()
            goto L40
        L3f:
            r0 = r1
        L40:
            boolean r2 = r10.yi()
            if (r2 != 0) goto L4d
            com.bytedance.msdk.api.c.d.c.d r2 = r10.hc
            if (r2 == 0) goto L4d
            r2.h_()
        L4d:
            r8 = r0
            goto L57
        L4f:
            com.bytedance.msdk.api.c.d.c.d r0 = r10.hc
            if (r0 == 0) goto L56
            r0.h_()
        L56:
            r8 = r1
        L57:
            long r2 = java.lang.System.currentTimeMillis()
            r4 = -1
            com.bytedance.msdk.hc.b r0 = r10.c
            boolean r0 = com.bytedance.msdk.gb.rf.d(r0)
            if (r0 == 0) goto L6e
            java.lang.String r1 = com.bytedance.msdk.gb.rf.hc()
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
        L6e:
            r6 = r4
            r5 = r1
            com.bytedance.msdk.api.d.hc r0 = r10.an
            java.lang.String r0 = r0.v()
            com.bytedance.msdk.core.hc.d.u(r0)
            com.bytedance.msdk.hc.b r2 = r10.c
            com.bytedance.msdk.api.d.hc r3 = r10.an
            boolean r4 = r10.sy()
            com.bytedance.msdk.hc.b r0 = r10.c
            boolean r9 = r0.z()
            com.bytedance.msdk.u.an.hc(r2, r3, r4, r5, r6, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.c.gb.h_():void");
    }

    @Override // com.bytedance.msdk.api.c.d.c.d
    public void b() {
        v();
        if (this.cb) {
            if (cb.d()) {
                if (this.c != null && "pangle".equals(this.c.nw())) {
                    if (!cb.b()) {
                        com.bytedance.msdk.u.an.d(this.c, this.an, 2, 1, sy() ? 1 : 0, rf.d());
                        return;
                    }
                    com.bytedance.msdk.u.an.d(this.c, this.an, 2, 0, sy() ? 1 : 0, (String) null);
                }
                if (yi()) {
                    return;
                }
                he();
                com.bytedance.msdk.api.c.d.c.d dVar = this.hc;
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            he();
            com.bytedance.msdk.api.c.d.c.d dVar2 = this.hc;
            if (dVar2 != null) {
                dVar2.b();
            }
        }
    }

    @Override // com.bytedance.msdk.api.c.d.c.d
    public void c() {
        if (cb.d()) {
            if (this.c != null && "pangle".equals(this.c.nw())) {
                if (!cb.b()) {
                    com.bytedance.msdk.u.an.d(this.c, this.an, 1, 1, sy() ? 1 : 0, rf.d());
                    return;
                }
                com.bytedance.msdk.u.an.d(this.c, this.an, 1, 0, sy() ? 1 : 0, (String) null);
            }
            if (yi()) {
                return;
            }
            he();
            com.bytedance.msdk.api.c.d.c.d dVar = this.hc;
            if (dVar != null) {
                dVar.c();
                return;
            }
            return;
        }
        he();
        com.bytedance.msdk.api.c.d.c.d dVar2 = this.hc;
        if (dVar2 != null) {
            dVar2.c();
        }
    }

    @Override // com.bytedance.msdk.api.c.d.c.d
    public void u() {
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
        com.bytedance.msdk.u.an.d(this.c, this.an, (com.bytedance.msdk.api.d) null, 2, sy() ? 1 : 0, strHc, jCurrentTimeMillis);
        com.bytedance.msdk.api.c.d.c.d dVar = this.hc;
        if (dVar != null) {
            dVar.u();
        }
    }

    @Override // com.bytedance.msdk.api.c.d.c.d
    public void an() {
        if (cb.d()) {
            if (this.c != null && "pangle".equals(this.c.nw())) {
                if (!cb.b()) {
                    com.bytedance.msdk.u.an.d(this.c, this.an, 3, 1, sy() ? 1 : 0, rf.d());
                    return;
                }
                com.bytedance.msdk.u.an.d(this.c, this.an, 3, 0, sy() ? 1 : 0, (String) null);
            }
            if (yi()) {
                return;
            }
            he();
            com.bytedance.msdk.api.c.d.c.d dVar = this.hc;
            if (dVar != null) {
                dVar.an();
                return;
            }
            return;
        }
        he();
        com.bytedance.msdk.api.c.d.c.d dVar2 = this.hc;
        if (dVar2 != null) {
            dVar2.an();
        }
    }

    @Override // com.bytedance.msdk.api.c.d.c.d
    public void d(com.bytedance.msdk.api.b.d dVar) {
        com.bytedance.msdk.api.c.d.c.d dVar2 = this.hc;
        if (dVar2 != null) {
            dVar2.d(mq.d(this.an, dVar, this.c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.c.gb.2
            @Override // java.lang.Runnable
            public void run() {
                if (gb.this.hc != null) {
                    gb.this.hc.d(dVar);
                }
            }
        });
    }
}
