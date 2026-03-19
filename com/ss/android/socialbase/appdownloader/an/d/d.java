package com.ss.android.socialbase.appdownloader.an.d;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class d implements tt {
    private an c;
    private int e;
    private int gb;
    private boolean h;
    private c hc;
    private int k;
    private int mk;
    private int[] mq;
    private int tc;
    private int tt;
    private int[] u;
    private int uo;
    private boolean b = false;
    private C0764d an = new C0764d();

    @Override // com.ss.android.socialbase.appdownloader.an.d.h
    public int an() {
        return -1;
    }

    public d() {
        h();
    }

    public void d(InputStream inputStream) throws IOException {
        d();
        if (inputStream != null) {
            this.hc = new c(inputStream, false);
        }
    }

    public void d() throws IOException {
        if (this.b) {
            this.b = false;
            this.hc.d();
            this.hc = null;
            this.c = null;
            this.u = null;
            this.an.d();
            h();
        }
    }

    public int hc() throws gb, IOException {
        if (this.hc == null) {
            throw new gb("Parser is not opened.", this, null);
        }
        try {
            gb();
            return this.gb;
        } catch (IOException e) {
            d();
            throw e;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.an.d.h
    public int b() {
        return this.tt;
    }

    @Override // com.ss.android.socialbase.appdownloader.an.d.h
    public String c() {
        return "XML line #" + b();
    }

    public int u() {
        if (this.gb != 2) {
            return -1;
        }
        return this.mq.length / 5;
    }

    public String d(int i) {
        int i2 = this.mq[u(i) + 1];
        return i2 == -1 ? "" : this.c.d(i2);
    }

    public int hc(int i) {
        return this.mq[u(i) + 3];
    }

    public int b(int i) {
        return this.mq[u(i) + 4];
    }

    public String c(int i) {
        int iU = u(i);
        int[] iArr = this.mq;
        if (iArr[iU + 3] != 3) {
            return "";
        }
        return this.c.d(iArr[iU + 2]);
    }

    private final int u(int i) {
        if (this.gb != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.mq.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    private final void h() {
        this.gb = -1;
        this.tt = -1;
        this.tc = -1;
        this.mk = -1;
        this.mq = null;
        this.uo = -1;
        this.k = -1;
        this.e = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0184, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void gb() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.an.d.d.gb():void");
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.an.d.d$d, reason: collision with other inner class name */
    private static final class C0764d {
        private int b;
        private int[] d = new int[32];
        private int hc;

        public final void d() {
            this.hc = 0;
            this.b = 0;
        }

        public final int hc() {
            int i = this.hc;
            if (i == 0) {
                return 0;
            }
            return this.d[i - 1];
        }

        public final void d(int i, int i2) {
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

        public final boolean b() {
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

        public final int c() {
            return this.b;
        }

        public final void u() {
            d(2);
            int i = this.hc;
            int[] iArr = this.d;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.hc = i + 2;
            this.b++;
        }

        public final void an() {
            int i = this.hc;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.d[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.hc = i - (i3 + 2);
                    this.b--;
                }
            }
        }

        private void d(int i) {
            int[] iArr = this.d;
            int length = iArr.length;
            int i2 = this.hc;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.d = iArr2;
            }
        }
    }
}
