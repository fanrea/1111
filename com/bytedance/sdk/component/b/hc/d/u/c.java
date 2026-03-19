package com.bytedance.sdk.component.b.hc.d.u;

import com.alipay.sdk.m.l.a;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.component.b.d.rf;
import com.bytedance.sdk.djx.core.util.FeedSurveyManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class c {
    static final b[] d = {new b(b.an, ""), new b(b.b, "GET"), new b(b.b, "POST"), new b(b.c, "/"), new b(b.c, "/index.html"), new b(b.u, a.r), new b(b.u, "https"), new b(b.hc, "200"), new b(b.hc, "204"), new b(b.hc, "206"), new b(b.hc, "304"), new b(b.hc, "400"), new b(b.hc, "404"), new b(b.hc, "500"), new b("accept-charset", ""), new b("accept-encoding", "gzip, deflate"), new b("accept-language", ""), new b("accept-ranges", ""), new b("accept", ""), new b("access-control-allow-origin", ""), new b(FeedSurveyManager.KEY_AGE, ""), new b("allow", ""), new b("authorization", ""), new b("cache-control", ""), new b("content-disposition", ""), new b("content-encoding", ""), new b("content-language", ""), new b("content-length", ""), new b("content-location", ""), new b("content-range", ""), new b(com.alipay.sdk.m.p.e.f, ""), new b("cookie", ""), new b("date", ""), new b("etag", ""), new b("expect", ""), new b("expires", ""), new b("from", ""), new b("host", ""), new b("if-match", ""), new b("if-modified-since", ""), new b("if-none-match", ""), new b("if-range", ""), new b("if-unmodified-since", ""), new b("last-modified", ""), new b("link", ""), new b("location", ""), new b("max-forwards", ""), new b("proxy-authenticate", ""), new b("proxy-authorization", ""), new b("range", ""), new b(Config.LAUNCH_REFERER, ""), new b("refresh", ""), new b("retry-after", ""), new b("server", ""), new b("set-cookie", ""), new b("strict-transport-security", ""), new b("transfer-encoding", ""), new b("user-agent", ""), new b("vary", ""), new b("via", ""), new b("www-authenticate", "")};
    static final Map<com.bytedance.sdk.component.b.d.an, Integer> hc = d();

    static final class d {
        private final com.bytedance.sdk.component.b.d.u an;
        int b;
        int c;
        b[] d;
        private int gb;
        private final int h;
        int hc;
        private final List<b> u;

        d(int i, rf rfVar) {
            this(i, i, rfVar);
        }

        d(int i, int i2, rf rfVar) {
            this.u = new ArrayList();
            this.d = new b[8];
            this.hc = r0.length - 1;
            this.b = 0;
            this.c = 0;
            this.h = i;
            this.gb = i2;
            this.an = com.bytedance.sdk.component.b.d.mq.d(rfVar);
        }

        private void c() {
            int i = this.gb;
            int i2 = this.c;
            if (i < i2) {
                if (i == 0) {
                    u();
                } else {
                    d(i2 - i);
                }
            }
        }

        private void u() {
            Arrays.fill(this.d, (Object) null);
            this.hc = this.d.length - 1;
            this.b = 0;
            this.c = 0;
        }

        private int d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.d.length;
                while (true) {
                    length--;
                    i2 = this.hc;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.d[length].tt;
                    this.c -= this.d[length].tt;
                    this.b--;
                    i3++;
                }
                b[] bVarArr = this.d;
                System.arraycopy(bVarArr, i2 + 1, bVarArr, i2 + 1 + i3, this.b);
                this.hc += i3;
            }
            return i3;
        }

        void d() throws IOException {
            while (!this.an.u()) {
                int iGb = this.an.gb() & 255;
                if (iGb == 128) {
                    throw new IOException("index == 0");
                }
                if ((iGb & 128) == 128) {
                    hc(d(iGb, 127) - 1);
                } else if (iGb == 64) {
                    h();
                } else if ((iGb & 64) == 64) {
                    u(d(iGb, 63) - 1);
                } else if ((iGb & 32) == 32) {
                    int iD = d(iGb, 31);
                    this.gb = iD;
                    if (iD < 0 || iD > this.h) {
                        throw new IOException("Invalid dynamic table size update " + this.gb);
                    }
                    c();
                } else if (iGb == 16 || iGb == 0) {
                    an();
                } else {
                    c(d(iGb, 15) - 1);
                }
            }
        }

        public List<b> hc() {
            ArrayList arrayList = new ArrayList(this.u);
            this.u.clear();
            return arrayList;
        }

        private void hc(int i) throws IOException {
            if (h(i)) {
                this.u.add(c.d[i]);
                return;
            }
            int iB = b(i - c.d.length);
            if (iB >= 0) {
                b[] bVarArr = this.d;
                if (iB <= bVarArr.length - 1) {
                    this.u.add(bVarArr[iB]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int b(int i) {
            return this.hc + 1 + i;
        }

        private void c(int i) throws IOException {
            this.u.add(new b(an(i), b()));
        }

        private void an() throws IOException {
            this.u.add(new b(c.d(b()), b()));
        }

        private void u(int i) throws IOException {
            d(-1, new b(an(i), b()));
        }

        private void h() throws IOException {
            d(-1, new b(c.d(b()), b()));
        }

        private com.bytedance.sdk.component.b.d.an an(int i) {
            if (h(i)) {
                return c.d[i].h;
            }
            return this.d[b(i - c.d.length)].h;
        }

        private boolean h(int i) {
            return i >= 0 && i <= c.d.length - 1;
        }

        private void d(int i, b bVar) {
            this.u.add(bVar);
            int i2 = bVar.tt;
            if (i != -1) {
                i2 -= this.d[b(i)].tt;
            }
            int i3 = this.gb;
            if (i2 > i3) {
                u();
                return;
            }
            int iD = d((this.c + i2) - i3);
            if (i == -1) {
                int i4 = this.b + 1;
                b[] bVarArr = this.d;
                if (i4 > bVarArr.length) {
                    b[] bVarArr2 = new b[bVarArr.length * 2];
                    System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                    this.hc = this.d.length - 1;
                    this.d = bVarArr2;
                }
                int i5 = this.hc;
                this.hc = i5 - 1;
                this.d[i5] = bVar;
                this.b++;
            } else {
                this.d[i + b(i) + iD] = bVar;
            }
            this.c += i2;
        }

        private int gb() throws IOException {
            return this.an.gb() & 255;
        }

        int d(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iGb = gb();
                if ((iGb & 128) == 0) {
                    return i2 + (iGb << i4);
                }
                i2 += (iGb & 127) << i4;
                i4 += 7;
            }
        }

        com.bytedance.sdk.component.b.d.an b() throws IOException {
            int iGb = gb();
            boolean z = (iGb & 128) == 128;
            int iD = d(iGb, 127);
            if (z) {
                return com.bytedance.sdk.component.b.d.an.d(mk.d().d(this.an.h(iD)));
            }
            return this.an.b(iD);
        }
    }

    private static Map<com.bytedance.sdk.component.b.d.an, Integer> d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.length);
        int i = 0;
        while (true) {
            b[] bVarArr = d;
            if (i < bVarArr.length) {
                if (!linkedHashMap.containsKey(bVarArr[i].h)) {
                    linkedHashMap.put(bVarArr[i].h, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static final class hc {
        int an;
        b[] b;
        int c;
        int d;
        private final boolean gb;
        private final com.bytedance.sdk.component.b.d.b h;
        int hc;
        private boolean tc;
        private int tt;
        int u;

        hc(com.bytedance.sdk.component.b.d.b bVar) {
            this(4096, true, bVar);
        }

        hc(int i, boolean z, com.bytedance.sdk.component.b.d.b bVar) {
            this.tt = Integer.MAX_VALUE;
            this.b = new b[8];
            this.c = r0.length - 1;
            this.u = 0;
            this.an = 0;
            this.d = i;
            this.hc = i;
            this.gb = z;
            this.h = bVar;
        }

        private void d() {
            Arrays.fill(this.b, (Object) null);
            this.c = this.b.length - 1;
            this.u = 0;
            this.an = 0;
        }

        private int hc(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.b.length;
                while (true) {
                    length--;
                    i2 = this.c;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.b[length].tt;
                    this.an -= this.b[length].tt;
                    this.u--;
                    i3++;
                }
                b[] bVarArr = this.b;
                System.arraycopy(bVarArr, i2 + 1, bVarArr, i2 + 1 + i3, this.u);
                b[] bVarArr2 = this.b;
                int i4 = this.c;
                Arrays.fill(bVarArr2, i4 + 1, i4 + 1 + i3, (Object) null);
                this.c += i3;
            }
            return i3;
        }

        private void d(b bVar) {
            int i = bVar.tt;
            int i2 = this.hc;
            if (i > i2) {
                d();
                return;
            }
            hc((this.an + i) - i2);
            int i3 = this.u + 1;
            b[] bVarArr = this.b;
            if (i3 > bVarArr.length) {
                b[] bVarArr2 = new b[bVarArr.length * 2];
                System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                this.c = this.b.length - 1;
                this.b = bVarArr2;
            }
            int i4 = this.c;
            this.c = i4 - 1;
            this.b[i4] = bVar;
            this.u++;
            this.an += i;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void d(java.util.List<com.bytedance.sdk.component.b.hc.d.u.b> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 237
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.d.u.c.hc.d(java.util.List):void");
        }

        void d(int i, int i2, int i3) {
            if (i < i2) {
                this.h.tt(i | i3);
                return;
            }
            this.h.tt(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.h.tt(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.h.tt(i4);
        }

        void d(com.bytedance.sdk.component.b.d.an anVar) throws IOException {
            if (this.gb && mk.d().d(anVar) < anVar.h()) {
                com.bytedance.sdk.component.b.d.b bVar = new com.bytedance.sdk.component.b.d.b();
                mk.d().d(anVar, bVar);
                com.bytedance.sdk.component.b.d.an anVarK = bVar.k();
                d(anVarK.h(), 127, 128);
                this.h.hc(anVarK);
                return;
            }
            d(anVar.h(), 127, 0);
            this.h.hc(anVar);
        }

        void d(int i) {
            this.d = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.hc;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.tt = Math.min(this.tt, iMin);
            }
            this.tc = true;
            this.hc = iMin;
            hc();
        }

        private void hc() {
            int i = this.hc;
            int i2 = this.an;
            if (i < i2) {
                if (i == 0) {
                    d();
                } else {
                    hc(i2 - i);
                }
            }
        }
    }

    static com.bytedance.sdk.component.b.d.an d(com.bytedance.sdk.component.b.d.an anVar) throws IOException {
        int iH = anVar.h();
        for (int i = 0; i < iH; i++) {
            byte bD = anVar.d(i);
            if (bD >= 65 && bD <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + anVar.d());
            }
        }
        return anVar;
    }
}
