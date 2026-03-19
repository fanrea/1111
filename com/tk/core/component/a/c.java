package com.tk.core.component.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.sigmob.sdk.base.mta.PointCategory;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.view.TKViewBackgroundDrawable;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class c extends TKBaseNativeModule {
    protected AnimatorListenerAdapter RP;

    @Deprecated
    public Object abO;

    @Deprecated
    public String abP;

    @Deprecated
    public float abQ;

    @Deprecated
    public String abR;
    public float abS;
    public String abT;
    public boolean abU;
    protected Animator abV;
    protected com.tk.core.component.e abW;
    protected JsValueRef<V8Function> abX;
    protected JsValueRef<V8Function> abY;
    protected JsValueRef<V8Function> abZ;
    protected JsValueRef<V8Function> aca;
    protected Map<String, AnimatorSet> acb;
    private String acc;
    private b acd;
    private Runnable ace;
    public int repeatCount;
    protected View uS;

    public interface a {
        void B(float f);

        void c(int i, float f, int i2);
    }

    public interface b {
        void qN();
    }

    public c(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.RP = new AnimatorListenerAdapter() { // from class: com.tk.core.component.a.c.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.acd != null) {
                    b unused = c.this.acd;
                }
                if (c.this.qI()) {
                    c.this.qJ();
                } else {
                    ac.a(c.this.ace, c.this.qL());
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.acd != null) {
                    c.this.acd.qN();
                }
                if (c.this.abY == null || !ad.isV8Valid(c.this.abY.get())) {
                    return;
                }
                try {
                    c.this.abY.get().call(null, Boolean.TRUE);
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(c.this.pO(), th);
                }
            }
        };
        this.ace = new Runnable() { // from class: com.tk.core.component.a.c.4
            @Override // java.lang.Runnable
            public final void run() {
                c.this.qJ();
            }
        };
        this.acb = new HashMap();
    }

    public boolean qI() {
        return (this.abZ == null && this.aca == null) ? false : true;
    }

    @Deprecated
    public final void bI(String str) {
        this.abR = str;
    }

    public final void bJ(String str) {
        this.abT = str;
    }

    public final void B(Object obj) {
        this.abO = obj;
    }

    public final void a(b bVar) {
        this.acd = bVar;
    }

    public final void C(Object obj) {
        if (obj instanceof V8Function) {
            JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue((V8Function) obj, this);
            ad.unRetainJsValue(this.abZ);
            this.abZ = jsValueRefRetainJsValue;
        }
    }

    public final void a(a aVar) {
        JsValueRef<V8Function> jsValueRef = this.abZ;
        if (jsValueRef == null || !ad.isV8Valid(jsValueRef.get())) {
            return;
        }
        try {
            this.abZ.get().call(null, new Object[0]);
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
        JsValueRef<V8Function> jsValueRef2 = this.aca;
        aVar.B((jsValueRef2 == null || jsValueRef2.get() == null) ? 1.0f : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qJ() {
        JsValueRef<V8Function> jsValueRef = this.abX;
        if (jsValueRef == null || !ad.isV8Valid(jsValueRef.get())) {
            return;
        }
        try {
            this.abX.get().call(null, new Object[0]);
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
    }

    public final void D(Object obj) {
        if (obj instanceof V8Function) {
            JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue((V8Function) obj, this);
            ad.unRetainJsValue(this.aca);
            this.aca = jsValueRefRetainJsValue;
        }
    }

    public final void b(a aVar) {
        JsValueRef<V8Function> jsValueRef = this.aca;
        if (jsValueRef == null || !ad.isV8Valid(jsValueRef.get())) {
            return;
        }
        try {
            this.aca.get().call(null, new Object[0]);
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
        aVar.B(1.0f);
    }

    public final void bK(String str) {
        this.abP = str;
    }

    public void C(float f) {
        this.abS = f;
    }

    public final void setDelay(float f) {
        this.abQ = f;
    }

    public final void setRepeatCount(int i) {
        this.repeatCount = i;
    }

    public final void aq(boolean z) {
        this.abU = z;
    }

    protected final long qK() {
        return (long) this.abS;
    }

    protected final int qL() {
        return (int) this.abQ;
    }

    public final int getRepeatCount() {
        int i = this.repeatCount;
        if (i == 0) {
            return this.abU ? 1 : 0;
        }
        if (i >= Integer.MAX_VALUE || i < 0) {
            return -1;
        }
        return this.abU ? (i * 2) - 1 : i - 1;
    }

    protected final TimeInterpolator getInterpolator() {
        if ("Linear".equalsIgnoreCase(this.abR)) {
            return new LinearInterpolator();
        }
        if ("EaseIn".equalsIgnoreCase(this.abR)) {
            return new AccelerateInterpolator();
        }
        if ("EaseOut".equalsIgnoreCase(this.abR)) {
            return new DecelerateInterpolator();
        }
        if ("EaseInEaseOut".equalsIgnoreCase(this.abR)) {
            return new AccelerateDecelerateInterpolator();
        }
        if ("linear".equalsIgnoreCase(this.abT)) {
            return com.tk.core.component.a.a.a.qT();
        }
        if ("ease-in".equalsIgnoreCase(this.abT)) {
            return com.tk.core.component.a.a.a.qQ();
        }
        if ("ease-out".equalsIgnoreCase(this.abT)) {
            return com.tk.core.component.a.a.a.qR();
        }
        if ("ease-in-out".equalsIgnoreCase(this.abT)) {
            return com.tk.core.component.a.a.a.qS();
        }
        if (!TextUtils.isEmpty(this.abT)) {
            String[] strArrSplit = this.abT.split(" ");
            if (4 != strArrSplit.length) {
                return new AccelerateDecelerateInterpolator();
            }
            try {
                return new com.tk.core.component.a.a.a(Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3]));
            } catch (Throwable unused) {
                return new AccelerateDecelerateInterpolator();
            }
        }
        return new AccelerateDecelerateInterpolator();
    }

    protected static String[] E(Object obj) {
        if (!(obj instanceof Map)) {
            return null;
        }
        Map map = (Map) obj;
        String[] strArr = new String[2];
        Object obj2 = map.get("x");
        if (obj2 instanceof String) {
            strArr[0] = (String) obj2;
        } else {
            strArr[0] = String.valueOf(obj2);
        }
        Object obj3 = map.get("y");
        if (obj3 instanceof String) {
            strArr[1] = (String) obj3;
            return strArr;
        }
        strArr[1] = String.valueOf(obj3);
        return strArr;
    }

    protected static String F(Object obj) {
        if (obj instanceof Map) {
            return (String) ((Map) obj).get(com.alipay.sdk.m.p0.b.d);
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return String.valueOf(obj);
    }

    protected static float bL(String str) throws NumberFormatException {
        float fP;
        float f = 0.0f;
        try {
            if (str.toLowerCase().endsWith("px")) {
                fP = Float.parseFloat(str.replace("px", ""));
            } else {
                f = Float.parseFloat(str);
                fP = o.P(f);
            }
            return fP;
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        }
    }

    protected static float bM(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    protected static int parseColor(String str) {
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final void m(String str, V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        if ("start".equalsIgnoreCase(str)) {
            ad.unRetainJsValue(this.abX);
            this.abX = jsValueRefRetainJsValue;
        } else if (PointCategory.END.equalsIgnoreCase(str)) {
            ad.unRetainJsValue(this.abY);
            this.abY = jsValueRefRetainJsValue;
        }
    }

    public final void bN(String str) {
        AnimatorSet animatorSet;
        if (qM() || (animatorSet = this.acb.get(str)) == null) {
            return;
        }
        a(animatorSet);
    }

    private void a(AnimatorSet animatorSet) {
        if (Build.VERSION.SDK_INT >= 19) {
            b(animatorSet);
        } else {
            c(animatorSet);
        }
    }

    private static void b(AnimatorSet animatorSet) {
        animatorSet.pause();
    }

    private static void c(AnimatorSet animatorSet) {
        animatorSet.cancel();
    }

    public final void bO(String str) {
        AnimatorSet animatorSet;
        if (qM() || (animatorSet = this.acb.get(str)) == null) {
            return;
        }
        d(animatorSet);
    }

    private void d(AnimatorSet animatorSet) {
        if (Build.VERSION.SDK_INT >= 19) {
            e(animatorSet);
        } else {
            f(animatorSet);
        }
    }

    private static void e(AnimatorSet animatorSet) {
        animatorSet.resume();
    }

    private static void f(AnimatorSet animatorSet) {
        animatorSet.start();
    }

    private void bP(String str) {
        HashMap<Float, HashMap<String, Object>> map;
        List<Animator> listG;
        HashMap<String, HashMap<Float, HashMap<String, Object>>> mapPS = this.abW.pS();
        if (TextUtils.isEmpty(str) || mapPS.isEmpty() || (map = mapPS.get(str)) == null || map.isEmpty() || (listG = g(map)) == null || listG.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(qK());
        animatorSet.playTogether(listG);
        animatorSet.setInterpolator(getInterpolator());
        animatorSet.addListener(this.RP);
        animatorSet.start();
        this.acb.put(str, animatorSet);
    }

    private ObjectAnimator a(String str, Map<Float, Object> map) {
        List<Keyframe> listH = h(map);
        if (listH == null || listH.isEmpty()) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.uS, PropertyValuesHolder.ofKeyframe(str, (Keyframe[]) listH.toArray(new Keyframe[0])));
        objectAnimatorOfPropertyValuesHolder.setDuration(qK());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(getRepeatCount());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(this.abU ? 2 : 1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    private ObjectAnimator b(final String str, Map<Float, Object> map) {
        List<Keyframe> listH;
        if (qM() || (listH = h(map)) == null || listH.isEmpty()) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.uS, PropertyValuesHolder.ofKeyframe(String.format("_%s", str), (Keyframe[]) listH.toArray(new Keyframe[0])));
        if (com.baidu.mobads.container.n.f.T.equals(str)) {
            objectAnimatorOfPropertyValuesHolder.setEvaluator(new ArgbEvaluator());
        }
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(getRepeatCount());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(this.abU ? 2 : 1);
        objectAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tk.core.component.a.c.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            /* JADX WARN: Removed duplicated region for block: B:62:0x00e1  */
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onAnimationUpdate(android.animation.ValueAnimator r3) {
                /*
                    Method dump skipped, instructions count: 406
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.a.c.AnonymousClass2.onAnimationUpdate(android.animation.ValueAnimator):void");
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    private List<Keyframe> h(Map<Float, Object> map) {
        if (map == null || 1 >= map.size()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Float, Object> entry : map.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                Object value = entry.getValue();
                if (value instanceof Float) {
                    arrayList.add(Keyframe.ofFloat(entry.getKey().floatValue(), ((Float) value).floatValue()));
                } else if (value instanceof Integer) {
                    arrayList.add(Keyframe.ofInt(entry.getKey().floatValue(), ((Integer) value).intValue()));
                } else if (value instanceof com.kwad.yoga.e) {
                    arrayList.add(Keyframe.ofFloat(entry.getKey().floatValue(), ((com.kwad.yoga.e) value).value));
                }
            }
        }
        Collections.sort(arrayList, new Comparator<Keyframe>() { // from class: com.tk.core.component.a.c.3
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Keyframe keyframe, Keyframe keyframe2) {
                return a(keyframe, keyframe2);
            }

            private static int a(Keyframe keyframe, Keyframe keyframe2) {
                return (int) ((keyframe.getFraction() * 10.0f) - (keyframe2.getFraction() * 10.0f));
            }
        });
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<android.animation.Animator> g(java.util.HashMap<java.lang.Float, java.util.HashMap<java.lang.String, java.lang.Object>> r14) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.a.c.g(java.util.HashMap):java.util.List");
    }

    private static boolean e(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        return ((obj instanceof Float) && (obj2 instanceof Float)) ? ((Float) obj).floatValue() == ((Float) obj2).floatValue() : ((obj instanceof Integer) && (obj2 instanceof Integer)) ? ((Integer) obj).intValue() == ((Integer) obj2).intValue() : (obj instanceof com.kwad.yoga.e) && (obj2 instanceof com.kwad.yoga.e) && Float.compare(((com.kwad.yoga.e) obj).value, ((com.kwad.yoga.e) obj2).value) == 0;
    }

    public final void p(com.tk.core.component.e eVar) {
        this.abW = eVar;
        this.uS = eVar.getView();
    }

    private boolean qM() {
        return this.abW == null || this.uS == null;
    }

    public final void bQ(String str) {
        if (qM()) {
            return;
        }
        this.acc = str;
        if (qI()) {
            bP(str);
        } else if (!TextUtils.isEmpty(this.abP)) {
            aS(this.uS);
        } else if (this.abO != null) {
            a(this.uS, str);
        }
    }

    private void aS(View view) {
        if ("position".equalsIgnoreCase(this.abP)) {
            aT(view);
            return;
        }
        if ("opacity".equalsIgnoreCase(this.abP)) {
            aU(view);
            return;
        }
        if ("scale".equalsIgnoreCase(this.abP)) {
            q(view, 13);
            return;
        }
        if ("scaleX".equalsIgnoreCase(this.abP)) {
            q(view, 11);
            return;
        }
        if ("scaleY".equalsIgnoreCase(this.abP)) {
            q(view, 12);
            return;
        }
        if ("rotationX".equalsIgnoreCase(this.abP)) {
            r(view, 1);
            return;
        }
        if ("rotationY".equalsIgnoreCase(this.abP)) {
            r(view, 2);
        } else if ("rotationZ".equalsIgnoreCase(this.abP)) {
            r(view, 3);
        } else if ("bgColor".equalsIgnoreCase(this.abP)) {
            aV(view);
        }
    }

    private void a(View view, String str) {
        if (this.abO instanceof Map) {
            ObjectAnimator objectAnimatorAW = aW(view);
            ObjectAnimator objectAnimatorAX = aX(view);
            ObjectAnimator objectAnimatorAY = aY(view);
            ObjectAnimator objectAnimatorAZ = aZ(view);
            ObjectAnimator objectAnimatorBa = ba(view);
            ArrayList arrayList = new ArrayList();
            if (objectAnimatorAW != null) {
                arrayList.add(objectAnimatorAW);
            }
            if (objectAnimatorAX != null) {
                arrayList.add(objectAnimatorAX);
            }
            if (objectAnimatorAY != null) {
                arrayList.add(objectAnimatorAY);
            }
            if (objectAnimatorAZ != null) {
                arrayList.add(objectAnimatorAZ);
            }
            if (objectAnimatorBa != null) {
                arrayList.add(objectAnimatorBa);
            }
            if (arrayList.size() == 0) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setStartDelay(qL());
            animatorSet.setInterpolator(getInterpolator());
            animatorSet.addListener(this.RP);
            animatorSet.start();
            this.acb.put(str, animatorSet);
        }
    }

    public final void bR(String str) {
        if (qM()) {
            return;
        }
        AnimatorSet animatorSet = this.acb.get(str);
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            if (animatorSet.isRunning()) {
                animatorSet.end();
            }
            this.acb.remove(str);
        }
        if (qI()) {
            return;
        }
        if (isRunning()) {
            this.abV.cancel();
            this.abV = null;
        }
        ac.d(this.ace);
    }

    private boolean isRunning() {
        Animator animator = this.abV;
        return animator != null && animator.isRunning();
    }

    protected void aT(View view) {
        float[] fArr = {0.0f, 0.0f};
        String[] strArrE = E(this.abO);
        if (strArrE != null && strArrE.length == 2) {
            fArr[0] = bL(strArrE[0]);
            fArr[1] = bL(strArrE[1]);
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", fArr[0]), PropertyValuesHolder.ofFloat("translationY", fArr[1]));
        this.abV = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(getRepeatCount());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(this.abU ? 2 : 1);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(qL());
        objectAnimatorOfPropertyValuesHolder.setInterpolator(getInterpolator());
        objectAnimatorOfPropertyValuesHolder.addListener(this.RP);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    protected void q(View view, int i) {
        ObjectAnimator duration;
        float fBM = bM(F(this.abO));
        if (i == 11) {
            duration = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, fBM).setDuration(qK());
        } else if (i == 12) {
            duration = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, fBM).setDuration(qK());
        } else {
            duration = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", fBM), PropertyValuesHolder.ofFloat("scaleY", fBM));
        }
        this.abV = duration;
        duration.setRepeatCount(getRepeatCount());
        duration.setRepeatMode(this.abU ? 2 : 1);
        duration.setStartDelay(qL());
        duration.setInterpolator(getInterpolator());
        duration.addListener(this.RP);
        duration.start();
    }

    protected void r(View view, int i) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, i != 1 ? i != 2 ? "rotation" : "rotationY" : "rotationX", 0.0f, bM(F(this.abO))).setDuration(qK());
        this.abV = duration;
        duration.setRepeatCount(getRepeatCount());
        duration.setRepeatMode(this.abU ? 2 : 1);
        duration.setStartDelay(qL());
        duration.setInterpolator(getInterpolator());
        duration.addListener(this.RP);
        duration.start();
    }

    protected void aU(View view) {
        float alpha = view.getAlpha();
        float fBM = bM(F(this.abO));
        if (alpha != fBM) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, "alpha", alpha, fBM).setDuration(qK());
            this.abV = duration;
            duration.setRepeatCount(getRepeatCount());
            duration.setRepeatMode(this.abU ? 2 : 1);
            duration.setStartDelay(qL());
            duration.setInterpolator(getInterpolator());
            duration.addListener(this.RP);
            duration.start();
        }
    }

    protected void aV(View view) {
        int color = ((TKViewBackgroundDrawable) view.getBackground()).getColor();
        int color2 = parseColor(F(this.abO));
        if (color != color2) {
            ObjectAnimator duration = ObjectAnimator.ofInt(view, com.baidu.mobads.container.n.f.T, color, color2).setDuration(qK());
            this.abV = duration;
            duration.setRepeatCount(getRepeatCount());
            duration.setRepeatMode(this.abU ? 2 : 1);
            duration.setStartDelay(qL());
            duration.setInterpolator(getInterpolator());
            duration.setEvaluator(new ArgbEvaluator());
            duration.addListener(this.RP);
            duration.start();
        }
    }

    private ObjectAnimator aW(View view) {
        String[] strArrE;
        if (!((Map) this.abO).containsKey("position") || (strArrE = E(((Map) this.abO).get("position"))) == null) {
            return null;
        }
        if (strArrE.length != 2) {
            return null;
        }
        float[] fArr = {0.0f, 0.0f};
        fArr[0] = bL(strArrE[0]);
        fArr[1] = bL(strArrE[1]);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", fArr[0]), PropertyValuesHolder.ofFloat("translationY", fArr[1]));
        objectAnimatorOfPropertyValuesHolder.setDuration(qK());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(getRepeatCount());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(this.abU ? 2 : 1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    private ObjectAnimator aX(View view) {
        String[] strArrE;
        if (!((Map) this.abO).containsKey("scale") || (strArrE = E(((Map) this.abO).get("scale"))) == null) {
            return null;
        }
        if (strArrE.length != 2) {
            return null;
        }
        float[] fArr = {0.0f, 0.0f};
        fArr[0] = bM(strArrE[0]);
        fArr[1] = bM(strArrE[1]);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", fArr[0]), PropertyValuesHolder.ofFloat("scaleY", fArr[1]));
        objectAnimatorOfPropertyValuesHolder.setDuration(qK());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(getRepeatCount());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(this.abU ? 2 : 1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    private ObjectAnimator aY(View view) {
        String[] strArrE;
        if (!((Map) this.abO).containsKey("rotation") || (strArrE = E(((Map) this.abO).get("rotation"))) == null) {
            return null;
        }
        if (strArrE.length != 2) {
            return null;
        }
        float[] fArr = {0.0f, 0.0f};
        fArr[0] = bM(strArrE[0]);
        fArr[1] = bM(strArrE[1]);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("rotationX", fArr[0]), PropertyValuesHolder.ofFloat("rotationY", fArr[1]));
        objectAnimatorOfPropertyValuesHolder.setDuration(qK());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(getRepeatCount());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(this.abU ? 2 : 1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    private ObjectAnimator aZ(View view) {
        if (!((Map) this.abO).containsKey("opacity")) {
            return null;
        }
        float alpha = view.getAlpha();
        float fBM = bM(F(((Map) this.abO).get("opacity")));
        if (alpha == fBM) {
            return null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", alpha, fBM);
        objectAnimatorOfFloat.setDuration(qK());
        objectAnimatorOfFloat.setRepeatCount(getRepeatCount());
        objectAnimatorOfFloat.setRepeatMode(this.abU ? 2 : 1);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator ba(View view) {
        if (!((Map) this.abO).containsKey(com.baidu.mobads.container.n.f.T)) {
            return null;
        }
        Object obj = ((Map) this.abO).get(com.baidu.mobads.container.n.f.T);
        TKViewBackgroundDrawable tKViewBackgroundDrawable = (TKViewBackgroundDrawable) view.getBackground();
        int color = tKViewBackgroundDrawable.getColor();
        int color2 = parseColor(F(obj));
        if (color == color2) {
            return null;
        }
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(tKViewBackgroundDrawable, TypedValues.Custom.S_COLOR, color, color2);
        objectAnimatorOfInt.setDuration(qK());
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        objectAnimatorOfInt.setRepeatCount(getRepeatCount());
        objectAnimatorOfInt.setRepeatMode(this.abU ? 2 : 1);
        return objectAnimatorOfInt;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public void ih() {
        ad.unRetainJsValue(this.abX);
        ad.unRetainJsValue(this.abY);
        ad.unRetainJsValue(this.abZ);
        ad.unRetainJsValue(this.aca);
    }

    public String toString() {
        return super.toString();
    }
}
