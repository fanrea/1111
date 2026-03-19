package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface ISensorManagerProxy {
    SensorManager checkAndObtainSensorManager(Context context);

    Sensor getDefaultSensor(Context context, int i);

    boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i);

    void unregisterListener(SensorEventListener sensorEventListener);
}
