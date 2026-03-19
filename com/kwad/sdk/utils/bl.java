package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class bl {
    private static bl cnm;
    private SensorManager mSensorManager;

    public static bl apH() {
        if (cnm == null) {
            synchronized (bl.class) {
                if (cnm == null) {
                    cnm = new bl();
                }
            }
        }
        return cnm;
    }

    private static boolean apI() {
        return !bd.useSensorManagerDisable();
    }

    public final SensorManager checkAndObtainSensorManager(Context context) {
        if (apJ()) {
            return eE(context);
        }
        return null;
    }

    private boolean apJ() {
        boolean zApI = apI();
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "checkEnableSensor enable:" + zApI);
        if (zApI) {
            return true;
        }
        this.mSensorManager = null;
        return false;
    }

    private SensorManager eE(Context context) {
        if (this.mSensorManager == null) {
            this.mSensorManager = (SensorManager) context.getSystemService("sensor");
        }
        return this.mSensorManager;
    }

    public final Sensor getDefaultSensor(Context context, int i) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "getDefaultSensor type:" + i);
        if (apJ()) {
            return eE(context).getDefaultSensor(i);
        }
        return null;
    }

    public final boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "registerListener sensor:" + sensor + ", listener: " + sensorEventListener);
        if (!apJ()) {
            return false;
        }
        try {
            return eE(context).registerListener(sensorEventListener, sensor, i);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void unregisterListener(SensorEventListener sensorEventListener) {
        SensorManager sensorManager;
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "unregisterListener listener:" + sensorEventListener);
        if (apJ() && (sensorManager = this.mSensorManager) != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Throwable unused) {
            }
        }
    }
}
