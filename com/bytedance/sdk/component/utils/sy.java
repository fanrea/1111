package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class sy implements SensorEventListener {
    private static volatile sy d;
    private volatile Sensor an;
    private volatile Sensor b;
    private volatile Sensor c;
    private final SensorManager hc;
    private volatile Sensor u;
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean gb = new AtomicBoolean(false);
    private final AtomicBoolean tt = new AtomicBoolean(false);
    private final AtomicBoolean tc = new AtomicBoolean(false);
    private final Map<SensorEventListener, Object> mk = new ConcurrentHashMap();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private sy(Context context) {
        this.hc = (SensorManager) context.getSystemService("sensor");
    }

    public static sy d(Context context) {
        if (d == null) {
            synchronized (sy.class) {
                if (d == null) {
                    d = new sy(context);
                }
            }
        }
        return d;
    }

    private Sensor hc() {
        if (this.b == null) {
            synchronized (sy.class) {
                if (this.b == null) {
                    this.b = this.hc.getDefaultSensor(1);
                }
            }
        }
        return this.b;
    }

    private Sensor b() {
        if (this.c == null) {
            synchronized (sy.class) {
                if (this.c == null) {
                    this.c = this.hc.getDefaultSensor(15);
                }
            }
        }
        return this.c;
    }

    private Sensor c() {
        if (this.u == null) {
            synchronized (sy.class) {
                if (this.u == null) {
                    this.u = this.hc.getDefaultSensor(4);
                }
            }
        }
        return this.u;
    }

    private Sensor u() {
        if (this.an == null) {
            synchronized (sy.class) {
                if (this.an == null) {
                    this.an = this.hc.getDefaultSensor(10);
                }
            }
        }
        return this.an;
    }

    public Sensor d(int i) {
        if (i == 1) {
            return hc();
        }
        if (i == 4) {
            return c();
        }
        if (i == 10) {
            return u();
        }
        if (i != 15) {
            return null;
        }
        return b();
    }

    public boolean d(SensorEventListener sensorEventListener, Sensor sensor, int i) {
        this.mk.put(sensorEventListener, 0);
        if (sensor == this.b) {
            if (!this.h.getAndSet(true)) {
                return this.hc.registerListener(this, sensor, i);
            }
        } else if (sensor == this.c) {
            if (!this.gb.getAndSet(true)) {
                return this.hc.registerListener(this, sensor, i);
            }
        } else if (sensor == this.u) {
            if (!this.tt.getAndSet(true)) {
                return this.hc.registerListener(this, sensor, i);
            }
        } else if (sensor == this.an && !this.tc.getAndSet(true)) {
            return this.hc.registerListener(this, sensor, i);
        }
        return true;
    }

    public void d(SensorEventListener sensorEventListener) {
        this.mk.remove(sensorEventListener);
        mq.d("TMe", "--==---- unreg shake size: " + this.mk.size());
        if (this.mk.isEmpty()) {
            try {
                this.hc.unregisterListener(this);
            } catch (Throwable th) {
                mq.d(th);
            }
            this.h.set(false);
            this.gb.set(false);
            this.tt.set(false);
            this.tc.set(false);
        }
    }

    public int d() {
        return this.mk.size();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorEventListener key;
        for (Map.Entry<SensorEventListener, Object> entry : this.mk.entrySet()) {
            if (entry != null && (key = entry.getKey()) != null) {
                key.onSensorChanged(sensorEvent);
            }
        }
    }
}
