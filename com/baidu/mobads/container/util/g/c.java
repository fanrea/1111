package com.baidu.mobads.container.util.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import com.baidu.mobads.container.l.g;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.r;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c implements SensorEventListener {
    private static final int o = 20;
    private static final int p = 67;
    private static final int q = 200;
    private static final int r = 200;
    private View C;
    private View D;
    private Context W;
    private a d;
    private final List<b> e = new CopyOnWriteArrayList();
    private float f = 7.0f;
    private float g = 6.0f;
    private int h = 190;
    private int i = 1;
    private float j = 0.0f;
    private float k = 0.0f;
    private float l = 4.0f;
    private boolean m = false;
    private float n = 35.0f;
    private long s = 0;
    private long t = 0;
    private long u = 0;
    private float v = 0.0f;
    private float w = 0.0f;
    private float x = 0.0f;
    private final AtomicBoolean y = new AtomicBoolean(false);
    private boolean z = true;
    private long A = 1000;
    private long B = 0;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private float H = 0.0f;
    private float I = 0.0f;
    private float J = 0.0f;

    /* renamed from: K, reason: collision with root package name */
    private float f743K = 0.0f;
    private float L = 0.0f;
    private float M = 0.0f;
    private float N = 0.0f;
    private float O = 0.0f;
    private float P = 0.0f;
    private float Q = 0.0f;
    private float[] R = new float[9];
    private float[] S = new float[3];
    private final float[] T = new float[4];
    private boolean U = false;
    private int[] V = new int[3];
    float[] a = new float[3];
    float[] b = new float[3];
    final float c = 0.8f;

    public c(Context context) {
        if (context != null) {
            this.W = context;
            this.d = a.a(context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x01dd  */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSensorChanged(android.hardware.SensorEvent r17) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.util.g.c.onSensorChanged(android.hardware.SensorEvent):void");
    }

    private float a(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 2) {
            this.b = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 1) {
            this.a[0] = (this.a[0] * 0.8f) + (sensorEvent.values[0] * 0.19999999f);
            this.a[1] = (this.a[1] * 0.8f) + (sensorEvent.values[1] * 0.19999999f);
            this.a[2] = (this.a[2] * 0.8f) + (sensorEvent.values[2] * 0.19999999f);
        }
        SensorManager.getRotationMatrix(this.R, null, this.a, this.b);
        SensorManager.getOrientation(this.R, this.S);
        float[] fArr = this.T;
        float fSin = (float) ((Math.sin(this.S[1] / 2.0f) * Math.sin(this.S[2] / 2.0f) * Math.cos(this.S[0] / 2.0f)) + (Math.cos(this.S[1] / 2.0f) * Math.cos(this.S[2] / 2.0f) * Math.sin(this.S[0] / 2.0f)));
        fArr[0] = fSin;
        float[] fArr2 = this.T;
        float fSin2 = (float) ((Math.sin(this.S[1] / 2.0f) * Math.cos(this.S[2] / 2.0f) * Math.cos(this.S[0] / 2.0f)) + (Math.cos(this.S[1] / 2.0f) * Math.sin(this.S[2] / 2.0f) * Math.sin(this.S[0] / 2.0f)));
        fArr2[1] = fSin2;
        float[] fArr3 = this.T;
        float fCos = (float) (((Math.cos(this.S[1] / 2.0f) * Math.sin(this.S[2] / 2.0f)) * Math.cos(this.S[0] / 2.0f)) - ((Math.sin(this.S[1] / 2.0f) * Math.cos(this.S[2] / 2.0f)) * Math.sin(this.S[0] / 2.0f)));
        fArr3[2] = fCos;
        float[] fArr4 = this.T;
        float fCos2 = (float) (((Math.cos(this.S[1] / 2.0f) * Math.cos(this.S[2] / 2.0f)) * Math.cos(this.S[0] / 2.0f)) - ((Math.sin(this.S[1] / 2.0f) * Math.sin(this.S[2] / 2.0f)) * Math.sin(this.S[0] / 2.0f)));
        fArr4[3] = fCos2;
        float f = ((fCos2 * fSin2) - (fCos * fSin)) * 2.0f;
        if (Math.abs(f) >= 1.0f) {
            this.S[0] = Math.copySign(1.57075f, f);
        } else {
            this.S[0] = (float) Math.asin(f);
        }
        float f2 = fSin2 * fSin2;
        this.S[1] = (float) Math.atan2(((fCos2 * fCos) + (fSin * fSin2)) * 2.0f, 1.0f - (((fCos * fCos) + f2) * 2.0f));
        this.S[2] = (float) Math.atan2(((fCos2 * fSin) + (fSin2 * fCos)) * 2.0f, 1.0f - (((fSin * fSin) + f2) * 2.0f));
        float degrees = (float) Math.toDegrees(this.S[0]);
        float degrees2 = (float) Math.toDegrees(this.S[1]);
        float degrees3 = (float) Math.toDegrees(this.S[2]);
        if (this.I == 0.0f && this.J == 0.0f && this.f743K == 0.0f && (degrees != 0.0f || degrees2 != 0.0f || degrees3 != 0.0f)) {
            this.I = degrees;
            this.J = degrees2;
            this.f743K = degrees3;
        }
        this.L = degrees - this.I;
        this.M = degrees2 - this.J;
        this.N = degrees3 - this.f743K;
        try {
            if (this.O > 0.0f || this.P > 0.0f || this.Q > 0.0f) {
                if (Math.abs(this.L - this.O) >= this.n && (this.L - this.O) * this.V[0] > 0.0f) {
                    this.U = true;
                } else if (Math.abs(this.M - this.P) >= this.n && (this.M - this.P) * this.V[1] > 0.0f) {
                    this.U = true;
                }
            }
        } catch (Throwable th) {
            g.f(th.getMessage());
        }
        return Math.max(Math.max(Math.abs(this.L), Math.abs(this.M)), Math.abs(this.N));
    }

    private void f() {
        this.G = true;
        this.t = 0L;
        this.F = false;
        this.E = false;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = 0.0f;
        this.f = 10.0f;
        this.g = 6.0f;
    }

    public static void a(View view, int i) {
        if (i > 0) {
            view.post(new e(view, i));
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void a() {
        this.z = true;
        c();
    }

    public void b() {
        this.z = false;
        d();
    }

    public boolean c() {
        try {
            if (this.d != null && this.y.compareAndSet(false, true)) {
                this.s = 0L;
                this.t = 0L;
                this.E = false;
                if (this.j > 0.0f || this.m) {
                    boolean zA = a(1, 3);
                    boolean zA2 = a(2, 3);
                    if (!this.G) {
                        if (!zA || !zA2) {
                            this.j = 0.0f;
                            this.f = 1.0f;
                            this.g = 10.0f;
                            this.h = 50;
                        } else if (this.j > 0.0f) {
                            this.f = 0.0f;
                            this.g = 0.0f;
                            this.h = 50;
                        }
                    }
                }
                if (a(10, -1)) {
                    return true;
                }
                return g();
            }
        } catch (Throwable th) {
            this.d.a(this);
            th.printStackTrace();
        }
        return false;
    }

    private boolean g() {
        if (this.d != null) {
            boolean zA = a(1, -1);
            if (!zA) {
                d();
            }
            this.g = 10.0f;
            return zA;
        }
        return false;
    }

    private boolean a(int i, int i2) {
        try {
            if (i2 >= 0) {
                return this.d.a(this, i, i2);
            }
            if (this.h < 20) {
                return this.d.a(this, i, 0);
            }
            if (this.h < 67) {
                return this.d.a(this, i, 1);
            }
            if (this.h < 200) {
                return this.d.a(this, i, 2);
            }
            return this.d.a(this, i, 3);
        } catch (IllegalStateException e) {
            this.d.a(this);
            a(e.getLocalizedMessage());
            return false;
        } catch (Throwable th) {
            this.d.a(this);
            a(th.getLocalizedMessage());
            return false;
        }
    }

    public void d() {
        try {
            if (this.d != null) {
                this.d.a(this, 10);
                this.d.a(this, 4);
                this.d.a(this, 1);
                this.d.a(this);
                this.y.set(false);
            } else {
                a.a(this.W).a(this);
                this.y.set(false);
                a("sensorManager is null");
            }
        } catch (Throwable th) {
            a(th.getLocalizedMessage());
            g.b().f(th.getMessage());
        }
    }

    private void a(String str) {
        by.a.a(this.W).a(810).a("reason", str).f();
    }

    public void a(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.i = i;
    }

    public void a(float f) {
        this.g = f;
    }

    public void b(float f) {
        this.f = f;
    }

    public void c(float f) {
        this.j = f;
    }

    public void d(float f) {
        this.k = f;
    }

    public void e(float f) {
        this.l = f;
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void f(float f) {
        this.n = f;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.e.add(bVar);
        }
    }

    public void b(b bVar) {
        this.e.remove(bVar);
    }

    public boolean e() {
        return this.y.get();
    }

    public void a(View view) {
        this.D = view;
    }

    public void a(long j) {
        this.A = j;
    }

    public void b(View view) {
        this.C = view;
    }

    private boolean h() {
        View view = this.C;
        if (view != null) {
            return view.hasWindowFocus() && r.d(view) == 0;
        }
        return true;
    }
}
