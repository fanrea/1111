package com.ss.texturerender;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.ImageReader;
import android.opengl.EGLContext;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.Surface;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.effect.PicoTextureObj;
import com.ss.texturerender.effect.vr.director.picodirector.PicoQuaternion;
import com.ss.texturerender.math.Quaternion;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VideoSurface extends Surface implements VideoSurfaceTexture.TextureDrawCallback, VideoSurfaceTexture.TextureErrorCallback, Handler.Callback {
    public static final int ERROR_SR_EXE_FAIL = 2;
    public static final int ERROR_SR_INIT_FAIL = 1;
    private static final int MSG_EFFECT_ERROR = 4097;
    private static final int MSG_HEADPOSE_UPDATE = 4098;
    private static final int MSG_TEXTURE_UPDATE = 4096;
    public static final int OPERATE_ADD = 1;
    public static final int OPERATE_RELEASE = 2;
    public static final int OPERATE_RELEASE_ALL = 3;
    public static final int SUPER_RES_CLOSE = 0;
    public static final int SUPER_RES_NN_ALG = 2;
    public static final int SUPER_RES_OPEN = 1;
    public static final int SUPER_RES_STAT_1_5 = 4;
    public static final int SUPER_RES_STAT_ALG_R = 0;
    public static final int SUPER_RES_STAT_ALG_V = 1;
    public static final int SUPER_RES_STAT_BMF_BACKEND_AUTO = 0;
    public static final int SUPER_RES_STAT_BMF_BACKEND_CPU = 1;
    public static final int SUPER_RES_STAT_BMF_BACKEND_DSP = 4;
    public static final int SUPER_RES_STAT_BMF_BACKEND_OPENCL = 2;
    public static final int SUPER_RES_STAT_BMF_BACKEND_OPENGL = 3;
    public static final int SUPER_RES_STAT_BMF_SRV1 = 8;
    public static final int SUPER_RES_STAT_BMF_SRV1_COMPOUND_OPT = 13;
    public static final int SUPER_RES_STAT_BMF_SRV1_COMPOUND_YUV = 12;
    public static final int SUPER_RES_STAT_BMF_SRV1_OPT = 10;
    public static final int SUPER_RES_STAT_BMF_SRV1_OPT_YUV = 11;
    public static final int SUPER_RES_STAT_BMF_SRV2 = 9;
    public static final int SUPER_RES_STAT_BMF_SRV3_4_OPT_OES = 17;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V4_1 = 18;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V6_1 = 19;

    @Deprecated
    public static final int SUPER_RES_STAT_BMF_V1 = 5;

    @Deprecated
    public static final int SUPER_RES_STAT_BMF_V1_OPT = 7;

    @Deprecated
    public static final int SUPER_RES_STAT_BMF_V2 = 6;
    public static final int SUPER_SCALE_TYPE_1_1 = 4;
    public static final int SUPER_SCALE_TYPE_1_2 = 8;
    public static final int SUPER_SCALE_TYPE_1_3 = 16;
    public static final int SUPER_SCALE_TYPE_1_4 = 32;
    public static final int SUPER_SCALE_TYPE_1_5 = 1;
    public static final int SUPER_SCALE_TYPE_2_0 = 0;
    public static final int SUPER_SCALE_TYPE_2_0_NEW = 2;
    private static final String TAG = "VideoSurface";
    private RenderCheckDispatcher mCheckDispatcher;
    private OnDrawFrameListener mDrawFrameListener;
    private boolean mEnableNoRenderCheck;
    private ArrayList<OnErrorListenerExt> mErrorListenerExts;

    @Deprecated
    private ArrayList<OnErrorListener> mErrorListeners;
    private OnExtraSurfaceDrawListener mExtraSurfaceDrawFrameListener;
    private Object mHandlerObject;
    private OnHeadposeChangedListener mHeadposeChangedListener;
    private Bundle mMsgObjectBundle;
    private Handler mNotifyHandler;
    private OnSetSurfaceListener mOnSetSurfaceListener;
    private float mQuatW;
    private float mQuatX;
    private float mQuatY;
    private float mQuatZ;
    private FrameRenderChecker mRenderChecker;
    private int mRenderDevice;
    protected int mSurfaceHeight;
    private VideoSurfaceTexture mSurfaceTexture;
    private VideoSurfaceTexturePicoInterface mSurfaceTexturePicoListener;
    protected int mSurfaceWidth;
    private int mTexType;

    public interface FrameRenderCallback extends Serializable {
        int onBytebufferCallbck(int i, ByteBuffer byteBuffer, int i2, int i3, long j);

        int onTextureCallback(int i, int i2, int i3, EGLContext eGLContext, int i4, int i5, long j);
    }

    public interface OnDrawFrameListener {
        void onDraw(long j);
    }

    @Deprecated
    public interface OnErrorListener {
        void onError(int i);
    }

    public interface OnExtraSurfaceDrawListener {
        void onExtraSurfaceDraw(Surface surface, long j);
    }

    public interface OnHeadposeChangedListener {
        void onHeadposeChanged(Quaternion quaternion);
    }

    public interface OnNoRenderListener {
        void onNoRenderEnd(int i);

        void onNoRenderStart(int i);
    }

    public interface OnSetSurfaceListener {
        int onSetSurface(VideoSurface videoSurface, Surface surface);
    }

    public interface SaveFrameCallback extends Serializable {
        int onFrame(ByteBuffer byteBuffer, int i, int i2);
    }

    public interface VQScoreCallback extends Serializable {
        int onProcessScore(float f, long j, long j2);
    }

    @Override // com.ss.texturerender.VideoSurfaceTexture.TextureErrorCallback
    public void onTextureRenderError(int i, int i2, String str) {
        ArrayList<OnErrorListenerExt> arrayList;
        ArrayList<OnErrorListener> arrayList2 = this.mErrorListeners;
        if ((arrayList2 == null || arrayList2.isEmpty()) && ((arrayList = this.mErrorListenerExts) == null || arrayList.isEmpty())) {
            return;
        }
        synchronized (this.mHandlerObject) {
            this.mNotifyHandler.obtainMessage(4097, i, i2, str).sendToTarget();
        }
    }

    public void setFrameRenderChecker(RenderCheckDispatcher renderCheckDispatcher) {
        if (renderCheckDispatcher != null) {
            renderCheckDispatcher.setEnabled(this.mEnableNoRenderCheck);
        }
        this.mCheckDispatcher = renderCheckDispatcher;
        this.mRenderChecker.setCheckDispatcher(renderCheckDispatcher);
    }

    public void setOnDrawFrameListener(OnDrawFrameListener onDrawFrameListener) {
        this.mDrawFrameListener = onDrawFrameListener;
    }

    public void setOnExtraSurfaceDrawListener(OnExtraSurfaceDrawListener onExtraSurfaceDrawListener) {
        this.mExtraSurfaceDrawFrameListener = onExtraSurfaceDrawListener;
    }

    public void setOnHeadposeChangedListener(OnHeadposeChangedListener onHeadposeChangedListener) {
        this.mHeadposeChangedListener = onHeadposeChangedListener;
    }

    public void setNoRenderListener(OnNoRenderListener onNoRenderListener) {
        this.mRenderChecker.setListener(onNoRenderListener);
    }

    public static class OnErrorListenerExt {
        public void onError(int i, int i2, String str) {
            TextureRenderLog.i(-1, VideoSurface.TAG, "OnErrorListenerExt (default impl) onError reason=" + i + " type=" + i2 + " msg=" + str);
        }
    }

    @Deprecated
    public void setOnErrorListener(OnErrorListener onErrorListener) {
        if (this.mErrorListeners == null) {
            this.mErrorListeners = new ArrayList<>();
        }
        if (this.mErrorListeners.contains(onErrorListener)) {
            return;
        }
        this.mErrorListeners.add(onErrorListener);
    }

    public void setOnErrorListenerExt(OnErrorListenerExt onErrorListenerExt) {
        if (this.mErrorListenerExts == null) {
            this.mErrorListenerExts = new ArrayList<>();
        }
        if (this.mErrorListenerExts.contains(onErrorListenerExt)) {
            return;
        }
        this.mErrorListenerExts.add(onErrorListenerExt);
    }

    public void setOnSetSurfaceListener(OnSetSurfaceListener onSetSurfaceListener) {
        this.mOnSetSurfaceListener = onSetSurfaceListener;
    }

    @Override // com.ss.texturerender.VideoSurfaceTexture.TextureDrawCallback
    public void onTextureUpdate(int i, long j) {
        if (this.mDrawFrameListener == null) {
            return;
        }
        synchronized (this.mHandlerObject) {
            Message messageObtainMessage = this.mNotifyHandler.obtainMessage(4096);
            this.mMsgObjectBundle.putLong(VideoSurfaceTexture.KEY_TIME, j);
            messageObtainMessage.arg1 = i;
            messageObtainMessage.setData(this.mMsgObjectBundle);
            messageObtainMessage.sendToTarget();
        }
    }

    @Override // com.ss.texturerender.VideoSurfaceTexture.TextureDrawCallback
    public void onTextureUpdate(int i, float f, float f2, float f3, float f4) {
        if (this.mDrawFrameListener == null) {
            return;
        }
        synchronized (this.mHandlerObject) {
            Message messageObtainMessage = this.mNotifyHandler.obtainMessage(4096);
            this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_X, f);
            this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_Y, f2);
            this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_Z, f3);
            this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_W, f4);
            messageObtainMessage.arg1 = i;
            messageObtainMessage.setData(this.mMsgObjectBundle);
            messageObtainMessage.sendToTarget();
        }
    }

    @Override // com.ss.texturerender.VideoSurfaceTexture.TextureDrawCallback
    public void onTextureUpdate(int i, Surface surface, long j) {
        if (this.mDrawFrameListener == null) {
            return;
        }
        synchronized (this.mHandlerObject) {
            Message messageObtainMessage = this.mNotifyHandler.obtainMessage(4096);
            Bundle bundle = new Bundle();
            bundle.putLong(VideoSurfaceTexture.KEY_TIME, j);
            bundle.putParcelable(VideoSurfaceTexture.KEY_SURFACE, surface);
            messageObtainMessage.arg1 = i;
            messageObtainMessage.setData(bundle);
            messageObtainMessage.sendToTarget();
        }
    }

    public void onHeadposeChanged(int i, float f, float f2, float f3, float f4) {
        if (this.mHeadposeChangedListener == null) {
            return;
        }
        synchronized (this.mHandlerObject) {
            Message messageObtainMessage = this.mNotifyHandler.obtainMessage(4098);
            this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_X, f);
            this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_Y, f2);
            this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_Z, f3);
            this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_W, f4);
            messageObtainMessage.arg1 = i;
            messageObtainMessage.setData(this.mMsgObjectBundle);
            messageObtainMessage.sendToTarget();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 4096:
                if (this.mDrawFrameListener != null && this.mSurfaceTexture != null) {
                    int i = message.arg1;
                    int serial = this.mSurfaceTexture.getSerial();
                    if (i != serial) {
                        TextureRenderLog.i(this.mTexType, TAG, "serial change :" + i + ", " + serial);
                        break;
                    } else {
                        Bundle data = message.getData();
                        long j = data.getLong(VideoSurfaceTexture.KEY_TIME);
                        if (data.getParcelable(VideoSurfaceTexture.KEY_SURFACE) == null) {
                            this.mQuatX = data.getFloat(VideoSurfaceTexture.KEY_QUATERNION_X);
                            this.mQuatY = data.getFloat(VideoSurfaceTexture.KEY_QUATERNION_Y);
                            this.mQuatZ = data.getFloat(VideoSurfaceTexture.KEY_QUATERNION_Z);
                            this.mQuatW = data.getFloat(VideoSurfaceTexture.KEY_QUATERNION_W);
                            OnDrawFrameListener onDrawFrameListener = this.mDrawFrameListener;
                            if (onDrawFrameListener != null) {
                                onDrawFrameListener.onDraw(j);
                                break;
                            }
                        } else {
                            Surface surface = (Surface) data.getParcelable(VideoSurfaceTexture.KEY_SURFACE);
                            OnExtraSurfaceDrawListener onExtraSurfaceDrawListener = this.mExtraSurfaceDrawFrameListener;
                            if (onExtraSurfaceDrawListener != null) {
                                onExtraSurfaceDrawListener.onExtraSurfaceDraw(surface, j);
                                break;
                            }
                        }
                    }
                }
                break;
            case 4097:
                if (this.mSurfaceTexture != null) {
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    String string = message.obj.toString();
                    ArrayList<OnErrorListener> arrayList = this.mErrorListeners;
                    if (arrayList != null) {
                        Iterator<OnErrorListener> it = arrayList.iterator();
                        while (it.hasNext()) {
                            it.next().onError(i2);
                        }
                    }
                    ArrayList<OnErrorListenerExt> arrayList2 = this.mErrorListenerExts;
                    if (arrayList2 != null) {
                        Iterator<OnErrorListenerExt> it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            it2.next().onError(i2, i3, string);
                        }
                        break;
                    }
                }
                break;
            case 4098:
                if (this.mHeadposeChangedListener != null && this.mSurfaceTexture != null) {
                    Bundle data2 = message.getData();
                    this.mQuatX = data2.getFloat(VideoSurfaceTexture.KEY_QUATERNION_X);
                    this.mQuatY = data2.getFloat(VideoSurfaceTexture.KEY_QUATERNION_Y);
                    this.mQuatZ = data2.getFloat(VideoSurfaceTexture.KEY_QUATERNION_Z);
                    this.mQuatW = data2.getFloat(VideoSurfaceTexture.KEY_QUATERNION_W);
                    OnHeadposeChangedListener onHeadposeChangedListener = this.mHeadposeChangedListener;
                    if (onHeadposeChangedListener != null) {
                        onHeadposeChangedListener.onHeadposeChanged(new Quaternion(this.mQuatX, this.mQuatY, this.mQuatZ, this.mQuatW));
                        break;
                    }
                }
                break;
        }
        return true;
    }

    public VideoSurface(VideoSurfaceTexture videoSurfaceTexture) {
        super(videoSurfaceTexture);
        this.mSurfaceTexturePicoListener = null;
        this.mErrorListeners = null;
        this.mErrorListenerExts = null;
        this.mTexType = -1;
        this.mQuatX = 0.0f;
        this.mQuatY = 0.0f;
        this.mQuatZ = 0.0f;
        this.mQuatW = 1.0f;
        this.mRenderDevice = -1;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        init(videoSurfaceTexture, false);
    }

    public VideoSurface(VideoSurfaceTexture videoSurfaceTexture, boolean z) {
        super(videoSurfaceTexture);
        this.mSurfaceTexturePicoListener = null;
        this.mErrorListeners = null;
        this.mErrorListenerExts = null;
        this.mTexType = -1;
        this.mQuatX = 0.0f;
        this.mQuatY = 0.0f;
        this.mQuatZ = 0.0f;
        this.mQuatW = 1.0f;
        this.mRenderDevice = -1;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        init(videoSurfaceTexture, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(VideoSurfaceTexture videoSurfaceTexture, boolean z) {
        this.mSurfaceTexture = videoSurfaceTexture;
        if (z) {
            this.mSurfaceTexturePicoListener = (VideoSurfaceTexturePicoInterface) videoSurfaceTexture;
        }
        if (videoSurfaceTexture != 0) {
            this.mTexType = videoSurfaceTexture.texType();
        }
        if (Looper.myLooper() != null) {
            this.mNotifyHandler = new Handler(this);
        } else {
            this.mNotifyHandler = new Handler(Looper.getMainLooper(), this);
        }
        this.mHandlerObject = new Object();
        this.mMsgObjectBundle = new Bundle();
        this.mRenderChecker = new FrameRenderChecker(this.mCheckDispatcher, videoSurfaceTexture);
    }

    public void setLooper(Looper looper) {
        if (looper != null) {
            this.mNotifyHandler = new Handler(looper, this);
        }
    }

    private synchronized void releaseTexture() {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.releaseOffScreenSurface(false);
            this.mSurfaceTexture = null;
        }
    }

    @Override // android.view.Surface
    protected void finalize() throws Throwable {
        releaseTexture();
        super.finalize();
    }

    @Override // android.view.Surface
    public void release() {
        TextureRenderLog.i(this.mTexType, TAG, this + "release");
        super.release();
        this.mRenderChecker.stop();
        releaseTexture();
        synchronized (this.mHandlerObject) {
            this.mDrawFrameListener = null;
            this.mNotifyHandler = null;
            ArrayList<OnErrorListener> arrayList = this.mErrorListeners;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<OnErrorListenerExt> arrayList2 = this.mErrorListenerExts;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
    }

    public void setDefaultSize(int i, int i2) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.setDefaultBufferSize(i, i2);
        }
    }

    public void pause(boolean z) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.pause(z, true);
        }
    }

    public void updateRenderSurface(Surface surface) {
        VideoSurfaceTexture videoSurfaceTexture;
        OnSetSurfaceListener onSetSurfaceListener = this.mOnSetSurfaceListener;
        if ((onSetSurfaceListener == null || onSetSurfaceListener.onSetSurface(this, surface) <= 0) && (videoSurfaceTexture = this.mSurfaceTexture) != null) {
            videoSurfaceTexture.updateSurface(surface);
        }
    }

    public Surface getRenderSurface() {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            return videoSurfaceTexture.getRenderSurface();
        }
        return null;
    }

    public Object getOption(Bundle bundle) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            return videoSurfaceTexture.getOption(bundle);
        }
        return null;
    }

    public void setExtraRenderSurface(Surface surface, int i) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.setExtraSurface(surface, i);
        }
    }

    public void preRender() {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.preRender();
        }
    }

    public void setSuperResolutionInitConfig(int i, String str, String str2, String str3) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.setSuperResolutionConfig(i, str, str2, str3, 0, 0, null);
        }
    }

    public void setSuperResolutionInitConfig(int i, String str, String str2, String str3, int i2, int i3) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.setSuperResolutionConfig(i, str, str2, str3, i2, i3, null);
        }
    }

    public void setSuperResolutionInitConfig(int i, String str, String str2, String str3, int i2, int i3, String str4) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.setSuperResolutionConfig(i, str, str2, str3, i2, i3, str4);
        }
    }

    public void setSuperResolutionMode(int i) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.setSuperResolutionMode(i);
        }
    }

    public void updateTexDimension(int i, int i2) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.updateTexDimension(i, i2);
        }
    }

    public boolean supportProcessResolution(int i, int i2) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture == null) {
            return false;
        }
        return videoSurfaceTexture.supportProcessResolution(i, i2);
    }

    public void ignoreSRResolutionCheck(boolean z) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.ignoreSRResolutionCheck(z);
        }
    }

    public void setEffect(Bundle bundle) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.setEffect(bundle);
        }
    }

    public void updateVRQuaternion(float f, float f2, float f3, float f4, int i) {
        PicoQuaternion.updateVRQuaternion(f, f2, f3, f4, i);
    }

    public void updateVRQuaternion(float f, float f2, float f3, float f4) {
        PicoQuaternion.updateVRCameraForaward(f, f2, f3, f4);
    }

    public void updateVRQuaternion(float f, float f2, float f3, float f4, int i, int[] iArr, int i2) {
        PicoQuaternion.updateVRQuaternion(f, f2, f3, f4, i);
        PicoQuaternion.updateVRSubIndex(iArr, i2);
    }

    public Bitmap saveFrame() {
        return saveFrame(null, null);
    }

    public Bitmap saveFrame(Bundle bundle, SaveFrameCallback saveFrameCallback) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture == null) {
            return null;
        }
        return videoSurfaceTexture.saveFrame(bundle, saveFrameCallback);
    }

    public void frameMetaCallback(long j, long j2, Map<Integer, String> map) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.frameMetaCallback(j, j2, map);
        }
    }

    public void setIntOption(int i, int i2) {
        if (i == 1) {
            VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
            if (videoSurfaceTexture != null) {
                videoSurfaceTexture.updateVideoState(i2);
                return;
            }
            return;
        }
        if (i == 133) {
            if (this.mRenderDevice != 1) {
                this.mRenderDevice = i2;
                TextureRenderLog.i(this.mTexType, TAG, "render device:" + this.mRenderDevice);
                return;
            }
            return;
        }
        if (i == 33) {
            if (i2 == 1) {
                this.mRenderChecker.start();
                return;
            } else {
                this.mRenderChecker.stop();
                return;
            }
        }
        if (i == 34) {
            boolean z = i2 == 1;
            this.mEnableNoRenderCheck = z;
            RenderCheckDispatcher renderCheckDispatcher = this.mCheckDispatcher;
            if (renderCheckDispatcher != null) {
                renderCheckDispatcher.setEnabled(z);
                return;
            }
            return;
        }
        VideoSurfaceTexture videoSurfaceTexture2 = this.mSurfaceTexture;
        if (videoSurfaceTexture2 != null) {
            videoSurfaceTexture2.setOption(i, i2);
        }
    }

    public void setFloatOption(int i, float f) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.setOption(i, f);
        }
    }

    public void setObjectOption(int i, Object obj) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            videoSurfaceTexture.setOption(i, obj);
        }
    }

    public int getIntOption(int i) {
        if (i == 133) {
            return this.mRenderDevice;
        }
        return getIntOption(i, -1);
    }

    public int getIntOption(int i, int i2) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            return videoSurfaceTexture.getIntOption(i, i2);
        }
        return -1;
    }

    public String getStringOption(int i) {
        return getStringOption(i, -1);
    }

    public String getStringOption(int i, int i2) {
        if (i == 119) {
            return BuildConfig.VERSION_NAME;
        }
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        return videoSurfaceTexture != null ? videoSurfaceTexture.getStringOption(i, i2) : "";
    }

    public long getLongOption(int i) {
        return getLongOption(i, -1);
    }

    public long getLongOption(int i, int i2) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            return videoSurfaceTexture.getLongOption(i, i2);
        }
        return -1L;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            return videoSurfaceTexture.onTouchEvent(motionEvent);
        }
        return false;
    }

    public int drawImage(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || this.mSurfaceTexture == null) {
            TextureRenderLog.e(this.mTexType, TAG, "drawImage error");
            return -1;
        }
        if (Build.VERSION.SDK_INT < 15) {
            TextureRenderLog.e(this.mTexType, TAG, "error,SDK version too low:" + Build.VERSION.SDK_INT);
            return -1;
        }
        this.mSurfaceTexture.setDefaultBufferSize(bitmap.getWidth(), bitmap.getHeight());
        updateTexDimension(bitmap.getWidth(), bitmap.getHeight());
        Canvas canvasLockCanvas = lockCanvas(null);
        canvasLockCanvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        unlockCanvasAndPost(canvasLockCanvas);
        return 0;
    }

    public float getFloatOption(int i) {
        switch (i) {
            case 112:
                return this.mQuatX;
            case 113:
                return this.mQuatY;
            case 114:
                return this.mQuatZ;
            case 115:
                return this.mQuatW;
            default:
                return getFloatOption(i, -1);
        }
    }

    public float getFloatOption(int i, int i2) {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            return videoSurfaceTexture.getFloatOption(i, i2);
        }
        return 0.0f;
    }

    public int[] getFovResult() {
        VideoSurfaceTexturePicoInterface videoSurfaceTexturePicoInterface = this.mSurfaceTexturePicoListener;
        if (videoSurfaceTexturePicoInterface != null) {
            return videoSurfaceTexturePicoInterface.getFovResult();
        }
        return null;
    }

    public boolean isUpdateFrame() {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture != null) {
            return videoSurfaceTexture.isUpdateFrame();
        }
        return false;
    }

    public void updatePicoTextureObjMap(HashMap<Integer, PicoTextureObj> map) {
        VideoSurfaceTexturePicoInterface videoSurfaceTexturePicoInterface = this.mSurfaceTexturePicoListener;
        if (videoSurfaceTexturePicoInterface != null) {
            videoSurfaceTexturePicoInterface.updatePicoTextureObj(map);
        }
    }

    public void setIsPicoVRScene(boolean z) {
        VideoSurfaceTexturePicoInterface videoSurfaceTexturePicoInterface = this.mSurfaceTexturePicoListener;
        if (videoSurfaceTexturePicoInterface != null) {
            videoSurfaceTexturePicoInterface.setIsPicoVRScene(z);
        }
    }

    public VideoSurface getExtraVideoSurface() {
        VideoSurfaceTexture extraVideoSurfaceTexture;
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture == null || (extraVideoSurfaceTexture = videoSurfaceTexture.getExtraVideoSurfaceTexture()) == null) {
            return null;
        }
        return extraVideoSurfaceTexture.getOffScreenSurface();
    }

    public void setSurfaceDimensions(int i, int i2) {
        this.mSurfaceWidth = i;
        this.mSurfaceHeight = i2;
        TextureRenderLog.d(this.mTexType, TAG, "setSurfaceDimensions,W:" + i + ",H:" + i2);
    }

    public ImageReader.OnImageAvailableListener getFrameProducer() {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture == null) {
            return null;
        }
        return (ImageReader.OnImageAvailableListener) videoSurfaceTexture.getFrameProducer();
    }

    public Handler getRenderhandler() {
        VideoSurfaceTexture videoSurfaceTexture = this.mSurfaceTexture;
        if (videoSurfaceTexture == null) {
            return null;
        }
        return videoSurfaceTexture.getRenderHandler();
    }
}
