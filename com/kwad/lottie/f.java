package com.kwad.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.kwad.lottie.c.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class f extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = "f";
    private float Kw;
    private int alpha;
    private d bjG;
    private String bjI;
    private final Matrix bka = new Matrix();
    private final com.kwad.lottie.d.c bkb;
    private final Set<Object> bkc;
    private final ArrayList<a> bkd;
    private com.kwad.lottie.b.b bke;
    private b bkf;
    private com.kwad.lottie.b.a bkg;
    com.kwad.lottie.a bkh;
    m bki;
    private boolean bkj;
    private com.kwad.lottie.model.layer.b bkk;
    private boolean bkl;

    interface a {
        void Qv();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public f() {
        com.kwad.lottie.d.c cVar = new com.kwad.lottie.d.c();
        this.bkb = cVar;
        this.Kw = 1.0f;
        this.bkc = new HashSet();
        this.bkd = new ArrayList<>();
        this.alpha = 255;
        cVar.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.bkk != null) {
                    f.this.bkk.setProgress(f.this.bkb.SB());
                }
            }
        });
    }

    public final boolean Qn() {
        return this.bkj;
    }

    public final void co(boolean z) {
        if (this.bkj == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.bkj = z;
        if (this.bjG != null) {
            Qo();
        }
    }

    public final void dj(String str) {
        this.bjI = str;
    }

    public final String getImageAssetsFolder() {
        return this.bjI;
    }

    public final void PX() {
        com.kwad.lottie.b.b bVar = this.bke;
        if (bVar != null) {
            bVar.PX();
        }
    }

    public final boolean b(d dVar) {
        if (this.bjG == dVar) {
            return false;
        }
        Qb();
        this.bjG = dVar;
        Qo();
        this.bkb.setComposition(dVar);
        setProgress(this.bkb.getAnimatedFraction());
        setScale(this.Kw);
        Qs();
        Iterator it = new ArrayList(this.bkd).iterator();
        while (it.hasNext()) {
            ((a) it.next()).Qv();
            it.remove();
        }
        this.bkd.clear();
        dVar.setPerformanceTrackingEnabled(this.bkl);
        return true;
    }

    public final void setPerformanceTrackingEnabled(boolean z) {
        this.bkl = z;
        d dVar = this.bjG;
        if (dVar != null) {
            dVar.setPerformanceTrackingEnabled(z);
        }
    }

    public final l getPerformanceTracker() {
        d dVar = this.bjG;
        if (dVar != null) {
            return dVar.getPerformanceTracker();
        }
        return null;
    }

    private void Qo() {
        this.bkk = new com.kwad.lottie.model.layer.b(this, s.c(this.bjG), this.bjG.Qg(), this.bjG);
    }

    public final void Qb() {
        PX();
        if (this.bkb.isRunning()) {
            this.bkb.cancel();
        }
        this.bjG = null;
        this.bkk = null;
        this.bke = null;
        this.bkb.Qb();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.alpha = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Log.w(com.component.lottie.c.b, "Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        c.beginSection("Drawable#draw");
        if (this.bkk == null) {
            return;
        }
        float f2 = this.Kw;
        float fG = g(canvas);
        if (f2 > fG) {
            f = this.Kw / fG;
        } else {
            fG = f2;
            f = 1.0f;
        }
        if (f > 1.0f) {
            canvas.save();
            float fWidth = this.bjG.getBounds().width() / 2.0f;
            float fHeight = this.bjG.getBounds().height() / 2.0f;
            float f3 = fWidth * fG;
            float f4 = fHeight * fG;
            canvas.translate((getScale() * fWidth) - f3, (getScale() * fHeight) - f4);
            canvas.scale(f, f, f3, f4);
        }
        this.bka.reset();
        this.bka.preScale(fG, fG);
        this.bkk.a(canvas, this.bka, this.alpha);
        c.dg("Drawable#draw");
        if (f > 1.0f) {
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        PZ();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Qp();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    public final void PZ() {
        if (this.bkk == null) {
            this.bkd.add(new a() { // from class: com.kwad.lottie.f.5
                @Override // com.kwad.lottie.f.a
                public final void Qv() {
                    f.this.PZ();
                }
            });
        } else {
            this.bkb.PZ();
        }
    }

    private void Qp() {
        this.bkd.clear();
        this.bkb.Qp();
    }

    public final void setMinFrame(final int i) {
        if (this.bjG == null) {
            this.bkd.add(new a() { // from class: com.kwad.lottie.f.6
                @Override // com.kwad.lottie.f.a
                public final void Qv() {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            this.bkb.setMinFrame(i);
        }
    }

    public final float getMinFrame() {
        return this.bkb.getMinFrame();
    }

    public final void setMinProgress(final float f) {
        d dVar = this.bjG;
        if (dVar == null) {
            this.bkd.add(new a() { // from class: com.kwad.lottie.f.7
                @Override // com.kwad.lottie.f.a
                public final void Qv() {
                    f.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.kwad.lottie.d.e.lerp(dVar.Qe(), this.bjG.Qf(), f));
        }
    }

    public final void setMaxFrame(final int i) {
        if (this.bjG == null) {
            this.bkd.add(new a() { // from class: com.kwad.lottie.f.8
                @Override // com.kwad.lottie.f.a
                public final void Qv() {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            this.bkb.setMaxFrame(i);
        }
    }

    public final float getMaxFrame() {
        return this.bkb.getMaxFrame();
    }

    public final void setMaxProgress(final float f) {
        d dVar = this.bjG;
        if (dVar == null) {
            this.bkd.add(new a() { // from class: com.kwad.lottie.f.9
                @Override // com.kwad.lottie.f.a
                public final void Qv() {
                    f.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.kwad.lottie.d.e.lerp(dVar.Qe(), this.bjG.Qf(), f));
        }
    }

    public final void setSpeed(float f) {
        this.bkb.setSpeed(f);
    }

    public final float getSpeed() {
        return this.bkb.getSpeed();
    }

    public final void a(Animator.AnimatorListener animatorListener) {
        this.bkb.addListener(animatorListener);
    }

    public final void b(Animator.AnimatorListener animatorListener) {
        this.bkb.removeListener(animatorListener);
    }

    public final void setFrame(final int i) {
        if (this.bjG == null) {
            this.bkd.add(new a() { // from class: com.kwad.lottie.f.2
                @Override // com.kwad.lottie.f.a
                public final void Qv() {
                    f.this.setFrame(i);
                }
            });
        } else {
            this.bkb.setFrame(i);
        }
    }

    public final int getFrame() {
        return (int) this.bkb.SC();
    }

    public final void setProgress(final float f) {
        d dVar = this.bjG;
        if (dVar == null) {
            this.bkd.add(new a() { // from class: com.kwad.lottie.f.3
                @Override // com.kwad.lottie.f.a
                public final void Qv() {
                    f.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.kwad.lottie.d.e.lerp(dVar.Qe(), this.bjG.Qf(), f));
        }
    }

    public final void setRepeatMode(int i) {
        this.bkb.setRepeatMode(i);
    }

    public final int getRepeatMode() {
        return this.bkb.getRepeatMode();
    }

    public final void setRepeatCount(int i) {
        this.bkb.setRepeatCount(i);
    }

    public final int getRepeatCount() {
        return this.bkb.getRepeatCount();
    }

    public final boolean isAnimating() {
        return this.bkb.isRunning();
    }

    public final void setScale(float f) {
        this.Kw = f;
        Qs();
    }

    public final void setImageAssetDelegate(b bVar) {
        this.bkf = bVar;
        com.kwad.lottie.b.b bVar2 = this.bke;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    public final void setFontAssetDelegate(com.kwad.lottie.a aVar) {
        this.bkh = aVar;
        com.kwad.lottie.b.a aVar2 = this.bkg;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public final void setTextDelegate(m mVar) {
        this.bki = mVar;
    }

    public final m Qq() {
        return this.bki;
    }

    public final boolean Qr() {
        return this.bki == null && this.bjG.Qh().size() > 0;
    }

    public final float getScale() {
        return this.Kw;
    }

    public final d getComposition() {
        return this.bjG;
    }

    private void Qs() {
        if (this.bjG == null) {
            return;
        }
        float scale = getScale();
        setBounds(0, 0, (int) (this.bjG.getBounds().width() * scale), (int) (this.bjG.getBounds().height() * scale));
    }

    public final void Qa() {
        this.bkd.clear();
        this.bkb.cancel();
    }

    public final float getProgress() {
        return this.bkb.SB();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.bjG == null) {
            return -1;
        }
        return (int) (r0.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.bjG == null) {
            return -1;
        }
        return (int) (r0.getBounds().height() * getScale());
    }

    private List<com.kwad.lottie.model.e> a(com.kwad.lottie.model.e eVar) {
        if (this.bkk == null) {
            Log.w(com.component.lottie.c.b, "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.bkk.a(eVar, 0, arrayList, new com.kwad.lottie.model.e(new String[0]));
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> void a(final com.kwad.lottie.model.e r5, final T r6, final com.kwad.lottie.e.c<T> r7) {
        /*
            r4 = this;
            com.kwad.lottie.model.layer.b r0 = r4.bkk
            if (r0 != 0) goto Lf
            java.util.ArrayList<com.kwad.lottie.f$a> r0 = r4.bkd
            com.kwad.lottie.f$4 r1 = new com.kwad.lottie.f$4
            r1.<init>()
            r0.add(r1)
            return
        Lf:
            com.kwad.lottie.model.f r0 = r5.Rg()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L20
            com.kwad.lottie.model.f r5 = r5.Rg()
            r5.a(r6, r7)
        L1e:
            r1 = r2
            goto L42
        L20:
            java.util.List r5 = r4.a(r5)
            r0 = r1
        L25:
            int r3 = r5.size()
            if (r0 >= r3) goto L3b
            java.lang.Object r3 = r5.get(r0)
            com.kwad.lottie.model.e r3 = (com.kwad.lottie.model.e) r3
            com.kwad.lottie.model.f r3 = r3.Rg()
            r3.a(r6, r7)
            int r0 = r0 + 1
            goto L25
        L3b:
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L42
            goto L1e
        L42:
            if (r1 == 0) goto L52
            r4.invalidateSelf()
            java.lang.Float r5 = com.kwad.lottie.i.bkT
            if (r6 != r5) goto L52
            float r5 = r4.getProgress()
            r4.setProgress(r5)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.lottie.f.a(com.kwad.lottie.model.e, java.lang.Object, com.kwad.lottie.e.c):void");
    }

    public final Bitmap dk(String str) {
        com.kwad.lottie.b.b bVarQt = Qt();
        if (bVarQt != null) {
            return bVarQt.m455do(str);
        }
        return null;
    }

    private com.kwad.lottie.b.b Qt() {
        if (getCallback() == null) {
            return null;
        }
        com.kwad.lottie.b.b bVar = this.bke;
        if (bVar != null && !bVar.aZ(getContext())) {
            this.bke.PX();
            this.bke = null;
        }
        if (this.bke == null) {
            this.bke = new com.kwad.lottie.b.b(getCallback(), this.bjI, this.bkf, this.bjG.Qj());
        }
        return this.bke;
    }

    public final Typeface N(String str, String str2) {
        com.kwad.lottie.b.a aVarQu = Qu();
        if (aVarQu != null) {
            return aVarQu.N(str, str2);
        }
        return null;
    }

    private com.kwad.lottie.b.a Qu() {
        if (getCallback() == null) {
            return null;
        }
        if (this.bkg == null) {
            this.bkg = new com.kwad.lottie.b.a(getCallback(), this.bkh);
        }
        return this.bkg;
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    private float g(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.bjG.getBounds().width(), canvas.getHeight() / this.bjG.getBounds().height());
    }
}
