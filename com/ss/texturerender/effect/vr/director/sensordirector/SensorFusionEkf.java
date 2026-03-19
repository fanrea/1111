package com.ss.texturerender.effect.vr.director.sensordirector;

import android.hardware.SensorEvent;
import android.view.MotionEvent;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.math.Matrix3x3d;
import com.ss.texturerender.math.Quaternion;
import com.ss.texturerender.math.Vector3d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SensorFusionEkf {
    private static final double DEFAULT_GYRO_TIME = 0.009999999776482582d;
    private static final double EPSILON = 1.0E-15d;
    private static final double INITIAL_STATE_COVARIANCE = 25.0d;
    private static final double KMinAccelNoiseSigma = 0.75d;
    private static final String LOG_TAG = "TR_SensorFusionEkf";
    private static final double MAX_ACC_NORM_CHANGE = 0.15d;
    private static final double NANO_TO_SEC = 9.999999717180685E-10d;
    private static final double kMaxAccelNoiseSigma = 7.0d;
    private Matrix3x3d mAccMeasureCovariance;
    private Matrix3x3d mAccMeasureJacobian;
    private double mAverageAccNormChange;
    private GyroBiasEstimator mBiasEstimator;
    private int mDisplayRotation;
    private Quaternion mEkfToHeadTracker;
    private Vector3d mGyroBias;
    private Vector3d mGyroSample;
    private TimeFilter mGyroTimeFilter;
    private Vector3d mInnovation;
    private Matrix3x3d mInnovationCovariance;
    private boolean mIsAlignedGravity;
    private Matrix3x3d mKalmanGain;
    private Quaternion mLastRotationFromStart;
    private double mPreviousAccNorm;
    private Matrix3x3d mProcessCovariance;
    private Quaternion mRotationFromStart;
    private int mSensorStartPos;
    private Vector3d mStartDirection;
    private Matrix3x3d mStateCovariance;
    private int mTexType;
    private long mGyroTimeStamp = -1;
    private double MAX_GYRO_DELAY = 0.03999999910593033d;
    private boolean mGyroEnableSmoother = false;
    private double mGyroSmoothFactor = 1.0d;
    private Quaternion mPreviousRotation = null;
    private long mAccTimeStamp = -1;
    private Vector3d mAccSample = new Vector3d();
    private boolean mIsDisableZrotation = false;
    private Vector3d mTestZrot = null;
    private double mRadius = 800.0d;

    public SensorFusionEkf(int i) {
        this.mTexType = i;
        reset();
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new SensorFusionEkf");
    }

    public void setSensorStartPos(int i) {
        this.mSensorStartPos = i;
    }

    public synchronized void processGyro(SensorEvent sensorEvent) {
        if (this.mGyroTimeStamp > sensorEvent.timestamp) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "lastTime > curTime, return");
            return;
        }
        if (this.mGyroTimeStamp > 0) {
            double filteredTime = (sensorEvent.timestamp - this.mGyroTimeStamp) * NANO_TO_SEC;
            if (this.mGyroTimeFilter == null) {
                this.mGyroTimeFilter = new TimeFilter();
            }
            if (filteredTime > this.MAX_GYRO_DELAY) {
                filteredTime = this.mGyroTimeFilter.isFilterValid() ? this.mGyroTimeFilter.getFilteredTime() : DEFAULT_GYRO_TIME;
            } else {
                this.mGyroTimeFilter.addSample(filteredTime);
            }
            this.mGyroSample.set(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
            this.mBiasEstimator.processGyroscope(this.mGyroSample, sensorEvent.timestamp);
            this.mBiasEstimator.getGyroBias(this.mGyroBias);
            if (this.mIsAlignedGravity) {
                Quaternion rotationFromGyro = getRotationFromGyro(this.mGyroSample.sub(this.mGyroBias), filteredTime);
                this.mRotationFromStart = rotationFromGyro.times(this.mRotationFromStart);
                updateStateCovariance(Matrix3x3d.rotationMatrix3x3(rotationFromGyro));
                this.mStateCovariance.plusEquals(this.mProcessCovariance.mult(filteredTime * filteredTime));
            }
        }
        this.mGyroTimeStamp = sensorEvent.timestamp;
    }

    public synchronized void processAcc(SensorEvent sensorEvent) {
        if (this.mAccTimeStamp > sensorEvent.timestamp) {
            return;
        }
        this.mAccSample.set(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
        long j = sensorEvent.timestamp;
        this.mAccTimeStamp = j;
        this.mBiasEstimator.processAccelerometer(this.mAccSample, j);
        if (!this.mIsAlignedGravity) {
            this.mIsAlignedGravity = true;
            if (this.mSensorStartPos == 2) {
                this.mStartDirection = new Vector3d(this.mAccSample);
            } else {
                int i = this.mDisplayRotation;
                if (i == 0) {
                    this.mStartDirection = new Vector3d(0.0d, 1.0d, 0.0d);
                } else if (i == 1) {
                    this.mStartDirection = new Vector3d(1.0d, 0.0d, 0.0d);
                } else if (i == 2) {
                    this.mStartDirection = new Vector3d(0.0d, -1.0d, 0.0d);
                } else if (i == 3) {
                    this.mStartDirection = new Vector3d(-1.0d, 0.0d, 0.0d);
                }
            }
            this.mRotationFromStart = Quaternion.rotateInto(this.mStartDirection, this.mAccSample);
            TextureRenderLog.i(this.mTexType, LOG_TAG, "rotation start:" + this.mRotationFromStart + ";acc:" + this.mAccSample.toString());
            this.mPreviousAccNorm = this.mAccSample.length();
            return;
        }
        updateMeasurementCovariance();
        this.mInnovation = computeInnovation(this.mRotationFromStart);
        computeMeasurementJacobian();
        Matrix3x3d matrix3x3dTranspose = this.mAccMeasureJacobian.transpose();
        Matrix3x3d.mult(this.mAccMeasureJacobian, this.mStateCovariance, this.mInnovationCovariance);
        Matrix3x3d matrix3x3d = this.mInnovationCovariance;
        Matrix3x3d.mult(matrix3x3d, matrix3x3dTranspose, matrix3x3d);
        Matrix3x3d matrix3x3d2 = this.mInnovationCovariance;
        Matrix3x3d.add(matrix3x3d2, this.mAccMeasureCovariance, matrix3x3d2);
        Matrix3x3d matrix3x3d3 = new Matrix3x3d();
        this.mInnovationCovariance.invert(matrix3x3d3);
        Matrix3x3d.mult(this.mStateCovariance, matrix3x3dTranspose, this.mKalmanGain);
        Matrix3x3d matrix3x3d4 = this.mKalmanGain;
        Matrix3x3d.mult(matrix3x3d4, matrix3x3d3, matrix3x3d4);
        Vector3d vector3d = new Vector3d();
        Matrix3x3d.mult(this.mKalmanGain, this.mInnovation, vector3d);
        Matrix3x3d matrix3x3d5 = new Matrix3x3d();
        Matrix3x3d.mult(this.mKalmanGain, this.mAccMeasureJacobian, matrix3x3d5);
        Matrix3x3d matrix3x3d6 = new Matrix3x3d();
        matrix3x3d6.setIdentity();
        matrix3x3d6.minusEquals(matrix3x3d5);
        Matrix3x3d matrix3x3d7 = this.mStateCovariance;
        Matrix3x3d.mult(matrix3x3d6, matrix3x3d7, matrix3x3d7);
        Quaternion quaternionRotationFromVector = rotationFromVector(vector3d);
        this.mRotationFromStart = quaternionRotationFromVector.times(this.mRotationFromStart);
        updateStateCovariance(Matrix3x3d.rotationMatrix3x3(quaternionRotationFromVector));
    }

    public boolean processScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.mRotationFromStart = Quaternion.rotateInto(new Vector3d(0.0d, 0.0d, -this.mRadius), new Vector3d(-f, f2, -this.mRadius)).times(this.mRotationFromStart);
        return true;
    }

    private Quaternion rotationFromVector(Vector3d vector3d) {
        double length = vector3d.length();
        if (length < EPSILON) {
            return new Quaternion();
        }
        vector3d.normalize();
        return Quaternion.fromAxisAndAngle(vector3d, length);
    }

    private Quaternion getRotationFromGyro(Vector3d vector3d, double d) {
        double length = vector3d.length();
        if (length < EPSILON) {
            return new Quaternion();
        }
        return Quaternion.fromAxisAndAngle(vector3d.devide(length), (-d) * length);
    }

    private void updateStateCovariance(Matrix3x3d matrix3x3d) {
        this.mStateCovariance = Matrix3x3d.mult(Matrix3x3d.mult(matrix3x3d, this.mStateCovariance), matrix3x3d.transpose());
    }

    private void updateMeasurementCovariance() {
        double length = this.mAccSample.length();
        double dAbs = Math.abs(length - this.mPreviousAccNorm);
        this.mPreviousAccNorm = length;
        double d = (this.mAverageAccNormChange + dAbs) / 2.0d;
        this.mAverageAccNormChange = d;
        double dMin = Math.min(kMaxAccelNoiseSigma, ((d / MAX_ACC_NORM_CHANGE) * 6.25d) + KMinAccelNoiseSigma);
        this.mAccMeasureCovariance.setIdentity();
        this.mAccMeasureCovariance.scale(dMin * dMin);
    }

    private Vector3d computeInnovation(Quaternion quaternion) {
        Quaternion quaternionRotateInto = Quaternion.rotateInto(Quaternion.applyToVector(this.mStartDirection, quaternion), this.mAccSample);
        Vector3d axis = quaternionRotateInto.getAxis();
        axis.scale(quaternionRotateInto.getAngle());
        return axis;
    }

    private void computeMeasurementJacobian() {
        Quaternion quaternionFromAxisAndAngle;
        for (int i = 0; i < 3; i++) {
            Vector3d vector3d = new Vector3d(0.0d, 0.0d, 0.0d);
            vector3d.setComponent(i, 1.0E-7d);
            double length = vector3d.length();
            if (length < EPSILON) {
                quaternionFromAxisAndAngle = new Quaternion();
            } else {
                vector3d.normalize();
                quaternionFromAxisAndAngle = Quaternion.fromAxisAndAngle(vector3d, length);
            }
            Vector3d.sub(this.mInnovation, computeInnovation(quaternionFromAxisAndAngle.times(this.mRotationFromStart)), vector3d);
            vector3d.devide(1.0E-7d);
            this.mAccMeasureJacobian.set(0, i, vector3d.x);
            this.mAccMeasureJacobian.set(1, i, vector3d.y);
            this.mAccMeasureJacobian.set(2, i, vector3d.z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ss.texturerender.math.Quaternion getRotation() {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.texturerender.effect.vr.director.sensordirector.SensorFusionEkf.getRotation():com.ss.texturerender.math.Quaternion");
    }

    public void reset() {
        this.mGyroTimeFilter = new TimeFilter();
        this.mBiasEstimator = new GyroBiasEstimator();
        this.mRotationFromStart = new Quaternion();
        Matrix3x3d matrix3x3d = new Matrix3x3d();
        this.mStateCovariance = matrix3x3d;
        matrix3x3d.setIdentity();
        this.mStateCovariance.scale(INITIAL_STATE_COVARIANCE);
        this.mGyroSample = new Vector3d();
        this.mGyroBias = new Vector3d();
        Matrix3x3d matrix3x3d2 = new Matrix3x3d();
        this.mProcessCovariance = matrix3x3d2;
        matrix3x3d2.setIdentity();
        this.mIsAlignedGravity = false;
        this.mAccMeasureCovariance = new Matrix3x3d();
        this.mAccMeasureJacobian = new Matrix3x3d();
        this.mKalmanGain = new Matrix3x3d();
        this.mInnovationCovariance = new Matrix3x3d();
        this.mEkfToHeadTracker = null;
        this.mDisplayRotation = 0;
        this.mPreviousRotation = null;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "ekf reset");
    }

    public boolean isAlignedGravity() {
        return this.mIsAlignedGravity;
    }

    public void setRotationFromStart(Quaternion quaternion) {
        this.mLastRotationFromStart = quaternion;
        this.mPreviousRotation = null;
    }

    public void setDisplayRotation(int i) {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "display rotation:" + i);
        if (this.mDisplayRotation != i) {
            this.mPreviousRotation = null;
        }
        this.mDisplayRotation = i;
    }

    public int getDisplayRotation() {
        return this.mDisplayRotation;
    }

    public void setIsDisableZrotation(boolean z) {
        this.mIsDisableZrotation = z;
    }

    public void setGyroSmootherParam(boolean z, double d) {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "enable smoother:" + z + ",factor:" + d);
        this.mGyroEnableSmoother = z;
        this.mGyroSmoothFactor = d;
    }

    private Quaternion slerp(Quaternion quaternion, Quaternion quaternion2, double d) {
        double x0 = quaternion.getX0();
        double x1 = quaternion.getX1();
        double x2 = quaternion.getX2();
        double x3 = quaternion.getX3();
        double x02 = quaternion2.getX0();
        double x12 = quaternion2.getX1();
        double x22 = quaternion2.getX2();
        double x32 = quaternion2.getX3();
        double d2 = (x3 * x32) + (x0 * x02) + (x1 * x12) + (x2 * x22);
        if (Math.abs(d2) >= 1.0d) {
            return new Quaternion(x0, x1, x2, x3);
        }
        double dAcos = Math.acos(d2);
        double dSqrt = Math.sqrt(1.0d - (d2 * d2));
        if (Math.abs(dSqrt) < 0.001d) {
            return new Quaternion((x0 * 0.5d) + (x02 * 0.5d), (x1 * 0.5d) + (x12 * 0.5d), (x2 * 0.5d) + (x22 * 0.5d), (x3 * 0.5d) + (x32 * 0.5d));
        }
        double dSin = Math.sin((1.0d - d) * dAcos) / dSqrt;
        double dSin2 = Math.sin(dAcos * d) / dSqrt;
        return new Quaternion((x0 * dSin) + (x02 * dSin2), (x1 * dSin) + (x12 * dSin2), (x2 * dSin) + (x22 * dSin2), (x3 * dSin) + (x32 * dSin2));
    }
}
