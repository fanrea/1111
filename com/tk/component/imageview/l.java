package com.tk.component.imageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.t;
import com.tk.core.o.y;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class l extends com.tk.core.component.e<com.tachikoma.lottie.d> {
    private float DT;
    public String QJ;

    @Deprecated
    public String RD;

    @Deprecated
    public String RE;
    public boolean RF;
    private final LinkedList<String> RG;
    private JsValueRef<V8Function> RH;
    private JsValueRef<V8Function> RI;
    private JsValueRef<V8Function> RJ;
    private JsValueRef<V8Function> RK;
    private JsValueRef<V8Function> RL;
    private JsValueRef<V8Function> RM;
    private JsValueRef<V8Function> RN;
    private com.tachikoma.lottie.m RO;
    private AnimatorListenerAdapter RP;
    private final ValueAnimator.AnimatorUpdateListener RQ;
    private final com.tachikoma.lottie.j RR;
    private final com.tachikoma.lottie.i<Throwable> RS;
    private boolean isRunning;

    public static void preload() {
    }

    @Override // com.tk.core.component.e
    public final boolean mJ() {
        return true;
    }

    @Override // com.tk.core.component.e
    public final /* synthetic */ View n(Context context) {
        return B(context);
    }

    static /* synthetic */ boolean a(l lVar, boolean z) {
        lVar.isRunning = false;
        return false;
    }

    public l(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.RG = new LinkedList<>();
        this.RP = new AnimatorListenerAdapter() { // from class: com.tk.component.imageview.l.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) throws Throwable {
                super.onAnimationStart(animator);
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RH, (Object) null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) throws Throwable {
                super.onAnimationEnd(animator);
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RI, (Object) null);
                l.a(l.this, false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) throws Throwable {
                super.onAnimationCancel(animator);
                if (animator == null || !l.this.isRunning) {
                    return;
                }
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RL, (Object) null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animator) throws Throwable {
                super.onAnimationRepeat(animator);
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RM, (Object) null);
            }
        };
        this.RQ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tk.component.imageview.l.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) throws Throwable {
                if (l.this.RK == null || valueAnimator == null) {
                    return;
                }
                NumberFormat numberInstance = NumberFormat.getNumberInstance();
                numberInstance.setMaximumFractionDigits(2);
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RK, numberInstance.format(valueAnimator.getAnimatedFraction()));
            }
        };
        this.RR = new com.tachikoma.lottie.j() { // from class: com.tk.component.imageview.l.3
            @Override // com.tachikoma.lottie.j
            public final void jM() throws Throwable {
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RJ, Boolean.TRUE);
                if (l.this.DT > 0.0f) {
                    l.this.getView().setProgress(l.this.DT);
                }
                l.a(l.this, false);
                l.this.nn();
            }
        };
        this.RS = new com.tachikoma.lottie.i<Throwable>() { // from class: com.tk.component.imageview.l.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.tachikoma.lottie.i
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResult(Throwable th) throws Throwable {
                if (t.isDebug()) {
                    com.tk.core.i.a.a("TKLottieImageView", "lottieFail", th);
                }
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RJ, Boolean.FALSE);
            }
        };
    }

    public l(NativeModuleInitParams nativeModuleInitParams, boolean z) {
        super(nativeModuleInitParams, true);
        this.RG = new LinkedList<>();
        this.RP = new AnimatorListenerAdapter() { // from class: com.tk.component.imageview.l.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) throws Throwable {
                super.onAnimationStart(animator);
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RH, (Object) null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) throws Throwable {
                super.onAnimationEnd(animator);
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RI, (Object) null);
                l.a(l.this, false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) throws Throwable {
                super.onAnimationCancel(animator);
                if (animator == null || !l.this.isRunning) {
                    return;
                }
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RL, (Object) null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animator) throws Throwable {
                super.onAnimationRepeat(animator);
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RM, (Object) null);
            }
        };
        this.RQ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tk.component.imageview.l.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) throws Throwable {
                if (l.this.RK == null || valueAnimator == null) {
                    return;
                }
                NumberFormat numberInstance = NumberFormat.getNumberInstance();
                numberInstance.setMaximumFractionDigits(2);
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RK, numberInstance.format(valueAnimator.getAnimatedFraction()));
            }
        };
        this.RR = new com.tachikoma.lottie.j() { // from class: com.tk.component.imageview.l.3
            @Override // com.tachikoma.lottie.j
            public final void jM() throws Throwable {
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RJ, Boolean.TRUE);
                if (l.this.DT > 0.0f) {
                    l.this.getView().setProgress(l.this.DT);
                }
                l.a(l.this, false);
                l.this.nn();
            }
        };
        this.RS = new com.tachikoma.lottie.i<Throwable>() { // from class: com.tk.component.imageview.l.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.tachikoma.lottie.i
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResult(Throwable th) throws Throwable {
                if (t.isDebug()) {
                    com.tk.core.i.a.a("TKLottieImageView", "lottieFail", th);
                }
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RJ, Boolean.FALSE);
            }
        };
    }

    private static com.tachikoma.lottie.d B(Context context) {
        return new com.tachikoma.lottie.d(context);
    }

    public final boolean nl() {
        return getView().isAnimating();
    }

    @Deprecated
    public final void aK(String str) {
        this.RD = str;
        nm();
    }

    @Deprecated
    public final void aL(String str) {
        this.RE = str;
        nm();
    }

    public final void at(String str) {
        this.QJ = str;
        nm();
    }

    public final void aM(String str) {
        String strConcat;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith(UriUtils.ASSET_PREFIX)) {
            getView().setImageAssetsFolder(y.getMappedPath(str, UriUtils.ASSET_PREFIX));
            getView().setImageAssetDelegate(null);
            return;
        }
        com.tachikoma.lottie.d view = getView();
        if (TextUtils.isEmpty(pn())) {
            strConcat = y.getMappedPath(str, UriUtils.BUNDLE_PREFIX);
        } else {
            strConcat = pn().concat(y.getMappedPath(str, UriUtils.BUNDLE_PREFIX));
        }
        view.setImageAssetDelegate(new k(strConcat));
    }

    public final void g(String str, V8Function v8Function) {
        if (v8Function != null) {
            JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
            ad.unRetainJsValue(this.RN);
            this.RN = jsValueRefRetainJsValue;
        }
        this.RO = com.tachikoma.lottie.f.b(getContext(), str).a(new com.tachikoma.lottie.i<com.tachikoma.lottie.e>() { // from class: com.tk.component.imageview.l.6
            @Override // com.tachikoma.lottie.i
            public final /* synthetic */ void onResult(com.tachikoma.lottie.e eVar) throws Throwable {
                np();
            }

            private void np() throws Throwable {
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RN, Boolean.TRUE);
            }
        }).c(new com.tachikoma.lottie.i<Throwable>() { // from class: com.tk.component.imageview.l.5
            @Override // com.tachikoma.lottie.i
            public final /* synthetic */ void onResult(Throwable th) throws Throwable {
                no();
            }

            private void no() throws Throwable {
                l lVar = l.this;
                lVar.a((JsValueRef<V8Function>) lVar.RN, Boolean.FALSE);
            }
        });
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void nm() {
        try {
            getView().a(this.RR);
            getView().setFailureListener(this.RS);
            getView().a(this.RP);
            getView().a(this.RQ);
            if (TextUtils.isEmpty(this.QJ)) {
                if (!TextUtils.isEmpty(this.RD)) {
                    aN(this.RD);
                }
                if (TextUtils.isEmpty(this.RE)) {
                    return;
                }
                if (!this.RE.startsWith("https://") && !this.RE.startsWith("http://")) {
                    aP(this.RE);
                    return;
                }
                aQ(this.RE);
                return;
            }
            int iIndexOf = this.QJ.indexOf(58);
            char c = 65535;
            if (iIndexOf == -1) {
                aO(this.QJ);
                return;
            }
            String str = this.QJ.substring(0, iIndexOf) + "://";
            switch (str.hashCode()) {
                case -855037794:
                    if (str.equals(UriUtils.FILE_PREFIX)) {
                        c = 1;
                        break;
                    }
                    break;
                case -373240150:
                    if (str.equals(UriUtils.ASSET_PREFIX)) {
                        c = 0;
                        break;
                    }
                    break;
                case -132207921:
                    if (str.equals("https://")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1242606098:
                    if (str.equals("http://")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                aN(this.QJ);
                return;
            }
            if (c == 1) {
                aP(this.QJ);
            } else if (c == 2 || c == 3) {
                aQ(this.QJ);
            } else {
                aO(this.QJ);
            }
        } catch (Throwable th) {
            com.tk.core.exception.a.a(th, pP().pg());
        }
    }

    private void aN(String str) {
        String mappedPath = y.getMappedPath(str, UriUtils.ASSET_PREFIX);
        if (-1 == mappedPath.lastIndexOf(".")) {
            mappedPath = mappedPath.concat(".json");
        }
        getView().setAnimation(mappedPath);
    }

    private void aO(String str) throws Throwable {
        String mappedPath = y.getMappedPath(str, UriUtils.BUNDLE_PREFIX);
        if (!TextUtils.isEmpty(pn())) {
            mappedPath = pn().concat(mappedPath);
        }
        if (com.tk.core.o.f.cS(mappedPath)) {
            getView().setAnimationFromFile(mappedPath);
        } else {
            a(this.RJ, Boolean.FALSE);
        }
    }

    private void aP(String str) throws Throwable {
        String mappedPath = y.getMappedPath(str, UriUtils.FILE_PREFIX);
        if (com.tk.core.o.f.cS(mappedPath)) {
            getView().setAnimationFromFile(mappedPath);
        } else {
            a(this.RJ, Boolean.FALSE);
        }
    }

    private void aQ(String str) {
        getView().setAnimationFromUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void nn() {
        if (getView().getComposition() == null) {
            return;
        }
        for (String str : new ArrayList(this.RG)) {
            char c = 65535;
            switch (str.hashCode()) {
                case -934426579:
                    if (str.equals("resume")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3443508:
                    if (str.equals("play")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3540994:
                    if (str.equals(com.component.feed.a.e)) {
                        c = 2;
                        break;
                    }
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                play();
            } else if (c == 1) {
                pause();
            } else if (c == 2) {
                stop();
            } else if (c == 3) {
                resume();
            }
        }
        this.RG.clear();
    }

    public final void Z(boolean z) {
        if (z) {
            getView().setRepeatCount(-1);
        } else {
            getView().setRepeatCount(0);
        }
    }

    public final void setAutoPlay(boolean z) {
        getView().setAutoPlay(z);
    }

    public final void play() {
        if (getView().getComposition() != null) {
            if (this.DT == 0.0f) {
                getView().jj();
            } else {
                getView().jk();
                a(this.RH, (Object) null);
            }
            if (this.isRunning) {
                a(this.RL, Boolean.FALSE);
            }
            this.DT = 0.0f;
            this.isRunning = true;
            return;
        }
        this.RG.add("play");
    }

    public final void pause() {
        if (getView().getComposition() != null) {
            if (getView().isAnimating()) {
                a(this.RL, (Object) null);
            }
            this.isRunning = false;
            getView().jm();
            return;
        }
        this.RG.add("pause");
    }

    public final void stop() {
        if (getView().getComposition() != null) {
            if (this.isRunning) {
                getView().jl();
                getView().setFrame(0);
                this.isRunning = false;
                return;
            }
            return;
        }
        this.RG.add(com.component.feed.a.e);
    }

    public final void resume() {
        if (getView().getComposition() != null) {
            getView().jk();
            this.isRunning = true;
        } else {
            this.RG.add("resume");
        }
    }

    public final void setProgress(float f) {
        if (f < 0.0f || f > 1.0f) {
            com.tk.core.exception.a.b(new Exception("progress is unavailable"), pP().pg());
            return;
        }
        this.DT = f;
        getView().setProgress(this.DT);
        if (nl()) {
            a(this.RH, (Object) null);
            this.DT = 0.0f;
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.RH);
        ad.unRetainJsValue(this.RI);
        ad.unRetainJsValue(this.RJ);
        ad.unRetainJsValue(this.RK);
        ad.unRetainJsValue(this.RL);
        ad.unRetainJsValue(this.RM);
    }

    public final void ab(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.RH);
        this.RH = jsValueRefRetainJsValue;
    }

    public final void ac(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.RI);
        this.RI = jsValueRefRetainJsValue;
    }

    public final void ad(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.RJ);
        this.RJ = jsValueRefRetainJsValue;
    }

    public final void ae(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.RK);
        this.RK = jsValueRefRetainJsValue;
    }

    public final void af(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.RL);
        this.RL = jsValueRefRetainJsValue;
    }

    public final void ag(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.RM);
        this.RM = jsValueRefRetainJsValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JsValueRef<V8Function> jsValueRef, Object obj) throws Throwable {
        if (jsValueRef == null || jsValueRef.get() == null || jsValueRef.get().isReleased() || !ad.isV8Valid(jsValueRef.get())) {
            return;
        }
        try {
            jsValueRef.get().call(null, obj);
        } catch (Exception e) {
            com.tk.core.exception.a.a(pO(), e);
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            nj();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.component.imageview.l.7
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.nj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj() {
        if (pQ()) {
            getView().b(this.RR);
            getView().removeUpdateListener(this.RQ);
            getView().b(this.RP);
            getView().setFailureListener(null);
            getView().P(true);
        }
        com.tachikoma.lottie.m mVar = this.RO;
        if (mVar != null) {
            mVar.removeAllListeners();
            this.RO.R(false);
        }
    }
}
