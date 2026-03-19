package com.kwad.framework.filedownloader.download;

import android.os.SystemClock;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private final String adR;
    private final int beF;
    private final long beN;
    long beO;
    private final long beP;
    private final com.kwad.framework.filedownloader.b.a beU;
    private final f bfC;
    private final int bfE;
    private final c bfT;
    private final com.kwad.framework.filedownloader.a.b bfU;
    private com.kwad.framework.filedownloader.e.a bfV;
    private volatile long bfW;
    private volatile long bfX;
    private final boolean bfc;
    private final long contentLength;
    private volatile boolean oW;

    /* synthetic */ e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str, byte b) {
        this(bVar, aVar, cVar, i, i2, z, fVar, str);
    }

    public final void pause() {
        this.oW = true;
    }

    private e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        this.bfW = 0L;
        this.bfX = 0L;
        this.bfC = fVar;
        this.adR = str;
        this.bfU = bVar;
        this.bfc = z;
        this.bfT = cVar;
        this.bfE = i2;
        this.beF = i;
        this.beU = b.Ny().NA();
        this.beN = aVar.beN;
        this.beP = aVar.beP;
        this.beO = aVar.beO;
        this.contentLength = aVar.contentLength;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x011c, code lost:
    
        if (r10 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011e, code lost:
    
        sync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0121, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r9);
        com.kwad.sdk.crash.utils.b.closeQuietly(r10);
        r6 = r16.beO - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012e, code lost:
    
        if (r2 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0132, code lost:
    
        if (r2 != r6) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0172, code lost:
    
        throw new com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", java.lang.Long.valueOf(r6), java.lang.Long.valueOf(r2), java.lang.Long.valueOf(r16.beN), java.lang.Long.valueOf(r16.beP), java.lang.Long.valueOf(r16.beO), java.lang.Long.valueOf(r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0173, code lost:
    
        r16.bfC.a(r16.bfT, r16.beN, r16.beP);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x017e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.e.run():void");
    }

    private void Ob() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwad.framework.filedownloader.f.f.r(this.beO - this.bfW, jElapsedRealtime - this.bfX)) {
            sync();
            this.bfW = this.beO;
            this.bfX = jElapsedRealtime;
        }
    }

    private void sync() {
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            this.bfV.OS();
            z = true;
        } catch (IOException e) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
            z = false;
        }
        if (z) {
            if (this.bfT != null) {
                this.beU.a(this.beF, this.bfE, this.beO);
            } else {
                this.bfC.NK();
            }
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.beF), Integer.valueOf(this.bfE), Long.valueOf(this.beO), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public static class a {
        String adR;
        Integer beL;
        com.kwad.framework.filedownloader.download.a beM;
        f bfC;
        Integer bfG;
        com.kwad.framework.filedownloader.a.b bfU;
        c bfY;
        Boolean bfz;

        public final a d(com.kwad.framework.filedownloader.a.b bVar) {
            this.bfU = bVar;
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.download.a aVar) {
            this.beM = aVar;
            return this;
        }

        public final a b(f fVar) {
            this.bfC = fVar;
            return this;
        }

        public final a cx(String str) {
            this.adR = str;
            return this;
        }

        public final a ck(boolean z) {
            this.bfz = Boolean.valueOf(z);
            return this;
        }

        public final a a(c cVar) {
            this.bfY = cVar;
            return this;
        }

        public final a dx(int i) {
            this.bfG = Integer.valueOf(i);
            return this;
        }

        public final a dy(int i) {
            this.beL = Integer.valueOf(i);
            return this;
        }

        public final e Oc() {
            if (this.bfz == null || this.bfU == null || this.beM == null || this.bfC == null || this.adR == null || this.beL == null || this.bfG == null) {
                throw new IllegalArgumentException();
            }
            return new e(this.bfU, this.beM, this.bfY, this.beL.intValue(), this.bfG.intValue(), this.bfz.booleanValue(), this.bfC, this.adR, (byte) 0);
        }
    }
}
