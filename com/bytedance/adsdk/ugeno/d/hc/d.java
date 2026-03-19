package com.bytedance.adsdk.ugeno.d.hc;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.d.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d {
    protected Map<Float, String> b;
    protected u c;
    protected Context d;
    protected com.bytedance.adsdk.ugeno.hc.b h;
    protected String hc;
    protected List<PropertyValuesHolder> an = new ArrayList();
    protected List<Keyframe> u = new ArrayList();

    public abstract TypeEvaluator an();

    public abstract void d(float f, String str);

    public abstract void hc();

    public d(Context context, com.bytedance.adsdk.ugeno.hc.b bVar, String str, Map<Float, String> map) {
        this.d = context;
        this.hc = str;
        this.b = map;
        this.c = u.d(this.hc);
        this.h = bVar;
    }

    public String getType() {
        return this.c.b();
    }

    public boolean d() {
        Map<Float, String> map = this.b;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.b.containsKey(Float.valueOf(0.0f));
    }

    public void b() {
        Map<Float, String> map = this.b;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.b;
        if (map2 instanceof TreeMap) {
            float fFloatValue = ((Float) ((TreeMap) map2).lastKey()).floatValue();
            if (fFloatValue != 100.0f) {
                d(100.0f, this.b.get(Float.valueOf(fFloatValue)));
            }
        }
    }

    public void c() {
        Map<Float, String> map = this.b;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!d()) {
            hc();
        }
        for (Map.Entry<Float, String> entry : this.b.entrySet()) {
            if (entry != null) {
                d(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        b();
    }

    public List<PropertyValuesHolder> u() {
        String strHc = this.c.hc();
        c();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strHc, (Keyframe[]) this.u.toArray(new Keyframe[0]));
        TypeEvaluator typeEvaluatorAn = an();
        if (typeEvaluatorAn != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorAn);
        }
        this.an.add(propertyValuesHolderOfKeyframe);
        return this.an;
    }
}
