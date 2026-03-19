package com.kwad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
class q {
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static SparseArrayCompat<WeakReference<Interpolator>> bpv;

    q() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> Sy() {
        if (bpv == null) {
            bpv = new SparseArrayCompat<>();
        }
        return bpv;
    }

    private static WeakReference<Interpolator> dW(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = Sy().get(i);
        }
        return weakReference;
    }

    private static void a(int i, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            bpv.put(i, weakReference);
        }
    }

    static <T> com.kwad.lottie.e.a<T> a(JsonReader jsonReader, com.kwad.lottie.d dVar, float f, aj<T> ajVar, boolean z) {
        if (z) {
            return a(dVar, jsonReader, f, ajVar);
        }
        return a(jsonReader, f, ajVar);
    }

    private static <T> com.kwad.lottie.e.a<T> a(com.kwad.lottie.d dVar, JsonReader jsonReader, float f, aj<T> ajVar) throws IOException {
        Interpolator interpolator;
        jsonReader.beginObject();
        PointF pointFE = null;
        PointF pointFE2 = null;
        T tA = null;
        T tA2 = null;
        PointF pointFE3 = null;
        PointF pointFE4 = null;
        float fNextDouble = 0.0f;
        while (true) {
            boolean z = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "e":
                        tA2 = ajVar.a(jsonReader, f);
                        break;
                    case "h":
                        if (jsonReader.nextInt() == 1) {
                            z = true;
                            break;
                        }
                        break;
                    case "i":
                        pointFE2 = p.e(jsonReader, f);
                        break;
                    case "o":
                        pointFE = p.e(jsonReader, f);
                        break;
                    case "s":
                        tA = ajVar.a(jsonReader, f);
                        break;
                    case "t":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    case "ti":
                        pointFE4 = p.e(jsonReader, f);
                        break;
                    case "to":
                        pointFE3 = p.e(jsonReader, f);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (z) {
                interpolator = LINEAR_INTERPOLATOR;
                tA2 = tA;
            } else if (pointFE != null && pointFE2 != null) {
                float f2 = -f;
                pointFE.x = com.kwad.lottie.d.e.clamp(pointFE.x, f2, f);
                pointFE.y = com.kwad.lottie.d.e.clamp(pointFE.y, -100.0f, 100.0f);
                pointFE2.x = com.kwad.lottie.d.e.clamp(pointFE2.x, f2, f);
                pointFE2.y = com.kwad.lottie.d.e.clamp(pointFE2.y, -100.0f, 100.0f);
                int iB = com.kwad.lottie.d.f.b(pointFE.x, pointFE.y, pointFE2.x, pointFE2.y);
                WeakReference<Interpolator> weakReferenceDW = dW(iB);
                Interpolator interpolatorCreate = weakReferenceDW != null ? weakReferenceDW.get() : null;
                if (weakReferenceDW == null || interpolatorCreate == null) {
                    interpolatorCreate = PathInterpolatorCompat.create(pointFE.x / f, pointFE.y / f, pointFE2.x / f, pointFE2.y / f);
                    try {
                        a(iB, new WeakReference(interpolatorCreate));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
                interpolator = interpolatorCreate;
            } else {
                interpolator = LINEAR_INTERPOLATOR;
            }
            com.kwad.lottie.e.a<T> aVar = new com.kwad.lottie.e.a<>(dVar, tA, tA2, interpolator, fNextDouble, null);
            aVar.bpT = pointFE3;
            aVar.bpU = pointFE4;
            return aVar;
        }
    }

    private static <T> com.kwad.lottie.e.a<T> a(JsonReader jsonReader, float f, aj<T> ajVar) {
        return new com.kwad.lottie.e.a<>(ajVar.a(jsonReader, f));
    }
}
