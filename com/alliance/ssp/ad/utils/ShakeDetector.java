package com.alliance.ssp.ad.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import com.alliance.ssp.ad.o0.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ShakeDetector implements SensorEventListener {
    public double a;
    public double b;
    public double c;
    public a d;
    public long g;
    public long h;
    public float j;
    public DETECTOR_STATE q;
    public boolean e = false;
    public boolean f = false;
    public final float[] i = new float[4];
    public float k = 0.0f;
    public float l = 0.0f;
    public float m = 0.0f;
    public float n = 0.0f;
    public float o = 0.0f;
    public float p = 0.0f;
    public float[] r = new float[3];
    public float[] s = new float[3];

    public enum DETECTOR_STATE {
        IDLE,
        DOING,
        PAUSE,
        STOP
    }

    public interface a {
    }

    public ShakeDetector(a aVar, Context context, double d, double d2, double d3) {
        this.a = 15.0d;
        this.b = 25.0d;
        this.c = 2000.0d;
        this.q = DETECTOR_STATE.IDLE;
        this.d = aVar;
        this.a = Math.max(d, 1.0d);
        this.b = Math.max(d2, 1.0d);
        this.c = d3;
        int i = l.a;
        this.q = DETECTOR_STATE.DOING;
    }

    public void a() {
        this.q = DETECTOR_STATE.PAUSE;
    }

    public void b() {
        this.q = DETECTOR_STATE.DOING;
        this.e = false;
        this.f = false;
        this.g = 0L;
        this.h = 0L;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSensorChanged(android.hardware.SensorEvent r16) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.utils.ShakeDetector.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
