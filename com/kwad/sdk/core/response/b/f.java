package com.kwad.sdk.core.response.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f {
    private static volatile f bGT;
    private String bGU = abN();

    private f() {
    }

    public static f abL() {
        if (bGT == null) {
            synchronized (f.class) {
                if (bGT == null) {
                    bGT = new f();
                }
            }
        }
        return bGT;
    }

    public final String abM() {
        return this.bGU;
    }

    public final void fO(String str) {
        if (bq.isEquals(this.bGU, str)) {
            return;
        }
        this.bGU = str;
        fP(str);
    }

    private static String abN() {
        try {
            return w.a(new File(bf.eB(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static void fP(String str) {
        try {
            w.a(new File(bf.eB(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
