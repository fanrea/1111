package com.ss.texturerender.effect.vr.director.sensordirector;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.bpea.basics.Cert;
import com.ss.texturerender.TextureRenderLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SensorHelper {
    private static final String LOG_TAG = "TR_DeviceSensorLooper";
    private boolean isRunning;
    private SensorEventListener sensorEventListener;
    private Looper sensorLooper;
    private SensorManager sensorManager;
    private Cert mCert = null;
    private final ArrayList<SensorEventListener> registeredListeners = new ArrayList<>();
    private int mTexType = -1;

    public void setCert(Serializable serializable) {
    }

    public SensorHelper(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Sensor getUncalibratedGyro() {
        if (Build.VERSION.SDK_INT < 18 || Build.MANUFACTURER.equals("HTC")) {
            return null;
        }
        return this.sensorManager.getDefaultSensor(16);
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.sensorEventListener = new SensorEventListener() { // from class: com.ss.texturerender.effect.vr.director.sensordirector.SensorHelper.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                synchronized (SensorHelper.this.registeredListeners) {
                    Iterator it = SensorHelper.this.registeredListeners.iterator();
                    while (it.hasNext()) {
                        ((SensorEventListener) it.next()).onSensorChanged(sensorEvent);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
                synchronized (SensorHelper.this.registeredListeners) {
                    Iterator it = SensorHelper.this.registeredListeners.iterator();
                    while (it.hasNext()) {
                        ((SensorEventListener) it.next()).onAccuracyChanged(sensor, i);
                    }
                }
            }
        };
        HandlerThread handlerThread = new HandlerThread("sensor") { // from class: com.ss.texturerender.effect.vr.director.sensordirector.SensorHelper.2
            @Override // android.os.HandlerThread
            protected void onLooperPrepared() {
                Handler handler = new Handler(Looper.myLooper());
                SensorHelper.this.sensorManager.registerListener(SensorHelper.this.sensorEventListener, SensorHelper.this.sensorManager.getDefaultSensor(1), 16666, handler);
                Sensor uncalibratedGyro = SensorHelper.this.getUncalibratedGyro();
                if (uncalibratedGyro == null) {
                    TextureRenderLog.e(SensorHelper.this.mTexType, SensorHelper.LOG_TAG, "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
                    uncalibratedGyro = SensorHelper.this.sensorManager.getDefaultSensor(4);
                }
                if (uncalibratedGyro == null) {
                    TextureRenderLog.e(SensorHelper.this.mTexType, SensorHelper.LOG_TAG, "gyroscope unavailable");
                }
                SensorHelper.this.sensorManager.registerListener(SensorHelper.this.sensorEventListener, uncalibratedGyro, 16666, handler);
            }
        };
        handlerThread.start();
        this.sensorLooper = handlerThread.getLooper();
        this.isRunning = true;
    }

    public void stop() {
        if (this.isRunning) {
            this.sensorManager.unregisterListener(this.sensorEventListener);
            this.sensorEventListener = null;
            this.sensorLooper.quit();
            this.sensorLooper = null;
            this.isRunning = false;
        }
    }

    public void registerListener(SensorEventListener sensorEventListener) {
        synchronized (this.registeredListeners) {
            this.registeredListeners.add(sensorEventListener);
        }
    }

    public void unregisterListener(SensorEventListener sensorEventListener) {
        synchronized (this.registeredListeners) {
            this.registeredListeners.remove(sensorEventListener);
        }
    }
}
