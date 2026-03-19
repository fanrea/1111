package com.tk.core.component.a;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.a.c;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e extends c implements c.b {
    public boolean ach;
    private HashMap aci;
    private float acj;
    private float ack;
    private float acl;
    private float acm;
    private float acn;
    private float aco;
    private float acp;
    private float acq;

    @Deprecated
    public ArrayList<a> acr;
    private JsValueRef<V8Array> acs;

    public e(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.aci = new HashMap();
        this.acj = 1.0f;
        this.ack = 1.0f;
        this.acl = 0.0f;
        this.acm = 0.0f;
        this.acn = 0.0f;
        this.aco = 0.0f;
        this.acp = 0.0f;
        this.acq = 1.0f;
        a((c.b) this);
    }

    @Override // com.tk.core.component.a.c
    public final boolean qI() {
        return this.acs != null;
    }

    @Override // com.tk.core.component.a.c
    public final void C(float f) {
        this.abS = f;
    }

    public final void G(Object obj) {
        if (obj instanceof V8Array) {
            ad.unRetainJsValue(this.acs);
            this.acs = ad.retainJsValue((V8Array) obj, this);
        }
    }

    public final void c(c.a aVar) {
        JsValueRef<V8Array> jsValueRef = this.acs;
        if (jsValueRef == null) {
            return;
        }
        V8Array v8Array = jsValueRef.get();
        if (ad.isV8Valid(v8Array)) {
            int length = v8Array.length();
            for (int i = 0; i < length; i++) {
                try {
                    Object obj = v8Array.get(i);
                    if (obj instanceof V8Function) {
                        V8Function v8Function = (V8Function) obj;
                        Object objCall = v8Function.call(null, v8Function);
                        if (objCall instanceof Number) {
                            aVar.c(i, ((Number) objCall).floatValue(), length);
                        }
                    }
                } catch (Throwable th) {
                    com.tk.core.i.a.a("TKKeyframeAnimation", "executeAnimationFunction", th);
                    com.tk.core.exception.a.a(pO(), th);
                    return;
                }
            }
        }
    }

    public final void a(ArrayList<a> arrayList) {
        this.acr = new ArrayList<>();
        Object[] array = arrayList.toArray();
        for (int i = 0; i < array.length; i++) {
            Object value = V8ObjectUtilsQuick.getValue(array[i]);
            a aVar = new a();
            Map map = (Map) value;
            if (map.containsKey(ILogConst.Keys.KEY_PERCENT)) {
                aVar.act = ((Number) map.get(ILogConst.Keys.KEY_PERCENT)).floatValue();
            }
            if (map.containsKey(com.alipay.sdk.m.p0.b.d)) {
                aVar.value = map.get(com.alipay.sdk.m.p0.b.d);
            }
            if (map.containsKey("easing")) {
                aVar.acu = (String) map.get("easing");
            }
            if (aVar.act == 0.0f) {
                if (array.length == 1) {
                    aVar.act = 1.0f;
                } else if (i > 0) {
                    aVar.act = (1.0f / (array.length - 1)) * i;
                }
            }
            this.acr.add(aVar);
        }
    }

    @Override // com.tk.core.component.a.c
    protected final void aT(View view) {
        Keyframe[] keyframeArr = new Keyframe[this.acr.size()];
        Keyframe[] keyframeArr2 = new Keyframe[this.acr.size()];
        for (int i = 0; i < this.acr.size(); i++) {
            a aVar = this.acr.get(i);
            String[] strArrE = E(aVar.value);
            Keyframe keyframeOfFloat = Keyframe.ofFloat(aVar.act, bL(strArrE[0]));
            Keyframe keyframeOfFloat2 = Keyframe.ofFloat(aVar.act, bL(strArrE[1]));
            keyframeArr[i] = keyframeOfFloat;
            keyframeArr2[i] = keyframeOfFloat2;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe("translationX", keyframeArr), PropertyValuesHolder.ofKeyframe("translationY", keyframeArr2));
        this.abV = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(qK());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(getRepeatCount());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(this.abU ? 2 : 1);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(qL());
        objectAnimatorOfPropertyValuesHolder.setInterpolator(getInterpolator());
        objectAnimatorOfPropertyValuesHolder.addListener(this.RP);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    @Override // com.tk.core.component.a.c
    protected final void q(View view, int i) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder;
        Keyframe[] keyframeArr = new Keyframe[this.acr.size()];
        for (int i2 = 0; i2 < this.acr.size(); i2++) {
            a aVar = this.acr.get(i2);
            keyframeArr[i2] = Keyframe.ofFloat(aVar.act, bM(F(aVar.value)));
        }
        if (i == 11) {
            objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe("scaleX", keyframeArr));
        } else if (i == 12) {
            objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe("scaleY", keyframeArr));
        } else {
            objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe("scaleX", keyframeArr), PropertyValuesHolder.ofKeyframe("scaleY", keyframeArr));
        }
        this.abV = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(qK());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(getRepeatCount());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(this.abU ? 2 : 1);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(qL());
        objectAnimatorOfPropertyValuesHolder.setInterpolator(getInterpolator());
        objectAnimatorOfPropertyValuesHolder.addListener(this.RP);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    @Override // com.tk.core.component.a.c
    protected final void r(View view, int i) {
        String str = i != 1 ? i != 2 ? "rotation" : "rotationY" : "rotationX";
        Keyframe[] keyframeArr = new Keyframe[this.acr.size()];
        for (int i2 = 0; i2 < this.acr.size(); i2++) {
            a aVar = this.acr.get(i2);
            keyframeArr[i2] = Keyframe.ofFloat(aVar.act, bM(F(aVar.value)));
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(str, keyframeArr));
        this.abV = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(qK());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(getRepeatCount());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(this.abU ? 2 : 1);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(qL());
        objectAnimatorOfPropertyValuesHolder.setInterpolator(getInterpolator());
        objectAnimatorOfPropertyValuesHolder.addListener(this.RP);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    @Override // com.tk.core.component.a.c
    protected final void aU(View view) {
        Keyframe[] keyframeArr = new Keyframe[this.acr.size()];
        for (int i = 0; i < this.acr.size(); i++) {
            a aVar = this.acr.get(i);
            keyframeArr[i] = Keyframe.ofFloat(aVar.act, bM(F(aVar.value)));
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe("alpha", keyframeArr));
        this.abV = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(qK());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(getRepeatCount());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(this.abU ? 2 : 1);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(qL());
        objectAnimatorOfPropertyValuesHolder.setInterpolator(getInterpolator());
        objectAnimatorOfPropertyValuesHolder.addListener(this.RP);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    @Override // com.tk.core.component.a.c
    protected final void aV(View view) {
        Keyframe[] keyframeArr = new Keyframe[this.acr.size()];
        for (int i = 0; i < this.acr.size(); i++) {
            a aVar = this.acr.get(i);
            keyframeArr[i] = Keyframe.ofInt(aVar.act, parseColor(F(aVar.value)));
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(com.baidu.mobads.container.n.f.T, keyframeArr));
        this.abV = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(qK());
        objectAnimatorOfPropertyValuesHolder.setEvaluator(new ArgbEvaluator());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(getRepeatCount());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(this.abU ? 2 : 1);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(qL());
        objectAnimatorOfPropertyValuesHolder.setInterpolator(getInterpolator());
        objectAnimatorOfPropertyValuesHolder.addListener(this.RP);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    @Override // com.tk.core.component.a.c.b
    public final void qN() {
        qP();
    }

    public class a {
        public float act;
        public String acu;
        public Object value;

        public a() {
        }
    }

    public final void qO() {
        if (this.uS == null || !this.ach) {
            return;
        }
        this.acj = this.uS.getScaleX();
        this.ack = this.uS.getScaleY();
        this.acl = this.uS.getTranslationX();
        this.acm = this.uS.getTranslationY();
        this.acn = this.uS.getRotationX();
        this.aco = this.uS.getRotationY();
        this.acp = this.uS.getRotation();
        this.acq = this.uS.getAlpha();
        this.aci.putAll(this.abW.style);
    }

    private void qP() {
        if (this.uS == null || !this.ach) {
            return;
        }
        this.abW.a(this.aci);
        this.abW.pR().rR();
        this.uS.setScaleX(this.acj);
        this.uS.setScaleY(this.ack);
        this.uS.setTranslationX(this.acl);
        this.uS.setTranslationY(this.acm);
        this.uS.setRotationX(this.acn);
        this.uS.setRotationY(this.aco);
        this.uS.setAlpha(this.acq);
        this.uS.setRotation(this.acp);
    }

    @Override // com.tk.core.component.a.c, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.acs);
    }
}
