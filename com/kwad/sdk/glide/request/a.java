package com.kwad.sdk.glide.request;

import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a<R> implements h<R> {
    private GlideException bZh;

    @Override // com.kwad.sdk.glide.request.h
    public final boolean a(R r, Object obj, com.kwad.sdk.glide.request.a.j<R> jVar, DataSource dataSource, boolean z) {
        return false;
    }

    @Override // com.kwad.sdk.glide.request.h
    public boolean a(GlideException glideException) {
        this.bZh = glideException;
        return false;
    }

    public final GlideException aix() {
        return this.bZh;
    }

    public static Exception c(GlideException glideException) {
        if (glideException == null) {
            return glideException;
        }
        List<Throwable> causes = glideException.getCauses();
        for (Throwable th : causes) {
            if (th instanceof IOException) {
                return (IOException) th;
            }
        }
        return (causes.isEmpty() || !(causes.get(0) instanceof Exception)) ? glideException : (Exception) causes.get(0);
    }
}
