package com.sigmob.sdk.base.common;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ae implements SensorEventListener {
    private static volatile ae c;
    public final Set<SensorEventListener> a = new CopyOnWriteArraySet();
    public boolean b = false;
    private final SensorManager d;

    private ae(Context context) {
        this.d = (SensorManager) context.getSystemService("sensor");
    }

    public static ae a(Context context) {
        if (c == null) {
            synchronized (ae.class) {
                if (c == null) {
                    c = new ae(context.getApplicationContext());
                }
            }
        }
        return c;
    }

    private void b() {
        if (this.b || this.a.isEmpty()) {
            return;
        }
        this.d.unregisterListener(this);
        SensorManager sensorManager = this.d;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(4), 3);
        SensorManager sensorManager2 = this.d;
        sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(1), 3);
        SensorManager sensorManager3 = this.d;
        sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(2), 3);
        this.b = true;
    }

    private void c() {
        if (this.b && this.a.isEmpty()) {
            this.d.unregisterListener(this);
            this.b = false;
        }
    }

    public void a() {
        if (this.b) {
            this.d.unregisterListener(this);
            this.b = false;
        }
        this.a.clear();
        c = null;
    }

    public void a(SensorEventListener listener) {
        if (this.a.add(listener)) {
            b();
        }
    }

    public void b(SensorEventListener listener) {
        if (this.a.remove(listener)) {
            c();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Iterator<SensorEventListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onAccuracyChanged(sensor, accuracy);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        Iterator<SensorEventListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onSensorChanged(event);
        }
    }
}
