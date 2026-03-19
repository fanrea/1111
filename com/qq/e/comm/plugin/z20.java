package com.qq.e.comm.plugin;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface z20 extends zp, SensorEventListener {

    /* compiled from: A */
    public static class a {
        public static z20 a(int i, int i2, int i3) {
            SensorManager sensorManager;
            z20 y0Var;
            if (!yh.e() || (sensorManager = (SensorManager) r1.d().a().getSystemService("sensor")) == null) {
                return null;
            }
            int i4 = 4;
            Sensor sensorA = kh.b().a(4);
            Sensor sensorA2 = kh.b().a(9);
            Sensor sensorA3 = kh.b().a(1);
            Sensor sensorA4 = kh.b().a(2);
            if (sensorA != null) {
                y0Var = new hi(sensorManager, sensorA, i, i2, i3);
                i4 = 1;
            } else if (sensorA2 != null && sensorA4 != null) {
                y0Var = new y0(sensorManager, sensorA2, sensorA4, i, i2, i3);
                i4 = 2;
            } else if (sensorA3 == null || sensorA4 == null) {
                y0Var = new y0(sensorManager, null, null, i, i2, i3);
                kh.b().a(y0Var);
            } else {
                y0Var = new y0(sensorManager, sensorA3, sensorA4, i, i2, i3);
                i4 = 3;
            }
            b10.a(9130011, null, Integer.valueOf(i4));
            return y0Var;
        }
    }

    void a(int i);

    void a(Sensor sensor, Sensor sensor2);

    void a(ts tsVar);

    void b(int i);

    void c(int i);
}
