package com.tencent.gatherer.core.internal.util.dex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c {
    private ByteBuffer a;

    public c(ByteBuffer byteBuffer) {
        com.tencent.gatherer.core.internal.util.d.a("buffer:" + byteBuffer.toString());
        this.a = byteBuffer;
        byteBuffer.position(0);
        this.a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private String a(int i) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            short sA = a.a(this.a);
            if ((sA & 128) == 0) {
                cArr[i2] = (char) sA;
            } else if ((sA & 224) == 192) {
                cArr[i2] = (char) (((sA & 31) << 6) | (a.a(this.a) & 63));
            } else if ((sA & 240) == 224) {
                cArr[i2] = (char) (((sA & 15) << 12) | ((a.a(this.a) & 63) << 6) | (a.a(this.a) & 63));
            }
            char c = cArr[i2];
        }
        return new String(cArr);
    }

    private b b() {
        this.a.getInt();
        a.b(this.a, 20);
        b bVar = new b();
        bVar.d(a.b(this.a));
        bVar.e(a.b(this.a));
        a.b(this.a);
        bVar.g(a.b(this.a));
        bVar.f(a.b(this.a));
        bVar.h(a.b(this.a));
        bVar.f(this.a.getInt());
        bVar.k(a.b(this.a));
        bVar.g(this.a.getInt());
        bVar.l(a.b(this.a));
        bVar.e(this.a.getInt());
        bVar.j(a.b(this.a));
        bVar.c(this.a.getInt());
        bVar.c(a.b(this.a));
        bVar.d(this.a.getInt());
        bVar.i(a.b(this.a));
        bVar.a(this.a.getInt());
        bVar.a(a.b(this.a));
        bVar.b(this.a.getInt());
        bVar.b(a.b(this.a));
        a.a(this.a, bVar.a());
        return bVar;
    }

    private String c() {
        return a(d());
    }

    private int d() {
        short sA;
        int i = 0;
        int i2 = 0;
        do {
            if (i > 4) {
                com.tencent.gatherer.core.internal.util.d.a("readVarInts count error!");
            }
            sA = a.a(this.a);
            i2 |= (sA & 127) << (i * 7);
            i++;
        } while ((sA & 128) != 0);
        return i2;
    }

    public String a() {
        String str = new String(a.b(this.a, 8));
        if (!str.startsWith("dex\n")) {
            com.tencent.gatherer.core.internal.util.d.a("dex magic error");
            return "";
        }
        if (Integer.parseInt(str.substring(4, 7)) < 35) {
            com.tencent.gatherer.core.internal.util.d.a("dex version error");
        }
        b bVarB = b();
        long jB = bVarB.b();
        long jC = bVarB.c();
        if (jC > 50000) {
            jC = 50000;
        }
        com.tencent.gatherer.core.internal.util.d.b("stringIdsOff: " + jB + ", size:" + jC);
        for (int i = 0; i < jC; i++) {
            a.a(this.a, (i * 4) + jB);
            a.a(this.a, a.b(this.a));
            String strC = c();
            if (a(strC)) {
                com.tencent.gatherer.core.internal.util.d.b("check true: " + strC);
                return strC;
            }
        }
        com.tencent.gatherer.core.internal.util.d.b("not found chrome version");
        return "";
    }

    public static boolean a(String str) {
        return a(str.getBytes());
    }

    public static boolean a(byte[] bArr) {
        if (bArr.length < 5 || bArr[0] < 53) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (byte b : bArr) {
            if (b < 48 && b != 46) {
                return false;
            }
            if (b > 57 && b != 46) {
                return false;
            }
            if (i == 2 && b != 46) {
                i3++;
            }
            if (b == 46) {
                i++;
            }
            if (i == 0) {
                i2 = (i2 * 10) + (b - 48);
            }
        }
        return i >= 3 && i2 >= 50 && i3 == 4;
    }
}
