package com.kwad.lottie;

import android.graphics.Rect;
import android.util.Log;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.kwad.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    private final l bjJ = new l();
    private final HashSet<String> bjK = new HashSet<>();
    private Map<String, List<Layer>> bjL;
    private Map<String, g> bjM;
    private Map<String, com.kwad.lottie.model.c> bjN;
    private SparseArrayCompat<com.kwad.lottie.model.d> bjO;
    private LongSparseArray<Layer> bjP;
    private List<Layer> bjQ;
    private Rect bjR;
    private float bjS;
    private float bjT;
    private float frameRate;

    public final void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.kwad.lottie.model.d> sparseArrayCompat, Map<String, com.kwad.lottie.model.c> map3) {
        this.bjR = rect;
        this.bjS = f;
        this.bjT = f2;
        this.frameRate = f3;
        this.bjQ = list;
        this.bjP = longSparseArray;
        this.bjL = map;
        this.bjM = map2;
        this.bjO = sparseArrayCompat;
        this.bjN = map3;
    }

    public final void dh(String str) {
        Log.w(com.component.lottie.c.b, str);
        this.bjK.add(str);
    }

    public final void setPerformanceTrackingEnabled(boolean z) {
        this.bjJ.setEnabled(z);
    }

    public final l getPerformanceTracker() {
        return this.bjJ;
    }

    public final Layer aB(long j) {
        return this.bjP.get(j);
    }

    public final Rect getBounds() {
        return this.bjR;
    }

    public final float Qd() {
        return (long) ((Qk() / this.frameRate) * 1000.0f);
    }

    public final float Qe() {
        return this.bjS;
    }

    public final float Qf() {
        return this.bjT;
    }

    public final float getFrameRate() {
        return this.frameRate;
    }

    public final List<Layer> Qg() {
        return this.bjQ;
    }

    public final List<Layer> di(String str) {
        return this.bjL.get(str);
    }

    public final SparseArrayCompat<com.kwad.lottie.model.d> Qh() {
        return this.bjO;
    }

    public final Map<String, com.kwad.lottie.model.c> Qi() {
        return this.bjN;
    }

    public final Map<String, g> Qj() {
        return this.bjM;
    }

    public final float Qk() {
        return this.bjT - this.bjS;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> it = this.bjQ.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString("\t"));
        }
        return sb.toString();
    }
}
