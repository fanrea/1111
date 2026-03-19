package com.kwad.sdk.glide.load.resource.b;

import android.graphics.drawable.Drawable;
import com.kwad.sdk.glide.load.engine.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class c extends b<Drawable> {
    @Override // com.kwad.sdk.glide.load.engine.s
    public final void recycle() {
    }

    static s<Drawable> b(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    private c(Drawable drawable) {
        super(drawable);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Class<Drawable> afv() {
        return this.bXV.getClass();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int getSize() {
        return Math.max(1, this.bXV.getIntrinsicWidth() * this.bXV.getIntrinsicHeight() * 4);
    }
}
