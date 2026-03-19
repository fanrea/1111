package com.bytedance.sdk.component.b.hc.d.b;

import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.rf;
import java.net.Proxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class tt {
    public static String d(he heVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(heVar.hc());
        sb.append(' ');
        if (hc(heVar, type)) {
            sb.append(heVar.d());
        } else {
            sb.append(d(heVar.d()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean hc(he heVar, Proxy.Type type) {
        return !heVar.gb() && type == Proxy.Type.HTTP;
    }

    public static String d(rf rfVar) {
        String strTt = rfVar.tt();
        try {
            String strMk = rfVar.mk();
            if (strMk != null) {
                return strTt + '?' + strMk;
            }
        } catch (OutOfMemoryError unused) {
        }
        return strTt;
    }
}
