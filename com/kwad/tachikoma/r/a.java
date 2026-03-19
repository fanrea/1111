package com.kwad.tachikoma.r;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.tachikoma.t.g;
import com.tkruntime.v8.V8Function;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a implements SensorEventListener {
    private g ED;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public a(V8Function v8Function, com.tk.core.bridge.b bVar) {
        this.ED = new g(v8Function, bVar);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (this.ED != null) {
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < sensorEvent.values.length; i++) {
                arrayList.add(Float.valueOf(sensorEvent.values[i]));
            }
            map.put("values", arrayList);
            map.put(com.alipay.sdk.m.t.a.k, Double.valueOf(sensorEvent.timestamp));
            map.put("accuracy", Integer.valueOf(sensorEvent.accuracy));
            this.ED.call(null, map);
        }
    }

    public final void ch(int i) {
        if (this.ED != null) {
            HashMap map = new HashMap();
            map.put("errorCode", -1);
            this.ED.call(null, map);
        }
    }

    public final void onDestroy() {
        g gVar = this.ED;
        if (gVar != null) {
            gVar.destroy();
        }
    }
}
