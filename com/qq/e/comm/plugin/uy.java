package com.qq.e.comm.plugin;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class uy implements zp, SensorEventListener {
    private volatile float d;
    private final int e;
    private long f;
    private int g;
    private boolean h;
    private float[] k;
    private double l;
    private long r;
    private SensorManager a = null;
    private Sensor b = null;
    private ss c = null;
    private final AtomicBoolean i = new AtomicBoolean(false);
    private final AtomicBoolean j = new AtomicBoolean(false);
    private boolean m = false;
    private boolean n = true;
    private int o = 0;
    private int p = 0;
    private int[] q = null;
    private float s = 0.0f;
    private float t = 0.0f;
    private float u = 0.0f;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.qq.e.comm.plugin.zp
    public void start() throws JSONException {
        SensorManager sensorManager = (SensorManager) r1.d().a().getSystemService("sensor");
        this.a = sensorManager;
        this.b = null;
        if (sensorManager != null && yh.e()) {
            if (this.n) {
                this.b = this.a.getDefaultSensor(1);
            } else {
                this.b = this.a.getDefaultSensor(10);
            }
        }
        if (this.b == null) {
            return;
        }
        c();
    }

    public uy(int i, int i2) {
        d(i);
        this.e = i2;
    }

    public void d(int i) {
        this.d = i / 100.0f;
    }

    public void f(int i) {
        this.o = i;
    }

    public void e(int i) {
        this.p = i;
    }

    private void c() throws JSONException {
        SensorManager sensorManager;
        Sensor sensor;
        if (!this.i.compareAndSet(false, true) || (sensorManager = this.a) == null || (sensor = this.b) == null) {
            return;
        }
        try {
            sensorManager.registerListener(this, sensor, 1);
            oy.a++;
        } catch (Throwable th) {
            oy.a(2, th);
        }
    }

    @Override // com.qq.e.comm.plugin.zp
    public void stop() throws JSONException {
        d();
        this.a = null;
        this.c = null;
    }

    @Override // com.qq.e.comm.plugin.zp
    public boolean pause() throws JSONException {
        boolean zCompareAndSet = this.j.compareAndSet(false, true);
        if (zCompareAndSet && aq.a()) {
            d();
        }
        return zCompareAndSet;
    }

    @Override // com.qq.e.comm.plugin.zp
    public boolean resume() throws JSONException {
        boolean zCompareAndSet = this.j.compareAndSet(true, false);
        if (zCompareAndSet && aq.a()) {
            c();
        }
        return zCompareAndSet;
    }

    @Override // com.qq.e.comm.plugin.zp
    public void reset() {
        this.f = 0L;
        this.g = 0;
        this.h = false;
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        this.r = 0L;
    }

    @Override // com.qq.e.comm.plugin.zp
    public boolean a() {
        return this.h;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        ss ssVar = this.c;
        if (ssVar != null) {
            ssVar.a();
        }
        if (this.h || this.j.get()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f < 16) {
            return;
        }
        this.f = jCurrentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = this.n ? fArr[2] * 0.5f : fArr[2];
        double dSqrt = Math.sqrt((Math.pow(f, 2.0d) + Math.pow(f2, 2.0d)) + Math.pow(f3, 2.0d)) / 9.8d;
        if (this.c != null) {
            double d = this.d * this.g;
            Double.isNaN(d);
            this.c.a(Math.min(((float) (d + dSqrt)) / (this.d * this.e), 1.0f));
        }
        boolean zE = e();
        if (dSqrt >= this.d) {
            if (zE) {
                a(f, f2, f3);
            } else {
                this.g++;
            }
        }
        if (dSqrt > this.l) {
            this.l = dSqrt;
            this.k = sensorEvent.values;
        }
        if (this.c == null || this.h) {
            return;
        }
        if (zE ? a(dSqrt) : b()) {
            this.h = true;
            this.c.a(this.k);
            g(0);
        }
    }

    private void d() throws JSONException {
        SensorManager sensorManager;
        if (this.i.compareAndSet(true, false) && (sensorManager = this.a) != null) {
            try {
                sensorManager.unregisterListener(this);
                oy.a--;
            } catch (Throwable th) {
                oy.a(6, th);
            }
        }
    }

    private boolean b() {
        return this.g >= this.e;
    }

    private void g(int i) {
        if (this.m) {
            b10.a(1300001, null, Integer.valueOf(i), null, null);
        }
    }

    public void b(boolean z) {
        this.m = z;
    }

    private boolean e() {
        if (!this.m) {
            return false;
        }
        int[] iArr = this.q;
        boolean z = iArr != null && iArr.length > 0;
        int i = this.o;
        return z && (i > 0 && i < this.p);
    }

    private boolean a(double d) {
        if (d >= this.d) {
            int i = this.g;
            int i2 = this.e;
            if (i >= i2 && (i2 <= 1 || System.currentTimeMillis() - this.r > this.o)) {
                return true;
            }
        }
        return false;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public void a(int[] iArr) {
        this.q = iArr;
    }

    public void a(ss ssVar) {
        this.c = ssVar;
    }

    private void a(float f, float f2, float f3) {
        int i;
        int i2;
        int i3;
        float f4 = this.s;
        float f5 = this.t;
        float f6 = this.u;
        if (f4 == 0.0f) {
            this.s = f;
        }
        if (f5 == 0.0f) {
            this.t = f2;
        }
        if (f6 == 0.0f) {
            this.u = f3;
        }
        if (this.s * f < 0.0f) {
            this.s = f;
            i = 1;
        } else {
            i = 0;
        }
        if (this.t * f2 < 0.0f) {
            this.t = f2;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.u * f3 < 0.0f) {
            this.u = f3;
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i4 = (i << 2) | (i2 << 1) | i3;
        for (int i5 : this.q) {
            if ((i4 & i5) == i5) {
                this.g++;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.g == 1) {
                    this.r = jCurrentTimeMillis;
                    g(1);
                    return;
                } else {
                    if (jCurrentTimeMillis - this.r > this.p) {
                        this.r = jCurrentTimeMillis;
                        this.g = 1;
                        g(2);
                        return;
                    }
                    return;
                }
            }
        }
    }
}
