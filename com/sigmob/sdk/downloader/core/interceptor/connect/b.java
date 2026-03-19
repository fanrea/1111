package com.sigmob.sdk.downloader.core.interceptor.connect;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.download.f;
import com.sigmob.sdk.downloader.core.interceptor.c;
import com.sigmob.sdk.downloader.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements c.a {
    private static final String a = "HeaderInterceptor";

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.a
    public a.InterfaceC0732a a(f chain) throws IOException {
        com.sigmob.sdk.downloader.core.breakpoint.c cVarD = chain.d();
        com.sigmob.sdk.downloader.core.connection.a aVarI = chain.i();
        com.sigmob.sdk.downloader.f fVarC = chain.c();
        Map<String, List<String>> mapB = fVarC.b();
        if (mapB != null) {
            com.sigmob.sdk.downloader.core.c.a(mapB, aVarI);
        }
        if (mapB == null || !mapB.containsKey("User-Agent")) {
            com.sigmob.sdk.downloader.core.c.a(aVarI);
        }
        int iE = chain.e();
        com.sigmob.sdk.downloader.core.breakpoint.a aVarB = cVarD.b(iE);
        if (aVarB == null) {
            throw new IOException("No block-info found on " + iE);
        }
        String str = "bytes=" + aVarB.c() + "-";
        if (!cVarD.b()) {
            str = str + aVarB.e();
        }
        aVarI.a("Range", str);
        com.sigmob.sdk.downloader.core.c.b(a, "AssembleHeaderRange (" + fVarC.c() + ") block(" + iE + ") downloadFrom(" + aVarB.c() + ") currentOffset(" + aVarB.a() + ")");
        String strK = cVarD.k();
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) strK)) {
            aVarI.a("If-Match", strK);
        }
        if (chain.f().k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.a;
        }
        g.j().b().a().b(fVarC, iE, aVarI.c());
        a.InterfaceC0732a interfaceC0732aN = chain.n();
        if (chain.f().k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.a;
        }
        Map<String, List<String>> mapF = interfaceC0732aN.f();
        if (mapF == null) {
            mapF = new HashMap<>();
        }
        g.j().b().a().a(fVarC, iE, interfaceC0732aN.d(), mapF);
        g.j().g().a(interfaceC0732aN, iE, cVarD).a();
        String strC = interfaceC0732aN.c("Content-Length");
        chain.a((strC == null || strC.length() == 0) ? com.sigmob.sdk.downloader.core.c.d(interfaceC0732aN.c("Content-Range")) : com.sigmob.sdk.downloader.core.c.b(strC));
        return interfaceC0732aN;
    }
}
