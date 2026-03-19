package com.bytedance.common.utility.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.common.utility.Logger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ShakeDetector implements SensorEventListener {
    private static final float ACCEL_THRESHOLD = 2.0f;
    private static final int BUFFER_SIZE = 10;
    public static final boolean ENABLE_SHAKER = false;
    private static final int FORCE_TIMEOUT = 500;
    private static final int MIN_SHAKE_COUNT = 3;
    private static final int MIN_SHAKE_INTERVAL = 1500;
    private static final int SHAKE_DURATION = 1000;
    private static final int SHAKE_TIMEOUT = 800;
    private static final int TIME_THRESHOLD = 100;
    private float mAccel;
    private float mAccelCurrent;
    private float mAccelLast;
    RingBuffer mBuffer;
    private long mLastShakeTime;
    private long mLastTime;
    private OnShakeListener mListener;
    Sensor mSensor;
    SensorManager mSensorMgr;

    public interface OnShakeListener {
        void onShake();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public ShakeDetector(Context context, OnShakeListener onShakeListener) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.mLastShakeTime < 1500) {
                return;
            }
            long j = jCurrentTimeMillis - this.mLastTime;
            if (j > 100) {
                this.mLastTime = jCurrentTimeMillis;
                float f = sensorEvent.values[0];
                float f2 = sensorEvent.values[1];
                float f3 = sensorEvent.values[2];
                this.mAccelLast = this.mAccelCurrent;
                float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
                this.mAccelCurrent = fSqrt;
                this.mAccel = (this.mAccel * 0.9f) + (fSqrt - this.mAccelLast);
                Logger.d("Shaker", j + " " + this.mAccel + " " + f + " " + f2 + " " + f3);
                this.mBuffer.add(this.mAccel, jCurrentTimeMillis);
                if (Math.abs(this.mAccel) <= ACCEL_THRESHOLD || !this.mBuffer.levelReached(jCurrentTimeMillis)) {
                    return;
                }
                this.mBuffer.clear();
                this.mLastShakeTime = jCurrentTimeMillis;
                OnShakeListener onShakeListener = this.mListener;
                if (onShakeListener != null) {
                    onShakeListener.onShake();
                }
            }
        }
    }

    static class RingBuffer {
        final float[] mAccelRing;
        int mIndex = 0;
        int mSize;
        final long[] mStampRing;

        RingBuffer(int i) {
            this.mSize = i;
            this.mAccelRing = new float[i];
            this.mStampRing = new long[i];
        }

        void clear() {
            this.mIndex = 0;
            for (int i = 0; i < this.mSize; i++) {
                this.mStampRing[i] = 0;
            }
        }

        void add(float f, long j) {
            float[] fArr = this.mAccelRing;
            int i = this.mIndex;
            fArr[i] = f;
            this.mStampRing[i] = j;
            this.mIndex = (i + 1) % this.mSize;
        }

        boolean levelReached(long j) {
            int i = this.mIndex;
            long j2 = 0;
            long j3 = 0;
            boolean z = true;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.mSize;
                if (i2 >= i4) {
                    return false;
                }
                i--;
                if (i < 0) {
                    i = i4 - 1;
                }
                long j4 = this.mStampRing[i];
                if (j4 <= 0 || j - j4 > 1000) {
                    return false;
                }
                if (j2 > 0 && j2 - j4 > 800) {
                    return false;
                }
                if (j3 > 0 && j3 - j4 > 500) {
                    return false;
                }
                float f = this.mAccelRing[i];
                if (Math.abs(f) >= ShakeDetector.ACCEL_THRESHOLD) {
                    boolean z2 = f > 0.0f;
                    if (i3 == 0 || z2 != z) {
                        i3++;
                        z = z2;
                        j2 = j4;
                    }
                    if (i3 >= 3) {
                        return true;
                    }
                    j3 = j4;
                }
                i2++;
            }
        }
    }
}
