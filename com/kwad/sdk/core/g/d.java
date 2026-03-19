package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.bj;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    private static float bHt = 9.81f;
    private static double bHu = 0.01d;
    private volatile boolean bHj = true;
    private final bj.b bHq = new bj.b() { // from class: com.kwad.sdk.core.g.d.1
        @Override // com.kwad.sdk.utils.bj.b
        public final void onFailed() {
            if (d.this.bHv != null) {
                d.this.bHv.ci();
            }
        }
    };
    private float bHs;
    private b bHv;
    private a bHw;

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.bHj = false;
        return false;
    }

    public d(float f) {
        if (f <= 0.0f) {
            this.bHs = 5.0f;
        } else {
            this.bHs = f;
        }
    }

    public final void bW(Context context) {
        if (context == null) {
            com.kwad.sdk.core.d.c.d("ShakeDetector", "startDetect context is null");
            return;
        }
        this.bHj = true;
        if (this.bHw == null) {
            this.bHw = new a();
        }
        bj.apC().a(1, 2, this.bHw, this.bHq);
    }

    public final void K(float f) {
        this.bHs = f;
    }

    public final synchronized void abR() {
        this.bHj = true;
    }

    public final void a(b bVar) {
        this.bHv = bVar;
    }

    public final synchronized void bX(Context context) {
        if (context != null) {
            if (this.bHw != null) {
                bj.apC().c(this.bHw);
                this.bHw = null;
            }
        }
    }

    class a implements SensorEventListener {
        private Random avb;
        private boolean bHz;
        private final float[] bHy = {0.0f, 0.0f, 9.8f};
        private final float[] bHA = {0.0f, 0.0f, 0.0f};

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public a() {
            this.bHz = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.d.g(DevelopMangerComponents.class)) != null) {
                this.bHz = false;
            }
        }

        private void abX() {
            if (this.avb == null) {
                this.avb = new Random();
            }
            if (this.avb.nextInt(100) == 1) {
                a(this.bHy);
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.bHz) {
                abX();
            }
        }

        private void a(float[] fArr) {
            c(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            double dAbs = Math.abs(Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)));
            if (b(fArr)) {
                dAbs = Math.abs(dAbs - d.bHt);
            }
            if (!d.this.bHj || dAbs < d.this.bHs || d.this.bHv == null) {
                return;
            }
            d.a(d.this, false);
            d.this.bHv.d(dAbs);
        }

        private static boolean b(float[] fArr) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            return Math.abs(Math.abs(Math.sqrt((double) (((f * f) + (f2 * f2)) + (f3 * f3)))) - ((double) d.bHt)) <= d.bHu;
        }

        private void c(float[] fArr) {
            float[] fArr2 = this.bHA;
            float f = fArr2[0];
            float f2 = (f == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) ? 1.0f : 0.6f;
            float f3 = 1.0f - f2;
            fArr[0] = (fArr[0] * f2) + (f * f3);
            fArr[1] = (fArr[1] * f2) + (fArr2[1] * f3);
            fArr[2] = (f2 * fArr[2]) + (f3 * fArr2[2]);
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }
    }
}
