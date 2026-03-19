package com.ss.texturerender.effect.vr.director.picodirector;

import com.ss.texturerender.math.Quaternion;
import com.ss.texturerender.math.Vector3d;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PicoQuaternion {
    private static Vector3d mCameraForward;
    private static float mFieldView;
    private static ArrayList<Integer> mSubIndexArray = new ArrayList<>();
    private static Quaternion mVRQuaternion;

    public static void updateVRQuaternion(float f, float f2, float f3, float f4, int i) {
        mVRQuaternion = new Quaternion(f, f2, i == 1 ? f3 : -f3, f4);
    }

    public static void updateVRCameraForaward(float f, float f2, float f3, float f4) {
        mCameraForward = new Vector3d(f, f2, f3);
        mFieldView = f4;
    }

    public static void updateVRSubIndex(int[] iArr, int i) {
        mSubIndexArray.clear();
        for (int i2 = 0; i2 < i; i2++) {
            mSubIndexArray.add(Integer.valueOf(iArr[i2]));
        }
    }

    public static Quaternion getVRQuaternion() {
        return mVRQuaternion;
    }

    public static Vector3d getCameraForward() {
        return mCameraForward;
    }

    public static float getFieldView() {
        return mFieldView;
    }

    public static ArrayList<Integer> getSubIndexArray() {
        return mSubIndexArray;
    }
}
