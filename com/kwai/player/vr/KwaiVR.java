package com.kwai.player.vr;

import android.content.Context;
import android.hardware.SensorEvent;
import android.util.Log;
import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiVR {
    public static final int INTERACTIVE_MODE_MOTION = 0;
    public static final int INTERACTIVE_MODE_MOTION_WITH_TOUCH = 2;
    public static final int INTERACTIVE_MODE_TOUCH = 1;
    public static final int STEREO_TYPE_NON = 0;
    public static final int STEREO_TYPE_SPHERE = 1;
    private static final String TAG = "KwaiVR";
    private Context mContext;
    private KwaiGestureHelper mGestureHelper;
    private int mInteractiveMode;
    private boolean mInteractiveValid = false;
    private KwaiOrientationHelper mKwaiOrientationHelper = KwaiOrientationHelper.builder().build();
    protected KwaiPlayerStereoMesh mKwaiPlayerStereoMesh;
    private boolean mPinchEnabled;
    private KwaiSensorHelper mSensorHelper;
    private int mStereoType;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    interface IAdvanceGestureListener {
        void onDrag(float f, float f2);

        void onPinch(float f);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    interface IAdvanceSensorListener {
        void OnRotation(int i);

        void onSensorMatrix(float[] fArr);

        boolean onStartOrientation(float[] fArr);
    }

    public KwaiVR(Builder builder) {
        this.mInteractiveMode = 0;
        this.mStereoType = 1;
        this.mContext = builder.mContext;
        this.mInteractiveMode = builder.mInteractiveMode;
        this.mPinchEnabled = builder.mPinchEnabled;
        this.mStereoType = builder.mStereoType;
        this.mKwaiPlayerStereoMesh = new KwaiPlayerStereoMesh(this.mStereoType);
        setUp();
    }

    public void setUp() {
        initGeusture();
        initSensor();
        setInteractiveMode(this.mInteractiveMode);
    }

    public void initGeusture() {
        KwaiGestureHelper kwaiGestureHelper = new KwaiGestureHelper(this.mContext);
        this.mGestureHelper = kwaiGestureHelper;
        kwaiGestureHelper.setAdvanceGestureListener(new IAdvanceGestureListener() { // from class: com.kwai.player.vr.KwaiVR.1
            @Override // com.kwai.player.vr.KwaiVR.IAdvanceGestureListener
            public void onDrag(float f, float f2) {
                KwaiVR.this.mKwaiOrientationHelper.setDelta(f, f2);
            }

            @Override // com.kwai.player.vr.KwaiVR.IAdvanceGestureListener
            public void onPinch(float f) {
                KwaiVR.this.mKwaiOrientationHelper.setNearScale(f);
            }
        });
    }

    public void initSensor() {
        KwaiSensorHelper kwaiSensorHelper = new KwaiSensorHelper(this.mContext);
        this.mSensorHelper = kwaiSensorHelper;
        kwaiSensorHelper.setAdvanceSensorListener(new IAdvanceSensorListener() { // from class: com.kwai.player.vr.KwaiVR.2
            @Override // com.kwai.player.vr.KwaiVR.IAdvanceSensorListener
            public void onSensorMatrix(float[] fArr) {
                KwaiVR.this.mKwaiOrientationHelper.updateSensorMatrix(fArr);
            }

            @Override // com.kwai.player.vr.KwaiVR.IAdvanceSensorListener
            public boolean onStartOrientation(float[] fArr) {
                return KwaiVR.this.mKwaiOrientationHelper.updateSensorOrigin(fArr);
            }

            @Override // com.kwai.player.vr.KwaiVR.IAdvanceSensorListener
            public void OnRotation(int i) {
                KwaiVR.this.mKwaiOrientationHelper.setRotation(i);
            }
        });
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        if (!this.mInteractiveValid) {
            Log.d(TAG, "handleTouchEvent: mInteractive is not Valid");
            return false;
        }
        KwaiGestureHelper kwaiGestureHelper = this.mGestureHelper;
        if (kwaiGestureHelper != null) {
            return kwaiGestureHelper.handleTouchEvent(motionEvent);
        }
        Log.d(TAG, "handleTouchEvent: mGestureHelper nil");
        return false;
    }

    public void handleSensorEvent(SensorEvent sensorEvent) {
        if (!this.mInteractiveValid) {
            Log.d(TAG, "handleSensorEvent: mInteractive is not Valid");
            return;
        }
        KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
        if (kwaiSensorHelper != null) {
            kwaiSensorHelper.onSensorChanged(sensorEvent);
        } else {
            Log.d(TAG, "handleSensorEvent: mSensorHelper nil");
        }
    }

    public float[] getMVPMatrix() {
        KwaiOrientationHelper kwaiOrientationHelper = this.mKwaiOrientationHelper;
        if (kwaiOrientationHelper != null) {
            return kwaiOrientationHelper.getMVPMatrix();
        }
        return null;
    }

    public void setViewport(int i, int i2) {
        KwaiOrientationHelper kwaiOrientationHelper = this.mKwaiOrientationHelper;
        if (kwaiOrientationHelper != null) {
            kwaiOrientationHelper.setViewport(i, i2);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class Builder {
        private Context mContext;
        private boolean mPinchEnabled = false;
        private int mInteractiveMode = 2;
        private int mStereoType = 1;

        public Builder setContext(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder setInteractive(int i) {
            this.mInteractiveMode = i;
            return this;
        }

        public Builder setPinchEnabled(boolean z) {
            this.mPinchEnabled = z;
            return this;
        }

        public Builder setStereoType(int i) {
            this.mStereoType = i;
            return this;
        }

        public KwaiVR build() {
            return new KwaiVR(this);
        }
    }

    public void setPinchEnabled(boolean z) {
        this.mPinchEnabled = z;
        this.mGestureHelper.setPinchEnabled(z);
    }

    public int getInteractiveMode() {
        return this.mInteractiveMode;
    }

    public void setInteractiveMode(int i) {
        Log.d(TAG, "setInteractiveMode: " + i);
        this.mInteractiveMode = i;
        if (i == 0) {
            setGestureEnabled(false);
            setSensorEnabled(true);
        } else if (i == 1) {
            setGestureEnabled(true);
            setSensorEnabled(false);
        } else {
            if (i != 2) {
                return;
            }
            setGestureEnabled(true);
            setSensorEnabled(true);
        }
    }

    private void setGestureEnabled(boolean z) {
        KwaiGestureHelper kwaiGestureHelper = this.mGestureHelper;
        if (kwaiGestureHelper != null) {
            kwaiGestureHelper.setGestureEnabled(z);
        }
        this.mGestureHelper.setPinchEnabled(this.mPinchEnabled);
    }

    private void setSensorEnabled(boolean z) {
        KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
        if (kwaiSensorHelper != null && z) {
            kwaiSensorHelper.turnOnInGL(this.mContext, true);
        } else if (kwaiSensorHelper != null) {
            kwaiSensorHelper.turnOffInGL(this.mContext);
        }
    }

    public KwaiMesh getKwaiMesh() {
        KwaiPlayerStereoMesh kwaiPlayerStereoMesh = this.mKwaiPlayerStereoMesh;
        if (kwaiPlayerStereoMesh != null) {
            return kwaiPlayerStereoMesh.getKwaiMesh();
        }
        return null;
    }

    public void setInteractiveValid() {
        this.mInteractiveValid = true;
        Log.d(TAG, "set interactive valid");
    }

    public void release() {
        KwaiGestureHelper kwaiGestureHelper = this.mGestureHelper;
        if (kwaiGestureHelper != null) {
            kwaiGestureHelper.setGestureEnabled(false);
            this.mGestureHelper = null;
        }
        KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
        if (kwaiSensorHelper != null) {
            kwaiSensorHelper.turnOffInGL(this.mContext);
            this.mSensorHelper = null;
        }
    }

    public void recenterOrientation() {
        KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
        if (kwaiSensorHelper != null) {
            kwaiSensorHelper.resetYaw();
        }
    }

    public void resetGesture() {
        KwaiGestureHelper kwaiGestureHelper = this.mGestureHelper;
        if (kwaiGestureHelper != null) {
            kwaiGestureHelper.reset();
        }
    }

    public int getOrientaionDegrees() {
        KwaiOrientationHelper kwaiOrientationHelper = this.mKwaiOrientationHelper;
        if (kwaiOrientationHelper == null) {
            return 0;
        }
        kwaiOrientationHelper.getOrientaionDegrees();
        return 0;
    }

    public void registerSensorEvent() {
        KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
        if (kwaiSensorHelper != null) {
            kwaiSensorHelper.turnOnInGL(this.mContext, true);
        }
    }

    public void unRegisterSensorEvent() {
        KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
        if (kwaiSensorHelper != null) {
            kwaiSensorHelper.turnOffInGL(this.mContext);
        }
    }

    public boolean isSupport() {
        return this.mStereoType == 1;
    }

    public float[] getOrientation() {
        KwaiOrientationHelper kwaiOrientationHelper = this.mKwaiOrientationHelper;
        if (kwaiOrientationHelper != null) {
            return kwaiOrientationHelper.getOrientation();
        }
        return null;
    }
}
