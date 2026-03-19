package com.bykv.vk.component.ttvideo.player;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SensorData {
    protected static final int Sensor_ACC_Data = 1;
    protected static final int Sensor_MAG_Data = 2;
    protected static final int Sensor_ROT_Data = 3;
    private long mHandle = 0;
    private SensorManager mSensorManager = null;
    private SensorEventListener mListener = null;
    private float[] magnet = new float[3];
    private float[] accel = new float[3];

    private static final native void _writeData(long j, int i, float f, float f2, float f3);

    protected void finalize() {
        stop();
    }

    public Boolean initListeners() {
        return Boolean.FALSE;
    }

    public void setHandle(long j, TTPlayer tTPlayer) {
        this.mHandle = j;
        tTPlayer.getContext();
    }

    public void stop() {
        mq.c("ttmn", "stop sensor");
        this.mHandle = 0L;
    }

    public int start() {
        return initListeners().booleanValue() ? 0 : -1;
    }
}
