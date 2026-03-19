package com.bytedance.adsdk.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.an;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LottieAnimationView extends ImageView {
    private static final String d = "LottieAnimationView";
    private static final tc<Throwable> hc = new tc<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.1
        @Override // com.bytedance.adsdk.lottie.tc
        public void d(Throwable th) {
            if (com.bytedance.adsdk.lottie.u.tt.d(th)) {
                com.bytedance.adsdk.lottie.u.u.d("Unable to load composition.", th);
            } else {
                com.bytedance.adsdk.lottie.u.u.d("Unable to parse composition:", th);
            }
        }
    };
    private int an;
    private final tc<an> b;
    private final tc<Throwable> c;
    private an cb;
    private int de;
    private uo<an> e;
    private String gb;
    private final gb h;
    private String he;
    private hc j;
    private long jh;
    private final Set<Object> k;
    private boolean mk;
    private boolean mq;
    private int np;
    private Handler rf;
    private d s;
    private com.bytedance.adsdk.lottie.model.layer.an sy;
    private boolean tc;
    private int tt;
    private tc<Throwable> u;
    private final Set<c> uo;
    private int v;
    private JSONArray vv;
    private final Handler w;
    private int yi;
    private int yo;
    private final Runnable zw;

    private enum c {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public interface d {
        void d(Map<String, Object> map);

        void hc(Map<String, Object> map);
    }

    public interface hc {
        void d(String str, JSONArray jSONArray);
    }

    static /* synthetic */ int u(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.yo;
        lottieAnimationView.yo = i + 1;
        return i;
    }

    static /* synthetic */ int yo(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.de;
        lottieAnimationView.de = i - 1;
        return i;
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.b = new tc<an>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.6
            @Override // com.bytedance.adsdk.lottie.tc
            public void d(an anVar) {
                LottieAnimationView.this.setComposition(anVar);
            }
        };
        this.c = new tc<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.7
            @Override // com.bytedance.adsdk.lottie.tc
            public void d(Throwable th) {
                if (LottieAnimationView.this.an != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.an);
                }
                (LottieAnimationView.this.u == null ? LottieAnimationView.hc : LottieAnimationView.this.u).d(th);
            }
        };
        this.an = 0;
        this.h = new gb(this);
        this.tc = false;
        this.mk = false;
        this.mq = true;
        this.uo = new HashSet();
        this.k = new HashSet();
        this.w = new Handler(Looper.getMainLooper());
        this.yo = 0;
        this.jh = 0L;
        this.zw = new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.utils.mq.d("TMe", "--==--- timer callback, timer: " + LottieAnimationView.this.de + ", " + LottieAnimationView.this.v);
                if (LottieAnimationView.this.de <= LottieAnimationView.this.v) {
                    if (LottieAnimationView.this.np >= 0 && LottieAnimationView.this.yi >= 0) {
                        com.bytedance.sdk.component.utils.mq.d("TMe", "--==--- timer end, play anim, startframe: " + LottieAnimationView.this.np);
                        LottieAnimationView.this.hc();
                        LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                        lottieAnimationView.setFrame(lottieAnimationView.np);
                        LottieAnimationView.this.d(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.4.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (LottieAnimationView.this.getFrame() < LottieAnimationView.this.yi - 1 || LottieAnimationView.this.getFrame() >= LottieAnimationView.this.yi + 2) {
                                    return;
                                }
                                com.bytedance.sdk.component.utils.mq.d("TMe", "--==--- timer end, play anim, endframe: " + LottieAnimationView.this.yi);
                                LottieAnimationView.this.hc(this);
                                LottieAnimationView.this.h();
                            }
                        });
                    } else {
                        com.bytedance.sdk.component.utils.mq.d("TMe", "--==--- timer end, frame invalid: " + LottieAnimationView.this.np + "," + LottieAnimationView.this.yi);
                    }
                    if ((!TextUtils.isEmpty(LottieAnimationView.this.he) || (LottieAnimationView.this.vv != null && LottieAnimationView.this.vv.length() > 0)) && LottieAnimationView.this.j != null) {
                        LottieAnimationView.this.j.d(LottieAnimationView.this.he, LottieAnimationView.this.vv);
                        return;
                    }
                    return;
                }
                LottieAnimationView.yo(LottieAnimationView.this);
                LottieAnimationView.this.sy.d(new StringBuilder().append(LottieAnimationView.this.de).toString());
                LottieAnimationView.this.invalidate();
                LottieAnimationView.this.cb();
            }
        };
        tt();
    }

    private void tt() {
        setSaveEnabled(false);
        this.mq = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        d(0.0f, false);
        d(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        this.h.d(Boolean.valueOf(com.bytedance.adsdk.lottie.u.tt.d(getContext()) != 0.0f));
        tc();
        mk();
        uo();
    }

    private void tc() {
        d(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) throws NumberFormatException {
                LottieAnimationView.this.hc(this);
                LottieAnimationView.this.e();
                LottieAnimationView.this.mq();
            }
        });
    }

    private void mk() {
        d(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) throws NumberFormatException {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < 0.98f) {
                    return;
                }
                LottieAnimationView.u(LottieAnimationView.this);
                an.hc globalConfig = LottieAnimationView.this.getGlobalConfig();
                if (globalConfig != null && globalConfig.c > 0 && globalConfig.c > LottieAnimationView.this.yo) {
                    LottieAnimationView.this.e();
                    LottieAnimationView.this.d();
                    LottieAnimationView.this.setProgress(0.0f);
                    return;
                }
                LottieAnimationView.this.hc(this);
                if (LottieAnimationView.this.s != null) {
                    Map<String, Object> map = null;
                    if (globalConfig != null && globalConfig.b != null) {
                        map = globalConfig.b;
                    }
                    LottieAnimationView.this.s.hc(map);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq() {
        final an.hc globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.u <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.an) && globalConfig.h == null) {
            return;
        }
        int maxFrame = globalConfig.u;
        if (maxFrame > getMaxFrame()) {
            maxFrame = (int) getMaxFrame();
        }
        final float maxFrame2 = maxFrame / getMaxFrame();
        d(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < maxFrame2) {
                    return;
                }
                LottieAnimationView.this.hc(this);
                if (LottieAnimationView.this.j != null) {
                    LottieAnimationView.this.j.d(globalConfig.an, globalConfig.h);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        an.hc globalConfig = getGlobalConfig();
        if (this.s != null) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(j));
            if (globalConfig != null && globalConfig.hc != null && !globalConfig.hc.isEmpty()) {
                map.putAll(globalConfig.hc);
            }
            this.s.d(map);
        }
    }

    private void uo() {
        d(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                jh jhVarYi;
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - LottieAnimationView.this.jh;
                LottieAnimationView.this.hc(this);
                String playDelayedELExpressTimeS = LottieAnimationView.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (jhVarYi = LottieAnimationView.this.h.yi()) != null) {
                    try {
                        int i = Integer.parseInt(jhVarYi.d(playDelayedELExpressTimeS)) * 1000;
                        if (LottieAnimationView.this.jh > 0) {
                            long jElapsedRealtime2 = (LottieAnimationView.this.jh + i) - SystemClock.elapsedRealtime();
                            com.bytedance.sdk.component.utils.mq.d("TMe", "--==-- lottie delayed time: ".concat(String.valueOf(jElapsedRealtime2)));
                            if (jElapsedRealtime2 > 0) {
                                LottieAnimationView.this.h();
                                LottieAnimationView.this.setVisibility(8);
                                if (LottieAnimationView.this.rf == null) {
                                    LottieAnimationView.this.rf = new Handler(Looper.getMainLooper());
                                }
                                LottieAnimationView.this.rf.removeCallbacksAndMessages(null);
                                LottieAnimationView.this.rf.postDelayed(new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.bytedance.sdk.component.utils.mq.d("TMe", "--==-- lottie real start play");
                                        LottieAnimationView.this.setVisibility(0);
                                        LottieAnimationView.this.d();
                                        LottieAnimationView.this.d(jElapsedRealtime);
                                    }
                                }, jElapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException e) {
                        com.bytedance.sdk.component.utils.mq.d(e);
                    }
                }
                LottieAnimationView.this.d(jElapsedRealtime);
            }
        });
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        k();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        k();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        k();
        super.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        gb gbVar;
        if (!this.tc && drawable == (gbVar = this.h) && gbVar.v()) {
            h();
        } else if (!this.tc && (drawable instanceof gb)) {
            gb gbVar2 = (gb) drawable;
            if (gbVar2.v()) {
                gbVar2.j();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof gb) && ((gb) drawable).h() == rf.SOFTWARE) {
            this.h.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        gb gbVar = this.h;
        if (drawable2 == gbVar) {
            super.invalidateDrawable(gbVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        an anVarVv;
        gb gbVar = this.h;
        if (gbVar == null || (anVarVv = gbVar.vv()) == null) {
            return null;
        }
        return anVarVv.tt();
    }

    private tt d(String str) {
        gb gbVar;
        an anVarVv;
        Map<String, tt> mapW;
        if (TextUtils.isEmpty(str) || (gbVar = this.h) == null || (anVarVv = gbVar.vv()) == null || (mapW = anVarVv.w()) == null) {
            return null;
        }
        return mapW.get(str);
    }

    private an.d getArea() {
        an anVarVv;
        gb gbVar = this.h;
        if (gbVar == null || (anVarVv = gbVar.vv()) == null) {
            return null;
        }
        return anVarVv.tc();
    }

    private an.b getGlobalEvent() {
        an anVarVv;
        gb gbVar = this.h;
        if (gbVar == null || (anVarVv = gbVar.vv()) == null) {
            return null;
        }
        return anVarVv.mk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public an.hc getGlobalConfig() {
        an anVarVv;
        gb gbVar = this.h;
        if (gbVar == null || (anVarVv = gbVar.vv()) == null) {
            return null;
        }
        return anVarVv.mq();
    }

    private void d(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i = iArr2[0];
            final int i2 = iArr2[1];
            if (i < 0 || i2 < 0) {
                return;
            }
            com.bytedance.sdk.component.utils.mq.d("TMe", "--==--- inel enter, play anim, startframe: ".concat(String.valueOf(i)));
            w();
            d();
            setFrame(i);
            d(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.12
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (LottieAnimationView.this.getFrame() < i2 - 1 || LottieAnimationView.this.getFrame() >= i2 + 2) {
                        return;
                    }
                    com.bytedance.sdk.component.utils.mq.d("TMe", "--==--- inel enter, play anim end, endframe: " + i2 + ", realFrame: " + LottieAnimationView.this.getFrame());
                    LottieAnimationView.this.hc(this);
                    LottieAnimationView.this.h();
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    private void d(String str, String str2, JSONArray jSONArray) {
        hc hcVar;
        an.b globalEvent = getGlobalEvent();
        if (globalEvent != null && str != null) {
            if (TextUtils.isEmpty(str2) && !str.contains("CSJNO")) {
                str2 = globalEvent.d;
            }
            if ((jSONArray == null || jSONArray.length() <= 0) && !str.contains("CSJLELNO")) {
                jSONArray = globalEvent.b;
            }
        }
        if ((!TextUtils.isEmpty(str2) || (jSONArray != null && jSONArray.length() > 0)) && (hcVar = this.j) != null) {
            hcVar.d(str2, jSONArray);
        }
    }

    private void d(an.d dVar) {
        dVar.u = com.bytedance.adsdk.lottie.u.tt.d("x", dVar.d, getWidth());
        dVar.an = com.bytedance.adsdk.lottie.u.tt.d("y", dVar.hc, getHeight());
        dVar.h = com.bytedance.adsdk.lottie.u.tt.d((String) null, dVar.b, getWidth());
        dVar.gb = com.bytedance.adsdk.lottie.u.tt.d((String) null, dVar.c, getHeight());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int[][] iArr;
        an.d area = getArea();
        if (area != null) {
            if (area.u == -1.0f) {
                d(area);
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x < area.u || x > area.u + area.h || y < area.an || y > area.an + area.gb) {
                com.bytedance.sdk.component.utils.mq.d("TMe", "--==--:width: " + getWidth() + ", height: " + getHeight());
                com.bytedance.sdk.component.utils.mq.d("TMe", "--==--:".concat(String.valueOf(area)));
                com.bytedance.sdk.component.utils.mq.d("TMe", "--==--:pintx: " + x + ", pointY: " + y);
                return false;
            }
        }
        com.bytedance.adsdk.lottie.model.layer.b bVarD = d(motionEvent);
        if (bVarD != null) {
            String strMk = bVarD.mk();
            if (bVarD instanceof com.bytedance.adsdk.lottie.model.layer.c) {
                if (getGlobalConfig() == null || getGlobalConfig().d != 1) {
                    return super.onTouchEvent(motionEvent);
                }
                return false;
            }
            if (strMk != null && strMk.startsWith("CSJCLOSE")) {
                w();
            }
            tt ttVarD = d(bVarD.h());
            if (ttVarD != null && motionEvent.getAction() == 1) {
                d(strMk, ttVarD.h(), ttVarD.tt());
                int[][] iArrGb = ttVarD.gb();
                if (iArrGb != null) {
                    d(iArrGb);
                } else if (getGlobalEvent() != null && (iArr = getGlobalEvent().hc) != null) {
                    d(iArr);
                }
            }
            if (strMk != null && strMk.startsWith("CSJNTP")) {
                return false;
            }
            return super.onTouchEvent(motionEvent);
        }
        if (getGlobalConfig() == null || getGlobalConfig().d != 1) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    private com.bytedance.adsdk.lottie.model.layer.b d(MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.c cVarB;
        gb gbVar = this.h;
        if (gbVar == null || (cVarB = gbVar.b()) == null) {
            return null;
        }
        return d(cVarB, motionEvent);
    }

    private com.bytedance.adsdk.lottie.model.layer.b d(com.bytedance.adsdk.lottie.model.layer.c cVar, MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.b bVarD;
        for (com.bytedance.adsdk.lottie.model.layer.b bVar : cVar.k()) {
            if (bVar instanceof com.bytedance.adsdk.lottie.model.layer.c) {
                if (bVar.tc() && bVar.gb() > 0.0f) {
                    RectF rectF = new RectF();
                    bVar.d(rectF, bVar.an(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (bVarD = d((com.bytedance.adsdk.lottie.model.layer.c) bVar, motionEvent)) != null) {
                        return bVarD;
                    }
                }
            } else if (bVar.tc() && bVar.gb() > 0.0f) {
                RectF rectF2 = new RectF();
                gb gbVar = this.h;
                if (gbVar != null && gbVar.gb()) {
                    bVar.d(rectF2, bVar.an(), true);
                    RectF rectFUs = this.h.us();
                    if (rectFUs != null) {
                        d(rectF2, rectFUs);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    bVar.d(rectF3, bVar.an(), true);
                    hc(rectF2, rectF3);
                }
                if (d(motionEvent, rectF2)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private boolean d(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void d(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass5.d[getScaleType().ordinal()];
        if (i == 1) {
            d(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            hc(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            b(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            c(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF);
    }

    /* renamed from: com.bytedance.adsdk.lottie.LottieAnimationView$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            d = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void hc(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = this.h.getBounds().width();
        float fHeight = this.h.getBounds().height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass5.d[getScaleType().ordinal()];
        if (i == 1) {
            d(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            hc(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            b(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            c(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF, rectF2);
    }

    private void d(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 / f4 >= f / f2) {
            float f5 = f2 / f4;
            matrix.preScale(f5, f5);
            matrix.postTranslate(-(((f3 * f5) - f) / 2.0f), 0.0f);
        } else {
            float f6 = f / f3;
            matrix.preScale(f6, f6);
            matrix.postTranslate(0.0f, -(((f4 * f6) - f2) / 2.0f));
        }
    }

    private void hc(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 < f && f4 < f2) {
            matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
            return;
        }
        if (f3 / f4 >= f / f2) {
            float f5 = f / f3;
            matrix.preScale(f5, f5);
            matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
        } else {
            float f6 = f2 / f4;
            matrix.preScale(f6, f6);
            matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
        }
    }

    private void b(Matrix matrix, float f, float f2, float f3, float f4) {
        matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
    }

    private void c(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 >= f || f4 >= f2) {
            if (f3 / f4 >= f / f2) {
                float f5 = f / f3;
                matrix.preScale(f5, f5);
                matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
                return;
            } else {
                float f6 = f2 / f4;
                matrix.preScale(f6, f6);
                matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
                return;
            }
        }
        if (f3 / f4 >= f / f2) {
            float f7 = f / f3;
            matrix.preScale(f7, f7);
            matrix.postTranslate(0.0f, (f2 - (f4 * f7)) / 2.0f);
        } else {
            float f8 = f2 / f4;
            matrix.preScale(f8, f8);
            matrix.postTranslate((f - (f3 * f8)) / 2.0f, 0.0f);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.d = this.gb;
        bVar.hc = this.tt;
        bVar.b = this.h.s();
        bVar.c = this.h.np();
        bVar.u = this.h.u();
        bVar.an = this.h.sy();
        bVar.h = this.h.de();
        return bVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.gb = bVar.d;
        if (!this.uo.contains(c.SET_ANIMATION) && !TextUtils.isEmpty(this.gb)) {
            setAnimation(this.gb);
        }
        this.tt = bVar.hc;
        if (!this.uo.contains(c.SET_ANIMATION) && (i = this.tt) != 0) {
            setAnimation(i);
        }
        if (!this.uo.contains(c.SET_PROGRESS)) {
            d(bVar.b, false);
        }
        if (!this.uo.contains(c.PLAY_OPTION) && bVar.c) {
            d();
        }
        if (!this.uo.contains(c.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(bVar.u);
        }
        if (!this.uo.contains(c.SET_REPEAT_MODE)) {
            setRepeatMode(bVar.an);
        }
        if (this.uo.contains(c.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(bVar.h);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.mk) {
            return;
        }
        this.h.mq();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w();
        Handler handler = this.rf;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        c();
        b();
        an();
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.h.h(z);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.h.gb(z);
    }

    public void d(boolean z, Context context) {
        this.h.d(z, context);
    }

    public void setClipToCompositionBounds(boolean z) {
        this.h.d(z);
    }

    public boolean getClipToCompositionBounds() {
        return this.h.c();
    }

    public void setCacheComposition(boolean z) {
        this.mq = z;
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.h.c(z);
    }

    public void setAnimation(int i) {
        this.tt = i;
        this.gb = null;
        setCompositionTask(d(i));
    }

    private uo<an> d(final int i) {
        if (isInEditMode()) {
            return new uo<>(new Callable<mq<an>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.13
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public mq<an> call() throws Exception {
                    return LottieAnimationView.this.mq ? h.hc(LottieAnimationView.this.getContext(), i) : h.hc(LottieAnimationView.this.getContext(), i, (String) null);
                }
            }, true);
        }
        return this.mq ? h.d(getContext(), i) : h.d(getContext(), i, (String) null);
    }

    public void setAnimation(String str) {
        this.gb = str;
        this.tt = 0;
        setCompositionTask(hc(str));
    }

    private uo<an> hc(final String str) {
        if (isInEditMode()) {
            return new uo<>(new Callable<mq<an>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public mq<an> call() throws Exception {
                    return LottieAnimationView.this.mq ? h.b(LottieAnimationView.this.getContext(), str) : h.b(LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        return this.mq ? h.hc(getContext(), str) : h.hc(getContext(), str, (String) null);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        d(str, (String) null);
    }

    public void d(String str, String str2) {
        d(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void d(InputStream inputStream, String str) {
        setCompositionTask(h.d(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.mq ? h.d(getContext(), str) : h.d(getContext(), str, (String) null));
    }

    public void setFailureListener(tc<Throwable> tcVar) {
        this.u = tcVar;
    }

    public void setFallbackResource(int i) {
        this.an = i;
    }

    private void setCompositionTask(uo<an> uoVar) {
        this.uo.add(c.SET_ANIMATION);
        yo();
        k();
        this.e = uoVar.d(this.b).b(this.c);
    }

    private void k() {
        uo<an> uoVar = this.e;
        if (uoVar != null) {
            uoVar.hc(this.b);
            this.e.c(this.c);
        }
    }

    private com.bytedance.adsdk.lottie.model.layer.an d(com.bytedance.adsdk.lottie.model.layer.c cVar, String str) {
        for (com.bytedance.adsdk.lottie.model.layer.b bVar : cVar.k()) {
            if (bVar instanceof com.bytedance.adsdk.lottie.model.layer.c) {
                com.bytedance.adsdk.lottie.model.layer.an anVarD = d((com.bytedance.adsdk.lottie.model.layer.c) bVar, str);
                if (anVarD != null) {
                    return anVarD;
                }
            } else if (TextUtils.equals(str, bVar.mk()) && (bVar instanceof com.bytedance.adsdk.lottie.model.layer.an)) {
                return (com.bytedance.adsdk.lottie.model.layer.an) bVar;
            }
        }
        return null;
    }

    private com.bytedance.adsdk.lottie.model.layer.an b(String str) {
        com.bytedance.adsdk.lottie.model.layer.c cVarB;
        gb gbVar = this.h;
        if (gbVar == null || (cVarB = gbVar.b()) == null) {
            return null;
        }
        return d(cVarB, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() throws java.lang.NumberFormatException {
        /*
            r9 = this;
            com.bytedance.adsdk.lottie.an r0 = r9.cb
            if (r0 == 0) goto Le6
            com.bytedance.adsdk.lottie.gb r0 = r9.h
            if (r0 == 0) goto Le6
            com.bytedance.adsdk.lottie.jh r0 = r0.yi()
            com.bytedance.adsdk.lottie.an r1 = r9.cb
            com.bytedance.adsdk.lottie.an$c r1 = r1.gb()
            if (r1 == 0) goto Le6
            if (r0 == 0) goto Le6
            int r2 = r1.d
            java.lang.String r3 = "TMe"
            if (r2 >= 0) goto L2a
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "--==--- timer fail, ke is invalid: "
            java.lang.String r0 = r1.concat(r0)
            com.bytedance.sdk.component.utils.mq.d(r3, r0)
            return
        L2a:
            int[] r4 = r1.u
            r5 = -1
            if (r4 == 0) goto L40
            int[] r4 = r1.u
            int r4 = r4.length
            r6 = 2
            if (r4 < r6) goto L40
            int[] r4 = r1.u
            r6 = 0
            r4 = r4[r6]
            int[] r6 = r1.u
            r7 = 1
            r6 = r6[r7]
            goto L42
        L40:
            r4 = r5
            r6 = r4
        L42:
            java.lang.String r7 = r1.b
            java.lang.String r7 = r0.d(r7)
            java.lang.String r8 = r1.c
            java.lang.String r0 = r0.d(r8)
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.NumberFormatException -> L59
            int r5 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L57
            goto L5e
        L57:
            r0 = move-exception
            goto L5b
        L59:
            r0 = move-exception
            r7 = r5
        L5b:
            com.bytedance.sdk.component.utils.mq.d(r0)
        L5e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r8 = "--==--- prepare timer, startS: "
            r0.<init>(r8)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r8 = ", lenS: "
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.utils.mq.d(r3, r0)
            java.lang.String r0 = r1.hc
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Ld2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r8 = "--==--- timer, id:"
            r0.<init>(r8)
            java.lang.String r8 = r1.hc
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.utils.mq.d(r3, r0)
            java.lang.String r0 = r1.hc
            com.bytedance.adsdk.lottie.model.layer.an r0 = r9.b(r0)
            if (r0 == 0) goto Ld1
            java.lang.String r8 = "--==--- timer success"
            com.bytedance.sdk.component.utils.mq.d(r3, r8)
            java.lang.String r3 = r1.an
            r9.he = r3
            org.json.JSONArray r1 = r1.h
            r9.vv = r1
            r9.sy = r0
            r9.de = r7
            int r1 = r7 - r5
            r9.v = r1
            r9.np = r4
            r9.yi = r6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r3 = r9.de
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.d(r1)
            com.bytedance.adsdk.lottie.LottieAnimationView$3 r0 = new com.bytedance.adsdk.lottie.LottieAnimationView$3
            r0.<init>()
            r9.d(r0)
        Ld1:
            return
        Ld2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "--==--- timer fail, id is invalid: "
            r0.<init>(r2)
            java.lang.String r1 = r1.hc
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.utils.mq.d(r3, r0)
        Le6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.LottieAnimationView.e():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb() {
        this.w.postDelayed(this.zw, 1000L);
    }

    private void w() {
        this.w.removeCallbacksAndMessages(null);
    }

    public void setComposition(an anVar) {
        boolean z = u.d;
        this.h.setCallback(this);
        this.cb = anVar;
        this.tc = true;
        boolean zD = this.h.d(anVar, getContext().getApplicationContext());
        this.tc = false;
        if (getDrawable() != this.h || zD) {
            if (!zD) {
                rf();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<Object> it = this.k.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public an getComposition() {
        return this.cb;
    }

    public void d() {
        if (this.jh == 0) {
            this.jh = SystemClock.elapsedRealtime();
        }
        this.uo.add(c.PLAY_OPTION);
        this.h.mq();
    }

    public void hc() {
        this.uo.add(c.PLAY_OPTION);
        this.h.k();
    }

    public void setMinFrame(int i) {
        this.h.d(i);
    }

    public float getMinFrame() {
        return this.h.e();
    }

    public void setMinProgress(float f) {
        this.h.d(f);
    }

    public void setMaxFrame(int i) {
        this.h.hc(i);
    }

    public float getMaxFrame() {
        return this.h.cb();
    }

    public void setMaxProgress(float f) {
        this.h.hc(f);
    }

    public void setMinFrame(String str) {
        this.h.hc(str);
    }

    public void setMaxFrame(String str) {
        this.h.b(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.h.c(str);
    }

    public void setSpeed(float f) {
        this.h.b(f);
    }

    public float getSpeed() {
        return this.h.w();
    }

    public void d(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.h.d(animatorUpdateListener);
    }

    public void hc(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.h.hc(animatorUpdateListener);
    }

    public void b() {
        this.h.yo();
    }

    public void d(Animator.AnimatorListener animatorListener) {
        this.h.d(animatorListener);
    }

    public void hc(Animator.AnimatorListener animatorListener) {
        this.h.hc(animatorListener);
    }

    public void c() {
        this.h.rf();
    }

    @Deprecated
    public void d(boolean z) {
        this.h.u(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.uo.add(c.SET_REPEAT_MODE);
        this.h.c(i);
    }

    public int getRepeatMode() {
        return this.h.sy();
    }

    public void setRepeatCount(int i) {
        this.uo.add(c.SET_REPEAT_COUNT);
        this.h.u(i);
    }

    public int getRepeatCount() {
        return this.h.de();
    }

    public boolean u() {
        return this.h.v();
    }

    public void setImageAssetsFolder(String str) {
        this.h.d(str);
    }

    public String getImageAssetsFolder() {
        return this.h.u();
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.h.hc(z);
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.h.an();
    }

    public Bitmap d(String str, Bitmap bitmap) {
        return this.h.d(str, bitmap);
    }

    public void setImageAssetDelegate(com.bytedance.adsdk.lottie.c cVar) {
        this.h.d(cVar);
    }

    public void setDefaultFontFileExtension(String str) {
        this.h.h(str);
    }

    public void setFontAssetDelegate(com.bytedance.adsdk.lottie.b bVar) {
        this.h.d(bVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.h.d(map);
    }

    public void setTextDelegate(jh jhVar) {
        this.h.d(jhVar);
    }

    public void setViewDelegate(sy syVar) {
        this.h.d(syVar);
    }

    public void an() {
        this.uo.add(c.PLAY_OPTION);
        this.h.zw();
    }

    public void h() {
        this.mk = false;
        this.h.j();
    }

    public void setFrame(int i) {
        this.h.b(i);
    }

    public int getFrame() {
        return this.h.jh();
    }

    public void setProgress(float f) {
        d(f, true);
    }

    private void d(float f, boolean z) {
        if (z) {
            this.uo.add(c.SET_PROGRESS);
        }
        this.h.c(f);
    }

    public float getProgress() {
        return this.h.s();
    }

    public long getDuration() {
        an anVar = this.cb;
        if (anVar != null) {
            return (long) anVar.u();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.h.b(z);
    }

    public yo getPerformanceTracker() {
        return this.h.tt();
    }

    private void yo() {
        this.cb = null;
        this.h.mk();
    }

    public void setSafeMode(boolean z) {
        this.h.an(z);
    }

    public void setRenderMode(rf rfVar) {
        this.h.d(rfVar);
    }

    public rf getRenderMode() {
        return this.h.h();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.h.u(z);
    }

    private void rf() {
        boolean zU = u();
        setImageDrawable(null);
        setImageDrawable(this.h);
        if (zU) {
            this.h.k();
        }
    }

    private static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.b.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i) {
                return new b[i];
            }
        };
        int an;
        float b;
        boolean c;
        String d;
        int h;
        int hc;
        String u;

        b(Parcelable parcelable) {
            super(parcelable);
        }

        private b(Parcel parcel) {
            super(parcel);
            this.d = parcel.readString();
            this.b = parcel.readFloat();
            this.c = parcel.readInt() == 1;
            this.u = parcel.readString();
            this.an = parcel.readInt();
            this.h = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.d);
            parcel.writeFloat(this.b);
            parcel.writeInt(this.c ? 1 : 0);
            parcel.writeString(this.u);
            parcel.writeInt(this.an);
            parcel.writeInt(this.h);
        }
    }

    public void setLottieClicklistener(hc hcVar) {
        this.j = hcVar;
    }

    public void setLottieAnimListener(d dVar) {
        this.s = dVar;
    }
}
