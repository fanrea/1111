package com.kwad.sdk.glide.load.resource.b;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.kwad.sdk.glide.load.engine.o;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.utils.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b<T extends Drawable> implements o, s<T> {
    protected final T bXV;

    public b(T t) {
        this.bXV = (T) ax.checkNotNull(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.engine.s
    /* renamed from: ahY, reason: merged with bridge method [inline-methods] */
    public T get() {
        Drawable.ConstantState constantState = this.bXV.getConstantState();
        if (constantState == null) {
            return this.bXV;
        }
        return (T) constantState.newDrawable();
    }

    @Override // com.kwad.sdk.glide.load.engine.o
    public void initialize() {
        T t = this.bXV;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof com.kwad.sdk.glide.load.resource.d.c) {
            ((com.kwad.sdk.glide.load.resource.d.c) t).ahZ().prepareToDraw();
        }
    }
}
