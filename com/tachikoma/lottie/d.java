package com.tachikoma.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import com.kwad.framework.tachikoma.a;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class d extends android.support.v7.widget.m {
    private Set<j> GA;
    private m<e> GB;
    private e GD;
    private final i<e> Gq;
    private final i<Throwable> Gr;
    private i<Throwable> Gs;
    private final g Gt;
    private String Gu;
    private int Gv;
    private boolean Gw;
    private boolean Gx;
    private boolean Gy;
    private RenderMode Gz;
    private static final String TAG = d.class.getSimpleName();
    private static final i<Throwable> Gp = new i<Throwable>() { // from class: com.tachikoma.lottie.d.1
        @Override // com.tachikoma.lottie.i
        public final /* synthetic */ void onResult(Throwable th) {
            b(th);
        }

        private static void b(Throwable th) {
            Log.e(d.TAG, "Unable to parse composition", th);
        }
    };

    public d(Context context) {
        super(context);
        this.Gq = new i<e>() { // from class: com.tachikoma.lottie.d.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.tachikoma.lottie.i
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(e eVar) {
                d.this.setComposition(eVar);
            }
        };
        this.Gr = new i<Throwable>() { // from class: com.tachikoma.lottie.d.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.tachikoma.lottie.i
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResult(Throwable th) {
                (d.this.Gs == null ? d.Gp : d.this.Gs).onResult(th);
            }
        };
        this.Gt = new g();
        this.Gw = false;
        this.Gx = false;
        this.Gy = false;
        this.Gz = RenderMode.AUTOMATIC;
        this.GA = new HashSet();
        h(null);
    }

    private void h(AttributeSet attributeSet) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, a.e.LottieAnimationView);
        if (!isInEditMode()) {
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(a.e.LottieAnimationView_lottie_rawRes);
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(a.e.LottieAnimationView_lottie_fileName);
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(a.e.LottieAnimationView_lottie_url);
            if (zHasValue && zHasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(a.e.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                String string2 = typedArrayObtainStyledAttributes.getString(a.e.LottieAnimationView_lottie_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(a.e.LottieAnimationView_lottie_url)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (typedArrayObtainStyledAttributes.getBoolean(a.e.LottieAnimationView_lottie_autoPlay, false)) {
            this.Gx = true;
            this.Gy = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(a.e.LottieAnimationView_lottie_loop, false)) {
            this.Gt.setRepeatCount(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(a.e.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(a.e.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(a.e.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(a.e.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(a.e.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(a.e.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(a.e.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(a.e.LottieAnimationView_lottie_progress, 0.0f));
        O(typedArrayObtainStyledAttributes.getBoolean(a.e.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (typedArrayObtainStyledAttributes.hasValue(a.e.LottieAnimationView_lottie_colorFilter)) {
            a(new com.tachikoma.lottie.model.d("**"), k.Ik, new com.tachikoma.lottie.e.c(new o(typedArrayObtainStyledAttributes.getColor(a.e.LottieAnimationView_lottie_colorFilter, 0))));
        }
        if (typedArrayObtainStyledAttributes.hasValue(a.e.LottieAnimationView_lottie_scale)) {
            this.Gt.setScale(typedArrayObtainStyledAttributes.getFloat(a.e.LottieAnimationView_lottie_scale, 1.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
        jo();
    }

    @Override // android.support.v7.widget.m, android.widget.ImageView
    public void setImageResource(int i) {
        ji();
        super.setImageResource(i);
    }

    @Override // android.support.v7.widget.m, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        ji();
        super.setImageDrawable(drawable);
    }

    @Override // android.support.v7.widget.m, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        ji();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        g gVar = this.Gt;
        if (drawable2 == gVar) {
            super.invalidateDrawable(gVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.Gu = this.Gu;
        aVar.Gv = this.Gv;
        aVar.GG = this.Gt.getProgress();
        aVar.GH = this.Gt.isAnimating();
        aVar.GI = this.Gt.getImageAssetsFolder();
        aVar.repeatMode = this.Gt.getRepeatMode();
        aVar.repeatCount = this.Gt.getRepeatCount();
        return aVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.Gu = aVar.Gu;
        if (!TextUtils.isEmpty(this.Gu)) {
            setAnimation(this.Gu);
        }
        this.Gv = aVar.Gv;
        int i = this.Gv;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(aVar.GG);
        if (aVar.GH) {
            jj();
        }
        this.Gt.X(aVar.GI);
        setRepeatMode(aVar.repeatMode);
        setRepeatCount(aVar.repeatCount);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (this.Gt == null) {
            return;
        }
        if (isShown()) {
            if (this.Gw) {
                jk();
            }
            this.Gw = false;
        } else if (isAnimating()) {
            jm();
            this.Gw = true;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Gy && this.Gx) {
            jj();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            jl();
            this.Gx = true;
        }
        super.onDetachedFromWindow();
    }

    private void O(boolean z) {
        this.Gt.O(z);
    }

    public void setAnimation(int i) {
        this.Gv = i;
        this.Gu = null;
        setCompositionTask(f.o(getContext(), i));
    }

    public void setAnimation(String str) {
        this.Gu = str;
        this.Gv = 0;
        setCompositionTask(f.c(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        n(str, null);
    }

    private void n(String str, String str2) {
        a(new JsonReader(new StringReader(str)), null);
    }

    private void a(JsonReader jsonReader, String str) {
        setCompositionTask(f.b(jsonReader, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(f.b(getContext(), str));
    }

    public void setAnimationFromFile(String str) {
        m<e> mVarW = f.W(str);
        if (mVarW == null) {
            this.Gr.onResult(new FileNotFoundException());
        } else {
            setCompositionTask(mVarW);
        }
    }

    private void setCompositionTask(m<e> mVar) {
        jn();
        ji();
        this.GB = mVar.a(this.Gq).c(this.Gr);
    }

    private void ji() {
        m<e> mVar = this.GB;
        if (mVar != null) {
            mVar.b(this.Gq);
            this.GB.d(this.Gr);
        }
    }

    public final void P(boolean z) {
        m<e> mVar = this.GB;
        if (mVar != null) {
            mVar.removeAllListeners();
            this.GB.R(true);
        }
    }

    public void setComposition(e eVar) {
        if (c.Gi) {
            Log.v(TAG, "Set Composition \n" + eVar);
        }
        this.Gt.setCallback(this);
        this.GD = eVar;
        boolean zB = this.Gt.b(eVar);
        jo();
        if (getDrawable() != this.Gt || zB) {
            setImageDrawable(null);
            setImageDrawable(this.Gt);
            requestLayout();
            Iterator<j> it = this.GA.iterator();
            while (it.hasNext()) {
                it.next().jM();
            }
        }
    }

    public e getComposition() {
        return this.GD;
    }

    public final void jj() {
        this.Gt.jj();
        jo();
    }

    public final void jk() {
        this.Gt.jk();
        jo();
    }

    public void setMinFrame(int i) {
        this.Gt.setMinFrame(i);
    }

    public float getMinFrame() {
        return this.Gt.getMinFrame();
    }

    public void setMinProgress(float f) {
        this.Gt.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.Gt.setMaxFrame(i);
    }

    public float getMaxFrame() {
        return this.Gt.getMaxFrame();
    }

    public void setMaxProgress(float f) {
        this.Gt.setMaxProgress(f);
    }

    public void setMinFrame(String str) {
        this.Gt.setMinFrame(str);
    }

    public void setMaxFrame(String str) {
        this.Gt.setMaxFrame(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.Gt.setMinAndMaxFrame(str);
    }

    public void setSpeed(float f) {
        this.Gt.setSpeed(f);
    }

    public float getSpeed() {
        return this.Gt.getSpeed();
    }

    public final void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Gt.a(animatorUpdateListener);
    }

    public final void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Gt.b(animatorUpdateListener);
    }

    public final void a(Animator.AnimatorListener animatorListener) {
        this.Gt.a(animatorListener);
    }

    public final void b(Animator.AnimatorListener animatorListener) {
        this.Gt.b(animatorListener);
    }

    public void setRepeatMode(int i) {
        this.Gt.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.Gt.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.Gt.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.Gt.getRepeatCount();
    }

    public final boolean isAnimating() {
        return this.Gt.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.Gt.X(str);
    }

    public String getImageAssetsFolder() {
        return this.Gt.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(b bVar) {
        this.Gt.setImageAssetDelegate(bVar);
    }

    public void setFontAssetDelegate(com.tachikoma.lottie.a aVar) {
        this.Gt.setFontAssetDelegate(aVar);
    }

    public void setTextDelegate(p pVar) {
        this.Gt.setTextDelegate(pVar);
    }

    private <T> void a(com.tachikoma.lottie.model.d dVar, T t, com.tachikoma.lottie.e.c<T> cVar) {
        this.Gt.a(dVar, t, cVar);
    }

    public void setScale(float f) {
        this.Gt.setScale(f);
        if (getDrawable() == this.Gt) {
            setImageDrawable(null);
            setImageDrawable(this.Gt);
        }
    }

    public float getScale() {
        return this.Gt.getScale();
    }

    public final void jl() {
        this.Gt.jl();
        jo();
    }

    public final void jm() {
        this.Gt.jm();
        jo();
    }

    public void setFrame(int i) {
        this.Gt.setFrame(i);
    }

    public int getFrame() {
        return this.Gt.getFrame();
    }

    public void setProgress(float f) {
        this.Gt.setProgress(f);
    }

    public float getProgress() {
        return this.Gt.getProgress();
    }

    public long getDuration() {
        e eVar = this.GD;
        if (eVar != null) {
            return (long) eVar.jt();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Gt.setPerformanceTrackingEnabled(z);
    }

    public n getPerformanceTracker() {
        return this.Gt.getPerformanceTracker();
    }

    private void jn() {
        this.GD = null;
        this.Gt.jn();
    }

    public void setRenderMode(RenderMode renderMode) {
        this.Gz = renderMode;
        jo();
    }

    /* renamed from: com.tachikoma.lottie.d$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] GF = new int[RenderMode.values().length];

        static {
            try {
                GF[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                GF[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                GF[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void jo() {
        /*
            r5 = this;
            int[] r0 = com.tachikoma.lottie.d.AnonymousClass4.GF
            com.tachikoma.lottie.RenderMode r1 = r5.Gz
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L37
            if (r0 == r1) goto L36
            r3 = 3
            if (r0 == r3) goto L14
            goto L3b
        L14:
            com.tachikoma.lottie.e r0 = r5.GD
            r3 = 0
            if (r0 == 0) goto L26
            boolean r0 = r0.jr()
            if (r0 == 0) goto L26
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L26
            goto L33
        L26:
            com.tachikoma.lottie.e r0 = r5.GD
            if (r0 == 0) goto L32
            int r0 = r0.js()
            r4 = 4
            if (r0 <= r4) goto L32
            goto L33
        L32:
            r3 = 1
        L33:
            if (r3 == 0) goto L36
            goto L37
        L36:
            r1 = 1
        L37:
            r0 = 0
            r5.setLayerType(r1, r0)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tachikoma.lottie.d.jo():void");
    }

    public void setAutoPlay(boolean z) {
        this.Gy = z;
    }

    public void setFailureListener(i<Throwable> iVar) {
        this.Gs = iVar;
    }

    public final boolean a(j jVar) {
        return this.GA.add(jVar);
    }

    public final boolean b(j jVar) {
        return this.GA.remove(jVar);
    }

    static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.tachikoma.lottie.d.a.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ a createFromParcel(Parcel parcel) {
                return j(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ a[] newArray(int i) {
                return cu(i);
            }

            private static a j(Parcel parcel) {
                return new a(parcel, (byte) 0);
            }

            private static a[] cu(int i) {
                return new a[i];
            }
        };
        float GG;
        boolean GH;
        String GI;
        String Gu;
        int Gv;
        int repeatCount;
        int repeatMode;

        /* synthetic */ a(Parcel parcel, byte b) {
            this(parcel);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.Gu = parcel.readString();
            this.GG = parcel.readFloat();
            this.GH = parcel.readInt() == 1;
            this.GI = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.Gu);
            parcel.writeFloat(this.GG);
            parcel.writeInt(this.GH ? 1 : 0);
            parcel.writeString(this.GI);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }
}
