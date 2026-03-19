package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.utils.bj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bk implements SensorEventListener {
    private final b cnd;
    private final b cne;
    private final b cnf;
    private boolean cng;
    private boolean cnh;
    private final bj.b cni;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* synthetic */ bk(byte b2) {
        this();
    }

    static /* synthetic */ boolean a(bk bkVar, boolean z) {
        bkVar.cng = true;
        return true;
    }

    private bk() {
        byte b2 = 0;
        this.cnd = new b(b2);
        this.cne = new b(b2);
        this.cnf = new b(b2);
        this.cng = false;
        this.cni = new bj.b() { // from class: com.kwad.sdk.utils.bk.2
            @Override // com.kwad.sdk.utils.bj.b
            public final void onFailed() {
                bk.a(bk.this, true);
            }
        };
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bk.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                if (s.aoa()) {
                    bk.this.register();
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                bk.this.apF();
            }
        });
    }

    static class a {
        private static final bk cnk = new bk(0);
    }

    public static bk apD() {
        return a.cnk;
    }

    public final synchronized List<com.kwad.sdk.l.a.e> apE() {
        if (!s.aoa()) {
            return null;
        }
        com.kwad.sdk.core.c.b.aaf();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            register();
        }
        ArrayList arrayList = new ArrayList();
        this.cnd.aN(arrayList);
        this.cne.aN(arrayList);
        this.cnf.aN(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void register() {
        if (!this.cng && !this.cnh) {
            this.cnh = true;
            try {
                bj.apC().a(3, 3, this, this.cni);
                bj.apC().a(2, 3, this, this.cni);
                bj.apC().a(4, 3, this, this.cni);
            } catch (Throwable unused) {
                this.cng = true;
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.cnd.b(sensorEvent);
        } else if (type == 4) {
            this.cne.b(sensorEvent);
        } else {
            if (type != 9) {
                return;
            }
            this.cnf.b(sensorEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void apF() {
        if (this.cnh) {
            bj.apC().c(this);
            this.cnh = false;
        }
    }

    static class b {
        private SensorEvent cnl;
        private long timestamp;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void b(SensorEvent sensorEvent) {
            this.cnl = sensorEvent;
            this.timestamp = System.currentTimeMillis();
        }

        public final void aN(List<com.kwad.sdk.l.a.e> list) {
            if (this.cnl == null) {
                return;
            }
            com.kwad.sdk.l.a.e eVar = new com.kwad.sdk.l.a.e();
            eVar.sensorType = this.cnl.sensor.getType();
            eVar.timestamp = this.timestamp / 1000;
            for (float f : this.cnl.values) {
                eVar.bUF.add(Float.valueOf(f));
            }
            list.add(eVar);
        }
    }
}
