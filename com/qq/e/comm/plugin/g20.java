package com.qq.e.comm.plugin;

import android.animation.TimeInterpolator;
import android.os.Build;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class g20 {
    private static final Map<Integer, d> a;
    private static final TimeInterpolator b;

    /* compiled from: A */
    private interface d {
        TimeInterpolator a(JSONArray jSONArray);
    }

    static {
        HashMap map = new HashMap();
        a = map;
        b = new LinearInterpolator();
        map.put(25, new e(1));
        map.put(26, new e(0));
        map.put(27, new e(2));
        map.put(28, new c(1));
        map.put(29, new c(0));
        map.put(30, new c(2));
        map.put(31, new b());
        map.put(32, new f());
    }

    static TimeInterpolator a(s2 s2Var) {
        int i = s2Var.i;
        if (i > 0 && i < 25) {
            i = 31;
        }
        d dVar = a.get(Integer.valueOf(i));
        return dVar == null ? b : dVar.a(s2Var.j);
    }

    /* compiled from: A */
    private static class e implements d, TimeInterpolator {
        private final int a;

        private float b(float f, float f2, int i) {
            if (f == 0.0f || f == 1.0f) {
                return f;
            }
            float f3 = i;
            double d = (((f * f3) + 1.0f) - f3) * 10.0f;
            Double.isNaN(d);
            double dPow = Math.pow(2.0d, -d);
            double d2 = f2;
            Double.isNaN(d2);
            Double.isNaN(d);
            Double.isNaN(d2);
            return (float) ((dPow * Math.sin(((d - (0.25d * d2)) * 6.283185307179586d) / d2)) + 1.0d);
        }

        @Override // com.qq.e.comm.plugin.g20.d
        public TimeInterpolator a(JSONArray jSONArray) {
            return this;
        }

        e(int i) {
            this.a = i;
        }

        private float a(float f, float f2, int i) {
            if (f == 0.0f || f == 1.0f) {
                return f;
            }
            double d = ((i * f) - 1.0f) * 10.0f;
            double d2 = -Math.pow(2.0d, d);
            double d3 = f2;
            Double.isNaN(d3);
            Double.isNaN(d);
            Double.isNaN(d3);
            return (float) (d2 * Math.sin(((d - (0.25d * d3)) * 6.283185307179586d) / d3));
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = this.a;
            if (i == 0) {
                return b(f, 3.0f, 1);
            }
            if (i == 1) {
                return a(f, 3.0f, 1);
            }
            if (i != 2) {
                return f;
            }
            return (((double) f) < 0.5d ? a(f, 4.5f, 2) : b(f, 4.5f, 2)) / 2.0f;
        }
    }

    /* compiled from: A */
    private static class c extends BounceInterpolator implements d {
        private final int a;

        @Override // com.qq.e.comm.plugin.g20.d
        public TimeInterpolator a(JSONArray jSONArray) {
            return this;
        }

        c(int i) {
            this.a = i;
        }

        @Override // android.view.animation.BounceInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = this.a;
            if (i == 1) {
                return 1.0f - super.getInterpolation(1.0f - f);
            }
            if (i != 2) {
                return super.getInterpolation(f);
            }
            if (f < 0.5d) {
                return (1.0f - super.getInterpolation(1.0f - (f * 2.0f))) / 2.0f;
            }
            return (super.getInterpolation((f * 2.0f) - 1.0f) + 1.0f) / 2.0f;
        }
    }

    /* compiled from: A */
    private static class b implements d {
        @Override // com.qq.e.comm.plugin.g20.d
        public TimeInterpolator a(JSONArray jSONArray) {
            int length;
            if (Build.VERSION.SDK_INT >= 21 && jSONArray != null && (length = jSONArray.length()) >= 2) {
                return length > 3 ? new PathInterpolator((float) jSONArray.optDouble(0), (float) jSONArray.optDouble(1), (float) jSONArray.optDouble(2), (float) jSONArray.optDouble(3)) : new PathInterpolator((float) jSONArray.optDouble(0), (float) jSONArray.optDouble(1));
            }
            return null;
        }

        private b() {
        }
    }

    /* compiled from: A */
    private static class f implements d {
        private f() {
        }

        @Override // com.qq.e.comm.plugin.g20.d
        public TimeInterpolator a(JSONArray jSONArray) {
            double dOptDouble = 0.0d;
            double dOptDouble2 = 1.0d;
            if (jSONArray != null && jSONArray.length() >= 2) {
                dOptDouble = jSONArray.optDouble(0, 0.0d);
                dOptDouble2 = jSONArray.optDouble(1, 1.0d);
            }
            double d = dOptDouble;
            return new a(dOptDouble2 - d, d);
        }

        /* compiled from: A */
        class a implements TimeInterpolator {
            final /* synthetic */ double a;
            final /* synthetic */ double b;

            a(double d, double d2) {
                this.a = d;
                this.b = d2;
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                double d = f;
                double d2 = this.a;
                Double.isNaN(d);
                return (float) Math.sin(((d * d2) + this.b) * 3.141592653589793d);
            }
        }
    }
}
