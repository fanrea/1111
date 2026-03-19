package com.qq.e.comm.plugin;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hi extends w0 {
    private final Sensor q;
    private double r;
    private double s;
    private double t;
    private long u;

    public hi(SensorManager sensorManager, Sensor sensor, int i, int i2, int i3) {
        super(i, i2, i3);
        this.r = 0.0d;
        this.s = 0.0d;
        this.t = 0.0d;
        this.u = 0L;
        this.a = sensorManager;
        this.q = sensor;
    }

    @Override // com.qq.e.comm.plugin.w0
    protected void c() throws JSONException {
        super.c();
        if (this.m.compareAndSet(false, true)) {
            try {
                SensorManager sensorManager = this.a;
                if (sensorManager != null) {
                    sensorManager.registerListener(this, this.q, 2);
                    oy.a++;
                }
            } catch (Throwable th) {
                oy.a(4, th);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.w0
    protected void f() throws JSONException {
        SensorManager sensorManager;
        if (this.m.compareAndSet(true, false) && (sensorManager = this.a) != null) {
            try {
                sensorManager.unregisterListener(this);
                oy.a--;
            } catch (Throwable th) {
                oy.a(8, th);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.w0
    protected void e() {
        super.e();
        this.r = 0.0d;
        this.s = 0.0d;
        this.t = 0.0d;
        this.u = 0L;
    }

    @Override // com.qq.e.comm.plugin.w0, android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        super.onSensorChanged(sensorEvent);
        if (this.o || this.n.get() || sensorEvent.sensor.getType() != 4) {
            return;
        }
        if (this.u != 0) {
            float f = (r2 - r0) * 1.0E-9f;
            this.u = sensorEvent.timestamp;
            double d = this.r;
            float[] fArr = sensorEvent.values;
            double d2 = fArr[0] * f;
            Double.isNaN(d2);
            double d3 = d + d2;
            this.r = d3;
            double d4 = this.s;
            double d5 = fArr[1] * f;
            Double.isNaN(d5);
            this.s = d4 + d5;
            double d6 = this.t;
            double d7 = fArr[2] * f;
            Double.isNaN(d7);
            this.t = d6 + d7;
            int degrees = (int) Math.toDegrees(d3);
            int degrees2 = (int) Math.toDegrees(this.s);
            int degrees3 = (int) Math.toDegrees(this.t);
            this.l[0] = e(degrees % 360);
            this.l[1] = e(degrees2 % 360);
            this.l[2] = e(degrees3 % 360);
            b();
            return;
        }
        this.u = sensorEvent.timestamp;
    }
}
