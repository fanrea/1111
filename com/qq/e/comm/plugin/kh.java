package com.qq.e.comm.plugin;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class kh {
    private static volatile kh h;
    private CopyOnWriteArrayList<WeakReference<z20>> f;
    private volatile Boolean g;
    private AtomicBoolean b = new AtomicBoolean(false);
    private final int[] e = {4, 2, 9, 1};
    private ConcurrentHashMap<Integer, Sensor> d = new ConcurrentHashMap<>();
    private SensorManager a = (SensorManager) r1.d().a().getSystemService("sensor");
    private int c = r1.d().f().a("sotms", 0);

    public static kh b() {
        if (h == null) {
            synchronized (kh.class) {
                if (h == null) {
                    h = new kh();
                }
            }
        }
        return h;
    }

    public void c() {
        int[] iArr;
        int length;
        if (yh.e()) {
            if (this.b.getAndSet(true)) {
                return;
            }
            if (this.a == null) {
                this.a = (SensorManager) r1.d().a().getSystemService("sensor");
            }
            if (this.a == null) {
                return;
            }
            if (r1.d().f().a("sole", 0) == 1) {
                List<Sensor> sensorList = this.a.getSensorList(-1);
                if (sensorList != null && sensorList.size() > 0) {
                    for (Sensor sensor : sensorList) {
                        int type = sensor.getType();
                        int[] iArr2 = this.e;
                        if (type == iArr2[0] || type == iArr2[1] || type == iArr2[2] || type == iArr2[3]) {
                            this.d.put(Integer.valueOf(type), sensor);
                        }
                    }
                }
                e();
                return;
            }
            if (a() || (length = (iArr = this.e).length) == 0) {
                return;
            }
            Sensor defaultSensor = this.a.getDefaultSensor(iArr[0]);
            if (defaultSensor != null) {
                this.d.put(Integer.valueOf(defaultSensor.getType()), defaultSensor);
            }
            for (int i = 1; i < length; i++) {
                k8.b().postDelayed(new b(i), this.c * i);
            }
        }
    }

    private kh() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Sensor sensor;
        CopyOnWriteArrayList<WeakReference<z20>> copyOnWriteArrayList = this.f;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0 || (sensor = this.d.get(2)) == null) {
            return;
        }
        Sensor sensor2 = this.d.get(9);
        Sensor sensor3 = this.d.get(1);
        if (sensor2 == null) {
            sensor2 = sensor3;
        }
        if (sensor2 == null) {
            return;
        }
        Iterator<WeakReference<z20>> it = this.f.iterator();
        while (it.hasNext()) {
            z20 z20Var = it.next().get();
            if (z20Var != null) {
                z20Var.a(sensor2, sensor);
            }
        }
    }

    public void a(z20 z20Var) {
        if (this.f == null) {
            this.f = new CopyOnWriteArrayList<>();
        }
        if (z20Var != null) {
            this.f.add(new WeakReference<>(z20Var));
        }
    }

    /* compiled from: A */
    private final class b implements Runnable {
        private int a;

        private b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i < 0 || i > kh.this.e.length - 1) {
                return;
            }
            Sensor defaultSensor = kh.this.a.getDefaultSensor(kh.this.e[this.a]);
            if (defaultSensor != null) {
                kh.this.d.put(Integer.valueOf(defaultSensor.getType()), defaultSensor);
            }
            if (this.a == kh.this.e.length - 1) {
                kh.this.e();
            }
        }
    }

    public boolean d() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    if (r1.d().f().a("sswog", 0) == 1) {
                        this.g = Boolean.TRUE;
                    } else {
                        this.g = Boolean.valueOf(a(4) != null);
                    }
                }
            }
        }
        return this.g.booleanValue();
    }

    private boolean a() {
        return this.c <= 0;
    }

    public Sensor a(int i) {
        SensorManager sensorManager;
        if (a() && (sensorManager = this.a) != null) {
            return sensorManager.getDefaultSensor(i);
        }
        c();
        return this.d.get(Integer.valueOf(i));
    }
}
