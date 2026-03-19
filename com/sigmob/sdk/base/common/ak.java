package com.sigmob.sdk.base.common;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.czhj.sdk.logger.SigmobLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ak {
    private static ae a;

    /* renamed from: com.sigmob.sdk.base.common.ak$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.SLOPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.SWING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.WRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class a implements SensorEventListener {
        static int[] b = {25, 60, 50, 45, 35, 25, 20, 15, 10, 5, 1};
        static float[] c = {4.0f, 10.0f, 8.0f, 6.0f, 5.0f, 4.0f, 3.0f, 2.0f, 1.8f, 1.5f, 1.0f};
        static int[] d = {15, 15, 13, 11, 10, 8, 6, 4, 3, 2, 1};
        static float[] e = {35.0f, 35.0f, 30.0f, 25.0f, 20.0f, 15.0f, 12.0f, 8.0f, 5.0f, 2.0f, 1.0f};
        private static float l = 40.0f;
        private long C;
        private Integer D;
        Float h;
        private SensorEvent i;
        private SensorEvent j;
        private SensorEvent k;
        private b m;
        private float n;
        private float o;
        private float p;
        private long q;
        private boolean r;
        private c t;
        private long u;
        private float v;
        private float w;
        private float x;
        private boolean y;
        private float z;
        protected int a = 0;
        float[] f = new float[9];
        float[] g = new float[3];
        private int s = 0;
        private int A = 100;
        private final int B = 2000;

        public a(Context context, b motionListener, c type) {
            if (ak.a == null) {
                ae unused = ak.a = ae.a(context);
            }
            this.m = motionListener;
            this.t = type;
        }

        private void a(SensorEvent event, SensorEvent gyroscopeEvent) {
            double degrees;
            int iIntValue;
            if (event == null || gyroscopeEvent == null) {
                return;
            }
            float f = event.values[0];
            float f2 = event.values[1];
            float f3 = event.values[2];
            float f4 = gyroscopeEvent.values[0];
            float f5 = gyroscopeEvent.values[1];
            float f6 = gyroscopeEvent.values[2];
            if (this.r) {
                degrees = this.u > 0 ? Math.toDegrees(((float) Math.sqrt(Math.pow(f4, 2.0d) + Math.pow(f5, 2.0d) + Math.pow(f6, 2.0d))) * (((gyroscopeEvent.timestamp - this.u) * 1.0f) / 1.0E9f)) : 0.0d;
                this.u = gyroscopeEvent.timestamp;
            } else {
                this.u = 0L;
                degrees = 0.0d;
            }
            float fSqrt = (float) Math.sqrt(Math.pow(f, 2.0d) + Math.pow(f2, 2.0d) + Math.pow(f3, 2.0d));
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.q;
            if (Math.abs(this.n) < Math.abs(f)) {
                this.n = f;
            }
            if (Math.abs(this.o) < Math.abs(f2)) {
                this.o = f2;
            }
            if (Math.abs(this.p) < Math.abs(f3)) {
                this.p = f3;
            }
            Integer num = this.D;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                int i = this.a;
                if (i <= 0 || i > 10) {
                    this.a = 1;
                }
                iIntValue = d[this.a];
            }
            l = iIntValue;
            float f7 = e[this.a];
            boolean z = fSqrt > l;
            if (z && !this.r) {
                this.r = true;
                this.q = jCurrentTimeMillis;
                b bVar = this.m;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            if (degrees <= f7 || !z || !this.r || j < 2000) {
                return;
            }
            this.r = false;
            SigmobLog.d("shake end");
            HashMap map = new HashMap();
            map.put("x_max_acc", Float.valueOf(this.n * this.A));
            map.put("y_max_acc", Float.valueOf(this.o * this.A));
            map.put("z_max_acc", Float.valueOf(this.p * this.A));
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            b bVar2 = this.m;
            if (bVar2 != null) {
                bVar2.a(map);
            }
        }

        public void a() {
            if (ak.a != null) {
                ak.a.b(this);
                ak.a.a(this);
            }
            this.h = null;
        }

        public void a(int factor) {
            if (factor > 0) {
                this.A = factor;
            }
        }

        public void b() {
            if (ak.a != null) {
                ak.a.b(this);
            }
            this.w = 0.0f;
            this.x = 0.0f;
            this.v = 0.0f;
            this.u = 0L;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.z = 0.0f;
            this.C = 0L;
            this.h = null;
        }

        public void b(int sensitivity_raw) {
            this.D = Integer.valueOf(sensitivity_raw);
        }

        public void c() {
            b();
            this.m = null;
        }

        public void c(int level) {
            this.a = level;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        /* JADX WARN: Removed duplicated region for block: B:119:0x0276  */
        /* JADX WARN: Removed duplicated region for block: B:122:0x0284  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x0294  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x0337  */
        /* JADX WARN: Removed duplicated region for block: B:160:0x0347  */
        /* JADX WARN: Removed duplicated region for block: B:163:0x0357  */
        /* JADX WARN: Removed duplicated region for block: B:166:0x036a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:167:0x036b  */
        /* JADX WARN: Removed duplicated region for block: B:190:? A[RETURN, SYNTHETIC] */
        @Override // android.hardware.SensorEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onSensorChanged(android.hardware.SensorEvent r22) {
            /*
                Method dump skipped, instructions count: 984
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.ak.a.onSensorChanged(android.hardware.SensorEvent):void");
        }
    }

    public interface b {
        void a();

        void a(float progress);

        void a(Map<String, Number> info);
    }

    public enum c {
        SWING,
        WRING,
        SLOPE,
        SHAKE
    }
}
