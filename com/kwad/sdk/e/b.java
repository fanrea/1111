package com.kwad.sdk.e;

import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements a {
    private static volatile b bPl;
    private static c bPm;

    private b() {
    }

    public static synchronized b aeR() {
        if (bPl == null) {
            synchronized (b.class) {
                if (bPl == null) {
                    bPl = new b();
                }
            }
        }
        return bPl;
    }

    public static void a(c cVar) {
        bPm = cVar;
    }

    @Override // com.kwad.sdk.e.a
    public final String aeF() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeF();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String getOaid() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.getOaid();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String aeG() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeG();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String aeH() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeH();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String aeI() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeI();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String aeJ() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeJ();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String aeK() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeK();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIccId() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.getIccId();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String aeL() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeL();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String aeM() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeM();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String aeN() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeN();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String getDeviceId() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.getDeviceId();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIp() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.getIp();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String aeO() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeO();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String getLocation() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.getLocation();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String aeP() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeP();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String aeQ() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.aeQ();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String getSdkVersion() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.getSdkVersion();
        }
        return aeS();
    }

    @Override // com.kwad.sdk.e.a
    public final String getAppId() {
        c cVar = bPm;
        if (cVar != null) {
            return cVar.getAppId();
        }
        return aeS();
    }

    private static String aeS() {
        return a(false, "", 2);
    }

    public static String a(boolean z, Object obj, int i) {
        HashMap map = new HashMap();
        map.put("userSet", String.valueOf(z));
        map.put(com.alipay.sdk.m.p0.b.d, obj);
        map.put("errorCode", String.valueOf(i));
        return new JSONObject(map).toString();
    }
}
