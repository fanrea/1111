package com.bytedance.msdk.b.c;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.msdk.b.c.tc;
import com.bytedance.msdk.gb.cb;
import com.bytedance.msdk.gb.k;
import com.bytedance.msdk.gb.rf;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq extends tc implements com.bytedance.msdk.d.hc.c {
    private com.bytedance.msdk.api.c.d.gb.d cb;
    com.bytedance.msdk.api.c.d.gb.d d;
    private com.bytedance.msdk.core.admanager.reward.d de;
    private com.bytedance.msdk.api.c.d.gb.hc hc;
    private com.bytedance.msdk.api.c.d.gb.d jh;
    private boolean np;
    private com.bytedance.msdk.core.admanager.reward.d sy;
    private com.bytedance.msdk.core.admanager.reward.rewardagain.b v;
    private final com.bytedance.msdk.d.hc.hc yi;

    public mq(Context context) {
        super(context);
        this.d = new AnonymousClass2();
        this.yi = new AnonymousClass6();
    }

    public void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.c.d.gb.hc hcVar2) {
        d(hcVar);
        this.sy = new com.bytedance.msdk.core.admanager.reward.d(this.u);
        this.de = new com.bytedance.msdk.core.admanager.reward.d(this.u);
        this.hc = hcVar2;
        this.tt = this;
        this.rf = this.d;
        if (com.bytedance.msdk.core.admanager.reward.rewardagain.b.tt(this.u) != null) {
            this.v = new com.bytedance.msdk.core.admanager.reward.rewardagain.b(this.gb.get(), this.an, this.cb, this.jh);
        }
        tt();
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void hc(com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.api.c.d.gb.hc hcVar = this.hc;
        if (hcVar != null) {
            hcVar.d(dVar);
        }
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void h() {
        com.bytedance.msdk.api.c.d.gb.hc hcVar = this.hc;
        if (hcVar != null) {
            hcVar.d();
        }
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void gb() {
        com.bytedance.msdk.api.c.d.gb.hc hcVar = this.hc;
        if (hcVar != null) {
            hcVar.hc();
        }
    }

    public void d(Activity activity, Object obj, String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.b bVar = this.v;
        if (bVar != null) {
            bVar.d(activity, obj, str);
        }
        d(activity, obj, str, new tc.d() { // from class: com.bytedance.msdk.b.c.mq.1
            @Override // com.bytedance.msdk.b.c.tc.d
            public void d() {
                mq.this.c(new com.bytedance.msdk.api.d(40052, com.bytedance.msdk.api.d.d(40052)));
            }
        });
        if (this.cb == null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "注意：未设置GMRewardedAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        d(this.c);
    }

    public void d(Activity activity) {
        d(activity, (Object) null, (String) null);
    }

    @Override // com.bytedance.msdk.b.c.tc
    public void d(com.bytedance.msdk.hc.b bVar, Activity activity, Object obj, String str) {
        if (bVar != null) {
            if (bVar.nv() != 6 && bVar.nv() == 7) {
                this.tt = this.yi;
            } else {
                this.tt = this;
            }
        }
        super.d(bVar, activity, obj, str);
    }

    public void d(com.bytedance.msdk.api.c.d.gb.d dVar) {
        this.cb = dVar;
        com.bytedance.msdk.core.admanager.reward.rewardagain.b bVar = this.v;
        if (bVar != null) {
            bVar.d(dVar);
        }
    }

    public void hc(com.bytedance.msdk.api.c.d.gb.d dVar) {
        this.jh = dVar;
        com.bytedance.msdk.core.admanager.reward.rewardagain.b bVar = this.v;
        if (bVar != null) {
            bVar.hc(dVar);
        }
    }

    /* renamed from: com.bytedance.msdk.b.c.mq$2, reason: invalid class name */
    class AnonymousClass2 implements com.bytedance.msdk.api.c.d.gb.d {
        AnonymousClass2() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
        @Override // com.bytedance.msdk.api.c.d.gb.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void i_() {
            /*
                Method dump skipped, instructions count: 345
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.c.mq.AnonymousClass2.i_():void");
        }

        @Override // com.bytedance.msdk.api.c.d.gb.d
        public void d(com.bytedance.msdk.api.d dVar) {
            String strHc;
            long jCurrentTimeMillis;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (rf.d(mq.this.c)) {
                strHc = rf.hc();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                strHc = null;
                jCurrentTimeMillis = -1;
            }
            com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, dVar, 1, 1, strHc, jCurrentTimeMillis);
            mq.this.b(dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
        @Override // com.bytedance.msdk.api.c.d.gb.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void j_() {
            /*
                r10 = this;
                boolean r0 = com.bytedance.msdk.gb.cb.d()
                r1 = 0
                if (r0 == 0) goto L5d
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r0 = r0.c
                if (r0 == 0) goto L41
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r0 = r0.c
                java.lang.String r0 = r0.nw()
                java.lang.String r2 = "pangle"
                boolean r0 = r2.equals(r0)
                if (r0 == 0) goto L41
                boolean r0 = com.bytedance.msdk.gb.cb.hc()
                if (r0 != 0) goto L36
                java.lang.String r7 = com.bytedance.msdk.gb.rf.d()
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r2 = r0.c
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.d.hc r3 = r0.an
                r4 = 5
                r5 = 1
                r6 = 1
                com.bytedance.msdk.u.an.d(r2, r3, r4, r5, r6, r7)
                return
            L36:
                boolean r0 = com.bytedance.msdk.gb.cb.u()
                if (r0 == 0) goto L41
                java.lang.String r0 = com.bytedance.msdk.gb.rf.d()
                goto L42
            L41:
                r0 = r1
            L42:
                com.bytedance.msdk.b.c.mq r2 = com.bytedance.msdk.b.c.mq.this
                boolean r2 = r2.yi()
                if (r2 != 0) goto L5b
                com.bytedance.msdk.b.c.mq r2 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.c.d.gb.d r2 = com.bytedance.msdk.b.c.mq.d(r2)
                if (r2 == 0) goto L5b
                com.bytedance.msdk.b.c.mq r2 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.c.d.gb.d r2 = com.bytedance.msdk.b.c.mq.d(r2)
                r2.j_()
            L5b:
                r8 = r0
                goto L6f
            L5d:
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.c.d.gb.d r0 = com.bytedance.msdk.b.c.mq.d(r0)
                if (r0 == 0) goto L6e
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.c.d.gb.d r0 = com.bytedance.msdk.b.c.mq.d(r0)
                r0.j_()
            L6e:
                r8 = r1
            L6f:
                long r2 = java.lang.System.currentTimeMillis()
                r4 = -1
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r0 = r0.c
                boolean r0 = com.bytedance.msdk.gb.rf.d(r0)
                if (r0 == 0) goto L88
                java.lang.String r1 = com.bytedance.msdk.gb.rf.hc()
                long r4 = java.lang.System.currentTimeMillis()
                long r4 = r4 - r2
            L88:
                r6 = r4
                r5 = r1
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r2 = r0.c
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.d.hc r3 = r0.an
                r4 = 1
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r0 = r0.c
                boolean r9 = r0.fs()
                com.bytedance.msdk.u.an.hc(r2, r3, r4, r5, r6, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.c.mq.AnonymousClass2.j_():void");
        }

        @Override // com.bytedance.msdk.api.c.d.gb.d
        public void b() {
            if (!cb.d()) {
                if (mq.this.jh != null) {
                    mq.this.jh.b();
                    return;
                }
                return;
            }
            if (mq.this.c != null && "pangle".equals(mq.this.c.nw())) {
                if (!cb.hc()) {
                    com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 2, 1, 1, rf.d());
                    return;
                }
                com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 2, 0, 1, (String) null);
            }
            if (mq.this.yi() || mq.this.jh == null) {
                return;
            }
            mq.this.jh.b();
        }

        @Override // com.bytedance.msdk.api.c.d.gb.d
        public void c() {
            if (!cb.d()) {
                if (mq.this.de.d()) {
                    mq.this.de.u();
                }
                if (mq.this.jh != null) {
                    mq.this.jh.c();
                    return;
                }
                return;
            }
            if (mq.this.c != null && "pangle".equals(mq.this.c.nw())) {
                if (!cb.hc()) {
                    com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 1, 1, 1, rf.d());
                    return;
                }
                com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 1, 0, 1, (String) null);
            }
            if (mq.this.yi()) {
                return;
            }
            if (mq.this.de.d()) {
                mq.this.de.u();
            }
            if (mq.this.jh != null) {
                mq.this.jh.c();
            }
        }

        @Override // com.bytedance.msdk.api.c.d.gb.d
        public void u() {
            String strHc;
            long jCurrentTimeMillis;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (rf.d(mq.this.c)) {
                strHc = rf.hc();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                strHc = null;
                jCurrentTimeMillis = -1;
            }
            com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, (com.bytedance.msdk.api.d) null, 2, 1, strHc, jCurrentTimeMillis);
            if (mq.this.jh != null) {
                mq.this.jh.u();
            }
        }

        @Override // com.bytedance.msdk.api.c.d.gb.d
        public void d(com.bytedance.msdk.api.b.d dVar) {
            if (!cb.d()) {
                if (mq.this.de.d()) {
                    mq.this.de.c();
                    return;
                } else {
                    if (mq.this.jh != null) {
                        mq.this.jh.d(mq.d(mq.this.an, dVar, mq.this.c));
                        mq.this.d((com.bytedance.msdk.api.b.d) null, 1);
                        return;
                    }
                    return;
                }
            }
            if (mq.this.c != null && "pangle".equals(mq.this.c.nw())) {
                if (!cb.hc()) {
                    com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 4, 1, 1, rf.d());
                    return;
                }
                com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 4, 0, 1, cb.an() ? rf.d() : null);
            }
            if (mq.this.yi()) {
                return;
            }
            if (mq.this.de.d()) {
                mq.this.de.c();
            } else if (mq.this.jh != null) {
                mq.this.jh.d(mq.d(mq.this.an, dVar, mq.this.c));
                mq.this.d((com.bytedance.msdk.api.b.d) null, 1);
            }
        }

        @Override // com.bytedance.msdk.api.c.d.gb.d
        public void an() {
            if (!cb.d()) {
                if (mq.this.de.d()) {
                    mq.this.de.hc();
                }
                if (mq.this.jh != null) {
                    mq.this.jh.an();
                    return;
                }
                return;
            }
            if (mq.this.c != null && "pangle".equals(mq.this.c.nw())) {
                if (!cb.hc()) {
                    com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 3, 1, 1, rf.d());
                    return;
                }
                com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 3, 0, 1, (String) null);
            }
            if (mq.this.yi()) {
                return;
            }
            if (mq.this.de.d()) {
                mq.this.de.hc();
            }
            if (mq.this.jh != null) {
                mq.this.jh.an();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.c.mq.3
            @Override // java.lang.Runnable
            public void run() {
                if (mq.this.jh != null) {
                    mq.this.jh.d(dVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.bytedance.msdk.api.b.d dVar, int i) {
        String strHc;
        long jCurrentTimeMillis;
        int i2;
        int iIntValue;
        String str;
        Map<String, Object> mapC;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (rf.d(this.c)) {
            strHc = rf.hc();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strHc = null;
            jCurrentTimeMillis = -1;
        }
        String str2 = strHc;
        long j = jCurrentTimeMillis;
        if (dVar == null || (mapC = dVar.c()) == null) {
            i2 = 0;
            iIntValue = 0;
            str = "";
        } else {
            Integer num = (Integer) mapC.get("reason");
            int iIntValue2 = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) mapC.get("errorCode");
            iIntValue = num2 != null ? num2.intValue() : 0;
            str = (String) mapC.get("errorMsg");
            i2 = iIntValue2;
        }
        com.bytedance.msdk.u.an.d(this.c, this.an, i, str2, j, i2, iIntValue, str);
    }

    public static com.bytedance.msdk.api.b.d d(final com.bytedance.msdk.api.d.hc hcVar, final com.bytedance.msdk.api.b.d dVar, final com.bytedance.msdk.hc.b bVar) {
        if (dVar == null) {
            return null;
        }
        return new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.b.c.mq.4
            @Override // com.bytedance.msdk.api.b.d
            public boolean d() {
                return dVar.d();
            }

            @Override // com.bytedance.msdk.api.b.d
            public float hc() {
                return dVar.hc();
            }

            @Override // com.bytedance.msdk.api.b.d
            public String b() {
                return dVar.b();
            }

            @Override // com.bytedance.msdk.api.b.d
            public Map<String, Object> c() {
                HashMap map;
                Map<String, Object> mapC = dVar.c();
                if (mapC != null && mapC.size() > 0) {
                    map = new HashMap(mapC);
                } else {
                    map = new HashMap();
                }
                com.bytedance.msdk.api.b bVarD = k.d(hcVar, bVar, true);
                map.put("adnName", bVarD != null ? bVarD.mq() : "");
                map.put(SplashAd.KEY_BIDFAIL_ECPM, bVarD != null ? bVarD.uo() : "");
                return map;
            }
        };
    }

    @Override // com.bytedance.msdk.b.c.tc, com.bytedance.msdk.b.c.hc
    public void d() {
        if (this.c == null) {
            com.bytedance.msdk.core.u.d.d.d().d(this.b.jh(), this.u, this.an, this.an.u(), this.c);
        }
        super.d();
        this.sy.b();
        this.de.b();
        this.hc = null;
        this.cb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.c.mq.5
            @Override // java.lang.Runnable
            public void run() {
                if (mq.this.cb != null) {
                    mq.this.cb.d(dVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean de() {
        int i;
        if (this.an == null || this.an.gb() == 1) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 激励再得，一次链路只展示一次激励再得: " + this.u);
            return false;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.d dVarTt = com.bytedance.msdk.core.admanager.reward.rewardagain.b.tt(this.u);
        if (dVarTt == null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 激励再得开关未开启: " + this.u);
            return false;
        }
        if (this.np) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 激励再得，adn已经触发了再看一个: " + this.u);
            return false;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.b bVar = this.v;
        if (bVar != null) {
            int iD = bVar.d(this.an, dVarTt, this.c);
            if (com.bytedance.msdk.core.u.hc.c.d().b(this.u, this.an.u())) {
                i = this.yo ? 4 : 2;
            } else {
                i = 1;
            }
            com.bytedance.msdk.u.an.d(this.an, iD, i);
            if (iD == 0) {
                this.v.d(dVarTt, this.c);
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.bytedance.msdk.b.c.mq$6, reason: invalid class name */
    class AnonymousClass6 implements com.bytedance.msdk.d.hc.hc {
        private volatile boolean hc = false;
        private volatile boolean b = false;
        private final Handler c = new Handler(Looper.getMainLooper());

        @Override // com.bytedance.msdk.api.c.d.c.d
        public void d(com.bytedance.msdk.api.b.d dVar) {
        }

        AnonymousClass6() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
        @Override // com.bytedance.msdk.api.c.d.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void g_() {
            /*
                Method dump skipped, instructions count: 409
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.c.mq.AnonymousClass6.g_():void");
        }

        @Override // com.bytedance.msdk.api.c.d.c.d
        public void d(com.bytedance.msdk.api.d dVar) {
            String strHc;
            long jCurrentTimeMillis;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (rf.d(mq.this.c)) {
                strHc = rf.hc();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                strHc = null;
                jCurrentTimeMillis = -1;
            }
            com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, dVar, 1, 0, strHc, jCurrentTimeMillis);
            mq.this.c(dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
        @Override // com.bytedance.msdk.api.c.d.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void h_() {
            /*
                r10 = this;
                boolean r0 = com.bytedance.msdk.gb.cb.d()
                r1 = 0
                if (r0 == 0) goto L5d
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r0 = r0.c
                if (r0 == 0) goto L41
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r0 = r0.c
                java.lang.String r0 = r0.nw()
                java.lang.String r2 = "pangle"
                boolean r0 = r2.equals(r0)
                if (r0 == 0) goto L41
                boolean r0 = com.bytedance.msdk.gb.cb.b()
                if (r0 != 0) goto L36
                java.lang.String r7 = com.bytedance.msdk.gb.rf.d()
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r2 = r0.c
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.d.hc r3 = r0.an
                r4 = 5
                r5 = 1
                r6 = 0
                com.bytedance.msdk.u.an.d(r2, r3, r4, r5, r6, r7)
                return
            L36:
                boolean r0 = com.bytedance.msdk.gb.cb.gb()
                if (r0 == 0) goto L41
                java.lang.String r0 = com.bytedance.msdk.gb.rf.d()
                goto L42
            L41:
                r0 = r1
            L42:
                com.bytedance.msdk.b.c.mq r2 = com.bytedance.msdk.b.c.mq.this
                boolean r2 = r2.yi()
                if (r2 != 0) goto L5b
                com.bytedance.msdk.b.c.mq r2 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.c.d.gb.d r2 = com.bytedance.msdk.b.c.mq.b(r2)
                if (r2 == 0) goto L5b
                com.bytedance.msdk.b.c.mq r2 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.c.d.gb.d r2 = com.bytedance.msdk.b.c.mq.b(r2)
                r2.j_()
            L5b:
                r8 = r0
                goto L6f
            L5d:
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.c.d.gb.d r0 = com.bytedance.msdk.b.c.mq.b(r0)
                if (r0 == 0) goto L6e
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.c.d.gb.d r0 = com.bytedance.msdk.b.c.mq.b(r0)
                r0.j_()
            L6e:
                r8 = r1
            L6f:
                long r2 = java.lang.System.currentTimeMillis()
                r4 = -1
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r0 = r0.c
                boolean r0 = com.bytedance.msdk.gb.rf.d(r0)
                if (r0 == 0) goto L88
                java.lang.String r1 = com.bytedance.msdk.gb.rf.hc()
                long r4 = java.lang.System.currentTimeMillis()
                long r4 = r4 - r2
            L88:
                r6 = r4
                r5 = r1
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                java.lang.String r0 = r0.u
                com.bytedance.msdk.core.hc.d.u(r0)
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r2 = r0.c
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.api.d.hc r3 = r0.an
                r4 = 0
                com.bytedance.msdk.b.c.mq r0 = com.bytedance.msdk.b.c.mq.this
                com.bytedance.msdk.hc.b r0 = r0.c
                boolean r9 = r0.z()
                com.bytedance.msdk.u.an.hc(r2, r3, r4, r5, r6, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.c.mq.AnonymousClass6.h_():void");
        }

        @Override // com.bytedance.msdk.api.c.d.c.d
        public void b() {
            h();
            this.b = true;
            if (cb.d()) {
                if (mq.this.c != null && "pangle".equals(mq.this.c.nw())) {
                    if (!cb.b()) {
                        com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 2, 1, 0, rf.d());
                        return;
                    }
                    com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 2, 0, 0, (String) null);
                }
                if (mq.this.yi()) {
                    return;
                }
                mq.this.he();
                if (mq.this.de() || mq.this.cb == null) {
                    return;
                }
                mq.this.cb.b();
                return;
            }
            mq.this.he();
            if (mq.this.de() || mq.this.cb == null) {
                return;
            }
            mq.this.cb.b();
        }

        @Override // com.bytedance.msdk.api.c.d.c.d
        public void c() {
            if (cb.d()) {
                if (mq.this.c != null && "pangle".equals(mq.this.c.nw())) {
                    if (!cb.b()) {
                        com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 1, 1, 0, rf.d());
                        return;
                    }
                    com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 1, 0, 0, (String) null);
                }
                if (mq.this.yi()) {
                    return;
                }
                mq.this.he();
                if (mq.this.sy.d()) {
                    mq.this.sy.u();
                }
                if (mq.this.cb != null) {
                    mq.this.cb.c();
                    return;
                }
                return;
            }
            mq.this.he();
            if (mq.this.sy.d()) {
                mq.this.sy.u();
            }
            if (mq.this.cb != null) {
                mq.this.cb.c();
            }
        }

        @Override // com.bytedance.msdk.api.c.d.c.d
        public void u() {
            mq.this.u();
        }

        @Override // com.bytedance.msdk.api.c.d.c.d
        public void an() {
            h();
            this.hc = true;
            if (cb.d()) {
                if (mq.this.c != null && "pangle".equals(mq.this.c.nw())) {
                    if (!cb.b()) {
                        com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 3, 1, 0, rf.d());
                        return;
                    }
                    com.bytedance.msdk.u.an.d(mq.this.c, mq.this.an, 3, 0, 0, (String) null);
                }
                if (mq.this.yi()) {
                    return;
                }
                mq.this.he();
                if (mq.this.sy.d()) {
                    mq.this.sy.hc();
                }
                if (mq.this.cb != null) {
                    mq.this.cb.an();
                    return;
                }
                return;
            }
            mq.this.he();
            if (mq.this.sy.d()) {
                mq.this.sy.hc();
            }
            if (mq.this.cb != null) {
                mq.this.cb.an();
            }
        }

        private void gb() {
            this.c.postDelayed(new Runnable() { // from class: com.bytedance.msdk.b.c.mq.6.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AnonymousClass6.this.b || AnonymousClass6.this.hc) {
                        AnonymousClass6.this.h();
                        return;
                    }
                    mq.this.d(new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.b.c.mq.6.2.1
                        @Override // com.bytedance.msdk.api.b.d
                        public boolean d() {
                            return true;
                        }

                        @Override // com.bytedance.msdk.api.b.d
                        public float hc() {
                            if (mq.this.an != null) {
                                return mq.this.an.s();
                            }
                            return 0.0f;
                        }

                        @Override // com.bytedance.msdk.api.b.d
                        public String b() {
                            return mq.this.an != null ? mq.this.an.j() : "";
                        }

                        @Override // com.bytedance.msdk.api.b.d
                        public Map<String, Object> c() {
                            return new HashMap();
                        }
                    });
                    AnonymousClass6.this.h();
                }
            }, com.bytedance.msdk.h.d.d.d().an());
        }

        public void h() {
            this.c.removeCallbacksAndMessages(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    @Override // com.bytedance.msdk.api.c.d.gb.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i_() {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.c.mq.i_():void");
    }

    @Override // com.bytedance.msdk.api.c.d.gb.d
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
        c(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    @Override // com.bytedance.msdk.api.c.d.gb.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j_() {
        /*
            r10 = this;
            com.bytedance.msdk.api.d.hc r0 = r10.an
            java.lang.String r0 = r0.v()
            com.bytedance.msdk.core.hc.d.u(r0)
            boolean r0 = com.bytedance.msdk.gb.cb.d()
            r1 = 0
            if (r0 == 0) goto L52
            com.bytedance.msdk.hc.b r0 = r10.c
            if (r0 == 0) goto L42
            com.bytedance.msdk.hc.b r0 = r10.c
            java.lang.String r0 = r0.nw()
            java.lang.String r2 = "pangle"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L42
            boolean r0 = com.bytedance.msdk.gb.cb.hc()
            if (r0 != 0) goto L37
            java.lang.String r7 = com.bytedance.msdk.gb.rf.d()
            com.bytedance.msdk.hc.b r2 = r10.c
            com.bytedance.msdk.api.d.hc r3 = r10.an
            r4 = 5
            r5 = 1
            r6 = 0
            com.bytedance.msdk.u.an.d(r2, r3, r4, r5, r6, r7)
            return
        L37:
            boolean r0 = com.bytedance.msdk.gb.cb.u()
            if (r0 == 0) goto L42
            java.lang.String r0 = com.bytedance.msdk.gb.rf.d()
            goto L43
        L42:
            r0 = r1
        L43:
            boolean r2 = r10.yi()
            if (r2 != 0) goto L50
            com.bytedance.msdk.api.c.d.gb.d r2 = r10.cb
            if (r2 == 0) goto L50
            r2.j_()
        L50:
            r8 = r0
            goto L5a
        L52:
            com.bytedance.msdk.api.c.d.gb.d r0 = r10.cb
            if (r0 == 0) goto L59
            r0.j_()
        L59:
            r8 = r1
        L5a:
            long r2 = java.lang.System.currentTimeMillis()
            r4 = -1
            com.bytedance.msdk.hc.b r0 = r10.c
            boolean r0 = com.bytedance.msdk.gb.rf.d(r0)
            if (r0 == 0) goto L71
            java.lang.String r1 = com.bytedance.msdk.gb.rf.hc()
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
        L71:
            r6 = r4
            r5 = r1
            com.bytedance.msdk.hc.b r2 = r10.c
            com.bytedance.msdk.api.d.hc r3 = r10.an
            r4 = 0
            com.bytedance.msdk.hc.b r0 = r10.c
            boolean r9 = r0.z()
            com.bytedance.msdk.u.an.hc(r2, r3, r4, r5, r6, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.c.mq.j_():void");
    }

    @Override // com.bytedance.msdk.api.c.d.gb.d
    public void b() {
        com.bytedance.msdk.api.c.d.gb.d dVar;
        com.bytedance.msdk.api.c.d.gb.d dVar2;
        if (cb.d()) {
            if (this.c != null && "pangle".equals(this.c.nw())) {
                if (!cb.hc()) {
                    com.bytedance.msdk.u.an.d(this.c, this.an, 2, 1, 0, rf.d());
                    return;
                }
                com.bytedance.msdk.u.an.d(this.c, this.an, 2, 0, 0, (String) null);
            }
            if (yi()) {
                return;
            }
            he();
            if (de() || (dVar2 = this.cb) == null) {
                return;
            }
            dVar2.b();
            return;
        }
        he();
        if (de() || (dVar = this.cb) == null) {
            return;
        }
        dVar.b();
    }

    @Override // com.bytedance.msdk.api.c.d.gb.d
    public void c() {
        if (cb.d()) {
            if (this.c != null && "pangle".equals(this.c.nw())) {
                if (!cb.hc()) {
                    com.bytedance.msdk.u.an.d(this.c, this.an, 1, 1, 0, rf.d());
                    return;
                }
                com.bytedance.msdk.u.an.d(this.c, this.an, 1, 0, 0, (String) null);
            }
            if (yi()) {
                return;
            }
            he();
            if (this.sy.d()) {
                this.sy.u();
            }
            com.bytedance.msdk.api.c.d.gb.d dVar = this.cb;
            if (dVar != null) {
                dVar.c();
                return;
            }
            return;
        }
        he();
        if (this.sy.d()) {
            this.sy.u();
        }
        com.bytedance.msdk.api.c.d.gb.d dVar2 = this.cb;
        if (dVar2 != null) {
            dVar2.c();
        }
    }

    @Override // com.bytedance.msdk.api.c.d.gb.d
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
        com.bytedance.msdk.u.an.d(this.c, this.an, (com.bytedance.msdk.api.d) null, 2, 0, strHc, jCurrentTimeMillis);
        com.bytedance.msdk.api.c.d.gb.d dVar = this.cb;
        if (dVar != null) {
            dVar.u();
        }
    }

    @Override // com.bytedance.msdk.api.c.d.gb.d
    public void d(com.bytedance.msdk.api.b.d dVar) {
        if (cb.d()) {
            if (this.c != null && "pangle".equals(this.c.nw())) {
                if (!cb.hc()) {
                    com.bytedance.msdk.u.an.d(this.c, this.an, 4, 1, 0, rf.d());
                    return;
                }
                com.bytedance.msdk.u.an.d(this.c, this.an, 4, 0, 0, cb.an() ? rf.d() : null);
            }
            if (yi()) {
                return;
            }
            com.bytedance.msdk.core.admanager.reward.rewardagain.b bVar = this.v;
            if (bVar != null) {
                bVar.hc();
            }
            if (this.sy.d()) {
                this.sy.c();
                return;
            }
            com.bytedance.msdk.api.c.d.gb.d dVar2 = this.cb;
            if (dVar2 != null) {
                dVar2.d(d(this.an, dVar, this.c));
                d((com.bytedance.msdk.api.b.d) null, 0);
                return;
            }
            return;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.b bVar2 = this.v;
        if (bVar2 != null) {
            bVar2.hc();
        }
        if (this.sy.d()) {
            this.sy.c();
            return;
        }
        com.bytedance.msdk.api.c.d.gb.d dVar3 = this.cb;
        if (dVar3 != null) {
            dVar3.d(d(this.an, dVar, this.c));
            d((com.bytedance.msdk.api.b.d) null, 0);
        }
    }

    @Override // com.bytedance.msdk.api.c.d.gb.d
    public void an() {
        if (cb.d()) {
            if (this.c != null && "pangle".equals(this.c.nw())) {
                if (!cb.hc()) {
                    com.bytedance.msdk.u.an.d(this.c, this.an, 3, 1, 0, rf.d());
                    return;
                }
                com.bytedance.msdk.u.an.d(this.c, this.an, 3, 0, 0, (String) null);
            }
            if (yi()) {
                return;
            }
            he();
            if (this.sy.d()) {
                this.sy.hc();
            }
            com.bytedance.msdk.api.c.d.gb.d dVar = this.cb;
            if (dVar != null) {
                dVar.an();
                return;
            }
            return;
        }
        he();
        if (this.sy.d()) {
            this.sy.hc();
        }
        com.bytedance.msdk.api.c.d.gb.d dVar2 = this.cb;
        if (dVar2 != null) {
            dVar2.an();
        }
    }
}
