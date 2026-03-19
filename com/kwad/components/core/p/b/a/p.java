package com.kwad.components.core.p.b.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kwad.components.offline.api.core.api.ISensorManagerProxy;
import com.kwad.sdk.utils.bl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class p implements ISensorManagerProxy {
    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final SensorManager checkAndObtainSensorManager(Context context) {
        return bl.apH().checkAndObtainSensorManager(context);
    }

    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final Sensor getDefaultSensor(Context context, int i) {
        return bl.apH().getDefaultSensor(context, i);
    }

    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i) {
        return bl.apH().registerListener(context, sensorEventListener, sensor, i);
    }

    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final void unregisterListener(SensorEventListener sensorEventListener) {
        bl.apH().unregisterListener(sensorEventListener);
    }
}
