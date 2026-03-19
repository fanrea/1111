package com.kwad.sdk.glide.request.a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class e<Z> extends k<ImageView, Z> {
    private Animatable animatable;
    private boolean mAutoStartAnimatable;

    protected abstract void setResource(Z z);

    public e(ImageView imageView) {
        super(imageView);
        this.mAutoStartAnimatable = true;
    }

    @Deprecated
    public e(ImageView imageView, boolean z) {
        super(imageView, z);
        this.mAutoStartAnimatable = true;
    }

    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public e autoStartAnimatable(boolean z) {
        this.mAutoStartAnimatable = z;
        return this;
    }

    @Override // com.kwad.sdk.glide.request.a.k, com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        setResourceInternal(null);
        setDrawable(drawable);
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        setResourceInternal(null);
        setDrawable(drawable);
    }

    @Override // com.kwad.sdk.glide.request.a.k, com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.animatable;
        if (animatable != null) {
            animatable.stop();
        }
        setResourceInternal(null);
        setDrawable(drawable);
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void onResourceReady(Z z, com.kwad.sdk.glide.request.b.b<? super Z> bVar) {
        setResourceInternal(z);
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.a.i
    public void onStart() {
        Animatable animatable = this.animatable;
        if (animatable == null || !this.mAutoStartAnimatable) {
            return;
        }
        animatable.start();
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.a.i
    public void onStop() {
        Animatable animatable = this.animatable;
        if (animatable != null) {
            animatable.stop();
        }
    }

    private void setResourceInternal(Z z) {
        setResource(z);
        maybeUpdateAnimatable(z);
    }

    private void maybeUpdateAnimatable(Z z) {
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.animatable = animatable;
            if (this.mAutoStartAnimatable) {
                animatable.start();
                return;
            }
            return;
        }
        this.animatable = null;
    }
}
