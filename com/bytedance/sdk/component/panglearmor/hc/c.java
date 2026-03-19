package com.bytedance.sdk.component.panglearmor.hc;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.alipay.sdk.m.t.a;
import com.bytedance.sdk.component.panglearmor.an;
import com.bytedance.sdk.component.tc.h;
import com.bytedance.sdk.component.tc.tt;
import com.bytedance.sdk.component.utils.k;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements SensorEventListener {
    private static volatile c d;
    private Sensor e;
    private Sensor k;
    private volatile d rf;
    private volatile boolean hc = false;
    private final List<Float> b = new ArrayList(1);
    private final List<Float> c = new ArrayList(1);
    private final List<Float> u = new ArrayList(1);
    private final List<Float> an = new ArrayList(1);
    private final List<Float> h = new ArrayList(1);
    private final List<Float> gb = new ArrayList(1);
    private final int tt = 0;
    private final int tc = 1;
    private final int mk = 2;
    private final int mq = 16;
    private final int uo = 32;
    private long cb = 0;
    private volatile boolean w = false;
    private volatile AtomicInteger yo = new AtomicInteger(0);
    private volatile int jh = 0;

    public interface d {
        void d(JSONObject jSONObject);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private c() {
        this.k = null;
        this.e = null;
        SensorManager sensorManager = (SensorManager) an.c().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            try {
                this.k = sensorManager.getDefaultSensor(1);
                this.e = sensorManager.getDefaultSensor(2);
            } catch (Exception unused) {
            }
        }
    }

    public static c d() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    public void d(d dVar) {
        this.rf = dVar;
    }

    public synchronized boolean hc() {
        int i;
        this.jh = 0;
        if (this.w) {
            return false;
        }
        int i2 = 32;
        if (this.k != null && this.e != null) {
            this.w = false;
            SensorManager sensorManager = (SensorManager) an.c().getApplicationContext().getSystemService("sensor");
            if (sensorManager != null) {
                try {
                    boolean zRegisterListener = sensorManager.registerListener(this, this.k, 1);
                    boolean zRegisterListener2 = sensorManager.registerListener(this, this.e, 1);
                    if (!zRegisterListener || !zRegisterListener2) {
                        this.jh |= 32;
                        u();
                        h();
                    } else {
                        this.w = true;
                        this.hc = false;
                    }
                } catch (Exception unused) {
                    i = this.jh;
                }
                return this.w;
            }
            i = this.jh;
            i2 = 1;
        } else {
            this.jh |= this.k == null ? 2 : 0;
            int i3 = this.jh;
            i2 = this.e == null ? 16 : 0;
            i = i3;
        }
        this.jh = i | i2;
        return this.w;
    }

    private void u() {
        this.yo = new AtomicInteger(0);
        SensorManager sensorManager = (SensorManager) an.c().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            Sensor sensor = this.k;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.e;
            if (sensor2 != null) {
                sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.yo.incrementAndGet();
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            if (this.b.size() <= 0) {
                this.b.add(Float.valueOf(sensorEvent.values[0]));
                this.c.add(Float.valueOf(sensorEvent.values[1]));
                this.u.add(Float.valueOf(sensorEvent.values[2]));
                return;
            }
            an();
            return;
        }
        if (type != 2) {
            return;
        }
        if (this.an.size() <= 0) {
            this.an.add(Float.valueOf(sensorEvent.values[0]));
            this.h.add(Float.valueOf(sensorEvent.values[1]));
            this.gb.add(Float.valueOf(sensorEvent.values[2]));
            return;
        }
        an();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(float[] fArr) throws JSONException {
        this.cb = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", c());
            if (Build.VERSION.SDK_INT >= 19) {
                jSONObject.put("val", new JSONArray(fArr));
            }
            hc.d().d(jSONObject, "sp_angle");
            hc.d().d(k.b(an.c()));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void an() {
        if (!this.hc && this.b.size() > 0 && this.an.size() > 0) {
            this.hc = true;
            u();
            h.hc(new tt("har") { // from class: com.bytedance.sdk.component.panglearmor.hc.c.1
                @Override // java.lang.Runnable
                public void run() throws JSONException {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        float[] fArrD = b.d(c.this.b, c.this.c, c.this.u, c.this.an, c.this.h, c.this.gb);
                        c.this.d(fArrD);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jAn = u.d().an();
                        long jH = u.d().h();
                        int iB = (int) (((u.d().b() / 1000) / 60) / 60);
                        if (iB <= 0) {
                            iB = 1;
                        }
                        jSONObject.put("azimuth_unit", jAn);
                        jSONObject.put("angle_unit", jH);
                        LinkedList<JSONObject> linkedListD = hc.d().d(0L);
                        jSONObject.put("active", Arrays.toString(b.d(linkedListD, iB)));
                        com.bytedance.sdk.component.panglearmor.hc.d.d().d(iB);
                        jSONObject.put("screen", Arrays.toString(com.bytedance.sdk.component.panglearmor.hc.d.d().b()));
                        jSONObject.put(PointCategory.NETWORK, Arrays.toString(com.bytedance.sdk.component.panglearmor.hc.d.d().hc()));
                        jSONObject.put("support_net", com.bytedance.sdk.component.panglearmor.hc.d.d().c());
                        jSONObject.put("sim_status", com.bytedance.sdk.component.panglearmor.hc.d.d().u());
                        int[][] iArrD = b.d(linkedListD, jAn, jH);
                        jSONObject.put("ax", Arrays.toString(iArrD[0]));
                        jSONObject.put("ay", Arrays.toString(iArrD[1]));
                        jSONObject.put("az", Arrays.toString(iArrD[2]));
                        int[][] iArrD2 = b.d(hc.d().d(10800000L), jAn, jH);
                        jSONObject.put("ax3", Arrays.toString(iArrD2[0]));
                        jSONObject.put("ay3", Arrays.toString(iArrD2[1]));
                        jSONObject.put("az3", Arrays.toString(iArrD2[2]));
                        int[][] iArrD3 = b.d(hc.d().d(21600000L), jAn, jH);
                        jSONObject.put("ax6", Arrays.toString(iArrD3[0]));
                        jSONObject.put("ay6", Arrays.toString(iArrD3[1]));
                        jSONObject.put("az6", Arrays.toString(iArrD3[2]));
                        jSONObject.put("angleAvg", Arrays.toString(fArrD));
                        jSONObject.put(a.k, jCurrentTimeMillis);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (c.this.rf != null) {
                        c.this.rf.d(jSONObject);
                    }
                    c.this.h();
                    c.this.w = false;
                }
            });
        } else {
            if (this.yo.get() > 3) {
                u();
                h();
                this.w = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.b.clear();
        this.c.clear();
        this.u.clear();
        this.an.clear();
        this.h.clear();
        this.gb.clear();
    }

    public boolean b() {
        return this.w;
    }

    public long c() {
        return this.cb;
    }
}
