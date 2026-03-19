package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.alipay.sdk.m.u.i;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bj;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private com.kwad.sdk.core.g.a bHo;
    private a bHp;
    private AdMatrixInfo.RotateInfo rotateInfo;
    private volatile boolean bHj = true;
    private long bHk = 0;
    private double bHl = 9.999999717180685E-10d;
    private double[] bHm = {0.0d, 0.0d, 0.0d};
    private double[] bHn = {0.0d, 0.0d, 0.0d};
    private final bj.b bHq = new bj.b() { // from class: com.kwad.sdk.core.g.c.1
        @Override // com.kwad.sdk.utils.bj.b
        public final void onFailed() {
            if (c.this.bHo != null) {
                c.this.bHo.cj();
            }
        }
    };

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void bW(Context context) {
        if (context == null) {
            return;
        }
        abQ();
        this.bHj = true;
        if (this.bHp == null) {
            this.bHp = new a(this, (byte) 0);
        }
        bj.apC().a(2, 2, this.bHp, this.bHq);
    }

    public final void b(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(com.kwad.sdk.core.g.a aVar) {
        this.bHo = aVar;
    }

    public final synchronized void bX(Context context) {
        if (context != null) {
            if (this.bHp != null) {
                bj.apC().c(this.bHp);
                this.bHp = null;
            }
        }
    }

    private void abQ() {
        Arrays.fill(this.bHm, 0.0d);
        Arrays.fill(this.bHn, 0.0d);
        this.bHk = 0L;
    }

    public final synchronized void abR() {
        abQ();
        this.bHj = true;
    }

    class a implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            if (c.this.bHk != 0) {
                double d = (sensorEvent.timestamp - c.this.bHk) * c.this.bHl;
                double[] dArr = c.this.bHn;
                dArr[0] = dArr[0] + Math.toDegrees(f * d);
                double[] dArr2 = c.this.bHn;
                dArr2[1] = dArr2[1] + Math.toDegrees(f2 * d);
                double[] dArr3 = c.this.bHn;
                dArr3[2] = dArr3[2] + Math.toDegrees(f3 * d);
                c.this.abS();
                c.this.abT();
            }
            c.this.bHk = sensorEvent.timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abS() {
        if (this.bHj) {
            if (Math.abs(this.bHn[0]) > Math.abs(this.bHm[0])) {
                this.bHm[0] = this.bHn[0];
            }
            if (Math.abs(this.bHn[1]) > Math.abs(this.bHm[1])) {
                this.bHm[1] = this.bHn[1];
            }
            if (Math.abs(this.bHn[2]) > Math.abs(this.bHm[2])) {
                this.bHm[2] = this.bHn[2];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abT() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.bHj || (rotateInfo = this.rotateInfo) == null || this.bHo == null) {
            return;
        }
        if (a(0, rotateInfo.x.rotateDegree, this.rotateInfo.x.direction) || a(1, this.rotateInfo.y.rotateDegree, this.rotateInfo.y.direction) || a(2, this.rotateInfo.z.rotateDegree, this.rotateInfo.z.direction)) {
            this.bHj = false;
            this.bHo.r(abU());
        }
    }

    private String abU() {
        return "{\"x\": " + this.bHm[0] + ",\"y\":" + this.bHm[1] + ",\"z\":" + this.bHm[2] + i.d;
    }

    private boolean a(int i, double d, int i2) {
        if (d <= 0.0d || Math.abs(this.bHn[i]) < d) {
            return false;
        }
        double d2 = this.bHn[i];
        return (d2 <= 0.0d || i2 != 1) && (d2 >= 0.0d || i2 != 2);
    }
}
