package com.ss.ttm.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import com.alipay.sdk.m.u.b;
import com.baidu.mobads.sdk.internal.cm;
import com.bytedance.common.utility.DeviceUtils;
import com.component.feed.a;
import com.kwai.video.player.misc.IMediaFormat;
import com.pandora.common.Constants;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.Util;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class AJMediaCodec {
    private static final int AV_TRC_ARIB_STD_B67 = 18;
    private static final int AV_TRC_SMPTE2084 = 16;
    private static final int CODEC_ERROR = -10000;
    private static final int CODEC_EXCEPTION_ERROR = -10001;
    private static final int CODEC_ILLEGAL_ARGUMENT = -10003;
    private static final int CODEC_ILLEGAL_STATE = -10002;
    private static final int CODEC_TIME_OUT = 3000;
    private static final double FIX_VERSION = 0.18041d;
    private static final long INPUT_TIMEOUT_US = 30000;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int NO_VALUE = -1;
    private static final int PIXEL_FORMAT_NV12 = 3;
    private static final int PIXEL_FORMAT_YUV420P = 0;
    private static final String TAG = "JAJMediaCodec";
    private static final String VENDOR_OPPO_PROPERTY = "persist.sys.aweme.hdsupport";
    private static final String VERSION_PROPERTY = "ro.config.hw_codec_support";
    private static final Condition mSingleCodecCond;
    private static final ReentrantLock mSingleCodecLock;
    private Handler mAsyncHandler;
    private HandlerThread mAsyncThread;
    private MediaCodec.BufferInfo mBufferInfo;
    private DummySurface mDummySurface;
    private String mExceptionInfo;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private static final ArrayList<MediaCodecInfo> mVideoHWDecoderCodecs = new ArrayList<>();
    private static final ArrayList<MediaCodecInfo> mAudioHWDecoderCodecs = new ArrayList<>();
    private static final Object mCodecListLock = new Object();
    private static boolean mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mIsInitDetected = false;
    private static boolean mIsByteVC1Blocklist = false;
    private static boolean mNeedByteVC1WorkAround = false;
    private static int mIsByteVC1BlocklistEnable = 1;
    private static int mEnableMediaCodecSyncClose = 0;
    private static final Object mAsyncLock = new Object();
    private static int mCodecInstanceNums = 0;
    private boolean mInputBuffersValid = false;
    private android.media.MediaFormat mOutputMediaFormat = null;
    private final AJMediaFormat mAJMediaFormat = new AJMediaFormat();
    private int mMcMode = 0;
    private long mHandler = 0;
    private int mPendingFlushCount = 0;
    private boolean mCodecIsClosed = false;
    private MediaCodecInfo mCodecInfo = null;
    private String mCodecType = null;
    private int mSupportAdaptivePlayBack = -1;
    private int mFixedMemcpyCrash = 0;
    private int mEnableSingleCodec = 0;

    private static final native void _clearBufferIndex(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native void _onEmptyBuffer(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native void _onError(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native void _onFilledBuffer(long j, int i, int i2, int i3, long j2, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native void _onFormatChanged(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    private static final native void _setSurfaceCompleted(long j);

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        mSingleCodecLock = reentrantLock;
        mSingleCodecCond = reentrantLock.newCondition();
    }

    public boolean MTKByteVC1NeedWorkAround() {
        return mNeedByteVC1WorkAround;
    }

    public static String getProperty(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
                return str3;
            } catch (Exception e) {
                e.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public AJMediaCodec() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        boolean z = false;
        if (!mIsInitDetected) {
            if (Util.HARDWARE.toLowerCase(Locale.US).startsWith("mt") && Util.SDK_INT < 26) {
                z = true;
            }
            mNeedByteVC1WorkAround = z;
            if (isHisiByteVC1BlockList() || isMtkByteVC1BlockList()) {
                mIsByteVC1Blocklist = true;
            }
        }
        codecNeedsSetOutputSurfaceWorkaround();
        mIsInitDetected = true;
        AVLogger.InfoTrackLife(TAG, this, "JAJMediaCodec#^workaround:" + mDeviceNeedsSetOutputSurfaceWorkaround);
    }

    public void setHandler(long j) {
        AVLogger.Debug(TAG, this, "ttmn: setHandler " + j);
        this.mHandler = j;
    }

    public void setMode(int i, int i2) {
        AVLogger.Debug(TAG, this, "ttmn: mode " + i + ", memcpyCrash " + i2);
        this.mMcMode = i;
        this.mFixedMemcpyCrash = i2;
    }

    public void setSingleCodec(int i) {
        AVLogger.Debug(TAG, this, "ttmn: EnableSingleCodec " + i);
        this.mEnableSingleCodec = i;
    }

    public String getErrorInfo() {
        return this.mExceptionInfo;
    }

    private boolean isHisiByteVC1BlockList() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String property = getProperty("ro.board.platform", null);
        if (Util.SDK_INT != 26 || property == null) {
            return false;
        }
        if (!property.startsWith("kirin960") && !property.startsWith("hi3660")) {
            return false;
        }
        double d = 0.0d;
        try {
            d = Double.parseDouble(getProperty(VERSION_PROPERTY, cm.d));
        } catch (NumberFormatException unused) {
            AVLogger.Warn(TAG, this, "vendor property abnormal");
        }
        return d < FIX_VERSION;
    }

    private boolean supportSetSurface() {
        return !mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    private boolean isMtkByteVC1BlockList() {
        String lowerCase = Util.HARDWARE.toLowerCase(Locale.US);
        return lowerCase.startsWith("mt6763") || lowerCase.startsWith("mt6757") || lowerCase.startsWith("mt6739") || lowerCase.startsWith("mt6750");
    }

    public int vendorOppoHWEnable() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (Util.BARND.equals(DeviceUtils.ROM_OPPO)) {
            String property = getProperty(VENDOR_OPPO_PROPERTY, "1");
            AVLogger.Debug(TAG, this, "oppo property = " + property);
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
                AVLogger.Warn(TAG, this, "vendor oppo property abnormal");
            }
        }
        return 1;
    }

    public int createByCodecName(String str) {
        AVLogger.Debug(TAG, this, "createByCodecName = " + str);
        try {
            if (this.mEnableSingleCodec == 1) {
                try {
                    ReentrantLock reentrantLock = mSingleCodecLock;
                    reentrantLock.lock();
                    if (mCodecInstanceNums > 0) {
                        mSingleCodecCond.await(b.a, TimeUnit.MILLISECONDS);
                    }
                    if (mCodecInstanceNums > 0) {
                        AVLogger.Warn(TAG, this, "already create a media codec");
                        reentrantLock.unlock();
                        return -1;
                    }
                    this.mMediaCodec = MediaCodec.createByCodecName(str);
                    mCodecInstanceNums++;
                    reentrantLock.unlock();
                    return 0;
                } catch (Throwable th) {
                    mSingleCodecLock.unlock();
                    throw th;
                }
            }
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            AVLogger.Debug(TAG, this, "createByCodecName fail = " + e.toString());
            return -1;
        }
    }

    private static void maybeSetInteger(android.media.MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    private static void maybeSetCsdBuffers(android.media.MediaFormat mediaFormat, ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null) {
            return;
        }
        mediaFormat.setByteBuffer("csd-" + i, byteBuffer);
    }

    private void createDummySurface() {
        AVLogger.Debug(TAG, this, "create dummy surface");
        this.mDummySurface = DummySurface.newInstanceV17(false);
    }

    public int setCallback(int i) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        AVLogger.Debug(TAG, this, "ttmn: set callback func.");
        if (i == 0) {
            return 0;
        }
        try {
            MediaCodec.Callback callback = new MediaCodec.Callback() { // from class: com.ss.ttm.player.AJMediaCodec.1
                @Override // android.media.MediaCodec.Callback
                public void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
                    if (mediaCodec == AJMediaCodec.this.mMediaCodec) {
                        synchronized (AJMediaCodec.mAsyncLock) {
                            if (AJMediaCodec.this.mCodecIsClosed) {
                                return;
                            }
                            AJMediaCodec._onEmptyBuffer(AJMediaCodec.this.mHandler, i2);
                        }
                    }
                }

                @Override // android.media.MediaCodec.Callback
                public void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
                    if (mediaCodec == AJMediaCodec.this.mMediaCodec) {
                        synchronized (AJMediaCodec.mAsyncLock) {
                            if (AJMediaCodec.this.mCodecIsClosed) {
                                return;
                            }
                            AJMediaCodec._onFilledBuffer(AJMediaCodec.this.mHandler, i2, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
                        }
                    }
                }

                @Override // android.media.MediaCodec.Callback
                public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                    AVLogger.Error(AJMediaCodec.TAG, this, "ttmn: " + codecException);
                    synchronized (AJMediaCodec.mAsyncLock) {
                        if (AJMediaCodec.this.mCodecIsClosed) {
                            return;
                        }
                        AJMediaCodec._onError(AJMediaCodec.this.mHandler);
                    }
                }

                @Override // android.media.MediaCodec.Callback
                public void onOutputFormatChanged(MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) {
                    int i2;
                    int i3;
                    int integer;
                    int integer2;
                    AJMediaCodec.this.mOutputMediaFormat = mediaFormat;
                    if (mediaFormat != null) {
                        try {
                            String string = mediaFormat.getString(IMediaFormat.KEY_MIME);
                            if (string.startsWith("video")) {
                                boolean z = mediaFormat.containsKey(AJMediaCodec.KEY_CROP_RIGHT) && mediaFormat.containsKey(AJMediaCodec.KEY_CROP_LEFT) && mediaFormat.containsKey(AJMediaCodec.KEY_CROP_BOTTOM) && mediaFormat.containsKey(AJMediaCodec.KEY_CROP_TOP);
                                AJMediaFormat aJMediaFormat = AJMediaCodec.this.mAJMediaFormat;
                                if (z) {
                                    integer = (mediaFormat.getInteger(AJMediaCodec.KEY_CROP_RIGHT) - mediaFormat.getInteger(AJMediaCodec.KEY_CROP_LEFT)) + 1;
                                } else {
                                    integer = mediaFormat.getInteger("width");
                                }
                                aJMediaFormat.width = integer;
                                AJMediaFormat aJMediaFormat2 = AJMediaCodec.this.mAJMediaFormat;
                                if (z) {
                                    integer2 = (mediaFormat.getInteger(AJMediaCodec.KEY_CROP_BOTTOM) - mediaFormat.getInteger(AJMediaCodec.KEY_CROP_TOP)) + 1;
                                } else {
                                    integer2 = mediaFormat.getInteger("height");
                                }
                                aJMediaFormat2.height = integer2;
                                int integer3 = mediaFormat.containsKey("color-format") ? mediaFormat.getInteger("color-format") : 0;
                                if (integer3 == 21 || integer3 == 2130706688 || integer3 == 2141391872) {
                                    AJMediaCodec.this.mAJMediaFormat.colorFormat = 3;
                                } else {
                                    AJMediaCodec.this.mAJMediaFormat.colorFormat = 0;
                                }
                                int integer4 = mediaFormat.containsKey("color-transfer") ? mediaFormat.getInteger("color-transfer") : 0;
                                if (integer4 == 6) {
                                    i3 = 0;
                                    AJMediaCodec.this.mAJMediaFormat.colorTrans = 16;
                                } else if (integer4 != 7) {
                                    i3 = 0;
                                    AJMediaCodec.this.mAJMediaFormat.colorTrans = 0;
                                } else {
                                    i3 = 0;
                                    AJMediaCodec.this.mAJMediaFormat.colorTrans = 18;
                                }
                                AJMediaCodec.this.mAJMediaFormat.sliceHeight = mediaFormat.containsKey("slice-height") ? mediaFormat.getInteger("slice-height") : i3;
                                AJMediaCodec.this.mAJMediaFormat.stride = mediaFormat.containsKey("stride") ? mediaFormat.getInteger("stride") : i3;
                            } else {
                                i3 = 0;
                            }
                            if (string.startsWith("audio")) {
                                AJMediaCodec.this.mAJMediaFormat.sampleRate = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : i3;
                                AJMediaCodec.this.mAJMediaFormat.channelCount = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : i3;
                            }
                        } catch (Exception unused) {
                            AJMediaCodec.this.mAJMediaFormat.reset();
                            AJMediaCodec._onFormatChanged(AJMediaCodec.this.mHandler, -1, 0, 0, 0, 0, 0, 0, 0, 0);
                            i2 = -1;
                        }
                    } else {
                        i3 = 0;
                    }
                    i2 = i3;
                    AJMediaCodec._onFormatChanged(AJMediaCodec.this.mHandler, i2, AJMediaCodec.this.mAJMediaFormat.width, AJMediaCodec.this.mAJMediaFormat.height, AJMediaCodec.this.mAJMediaFormat.sampleRate, AJMediaCodec.this.mAJMediaFormat.channelCount, AJMediaCodec.this.mAJMediaFormat.colorFormat, AJMediaCodec.this.mAJMediaFormat.colorTrans, AJMediaCodec.this.mAJMediaFormat.sliceHeight, AJMediaCodec.this.mAJMediaFormat.stride);
                }
            };
            if (Util.SDK_INT < 23) {
                this.mMediaCodec.setCallback(callback);
                this.mAsyncHandler = new Handler(Looper.getMainLooper());
            } else {
                AVLogger.d("ttmn", "create async thread");
                HandlerThread handlerThread = new HandlerThread("mc_async");
                this.mAsyncThread = handlerThread;
                handlerThread.start();
                Handler handler = new Handler(this.mAsyncThread.getLooper());
                this.mAsyncHandler = handler;
                this.mMediaCodec.setCallback(callback, handler);
            }
            AVLogger.Debug(TAG, this, "ttmn: success to set callback func.");
            return 0;
        } catch (Exception unused) {
            AVLogger.Error(TAG, this, "ttmn: failed to set callback");
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFlushCompleted(Runnable runnable) {
        synchronized (mAsyncLock) {
            if (this.mCodecIsClosed) {
                return;
            }
            int i = this.mPendingFlushCount - 1;
            this.mPendingFlushCount = i;
            if (i > 0) {
                return;
            }
            if (i < 0) {
                return;
            }
            _clearBufferIndex(this.mHandler);
            try {
                runnable.run();
            } catch (Exception e) {
                if (e instanceof IllegalStateException) {
                    _onError(this.mHandler);
                } else {
                    AVLogger.Warn(TAG, this, e.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetSurfaceCompleted() {
        synchronized (mAsyncLock) {
            if (this.mCodecIsClosed) {
                return;
            }
            AVLogger.Debug(TAG, this, "ttmn setSurfaceCompleted");
            _setSurfaceCompleted(this.mHandler);
        }
    }

    public int configure(int i, int i2, int i3, int i4, int i5, String str, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, Surface surface, boolean z, boolean z2, int i6, int i7, boolean z3, int i8, boolean z4, boolean z5, int i9, int i10, int i11) {
        Surface surface2 = surface;
        int i12 = i6;
        int i13 = i7;
        AVLogger.Debug(TAG, this, "ttmn: configure =" + surface2 + ", surfaceConfigure =" + z);
        if (Util.SDK_INT >= 21 && setCallback(this.mMcMode) == -1) {
            return -1;
        }
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, str);
        maybeSetInteger(mediaFormat, "width", i);
        maybeSetInteger(mediaFormat, "height", i2);
        if (i12 != -1 && i13 != -1) {
            if (i12 <= i) {
                i12 = i;
            }
            maybeSetInteger(mediaFormat, "max-width", i12);
            if (i13 <= i2) {
                i13 = i2;
            }
            maybeSetInteger(mediaFormat, "max-height", i13);
        }
        maybeSetInteger(mediaFormat, "sample-rate", i4);
        maybeSetInteger(mediaFormat, "channel-count", i5);
        AVLogger.Debug(TAG, this, "format  = " + mediaFormat);
        int maxInputSize = getMaxInputSize(str, i, i2);
        AVLogger.Debug(TAG, this, "max input = " + maxInputSize);
        maybeSetInteger(mediaFormat, "max-input-size", maxInputSize);
        maybeSetCsdBuffers(mediaFormat, byteBuffer, 0);
        maybeSetCsdBuffers(mediaFormat, byteBuffer2, 1);
        maybeSetCsdBuffers(mediaFormat, byteBuffer3, 2);
        if (z) {
            if (Util.SDK_INT >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i3);
            }
            if ((surface2 == null || !surface.isValid()) && this.mDummySurface == null && Util.SDK_INT >= 23 && !mDeviceNeedsSetOutputSurfaceWorkaround) {
                AVLogger.Debug(TAG, this, "create dummy surface");
                createDummySurface();
                surface2 = this.mDummySurface;
            }
            if (surface2 == null) {
                this.mExceptionInfo = "Error: configure with null surface";
                return CODEC_ILLEGAL_ARGUMENT;
            }
        }
        if (Util.SDK_INT >= 23 && z2) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z3) {
            VendorQTI.setupVpp(mediaFormat, i8);
        }
        if (z4) {
            VendorQTI.debugEffect(mediaFormat);
        }
        if (z5) {
            VendorQTI.enableLowLatency(mediaFormat);
        }
        if (i11 > 0 && isLowLatencyDecode() > 0) {
            AVLogger.Debug(TAG, this, "low latency works.");
            maybeSetInteger(mediaFormat, "low-latency", 1);
        }
        if (i10 > 0 && i9 >= 0) {
            String dolbyCodecs = MediaCodecUtil.getDolbyCodecs(i9, i10);
            AVLogger.Debug(TAG, this, "dv codecs = " + dolbyCodecs);
            Pair<Integer, Integer> dolbyVisionProfileAndLevel = MediaCodecUtil.getDolbyVisionProfileAndLevel(dolbyCodecs, dolbyCodecs != null ? dolbyCodecs.split("\\.") : null);
            if (dolbyVisionProfileAndLevel != null) {
                AVLogger.Debug(TAG, this, "dv profile & level  = " + dolbyVisionProfileAndLevel.toString());
                maybeSetInteger(mediaFormat, "profile", ((Integer) dolbyVisionProfileAndLevel.first).intValue());
            }
        }
        try {
            this.mMediaCodec.configure(mediaFormat, surface2, (MediaCrypto) null, 0);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            AVLogger.Debug(TAG, this, "configure failed = " + this.mMediaCodec + ", ex=" + e.toString());
            if (e instanceof IllegalArgumentException) {
                return CODEC_ILLEGAL_ARGUMENT;
            }
            return -1;
        }
    }

    public int start() {
        AVLogger.Debug(TAG, this, "start");
        try {
            this.mMediaCodec.start();
            if (this.mMcMode == 0) {
                this.mInputBuffers = this.mMediaCodec.getInputBuffers();
                if (Util.SDK_INT >= 21) {
                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                }
            } else {
                this.mInputBuffers = null;
                this.mOutputBuffers = null;
            }
            this.mInputBuffersValid = true;
            this.mBufferInfo = new MediaCodec.BufferInfo();
            AVLogger.Debug(TAG, this, "start end");
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            return -1;
        }
    }

    public int open(int i, int i2, int i3, String str, String str2, ByteBuffer byteBuffer, Surface surface) {
        AVLogger.Debug(TAG, this, "open, rotation = " + i3 + "; codecName = " + str + "; codecType =" + str2);
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            AVLogger.Debug(TAG, this, "configure mediacodec");
            android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, str2);
            maybeSetInteger(mediaFormat, "width", i);
            maybeSetInteger(mediaFormat, "height", i2);
            if (byteBuffer != null) {
                mediaFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (surface != null && Util.SDK_INT >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i3);
            }
            try {
                this.mMediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
                AVLogger.Debug(TAG, this, "mediacodec start");
                try {
                    this.mMediaCodec.start();
                    this.mInputBuffers = this.mMediaCodec.getInputBuffers();
                    this.mInputBuffersValid = true;
                    AVLogger.Debug(TAG, this, String.format(Locale.US, "open() input params. width:%d,height:%d", Integer.valueOf(i), Integer.valueOf(i2)));
                    return 0;
                } catch (Exception e) {
                    AVLogger.Debug(TAG, this, e.toString());
                    return -1;
                }
            } catch (Exception e2) {
                AVLogger.Debug(TAG, this, e2.toString());
                return -1;
            }
        } catch (Exception e3) {
            AVLogger.Debug(TAG, this, e3.toString());
            return -1;
        }
    }

    public int stop() {
        if (this.mInputBuffersValid) {
            AVLogger.Debug(TAG, this, a.e);
            try {
                this.mInputBuffersValid = false;
                this.mMediaCodec.stop();
            } catch (Exception unused) {
                AVLogger.Debug(TAG, this, "mediacodec stop exception");
                return -1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodec(MediaCodec mediaCodec) {
        ReentrantLock reentrantLock;
        ReentrantLock reentrantLock2;
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.release();
            DummySurface dummySurface = this.mDummySurface;
            if (dummySurface != null) {
                dummySurface.release();
                this.mDummySurface = null;
            }
        } catch (Exception unused) {
            if (this.mDummySurface != null) {
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            if (this.mEnableSingleCodec == 1) {
                try {
                    reentrantLock2 = mSingleCodecLock;
                    reentrantLock2.lock();
                    mCodecInstanceNums--;
                    mSingleCodecCond.signal();
                } catch (Exception unused2) {
                    reentrantLock2 = mSingleCodecLock;
                } catch (Throwable th) {
                    mSingleCodecLock.unlock();
                    throw th;
                }
            }
        } catch (Throwable th2) {
            if (this.mDummySurface != null) {
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            if (this.mEnableSingleCodec == 1) {
                try {
                    reentrantLock = mSingleCodecLock;
                    reentrantLock.lock();
                    mCodecInstanceNums--;
                    mSingleCodecCond.signal();
                } catch (Exception unused3) {
                    reentrantLock = mSingleCodecLock;
                } catch (Throwable th3) {
                    mSingleCodecLock.unlock();
                    throw th3;
                }
                reentrantLock.unlock();
            }
            AVLogger.Debug(TAG, this, "codec release end");
            throw th2;
        }
        if (this.mEnableSingleCodec == 1) {
            try {
                reentrantLock2 = mSingleCodecLock;
                reentrantLock2.lock();
                mCodecInstanceNums--;
                mSingleCodecCond.signal();
            } catch (Exception unused4) {
                reentrantLock2 = mSingleCodecLock;
            } catch (Throwable th4) {
                mSingleCodecLock.unlock();
                throw th4;
            }
            reentrantLock2.unlock();
        }
        AVLogger.Debug(TAG, this, "codec release end");
    }

    public void close() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        AVLogger.Debug(TAG, this, "~JAJMediaCodec#{");
        if (this.mMediaCodec != null) {
            stop();
            final MediaCodec mediaCodec = this.mMediaCodec;
            this.mInputBuffers = null;
            this.mOutputBuffers = null;
            if (this.mMcMode == 1 && Util.SDK_INT >= 23) {
                synchronized (mAsyncLock) {
                    HandlerThread handlerThread = this.mAsyncThread;
                    if (handlerThread != null) {
                        handlerThread.quit();
                    }
                    _clearBufferIndex(this.mHandler);
                    this.mCodecIsClosed = true;
                    this.mMediaCodec = null;
                }
            } else {
                this.mMediaCodec = null;
            }
            if (mEnableMediaCodecSyncClose > 0) {
                AVLogger.Debug(TAG, this, "sync releaseCodec");
                releaseCodec(mediaCodec);
            } else {
                try {
                    AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AVLogger.Debug(AJMediaCodec.TAG, this, "start releaseCodec task");
                            AJMediaCodec.this.releaseCodec(mediaCodec);
                        }
                    });
                } catch (Throwable unused) {
                    AVLogger.Warn(TAG, this, "new thread failed");
                    releaseCodec(mediaCodec);
                }
            }
        }
        AVLogger.InfoTrackLife(TAG, this, "~JAJMediaCodec#}");
    }

    private int renderOutputBufferV21(int i, long j) {
        try {
            this.mMediaCodec.releaseOutputBuffer(i, j);
            return 0;
        } catch (Exception unused) {
            return CODEC_ERROR;
        }
    }

    public int handleCodecExceptionV21(Exception exc) {
        if (exc instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) exc;
            if (Util.SDK_INT >= 23) {
                AVLogger.Debug(TAG, this, "exception codecExc isRecoverable: " + codecException.isRecoverable() + ", errorcode: " + codecException.getErrorCode());
                if (!codecException.isRecoverable() && codecException.getErrorCode() != 1100 && codecException.getErrorCode() != 1101) {
                    return CODEC_EXCEPTION_ERROR;
                }
            } else {
                AVLogger.Debug(TAG, this, "exception codecExc isRecoverable: " + codecException.isRecoverable());
                if (!codecException.isRecoverable()) {
                    return CODEC_EXCEPTION_ERROR;
                }
            }
        }
        return exc instanceof IllegalStateException ? CODEC_ILLEGAL_STATE : CODEC_ERROR;
    }

    public int handleCodecException(Exception exc) {
        this.mExceptionInfo = exc.toString();
        if (Util.SDK_INT >= 21) {
            return handleCodecExceptionV21(exc);
        }
        return exc instanceof IllegalStateException ? CODEC_ILLEGAL_STATE : CODEC_ERROR;
    }

    public int dequeueInputBuffer(long j) {
        try {
            return this.mMediaCodec.dequeueInputBuffer(j);
        } catch (Exception e) {
            AVLogger.Debug(TAG, this, "dequeueInputBuffer failed, exception: " + e);
            return handleCodecException(e);
        }
    }

    public ByteBuffer[] getInputBuffers() {
        if (this.mInputBuffersValid) {
            return this.mInputBuffers;
        }
        return null;
    }

    public ByteBuffer getInputBuffer(int i) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.mInputBuffersValid) {
            try {
                return this.mMediaCodec.getInputBuffer(i);
            } catch (Exception e) {
                AVLogger.Error(TAG, this, "getInputBuffer failed, exception: " + e);
            }
        }
        return null;
    }

    public int queueInputBuffer(int i, int i2, int i3, long j, int i4) throws MediaCodec.CryptoException {
        try {
            this.mMediaCodec.queueInputBuffer(i, i2, i3, j, i4);
            return 0;
        } catch (Exception e) {
            AVLogger.Debug(TAG, this, "queueInputBuffer failed, exception: " + e);
            return handleCodecException(e);
        }
    }

    public int setOutputSurface(Surface surface) {
        AVLogger.Debug(TAG, this, "setoutput surface = " + surface);
        if (mDeviceNeedsSetOutputSurfaceWorkaround || !this.mInputBuffersValid) {
            return -1;
        }
        if (surface == null) {
            if (this.mDummySurface == null) {
                createDummySurface();
            }
            surface = this.mDummySurface;
            AVLogger.Debug(TAG, this, "use dummy surface");
        }
        AVLogger.Debug(TAG, this, "setoutputSurface = " + surface);
        return setOutputSurfaceV23(this.mMediaCodec, surface);
    }

    public int write(AJMediaCodecFrame aJMediaCodecFrame) throws IllegalAccessException, MediaCodec.CryptoException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (aJMediaCodecFrame == null || aJMediaCodecFrame.data == null) {
            AVLogger.Debug(TAG, this, "buffer is nullpoint");
            return -1;
        }
        try {
            int iDequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(INPUT_TIMEOUT_US);
            if (iDequeueInputBuffer < 0) {
                return iDequeueInputBuffer == -1 ? 4 : -1;
            }
            this.mInputBuffers[iDequeueInputBuffer].put(aJMediaCodecFrame.data);
            this.mMediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, aJMediaCodecFrame.size, aJMediaCodecFrame.pts, 0);
            return 0;
        } catch (Exception e) {
            AVLogger.Error(TAG, this, "write meet exception =" + e);
            return -1;
        }
    }

    public int read(AJMediaCodecFrame aJMediaCodecFrame, long j) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        while (true) {
            try {
                int iDequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, j);
                if (iDequeueOutputBuffer >= 0) {
                    aJMediaCodecFrame.data = this.mOutputBuffers[iDequeueOutputBuffer];
                    aJMediaCodecFrame.pts = this.mBufferInfo.presentationTimeUs;
                    aJMediaCodecFrame.index = iDequeueOutputBuffer;
                    aJMediaCodecFrame.size = this.mBufferInfo.size;
                    aJMediaCodecFrame.flags = this.mBufferInfo.flags;
                    return 0;
                }
                if (iDequeueOutputBuffer != -3) {
                    if (iDequeueOutputBuffer != -2) {
                        if (iDequeueOutputBuffer != -1) {
                            AVLogger.Error(TAG, this, "error, idx = " + iDequeueOutputBuffer);
                        }
                        return -1;
                    }
                    AVLogger.Debug(TAG, this, "INFO_OUTPUT_FORMAT_CHANGED");
                    try {
                        this.mOutputMediaFormat = this.mMediaCodec.getOutputFormat();
                        if (this.mOutputBuffers == null) {
                            try {
                                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                            } catch (Exception e) {
                                AVLogger.Debug(TAG, this, "getOutputBuffers e = " + e);
                                return handleCodecException(e);
                            }
                        }
                        return iDequeueOutputBuffer;
                    } catch (Exception e2) {
                        AVLogger.Debug(TAG, this, "getOutputFormat e =" + e2);
                        return handleCodecException(e2);
                    }
                }
                AVLogger.Debug(TAG, this, "INFO_OUTPUT_BUFFERS_CHANGED");
                try {
                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                } catch (Exception e3) {
                    AVLogger.Debug(TAG, this, "getOutputBuffers e = " + e3);
                    return handleCodecException(e3);
                }
            } catch (Exception e4) {
                AVLogger.Debug(TAG, this, "dequeueOutputBuffer e :" + e4);
                return handleCodecException(e4);
            }
        }
    }

    public int flush() {
        AVLogger.Debug(TAG, this, "flush");
        try {
            this.mMediaCodec.flush();
            if (this.mMcMode == 1) {
                synchronized (mAsyncLock) {
                    this.mPendingFlushCount++;
                    this.mAsyncHandler.post(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (AJMediaCodec.this.mMediaCodec != null) {
                                    AJMediaCodec.this.onFlushCompleted(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.3.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (AJMediaCodec.this.mMediaCodec != null) {
                                                AJMediaCodec.this.mMediaCodec.start();
                                            }
                                        }
                                    });
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            }
            AVLogger.Debug(TAG, this, "flush done");
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public int releaseBuffer(int i, boolean z, long j) {
        if (Util.SDK_INT >= 21 && z) {
            return renderOutputBufferV21(i, j);
        }
        try {
            this.mMediaCodec.releaseOutputBuffer(i, z);
            return 0;
        } catch (Exception e) {
            return handleCodecException(e);
        }
    }

    public int getFormatWidth() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                    return (this.mOutputMediaFormat.getInteger(KEY_CROP_RIGHT) - this.mOutputMediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
                }
                return this.mOutputMediaFormat.getInteger("width");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getFormatHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                    return (this.mOutputMediaFormat.getInteger(KEY_CROP_BOTTOM) - this.mOutputMediaFormat.getInteger(KEY_CROP_TOP)) + 1;
                }
                return this.mOutputMediaFormat.getInteger("height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getStride() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("stride");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getSliceHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("slice-height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getSampleRate() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("sample-rate");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getChannelCount() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("channel-count");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getColorFormat() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-format");
                return (integer == 21 || integer == 2130706688 || integer == 2141391872) ? 3 : 0;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getColorTransfer() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-transfer");
                if (integer != 6) {
                    return integer != 7 ? 0 : 18;
                }
                return 16;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getOSVerion() {
        return Util.SDK_INT;
    }

    public void speedEnhance(float f) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23 || f <= 30.0f) {
            return;
        }
        AVLogger.Debug(TAG, this, "rate " + f);
        Bundle bundle = new Bundle();
        bundle.putFloat("operating-rate", f);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e) {
            AVLogger.Warn(TAG, this, "setParameters failed ret = " + e);
        }
    }

    public void decodeFRC(int i) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23) {
            return;
        }
        AVLogger.Debug(TAG, this, "frc level = " + i);
        Bundle bundle = new Bundle();
        bundle.putInt("vivo.video-dec.dynamic-frc", i);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e) {
            AVLogger.Warn(TAG, this, "setParameters failed ret = " + e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00fc A[Catch: all -> 0x025e, TryCatch #1 {, blocks: (B:19:0x006c, B:21:0x0075, B:24:0x007e, B:26:0x0086, B:29:0x008f, B:31:0x0095, B:35:0x00a1, B:37:0x00a7, B:39:0x00b2, B:114:0x0217, B:42:0x00d6, B:44:0x00de, B:47:0x00e7, B:53:0x00fc, B:56:0x0104, B:58:0x0108, B:113:0x0212, B:61:0x0112, B:63:0x0118, B:65:0x0121, B:67:0x012a, B:68:0x012f, B:70:0x0135, B:72:0x013d, B:74:0x0145, B:75:0x014a, B:78:0x0152, B:80:0x0172, B:82:0x017a, B:84:0x0182, B:86:0x018a, B:88:0x0192, B:90:0x019a, B:93:0x01a4, B:95:0x01ac, B:98:0x01b3, B:101:0x01ba, B:104:0x01c1, B:106:0x01f1, B:108:0x01f7, B:109:0x0200, B:111:0x0206, B:112:0x020f, B:50:0x00f1, B:38:0x00ae, B:115:0x021c, B:117:0x0222, B:120:0x0225, B:121:0x0230, B:123:0x0236, B:126:0x0244, B:127:0x0252, B:32:0x009a, B:129:0x0254, B:130:0x025b), top: B:137:0x006c, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getBestCodecName(java.lang.String r17) throws java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 609
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.AJMediaCodec.getBestCodecName(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061 A[Catch: all -> 0x0095, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:10:0x0018, B:52:0x008f, B:11:0x001c, B:14:0x0022, B:36:0x0063, B:51:0x008d, B:41:0x0074, B:44:0x007e, B:35:0x0061, B:21:0x003b, B:24:0x0045, B:27:0x004f, B:53:0x0091), top: B:59:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007e A[Catch: all -> 0x0095, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:10:0x0018, B:52:0x008f, B:11:0x001c, B:14:0x0022, B:36:0x0063, B:51:0x008d, B:41:0x0074, B:44:0x007e, B:35:0x0061, B:21:0x003b, B:24:0x0045, B:27:0x004f, B:53:0x0091), top: B:59:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d A[Catch: all -> 0x0095, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:10:0x0018, B:52:0x008f, B:11:0x001c, B:14:0x0022, B:36:0x0063, B:51:0x008d, B:41:0x0074, B:44:0x007e, B:35:0x0061, B:21:0x003b, B:24:0x0045, B:27:0x004f, B:53:0x0091), top: B:59:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean codecNeedsSetOutputSurfaceWorkaround() {
        /*
            java.lang.Class<com.ss.ttm.player.AJMediaCodec> r0 = com.ss.ttm.player.AJMediaCodec.class
            monitor-enter(r0)
            boolean r1 = com.ss.ttm.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround     // Catch: java.lang.Throwable -> L95
            if (r1 != 0) goto L91
            int r1 = com.ss.ttm.utils.Util.SDK_INT     // Catch: java.lang.Throwable -> L95
            r2 = 27
            r3 = 1
            if (r1 > r2) goto L1c
            java.lang.String r1 = "dangal"
            java.lang.String r4 = com.ss.ttm.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L95
            boolean r1 = r1.equals(r4)     // Catch: java.lang.Throwable -> L95
            if (r1 == 0) goto L1c
            com.ss.ttm.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L95
            goto L8f
        L1c:
            int r1 = com.ss.ttm.utils.Util.SDK_INT     // Catch: java.lang.Throwable -> L95
            if (r1 < r2) goto L22
            goto L8f
        L22:
            java.lang.String r1 = com.ss.ttm.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L95
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L95
            r4 = 99329(0x18401, float:1.3919E-40)
            r5 = 0
            r6 = 2
            r7 = -1
            if (r2 == r4) goto L4f
            r4 = 3351335(0x332327, float:4.69622E-39)
            if (r2 == r4) goto L45
            r4 = 1865889110(0x6f373556, float:5.6700236E28)
            if (r2 == r4) goto L3b
            goto L59
        L3b:
            java.lang.String r2 = "santoni"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L95
            if (r1 == 0) goto L59
            r1 = r6
            goto L5a
        L45:
            java.lang.String r2 = "mido"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L95
            if (r1 == 0) goto L59
            r1 = r3
            goto L5a
        L4f:
            java.lang.String r2 = "deb"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L95
            if (r1 == 0) goto L59
            r1 = r5
            goto L5a
        L59:
            r1 = r7
        L5a:
            if (r1 == 0) goto L61
            if (r1 == r3) goto L61
            if (r1 == r6) goto L61
            goto L63
        L61:
            com.ss.ttm.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L95
        L63:
            java.lang.String r1 = com.ss.ttm.utils.Util.MODEL     // Catch: java.lang.Throwable -> L95
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L95
            r4 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r2 == r4) goto L7e
            r4 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r2 == r4) goto L74
            goto L87
        L74:
            java.lang.String r2 = "AFTN"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L95
            if (r1 == 0) goto L87
            r5 = r3
            goto L88
        L7e:
            java.lang.String r2 = "AFTA"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L95
            if (r1 == 0) goto L87
            goto L88
        L87:
            r5 = r7
        L88:
            if (r5 == 0) goto L8d
            if (r5 == r3) goto L8d
            goto L8f
        L8d:
            com.ss.ttm.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L95
        L8f:
            com.ss.ttm.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L95
        L91:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L95
            boolean r0 = com.ss.ttm.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround
            return r0
        L95:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L95
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.AJMediaCodec.codecNeedsSetOutputSurfaceWorkaround():boolean");
    }

    private int setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            mediaCodec.setOutputSurface(surface);
            if (this.mMcMode != 1 || this.mFixedMemcpyCrash != 1) {
                return 0;
            }
            synchronized (mAsyncLock) {
                this.mAsyncHandler.post(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AJMediaCodec.this.onSetSurfaceCompleted();
                    }
                });
            }
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            AVLogger.Warn(TAG, this, "setoutputsurface failed = " + e);
            DummySurface dummySurface = this.mDummySurface;
            if (dummySurface != null) {
                dummySurface.addEvent(surface != dummySurface ? 2 : 1);
            }
            if (e instanceof IllegalArgumentException) {
                return CODEC_ILLEGAL_ARGUMENT;
            }
            return -1;
        }
    }

    public static int ceilDivide(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    private static int getMaxInputSize(String str, int i, int i2) {
        int iCeilDivide;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        if (str.equals("video/3gpp") || str.equals("video/mp4v-es")) {
            iCeilDivide = i * i2;
            i3 = 2;
        } else if (str.equals(Constants.CodecType.VIDEO_H264)) {
            if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
                return -1;
            }
            iCeilDivide = ceilDivide(i, 16) * ceilDivide(i2, 16) * 16 * 16;
            i3 = 2;
        } else {
            if (!str.equals("video/x-vnd.on2.vp8")) {
                if (!str.equals(Constants.CodecType.VIDEO_H265) && !str.equals("video/x-vnd.on2.vp9")) {
                    return -1;
                }
                iCeilDivide = i * i2;
                i3 = 4;
            }
            iCeilDivide = i * i2;
            i3 = 2;
        }
        return (iCeilDivide * 3) / (i3 * 2);
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        return Util.SDK_INT < 18 || (Util.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (Util.SDK_INT == 19 && Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    public void setEnableVC1BlockList(int i) {
        mIsByteVC1BlocklistEnable = i;
    }

    public void setEnableMediaCodecSyncClose(int i) {
        mEnableMediaCodecSyncClose = i;
    }

    private int isLowLatencyDecode() {
        MediaCodecInfo mediaCodecInfo;
        String str;
        if (Build.VERSION.SDK_INT >= 30 && (mediaCodecInfo = this.mCodecInfo) != null && (str = this.mCodecType) != null) {
            try {
                return mediaCodecInfo.getCapabilitiesForType(str).isFeatureSupported("low-latency") ? 1 : 0;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private boolean isAdaptivePlaybackV19() {
        String str;
        MediaCodecInfo mediaCodecInfo = this.mCodecInfo;
        if (mediaCodecInfo != null && (str = this.mCodecType) != null) {
            try {
                return mediaCodecInfo.getCapabilitiesForType(str).isFeatureSupported("adaptive-playback");
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public int isAdaptivePlayback() {
        int i = this.mSupportAdaptivePlayBack;
        if (i != -1) {
            return i;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.mSupportAdaptivePlayBack = isAdaptivePlaybackV19() ? 1 : 0;
        } else {
            this.mSupportAdaptivePlayBack = 1;
        }
        if ("Q7-G1".equals(Build.MODEL) && "kunlun".equals(Build.HARDWARE) && "GK6323V100C".equals(Build.BOARD) && Build.VERSION.SDK_INT == 19) {
            this.mSupportAdaptivePlayBack = 0;
        }
        return this.mSupportAdaptivePlayBack;
    }
}
