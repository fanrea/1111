package com.kwad.sdk.glide.load.engine.a;

import android.util.Log;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e implements a {
    private final File bAP;
    private com.kwad.sdk.core.diskcache.a.a bBs;
    private final long maxSize;
    private final c bVp = new c();
    private final j bVo = new j();

    public static a a(File file, long j) {
        return new e(file, j);
    }

    @Deprecated
    private e(File file, long j) {
        this.bAP = file;
        this.maxSize = j;
    }

    private synchronized com.kwad.sdk.core.diskcache.a.a ahg() {
        if (this.bBs == null) {
            this.bBs = com.kwad.sdk.core.diskcache.a.a.a(this.bAP, 1, 1, this.maxSize);
        }
        return this.bBs;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a
    public final File e(com.kwad.sdk.glide.load.c cVar) {
        String strG = this.bVo.g(cVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strG + " for for Key: " + cVar);
        }
        try {
            a.c cVarES = ahg().eS(strG);
            if (cVarES != null) {
                return cVarES.fe(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a
    public final void a(com.kwad.sdk.glide.load.c cVar, a.b bVar) {
        String strG = this.bVo.g(cVar);
        this.bVp.hk(strG);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strG + " for for Key: " + cVar);
            }
            try {
                com.kwad.sdk.core.diskcache.a.a aVarAhg = ahg();
                if (aVarAhg.eS(strG) == null) {
                    a.C0579a c0579aET = aVarAhg.eT(strG);
                    if (c0579aET == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + strG);
                    }
                    try {
                        if (bVar.O(c0579aET.fe(0))) {
                            c0579aET.commit();
                        }
                        c0579aET.abortUnlessCommitted();
                    } catch (Throwable th) {
                        c0579aET.abortUnlessCommitted();
                        throw th;
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
        } finally {
            this.bVp.hl(strG);
        }
    }
}
