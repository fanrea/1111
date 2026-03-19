package com.ss.texturerender;

import android.os.Bundle;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VideoOCLSRWrapper extends VideoOCLSRBaseWrapper {
    private static final int HEIGHT_DEFAULT = 720;
    private static final String LOG_TAG = "VideoOCLSRWrapper";
    private static final String VIDEO_OCLSR_CLASS_NAME = "com.ss.lens.algorithm.VideoOCLSR";
    private static final int WIDTH_DEFAULT = 1440;
    private int mTexType;
    private Object mSRObject = null;
    private Method mInitMethod = null;
    private Method mInitMethodMax = null;
    private Method mInitMethodMaxMalisync = null;
    private Method mInitWithLicenseMethod = null;
    private Method mProcessOesMethod = null;
    private Method mProcessMethod = null;
    private Method mGetOutputMethod = null;
    private Method mReleaseMethod = null;

    public VideoOCLSRWrapper(int i) {
        this.mTexType = i;
        TextureRenderLog.i(i, LOG_TAG, "new VideoOCLSRWrapper");
        _initObjAndMethod();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean glSrInit(String str, int i, boolean z, int i2, int i3) {
        return InitVideoOclSr(str, i, z, i3, i2);
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String str, int i, boolean z, String str2, int i2, int i3, int i4, String str3, String str4) {
        if (this.mSRObject == null || this.mInitWithLicenseMethod == null) {
            _initObjAndMethod();
        }
        Object obj_invokeMethod = null;
        Object obj = this.mSRObject;
        if (obj != null) {
            if (this.mInitWithLicenseMethod != null) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "mInitWithLicenseMethod " + str2);
                obj_invokeMethod = _invokeMethod(this.mInitWithLicenseMethod, this.mSRObject, str, Integer.valueOf(i), Boolean.valueOf(z), true, str2, 720, Integer.valueOf(WIDTH_DEFAULT));
            } else {
                Method method = this.mInitMethod;
                if (method != null) {
                    obj_invokeMethod = _invokeMethod(method, obj, str, Integer.valueOf(i), Boolean.valueOf(z));
                }
            }
        }
        return obj_invokeMethod != null && ((Boolean) obj_invokeMethod).booleanValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String str, int i, boolean z, int i2, int i3) {
        if (this.mSRObject == null || this.mInitMethodMax == null) {
            _initObjAndMethod();
        }
        Object obj_invokeMethod = _invokeMethod(this.mInitMethodMax, this.mSRObject, str, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3));
        return obj_invokeMethod != null && ((Boolean) obj_invokeMethod).booleanValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String str, int i, boolean z, boolean z2, int i2, int i3, String str2, int i4, int i5, int i6, String str3, String str4) {
        if (this.mSRObject == null || this.mInitWithLicenseMethod == null) {
            _initObjAndMethod();
        }
        Object obj_invokeMethod = null;
        Object obj = this.mSRObject;
        if (obj != null) {
            if (this.mInitWithLicenseMethod != null) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "mInitWithLicenseMethod " + str2);
                obj_invokeMethod = _invokeMethod(this.mInitWithLicenseMethod, this.mSRObject, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str2, Integer.valueOf(i2), Integer.valueOf(i3));
            } else {
                Method method = this.mInitMethodMaxMalisync;
                if (method != null) {
                    obj_invokeMethod = _invokeMethod(method, obj, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3));
                } else if (this.mInitMethodMax != null) {
                    TextureRenderLog.i(this.mTexType, LOG_TAG, "mInitMethodMaxMalisync null, use mInitMethodMax");
                    obj_invokeMethod = _invokeMethod(this.mInitMethodMax, this.mSRObject, str, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3));
                } else if (this.mInitMethod != null) {
                    TextureRenderLog.i(this.mTexType, LOG_TAG, "mInitMethodMaxMalisync/mInitMethodMax null,use mInitMethod");
                    obj_invokeMethod = _invokeMethod(this.mInitMethod, this.mSRObject, str, Integer.valueOf(i), Boolean.valueOf(z));
                }
            }
        }
        return obj_invokeMethod != null && ((Boolean) obj_invokeMethod).booleanValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoAsyncOclSr(String str, int i, boolean z, boolean z2, int i2, int i3, String str2, int i4, int i5, int i6, String str3, String str4, Bundle bundle) {
        return InitVideoOclSr(str, i, z, i2, i3);
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int i, int i2, int i3, float[] fArr, boolean z, int i4, int i5, int i6, int i7, int i8, long j, int i9, int i10, Bundle bundle) {
        if (this.mSRObject == null || this.mProcessOesMethod == null) {
            _initObjAndMethod();
        }
        Object obj_invokeMethod = _invokeMethod(this.mProcessOesMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fArr, Boolean.valueOf(z));
        if (obj_invokeMethod != null) {
            TextureRenderLog.d(this.mTexType, LOG_TAG, "lensTextureProcess sucess");
        }
        if (obj_invokeMethod == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrProcess(int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, int i8, long j, int i9, int i10, Bundle bundle) {
        if (this.mSRObject == null || this.mProcessMethod == null) {
            _initObjAndMethod();
        }
        Object obj_invokeMethod = _invokeMethod(this.mProcessMethod, this.mSRObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
        if (obj_invokeMethod != null) {
            TextureRenderLog.d(this.mTexType, LOG_TAG, "lensTextureProcess sucess");
        }
        if (obj_invokeMethod == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int GetVideoOclSrOutput() {
        if (this.mSRObject == null || this.mGetOutputMethod == null) {
            _initObjAndMethod();
        }
        Object obj_invokeMethod = _invokeMethod(this.mGetOutputMethod, this.mSRObject, new Object[0]);
        if (obj_invokeMethod == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public void ReleaseVideoOclSr() {
        Method method;
        Object obj = this.mSRObject;
        if (obj != null && (method = this.mReleaseMethod) != null) {
            _invokeMethod(method, obj, new Object[0]);
            TextureRenderLog.i(this.mTexType, LOG_TAG, "ReleaseVideoOclSr");
        }
        this.mSRObject = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void _initObjAndMethod() {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.texturerender.VideoOCLSRWrapper._initObjAndMethod():void");
    }

    private Object _invokeMethod(Method method, Object obj, Object... objArr) {
        if (method == null || obj == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, e.toString());
            return null;
        }
    }
}
