package com.alipay.sdk.m.n0;

import android.content.Context;
import java.util.zip.Adler32;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c {
    public static b a;
    public static final Object b = new Object();

    public static synchronized b b(Context context) {
        b bVar = a;
        if (bVar != null) {
            return bVar;
        }
        if (context == null) {
            return null;
        }
        b bVarA = a(context);
        a = bVarA;
        return bVarA;
    }

    public static long a(b bVar) {
        if (bVar == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", bVar.c(), bVar.d(), Long.valueOf(bVar.a()), bVar.e(), bVar.b());
        if (com.alipay.sdk.m.l0.f.m293a(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    public static b a(Context context) {
        if (context == null) {
            return null;
        }
        synchronized (b) {
            String strB = d.a(context).b();
            if (com.alipay.sdk.m.l0.f.m293a(strB)) {
                return null;
            }
            if (strB.endsWith("\n")) {
                strB = strB.substring(0, strB.length() - 1);
            }
            b bVar = new b();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strA = com.alipay.sdk.m.l0.d.a(context);
            String strB2 = com.alipay.sdk.m.l0.d.b(context);
            bVar.c(strA);
            bVar.a(strA);
            bVar.b(jCurrentTimeMillis);
            bVar.b(strB2);
            bVar.d(strB);
            bVar.a(a(bVar));
            return bVar;
        }
    }
}
