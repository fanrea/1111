package com.component.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class LottieAnimationView extends ImageView {
    private static final String a = LottieAnimationView.class.getSimpleName();
    private static final ay<Throwable> b = new e();
    private final ay<t> c;
    private final ay<Throwable> d;
    private ay<Throwable> e;
    private int f;
    private final af g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private final Set<a> l;
    private final Set<az> m;
    private bc<t> n;
    private t o;

    private enum a {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.c = new f(this);
        this.d = new g(this);
        this.f = 0;
        this.g = new af();
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = new HashSet();
        this.m = new HashSet();
        C();
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new f(this);
        this.d = new g(this);
        this.f = 0;
        this.g = new af();
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = new HashSet();
        this.m = new HashSet();
        C();
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new f(this);
        this.d = new g(this);
        this.f = 0;
        this.g = new af();
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = new HashSet();
        this.m = new HashSet();
        C();
    }

    private void C() {
        this.g.a(Boolean.valueOf(com.component.lottie.g.g.a(getContext()) != 0.0f));
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            a(new com.component.lottie.d.e("**"), (com.component.lottie.d.e) ba.f759K, (com.component.lottie.h.j<com.component.lottie.d.e>) new com.component.lottie.h.j(new bi(colorStateList.getDefaultColor())));
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        D();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        D();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        D();
        super.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        if (!this.i && drawable == this.g && this.g.y()) {
            t();
        } else if (!this.i && (drawable instanceof af)) {
            af afVar = (af) drawable;
            if (afVar.y()) {
                afVar.E();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof af) && ((af) drawable).h() == bg.SOFTWARE) {
            this.g.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (getDrawable() == this.g) {
            super.invalidateDrawable(this.g);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.h;
        savedState.b = this.g.F();
        savedState.c = this.g.z();
        savedState.d = this.g.f();
        savedState.e = this.g.v();
        savedState.f = this.g.w();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.h = savedState.a;
        if (!this.l.contains(a.SET_ANIMATION) && this.h != 0) {
            a(this.h);
        }
        if (!this.l.contains(a.SET_PROGRESS)) {
            d(savedState.b);
        }
        if (!this.l.contains(a.PLAY_OPTION) && savedState.c) {
            f();
        }
        if (!this.l.contains(a.SET_IMAGE_ASSETS)) {
            e(savedState.d);
        }
        if (!this.l.contains(a.SET_REPEAT_MODE)) {
            e(savedState.e);
        }
        if (!this.l.contains(a.SET_REPEAT_COUNT)) {
            f(savedState.f);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.j) {
            this.g.l();
        }
    }

    public void a(boolean z) {
        this.g.i(z);
    }

    public void b(boolean z) {
        this.g.a(z);
    }

    public boolean a() {
        return this.g.d();
    }

    public void c(boolean z) {
        this.g.b(z);
    }

    public boolean b() {
        return this.g.e();
    }

    public void d(boolean z) {
        this.k = z;
    }

    public void e(boolean z) {
        this.g.e(z);
    }

    public void a(int i) {
        this.h = i;
        a(h(i));
    }

    public void a(InputStream inputStream, String str) {
        a(u.a(inputStream, str));
    }

    private bc<t> h(int i) {
        if (isInEditMode()) {
            return new bc<>(new h(this, i), true);
        }
        if (this.k) {
            return u.a(getContext(), i);
        }
        return u.a(getContext(), i, (String) null);
    }

    @Deprecated
    public void a(String str) {
        a(str, (String) null);
    }

    public void a(String str, String str2) {
        a(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void a(ay<Throwable> ayVar) {
        this.e = ayVar;
    }

    public void b(int i) {
        this.f = i;
    }

    private void a(bc<t> bcVar) {
        this.l.add(a.SET_ANIMATION);
        E();
        D();
        this.n = bcVar.a(this.c).c(this.d);
    }

    private void D() {
        if (this.n != null) {
            this.n.b(this.c);
            this.n.d(this.d);
        }
    }

    public void a(t tVar) {
        if (c.a) {
            Log.v(a, "Set Composition \n" + tVar);
        }
        this.g.setCallback(this);
        this.o = tVar;
        this.i = true;
        boolean zA = this.g.a(tVar);
        this.i = false;
        if (getDrawable() == this.g && !zA) {
            return;
        }
        if (!zA) {
            F();
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator<az> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().a(tVar);
        }
    }

    public t c() {
        return this.o;
    }

    public boolean d() {
        return this.g.a();
    }

    public boolean e() {
        return this.g.b();
    }

    public void f() {
        this.l.add(a.PLAY_OPTION);
        this.g.l();
    }

    public void g() {
        this.l.add(a.PLAY_OPTION);
        this.g.n();
    }

    public void c(int i) {
        this.g.a(i);
    }

    public void b(String str) {
        this.g.b(str);
    }

    public float h() {
        return this.g.o();
    }

    public void d(int i) {
        this.g.b(i);
    }

    public void c(String str) {
        this.g.c(str);
    }

    public float i() {
        return this.g.p();
    }

    public void a(float f) {
        this.g.a(f);
    }

    public void b(float f) {
        this.g.b(f);
    }

    public void a(float f, float f2) {
        this.g.a(f, f2);
    }

    public void d(String str) {
        this.g.d(str);
    }

    public void a(String str, String str2, boolean z) {
        this.g.a(str, str2, z);
    }

    public void a(int i, int i2) {
        this.g.a(i, i2);
    }

    public void j() {
        this.g.q();
    }

    public void c(float f) {
        this.g.c(f);
    }

    public float k() {
        return this.g.r();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.g.a(animatorUpdateListener);
    }

    public void b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.g.b(animatorUpdateListener);
    }

    public void l() {
        this.g.s();
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.g.a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.g.b(animatorListener);
    }

    public void m() {
        this.g.t();
    }

    public void a(Animator.AnimatorPauseListener animatorPauseListener) {
        this.g.a(animatorPauseListener);
    }

    public void b(Animator.AnimatorPauseListener animatorPauseListener) {
        this.g.b(animatorPauseListener);
    }

    @Deprecated
    public void f(boolean z) {
        this.g.e(z ? -1 : 0);
    }

    public void e(int i) {
        this.l.add(a.SET_REPEAT_MODE);
        this.g.d(i);
    }

    public int n() {
        return this.g.v();
    }

    public void f(int i) {
        this.l.add(a.SET_REPEAT_COUNT);
        this.g.e(i);
    }

    public int o() {
        return this.g.w();
    }

    public boolean p() {
        return this.g.y();
    }

    public void e(String str) {
        this.g.a(str);
    }

    public String q() {
        return this.g.f();
    }

    public void g(boolean z) {
        this.g.c(z);
    }

    public boolean r() {
        return this.g.g();
    }

    public Bitmap a(String str, Bitmap bitmap) {
        return this.g.a(str, bitmap);
    }

    public void a(b bVar) {
        this.g.a(bVar);
    }

    public void a(com.component.lottie.a aVar) {
        this.g.a(aVar);
    }

    public void a(bj bjVar) {
        this.g.a(bjVar);
    }

    public List<com.component.lottie.d.e> a(com.component.lottie.d.e eVar) {
        return this.g.a(eVar);
    }

    public <T> void a(com.component.lottie.d.e eVar, T t, com.component.lottie.h.j<T> jVar) {
        this.g.a(eVar, (com.component.lottie.d.e) t, (com.component.lottie.h.j<com.component.lottie.d.e>) jVar);
    }

    public <T> void a(com.component.lottie.d.e eVar, T t, com.component.lottie.h.l<T> lVar) {
        this.g.a(eVar, (com.component.lottie.d.e) t, (com.component.lottie.h.j<com.component.lottie.d.e>) new i(this, lVar));
    }

    public void s() {
        this.l.add(a.PLAY_OPTION);
        this.g.D();
    }

    public void t() {
        this.j = false;
        this.g.E();
    }

    public void u() {
        this.l.add(a.PLAY_OPTION);
        this.g.m();
    }

    public void g(int i) {
        this.g.c(i);
    }

    public int v() {
        return this.g.u();
    }

    public void d(float f) {
        this.l.add(a.SET_PROGRESS);
        this.g.d(f);
    }

    public float w() {
        return this.g.F();
    }

    public long x() {
        if (this.o != null) {
            return (long) this.o.f();
        }
        return 0L;
    }

    public void h(boolean z) {
        this.g.d(z);
    }

    public be y() {
        return this.g.i();
    }

    private void E() {
        this.o = null;
        this.g.k();
    }

    public void i(boolean z) {
        this.g.g(z);
    }

    public void a(bg bgVar) {
        this.g.a(bgVar);
    }

    public bg z() {
        return this.g.h();
    }

    public void j(boolean z) {
        this.g.f(z);
    }

    public boolean a(az azVar) {
        t tVar = this.o;
        if (tVar != null) {
            azVar.a(tVar);
        }
        return this.m.add(azVar);
    }

    public boolean b(az azVar) {
        return this.m.remove(azVar);
    }

    public void A() {
        this.m.clear();
    }

    private void F() {
        boolean zP = p();
        setImageDrawable(null);
        setImageDrawable(this.g);
        if (zP) {
            this.g.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new j();
        int a;
        float b;
        boolean c;
        String d;
        int e;
        int f;

        /* synthetic */ SavedState(Parcel parcel, e eVar) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.b = parcel.readFloat();
            this.c = parcel.readInt() == 1;
            this.d = parcel.readString();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.b);
            parcel.writeInt(this.c ? 1 : 0);
            parcel.writeString(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
        }
    }
}
