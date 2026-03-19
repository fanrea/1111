package com.tachikoma.lottie;

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
import com.tachikoma.lottie.c.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class g extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = g.class.getSimpleName();
    private e GD;
    private String GI;
    private com.tachikoma.lottie.b.b Hm;
    private b Hn;
    private com.tachikoma.lottie.b.a Ho;
    com.tachikoma.lottie.a Hp;
    p Hq;
    private boolean Hr;
    private com.tachikoma.lottie.model.layer.b Hs;
    private boolean Ht;
    private final Matrix Hh = new Matrix();
    private final com.tachikoma.lottie.d.c Hi = new com.tachikoma.lottie.d.c();
    private float Hj = 1.0f;
    private final Set<Object> Hk = new HashSet();
    private final ArrayList<a> Hl = new ArrayList<>();
    private int alpha = 255;
    private boolean Hu = false;

    interface a {
        void jK();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public g() {
        this.Hi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tachikoma.lottie.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.Hs != null) {
                    g.this.Hs.setProgress(g.this.Hi.lY());
                }
            }
        });
    }

    public final boolean jC() {
        return this.Hr;
    }

    public final void O(boolean z) {
        if (this.Hr == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.Hr = z;
        if (this.GD != null) {
            jD();
        }
    }

    public final void X(String str) {
        this.GI = str;
    }

    public final String getImageAssetsFolder() {
        return this.GI;
    }

    public final boolean b(e eVar) {
        if (this.GD == eVar) {
            return false;
        }
        this.Hu = false;
        jn();
        this.GD = eVar;
        jD();
        this.Hi.setComposition(eVar);
        setProgress(this.Hi.getAnimatedFraction());
        setScale(this.Hj);
        jH();
        Iterator it = new ArrayList(this.Hl).iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.jK();
            }
            it.remove();
        }
        this.Hl.clear();
        eVar.setPerformanceTrackingEnabled(this.Ht);
        return true;
    }

    public final void setPerformanceTrackingEnabled(boolean z) {
        this.Ht = z;
        e eVar = this.GD;
        if (eVar != null) {
            eVar.setPerformanceTrackingEnabled(z);
        }
    }

    public final n getPerformanceTracker() {
        e eVar = this.GD;
        if (eVar != null) {
            return eVar.getPerformanceTracker();
        }
        return null;
    }

    private void jD() {
        this.Hs = new com.tachikoma.lottie.model.layer.b(this, s.c(this.GD), this.GD.jw(), this.GD);
    }

    public final void jn() {
        if (this.Hi.isRunning()) {
            this.Hi.cancel();
        }
        this.GD = null;
        this.Hs = null;
        this.Hm = null;
        this.Hi.jn();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.Hu) {
            return;
        }
        this.Hu = true;
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
        this.Hu = false;
        c.beginSection("Drawable#draw");
        if (this.Hs == null) {
            return;
        }
        float f2 = this.Hj;
        float f3 = f(canvas);
        if (f2 > f3) {
            f = this.Hj / f3;
        } else {
            f3 = f2;
            f = 1.0f;
        }
        int iSave = -1;
        if (f > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.GD.getBounds().width() / 2.0f;
            float fHeight = this.GD.getBounds().height() / 2.0f;
            float f4 = fWidth * f3;
            float f5 = fHeight * f3;
            canvas.translate((getScale() * fWidth) - f4, (getScale() * fHeight) - f5);
            canvas.scale(f, f, f4, f5);
        }
        this.Hh.reset();
        this.Hh.preScale(f3, f3);
        this.Hs.a(canvas, this.Hh, this.alpha);
        c.S("Drawable#draw");
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        jj();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        jE();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    public final void jj() {
        if (this.Hs == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.7
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.jj();
                }
            });
        } else {
            this.Hi.jj();
        }
    }

    private void jE() {
        this.Hl.clear();
        this.Hi.jE();
    }

    public final void jk() {
        if (this.Hs == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.8
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.jk();
                }
            });
        } else {
            this.Hi.jk();
        }
    }

    public final void setMinFrame(final int i) {
        if (this.GD == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.9
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.setMinFrame(i);
                }
            });
        } else {
            this.Hi.setMinFrame(i);
        }
    }

    public final float getMinFrame() {
        return this.Hi.getMinFrame();
    }

    public final void setMinProgress(final float f) {
        e eVar = this.GD;
        if (eVar == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.10
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.tachikoma.lottie.d.e.c(eVar.ju(), this.GD.jv(), f));
        }
    }

    public final void setMaxFrame(final int i) {
        if (this.GD == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.11
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.setMaxFrame(i);
                }
            });
        } else {
            this.Hi.l(i + 0.99f);
        }
    }

    public final float getMaxFrame() {
        return this.Hi.getMaxFrame();
    }

    public final void setMaxProgress(final float f) {
        e eVar = this.GD;
        if (eVar == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.12
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.tachikoma.lottie.d.e.c(eVar.ju(), this.GD.jv(), f));
        }
    }

    public final void setMinFrame(final String str) {
        e eVar = this.GD;
        if (eVar == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.13
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.setMinFrame(str);
                }
            });
            return;
        }
        com.tachikoma.lottie.model.g gVarV = eVar.V(str);
        if (gVarV == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        setMinFrame((int) gVarV.GT);
    }

    public final void setMaxFrame(final String str) {
        e eVar = this.GD;
        if (eVar == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.14
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.setMaxFrame(str);
                }
            });
            return;
        }
        com.tachikoma.lottie.model.g gVarV = eVar.V(str);
        if (gVarV == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        setMaxFrame((int) (gVarV.GT + gVarV.KY));
    }

    public final void setMinAndMaxFrame(final String str) {
        e eVar = this.GD;
        if (eVar == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.2
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.setMinAndMaxFrame(str);
                }
            });
            return;
        }
        com.tachikoma.lottie.model.g gVarV = eVar.V(str);
        if (gVarV == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i = (int) gVarV.GT;
        aA(i, ((int) gVarV.KY) + i);
    }

    public final void aA(final int i, final int i2) {
        if (this.GD == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.3
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.aA(i, i2);
                }
            });
        } else {
            this.Hi.o(i, i2 + 0.99f);
        }
    }

    public final void setSpeed(float f) {
        this.Hi.setSpeed(f);
    }

    public final float getSpeed() {
        return this.Hi.getSpeed();
    }

    public final void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Hi.addUpdateListener(animatorUpdateListener);
    }

    public final void b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Hi.removeUpdateListener(animatorUpdateListener);
    }

    public final void a(Animator.AnimatorListener animatorListener) {
        this.Hi.addListener(animatorListener);
    }

    public final void b(Animator.AnimatorListener animatorListener) {
        this.Hi.removeListener(animatorListener);
    }

    public final void setFrame(final int i) {
        if (this.GD == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.4
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.setFrame(i);
                }
            });
        } else {
            this.Hi.setFrame(i);
        }
    }

    public final int getFrame() {
        return (int) this.Hi.lZ();
    }

    public final void setProgress(final float f) {
        e eVar = this.GD;
        if (eVar == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.5
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.tachikoma.lottie.d.e.c(eVar.ju(), this.GD.jv(), f));
        }
    }

    public final void setRepeatMode(int i) {
        this.Hi.setRepeatMode(i);
    }

    public final int getRepeatMode() {
        return this.Hi.getRepeatMode();
    }

    public final void setRepeatCount(int i) {
        this.Hi.setRepeatCount(i);
    }

    public final int getRepeatCount() {
        return this.Hi.getRepeatCount();
    }

    public final boolean isAnimating() {
        return this.Hi.isRunning();
    }

    public final void setScale(float f) {
        this.Hj = f;
        jH();
    }

    public final void setImageAssetDelegate(b bVar) {
        this.Hn = bVar;
        com.tachikoma.lottie.b.b bVar2 = this.Hm;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    public final void setFontAssetDelegate(com.tachikoma.lottie.a aVar) {
        this.Hp = aVar;
        com.tachikoma.lottie.b.a aVar2 = this.Ho;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public final void setTextDelegate(p pVar) {
        this.Hq = pVar;
    }

    public final p jF() {
        return this.Hq;
    }

    public final boolean jG() {
        return this.Hq == null && this.GD.jx().size() > 0;
    }

    public final float getScale() {
        return this.Hj;
    }

    public final e getComposition() {
        return this.GD;
    }

    private void jH() {
        if (this.GD == null) {
            return;
        }
        float scale = getScale();
        setBounds(0, 0, (int) (this.GD.getBounds().width() * scale), (int) (this.GD.getBounds().height() * scale));
    }

    public final void jl() {
        this.Hl.clear();
        this.Hi.cancel();
    }

    public final void jm() {
        this.Hl.clear();
        this.Hi.jm();
    }

    public final float getProgress() {
        return this.Hi.lY();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.GD == null) {
            return -1;
        }
        return (int) (r0.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.GD == null) {
            return -1;
        }
        return (int) (r0.getBounds().height() * getScale());
    }

    private List<com.tachikoma.lottie.model.d> a(com.tachikoma.lottie.model.d dVar) {
        if (this.Hs == null) {
            Log.w(com.component.lottie.c.b, "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.Hs.a(dVar, 0, arrayList, new com.tachikoma.lottie.model.d(new String[0]));
        return arrayList;
    }

    public final <T> void a(final com.tachikoma.lottie.model.d dVar, final T t, final com.tachikoma.lottie.e.c<T> cVar) {
        if (this.Hs == null) {
            this.Hl.add(new a() { // from class: com.tachikoma.lottie.g.6
                @Override // com.tachikoma.lottie.g.a
                public final void jK() {
                    g.this.a(dVar, t, cVar);
                }
            });
            return;
        }
        boolean z = true;
        if (dVar.ky() != null) {
            dVar.ky().a(t, cVar);
        } else {
            List<com.tachikoma.lottie.model.d> listA = a(dVar);
            for (int i = 0; i < listA.size(); i++) {
                listA.get(i).ky().a(t, cVar);
            }
            if (listA.isEmpty()) {
                z = false;
            }
        }
        if (z) {
            invalidateSelf();
            if (t == k.Ij) {
                setProgress(getProgress());
            }
        }
    }

    public final Bitmap Y(String str) {
        com.tachikoma.lottie.b.b bVarJI = jI();
        if (bVarJI != null) {
            return bVarJI.ac(str);
        }
        return null;
    }

    private com.tachikoma.lottie.b.b jI() {
        if (getCallback() == null) {
            return null;
        }
        com.tachikoma.lottie.b.b bVar = this.Hm;
        if (bVar != null && !bVar.w(getContext())) {
            this.Hm = null;
        }
        if (this.Hm == null) {
            this.Hm = new com.tachikoma.lottie.b.b(getCallback(), this.GI, this.Hn, this.GD.jz());
        }
        return this.Hm;
    }

    public final Typeface o(String str, String str2) {
        com.tachikoma.lottie.b.a aVarJJ = jJ();
        if (aVarJJ != null) {
            return aVarJJ.o(str, str2);
        }
        return null;
    }

    private com.tachikoma.lottie.b.a jJ() {
        if (getCallback() == null) {
            return null;
        }
        if (this.Ho == null) {
            this.Ho = new com.tachikoma.lottie.b.a(getCallback(), this.Hp);
        }
        return this.Ho;
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

    private float f(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.GD.getBounds().width(), canvas.getHeight() / this.GD.getBounds().height());
    }
}
