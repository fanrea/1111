package com.tachikoma.lottie;

import android.graphics.Rect;
import android.util.Log;
import com.tachikoma.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e {
    private Map<String, List<Layer>> GL;
    private Map<String, h> GM;
    private Map<String, com.tachikoma.lottie.model.b> GN;
    private List<com.tachikoma.lottie.model.g> GO;
    private android.support.v4.d.m<com.tachikoma.lottie.model.c> GP;
    private android.support.v4.d.e<Layer> GQ;
    private List<Layer> GR;
    private Rect GS;
    private float GT;
    private float GU;
    private float GV;
    private boolean GW;
    private final n GJ = new n();
    private final HashSet<String> GK = new HashSet<>();
    private int GX = 0;

    public final void a(Rect rect, float f, float f2, float f3, List<Layer> list, android.support.v4.d.e<Layer> eVar, Map<String, List<Layer>> map, Map<String, h> map2, android.support.v4.d.m<com.tachikoma.lottie.model.c> mVar, Map<String, com.tachikoma.lottie.model.b> map3, List<com.tachikoma.lottie.model.g> list2) {
        this.GS = rect;
        this.GT = f;
        this.GU = f2;
        this.GV = f3;
        this.GR = list;
        this.GQ = eVar;
        this.GL = map;
        this.GM = map2;
        this.GP = mVar;
        this.GN = map3;
        this.GO = list2;
    }

    public final void T(String str) {
        Log.w(com.component.lottie.c.b, str);
        this.GK.add(str);
    }

    public final void Q(boolean z) {
        this.GW = true;
    }

    public final void cv(int i) {
        this.GX += i;
    }

    public final boolean jr() {
        return this.GW;
    }

    public final int js() {
        return this.GX;
    }

    public final void setPerformanceTrackingEnabled(boolean z) {
        this.GJ.setEnabled(z);
    }

    public final n getPerformanceTracker() {
        return this.GJ;
    }

    public final Layer l(long j) {
        return this.GQ.get(j);
    }

    public final Rect getBounds() {
        return this.GS;
    }

    public final float jt() {
        return (long) ((jA() / this.GV) * 1000.0f);
    }

    public final float ju() {
        return this.GT;
    }

    public final float jv() {
        return this.GU;
    }

    public final float getFrameRate() {
        return this.GV;
    }

    public final List<Layer> jw() {
        return this.GR;
    }

    public final List<Layer> U(String str) {
        return this.GL.get(str);
    }

    public final android.support.v4.d.m<com.tachikoma.lottie.model.c> jx() {
        return this.GP;
    }

    public final Map<String, com.tachikoma.lottie.model.b> jy() {
        return this.GN;
    }

    public final com.tachikoma.lottie.model.g V(String str) {
        this.GO.size();
        for (int i = 0; i < this.GO.size(); i++) {
            com.tachikoma.lottie.model.g gVar = this.GO.get(i);
            if (gVar.ag(str)) {
                return gVar;
            }
        }
        return null;
    }

    public final Map<String, h> jz() {
        return this.GM;
    }

    public final float jA() {
        return this.GU - this.GT;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> it = this.GR.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString("\t"));
        }
        return sb.toString();
    }
}
