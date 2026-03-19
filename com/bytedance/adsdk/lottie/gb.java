package com.bytedance.adsdk.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.c.de;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb extends Drawable implements Animatable, Drawable.Callback {
    private boolean an;
    jh b;
    private Rect ba;
    private Matrix bc;
    private an c;
    private Map<String, Typeface> cb;
    String d;
    private sy dc;
    private boolean de;
    private com.bytedance.adsdk.lottie.hc.d e;
    private Rect fs;
    private boolean gb;
    private boolean h;
    b hc;
    private boolean he;
    private Matrix hv;
    private Canvas j;
    private com.bytedance.adsdk.lottie.model.layer.c jh;
    private c k;
    private final ValueAnimator.AnimatorUpdateListener mk;
    private com.bytedance.adsdk.lottie.hc.hc mq;
    private RectF mt;
    private boolean np;
    private boolean nv;
    private RectF r;
    private boolean rf;
    private Rect s;
    private int sy;
    private final ArrayList<d> tc;
    private LottieAnimationView tr;
    private hc tt;
    private final com.bytedance.adsdk.lottie.u.an u;
    private String uo;
    private RectF us;
    private boolean v;
    private final Matrix vv;
    private boolean w;
    private rf yi;
    private boolean yo;
    private Paint z;
    private Bitmap zw;

    private interface d {
        void d(an anVar);
    }

    private enum hc {
        NONE,
        PLAY,
        RESUME
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public gb(LottieAnimationView lottieAnimationView) {
        com.bytedance.adsdk.lottie.u.an anVar = new com.bytedance.adsdk.lottie.u.an();
        this.u = anVar;
        this.an = true;
        this.h = false;
        this.gb = false;
        this.tt = hc.NONE;
        this.tc = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.gb.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (gb.this.jh != null) {
                    gb.this.jh.d(gb.this.u.an());
                }
            }
        };
        this.mk = animatorUpdateListener;
        this.yo = false;
        this.rf = true;
        this.sy = 255;
        this.yi = rf.AUTOMATIC;
        this.he = false;
        this.vv = new Matrix();
        this.nv = false;
        this.tr = lottieAnimationView;
        anVar.addUpdateListener(animatorUpdateListener);
    }

    public void d(sy syVar) {
        this.dc = syVar;
    }

    public sy d() {
        return this.dc;
    }

    public LottieAnimationView hc() {
        return this.tr;
    }

    public void d(boolean z, Context context) {
        if (this.w == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            com.bytedance.adsdk.lottie.u.u.hc("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.w = z;
        if (this.c != null) {
            d(context);
        }
    }

    public void d(boolean z) {
        if (z != this.rf) {
            this.rf = z;
            com.bytedance.adsdk.lottie.model.layer.c cVar = this.jh;
            if (cVar != null) {
                cVar.hc(z);
            }
            invalidateSelf();
        }
    }

    public com.bytedance.adsdk.lottie.model.layer.c b() {
        return this.jh;
    }

    public boolean c() {
        return this.rf;
    }

    public void d(String str) {
        this.uo = str;
    }

    public String u() {
        return this.uo;
    }

    public void hc(boolean z) {
        this.yo = z;
    }

    public boolean an() {
        return this.yo;
    }

    public boolean d(an anVar, Context context) {
        if (this.c == anVar) {
            return false;
        }
        this.nv = true;
        mk();
        this.c = anVar;
        d(context);
        this.u.d(anVar);
        c(this.u.getAnimatedFraction());
        Iterator it = new ArrayList(this.tc).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar != null) {
                dVar.d(anVar);
            }
            it.remove();
        }
        this.tc.clear();
        anVar.hc(this.de);
        z();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void d(rf rfVar) {
        this.yi = rfVar;
        z();
    }

    public rf h() {
        return this.he ? rf.SOFTWARE : rf.HARDWARE;
    }

    private void z() {
        an anVar = this.c;
        if (anVar == null) {
            return;
        }
        this.he = this.yi.d(Build.VERSION.SDK_INT, anVar.d(), anVar.hc());
    }

    public boolean gb() {
        return this.he;
    }

    public void b(boolean z) {
        this.de = z;
        an anVar = this.c;
        if (anVar != null) {
            anVar.hc(z);
        }
    }

    public void c(boolean z) {
        if (this.v == z) {
            return;
        }
        this.v = z;
        com.bytedance.adsdk.lottie.model.layer.c cVar = this.jh;
        if (cVar != null) {
            cVar.d(z);
        }
    }

    public yo tt() {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.b();
        }
        return null;
    }

    public void u(boolean z) {
        this.np = z;
    }

    public boolean tc() {
        return this.np;
    }

    private void d(Context context) {
        an anVar = this.c;
        if (anVar == null) {
            return;
        }
        com.bytedance.adsdk.lottie.model.layer.c cVar = this.jh;
        if (cVar != null) {
            d(cVar);
        }
        com.bytedance.adsdk.lottie.model.layer.c cVar2 = new com.bytedance.adsdk.lottie.model.layer.c(this, de.d(anVar), anVar.k(), anVar, context);
        this.jh = cVar2;
        if (this.v) {
            cVar2.d(true);
        }
        this.jh.hc(this.rf);
    }

    private void d(com.bytedance.adsdk.lottie.model.layer.c cVar) {
        if (cVar != null) {
            cVar.b();
            List<com.bytedance.adsdk.lottie.model.layer.b> listK = cVar.k();
            if (listK != null) {
                for (com.bytedance.adsdk.lottie.model.layer.b bVar : listK) {
                    if (bVar instanceof com.bytedance.adsdk.lottie.model.layer.c) {
                        d((com.bytedance.adsdk.lottie.model.layer.c) bVar);
                    } else if (bVar != null) {
                        bVar.b();
                    }
                }
            }
        }
    }

    public void mk() {
        if (this.u.isRunning()) {
            this.u.cancel();
            if (!isVisible()) {
                this.tt = hc.NONE;
            }
        }
        this.c = null;
        com.bytedance.adsdk.lottie.model.layer.c cVar = this.jh;
        if (cVar != null) {
            d(cVar);
        }
        this.jh = null;
        this.mq = null;
        this.u.gb();
        invalidateSelf();
    }

    public void an(boolean z) {
        this.gb = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.nv) {
            return;
        }
        this.nv = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.sy = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.sy;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.bytedance.adsdk.lottie.u.u.hc("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        u.d("Drawable#draw");
        try {
            if (this.he) {
                d(canvas, this.jh);
            } else {
                d(canvas);
            }
        } catch (Throwable th) {
            com.bytedance.adsdk.lottie.u.u.hc("Lottie crashed in draw!", th);
        }
        this.nv = false;
        u.hc("Drawable#draw");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        mq();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        uo();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return v();
    }

    public void mq() {
        if (this.jh == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.6
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar) {
                    gb.this.mq();
                }
            });
            return;
        }
        z();
        if (fs() || de() == 0) {
            if (isVisible()) {
                this.u.mk();
                this.tt = hc.NONE;
            } else {
                this.tt = hc.PLAY;
            }
        }
        if (fs()) {
            return;
        }
        b((int) (w() < 0.0f ? e() : cb()));
        this.u.mq();
        if (isVisible()) {
            return;
        }
        this.tt = hc.NONE;
    }

    public void uo() {
        this.tc.clear();
        this.u.mq();
        if (isVisible()) {
            return;
        }
        this.tt = hc.NONE;
    }

    public void k() {
        if (this.jh == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.7
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar) {
                    gb.this.k();
                }
            });
            return;
        }
        z();
        if (fs() || de() == 0) {
            if (isVisible()) {
                this.u.k();
                this.tt = hc.NONE;
            } else {
                this.tt = hc.RESUME;
            }
        }
        if (fs()) {
            return;
        }
        b((int) (w() < 0.0f ? e() : cb()));
        this.u.mq();
        if (isVisible()) {
            return;
        }
        this.tt = hc.NONE;
    }

    public void d(final int i) {
        if (this.c == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.8
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar) {
                    gb.this.d(i);
                }
            });
        } else {
            this.u.d(i);
        }
    }

    public float e() {
        return this.u.e();
    }

    public void d(final float f) {
        an anVar = this.c;
        if (anVar == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.9
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar2) {
                    gb.this.d(f);
                }
            });
        } else {
            d((int) com.bytedance.adsdk.lottie.u.gb.d(anVar.an(), this.c.h(), f));
        }
    }

    public void hc(final int i) {
        if (this.c == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.10
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar) {
                    gb.this.hc(i);
                }
            });
        } else {
            this.u.hc(i + 0.99f);
        }
    }

    public float cb() {
        return this.u.cb();
    }

    public void hc(final float f) {
        an anVar = this.c;
        if (anVar == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.11
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar2) {
                    gb.this.hc(f);
                }
            });
        } else {
            this.u.hc(com.bytedance.adsdk.lottie.u.gb.d(anVar.an(), this.c.h(), f));
        }
    }

    public void hc(final String str) {
        an anVar = this.c;
        if (anVar == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.12
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar2) {
                    gb.this.hc(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.an anVarB = anVar.b(str);
        if (anVarB == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        d((int) anVarB.d);
    }

    public void b(final String str) {
        an anVar = this.c;
        if (anVar == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.13
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar2) {
                    gb.this.b(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.an anVarB = anVar.b(str);
        if (anVarB == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        hc((int) (anVarB.d + anVarB.hc));
    }

    public void c(final String str) {
        an anVar = this.c;
        if (anVar == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.2
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar2) {
                    gb.this.c(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.an anVarB = anVar.b(str);
        if (anVarB == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i = (int) anVarB.d;
        d(i, ((int) anVarB.hc) + i);
    }

    public void d(final int i, final int i2) {
        if (this.c == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.3
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar) {
                    gb.this.d(i, i2);
                }
            });
        } else {
            this.u.d(i, i2 + 0.99f);
        }
    }

    public void b(float f) {
        this.u.b(f);
    }

    public float w() {
        return this.u.tc();
    }

    public void d(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.u.addUpdateListener(animatorUpdateListener);
    }

    public void hc(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.u.removeUpdateListener(animatorUpdateListener);
    }

    public void yo() {
        this.u.removeAllUpdateListeners();
        this.u.addUpdateListener(this.mk);
    }

    public void d(Animator.AnimatorListener animatorListener) {
        this.u.addListener(animatorListener);
    }

    public void hc(Animator.AnimatorListener animatorListener) {
        this.u.removeListener(animatorListener);
    }

    public void rf() {
        this.u.removeAllListeners();
    }

    public void b(final int i) {
        if (this.c == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.4
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar) {
                    gb.this.b(i);
                }
            });
        } else {
            this.u.d(i);
        }
    }

    public int jh() {
        return (int) this.u.h();
    }

    public void c(final float f) {
        if (this.c == null) {
            this.tc.add(new d() { // from class: com.bytedance.adsdk.lottie.gb.5
                @Override // com.bytedance.adsdk.lottie.gb.d
                public void d(an anVar) {
                    gb.this.c(f);
                }
            });
            return;
        }
        u.d("Drawable#setProgress");
        this.u.d(this.c.d(f));
        u.hc("Drawable#setProgress");
    }

    public void c(int i) {
        this.u.setRepeatMode(i);
    }

    public int sy() {
        return this.u.getRepeatMode();
    }

    public void u(int i) {
        this.u.setRepeatCount(i);
    }

    public int de() {
        return this.u.getRepeatCount();
    }

    public boolean v() {
        com.bytedance.adsdk.lottie.u.an anVar = this.u;
        if (anVar == null) {
            return false;
        }
        return anVar.isRunning();
    }

    boolean np() {
        if (isVisible()) {
            return this.u.isRunning();
        }
        return this.tt == hc.PLAY || this.tt == hc.RESUME;
    }

    private boolean fs() {
        return this.an || this.h;
    }

    public void d(Boolean bool) {
        this.an = bool.booleanValue();
    }

    public void h(boolean z) {
        this.h = z;
    }

    public void gb(boolean z) {
        this.u.b(z);
    }

    public void d(c cVar) {
        this.k = cVar;
        com.bytedance.adsdk.lottie.hc.hc hcVar = this.mq;
        if (hcVar != null) {
            hcVar.d(cVar);
        }
    }

    public void d(b bVar) {
        this.hc = bVar;
        com.bytedance.adsdk.lottie.hc.d dVar = this.e;
        if (dVar != null) {
            dVar.d(bVar);
        }
    }

    public void d(Map<String, Typeface> map) {
        if (map == this.cb) {
            return;
        }
        this.cb = map;
        invalidateSelf();
    }

    public void d(jh jhVar) {
        this.b = jhVar;
    }

    public jh yi() {
        return this.b;
    }

    public boolean he() {
        return this.cb == null && this.b == null && this.c.e().size() > 0;
    }

    public an vv() {
        return this.c;
    }

    public void zw() {
        this.tc.clear();
        this.u.cancel();
        if (isVisible()) {
            return;
        }
        this.tt = hc.NONE;
    }

    public void j() {
        this.tc.clear();
        this.u.uo();
        if (isVisible()) {
            return;
        }
        this.tt = hc.NONE;
    }

    public float s() {
        return this.u.an();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        an anVar = this.c;
        if (anVar == null) {
            return -1;
        }
        return anVar.c().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        an anVar = this.c;
        if (anVar == null) {
            return -1;
        }
        return anVar.c().height();
    }

    public Bitmap d(String str, Bitmap bitmap) {
        com.bytedance.adsdk.lottie.hc.hc hcVarBa = ba();
        if (hcVarBa == null) {
            com.bytedance.adsdk.lottie.u.u.hc("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapD = hcVarBa.d(str, bitmap);
        invalidateSelf();
        return bitmapD;
    }

    public Bitmap u(String str) {
        com.bytedance.adsdk.lottie.hc.hc hcVarBa = ba();
        if (hcVarBa != null) {
            return hcVarBa.d(str);
        }
        return null;
    }

    public tt an(String str) {
        an anVar = this.c;
        if (anVar == null) {
            return null;
        }
        return anVar.w().get(str);
    }

    private com.bytedance.adsdk.lottie.hc.hc ba() {
        com.bytedance.adsdk.lottie.hc.hc hcVar = this.mq;
        if (hcVar != null && !hcVar.d(getContext())) {
            this.mq = null;
        }
        if (this.mq == null) {
            this.mq = new com.bytedance.adsdk.lottie.hc.hc(getCallback(), this.uo, this.k, this.c.w());
        }
        return this.mq;
    }

    public Typeface d(com.bytedance.adsdk.lottie.model.b bVar) {
        Map<String, Typeface> map = this.cb;
        if (map != null) {
            String strD = bVar.d();
            if (map.containsKey(strD)) {
                return map.get(strD);
            }
            String strHc = bVar.hc();
            if (map.containsKey(strHc)) {
                return map.get(strHc);
            }
            String str = bVar.d() + "-" + bVar.b();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.bytedance.adsdk.lottie.hc.d dVarMt = mt();
        if (dVarMt != null) {
            return dVarMt.d(bVar);
        }
        return null;
    }

    private com.bytedance.adsdk.lottie.hc.d mt() {
        if (getCallback() == null) {
            return null;
        }
        if (this.e == null) {
            com.bytedance.adsdk.lottie.hc.d dVar = new com.bytedance.adsdk.lottie.hc.d(getCallback(), this.hc);
            this.e = dVar;
            String str = this.d;
            if (str != null) {
                dVar.d(str);
            }
        }
        return this.e;
    }

    public void h(String str) {
        this.d = str;
        com.bytedance.adsdk.lottie.hc.d dVarMt = mt();
        if (dVarMt != null) {
            dVarMt.d(str);
        }
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = !isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            if (this.tt == hc.PLAY) {
                mq();
            } else if (this.tt == hc.RESUME) {
                k();
            }
        } else if (this.u.isRunning()) {
            j();
            this.tt = hc.RESUME;
        } else if (!z3) {
            this.tt = hc.NONE;
        }
        return visible;
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

    private void d(Canvas canvas) {
        com.bytedance.adsdk.lottie.model.layer.c cVar = this.jh;
        an anVar = this.c;
        if (cVar == null || anVar == null) {
            return;
        }
        this.vv.reset();
        if (!getBounds().isEmpty()) {
            this.vv.preScale(r2.width() / anVar.c().width(), r2.height() / anVar.c().height());
            this.vv.preTranslate(r2.left, r2.top);
        }
        cVar.d(canvas, this.vv, this.sy);
    }

    public RectF us() {
        return this.r;
    }

    private void d(Canvas canvas, com.bytedance.adsdk.lottie.model.layer.c cVar) {
        if (this.c == null || cVar == null) {
            return;
        }
        r();
        canvas.getMatrix(this.hv);
        canvas.getClipBounds(this.s);
        d(this.s, this.us);
        this.hv.mapRect(this.us);
        d(this.us, this.s);
        if (this.rf) {
            this.r.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            cVar.d(this.r, (Matrix) null, false);
        }
        this.hv.mapRect(this.r);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        d(this.r, fWidth, fHeight);
        if (!hv()) {
            this.r.intersect(this.s.left, this.s.top, this.s.right, this.s.bottom);
        }
        int iCeil = (int) Math.ceil(this.r.width());
        int iCeil2 = (int) Math.ceil(this.r.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        hc(iCeil, iCeil2);
        if (this.nv) {
            this.vv.set(this.hv);
            this.vv.preScale(fWidth, fHeight);
            this.vv.postTranslate(-this.r.left, -this.r.top);
            this.zw.eraseColor(0);
            cVar.d(this.j, this.vv, this.sy);
            this.hv.invert(this.bc);
            this.bc.mapRect(this.mt, this.r);
            d(this.mt, this.ba);
        }
        this.fs.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.zw, this.fs, this.ba, this.z);
    }

    private void r() {
        if (this.j != null) {
            return;
        }
        this.j = new Canvas();
        this.r = new RectF();
        this.hv = new Matrix();
        this.bc = new Matrix();
        this.s = new Rect();
        this.us = new RectF();
        this.z = new com.bytedance.adsdk.lottie.d.d();
        this.fs = new Rect();
        this.ba = new Rect();
        this.mt = new RectF();
    }

    private void hc(int i, int i2) {
        Bitmap bitmap = this.zw;
        if (bitmap == null || bitmap.getWidth() < i || this.zw.getHeight() < i2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.zw = bitmapCreateBitmap;
            this.j.setBitmap(bitmapCreateBitmap);
            this.nv = true;
            return;
        }
        if (this.zw.getWidth() > i || this.zw.getHeight() > i2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.zw, 0, 0, i, i2);
            this.zw = bitmapCreateBitmap2;
            this.j.setBitmap(bitmapCreateBitmap2);
            this.nv = true;
        }
    }

    private void d(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void d(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void d(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    private boolean hv() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return Build.VERSION.SDK_INT >= 18 && (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }
}
