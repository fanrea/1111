package com.bytedance.pangle.res.d;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private int[] cb;
    private int e;
    private final gb gb;
    private boolean k;
    private int[] mq;
    private h tc;
    private final byte[] tt;
    private int w;
    HashMap<Integer, Integer> d = new HashMap<>();
    boolean hc = false;
    private boolean mk = false;
    private final d uo = new d();
    int b = 0;
    int c = 1;
    int u = 2;
    int an = 3;
    int h = 4;

    public hc(byte[] bArr, gb gbVar) {
        this.gb = gbVar;
        this.tt = bArr;
        c();
    }

    public void d(InputStream inputStream) {
        d();
        if (inputStream != null) {
            this.tc = new h(new tt(new u(inputStream)));
        }
    }

    public void d() {
        if (this.mk) {
            this.mk = false;
            this.tc = null;
            this.mq = null;
            this.uo.d();
            c();
        }
    }

    public int hc() throws IOException {
        if (this.tc == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            u();
            return this.e;
        } catch (IOException e) {
            d();
            throw e;
        }
    }

    public int b() throws IOException {
        return hc();
    }

    public void hc(InputStream inputStream) {
        d(inputStream);
    }

    private static final class d {
        private int b;
        private int[] d = new int[32];
        private int hc;

        public void d() {
            this.hc = 0;
            this.b = 0;
        }

        public int hc() {
            int i = this.hc;
            if (i == 0) {
                return 0;
            }
            return this.d[i - 1];
        }

        public void d(int i, int i2) {
            if (this.b == 0) {
                u();
            }
            d(2);
            int i3 = this.hc;
            int i4 = i3 - 1;
            int[] iArr = this.d;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.hc = i3 + 2;
        }

        public boolean b() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.hc;
            if (i3 == 0 || (i2 = (iArr = this.d)[i3 - 1]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.hc = i3 - 2;
            return true;
        }

        public int c() {
            return this.b;
        }

        public void u() {
            d(2);
            int i = this.hc;
            int[] iArr = this.d;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.hc = i + 2;
            this.b++;
        }

        public void an() {
            int i = this.hc;
            if (i == 0) {
                return;
            }
            int i2 = i - 1;
            int i3 = this.d[i2] * 2;
            if ((i2 - 1) - i3 == 0) {
                return;
            }
            this.hc = i - (i3 + 2);
            this.b--;
        }

        private void d(int i) {
            int[] iArr = this.d;
            int length = iArr.length;
            int i2 = this.hc;
            int i3 = length - i2;
            if (i3 > i) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.d = iArr2;
        }
    }

    private void c() {
        this.e = -1;
        this.cb = null;
        this.w = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e7, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0217, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r2 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void u() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.d.hc.u():void");
    }
}
