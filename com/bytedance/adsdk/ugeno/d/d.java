package com.bytedance.adsdk.ugeno.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.d.b;
import com.bytedance.adsdk.ugeno.d.d.d;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends AnimatorListenerAdapter {
    private int an = 1;
    private ValueAnimator b;
    private Context c;
    private com.bytedance.adsdk.ugeno.hc.b d;
    private String gb;
    private com.bytedance.adsdk.ugeno.d.d.d h;
    private b hc;
    private hc tt;
    private int u;

    public d(Context context, com.bytedance.adsdk.ugeno.hc.b bVar, b bVar2) {
        this.d = bVar;
        this.hc = bVar2;
        this.c = context;
    }

    public void d() {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator == null || this.u == -2 || this.an == 0) {
            return;
        }
        valueAnimator.start();
    }

    public void d(hc hcVar) {
        this.tt = hcVar;
    }

    public void hc() {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void b() {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public ValueAnimator c() {
        String key;
        com.bytedance.adsdk.ugeno.d.hc.d bVar;
        b bVar2 = this.hc;
        if (bVar2 == null || this.d == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> mapHc = bVar2.hc();
        ArrayList arrayList = new ArrayList();
        if (mapHc != null && !mapHc.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : mapHc.entrySet()) {
                if (entry != null) {
                    key = entry.getKey();
                    String strB = u.d(key).b();
                    strB.hashCode();
                    switch (strB) {
                        case "int":
                            bVar = new com.bytedance.adsdk.ugeno.d.hc.b(this.c, this.d, key, entry.getValue());
                            break;
                        case "float":
                            bVar = new com.bytedance.adsdk.ugeno.d.hc.hc(this.c, this.d, key, entry.getValue());
                            break;
                        case "point":
                            bVar = new com.bytedance.adsdk.ugeno.d.hc.c(this.c, this.d, key, entry.getValue());
                            break;
                        default:
                            bVar = null;
                            break;
                    }
                    if (bVar != null) {
                        arrayList.addAll(bVar.u());
                    }
                }
            }
        }
        JSONObject jSONObjectD = this.hc.d();
        if (jSONObjectD != null) {
            com.bytedance.adsdk.ugeno.d.d.d dVarD = d.C0175d.d(this.d, jSONObjectD);
            this.h = dVarD;
            if (dVarD != null) {
                arrayList.addAll(dVarD.b());
            }
        }
        final View viewTt = this.d.tt();
        if (viewTt == null) {
            return null;
        }
        final b.d dVarH = this.hc.h();
        if (dVarH != null) {
            viewTt.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.d.d.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = viewTt.getWidth();
                    int height = viewTt.getHeight();
                    viewTt.setPivotX(c.d(dVarH.d, width));
                    viewTt.setPivotY(c.d(dVarH.hc, height));
                }
            });
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewTt, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.u = c.d(this.hc.c());
        objectAnimatorOfPropertyValuesHolder.setDuration(this.hc.b());
        int i = this.u;
        if (i != -2) {
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(i);
        }
        this.an = this.hc.tc();
        this.gb = this.hc.tt();
        objectAnimatorOfPropertyValuesHolder.setStartDelay(this.hc.an());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(c.d(this.hc.u()));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(c.hc(this.hc.gb()));
        objectAnimatorOfPropertyValuesHolder.addListener(this);
        this.b = objectAnimatorOfPropertyValuesHolder;
        return objectAnimatorOfPropertyValuesHolder;
    }

    public void d(Canvas canvas) {
        com.bytedance.adsdk.ugeno.d.d.d dVar = this.h;
        if (dVar != null) {
            dVar.d(canvas);
        }
    }

    public void d(int i, int i2) {
        com.bytedance.adsdk.ugeno.d.d.d dVar = this.h;
        if (dVar != null) {
            dVar.d(i, i2);
        }
    }

    public String u() {
        return this.gb;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        hc hcVar = this.tt;
        if (hcVar != null) {
            hcVar.d();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        hc hcVar = this.tt;
        if (hcVar != null) {
            hcVar.hc();
        }
    }
}
