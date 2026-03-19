package com.ss.texturerender.effect;

import com.ss.texturerender.SharpenBaseWrapper;
import com.ss.texturerender.TextureRenderHelper;
import com.ss.texturerender.TextureRenderLog;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BMFAdaptiveSharpenWrapper extends SharpenBaseWrapper {
    private static final String LOG_TAG = "TR_BMFAdaptiveSharpenWrapper";
    private static final String VIDEO_SHARPEN_CLASS_NAME = "com.bytedance.bmf_mods.Sharp";
    private Method mGetOutputMethod;
    private Method mInitMethod;
    private Method mProcessMethod;
    private Method mProcessOESMethod;
    private Method mReleaseMethod;
    private Object mSharpenObject;
    private int mTexType;

    public BMFAdaptiveSharpenWrapper(int i) {
        this.mSharpenObject = null;
        this.mInitMethod = null;
        this.mProcessMethod = null;
        this.mProcessOESMethod = null;
        this.mGetOutputMethod = null;
        this.mReleaseMethod = null;
        this.mTexType = i;
        TextureRenderLog.i(i, LOG_TAG, "new BMFAdaptiveSharpenWrapper");
        try {
            Class<?> clzUsingPluginLoader = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_SHARPEN_CLASS_NAME);
            if (clzUsingPluginLoader != null) {
                this.mInitMethod = clzUsingPluginLoader.getDeclaredMethod("Init", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, Float.TYPE, Float.TYPE, Float.TYPE, Boolean.TYPE, Float.TYPE, Float.TYPE);
                this.mProcessMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessTexture", Integer.TYPE, Integer.TYPE, Integer.TYPE);
                this.mProcessOESMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessOesTexture", Integer.TYPE, Integer.TYPE, Integer.TYPE, float[].class, float[].class, float[].class);
                this.mGetOutputMethod = clzUsingPluginLoader.getDeclaredMethod("GetResult", new Class[0]);
                this.mReleaseMethod = clzUsingPluginLoader.getDeclaredMethod("Free", new Class[0]);
                this.mSharpenObject = clzUsingPluginLoader.newInstance();
            }
        } catch (Exception e) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "AdaptiveSharpen get fail:" + e.toString());
            this.mSharpenObject = null;
            this.mInitMethod = null;
            this.mProcessMethod = null;
            this.mGetOutputMethod = null;
            this.mReleaseMethod = null;
        }
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int InitAdaptiveSharpen(int i, int i2, int i3, int i4, String str, float f, float f2, float f3, boolean z, float f4, float f5) {
        Object obj_invokeMethod = _invokeMethod(this.mInitMethod, this.mSharpenObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), Float.valueOf(f4), Float.valueOf(f5));
        if (obj_invokeMethod == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenProcess(int i, int i2, int i3) {
        Method method;
        Object obj_invokeMethod;
        Object obj = this.mSharpenObject;
        if (obj == null || (method = this.mProcessMethod) == null || (obj_invokeMethod = _invokeMethod(method, obj, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))) == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenOesProcess(int i, int i2, int i3, float[] fArr, float[] fArr2, float[] fArr3) {
        Method method;
        Object obj_invokeMethod;
        Object obj = this.mSharpenObject;
        if (obj == null || (method = this.mProcessOESMethod) == null || (obj_invokeMethod = _invokeMethod(method, obj, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fArr, fArr2, fArr3)) == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int GetAdaptiveSharpenOutput() {
        Method method;
        Object obj_invokeMethod;
        Object obj = this.mSharpenObject;
        if (obj == null || (method = this.mGetOutputMethod) == null || (obj_invokeMethod = _invokeMethod(method, obj, new Object[0])) == null) {
            return -1;
        }
        return ((Integer) obj_invokeMethod).intValue();
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public void ReleaseAdaptiveSharpen() {
        Method method;
        Object obj = this.mSharpenObject;
        if (obj != null && (method = this.mReleaseMethod) != null) {
            _invokeMethod(method, obj, new Object[0]);
            TextureRenderLog.i(this.mTexType, LOG_TAG, "ReleaseAdaptiveSharpen");
        }
        this.mSharpenObject = null;
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
