package com.kwad.sdk.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.kwad.sdk.glide.request.a.k;
import com.kwad.sdk.glide.request.i;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e extends ContextWrapper {
    static final h<?, ?> bPT = new b();
    private final Registry bPC;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bPD;
    private final Map<Class<?>, h<?, ?>> bPI;
    private final i bPN;
    private final List<com.kwad.sdk.glide.request.h<Object>> bPR;
    private final boolean bPS;
    private final com.kwad.sdk.glide.request.a.f bPU;
    private final com.kwad.sdk.glide.load.engine.i bPx;
    private final int logLevel;

    public e(Context context, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, Registry registry, com.kwad.sdk.glide.request.a.f fVar, i iVar, Map<Class<?>, h<?, ?>> map, List<com.kwad.sdk.glide.request.h<Object>> list, com.kwad.sdk.glide.load.engine.i iVar2, boolean z, int i) {
        super(context.getApplicationContext());
        this.bPD = bVar;
        this.bPC = registry;
        this.bPU = fVar;
        this.bPN = iVar;
        this.bPR = list;
        this.bPI = map;
        this.bPx = iVar2;
        this.bPS = z;
        this.logLevel = i;
    }

    public final List<com.kwad.sdk.glide.request.h<Object>> aff() {
        return this.bPR;
    }

    public final i afg() {
        return this.bPN;
    }

    public final <T> h<?, T> h(Class<T> cls) {
        h<?, T> hVar = (h) this.bPI.get(cls);
        if (hVar == null) {
            for (Map.Entry<Class<?>, h<?, ?>> entry : this.bPI.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    hVar = (h) entry.getValue();
                }
            }
        }
        return hVar == null ? (h<?, T>) bPT : hVar;
    }

    public final <X> k<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return com.kwad.sdk.glide.request.a.f.b(imageView, cls);
    }

    public final com.kwad.sdk.glide.load.engine.i afh() {
        return this.bPx;
    }

    public final Registry afe() {
        return this.bPC;
    }

    public final int getLogLevel() {
        return this.logLevel;
    }

    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b afa() {
        return this.bPD;
    }

    public final boolean afi() {
        return this.bPS;
    }
}
