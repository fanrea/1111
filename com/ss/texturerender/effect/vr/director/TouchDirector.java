package com.ss.texturerender.effect.vr.director;

import android.opengl.Matrix;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TouchDirector extends GestureDetector.SimpleOnGestureListener implements IDirector {
    private Display mDisplay;
    private float mRadius;
    private float[] mRotationMatrix;
    private float mDiffX = 0.0f;
    private float mDiffY = 0.0f;
    private boolean mSensorEnabled = true;
    private DeviceOrientation mDeviceOrientation = DeviceOrientation.PORTRAIT;
    private DeviceOrientation mDeviceOriToScreenOri = DeviceOrientation.PORTRAIT;

    public enum DeviceOrientation {
        PORTRAIT,
        LANDSCAPE_LEFT,
        UPSIDE_DOWN,
        LANDSCAPE_RIGHT
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void setParam(Bundle bundle) {
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void stop() {
    }

    public TouchDirector(Display display) {
        this.mDisplay = display;
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void start() {
        float[] fArr = new float[16];
        this.mRotationMatrix = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void getView(float[] fArr, int i) {
        System.arraycopy(this.mRotationMatrix, 0, fArr, i, fArr.length - i);
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void reset() {
        this.mDiffX = 0.0f;
        this.mDiffY = 0.0f;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3 = this.mRadius;
        float f4 = (float) (((f / f3) / 3.141592653589793d) * 180.0d);
        float f5 = (float) (((f2 / f3) / 3.141592653589793d) * 180.0d);
        if (!this.mSensorEnabled) {
            this.mDiffX += f5;
            this.mDiffY += f4;
            return true;
        }
        int i = AnonymousClass1.$SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation[this.mDeviceOriToScreenOri.ordinal()];
        if (i == 1) {
            this.mDiffX += f5;
            this.mDiffY += f4;
        } else if (i == 2) {
            this.mDiffX += f4;
            this.mDiffY -= f5;
        } else if (i == 3) {
            this.mDiffX -= f5;
            this.mDiffY -= f4;
        } else if (i == 4) {
            this.mDiffX -= f4;
            this.mDiffY += f5;
        }
        return true;
    }

    /* renamed from: com.ss.texturerender.effect.vr.director.TouchDirector$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation;

        static {
            int[] iArr = new int[DeviceOrientation.values().length];
            $SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation = iArr;
            try {
                iArr[DeviceOrientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation[DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation[DeviceOrientation.UPSIDE_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation[DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public float getDiffX() {
        return this.mDiffX;
    }

    public float getDiffY() {
        return this.mDiffY;
    }

    public void updateDeviceOrientation(int i, boolean z) {
        this.mSensorEnabled = z;
        if ((i >= 315 && i < 360) || (i >= 0 && i < 45)) {
            this.mDeviceOrientation = DeviceOrientation.PORTRAIT;
        } else if (i >= 45 && i < 135) {
            this.mDeviceOrientation = DeviceOrientation.LANDSCAPE_RIGHT;
        } else if (i >= 135 && i < 225) {
            this.mDeviceOrientation = DeviceOrientation.UPSIDE_DOWN;
        } else if (i >= 225 && i < 315) {
            this.mDeviceOrientation = DeviceOrientation.LANDSCAPE_LEFT;
        }
        if (this.mDisplay != null) {
            int iOrdinal = this.mDeviceOrientation.ordinal() - this.mDisplay.getRotation();
            if (iOrdinal < 0) {
                iOrdinal += DeviceOrientation.values().length;
            }
            this.mDeviceOriToScreenOri = DeviceOrientation.values()[iOrdinal];
        }
    }
}
