package com.qq.e.comm.plugin;

import aegon.chrome.net.NetError;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.util.Pair;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class w0 implements z20 {
    private static final int[] p = {1, 0, 3, 2, 5, 4};
    protected SensorManager a;
    private int b;
    private int h;
    private final int i;
    private ts j;
    private int c = -1;
    private int d = -1;
    private boolean e = false;
    private final boolean[] f = new boolean[6];
    private final boolean[] g = new boolean[6];
    private long k = 0;
    protected int[] l = new int[3];
    protected final AtomicBoolean m = new AtomicBoolean(false);
    protected final AtomicBoolean n = new AtomicBoolean(false);
    protected boolean o = false;

    @Override // com.qq.e.comm.plugin.z20
    public void a(Sensor sensor, Sensor sensor2) {
    }

    protected int e(int i) {
        return i > 180 ? i + NetError.ERR_HTTP2_INADEQUATE_TRANSPORT_SECURITY : i <= -180 ? i + 360 : i;
    }

    protected abstract void f();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public w0(int i, int i2, int i3) {
        this.b = i;
        b(i2);
        this.i = i3;
    }

    private void g(int i) {
        for (int i2 = 0; i2 < 6; i2++) {
            boolean[] zArr = this.g;
            boolean z = true;
            if (((1 << i2) & i) == 0) {
                z = false;
            }
            zArr[i2] = z;
        }
    }

    @Override // com.qq.e.comm.plugin.zp
    public void start() {
        c();
    }

    protected void c() {
        d();
    }

    @Override // com.qq.e.comm.plugin.zp
    public boolean pause() {
        boolean zCompareAndSet = this.n.compareAndSet(false, true);
        if (zCompareAndSet && aq.a()) {
            f();
        }
        return zCompareAndSet;
    }

    @Override // com.qq.e.comm.plugin.zp
    public boolean resume() {
        boolean zCompareAndSet = this.n.compareAndSet(true, false);
        if (zCompareAndSet && aq.a()) {
            c();
        }
        return zCompareAndSet;
    }

    @Override // com.qq.e.comm.plugin.zp
    public void stop() {
        f();
        this.a = null;
        this.j = null;
    }

    @Override // com.qq.e.comm.plugin.zp
    public void reset() {
        d();
        e();
        this.o = false;
        ts tsVar = this.j;
        if (tsVar != null) {
            tsVar.b();
        }
        this.d = -1;
        this.e = false;
    }

    protected void e() {
        Arrays.fill(this.l, 0);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        ts tsVar = this.j;
        if (tsVar != null) {
            tsVar.a();
        }
    }

    protected void b() {
        if (this.o || this.n.get()) {
            return;
        }
        int[] iArr = this.l;
        Pair<Integer, Integer> pairA = a(iArr[0], iArr[1], iArr[2]);
        int iIntValue = ((Integer) pairA.first).intValue();
        int iIntValue2 = ((Integer) pairA.second).intValue();
        if (iIntValue < 5 && !this.e) {
            d();
        }
        if (this.j != null) {
            float fD = d(iIntValue);
            ts tsVar = this.j;
            int[] iArr2 = this.l;
            tsVar.a(iArr2[0], iArr2[1], iArr2[2], this.b, fD);
        }
        boolean z = iIntValue >= (this.e ? this.c : this.b);
        long jCurrentTimeMillis = System.currentTimeMillis() - this.k;
        boolean zA = a(z, jCurrentTimeMillis);
        if (z && !this.e) {
            f(iIntValue2);
            e();
        }
        if (!zA || this.j == null) {
            return;
        }
        this.o = true;
        h(0);
        ts tsVar2 = this.j;
        int[] iArr3 = this.l;
        tsVar2.a(iArr3[0], iArr3[1], iArr3[2], this.b, jCurrentTimeMillis);
    }

    @Override // com.qq.e.comm.plugin.z20
    public void c(int i) {
        this.c = i;
    }

    private Pair<Integer, Integer> a(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean[] zArr = this.e ? this.g : this.f;
        int i8 = 0;
        if (!zArr[0] || i <= 0) {
            i4 = -1;
        } else {
            i8 = i;
            i4 = 0;
        }
        if (zArr[1] && i < 0 && (i7 = -i) > i8) {
            i8 = i7;
            i4 = 1;
        }
        if (zArr[2] && i2 > i8) {
            i8 = i2;
            i4 = 2;
        }
        if (zArr[3] && i2 < 0 && (i6 = -i2) > i8) {
            i8 = i6;
            i4 = 3;
        }
        if (zArr[4] && i3 > i8) {
            i8 = i3;
            i4 = 4;
        }
        if (zArr[5] && i3 < 0 && (i5 = -i3) > i8) {
            i8 = i5;
            i4 = 5;
        }
        return new Pair<>(Integer.valueOf(i8), Integer.valueOf(i4));
    }

    private void f(int i) {
        this.e = true;
        if (this.c <= 0 || this.d > -1) {
            return;
        }
        this.d = i;
        g(1 << p[i]);
        h(1);
    }

    private float d(int i) {
        int i2 = this.c;
        if (i2 <= 0) {
            return Math.min(i / this.b, 1.0f);
        }
        if (!this.e) {
            return Math.min(i / this.b, 1.0f) * 0.5f;
        }
        return (Math.min(i / i2, 1.0f) * 0.5f) + 0.5f;
    }

    @Override // com.qq.e.comm.plugin.z20
    public void b(int i) {
        for (int i2 = 0; i2 < 6; i2++) {
            boolean[] zArr = this.f;
            boolean z = true;
            if (((1 << i2) & i) == 0) {
                z = false;
            }
            zArr[i2] = z;
        }
        this.h = i;
    }

    private void h(int i) {
        if (this.c <= 0) {
            return;
        }
        b10.a(1310001, null, Integer.valueOf(i), null, null);
    }

    @Override // com.qq.e.comm.plugin.zp
    public boolean a() {
        return this.o;
    }

    private void d() {
        this.k = System.currentTimeMillis();
        aq.a(this, "reset twist time: " + this.k);
    }

    private boolean a(boolean z, long j) {
        int i = this.i;
        if (i > 0) {
            z = z && j >= ((long) i);
        }
        return this.c > 0 ? z && this.e : z;
    }

    @Override // com.qq.e.comm.plugin.z20
    public void a(ts tsVar) {
        this.j = tsVar;
    }

    @Override // com.qq.e.comm.plugin.z20
    public void a(int i) {
        this.b = i;
    }
}
