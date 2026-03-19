package com.baidu.mobads.container.util.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static a b;
    private final Map<C0139a, Sensor> a = new HashMap();
    private SensorManager c;

    private a() {
    }

    public static a a(Context context) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        b.b(context);
        return b;
    }

    public void b(Context context) {
        if (this.c == null && context != null) {
            this.c = (SensorManager) context.getSystemService("sensor");
        }
    }

    public Sensor a(int i) {
        if (this.c != null) {
            return this.c.getDefaultSensor(i);
        }
        return null;
    }

    public boolean a(SensorEventListener sensorEventListener, int i, int i2) {
        try {
            C0139a c0139aA = a(i, i2);
            if (c0139aA == null) {
                c0139aA = b(i, i2);
            }
            if (c0139aA != null) {
                b bVarB = c0139aA.b();
                if (bVarB.a(sensorEventListener)) {
                    return true;
                }
                return bVarB.b(sensorEventListener);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void a(SensorEventListener sensorEventListener, int i) {
        try {
            for (C0139a c0139a : new HashSet(this.a.keySet())) {
                if (c0139a.a() == i) {
                    a(c0139a, sensorEventListener);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(SensorEventListener sensorEventListener) {
        try {
            Iterator<C0139a> it = this.a.keySet().iterator();
            while (it.hasNext()) {
                a(it.next(), sensorEventListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private C0139a a(int i, int i2) {
        for (C0139a c0139a : this.a.keySet()) {
            if (c0139a.a(i, i2)) {
                return c0139a;
            }
        }
        return null;
    }

    private C0139a b(int i, int i2) {
        if (this.c != null) {
            C0139a c0139a = new C0139a(i, i2, new b());
            Sensor sensorA = a(i);
            if (this.c.registerListener(c0139a, sensorA, i2)) {
                this.a.put(c0139a, sensorA);
                return c0139a;
            }
            return null;
        }
        return null;
    }

    private void a(C0139a c0139a, SensorEventListener sensorEventListener) {
        if (c0139a != null && sensorEventListener != null) {
            try {
                b bVarB = c0139a.b();
                if (bVarB != null) {
                    bVarB.c(sensorEventListener);
                    if (bVarB.a() == 0) {
                        this.c.unregisterListener(c0139a, this.a.remove(c0139a));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.baidu.mobads.container.util.g.a$a, reason: collision with other inner class name */
    private static class C0139a implements SensorEventListener {
        private final b a;
        private final int b;
        private final int c;

        public C0139a(int i, int i2, b bVar) {
            this.b = i;
            this.c = i2;
            this.a = bVar;
        }

        public int a() {
            return this.b;
        }

        public b b() {
            return this.a;
        }

        public boolean a(int i, int i2) {
            return this.b == i && this.c == i2;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                this.a.a(sensorEvent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            try {
                this.a.a(sensor, i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static class b {
        private static final int a = 10;
        private final List<SensorEventListener> b = new ArrayList();

        public SensorEventListener a(int i) {
            if (i < a()) {
                return this.b.get(i);
            }
            return null;
        }

        public int a() {
            return this.b.size();
        }

        public boolean a(SensorEventListener sensorEventListener) {
            if (sensorEventListener != null) {
                return this.b.contains(sensorEventListener);
            }
            return false;
        }

        public synchronized boolean b(SensorEventListener sensorEventListener) {
            if (sensorEventListener == null) {
                return false;
            }
            if (a() > 10) {
                this.b.remove(0);
            }
            return this.b.add(sensorEventListener);
        }

        public synchronized boolean c(SensorEventListener sensorEventListener) {
            return this.b.remove(sensorEventListener);
        }

        public synchronized void a(SensorEvent sensorEvent) {
            for (int i = 0; i < a(); i++) {
                this.b.get(i).onSensorChanged(sensorEvent);
            }
        }

        public synchronized void a(Sensor sensor, int i) {
            for (int i2 = 0; i2 < a(); i2++) {
                this.b.get(i2).onAccuracyChanged(sensor, i);
            }
        }
    }
}
