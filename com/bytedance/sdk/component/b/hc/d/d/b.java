package com.bytedance.sdk.component.b.hc.d.d;

import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.yo;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class b {
    public final he d;
    public final j hc;

    b(he heVar, j jVar) {
        this.d = heVar;
        this.hc = jVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.mq().c() == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(com.bytedance.sdk.component.b.hc.j r3, com.bytedance.sdk.component.b.hc.he r4) {
        /*
            int r0 = r3.b()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L59
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L59
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L59
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L59
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L59
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L59
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L59
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L59
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L59
            switch(r0) {
                case 300: goto L59;
                case 301: goto L59;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L58
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.d(r0)
            if (r0 != 0) goto L59
            com.bytedance.sdk.component.b.hc.c r0 = r3.mq()
            int r0 = r0.b()
            r1 = -1
            if (r0 != r1) goto L59
            com.bytedance.sdk.component.b.hc.c r0 = r3.mq()
            boolean r0 = r0.u()
            if (r0 != 0) goto L59
            com.bytedance.sdk.component.b.hc.c r0 = r3.mq()
            boolean r0 = r0.c()
            if (r0 != 0) goto L59
        L58:
            return r2
        L59:
            com.bytedance.sdk.component.b.hc.c r3 = r3.mq()
            boolean r3 = r3.hc()
            if (r3 != 0) goto L6f
            com.bytedance.sdk.component.b.hc.c r3 = r4.h()
            boolean r3 = r3.hc()
            if (r3 != 0) goto L6f
            r3 = 1
            return r3
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.d.d.b.d(com.bytedance.sdk.component.b.hc.j, com.bytedance.sdk.component.b.hc.he):boolean");
    }

    public static class d {
        private Date an;
        final j b;
        private Date c;
        final long d;
        private Date gb;
        private String h;
        final he hc;
        private String mk;
        private int mq;
        private long tc;
        private long tt;
        private String u;

        public d(long j, he heVar, j jVar) {
            this.mq = -1;
            this.d = j;
            this.hc = heVar;
            this.b = jVar;
            if (jVar != null) {
                this.tt = jVar.uo();
                this.tc = jVar.k();
                yo yoVarH = jVar.h();
                int iD = yoVarH.d();
                for (int i = 0; i < iD; i++) {
                    String strD = yoVarH.d(i);
                    String strHc = yoVarH.hc(i);
                    if ("Date".equalsIgnoreCase(strD)) {
                        this.c = com.bytedance.sdk.component.b.hc.d.b.c.d(strHc);
                        this.u = strHc;
                    } else if ("Expires".equalsIgnoreCase(strD)) {
                        this.gb = com.bytedance.sdk.component.b.hc.d.b.c.d(strHc);
                    } else if ("Last-Modified".equalsIgnoreCase(strD)) {
                        this.an = com.bytedance.sdk.component.b.hc.d.b.c.d(strHc);
                        this.h = strHc;
                    } else if ("ETag".equalsIgnoreCase(strD)) {
                        this.mk = strHc;
                    } else if ("Age".equalsIgnoreCase(strD)) {
                        this.mq = com.bytedance.sdk.component.b.hc.d.b.u.hc(strHc, -1);
                    }
                }
            }
        }

        public b d() {
            b bVarHc = hc();
            return (bVarHc.d == null || !this.hc.h().tt()) ? bVarHc : new b(null, null);
        }

        private b hc() {
            if (this.b == null) {
                return new b(this.hc, null);
            }
            if (this.hc.gb() && this.b.an() == null) {
                return new b(this.hc, null);
            }
            if (!b.d(this.b, this.hc)) {
                return new b(this.hc, null);
            }
            com.bytedance.sdk.component.b.hc.c cVarH = this.hc.h();
            if (cVarH.d() || d(this.hc)) {
                return new b(this.hc, null);
            }
            com.bytedance.sdk.component.b.hc.c cVarMq = this.b.mq();
            if (cVarMq.tc()) {
                return new b(null, this.b);
            }
            long jC = c();
            long jB = b();
            if (cVarH.b() != -1) {
                jB = Math.min(jB, TimeUnit.SECONDS.toMillis(cVarH.b()));
            }
            long millis = 0;
            long millis2 = cVarH.gb() != -1 ? TimeUnit.SECONDS.toMillis(cVarH.gb()) : 0L;
            if (!cVarMq.an() && cVarH.h() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cVarH.h());
            }
            if (!cVarMq.d()) {
                long j = millis2 + jC;
                if (j < millis + jB) {
                    j.d dVarTt = this.b.tt();
                    if (j >= jB) {
                        dVarTt.d("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jC > 86400000 && u()) {
                        dVarTt.d("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new b(null, dVarTt.d());
                }
            }
            String str = this.mk;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.an != null) {
                str = this.h;
            } else if (this.c != null) {
                str = this.u;
            } else {
                return new b(this.hc, null);
            }
            yo.d dVarHc = this.hc.b().hc();
            com.bytedance.sdk.component.b.hc.d.d.d.d(dVarHc, str2, str);
            return new b(this.hc.an().d(dVarHc.d()).d(), this.b);
        }

        private long b() {
            if (this.b.mq().b() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.b());
            }
            if (this.gb != null) {
                Date date = this.c;
                long time = this.gb.getTime() - (date != null ? date.getTime() : this.tc);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.an != null && this.b.d().d().query() == null) {
                Date date2 = this.c;
                long time2 = (date2 != null ? date2.getTime() : this.tt) - this.an.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private long c() {
            Date date = this.c;
            long jMax = date != null ? Math.max(0L, this.tc - date.getTime()) : 0L;
            if (this.mq != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.mq));
            }
            long j = this.tc;
            return jMax + (j - this.tt) + (this.d - j);
        }

        private boolean u() {
            return this.b.mq().b() == -1 && this.gb == null;
        }

        private static boolean d(he heVar) {
            return (heVar.d("If-Modified-Since") == null && heVar.d("If-None-Match") == null) ? false : true;
        }
    }
}
