package com.qq.e.comm.plugin;

import java.io.IOException;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class o9 extends l9 {
    private final long e;
    private final int f;
    private final String g;
    private final m9 h;
    private final byte[] i;
    private int j;
    private int k;
    private List<kv> l;
    private List<kv> m;
    private List<kv> n;

    public String toString() {
        return String.format(Locale.getDefault(), "{messageId:%d, rd:%d, ra:%d, aa:%d, rCode:%d, server:%s, request:%s, answerArray:%s, authorityArray:%s, additionalArray:%s}", Short.valueOf(this.a), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.j), Integer.valueOf(this.k), this.g, this.h, this.l, this.m, this.n);
    }

    o9(String str, int i, m9 m9Var, byte[] bArr) throws IOException {
        if (bArr != null && bArr.length != 0) {
            this.g = str;
            this.f = i;
            this.h = m9Var;
            this.i = bArr;
            this.e = new Date().getTime() / 1000;
            b();
            return;
        }
        throw new IOException("response data is empty");
    }

    private void b() throws IOException {
        if (this.i.length >= 12) {
            c();
            int iD = d();
            c cVar = new c("answer", b(6), iD);
            a(cVar);
            this.l = cVar.e;
            int i = iD + cVar.d;
            c cVar2 = new c("authority", b(8), i);
            a(cVar2);
            this.m = cVar2.e;
            String str = "additional";
            c cVar3 = new c(str, b(10), i + cVar2.d);
            a(cVar3);
            this.n = cVar3.e;
            return;
        }
        throw new IOException("response data too small");
    }

    private void c() throws IOException {
        short sB = b(0);
        this.a = sB;
        if (sB == this.h.a) {
            int iD = d(2);
            if ((d(2) & 128) != 0) {
                this.b = (iD >> 3) & 7;
                this.j = (iD >> 2) & 1;
                this.c = iD & 1;
                int iD2 = d(3);
                this.d = (iD2 >> 7) & 1;
                this.k = iD2 & 15;
                return;
            }
            throw new IOException("not a response data");
        }
        throw new IOException("question id error");
    }

    private int d() throws IOException {
        int i = 12;
        for (int iB = b(4); iB > 0; iB--) {
            b bVarA = a(i);
            if (bVarA == null) {
                throw new IOException("read Question error");
            }
            i += bVarA.a + 4;
        }
        return i;
    }

    List<kv> a() {
        return this.l;
    }

    /* compiled from: A */
    private static class c {
        private final String a;
        private final int b;
        private final int c;
        private int d;
        private final List<kv> e;

        private c(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = 0;
            this.e = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(kv kvVar) {
            if (kvVar != null) {
                this.e.add(kvVar);
            }
        }
    }

    private short b(int i) throws IOException {
        int i2 = i + 1;
        byte[] bArr = this.i;
        if (i2 < bArr.length) {
            return (short) (((bArr[i] & 255) << 8) + (bArr[i2] & 255));
        }
        throw new IOException("read response data out of range");
    }

    /* compiled from: A */
    private static class b {
        private int a;
        private String b;

        private b() {
        }
    }

    private int d(int i) throws IOException {
        byte[] bArr = this.i;
        if (i < bArr.length) {
            return bArr[i] & 255;
        }
        throw new IOException("read response data out of range");
    }

    private int c(int i) throws IOException {
        int i2 = i + 3;
        byte[] bArr = this.i;
        if (i2 < bArr.length) {
            int i3 = (bArr[i] & 255) << 24;
            int i4 = (bArr[i + 1] & 255) << 16;
            return i3 + i4 + ((bArr[i + 2] & 255) << 8) + (bArr[i2] & 255);
        }
        throw new IOException("read response data out of range");
    }

    private void a(c cVar) throws IOException {
        int i = cVar.c;
        for (int i2 = cVar.b; i2 > 0; i2--) {
            b bVarA = a(i);
            if (bVarA == null) {
                throw new IOException("read " + cVar.a + " error");
            }
            int i3 = i + bVarA.a;
            short sB = b(i3);
            short sB2 = b(i3 + 2);
            int iC = c(i3 + 4);
            short sB3 = b(i3 + 8);
            int i4 = i3 + 10;
            String strA = a(sB, i4, sB3);
            if (sB2 == 1 && (sB == 5 || sB == this.h.a())) {
                cVar.a(new kv(strA, sB, iC, this.e, this.f, this.g));
            }
            i = i4 + sB3;
        }
        cVar.d = i - cVar.c;
    }

    private String a(int i, int i2, int i3) throws IOException {
        if (i != 1) {
            if (i != 5) {
                if (i != 16) {
                    if (i == 28 && i3 == 16) {
                        StringBuilder sb = new StringBuilder();
                        int i4 = 0;
                        while (i4 < 16) {
                            sb.append(i4 > 0 ? ":" : "");
                            int i5 = i2 + i4;
                            sb.append(d(i5));
                            sb.append(d(i5 + 1));
                            i4 += 2;
                        }
                        return sb.toString();
                    }
                } else if (i3 > 0) {
                    int i6 = i3 + i2;
                    byte[] bArr = this.i;
                    if (i6 < bArr.length) {
                        return IDN.toUnicode(new String(Arrays.copyOfRange(bArr, i2, i6)));
                    }
                }
            } else if (i3 > 1) {
                return a(i2).b;
            }
        } else if (i3 == 4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(d(i2));
            for (int i7 = 1; i7 < 4; i7++) {
                sb2.append(".");
                sb2.append(d(i2 + i7));
            }
            return sb2.toString();
        }
        return null;
    }

    private b a(int i) throws IOException {
        StringBuilder sb = new StringBuilder();
        b bVar = new b();
        int i2 = 128;
        int iD = i;
        do {
            int iD2 = d(iD);
            int i3 = iD2 & 192;
            if (i3 == 192) {
                if (bVar.a < 1) {
                    bVar.a = (iD + 2) - i;
                }
                iD = d(iD + 1) | ((iD2 & 63) << 8);
            } else {
                if (i3 > 0) {
                    return null;
                }
                iD++;
                if (iD2 > 0) {
                    if (sb.length() > 0) {
                        sb.append(".");
                    }
                    int i4 = iD + iD2;
                    sb.append(IDN.toUnicode(new String(Arrays.copyOfRange(this.i, iD, i4))));
                    iD = i4;
                }
            }
            if (iD2 <= 0) {
                break;
            }
            i2--;
        } while (i2 > 0);
        bVar.b = sb.toString();
        if (bVar.a < 1) {
            bVar.a = iD - i;
        }
        return bVar;
    }
}
