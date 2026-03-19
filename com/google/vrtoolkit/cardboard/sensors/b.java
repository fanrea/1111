package com.google.vrtoolkit.cardboard.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b implements d {
    private static final String a = "b";
    private boolean b;
    private SensorManager cN;
    private Looper cO;
    private SensorEventListener cP;
    private final ArrayList<SensorEventListener> cQ = new ArrayList<>();
    private int g = 1;

    public b(SensorManager sensorManager, int i) {
        this.cN = sensorManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Sensor O() {
        if (Build.MANUFACTURER.equals("HTC")) {
            return null;
        }
        return this.cN.getDefaultSensor(16);
    }

    @Override // com.google.vrtoolkit.cardboard.sensors.d
    public final void a() {
        if (this.b) {
            return;
        }
        this.cP = new SensorEventListener() { // from class: com.google.vrtoolkit.cardboard.sensors.b.1
            @Override // android.hardware.SensorEventListener
            public final void onSensorChanged(SensorEvent sensorEvent) {
                synchronized (b.this.cQ) {
                    Iterator it = b.this.cQ.iterator();
                    while (it.hasNext()) {
                        ((SensorEventListener) it.next()).onSensorChanged(sensorEvent);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public final void onAccuracyChanged(Sensor sensor, int i) {
                synchronized (b.this.cQ) {
                    Iterator it = b.this.cQ.iterator();
                    while (it.hasNext()) {
                        ((SensorEventListener) it.next()).onAccuracyChanged(sensor, i);
                    }
                }
            }
        };
        HandlerThread handlerThread = new HandlerThread("sensor") { // from class: com.google.vrtoolkit.cardboard.sensors.b.2
            @Override // android.os.HandlerThread
            protected final void onLooperPrepared() {
                Handler handler = new Handler(Looper.myLooper());
                b.this.cN.registerListener(b.this.cP, b.this.cN.getDefaultSensor(1), b.this.g, handler);
                Sensor sensorO = b.this.O();
                if (sensorO == null) {
                    Log.i(b.a, "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
                    sensorO = b.this.cN.getDefaultSensor(4);
                }
                b.this.cN.registerListener(b.this.cP, sensorO, b.this.g, handler);
            }
        };
        handlerThread.start();
        this.cO = handlerThread.getLooper();
        this.b = true;
    }

    @Override // com.google.vrtoolkit.cardboard.sensors.d
    public final void b() {
        if (this.b) {
            this.cN.unregisterListener(this.cP);
            this.cP = null;
            this.cO.quit();
            this.cO = null;
            this.b = false;
        }
    }

    @Override // com.google.vrtoolkit.cardboard.sensors.d
    public final void a(SensorEventListener sensorEventListener) {
        synchronized (this.cQ) {
            this.cQ.add(sensorEventListener);
        }
    }

    @Override // com.google.vrtoolkit.cardboard.sensors.d
    public final void b(SensorEventListener sensorEventListener) {
        synchronized (this.cQ) {
            this.cQ.remove(sensorEventListener);
        }
    }
}
