package com.component.lottie;

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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class af extends Drawable implements Animatable, Drawable.Callback {
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = -1;
    private Bitmap C;
    private Canvas D;
    private Rect E;
    private RectF F;
    private Paint G;
    private Rect H;
    private Rect I;
    private RectF J;

    /* renamed from: K, reason: collision with root package name */
    private RectF f758K;
    private Matrix L;
    private Matrix M;
    com.component.lottie.a a;
    bj b;
    private t f;
    private com.component.lottie.c.b n;
    private String o;
    private com.component.lottie.b p;
    private com.component.lottie.c.a q;
    private boolean r;
    private com.component.lottie.d.c.d u;
    private boolean w;
    private boolean x;
    private boolean y;
    private final com.component.lottie.g.d g = new com.component.lottie.g.d();
    private boolean h = true;
    private boolean i = false;
    private boolean j = false;
    private b k = b.NONE;
    private final ArrayList<a> l = new ArrayList<>();
    private final ValueAnimator.AnimatorUpdateListener m = new ag(this);
    private boolean s = false;
    private boolean t = true;
    private int v = 255;
    private bg z = bg.AUTOMATIC;
    private boolean A = false;
    private final Matrix B = new Matrix();
    private boolean N = false;

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
        void a(t tVar);
    }

    private enum b {
        NONE,
        PLAY,
        RESUME
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public af() {
        this.g.addUpdateListener(this.m);
    }

    public boolean a() {
        return this.u != null && this.u.h();
    }

    public boolean b() {
        return this.u != null && this.u.i();
    }

    public boolean c() {
        return this.r;
    }

    public void a(boolean z) {
        if (this.r == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            com.component.lottie.g.c.b("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.r = z;
        if (this.f != null) {
            H();
        }
    }

    public boolean d() {
        return this.r;
    }

    public void b(boolean z) {
        if (z != this.t) {
            this.t = z;
            com.component.lottie.d.c.d dVar = this.u;
            if (dVar != null) {
                dVar.b(z);
            }
            invalidateSelf();
        }
    }

    public boolean e() {
        return this.t;
    }

    public void a(String str) {
        this.o = str;
    }

    public String f() {
        return this.o;
    }

    public void c(boolean z) {
        this.s = z;
    }

    public boolean g() {
        return this.s;
    }

    public boolean a(t tVar) {
        if (this.f == tVar) {
            return false;
        }
        this.N = true;
        k();
        this.f = tVar;
        H();
        this.g.a(tVar);
        d(this.g.getAnimatedFraction());
        Iterator it = new ArrayList(this.l).iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.a(tVar);
            }
            it.remove();
        }
        this.l.clear();
        tVar.b(this.w);
        G();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void a(bg bgVar) {
        this.z = bgVar;
        G();
    }

    public bg h() {
        return this.A ? bg.SOFTWARE : bg.HARDWARE;
    }

    private void G() {
        t tVar = this.f;
        if (tVar == null) {
            return;
        }
        this.A = this.z.a(com.baidu.mobads.container.util.x.a(null).a(), tVar.a(), tVar.b());
    }

    public void d(boolean z) {
        this.w = z;
        if (this.f != null) {
            this.f.b(z);
        }
    }

    public void e(boolean z) {
        if (this.x == z) {
            return;
        }
        this.x = z;
        if (this.u != null) {
            this.u.a(z);
        }
    }

    public be i() {
        if (this.f != null) {
            return this.f.d();
        }
        return null;
    }

    public void f(boolean z) {
        this.y = z;
    }

    public boolean j() {
        return this.y;
    }

    private void H() {
        t tVar = this.f;
        if (tVar == null) {
            return;
        }
        this.u = new com.component.lottie.d.c.d(this, com.component.lottie.f.w.a(tVar), tVar.j(), tVar);
        if (this.x) {
            this.u.a(true);
        }
        this.u.b(this.t);
    }

    public void k() {
        if (this.g.isRunning()) {
            this.g.cancel();
            if (!isVisible()) {
                this.k = b.NONE;
            }
        }
        this.f = null;
        this.u = null;
        this.n = null;
        this.g.g();
        invalidateSelf();
    }

    public void g(boolean z) {
        this.j = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.N) {
            return;
        }
        this.N = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.v = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.v;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.component.lottie.g.c.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.component.lottie.c.a("Drawable#draw");
        if (this.j) {
            try {
                if (this.A) {
                    a(canvas, this.u);
                } else {
                    a(canvas);
                }
            } catch (Throwable th) {
                com.component.lottie.g.c.c("Lottie crashed in draw!", th);
            }
        } else if (this.A) {
            a(canvas, this.u);
        } else {
            a(canvas);
        }
        this.N = false;
        com.component.lottie.c.b("Drawable#draw");
    }

    public void a(Canvas canvas, Matrix matrix) {
        com.component.lottie.d.c.d dVar = this.u;
        t tVar = this.f;
        if (dVar == null || tVar == null) {
            return;
        }
        if (this.A) {
            canvas.save();
            canvas.concat(matrix);
            a(canvas, dVar);
            canvas.restore();
        } else {
            dVar.a(canvas, matrix, this.v);
        }
        this.N = false;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && !((View) callback).isInEditMode()) {
            l();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        m();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return y();
    }

    public void l() {
        if (this.u == null) {
            this.l.add(new ap(this));
            return;
        }
        G();
        if (I() || w() == 0) {
            if (isVisible()) {
                this.g.j();
            } else {
                this.k = b.PLAY;
            }
        }
        if (!I()) {
            c((int) (r() < 0.0f ? o() : p()));
            this.g.k();
            if (!isVisible()) {
                this.k = b.NONE;
            }
        }
    }

    public void m() {
        this.l.clear();
        this.g.k();
        if (!isVisible()) {
            this.k = b.NONE;
        }
    }

    public void n() {
        if (this.u == null) {
            this.l.add(new aq(this));
            return;
        }
        G();
        if (I() || w() == 0) {
            if (isVisible()) {
                this.g.m();
            } else {
                this.k = b.RESUME;
            }
        }
        if (!I()) {
            c((int) (r() < 0.0f ? o() : p()));
            this.g.k();
            if (!isVisible()) {
                this.k = b.NONE;
            }
        }
    }

    public void a(int i) {
        if (this.f == null) {
            this.l.add(new ar(this, i));
        } else {
            this.g.a(i);
        }
    }

    public void b(String str) {
        if (this.f == null) {
            this.l.add(new as(this, str));
            return;
        }
        com.component.lottie.d.g gVarC = this.f.c(str);
        if (gVarC == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        a((int) gVarC.a);
    }

    public float o() {
        return this.g.n();
    }

    public void b(int i) {
        if (this.f == null) {
            this.l.add(new at(this, i));
        } else {
            this.g.b(i + 0.99f);
        }
    }

    public void c(String str) {
        if (this.f == null) {
            this.l.add(new au(this, str));
            return;
        }
        com.component.lottie.d.g gVarC = this.f.c(str);
        if (gVarC == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        b((int) (gVarC.a + gVarC.b));
    }

    public float p() {
        return this.g.o();
    }

    public void d(String str) {
        if (this.f == null) {
            this.l.add(new av(this, str));
            return;
        }
        com.component.lottie.d.g gVarC = this.f.c(str);
        if (gVarC == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i = (int) gVarC.a;
        a(i, ((int) gVarC.b) + i);
    }

    public void a(String str, String str2, boolean z) {
        if (this.f == null) {
            this.l.add(new aw(this, str, str2, z));
            return;
        }
        com.component.lottie.d.g gVarC = this.f.c(str);
        if (gVarC == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i = (int) gVarC.a;
        com.component.lottie.d.g gVarC2 = this.f.c(str2);
        if (gVarC2 == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        a(i, (int) (gVarC2.a + (z ? 1.0f : 0.0f)));
    }

    public void a(int i, int i2) {
        if (this.f == null) {
            this.l.add(new ah(this, i, i2));
        } else {
            this.g.a(i, i2 + 0.99f);
        }
    }

    public void a(float f) {
        if (this.f == null) {
            this.l.add(new ai(this, f));
        } else {
            a((int) com.component.lottie.g.f.a(this.f.g(), this.f.h(), f));
        }
    }

    public void b(float f) {
        if (this.f == null) {
            this.l.add(new aj(this, f));
        } else {
            b((int) com.component.lottie.g.f.a(this.f.g(), this.f.h(), f));
        }
    }

    public void a(float f, float f2) {
        if (this.f == null) {
            this.l.add(new ak(this, f, f2));
        } else {
            a((int) com.component.lottie.g.f.a(this.f.g(), this.f.h(), f), (int) com.component.lottie.g.f.a(this.f.g(), this.f.h(), f2));
        }
    }

    public void q() {
        this.g.h();
    }

    public void c(float f) {
        this.g.c(f);
    }

    public float r() {
        return this.g.i();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.g.addUpdateListener(animatorUpdateListener);
    }

    public void b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.g.removeUpdateListener(animatorUpdateListener);
    }

    public void s() {
        this.g.removeAllUpdateListeners();
        this.g.addUpdateListener(this.m);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.g.addListener(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.g.removeListener(animatorListener);
    }

    public void t() {
        this.g.removeAllListeners();
    }

    public void a(Animator.AnimatorPauseListener animatorPauseListener) {
        this.g.addPauseListener(animatorPauseListener);
    }

    public void b(Animator.AnimatorPauseListener animatorPauseListener) {
        this.g.removePauseListener(animatorPauseListener);
    }

    public void c(int i) {
        if (this.f == null) {
            this.l.add(new al(this, i));
        } else {
            this.g.a(i);
        }
    }

    public int u() {
        return (int) this.g.f();
    }

    public void d(float f) {
        if (this.f == null) {
            this.l.add(new am(this, f));
            return;
        }
        com.component.lottie.c.a("Drawable#setProgress");
        this.g.a(this.f.a(f));
        com.component.lottie.c.b("Drawable#setProgress");
    }

    @Deprecated
    public void h(boolean z) {
        this.g.setRepeatCount(z ? -1 : 0);
    }

    public void d(int i) {
        this.g.setRepeatMode(i);
    }

    public int v() {
        return this.g.getRepeatMode();
    }

    public void e(int i) {
        this.g.setRepeatCount(i);
    }

    public int w() {
        return this.g.getRepeatCount();
    }

    public boolean x() {
        return this.g.getRepeatCount() == -1;
    }

    public boolean y() {
        if (this.g == null) {
            return false;
        }
        return this.g.isRunning();
    }

    boolean z() {
        if (isVisible()) {
            return this.g.isRunning();
        }
        return this.k == b.PLAY || this.k == b.RESUME;
    }

    private boolean I() {
        return this.h || this.i;
    }

    void a(Boolean bool) {
        this.h = bool.booleanValue();
    }

    public void i(boolean z) {
        this.i = z;
    }

    public void a(com.component.lottie.b bVar) {
        this.p = bVar;
        if (this.n != null) {
            this.n.a(bVar);
        }
    }

    public void a(com.component.lottie.a aVar) {
        this.a = aVar;
        if (this.q != null) {
            this.q.a(aVar);
        }
    }

    public void a(bj bjVar) {
        this.b = bjVar;
    }

    public bj A() {
        return this.b;
    }

    public boolean B() {
        return this.b == null && this.f.k().b() > 0;
    }

    public t C() {
        return this.f;
    }

    public void D() {
        this.l.clear();
        this.g.cancel();
        if (!isVisible()) {
            this.k = b.NONE;
        }
    }

    public void E() {
        this.l.clear();
        this.g.l();
        if (!isVisible()) {
            this.k = b.NONE;
        }
    }

    public float F() {
        return this.g.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f == null) {
            return -1;
        }
        return this.f.e().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f == null) {
            return -1;
        }
        return this.f.e().height();
    }

    public List<com.component.lottie.d.e> a(com.component.lottie.d.e eVar) {
        if (this.u == null) {
            com.component.lottie.g.c.b("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.u.a(eVar, 0, arrayList, new com.component.lottie.d.e(new String[0]));
        return arrayList;
    }

    public <T> void a(com.component.lottie.d.e eVar, T t, com.component.lottie.h.j<T> jVar) {
        if (this.u == null) {
            this.l.add(new an(this, eVar, t, jVar));
            return;
        }
        boolean zIsEmpty = true;
        if (eVar == com.component.lottie.d.e.a) {
            this.u.a((com.component.lottie.d.c.d) t, (com.component.lottie.h.j<com.component.lottie.d.c.d>) jVar);
        } else if (eVar.a() != null) {
            eVar.a().a(t, jVar);
        } else {
            List<com.component.lottie.d.e> listA = a(eVar);
            for (int i = 0; i < listA.size(); i++) {
                listA.get(i).a().a(t, jVar);
            }
            zIsEmpty = true ^ listA.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == ba.E) {
                d(F());
            }
        }
    }

    public <T> void a(com.component.lottie.d.e eVar, T t, com.component.lottie.h.l<T> lVar) {
        a(eVar, (com.component.lottie.d.e) t, (com.component.lottie.h.j<com.component.lottie.d.e>) new ao(this, lVar));
    }

    public Bitmap a(String str, Bitmap bitmap) {
        com.component.lottie.c.b bVarJ = J();
        if (bVarJ == null) {
            com.component.lottie.g.c.b("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapA = bVarJ.a(str, bitmap);
        invalidateSelf();
        return bitmapA;
    }

    @Deprecated
    public Bitmap e(String str) {
        com.component.lottie.c.b bVarJ = J();
        if (bVarJ != null) {
            return bVarJ.b(str);
        }
        ax axVar = this.f == null ? null : this.f.o().get(str);
        if (axVar != null) {
            return axVar.f();
        }
        return null;
    }

    public Bitmap f(String str) {
        com.component.lottie.c.b bVarJ = J();
        if (bVarJ != null) {
            return bVarJ.b(str);
        }
        return null;
    }

    public ax g(String str) {
        t tVar = this.f;
        if (tVar == null) {
            return null;
        }
        return tVar.o().get(str);
    }

    private com.component.lottie.c.b J() {
        if (getCallback() == null) {
            return null;
        }
        if (this.n != null && !this.n.a(L())) {
            this.n = null;
        }
        if (this.n == null) {
            this.n = new com.component.lottie.c.b(getCallback(), this.o, this.p, this.f.o());
        }
        return this.n;
    }

    public Typeface a(String str, String str2) {
        com.component.lottie.c.a aVarK = K();
        if (aVarK != null) {
            return aVarK.a(str, str2);
        }
        return null;
    }

    private com.component.lottie.c.a K() {
        if (getCallback() == null) {
            return null;
        }
        if (this.q == null) {
            this.q = new com.component.lottie.c.a(getCallback(), this.a);
        }
        return this.q;
    }

    private Context L() {
        Drawable.Callback callback = getCallback();
        if (callback == null || !(callback instanceof View)) {
            return null;
        }
        return ((View) callback).getContext();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = !isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            if (this.k == b.PLAY) {
                l();
            } else if (this.k == b.RESUME) {
                n();
            }
        } else if (this.g.isRunning()) {
            E();
            this.k = b.RESUME;
        } else if (!z3) {
            this.k = b.NONE;
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

    private void a(Canvas canvas) {
        com.component.lottie.d.c.d dVar = this.u;
        t tVar = this.f;
        if (dVar == null || tVar == null) {
            return;
        }
        this.B.reset();
        if (!getBounds().isEmpty()) {
            this.B.preScale(r2.width() / tVar.e().width(), r2.height() / tVar.e().height());
        }
        dVar.a(canvas, this.B, this.v);
    }

    private void a(Canvas canvas, com.component.lottie.d.c.d dVar) {
        if (this.f == null || dVar == null) {
            return;
        }
        M();
        canvas.getMatrix(this.L);
        canvas.getClipBounds(this.E);
        a(this.E, this.F);
        this.L.mapRect(this.F);
        a(this.F, this.E);
        if (this.t) {
            this.f758K.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            dVar.a(this.f758K, (Matrix) null, false);
        }
        this.L.mapRect(this.f758K);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        a(this.f758K, fWidth, fHeight);
        if (!N()) {
            this.f758K.intersect(this.E.left, this.E.top, this.E.right, this.E.bottom);
        }
        int iCeil = (int) Math.ceil(this.f758K.width());
        int iCeil2 = (int) Math.ceil(this.f758K.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        b(iCeil, iCeil2);
        if (this.N) {
            this.B.set(this.L);
            this.B.preScale(fWidth, fHeight);
            this.B.postTranslate(-this.f758K.left, -this.f758K.top);
            this.C.eraseColor(0);
            dVar.a(this.D, this.B, this.v);
            this.L.invert(this.M);
            this.M.mapRect(this.J, this.f758K);
            a(this.J, this.I);
        }
        this.H.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.C, this.H, this.I, this.G);
    }

    private void M() {
        if (this.D != null) {
            return;
        }
        this.D = new Canvas();
        this.f758K = new RectF();
        this.L = new Matrix();
        this.M = new Matrix();
        this.E = new Rect();
        this.F = new RectF();
        this.G = new com.component.lottie.a.a();
        this.H = new Rect();
        this.I = new Rect();
        this.J = new RectF();
    }

    private void b(int i, int i2) {
        if (this.C == null || this.C.getWidth() < i || this.C.getHeight() < i2) {
            this.C = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.D.setBitmap(this.C);
            this.N = true;
        } else if (this.C.getWidth() > i || this.C.getHeight() > i2) {
            this.C = Bitmap.createBitmap(this.C, 0, 0, i, i2);
            this.D.setBitmap(this.C);
            this.N = true;
        }
    }

    private void a(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void a(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void a(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    private boolean N() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        if (Build.VERSION.SDK_INT < 18 || !(parent instanceof ViewGroup)) {
            return false;
        }
        return !((ViewGroup) parent).getClipChildren();
    }
}
