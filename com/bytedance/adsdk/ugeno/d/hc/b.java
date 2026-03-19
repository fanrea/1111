package com.bytedance.adsdk.ugeno.d.hc;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.d.u;
import java.util.TreeMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends d {
    public b(Context context, com.bytedance.adsdk.ugeno.hc.b bVar, String str, TreeMap<Float, String> treeMap) {
        super(context, bVar, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc.d
    public void hc() {
        if (this.c == u.BACKGROUND_COLOR) {
            this.u.add(Keyframe.ofInt(0.0f, this.h.hv()));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc.d
    public void d(float f, String str) {
        Keyframe keyframeOfInt;
        if (this.c == u.BACKGROUND_COLOR) {
            keyframeOfInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.an.d.d(str));
        } else {
            keyframeOfInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.an.b.d(str, 0));
        }
        this.u.add(keyframeOfInt);
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc.d
    public TypeEvaluator an() {
        if (this.c == u.BACKGROUND_COLOR) {
            return new ArgbEvaluator();
        }
        return new IntEvaluator();
    }
}
