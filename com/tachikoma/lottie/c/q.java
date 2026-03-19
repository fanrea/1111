package com.tachikoma.lottie.c;

import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
class q {
    private static final Interpolator Nl = new LinearInterpolator();
    private static android.support.v4.d.m<WeakReference<Interpolator>> Nm;

    q() {
    }

    private static android.support.v4.d.m<WeakReference<Interpolator>> lU() {
        if (Nm == null) {
            Nm = new android.support.v4.d.m<>();
        }
        return Nm;
    }

    private static WeakReference<Interpolator> cy(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = lU().get(i);
        }
        return weakReference;
    }

    private static void a(int i, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            Nm.put(i, weakReference);
        }
    }

    static <T> com.tachikoma.lottie.e.a<T> a(JsonReader jsonReader, com.tachikoma.lottie.e eVar, float f, aj<T> ajVar, boolean z) {
        if (z) {
            return a(eVar, jsonReader, f, ajVar);
        }
        return a(jsonReader, f, ajVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> com.tachikoma.lottie.e.a<T> a(com.tachikoma.lottie.e r17, android.util.JsonReader r18, float r19, com.tachikoma.lottie.c.aj<T> r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tachikoma.lottie.c.q.a(com.tachikoma.lottie.e, android.util.JsonReader, float, com.tachikoma.lottie.c.aj):com.tachikoma.lottie.e.a");
    }

    private static <T> com.tachikoma.lottie.e.a<T> a(JsonReader jsonReader, float f, aj<T> ajVar) {
        return new com.tachikoma.lottie.e.a<>(ajVar.a(jsonReader, f));
    }
}
