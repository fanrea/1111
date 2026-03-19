package com.ss.texturerender.effect.vr.director.sensordirector;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.component.feed.a;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.effect.vr.director.IDirector;
import com.ss.texturerender.effect.vr.director.IDirectorEventListener;
import com.ss.texturerender.math.Matrix3x3d;
import com.ss.texturerender.math.Quaternion;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SensorDirector extends GestureDetector.SimpleOnGestureListener implements IDirector, SensorEventListener {
    private static final String LOG_TAG = "TR_SensorDirector";
    private IDirectorEventListener mDirectorEventListener;
    private Display mDisplay;
    private SensorFusionEkf mFusionEkf;
    private SensorHelper mSensorEventProvider;
    private boolean mSensorResetPosKeepFix;
    private int mSensorStartPos;
    private int mTexType;
    private volatile boolean tracking;
    private int mDirectMode = 1;
    private Quaternion mLastRotation = new Quaternion();
    private boolean resetSensorAfterDisplayRotationChange = false;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public SensorDirector(Context context, Display display, int i, int i2, int i3, int i4, double d, IDirectorEventListener iDirectorEventListener) {
        this.mDirectorEventListener = null;
        this.mTexType = i3;
        this.mSensorEventProvider = new SensorHelper((SensorManager) context.getSystemService("sensor"));
        this.mDisplay = display;
        SensorFusionEkf sensorFusionEkf = new SensorFusionEkf(this.mTexType);
        this.mFusionEkf = sensorFusionEkf;
        sensorFusionEkf.setGyroSmootherParam(i4 == 1, d);
        this.mFusionEkf.setSensorStartPos(i);
        this.mFusionEkf.setDisplayRotation(this.mDisplay.getRotation());
        this.mSensorStartPos = i;
        this.mSensorResetPosKeepFix = i2 == 1;
        this.mDirectorEventListener = iDirectorEventListener;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            this.mFusionEkf.processAcc(sensorEvent);
        } else if (sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16) {
            this.mFusionEkf.processGyro(sensorEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mDirectMode == 1) {
            return false;
        }
        return this.mFusionEkf.processScroll(motionEvent, motionEvent2, f, f2);
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void start() {
        if (this.tracking) {
            return;
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "start");
        this.mSensorEventProvider.registerListener(this);
        this.mSensorEventProvider.start();
        SensorFusionEkf sensorFusionEkf = this.mFusionEkf;
        if (sensorFusionEkf != null) {
            if (!sensorFusionEkf.isAlignedGravity()) {
                this.mFusionEkf.reset();
            } else {
                this.mFusionEkf.reset();
                if (!this.mSensorResetPosKeepFix || this.mSensorStartPos != 1) {
                    this.mFusionEkf.setSensorStartPos(2);
                    this.mFusionEkf.setRotationFromStart(this.mLastRotation);
                }
            }
            testRotationChange(true);
        }
        this.tracking = true;
    }

    private void testRotationChange(boolean z) {
        int rotation = this.mDisplay.getRotation();
        if (rotation != this.mFusionEkf.getDisplayRotation()) {
            if (z) {
                this.mFusionEkf.reset();
            }
            this.mFusionEkf.setDisplayRotation(rotation);
            this.mFusionEkf.setSensorStartPos(this.mSensorStartPos);
            IDirectorEventListener iDirectorEventListener = this.mDirectorEventListener;
            if (iDirectorEventListener != null) {
                iDirectorEventListener.onDisplayRotationChanged(rotation, z);
            }
        }
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void getView(float[] fArr, int i) {
        testRotationChange(this.resetSensorAfterDisplayRotationChange);
        if (this.mFusionEkf.isAlignedGravity()) {
            this.mLastRotation = this.mFusionEkf.getRotation();
        }
        Matrix3x3d.matrixToColumnArray(Matrix3x3d.rotationMatrix3x3(this.mLastRotation), fArr);
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void stop() {
        if (this.tracking) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, a.e);
            this.mSensorEventProvider.unregisterListener(this);
            this.mSensorEventProvider.stop();
            this.tracking = false;
        }
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void reset() {
        this.mLastRotation = new Quaternion();
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void setParam(Bundle bundle) {
        if (bundle != null) {
            SensorFusionEkf sensorFusionEkf = this.mFusionEkf;
            if (sensorFusionEkf != null) {
                sensorFusionEkf.setIsDisableZrotation(bundle.getInt(TextureRenderKeys.KEY_IS_INT_DISABLE_AXIS) == 3);
            }
            if (this.mSensorEventProvider == null || !bundle.containsKey(TextureRenderKeys.KEY_IS_CERT)) {
                return;
            }
            this.mSensorEventProvider.setCert(bundle.getSerializable(TextureRenderKeys.KEY_IS_CERT));
        }
    }
}
