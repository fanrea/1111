package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class de implements SensorEventListener {
    private static v dz;
    private float b;
    private JSONObject ba;
    private float c;
    private Sensor cb;
    private float dc;
    private Sensor e;
    private volatile long h;
    private volatile long hc;
    private float he;
    private float hv;
    private boolean ia;
    private Sensor k;
    private sy mk;
    private int np;
    private float nv;
    private Context nw;
    private int rf;
    private b rw;
    private float u;
    private Sensor w;
    private float yo;
    private final long d = 2000;
    private boolean an = false;
    private float gb = 13.0f;
    private float tt = 50.0f;
    private int tc = 0;
    private d mq = null;
    private hc uo = null;
    private final long jh = 500;
    private volatile long sy = 0;
    private volatile boolean de = false;
    private volatile boolean v = false;
    private final float yi = 1.0E-9f;
    private float[] vv = new float[3];
    private long zw = 0;
    private float j = 0.0f;
    private float s = 4.0f;
    private float us = 0.0f;
    private float[] z = new float[3];
    private final float fs = 0.0f;
    private boolean mt = false;
    private boolean r = false;
    private boolean bc = false;
    private boolean tr = false;
    private int y = 0;
    private int wl = 0;
    private int q = 0;
    private int ru = 0;
    private int yn = 0;
    private int l = 0;
    private boolean fu = false;
    private int xp = 0;
    private int to = 0;
    private float ra = 0.0f;

    public interface b {
        void d();
    }

    public interface d {
        void d(int i);
    }

    public interface hc {
        void d(float f, float f2, float f3);
    }

    private int an(float f) {
        return f < 0.0f ? 1 : 2;
    }

    private float d(double d2) {
        if (d2 <= 0.0d || d2 > 180.0d) {
            d2 = 50.0d;
        }
        return (float) d2;
    }

    private boolean d(float f, float f2) {
        return f2 > 0.0f && f > f2;
    }

    private boolean d(int i, int i2) {
        return (i | i2) == 3;
    }

    private boolean d(int i, int i2, int i3) {
        return i2 == 3 && (i | i3) == 3;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public de(Context context, int i, boolean z) {
        this.mk = null;
        this.ia = z;
        this.np = i;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.nw = applicationContext;
        if (applicationContext == null) {
            return;
        }
        mq.d("xgc_cus", "cus:" + z);
        if (z) {
            this.mk = sy.d(this.nw);
        }
    }

    public void d(boolean z) {
        Context context;
        mq.d("xgcc", "cus:" + z + " m:" + this.ia + " equ:" + (this.mk != null));
        if (!z) {
            sy syVar = this.mk;
            if (syVar != null) {
                syVar.d(this);
                this.mk = null;
                return;
            }
            return;
        }
        if (this.ia || this.mk != null || (context = this.nw) == null) {
            return;
        }
        this.mk = sy.d(context);
    }

    public void d(d dVar) {
        this.mq = dVar;
    }

    public void d(hc hcVar) {
        this.uo = hcVar;
    }

    private boolean hc() {
        sy syVar = this.mk;
        if (syVar == null) {
            return false;
        }
        try {
            if (this.tc == 4) {
                return b();
            }
            if (this.k == null) {
                this.k = syVar.d(1);
            }
            boolean zD = this.mk.d(this, this.k, 3);
            an();
            return zD;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean b() {
        int i;
        sy syVar = this.mk;
        boolean zD = false;
        if (syVar == null) {
            return false;
        }
        try {
            if (this.rf == 0) {
                if (this.e == null) {
                    this.e = syVar.d(15);
                }
                this.an = false;
                if (Build.VERSION.SDK_INT > 18) {
                    zD = this.mk.d(this, this.e, 1);
                }
            }
            int i2 = this.rf;
            if (i2 == 3 || i2 == 2 || i2 == 4 || i2 == 7) {
                if (this.cb == null) {
                    this.cb = this.mk.d(4);
                }
                float f = this.s;
                if (f != 0.0f && ((i = this.rf) == 2 || i == 4)) {
                    this.ra = (float) Math.pow(f, 2.0d);
                    if (this.w == null) {
                        this.w = this.mk.d(10);
                    }
                    this.mk.d(this, this.w, 1);
                }
                zD = this.mk.d(this, this.cb, 1);
            }
            h();
        } catch (Throwable unused) {
        }
        return zD;
    }

    public static void d(v vVar) {
        dz = vVar;
    }

    public boolean d(int i) {
        v vVar;
        if (i > 0 && (vVar = dz) != null && !vVar.d(i)) {
            dz.d(i, hashCode(), new Runnable() { // from class: com.bytedance.sdk.component.utils.de.1
                @Override // java.lang.Runnable
                public void run() {
                    de.this.c();
                }
            });
            return true;
        }
        return c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (this.mk == null || this.fu) {
            return false;
        }
        int i = this.np;
        if (i == 1) {
            return hc();
        }
        if (i == 2) {
            return b();
        }
        return false;
    }

    public void hc(int i) {
        u();
        v vVar = dz;
        if (vVar != null) {
            vVar.d(i, hashCode());
        }
    }

    private void u() {
        sy syVar = this.mk;
        if (syVar == null) {
            return;
        }
        syVar.d(this);
    }

    public void b(int i) {
        this.fu = false;
        d(i);
    }

    public void c(int i) {
        this.fu = true;
        hc(i);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        b bVar = this.rw;
        if (bVar != null) {
            bVar.d();
        }
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[1]);
        float fAbs3 = Math.abs(fArr[2]);
        if (type == 1) {
            if (this.mq == null || System.currentTimeMillis() - this.hc <= 2000) {
                return;
            }
            int i = this.tc;
            if (i == 1) {
                double dSqrt = Math.sqrt(Math.pow(fAbs, 2.0d) + Math.pow(fAbs2, 2.0d) + Math.pow(fAbs3, 2.0d));
                d(dSqrt > ((double) this.gb), dSqrt);
                return;
            } else if (i == 2) {
                hc(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.gb), sensorEvent);
                return;
            } else if (i == 3) {
                d(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.gb), sensorEvent);
                return;
            } else {
                double d2 = d(fAbs, fAbs2, fAbs3);
                d(d2 > ((double) this.gb), d2);
                return;
            }
        }
        if (type == 4) {
            int i2 = this.rf;
            if (i2 == 3) {
                hc(sensorEvent);
                return;
            } else {
                if (i2 == 2 || i2 == 4 || i2 == 7) {
                    d(sensorEvent);
                    return;
                }
                return;
            }
        }
        if (type == 10) {
            this.us = (float) (Math.pow(sensorEvent.values[0], 2.0d) + Math.pow(sensorEvent.values[1], 2.0d) + Math.pow(sensorEvent.values[2], 2.0d));
            return;
        }
        if (type != 15) {
            return;
        }
        float fAbs4 = Math.abs(fArr[0]);
        float fAbs5 = Math.abs(fArr[1]);
        float fAbs6 = Math.abs(fArr[2]);
        hc hcVar = this.uo;
        if (hcVar != null) {
            hcVar.d(fArr[0], fArr[1], fArr[2]);
        }
        if (fAbs4 == 0.0f && fAbs5 == 0.0f && fAbs6 == 0.0f) {
            return;
        }
        if (!this.an) {
            this.an = true;
            this.b = fAbs4;
            this.c = fAbs5;
            this.u = fAbs6;
            return;
        }
        float fAbs7 = Math.abs(fAbs4 - this.b) * 180.0f;
        float fAbs8 = Math.abs(fAbs5 - this.c) * 180.0f;
        float fAbs9 = Math.abs(fAbs6 - this.u) * 180.0f;
        if (this.mt) {
            boolean z = this.r && fAbs7 > this.hv;
            boolean z2 = this.bc && fAbs8 > this.dc;
            boolean z3 = this.tr && fAbs9 > this.nv;
            if ((z || z2 || z3) && this.mq != null && System.currentTimeMillis() - this.h > 2000) {
                this.mq.d(getType());
                this.h = System.currentTimeMillis();
                this.an = false;
                return;
            }
            return;
        }
        float f = this.tt;
        if ((fAbs7 > f || fAbs8 > f || fAbs9 > f) && this.mq != null && System.currentTimeMillis() - this.h > 2000) {
            this.mq.d(getType());
            this.h = System.currentTimeMillis();
            this.an = false;
        }
    }

    private void d(SensorEvent sensorEvent) {
        if (this.zw != 0) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            float f4 = (sensorEvent.timestamp - this.zw) * 1.0E-9f;
            float f5 = this.j;
            if (f5 != 0.0f) {
                if (!hc(f5, f) || !hc(this.j, f2) || !hc(this.j, f3)) {
                    hc(true);
                } else {
                    d(f, f2, f3, f4);
                }
            } else {
                float f6 = this.ra;
                if (f6 != 0.0f && this.us >= f6) {
                    hc(true);
                } else {
                    d(f, f2, f3, f4);
                }
            }
            if (this.rf == 7) {
                h(this.tt);
            } else {
                c(this.tt);
            }
            hc hcVar = this.uo;
            if (hcVar != null) {
                float[] fArr = this.z;
                hcVar.d(fArr[0], fArr[1], fArr[2]);
            }
        }
        this.zw = sensorEvent.timestamp;
    }

    private void hc(SensorEvent sensorEvent) {
        boolean z;
        if (this.he != 0.0f) {
            float f = (sensorEvent.timestamp - this.he) * 1.0E-9f;
            float[] fArr = this.vv;
            fArr[0] = fArr[0] + (sensorEvent.values[0] * f);
            float[] fArr2 = this.vv;
            fArr2[1] = fArr2[1] + (sensorEvent.values[1] * f);
            float[] fArr3 = this.vv;
            fArr3[2] = fArr3[2] + (sensorEvent.values[2] * f);
            float fAbs = Math.abs((float) Math.toDegrees(this.vv[0]));
            float fAbs2 = Math.abs((float) Math.toDegrees(this.vv[1]));
            float fAbs3 = Math.abs((float) Math.toDegrees(this.vv[2]));
            if (this.mt) {
                boolean z2 = this.r && d(fAbs, this.hv);
                boolean z3 = this.bc && d(fAbs2, this.dc);
                boolean z4 = this.tr && d(fAbs3, this.nv);
                if (z2 || z3 || z4) {
                    float[] fArr4 = this.vv;
                    fArr4[0] = 0.0f;
                    fArr4[1] = 0.0f;
                    fArr4[2] = 0.0f;
                    z = true;
                }
                z = false;
            } else {
                if (d(fAbs, this.tt) || d(fAbs2, this.tt) || d(fAbs3, this.tt)) {
                    float[] fArr5 = this.vv;
                    fArr5[0] = 0.0f;
                    fArr5[1] = 0.0f;
                    fArr5[2] = 0.0f;
                    z = true;
                }
                z = false;
            }
            if (z && System.currentTimeMillis() - this.h > 2000) {
                d dVar = this.mq;
                if (dVar != null) {
                    dVar.d(getType());
                }
                this.h = System.currentTimeMillis();
            }
            hc hcVar = this.uo;
            if (hcVar != null) {
                float[] fArr6 = this.vv;
                hcVar.d(fArr6[0], fArr6[1], fArr6[2]);
            }
        }
        this.he = sensorEvent.timestamp;
    }

    private void c(float f) {
        if (!d(this.rf == 4, f) || System.currentTimeMillis() - this.h <= 2000) {
            return;
        }
        d dVar = this.mq;
        if (dVar != null) {
            dVar.d(getType());
        }
        this.h = System.currentTimeMillis();
    }

    private boolean d(boolean z, float f) {
        float fAbs = Math.abs((float) Math.toDegrees(this.z[0]));
        float fAbs2 = Math.abs((float) Math.toDegrees(this.z[1]));
        float fAbs3 = Math.abs((float) Math.toDegrees(this.z[2]));
        if (this.mt) {
            boolean z2 = this.r && d(fAbs, this.hv);
            boolean z3 = this.bc && d(fAbs2, this.dc);
            boolean z4 = this.tr && d(fAbs3, this.nv);
            if (z2 || z3 || z4) {
                return d(z, z2, z3, z4);
            }
            return false;
        }
        boolean zD = d(fAbs, f);
        boolean zD2 = d(fAbs2, f);
        boolean zD3 = d(fAbs3, f);
        if (zD || zD2 || zD3) {
            return d(z, zD, zD2, zD3);
        }
        return false;
    }

    private void d(float f, float f2, float f3, float f4) {
        float[] fArr = this.z;
        fArr[0] = fArr[0] + (f * f4);
        fArr[1] = fArr[1] + (f2 * f4);
        fArr[2] = fArr[2] + (f3 * f4);
    }

    private boolean hc(float f, float f2) {
        return Math.abs(f2) < f;
    }

    private void hc(boolean z) {
        float[] fArr = this.z;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    public void d(float f) {
        this.gb = f;
    }

    public void d(b bVar) {
        this.rw = bVar;
    }

    public void hc(float f) {
        this.tt = f;
    }

    public void d(JSONObject jSONObject) {
        if (this.np != 2) {
            return;
        }
        this.ba = jSONObject;
        if (jSONObject == null) {
            this.r = false;
            this.bc = false;
            this.tr = false;
        } else {
            this.r = jSONObject.has("x_threshold");
            this.hv = d(this.ba.optDouble("x_threshold", 50.0d));
            this.bc = this.ba.has("y_threshold");
            this.dc = d(this.ba.optDouble("y_threshold", 50.0d));
            this.tr = this.ba.has("z_threshold");
            this.nv = d(this.ba.optDouble("z_threshold", 50.0d));
        }
        this.mt = this.r || this.bc || this.tr;
    }

    public void hc(JSONObject jSONObject) {
        if (this.np != 2) {
            return;
        }
        if (jSONObject == null) {
            this.to = 0;
        } else {
            this.to = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void b(JSONObject jSONObject) {
        if (this.np != 1) {
            return;
        }
        if (jSONObject == null) {
            this.xp = 0;
            this.to = 0;
        } else {
            this.xp = jSONObject.optInt("double_direct_conf", 0);
            this.to = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void u(int i) {
        this.tc = i;
    }

    private void an() {
        this.sy = 0L;
        this.de = false;
        this.v = false;
        this.y = 0;
        this.wl = 0;
        this.q = 0;
        this.ru = 0;
        this.yn = 0;
        this.l = 0;
    }

    private void h() {
        this.y = 0;
        this.wl = 0;
        this.q = 0;
    }

    private void u(float f) {
        if (System.currentTimeMillis() - this.sy >= 500) {
            this.de = false;
            tc();
        } else if (f >= this.yo) {
            this.de = true;
            tc();
        }
    }

    public boolean d() {
        return this.de;
    }

    private boolean gb() {
        return this.yo > this.gb;
    }

    private void tt() {
        d dVar = this.mq;
        if (dVar != null) {
            dVar.d(getType());
        }
        this.hc = System.currentTimeMillis();
    }

    private void tc() {
        d dVar = this.mq;
        if (dVar != null) {
            dVar.d(getType());
        }
        this.hc = System.currentTimeMillis();
        this.sy = 0L;
        this.v = false;
    }

    private float d(float f, float f2, float f3) {
        return Math.max(Math.max(f2, f), f3);
    }

    public void b(float f) {
        this.yo = f;
    }

    public void an(int i) {
        sy syVar = this.mk;
        if (syVar == null) {
            return;
        }
        if (i == 3 || i == 2 || i == 4 || i == 7) {
            if (this.cb == null && syVar != null) {
                this.cb = syVar.d(4);
            }
            if (this.cb != null) {
                this.rf = i;
                return;
            }
        }
        this.rf = 0;
    }

    private void d(boolean z, double d2) {
        if (!gb() && z) {
            tt();
            return;
        }
        if (z) {
            this.sy = System.currentTimeMillis();
            this.v = true;
            u((float) d2);
        } else {
            if (!this.v || System.currentTimeMillis() - this.sy < 500) {
                return;
            }
            this.de = false;
            tc();
        }
    }

    private void d(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int iD = d(fArr[0], this.y);
            int iD2 = d(fArr[1], this.wl);
            int iD3 = d(fArr[2], this.q);
            if (hc(iD, iD2, iD3, false)) {
                d(iD, iD2, iD3, true);
                tt();
                return;
            }
            this.y |= iD;
            if (iD <= 0) {
                iD = this.ru;
            }
            this.ru = iD;
            this.wl |= iD2;
            if (iD2 <= 0) {
                iD2 = this.yn;
            }
            this.yn = iD2;
            this.q |= iD3;
            if (iD3 <= 0) {
                iD3 = this.l;
            }
            this.l = iD3;
        }
    }

    private void hc(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int iD = d(fArr[0], this.y);
            int iD2 = d(fArr[1], this.wl);
            int iD3 = d(fArr[2], this.q);
            if (hc(iD, iD2, iD3, true)) {
                d(iD, iD2, iD3, true);
                tt();
            } else if (this.to == 1) {
                this.y = iD;
                this.wl = iD2;
                this.q = iD3;
            } else {
                this.y = iD | this.y;
                this.wl |= iD2;
                this.q = iD3 | this.q;
            }
        }
    }

    private boolean d(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!z) {
            hc(false);
            return true;
        }
        int iAn = z2 ? an(this.z[0]) : 0;
        int iAn2 = z3 ? an(this.z[1]) : 0;
        int iAn3 = z4 ? an(this.z[2]) : 0;
        if (this.rf != 7) {
            hc(false);
        }
        if (d(iAn, this.y) || d(iAn2, this.wl) || d(iAn3, this.q)) {
            d(iAn, iAn2, iAn3, true);
            return true;
        }
        if (this.to != 1) {
            d(iAn, iAn2, iAn3, false);
        } else if (z2 || z3 || z4) {
            this.y = iAn;
            this.wl = iAn2;
            this.q = iAn3;
        }
        return false;
    }

    private void d(int i, int i2, int i3, boolean z) {
        if (z) {
            this.y = 0;
            this.wl = 0;
            this.q = 0;
            this.ru = 0;
            this.yn = 0;
            this.l = 0;
            return;
        }
        if (i == 0) {
            i = this.y;
        }
        this.y = i;
        if (i2 == 0) {
            i2 = this.wl;
        }
        this.wl = i2;
        if (i3 == 0) {
            i3 = this.q;
        }
        this.q = i3;
    }

    private int d(float f, int i) {
        if (f != 0.0f) {
            return an(f);
        }
        if (i == 0) {
            return 0;
        }
        return i == 2 ? 1 : 2;
    }

    private boolean hc(int i, int i2, int i3, boolean z) {
        boolean zD;
        boolean zD2;
        boolean zD3;
        boolean zD4;
        int i4 = this.xp;
        if (i4 == 1) {
            int i5 = this.q;
            zD = z ? d(i3, i5) : d(i3, i5, this.l);
        } else if (i4 == 2) {
            int i6 = this.wl;
            zD = z ? d(i2, i6) : d(i2, i6, this.yn);
        } else {
            if (i4 != 4) {
                if (i4 != 7) {
                    if (z) {
                        zD2 = d(i, this.y);
                        zD3 = d(i2, this.wl);
                        zD4 = d(i3, this.q);
                    } else {
                        zD2 = d(i, this.y, this.ru);
                        zD3 = d(i2, this.wl, this.yn);
                        zD4 = d(i3, this.q, this.l);
                    }
                    if (zD2 || zD3 || zD4) {
                        return true;
                    }
                } else if (z) {
                    if (d(i, this.y) && d(i2, this.wl) && d(i3, this.q)) {
                        return true;
                    }
                } else if (d(i, this.y, this.ru) && d(i2, this.wl, this.yn) && d(i3, this.q, this.l)) {
                    return true;
                }
                return false;
            }
            int i7 = this.y;
            zD = z ? d(i, i7) : d(i, i7, this.ru);
        }
        return zD;
    }

    private void h(float f) {
        if (!d(this.rf == 7, f) || System.currentTimeMillis() - this.h <= 2000) {
            return;
        }
        hc(false);
        d dVar = this.mq;
        if (dVar != null) {
            dVar.d(getType());
        }
        this.h = System.currentTimeMillis();
    }

    private int getType() {
        return this.np == 2 ? 2 : 1;
    }
}
