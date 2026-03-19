package com.bytedance.adsdk.ugeno.d.hc;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.an.gb;
import com.bytedance.adsdk.ugeno.d.u;
import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends d {
    private List<Keyframe> gb;

    public c(Context context, com.bytedance.adsdk.ugeno.hc.b bVar, String str, Map<Float, String> map) {
        super(context, bVar, str, map);
        this.gb = new ArrayList();
    }

    /* renamed from: com.bytedance.adsdk.ugeno.d.hc.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[u.values().length];
            d = iArr;
            try {
                iArr[u.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[u.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc.d
    public void hc() {
        Keyframe keyframeOfFloat;
        int i = AnonymousClass1.d[this.c.ordinal()];
        Keyframe keyframeOfFloat2 = null;
        if (i == 1) {
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.h.uo());
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.h.k());
        } else if (i != 2) {
            keyframeOfFloat = null;
        } else {
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.h.e());
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.h.cb());
        }
        if (keyframeOfFloat2 != null) {
            this.u.add(keyframeOfFloat2);
        }
        if (keyframeOfFloat != null) {
            this.gb.add(keyframeOfFloat);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc.d
    public void d(float f, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 2) {
                return;
            }
            float fOptDouble = (float) jSONArray.optDouble(0);
            float fOptDouble2 = (float) jSONArray.optDouble(1);
            if (this.c == u.TRANSLATE) {
                fOptDouble = gb.d(this.d, fOptDouble);
                fOptDouble2 = gb.d(this.d, fOptDouble2);
            }
            this.u.add(Keyframe.ofFloat(f, fOptDouble));
            this.gb.add(Keyframe.ofFloat(f, fOptDouble2));
        } catch (JSONException e) {
            mq.d(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc.d
    public List<PropertyValuesHolder> u() {
        String strHc = this.c.hc();
        c();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strHc + "X", (Keyframe[]) this.u.toArray(new Keyframe[0]));
        this.an.add(propertyValuesHolderOfKeyframe);
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(strHc + "Y", (Keyframe[]) this.gb.toArray(new Keyframe[0]));
        this.an.add(propertyValuesHolderOfKeyframe2);
        TypeEvaluator typeEvaluatorAn = an();
        if (typeEvaluatorAn != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorAn);
            propertyValuesHolderOfKeyframe2.setEvaluator(typeEvaluatorAn);
        }
        return this.an;
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc.d
    public TypeEvaluator an() {
        return new FloatEvaluator();
    }
}
