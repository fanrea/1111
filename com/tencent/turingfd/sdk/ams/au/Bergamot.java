package com.tencent.turingfd.sdk.ams.au;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Bergamot extends Equuleus {
    public static byte[] m = null;
    public static Map<String, String> n = null;
    public static final /* synthetic */ boolean o = true;
    public byte[] g;
    public Map<String, String> i;
    public Map<String, String> j;
    public short a = 0;
    public byte b = 0;
    public int c = 0;
    public int d = 0;
    public String e = null;
    public String f = null;
    public int h = 0;

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Eridanus eridanus) throws UnsupportedEncodingException {
        eridanus.a(this.a, 1);
        eridanus.a(this.b, 2);
        eridanus.a(this.c, 3);
        eridanus.a(this.d, 4);
        eridanus.a(this.e, 5);
        eridanus.a(this.f, 6);
        eridanus.a(this.g, 7);
        eridanus.a(this.h, 8);
        eridanus.a((Map) this.i, 9);
        eridanus.a((Map) this.j, 10);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        Bergamot bergamot = (Bergamot) obj;
        Integer num = 1;
        return GalacticCore.a(1, (int) bergamot.a) && GalacticCore.a(1, (int) bergamot.b) && GalacticCore.a(1, bergamot.c) && GalacticCore.a(1, bergamot.d) && num.equals(bergamot.e) && num.equals(bergamot.f) && num.equals(bergamot.g) && GalacticCore.a(1, bergamot.h) && num.equals(bergamot.i) && num.equals(bergamot.j);
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Draco draco) {
        String str;
        try {
            this.a = draco.a(this.a, 1, true);
            this.b = draco.a(this.b, 2, true);
            this.c = draco.a(this.c, 3, true);
            this.d = draco.a(this.d, 4, true);
            this.e = draco.b(5, true);
            this.f = draco.b(6, true);
            if (m == null) {
                m = new byte[]{0};
            }
            this.g = draco.a(7, true);
            this.h = draco.a(this.h, 8, true);
            if (n == null) {
                HashMap map = new HashMap();
                n = map;
                map.put("", "");
            }
            this.i = (Map) draco.a((Draco) n, 9, true);
            if (n == null) {
                HashMap map2 = new HashMap();
                n = map2;
                map2.put("", "");
            }
            this.j = (Map) draco.a((Draco) n, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder sbA = Bennet.a("RequestPacket decode error ");
            byte[] bArr = this.g;
            if (bArr == null || bArr.length == 0) {
                str = null;
            } else {
                char[] cArr = new char[bArr.length * 2];
                for (int i = 0; i < bArr.length; i++) {
                    byte b = bArr[i];
                    int i2 = i * 2;
                    char[] cArr2 = Papaya.a;
                    cArr[i2 + 1] = cArr2[b & 15];
                    cArr[i2] = cArr2[((byte) (b >>> 4)) & 15];
                }
                str = new String(cArr);
            }
            sbA.append(str);
            printStream.println(sbA.toString());
            throw new RuntimeException(e);
        }
    }
}
