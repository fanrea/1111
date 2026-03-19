package com.sigmob.sdk.downloader.core.interceptor;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.download.f;
import com.sigmob.sdk.downloader.core.exception.g;
import com.sigmob.sdk.downloader.core.interceptor.c;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a implements c.a, c.b {
    private static final String a = "BreakpointInterceptor";
    private static final Pattern b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");

    static long a(String contentRange) {
        Matcher matcher = b.matcher(contentRange);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    long a(com.sigmob.sdk.downloader.core.connection.a.InterfaceC0732a r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Content-Range"
            java.lang.String r0 = r7.c(r0)
            boolean r1 = com.sigmob.sdk.downloader.core.c.a(r0)
            r2 = 0
            if (r1 != 0) goto L1a
            long r0 = a(r0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L1a
            r4 = 1
            long r0 = r0 + r4
            goto L1c
        L1a:
            r0 = -1
        L1c:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L30
            java.lang.String r2 = "Content-Length"
            java.lang.String r7 = r7.c(r2)
            boolean r2 = com.sigmob.sdk.downloader.core.c.a(r7)
            if (r2 != 0) goto L30
            long r0 = java.lang.Long.parseLong(r7)
        L30:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.interceptor.a.a(com.sigmob.sdk.downloader.core.connection.a$a):long");
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.a
    public a.InterfaceC0732a a(f chain) throws IOException {
        a.InterfaceC0732a interfaceC0732aN = chain.n();
        com.sigmob.sdk.downloader.core.breakpoint.c cVarD = chain.d();
        if (chain.f().k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.a;
        }
        if (cVarD.g() == 1 && !cVarD.b()) {
            long jA = a(interfaceC0732aN);
            long j = cVarD.j();
            if (jA > 0 && jA != j) {
                com.sigmob.sdk.downloader.core.c.b(a, "SingleBlock special check: the response instance-length[" + jA + "] isn't equal to the instance length from trial-connection[" + j + "]");
                boolean z = cVarD.b(0).c() != 0;
                com.sigmob.sdk.downloader.core.breakpoint.a aVar = new com.sigmob.sdk.downloader.core.breakpoint.a(0L, jA);
                cVarD.f();
                cVarD.a(aVar);
                if (z) {
                    com.sigmob.sdk.downloader.core.c.a(a, "Discard breakpoint because of on this special case, we have to download from beginning");
                    throw new g("Discard breakpoint because of on this special case, we have to download from beginning");
                }
                com.sigmob.sdk.downloader.g.j().b().a().a(chain.c(), cVarD, com.sigmob.sdk.downloader.core.cause.b.CONTENT_LENGTH_CHANGED);
            }
        }
        try {
            if (chain.r().a(cVarD)) {
                return interfaceC0732aN;
            }
            throw new IOException("Update store failed!");
        } catch (Exception e) {
            throw new IOException("Update store failed!", e);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.b
    public long b(f chain) throws IOException {
        long jA = chain.a();
        int iE = chain.e();
        boolean z = jA != -1;
        long j = 0;
        com.sigmob.sdk.downloader.core.file.d dVarG = chain.g();
        while (true) {
            try {
                long jP = chain.p();
                if (jP == -1) {
                    break;
                }
                j += jP;
            } finally {
                chain.j();
                if (!chain.f().d()) {
                    dVarG.a(iE);
                }
            }
        }
        if (z) {
            dVarG.b(iE);
            if (j != jA) {
                throw new IOException("Fetch-length isn't equal to the response content-length, " + j + "!= " + jA);
            }
        }
        return j;
    }
}
