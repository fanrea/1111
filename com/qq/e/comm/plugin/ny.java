package com.qq.e.comm.plugin;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kuaishou.android.live.network.ApiStatus;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ny implements pl {
    private static final long j = r1.d().f().a("sksdrqst", 5) * 1000;
    private final SensorManager a;
    private Sensor b;
    private Sensor c;
    private final b d = new b();
    private float[] e = null;
    private float[] f = null;
    private int[] g = {ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG, ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG, ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG};
    private final AtomicBoolean h = new AtomicBoolean(false);
    private long i = -1;

    private void d() throws JSONException {
        Sensor sensor;
        if (yh.e() && this.h.compareAndSet(false, true)) {
            if (this.b == null || this.c == null) {
                this.b = kh.b().a(1);
                this.c = kh.b().a(2);
            }
            SensorManager sensorManager = this.a;
            if (sensorManager == null || (sensor = this.b) == null || this.c == null) {
                return;
            }
            try {
                sensorManager.registerListener(this.d, sensor, 1);
                this.a.registerListener(this.d, this.c, 1);
                oy.a++;
            } catch (Throwable th) {
                oy.a(1, th);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.pl
    public void start() throws JSONException {
        if (System.currentTimeMillis() - this.i < j) {
            return;
        }
        this.i = System.currentTimeMillis();
        d();
    }

    public ny(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.a = sensorManager;
        if (sensorManager == null || !yh.e()) {
            return;
        }
        this.b = kh.b().a(1);
        this.c = kh.b().a(2);
    }

    private void e() throws JSONException {
        if (this.h.compareAndSet(true, false)) {
            SensorManager sensorManager = this.a;
            if (sensorManager != null) {
                try {
                    sensorManager.unregisterListener(this.d);
                    oy.a--;
                } catch (Throwable th) {
                    oy.a(5, th);
                }
            }
            this.e = null;
            this.f = null;
        }
    }

    @Override // com.qq.e.comm.plugin.pl
    public void stop() throws JSONException {
        e();
    }

    /* compiled from: A */
    private class b implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        private b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) throws JSONException {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                ny.this.e = sensorEvent.values;
            } else if (type == 2) {
                ny.this.f = sensorEvent.values;
            }
            if (ny.this.e == null || ny.this.f == null) {
                return;
            }
            ny.this.c();
            ny.this.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        float[] fArr = new float[9];
        SensorManager.getRotationMatrix(fArr, null, this.e, this.f);
        SensorManager.getOrientation(fArr, new float[3]);
        this.g = new int[]{(int) Math.toDegrees(r0[1]), (int) Math.toDegrees(r0[2]), (int) Math.toDegrees(r0[0])};
    }

    @Override // com.qq.e.comm.plugin.pl
    public boolean b() {
        return this.h.get();
    }

    @Override // com.qq.e.comm.plugin.pl
    public int[] a() {
        return this.g;
    }
}
