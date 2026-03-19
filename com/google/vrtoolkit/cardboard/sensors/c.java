package com.google.vrtoolkit.cardboard.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.Matrix;
import android.view.Display;
import com.google.vrtoolkit.cardboard.sensors.a.g;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements SensorEventListener {
    private final Display cS;
    private final float[] cW;
    private com.google.vrtoolkit.cardboard.sensors.a.a dd;
    private d de;
    private a df;
    private long dg;
    private volatile boolean j;
    private final float[] cT = new float[16];
    private final float[] cU = new float[16];
    private float cV = -1.0f;
    private final float[] cX = new float[16];
    private final float[] cY = new float[16];
    private float cZ = 1.0f;
    private final Object da = new Object();
    private final Object dc = new Object();
    private volatile boolean dh = true;
    private float[] di = new float[3];
    private final g dj = new g();
    private final g bZ = new g();
    private final g dk = new g();
    private final com.google.vrtoolkit.cardboard.sensors.a.d db = new com.google.vrtoolkit.cardboard.sensors.a.d();

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public c(d dVar, a aVar, Display display) {
        float[] fArr = new float[16];
        this.cW = fArr;
        this.df = aVar;
        this.de = dVar;
        this.cS = display;
        a(true);
        Matrix.setIdentityM(fArr, 0);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            this.dk.a(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
            com.google.vrtoolkit.cardboard.sensors.a.d dVar = this.db;
            g gVar = this.dk;
            long j = sensorEvent.timestamp;
            dVar.b(gVar);
            synchronized (this.dc) {
                com.google.vrtoolkit.cardboard.sensors.a.a aVar = this.dd;
                if (aVar != null) {
                    aVar.b(this.dk, sensorEvent.timestamp);
                }
            }
            return;
        }
        if (sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16) {
            this.dg = this.df.a();
            if (sensorEvent.sensor.getType() == 16) {
                if (this.dh && sensorEvent.values.length == 6) {
                    this.di[0] = sensorEvent.values[3];
                    this.di[1] = sensorEvent.values[4];
                    this.di[2] = sensorEvent.values[5];
                }
                this.bZ.a(sensorEvent.values[0] - this.di[0], sensorEvent.values[1] - this.di[1], sensorEvent.values[2] - this.di[2]);
            } else {
                this.bZ.a(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
            }
            this.dh = false;
            synchronized (this.dc) {
                com.google.vrtoolkit.cardboard.sensors.a.a aVar2 = this.dd;
                if (aVar2 != null) {
                    aVar2.a(this.bZ, sensorEvent.timestamp);
                    this.dd.a(this.dj);
                    g gVar2 = this.bZ;
                    g.b(gVar2, this.dj, gVar2);
                }
            }
            this.db.a(this.bZ, sensorEvent.timestamp);
        }
    }

    public final void a() {
        if (this.j) {
            return;
        }
        this.db.a();
        synchronized (this.dc) {
            com.google.vrtoolkit.cardboard.sensors.a.a aVar = this.dd;
            if (aVar != null) {
                aVar.a();
            }
        }
        this.dh = true;
        this.de.a(this);
        this.de.a();
        this.j = true;
    }

    public final void b() {
        if (this.j) {
            this.de.b(this);
            this.de.b();
            this.j = false;
        }
    }

    private void a(boolean z) {
        synchronized (this.dc) {
            if (this.dd == null) {
                this.dd = new com.google.vrtoolkit.cardboard.sensors.a.a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(float[] r17, int r18) {
        /*
            Method dump skipped, instructions count: 196
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.vrtoolkit.cardboard.sensors.c.a(float[], int):void");
    }
}
