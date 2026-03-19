package com.bytedance.adsdk.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class jh {
    private static final Interpolator d = new LinearInterpolator();
    private static SparseArray<WeakReference<Interpolator>> hc;

    jh() {
    }

    private static SparseArray<WeakReference<Interpolator>> d() {
        if (hc == null) {
            hc = new SparseArray<>();
        }
        return hc;
    }

    private static WeakReference<Interpolator> d(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (jh.class) {
            weakReference = d().get(i);
        }
        return weakReference;
    }

    private static void d(int i, WeakReference<Interpolator> weakReference) {
        synchronized (jh.class) {
            hc.put(i, weakReference);
        }
    }

    static <T> com.bytedance.adsdk.lottie.an.d<T> d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar, float f, tr<T> trVar, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return hc(anVar, jsonReader, f, trVar);
        }
        if (z) {
            return d(anVar, jsonReader, f, trVar);
        }
        return d(jsonReader, f, trVar);
    }

    private static <T> com.bytedance.adsdk.lottie.an.d<T> d(com.bytedance.adsdk.lottie.an anVar, JsonReader jsonReader, float f, tr<T> trVar) throws IOException {
        Interpolator interpolatorD;
        jsonReader.beginObject();
        PointF pointFHc = null;
        boolean z = false;
        T tHc = null;
        T tHc2 = null;
        PointF pointFHc2 = null;
        PointF pointFHc3 = null;
        float fNextDouble = 0.0f;
        PointF pointFHc4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    tHc = trVar.hc(jsonReader, f);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case "i":
                    pointFHc4 = rf.hc(jsonReader, 1.0f);
                    break;
                case "o":
                    pointFHc = rf.hc(jsonReader, 1.0f);
                    break;
                case "s":
                    tHc2 = trVar.hc(jsonReader, f);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFHc3 = rf.hc(jsonReader, f);
                    break;
                case "to":
                    pointFHc2 = rf.hc(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (!z) {
            if (pointFHc != null && pointFHc4 != null) {
                interpolatorD = d(pointFHc, pointFHc4);
            }
            com.bytedance.adsdk.lottie.an.d<T> dVar = new com.bytedance.adsdk.lottie.an.d<>(anVar, tHc2, tHc, interpolatorD, fNextDouble, null);
            dVar.gb = pointFHc2;
            dVar.tt = pointFHc3;
            return dVar;
        }
        tHc = tHc2;
        interpolatorD = d;
        com.bytedance.adsdk.lottie.an.d<T> dVar2 = new com.bytedance.adsdk.lottie.an.d<>(anVar, tHc2, tHc, interpolatorD, fNextDouble, null);
        dVar2.gb = pointFHc2;
        dVar2.tt = pointFHc3;
        return dVar2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0262 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0273  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> com.bytedance.adsdk.lottie.an.d<T> hc(com.bytedance.adsdk.lottie.an r23, android.util.JsonReader r24, float r25, com.bytedance.adsdk.lottie.c.tr<T> r26) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 706
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.c.jh.hc(com.bytedance.adsdk.lottie.an, android.util.JsonReader, float, com.bytedance.adsdk.lottie.c.tr):com.bytedance.adsdk.lottie.an.d");
    }

    private static Interpolator d(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.bytedance.adsdk.lottie.u.gb.hc(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.lottie.u.gb.hc(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.lottie.u.gb.hc(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.bytedance.adsdk.lottie.u.gb.hc(pointF2.y, -100.0f, 100.0f);
        int iD = com.bytedance.adsdk.lottie.u.tt.d(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> weakReferenceD = com.bytedance.adsdk.lottie.u.d() ? null : d(iD);
        Interpolator interpolator = weakReferenceD != null ? weakReferenceD.get() : null;
        if (weakReferenceD == null || interpolator == null) {
            try {
                linearInterpolator = com.bytedance.adsdk.lottie.w.d(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = com.bytedance.adsdk.lottie.w.d(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            if (!com.bytedance.adsdk.lottie.u.d()) {
                try {
                    d(iD, (WeakReference<Interpolator>) new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    private static <T> com.bytedance.adsdk.lottie.an.d<T> d(JsonReader jsonReader, float f, tr<T> trVar) throws IOException {
        return new com.bytedance.adsdk.lottie.an.d<>(trVar.hc(jsonReader, f));
    }
}
