package com.bytedance.msdk.b.an.hc;

import android.text.TextUtils;
import com.bytedance.msdk.core.tc.gb;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.an;
import com.bytedance.msdk.hc.b;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements d {
    private int an;
    private String b;
    private String c;
    private tc d;
    private long gb = -1;
    private boolean h;
    private com.bytedance.msdk.b.hc.hc.d hc;
    private int tt;
    private int u;

    private hc() {
    }

    public static hc d(tc tcVar, com.bytedance.msdk.b.hc.hc.d dVar) {
        hc hcVar = new hc();
        hcVar.d = tcVar;
        hcVar.hc = dVar;
        return hcVar;
    }

    public int b() {
        return this.tt;
    }

    public void d(int i) {
        this.tt = i;
    }

    public long c() {
        return this.gb;
    }

    public void d(long j) {
        this.gb = j;
    }

    public boolean u() {
        return this.h;
    }

    public void d(boolean z) {
        this.h = z;
    }

    public int an() {
        return this.an;
    }

    public void hc(int i) {
        this.an = i;
    }

    public int h() {
        return this.u;
    }

    public void b(int i) {
        this.u = i;
    }

    public tc gb() {
        return this.d;
    }

    public void d(final List<b> list, final tc tcVar) {
        an.d(new Runnable() { // from class: com.bytedance.msdk.b.an.hc.hc.1
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.hc != null) {
                    hc.this.hc.d(list, tcVar);
                }
            }
        });
    }

    public void d(final com.bytedance.msdk.api.d dVar, final tc tcVar) {
        an.d(new Runnable() { // from class: com.bytedance.msdk.b.an.hc.hc.2
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.hc != null) {
                    hc.this.hc.d(dVar, tcVar);
                }
            }
        });
    }

    public void tt() {
        an.d(new Runnable() { // from class: com.bytedance.msdk.b.an.hc.hc.3
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.hc != null) {
                    hc.this.hc.d();
                }
            }
        });
    }

    public boolean tc() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.hv();
        }
        return false;
    }

    public boolean mk() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return TextUtils.equals(tcVar.e(), "pangle");
        }
        return false;
    }

    public String mq() {
        tc tcVar = this.d;
        return tcVar != null ? tcVar.yo() : "";
    }

    public String uo() {
        tc tcVar = this.d;
        return tcVar != null ? tcVar.e() : "";
    }

    public int k() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.tc();
        }
        return 0;
    }

    public int e() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.an();
        }
        return 0;
    }

    public String cb() {
        tc tcVar = this.d;
        return tcVar != null ? tcVar.he() : "";
    }

    public void d(String str) {
        this.b = str;
    }

    public String w() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00db A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String yo() {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.an.hc.hc.yo():java.lang.String");
    }

    public int rf() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.rf();
        }
        return 0;
    }

    public int jh() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.np();
        }
        return 0;
    }

    public int sy() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.yi();
        }
        return 0;
    }

    public String de() {
        tc tcVar = this.d;
        return tcVar != null ? tcVar.e() : "";
    }

    @Override // com.bytedance.msdk.b.an.hc.d
    public boolean d() {
        tc tcVar = this.d;
        return tcVar != null && tcVar.rf() == 1;
    }

    public boolean v() {
        tc tcVar = this.d;
        return tcVar != null && tcVar.rf() == 2;
    }

    public boolean np() {
        tc tcVar = this.d;
        return tcVar != null && tcVar.rf() == 3;
    }

    public String yi() {
        return (v() && us() != null) ? us().tc() : "";
    }

    public void hc(String str) {
        this.c = str;
    }

    @Override // com.bytedance.msdk.b.an.hc.d
    public String hc() {
        return this.c;
    }

    public int he() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.uo();
        }
        return 0;
    }

    public int vv() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.d();
        }
        return 0;
    }

    public double zw() {
        tc tcVar;
        if (v() || d() || np() || (tcVar = this.d) == null) {
            return 0.0d;
        }
        return tcVar.v();
    }

    public double j() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.sy();
        }
        return 0.0d;
    }

    public double s() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.de();
        }
        return 0.0d;
    }

    public gb us() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.zw();
        }
        return null;
    }

    public String z() {
        tc tcVar = this.d;
        return tcVar != null ? tcVar.k() : "";
    }

    public int fs() {
        tc tcVar = this.d;
        if (tcVar != null) {
            return tcVar.tt();
        }
        return 0;
    }

    public String ba() {
        tc tcVar = this.d;
        return tcVar != null ? tcVar.r() : "";
    }

    public Object mt() {
        if (v() && us() != null) {
            return us().hc();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0045 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int r() {
        /*
            r7 = this;
            com.bytedance.msdk.core.tc.tc r0 = r7.d
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r0.an()
            com.bytedance.msdk.core.tc.tc r2 = r7.d
            int r2 = r2.uo()
            r3 = 20002(0x4e22, float:2.8029E-41)
            r4 = 20004(0x4e24, float:2.8032E-41)
            r5 = 20001(0x4e21, float:2.8027E-41)
            r6 = 20003(0x4e23, float:2.803E-41)
            switch(r2) {
                case 1: goto L44;
                case 2: goto L43;
                case 3: goto L40;
                case 4: goto L1b;
                case 5: goto L31;
                case 6: goto L1b;
                case 7: goto L26;
                case 8: goto L25;
                case 9: goto L24;
                case 10: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L45
        L1c:
            r2 = 1
            if (r0 != r2) goto L20
            return r4
        L20:
            r2 = 2
            if (r0 != r2) goto L45
            return r6
        L24:
            return r3
        L25:
            return r6
        L26:
            r1 = 6
            r2 = 20006(0x4e26, float:2.8034E-41)
            if (r0 != r1) goto L2c
            return r2
        L2c:
            r1 = 7
            if (r0 != r1) goto L30
            return r6
        L30:
            return r2
        L31:
            r1 = 4
            r2 = 20005(0x4e25, float:2.8033E-41)
            if (r0 != r1) goto L37
            return r2
        L37:
            r1 = 5
            if (r0 != r1) goto L3b
            return r3
        L3b:
            r1 = 3
            if (r0 != r1) goto L3f
            return r5
        L3f:
            return r2
        L40:
            r0 = 20007(0x4e27, float:2.8036E-41)
            return r0
        L43:
            return r4
        L44:
            return r5
        L45:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.an.hc.hc.r():int");
    }
}
