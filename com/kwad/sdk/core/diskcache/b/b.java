package com.kwad.sdk.core.diskcache.b;

import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    static void a(final com.kwad.sdk.core.diskcache.a.a aVar, final String str, final String str2) {
        h.execute(new bh() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                OutputStream outputStreamFf = null;
                try {
                    a.C0579a c0579aET = aVar.eT(str2);
                    if (c0579aET != null) {
                        outputStreamFf = c0579aET.ff(0);
                        if (b.a(str, outputStreamFf, new a.C0589a())) {
                            c0579aET.commit();
                        } else {
                            c0579aET.abort();
                        }
                        aVar.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamFf);
                }
            }
        });
    }

    static File a(com.kwad.sdk.core.diskcache.a.a aVar, String str) throws Throwable {
        a.c cVarES;
        a.c cVar = null;
        try {
            cVarES = aVar.eS(str);
            if (cVarES != null) {
                try {
                    File fileFe = cVarES.fe(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVarES);
                    return fileFe;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    cVar = cVarES;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            cVarES = null;
        } catch (Throwable th2) {
            th = th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cVarES);
        return null;
    }

    static boolean a(com.kwad.sdk.core.diskcache.a.a aVar, String str, String str2, a.C0589a c0589a) {
        boolean z = false;
        OutputStream outputStreamFf = null;
        try {
            try {
                a.C0579a c0579aET = aVar.eT(str2);
                if (c0579aET != null) {
                    outputStreamFf = c0579aET.ff(0);
                    if (a(str, outputStreamFf, c0589a)) {
                        c0579aET.commit();
                        z = true;
                    } else {
                        c0579aET.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e) {
                c0589a.msg = e.getMessage();
            }
            return z;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamFf);
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0589a c0589a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c0589a, -1L, true, null);
    }
}
