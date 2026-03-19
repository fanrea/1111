package com.bytedance.pangle.h.d;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class d {
    private int an;
    private hc gb;
    private boolean h;
    private an mk;
    private int[] tt;
    private boolean tc = false;
    private final b mq = new b();
    int d = 0;
    int hc = 1;
    int b = 2;
    int c = 3;
    int u = 4;

    public d() {
        c();
    }

    public void d(InputStream inputStream) throws IOException {
        d();
        if (inputStream != null) {
            this.gb = new hc(inputStream);
        }
    }

    public void d() throws IOException {
        if (this.tc) {
            this.tc = false;
            this.gb.d();
            this.mk = null;
            this.gb = null;
            this.mq.d();
            c();
        }
    }

    public int hc() throws IOException {
        try {
            if (this.gb != null) {
                u();
                return this.an;
            }
            throw new IOException("Parser is not opened.");
        } catch (IOException e) {
            d();
            throw e;
        }
    }

    public int b() {
        if (this.an != 2) {
            return -1;
        }
        return this.tt.length / 5;
    }

    public String d(int i) {
        int i2 = this.tt[u(i) + 1];
        return i2 == -1 ? "" : this.mk.d(i2);
    }

    public int hc(int i) {
        return this.tt[u(i) + 3];
    }

    public int b(int i) {
        return this.tt[u(i) + 4];
    }

    public String c(int i) {
        int iU = u(i);
        int[] iArr = this.tt;
        if (iArr[iU + 3] != 3) {
            return "";
        }
        return this.mk.d(iArr[iU + 2]);
    }

    private int u(int i) {
        if (this.an != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.tt.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    private void c() {
        this.tt = null;
        this.an = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x016f, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r2 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void u() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.h.d.d.u():void");
    }
}
