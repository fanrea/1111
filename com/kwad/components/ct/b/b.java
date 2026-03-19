package com.kwad.components.ct.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.request.a.j;
import com.kwad.sdk.glide.request.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static void i(Context context, final String str) {
        com.kwad.sdk.core.d.c.d("GlideUtils", "preloadImage imageUrl=" + str);
        try {
            com.kwad.sdk.glide.c.cy(context).hh(str).b(new h<Drawable>() { // from class: com.kwad.components.ct.b.b.1
                @Override // com.kwad.sdk.glide.request.h
                public final /* synthetic */ boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
                    return Fk();
                }

                @Override // com.kwad.sdk.glide.request.h
                public final boolean a(GlideException glideException) {
                    com.kwad.sdk.core.d.c.d("GlideUtils", "preloadImage onLoadFailed imageUrl=" + str);
                    return false;
                }

                private boolean Fk() {
                    com.kwad.sdk.core.d.c.d("GlideUtils", "preloadImage onResourceReady imageUrl=" + str);
                    return false;
                }
            }).afm();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }
}
