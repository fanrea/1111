package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.forbes.Config;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class bj {
    private static volatile bj cmY;
    private final Map<String, a> cmZ = new ConcurrentHashMap();
    private final Map<String, CopyOnWriteArraySet<SensorEventListener>> cna = new ConcurrentHashMap();
    private boolean cnb = false;

    public interface b {
        void onFailed();
    }

    private static int hA(int i) {
        if (i == -3) {
            return 2;
        }
        if (i != -2) {
            return i != -1 ? 3 : 0;
        }
        return 1;
    }

    static /* synthetic */ Sensor a(bj bjVar, int i) {
        return hz(i);
    }

    static /* synthetic */ int b(bj bjVar, int i) {
        return hA(i);
    }

    private bj() {
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bj.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() throws NumberFormatException {
                super.onBackToForeground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToForeground ");
                SensorManager sensorManagerCheckAndObtainSensorManager = bl.apH().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bj.this.cmZ.keySet()) {
                    a aVar = (a) bj.this.cmZ.get(str);
                    if (aVar != null) {
                        sensorManagerCheckAndObtainSensorManager.registerListener(aVar, bj.a(bj.this, Integer.parseInt(str.split(Config.replace)[0])), bj.b(bj.this, Integer.parseInt(str.split(Config.replace)[1])));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "register successfully: " + str);
                    }
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToBackground");
                SensorManager sensorManagerCheckAndObtainSensorManager = bl.apH().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bj.this.cmZ.keySet()) {
                    try {
                        sensorManagerCheckAndObtainSensorManager.unregisterListener((a) bj.this.cmZ.get(str));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "unregister successfully: " + str);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public static bj apC() {
        if (cmY == null) {
            synchronized (bj.class) {
                if (cmY == null) {
                    cmY = new bj();
                }
            }
        }
        return cmY;
    }

    public final synchronized void a(int i, int i2, SensorEventListener sensorEventListener, b bVar) {
        Sensor sensorHz = hz(i);
        if (sensorHz == null) {
            if (bVar != null) {
                bVar.onFailed();
            }
            return;
        }
        String strAd = ad(i, i2);
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.cna.get(strAd);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        }
        copyOnWriteArraySet.add(sensorEventListener);
        if (copyOnWriteArraySet.size() == 1) {
            this.cna.put(strAd, copyOnWriteArraySet);
            a(strAd, i2, sensorHz);
        }
    }

    public final synchronized void c(SensorEventListener sensorEventListener) {
        for (Map.Entry<String, CopyOnWriteArraySet<SensorEventListener>> entry : this.cna.entrySet()) {
            CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
            Iterator<SensorEventListener> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SensorEventListener next = it.next();
                if (next.equals(sensorEventListener)) {
                    value.remove(next);
                    break;
                }
            }
            if (value.size() == 0) {
                iF(entry.getKey());
            }
        }
    }

    private void iF(String str) {
        a aVar = this.cmZ.get(str);
        if (aVar != null) {
            this.cmZ.remove(str);
            try {
                bl.apH().unregisterListener(aVar);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    private void a(String str, int i, Sensor sensor) {
        boolean zUseSensorManagerDisable = bd.useSensorManagerDisable();
        this.cnb = zUseSensorManagerDisable;
        if (zUseSensorManagerDisable) {
            return;
        }
        bl.apH().registerListener(ServiceProvider.getContext(), iG(str), sensor, hA(i));
    }

    private static Sensor hz(int i) {
        bl blVarApH = bl.apH();
        Context context = ServiceProvider.getContext();
        if (i == 1) {
            return blVarApH.getDefaultSensor(context, 10);
        }
        if (i == 2) {
            return blVarApH.getDefaultSensor(context, 4);
        }
        if (i == 3) {
            return blVarApH.getDefaultSensor(context, 1);
        }
        if (i != 4) {
            return null;
        }
        return blVarApH.getDefaultSensor(context, 9);
    }

    private a iG(String str) {
        a aVar = this.cmZ.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str, this);
        this.cmZ.put(str, aVar2);
        return aVar2;
    }

    private static String ad(int i, int i2) {
        return i + Config.replace + i2;
    }

    public static class a implements SensorEventListener {
        private final WeakReference<bj> agc;
        private final String key;

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public a(String str, bj bjVar) {
            this.key = str;
            this.agc = new WeakReference<>(bjVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            bj bjVar = this.agc.get();
            if (bjVar != null) {
                bjVar.a(this.key, sensorEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, SensorEvent sensorEvent) {
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.cna.get(str);
        if (copyOnWriteArraySet != null) {
            Iterator<SensorEventListener> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().onSensorChanged(sensorEvent);
            }
        }
    }
}
