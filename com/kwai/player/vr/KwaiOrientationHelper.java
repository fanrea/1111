package com.kwai.player.vr;

import android.opengl.Matrix;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiOrientationHelper {
    private static final String TAG = "KwaiOrientationHelper";
    public static final int UIDeviceOrientationFaceDown = 5;
    public static final int UIDeviceOrientationFaceUp = 4;
    public static final int UIDeviceOrientationLandscapeLeft = 2;
    public static final int UIDeviceOrientationLandscapeRight = 3;
    public static final int UIDeviceOrientationPortrait = 1;
    public static final int UIDeviceOrientationUnknown = 0;
    private static final float mNear = 0.7f;
    private int mDegrees;
    private float mDeltaX;
    private float mDeltaY;
    private float mEyeX;
    private float mEyeY;
    private float mEyeZ;
    private float mLookX;
    private float mLookY;
    private float mNearScale;
    private float[] mViewMatrix = new float[16];
    private float[] mProjectionMatrix = new float[16];
    private float[] mMVPMatrix = new float[16];
    private float[] mWorldRotationMatrix = new float[16];
    private float[] mWorldRotationInvertMatrix = new float[16];
    private float[] mCurrentRotationPost = new float[16];
    private float[] mSensorMatrix = new float[16];
    private float[] mTempMatrix = new float[16];
    private float[] mCameraMatrix = new float[16];
    private float[] mModelMatrix = new float[16];
    private float[] mStartFromSensorTransformation = new float[3];
    private float[] mOrientation = new float[3];
    private float mscale = 0.5f;
    private float mLookZ = -1.0f;
    private boolean mProjectionValidate = false;
    private boolean mPositionValidate = true;
    private boolean mModelValidate = true;
    private float mRatio = 1.5f;
    private int mViewportWidth = 0;
    private int mViewportHeight = 0;
    private int mRotation = 0;
    private float threshold = 40.0f;
    private int mDeviceorientation = 0;
    private boolean mWorldRotationMatrixInvalidate = true;

    protected KwaiOrientationHelper(Builder builder) {
        this.mEyeX = 0.0f;
        this.mEyeY = 0.0f;
        this.mEyeZ = 0.0f;
        this.mLookX = 0.0f;
        this.mLookY = 0.0f;
        this.mNearScale = 1.0f;
        this.mEyeX = builder.mEyeX;
        this.mEyeY = builder.mEyeY;
        this.mEyeZ = builder.mEyeZ;
        this.mLookX = builder.mLookX;
        this.mLookY = builder.mLookY;
        this.mNearScale = builder.mNearScale;
        initModel();
    }

    public float getDeltaY() {
        return this.mDeltaY;
    }

    public void setDelta(float f, float f2) {
        this.mDeltaX = f;
        this.mDeltaY = f2;
        this.mWorldRotationMatrixInvalidate = true;
    }

    public float getDeltaX() {
        return this.mDeltaX;
    }

    private void initModel() {
        Matrix.setIdentityM(this.mViewMatrix, 0);
        Matrix.setIdentityM(this.mViewMatrix, 0);
        Matrix.setIdentityM(this.mSensorMatrix, 0);
    }

    private void updateViewMatrixIfNeed() {
        boolean z = this.mWorldRotationMatrixInvalidate;
        if (this.mPositionValidate) {
            updateCameraMatrix();
            this.mPositionValidate = false;
        }
        if (this.mModelValidate) {
            updateModelMatrix();
            this.mModelValidate = false;
        }
        if (z) {
            updateWorldRotationMatrix();
            this.mWorldRotationMatrixInvalidate = false;
        }
        if (this.mPositionValidate || z) {
            Matrix.multiplyMM(this.mViewMatrix, 0, this.mCameraMatrix, 0, this.mWorldRotationMatrix, 0);
        }
        calDegrees();
    }

    public void setViewport(int i, int i2) {
        this.mViewportWidth = i;
        this.mViewportHeight = i2;
        this.mRatio = (i * 1.0f) / i2;
        this.mProjectionValidate = true;
        Log.d(TAG, "KwaiOrientationHelper setViewport width:" + i + " height:" + i2);
    }

    public void setRotation(int i) {
        this.mRotation = i;
        Log.d(TAG, "KwaiOrientationHelper setRotation: " + this.mRotation);
        this.mProjectionValidate = true;
    }

    public void setNearScale(float f) {
        this.mNearScale = f;
        this.mProjectionValidate = true;
    }

    private void updateProjectionIfNeed() {
        if (this.mProjectionValidate) {
            updateProjection();
            this.mProjectionValidate = false;
        }
    }

    protected void updateProjection() {
        float f = this.mRatio;
        Matrix.frustumM(getProjectionMatrix(), 0, (-f) / 2.0f, f / 2.0f, -0.5f, 0.5f, getNear(), 500.0f);
    }

    protected float getNear() {
        float f;
        float f2 = this.mRatio;
        float f3 = mNear;
        if (f2 < 1.0f) {
            f = this.mNearScale * mNear;
            f3 = this.mscale;
        } else {
            f = this.mNearScale;
        }
        return f * f3;
    }

    public float[] getProjectionMatrix() {
        return this.mProjectionMatrix;
    }

    public int getViewportWidth() {
        return this.mViewportWidth;
    }

    public int getViewportHeight() {
        return this.mViewportHeight;
    }

    public float[] getViewMatrix() {
        return this.mViewMatrix;
    }

    private void updateCameraMatrix() {
        Matrix.setIdentityM(this.mCameraMatrix, 0);
        Matrix.setLookAtM(this.mCameraMatrix, 0, this.mEyeX, this.mEyeY, this.mEyeZ, this.mLookX, this.mLookY, this.mLookZ, 0.0f, 1.0f, 0.0f);
    }

    private void updateModelMatrix() {
        Matrix.setIdentityM(this.mModelMatrix, 0);
        float[] fArr = this.mStartFromSensorTransformation;
        if (fArr != null) {
            Matrix.rotateM(this.mModelMatrix, 0, -fArr[0], 0.0f, 1.0f, 0.0f);
            Matrix.rotateM(this.mModelMatrix, 0, this.mStartFromSensorTransformation[2], 0.0f, 1.0f, 0.0f);
        }
        Matrix.rotateM(this.mModelMatrix, 0, 0.0f, 0.0f, 0.0f, 1.0f);
    }

    private void updateWorldRotationMatrix() {
        Matrix.setIdentityM(this.mWorldRotationMatrix, 0);
        Matrix.rotateM(this.mWorldRotationMatrix, 0, -this.mDeltaY, 1.0f, 0.0f, 0.0f);
        Matrix.setIdentityM(this.mCurrentRotationPost, 0);
        Matrix.rotateM(this.mCurrentRotationPost, 0, -this.mDeltaX, 0.0f, 1.0f, 0.0f);
        Matrix.setIdentityM(this.mTempMatrix, 0);
        Matrix.multiplyMM(this.mTempMatrix, 0, this.mCurrentRotationPost, 0, this.mModelMatrix, 0);
        synchronized (this) {
            Matrix.multiplyMM(this.mCurrentRotationPost, 0, this.mSensorMatrix, 0, this.mTempMatrix, 0);
        }
        Matrix.multiplyMM(this.mTempMatrix, 0, this.mWorldRotationMatrix, 0, this.mCurrentRotationPost, 0);
        System.arraycopy(this.mTempMatrix, 0, this.mWorldRotationMatrix, 0, 16);
        if (Matrix.invertM(this.mWorldRotationInvertMatrix, 0, this.mWorldRotationMatrix, 0)) {
            return;
        }
        Matrix.setIdentityM(this.mWorldRotationInvertMatrix, 0);
    }

    public void updateSensorMatrix(float[] fArr) {
        if (fArr == null || fArr.length != 16 || Float.isNaN(fArr[0]) || Float.isNaN(fArr[1])) {
            return;
        }
        synchronized (this) {
            System.arraycopy(fArr, 0, this.mSensorMatrix, 0, 16);
        }
        this.mWorldRotationMatrixInvalidate = true;
    }

    public boolean updateSensorOrigin(float[] fArr) {
        synchronized (this) {
            this.mStartFromSensorTransformation = fArr;
            this.mModelValidate = true;
        }
        return true;
    }

    public void reset() {
        this.mDeltaY = 0.0f;
        this.mDeltaX = 0.0f;
        Matrix.setIdentityM(this.mSensorMatrix, 0);
        this.mWorldRotationMatrixInvalidate = true;
    }

    public static Builder builder() {
        return new Builder();
    }

    public float[] getWorldRotationInvert() {
        return this.mWorldRotationInvertMatrix;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class Builder {
        private float mEyeX = 0.0f;
        private float mEyeY = 0.0f;
        private float mEyeZ = 0.0f;
        private float mLookX = 0.0f;
        private float mLookY = 0.0f;
        private float mNearScale = 1.0f;

        public Builder setLookX(float f) {
            this.mLookX = f;
            return this;
        }

        public Builder setLookY(float f) {
            this.mLookY = f;
            return this;
        }

        public Builder setEyeX(float f) {
            this.mEyeX = f;
            return this;
        }

        public Builder setEyeY(float f) {
            this.mEyeY = f;
            return this;
        }

        public Builder setEyeZ(float f) {
            this.mEyeZ = f;
            return this;
        }

        public Builder setNearScale(float f) {
            this.mNearScale = f;
            return this;
        }

        public KwaiOrientationHelper build() {
            return new KwaiOrientationHelper(this);
        }
    }

    public float[] getMVPMatrix() {
        updateProjectionIfNeed();
        updateViewMatrixIfNeed();
        Matrix.multiplyMM(this.mMVPMatrix, 0, this.mProjectionMatrix, 0, this.mViewMatrix, 0);
        return this.mMVPMatrix;
    }

    public boolean isNearValue(float f, float f2) {
        return Math.abs(f - f2) < this.threshold;
    }

    public boolean isNearValueABS(float f, float f2) {
        return isNearValue(Math.abs(f), Math.abs(f2));
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void calDegrees() {
        /*
            r14 = this;
            com.kwai.player.vr.MDQuaternion r0 = new com.kwai.player.vr.MDQuaternion
            r0.<init>()
            float[] r1 = r14.mWorldRotationMatrix
            float[] r2 = r14.mOrientation
            android.hardware.SensorManager.getOrientation(r1, r2)
            float[] r1 = r14.mWorldRotationMatrix
            r0.fromMatrix(r1)
            float r1 = r0.getPitch()
            float r2 = r0.getYaw()
            float r0 = r0.getRoll()
            int r3 = r14.mDeviceorientation
            r4 = 0
            boolean r5 = r14.isNearValueABS(r4, r1)
            r6 = 5
            r7 = 3
            r8 = 2
            r9 = 4
            r10 = 1
            if (r5 == 0) goto L33
            boolean r5 = r14.isNearValueABS(r4, r0)
            if (r5 == 0) goto L33
            r3 = r10
            goto L7c
        L33:
            r5 = -1028390912(0xffffffffc2b40000, float:-90.0)
            boolean r11 = r14.isNearValue(r5, r1)
            r12 = 1127481344(0x43340000, float:180.0)
            if (r11 == 0) goto L43
            boolean r11 = r14.isNearValueABS(r12, r0)
            if (r11 != 0) goto L4f
        L43:
            boolean r11 = r14.isNearValue(r5, r1)
            if (r11 == 0) goto L51
            boolean r11 = r14.isNearValueABS(r4, r0)
            if (r11 == 0) goto L51
        L4f:
            r3 = r9
            goto L7c
        L51:
            r11 = 1119092736(0x42b40000, float:90.0)
            boolean r13 = r14.isNearValue(r11, r1)
            if (r13 == 0) goto L61
            boolean r12 = r14.isNearValueABS(r12, r0)
            if (r12 == 0) goto L61
            r3 = r6
            goto L7c
        L61:
            boolean r12 = r14.isNearValue(r4, r1)
            if (r12 == 0) goto L6f
            boolean r5 = r14.isNearValue(r5, r0)
            if (r5 == 0) goto L6f
            r3 = r7
            goto L7c
        L6f:
            boolean r1 = r14.isNearValue(r4, r1)
            if (r1 == 0) goto L7c
            boolean r1 = r14.isNearValue(r11, r0)
            if (r1 == 0) goto L7c
            r3 = r8
        L7c:
            int r1 = r14.mDeviceorientation
            if (r1 == r3) goto L98
            r14.mDeviceorientation = r3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "mdevice orientation "
            r1.<init>(r3)
            int r3 = r14.mDeviceorientation
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "KwaiOrientationHelper"
            android.util.Log.d(r3, r1)
        L98:
            int r1 = (int) r2
            int r2 = r14.mDeviceorientation
            if (r2 == r10) goto Lbc
            if (r2 == r8) goto Lbc
            if (r2 == r7) goto Lbc
            if (r2 == r9) goto Lb0
            if (r2 == r6) goto La6
            goto Lc2
        La6:
            boolean r0 = r14.isNearValue(r4, r0)
            if (r0 == 0) goto Lad
            goto Lb9
        Lad:
            if (r1 <= 0) goto Lc1
            goto Lbe
        Lb0:
            boolean r0 = r14.isNearValue(r4, r0)
            if (r0 == 0) goto Lb9
            if (r1 <= 0) goto Lc1
            goto Lbe
        Lb9:
            int r1 = 180 - r1
            goto Lc2
        Lbc:
            if (r1 <= 0) goto Lc1
        Lbe:
            int r1 = 360 - r1
            goto Lc2
        Lc1:
            int r1 = -r1
        Lc2:
            int r1 = r1 % 360
            r14.mDegrees = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.player.vr.KwaiOrientationHelper.calDegrees():void");
    }

    public int getOrientaionDegrees() {
        return this.mDegrees;
    }

    public float[] getOrientation() {
        return this.mOrientation;
    }
}
