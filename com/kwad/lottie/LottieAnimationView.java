package com.kwad.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LottieAnimationView extends ImageView {
    private static final String TAG = "LottieAnimationView";
    private boolean aiW;
    private String bjA;
    private int bjB;
    private boolean bjC;
    private boolean bjD;
    private Set<Object> bjE;
    private k<d> bjF;
    private d bjG;
    private final h<d> bjx;
    private final h<Throwable> bjy;
    private final f bjz;

    public LottieAnimationView(Context context) {
        super(context);
        this.bjx = new h<d>() { // from class: com.kwad.lottie.LottieAnimationView.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.lottie.h
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.bjy = new h<Throwable>() { // from class: com.kwad.lottie.LottieAnimationView.2
            @Override // com.kwad.lottie.h
            public final /* synthetic */ void onResult(Throwable th) {
                n(th);
            }

            private static void n(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.bjz = new f();
        this.bjC = false;
        this.aiW = false;
        this.bjD = false;
        this.bjE = new HashSet();
        rS();
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjx = new h<d>() { // from class: com.kwad.lottie.LottieAnimationView.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.lottie.h
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.bjy = new h<Throwable>() { // from class: com.kwad.lottie.LottieAnimationView.2
            @Override // com.kwad.lottie.h
            public final /* synthetic */ void onResult(Throwable th) {
                n(th);
            }

            private static void n(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.bjz = new f();
        this.bjC = false;
        this.aiW = false;
        this.bjD = false;
        this.bjE = new HashSet();
        rS();
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bjx = new h<d>() { // from class: com.kwad.lottie.LottieAnimationView.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.lottie.h
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.bjy = new h<Throwable>() { // from class: com.kwad.lottie.LottieAnimationView.2
            @Override // com.kwad.lottie.h
            public final /* synthetic */ void onResult(Throwable th) {
                n(th);
            }

            private static void n(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.bjz = new f();
        this.bjC = false;
        this.aiW = false;
        this.bjD = false;
        this.bjE = new HashSet();
        rS();
    }

    private void rS() {
        Qc();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        PX();
        PY();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        a(drawable, true);
    }

    private void a(Drawable drawable, boolean z) {
        if (z && drawable != this.bjz) {
            PX();
        }
        PY();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        PX();
        PY();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.bjz;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.bjA = this.bjA;
        aVar.bjB = this.bjB;
        aVar.agh = this.bjz.getProgress();
        aVar.axA = this.bjz.isAnimating();
        aVar.bjI = this.bjz.getImageAssetsFolder();
        aVar.repeatMode = this.bjz.getRepeatMode();
        aVar.repeatCount = this.bjz.getRepeatCount();
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
        String str = aVar.bjA;
        this.bjA = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.bjA);
        }
        int i = aVar.bjB;
        this.bjB = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(aVar.agh);
        if (aVar.axA) {
            PZ();
        }
        this.bjz.dj(aVar.bjI);
        setRepeatMode(aVar.repeatMode);
        setRepeatCount(aVar.repeatCount);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aiW && this.bjC) {
            PZ();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            Qa();
            this.bjC = true;
        }
        PX();
        super.onDetachedFromWindow();
    }

    private void PX() {
        this.bjz.PX();
    }

    public final void co(boolean z) {
        this.bjz.co(true);
    }

    public boolean getUseHardwareAcceleration() {
        return this.bjD;
    }

    public void setAnimation(int i) {
        this.bjB = i;
        this.bjA = null;
        setCompositionTask(e.h(getContext(), i));
    }

    public void setAnimation(String str) {
        this.bjA = str;
        this.bjB = 0;
        setCompositionTask(e.v(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        M(str, null);
    }

    private void M(String str, String str2) {
        a(new JsonReader(new StringReader(str)), (String) null);
    }

    private void a(JsonReader jsonReader, String str) {
        setCompositionTask(e.b(jsonReader, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(e.u(getContext(), str));
    }

    private void setCompositionTask(k<d> kVar) {
        Qb();
        PY();
        this.bjF = kVar.a(this.bjx).c(this.bjy);
    }

    private void PY() {
        k<d> kVar = this.bjF;
        if (kVar != null) {
            kVar.b(this.bjx);
            this.bjF.d(this.bjy);
        }
    }

    public void setComposition(d dVar) {
        if (c.bjq) {
            Log.v(TAG, "Set Composition \n" + dVar);
        }
        this.bjz.setCallback(this);
        this.bjG = dVar;
        boolean zB = this.bjz.b(dVar);
        Qc();
        if (getDrawable() != this.bjz || zB) {
            setImageDrawable(null);
            setImageDrawable(this.bjz);
            requestLayout();
            Iterator<Object> it = this.bjE.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public d getComposition() {
        return this.bjG;
    }

    public final void PZ() {
        this.bjz.PZ();
        Qc();
    }

    public void setMinFrame(int i) {
        this.bjz.setMinFrame(i);
    }

    public float getMinFrame() {
        return this.bjz.getMinFrame();
    }

    public void setMinProgress(float f) {
        this.bjz.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.bjz.setMaxFrame(i);
    }

    public float getMaxFrame() {
        return this.bjz.getMaxFrame();
    }

    public void setMaxProgress(float f) {
        this.bjz.setMaxProgress(f);
    }

    public void setSpeed(float f) {
        this.bjz.setSpeed(f);
    }

    public float getSpeed() {
        return this.bjz.getSpeed();
    }

    public final void a(Animator.AnimatorListener animatorListener) {
        this.bjz.a(animatorListener);
    }

    public final void b(Animator.AnimatorListener animatorListener) {
        this.bjz.b(animatorListener);
    }

    public void setRepeatMode(int i) {
        this.bjz.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.bjz.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.bjz.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.bjz.getRepeatCount();
    }

    public final boolean isAnimating() {
        return this.bjz.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.bjz.dj(str);
    }

    public String getImageAssetsFolder() {
        return this.bjz.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(b bVar) {
        this.bjz.setImageAssetDelegate(bVar);
    }

    public void setFontAssetDelegate(com.kwad.lottie.a aVar) {
        this.bjz.setFontAssetDelegate(aVar);
    }

    public void setTextDelegate(m mVar) {
        this.bjz.setTextDelegate(mVar);
    }

    public final <T> void a(com.kwad.lottie.model.e eVar, T t, com.kwad.lottie.e.c<T> cVar) {
        this.bjz.a(eVar, t, cVar);
    }

    public void setScale(float f) {
        this.bjz.setScale(f);
        if (getDrawable() == this.bjz) {
            a((Drawable) null, false);
            a((Drawable) this.bjz, false);
        }
    }

    public float getScale() {
        return this.bjz.getScale();
    }

    public final void Qa() {
        this.bjz.Qa();
        Qc();
    }

    public void setFrame(int i) {
        this.bjz.setFrame(i);
    }

    public int getFrame() {
        return this.bjz.getFrame();
    }

    public void setProgress(float f) {
        this.bjz.setProgress(f);
    }

    public float getProgress() {
        return this.bjz.getProgress();
    }

    public long getDuration() {
        d dVar = this.bjG;
        if (dVar != null) {
            return (long) dVar.Qd();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.bjz.setPerformanceTrackingEnabled(z);
    }

    public l getPerformanceTracker() {
        return this.bjz.getPerformanceTracker();
    }

    private void Qb() {
        this.bjG = null;
        this.bjz.Qb();
    }

    private void Qc() {
        setLayerType(this.bjD && this.bjz.isAnimating() ? 2 : 1, null);
    }

    static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.kwad.lottie.LottieAnimationView.a.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ a createFromParcel(Parcel parcel) {
                return d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ a[] newArray(int i) {
                return dU(i);
            }

            private static a d(Parcel parcel) {
                return new a(parcel, (byte) 0);
            }

            private static a[] dU(int i) {
                return new a[i];
            }
        };
        float agh;
        boolean axA;
        String bjA;
        int bjB;
        String bjI;
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
            this.bjA = parcel.readString();
            this.agh = parcel.readFloat();
            this.axA = parcel.readInt() == 1;
            this.bjI = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.bjA);
            parcel.writeFloat(this.agh);
            parcel.writeInt(this.axA ? 1 : 0);
            parcel.writeString(this.bjI);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }
}
