package com.kwad.sdk.glide.webp.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.kwad.sdk.glide.webp.decoder.o;
import com.kwad.sdk.utils.ax;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class k extends Drawable implements Animatable, Animatable2Compat, o.b {
    private boolean aev;
    private int bRd;
    private boolean bUe;
    private boolean bYc;
    private int bYd;
    private boolean bYe;
    private Rect bYf;
    private List<Animatable2Compat.AnimationCallback> bYg;
    private Paint blq;
    private final a caQ;
    private boolean isRunning;

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public int getOpacity() {
        return -2;
    }

    public k(Context context, i iVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.i<Bitmap> iVar2, int i, int i2, Bitmap bitmap) {
        this(new a(eVar, new o(com.kwad.sdk.glide.c.cv(context), iVar, i, i2, iVar2, bitmap)));
    }

    k(a aVar) {
        this.bYc = true;
        this.bYd = -1;
        this.caQ = (a) ax.checkNotNull(aVar);
    }

    public final int getSize() {
        return this.caQ.caR.getSize();
    }

    public final Bitmap ahZ() {
        return this.caQ.caR.ahZ();
    }

    public final void a(com.kwad.sdk.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this.caQ.caR.a(iVar, bitmap);
    }

    public final ByteBuffer getBuffer() {
        return this.caQ.caR.getBuffer();
    }

    private int getFrameCount() {
        return this.caQ.caR.getFrameCount();
    }

    private int aia() {
        return this.caQ.caR.getCurrentIndex();
    }

    private void aib() {
        this.bRd = 0;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.aev = true;
        aib();
        if (this.bYc) {
            aic();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.aev = false;
        aid();
    }

    private void aic() {
        ax.checkArgument(!this.bUe, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        System.currentTimeMillis();
        if (this.caQ.caR.getFrameCount() == 1) {
            invalidateSelf();
        } else {
            if (this.isRunning) {
                return;
            }
            this.isRunning = true;
            this.caQ.caR.a(this);
            invalidateSelf();
        }
    }

    private void aid() {
        this.isRunning = false;
        this.caQ.caR.b(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        ax.checkArgument(!this.bUe, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.bYc = z;
        if (!z) {
            aid();
        } else if (this.aev) {
            aic();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.caQ.caR.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.caQ.caR.getHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.bYe = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        System.currentTimeMillis();
        if (isRecycled()) {
            return;
        }
        if (this.bYe) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), aie());
            this.bYe = false;
        }
        canvas.drawBitmap(this.caQ.caR.aij(), (Rect) null, aie(), getPaint());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        getPaint().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        getPaint().setColorFilter(colorFilter);
    }

    private Rect aie() {
        if (this.bYf == null) {
            this.bYf = new Rect();
        }
        return this.bYf;
    }

    private Paint getPaint() {
        if (this.blq == null) {
            this.blq = new Paint(2);
        }
        return this.blq;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback aif() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    @Override // com.kwad.sdk.glide.webp.decoder.o.b
    public final void aig() {
        if (aif() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (aia() == getFrameCount() - 1) {
            this.bRd++;
        }
        int i = this.bYd;
        if (i == -1 || this.bRd < i) {
            return;
        }
        stop();
        aih();
    }

    private void aih() {
        List<Animatable2Compat.AnimationCallback> list = this.bYg;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.bYg.get(i).onAnimationEnd(this);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.caQ;
    }

    public final void recycle() {
        this.bUe = true;
        this.caQ.caR.clear();
    }

    private boolean isRecycled() {
        return this.bUe;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.bYg == null) {
            this.bYg = new ArrayList();
        }
        this.bYg.add(animationCallback);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.bYg;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.bYg;
        if (list != null) {
            list.clear();
        }
    }

    static class a extends Drawable.ConstantState {
        final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;
        final o caR;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, o oVar) {
            this.bPy = eVar;
            this.caR = oVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new k(this);
        }
    }
}
