package com.qq.e.comm.plugin;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.SystemClock;
import java.util.Arrays;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class y0 extends w0 {
    private long A;
    private int q;
    private Sensor r;
    private Sensor s;
    private boolean t;
    protected int[] u;
    private float[] v;
    private float[] w;
    private final float[] x;
    private final float[] y;
    private boolean z;

    public y0(SensorManager sensorManager, Sensor sensor, Sensor sensor2, int i, int i2, int i3) {
        super(i, i2, i3);
        this.t = false;
        this.u = new int[3];
        this.x = new float[3];
        this.y = new float[9];
        this.z = false;
        this.a = sensorManager;
        if (sensor == null || sensor2 == null) {
            return;
        }
        this.q = sensor.getType();
        this.r = sensor;
        this.s = sensor2;
    }

    @Override // com.qq.e.comm.plugin.w0
    protected void c() throws JSONException {
        if (this.s != null && this.r != null) {
            super.c();
            if (this.m.compareAndSet(false, true)) {
                try {
                    SensorManager sensorManager = this.a;
                    if (sensorManager != null) {
                        sensorManager.registerListener(this, this.r, 2);
                        this.a.registerListener(this, this.s, 2);
                        oy.a++;
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    oy.a(3, th);
                    return;
                }
            }
            return;
        }
        this.z = true;
        this.A = SystemClock.elapsedRealtime();
    }

    @Override // com.qq.e.comm.plugin.w0
    protected void f() throws JSONException {
        SensorManager sensorManager;
        if (this.s != null && this.r != null) {
            if (this.m.compareAndSet(true, false) && (sensorManager = this.a) != null) {
                try {
                    sensorManager.unregisterListener(this);
                    oy.a--;
                    return;
                } catch (Throwable th) {
                    oy.a(7, th);
                    return;
                }
            }
            return;
        }
        this.z = false;
    }

    @Override // com.qq.e.comm.plugin.w0, com.qq.e.comm.plugin.z20
    public void a(Sensor sensor, Sensor sensor2) throws JSONException {
        if (sensor == null || sensor2 == null) {
            return;
        }
        this.q = sensor.getType();
        this.r = sensor;
        this.s = sensor2;
        if (this.z) {
            c();
            b10.a(9130020, null, Integer.valueOf(Math.min((int) ((SystemClock.elapsedRealtime() - this.A) / 500), 20)));
        }
    }

    @Override // com.qq.e.comm.plugin.w0, com.qq.e.comm.plugin.zp
    public void reset() {
        super.reset();
        this.v = null;
        this.w = null;
    }

    @Override // com.qq.e.comm.plugin.w0
    protected void e() {
        super.e();
        this.t = false;
        Arrays.fill(this.u, 0);
        Arrays.fill(this.x, 0.0f);
        Arrays.fill(this.y, 0.0f);
    }

    @Override // com.qq.e.comm.plugin.w0, android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        super.onSensorChanged(sensorEvent);
        if (this.o || this.n.get()) {
            return;
        }
        if (this.q == sensorEvent.sensor.getType()) {
            float[] fArr = sensorEvent.values;
            this.v = fArr;
            float[] fArr2 = this.w;
            if (fArr2 == null) {
                return;
            }
            SensorManager.getRotationMatrix(this.y, null, fArr, fArr2);
            SensorManager.getOrientation(this.y, this.x);
            int degrees = (int) Math.toDegrees(this.x[1]);
            if (this.v[2] < 0.0f) {
                degrees = degrees > 0 ? 180 - degrees : (-180) - degrees;
            }
            int degrees2 = (int) Math.toDegrees(this.x[2]);
            int degrees3 = (int) Math.toDegrees(this.x[0]);
            if (!this.t) {
                int[] iArr = this.u;
                iArr[0] = degrees;
                iArr[1] = degrees2;
                iArr[2] = degrees3;
                this.t = true;
                return;
            }
            this.l[0] = -e(degrees - this.u[0]);
            this.l[1] = e(degrees2 - this.u[1]);
            this.l[2] = -e(degrees3 - this.u[2]);
            b();
            return;
        }
        if (2 == sensorEvent.sensor.getType()) {
            this.w = sensorEvent.values;
        }
    }
}
