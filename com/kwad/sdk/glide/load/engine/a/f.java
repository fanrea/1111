package com.kwad.sdk.glide.load.engine.a;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.kwad.sdk.glide.load.engine.a.d;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f extends d {
    public f(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000L);
    }

    private f(final Context context, final String str, long j) {
        super(new d.a() { // from class: com.kwad.sdk.glide.load.engine.a.f.1
            @Override // com.kwad.sdk.glide.load.engine.a.d.a
            public final File ahf() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, 262144000L);
    }
}
