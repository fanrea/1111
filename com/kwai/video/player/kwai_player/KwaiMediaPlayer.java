package com.kwai.video.player.kwai_player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwad.sdk.AdLiveOfflineCompoImpl;
import com.kwai.player.KwaiPlayerConfig;
import com.kwai.player.KwaiPlayerReleasePool;
import com.kwai.player.OnPlayerReleaseListener;
import com.kwai.player.debuginfo.model.AppLiveQosDebugInfo;
import com.kwai.player.debuginfo.model.AppLiveQosDebugInfoNew;
import com.kwai.player.debuginfo.model.AppVodQosDebugInfoNew;
import com.kwai.player.debuginfo.model.KwaiPlayerDebugInfo;
import com.kwai.player.debuginfo.model.PlayerConfigDebugInfo;
import com.kwai.player.qos.AppLiveAdaptiveRealtimeInfo;
import com.kwai.player.qos.AppQosLiveAdaptiveRealtimeWrapper;
import com.kwai.player.qos.AppQosLiveRealtimeWrapper;
import com.kwai.player.qos.KwaiPlayerResultQos;
import com.kwai.player.qos.KwaiQosInfo;
import com.kwai.player.vr.KwaiVR;
import com.kwai.player.vr.SurfaceTextureRenderer;
import com.kwai.video.cache.PlayerPreferrenceUtil;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.AbstractNativeMediaPlayer;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.IKwaiRepresentationListener;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.KsMediaPlayerInitConfig;
import com.kwai.video.player.MediaInfo;
import com.kwai.video.player.PlayerProps;
import com.kwai.video.player.misc.IMediaDataSource;
import com.kwai.video.player.misc.KsTrackInfo;
import com.kwai.video.player.pragma.DebugLog;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class KwaiMediaPlayer extends AbstractNativeMediaPlayer implements IKwaiMediaPlayer {
    private static final int AUDIO_CHANNEL_MODE_FOA = 2;
    static final int INPUT_DATA_TYPE_HLS_CUSTOME_MANIFEST = 3;
    static final int INPUT_DATA_TYPE_INDEX_CONTENT = 2;
    static final int INPUT_DATA_TYPE_SINGLE_URL = 0;
    static final int INPUT_DATA_TYPE_VOD_MANIFEST = 1;
    private static final int MEDIA_BUFFERSIZE_DEFAULT = 20;
    private static final String TAG = "com.kwai.video.player.kwai_player.KwaiMediaPlayer";
    AppQosLiveAdaptiveRealtimeWrapper mAppQosLiveAdaptiveRealtimeWrapper;
    AppQosLiveRealtimeWrapper mAppQosLiveRealtimeWrapper;
    private AspectAwesomeCache mAspectAwesomeCache;
    private AspectKFlv mAspectKFlv;
    private int mAudioChannelMode;
    private int mBufferingCount;
    private Context mContext;
    private String mDataSource;
    private boolean mIsLive;
    private boolean mIsVR;
    private boolean mIsVodAdaptive;
    private IKwaiRepresentationListener mKwaiRepresentationListener;
    private KwaiVR mKwaiVR;
    private OnControlMessageListener mOnControlMessageListener;
    private IMediaPlayer.OnLiveVoiceCommentListener mOnLiveVoiceCommentListener;
    private OnNativeInvokeListener mOnNativeInvokeListener;
    private boolean mScreenOnWhilePlaying;
    private long mStartBufferingTime;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceTextureRenderer mSurfaceTextureRender;
    private int mTotalBufferingTime;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private AspectKwaiVodAdaptive mVodAdaptive;
    private PowerManager.WakeLock mWakeLock = null;
    private int mInteractivemode = 0;
    private int mStereoType = 0;
    private ByteBuffer mProcessPCMBuffer = null;
    private KwaiPlayerDebugInfo mKwaiPlayerDebugInfo = new KwaiPlayerDebugInfo();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface IHeadTrackerListener {
        void onHeadTracker(float f, float f2, float f3);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    @Deprecated
    public interface OnControlMessageListener {
        String onControlResolveSegmentUrl(int i);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    interface OnNativeInvokeListener {
        public static final String ARG_RETRY_COUNTER = "retry_counter";
        public static final String ARG_SEGMENT_INDEX = "segment_index";
        public static final String ARG_URL = "url";
        public static final int ON_CONCAT_RESOLVE_SEGMENT = 65536;
        public static final int ON_HTTP_OPEN = 65538;
        public static final int ON_LIVE_RETRY = 65540;
        public static final int ON_TCP_OPEN = 65537;

        boolean onNativeInvoke(int i, Bundle bundle);
    }

    private native void _addVideoRawBuffer(byte[] bArr);

    private native void _audioOnly(boolean z);

    private native boolean _checkCanStartPlay();

    private native void _disableSoftVideoDecode(boolean z);

    private native void _enableLoopOnBlock(int i, int i2, long j);

    private native void _enableVideoRawDataCallback(boolean z);

    private native Bundle _getAppLiveAdaptiveRealtimeInfo();

    private native Bundle _getAppLiveQosDebugInfo();

    private native void _getAppLiveQosDebugInfoNew(AppLiveQosDebugInfoNew appLiveQosDebugInfoNew);

    private native void _getAppVodQosDebugInfoNew(AppVodQosDebugInfoNew appVodQosDebugInfoNew);

    private native String _getAudioCodecInfo();

    private native String _getBriefVideoStatJson();

    private static native String _getColorFormatName(int i);

    private native int _getDownloadedPercent();

    private native String _getKwaiLiveVoiceComment(long j);

    private native String _getKwaiSign();

    private native String _getLiveRealTimeQosJson(int i, int i2, long j, long j2, long j3);

    private native String _getLiveStatJson();

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    public static native int _getPlayerAliveCnt();

    private native void _getPlayerConfigDebugInfo(PlayerConfigDebugInfo playerConfigDebugInfo);

    private native float _getProbeFps();

    private native Bundle _getQosInfo();

    /* JADX INFO: Access modifiers changed from: private */
    public native KwaiPlayerResultQos _getResultQos();

    private native void _getScreenShot(Bitmap bitmap);

    private native String _getVideoCodecInfo();

    private native String _getVideoStatJson();

    private native String _getVodAdaptiveCacheKey();

    private native String _getVodAdaptiveHostName();

    private native String _getVodAdaptiveUrl();

    private native String _getXksCache();

    private native boolean _isCacheEnabled();

    private native boolean _isMediaPlayerValid();

    private native void _pause();

    private native void _prepareAsync();

    private native void _release();

    private native void _reload(String str, boolean z);

    private native void _reset();

    private native void _setCodecFlag(int i);

    private native void _setDataSource(IMediaDataSource iMediaDataSource);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private native void _setDataSourceFd(int i, long j, long j2);

    private native void _setHeadTracker(float f, float f2, float f3);

    private native void _setHevcCodecName(String str);

    private native void _setLastTryFlag(int i);

    private native void _setLiveAppQosInfo(String str);

    private native void _setLiveManifestSwitchMode(int i);

    private native void _setLoopCount(int i);

    private native void _setOnLiveInterActiveListener(Object obj);

    private native void _setOption(int i, String str, long j);

    private native void _setOption(int i, String str, String str2);

    private native void _setPlayerMute(int i);

    private native void _setProcessPCMBuffer(ByteBuffer byteBuffer);

    private native void _setRepresentation(int i);

    private native void _setRepresentationListener(Object obj);

    private native boolean _setRotateDegree(int i);

    private native void _setSpeed(float f);

    private native void _setStreamSelected(int i, boolean z);

    private native void _setSurfaceTexture(SurfaceTexture surfaceTexture);

    private native void _setTone(int i);

    private native void _setVideoScalingMode(int i);

    private native void _setVideoSurface(Surface surface);

    private native void _shutdownWaitStop();

    private native void _start();

    private native void _step_frame();

    private native void _stop();

    private native void _updateCurrentMaxWallClockOffset(long j);

    private native void _updateCurrentWallClock(long j);

    public static native String getVersion();

    public static native String getVersionExt();

    private native void native_finalize();

    public static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setKlogParam(Object obj);

    public static native void native_setKwaiLogLevel(int i);

    public static native void native_setLogLevel(int i);

    private native void native_setup(Object obj);

    final native void _enableAbLoop(long j, long j2);

    final native void _enablePreDemux(int i, long j);

    final native float _getPropertyFloat(int i, float f);

    final native long _getPropertyLong(int i, long j);

    final native String _getPropertyString(int i);

    final native boolean _isLiveManifest();

    final native void _setAwesomeCacheCallback(Object obj);

    final native void _setBufferSize(int i);

    final native void _setConfigJson(String str);

    final native void _setConnectionTimeout(int i);

    final native void _setLiveLowDelayConfigJson(String str);

    final native void _setPropertyFloat(int i, float f);

    final native void _setPropertyLong(int i, long j);

    final native void _setQy265Context(Object obj);

    final native void _setStartPlayBlockBufferMs(int i, int i2);

    final native void _setTimeout(int i);

    final native void _setupCacheSessionListener(Object obj);

    @Override // com.kwai.video.player.IMediaPlayer
    public final native int getAudioSessionId();

    @Override // com.kwai.video.player.IMediaPlayer
    public final native long getCurrentPosition();

    @Override // com.kwai.video.player.IMediaPlayer
    public final native long getDuration();

    @Override // com.kwai.video.player.IMediaPlayer
    public final boolean isPlayable() {
        return true;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final native boolean isPlaying();

    @Override // com.kwai.video.player.IMediaPlayer
    public final native void seekTo(long j);

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setAudioStreamType(int i) {
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setKeepInBackground(boolean z) {
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final native void setVolume(float f, float f2);

    KwaiMediaPlayer() {
        initPlayer();
        resetSomething();
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public final void initPlayer() {
        super.initPlayer();
        native_setup(new WeakReference(this));
    }

    private void resetSomething() {
        this.mBufferingCount = 0;
        this.mTotalBufferingTime = 0;
        this.mStartBufferingTime = 0L;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        updateSurfaceScreenOn();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setSurface(Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    private void setVideoSurface(Surface surface) {
        if (this.mIsVR) {
            Surface surfaceOpenSurface = surface != null ? openSurface() : surface;
            SurfaceTextureRenderer surfaceTextureRenderer = this.mSurfaceTextureRender;
            if (surfaceTextureRenderer != null) {
                surfaceTextureRenderer.updateNativeWindow(surface);
            }
            surface = surfaceOpenSurface;
        }
        _setVideoSurface(surface);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    private void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setWakeMode(Context context, int i) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z = true;
                this.mWakeLock.release();
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, KwaiMediaPlayer.class.getName());
        this.mWakeLock = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    private void stayAwake(boolean z) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setDataSource(Context context, Uri uri) throws IOException {
        setDataSource(context, uri, (Map<String, String>) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0083  */
    @Override // com.kwai.video.player.IMediaPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setDataSource(android.content.Context r8, android.net.Uri r9, java.util.Map<java.lang.String, java.lang.String> r10) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = r9.getScheme()
            java.lang.String r1 = "file"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L14
            java.lang.String r8 = r9.getPath()
            r7.setDataSource(r8)
            return
        L14:
            java.lang.String r1 = "content"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3c
            java.lang.String r0 = r9.getAuthority()
            java.lang.String r1 = "settings"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3c
            int r9 = android.media.RingtoneManager.getDefaultType(r9)
            android.net.Uri r9 = android.media.RingtoneManager.getActualDefaultRingtoneUri(r8, r9)
            if (r9 == 0) goto L34
            goto L3c
        L34:
            java.io.FileNotFoundException r8 = new java.io.FileNotFoundException
            java.lang.String r9 = "Failed to resolve default ringtone"
            r8.<init>(r9)
            throw r8
        L3c:
            r0 = 0
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7e java.lang.SecurityException -> L81
            java.lang.String r1 = "r"
            android.content.res.AssetFileDescriptor r0 = r8.openAssetFileDescriptor(r9, r1)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7e java.lang.SecurityException -> L81
            if (r0 != 0) goto L4f
            if (r0 == 0) goto L4e
            r0.close()
        L4e:
            return
        L4f:
            long r1 = r0.getDeclaredLength()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7e java.lang.SecurityException -> L81
            r3 = 0
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 >= 0) goto L61
            java.io.FileDescriptor r8 = r0.getFileDescriptor()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7e java.lang.SecurityException -> L81
            r7.setDataSource(r8)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7e java.lang.SecurityException -> L81
            goto L71
        L61:
            java.io.FileDescriptor r2 = r0.getFileDescriptor()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7e java.lang.SecurityException -> L81
            long r3 = r0.getStartOffset()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7e java.lang.SecurityException -> L81
            long r5 = r0.getDeclaredLength()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7e java.lang.SecurityException -> L81
            r1 = r7
            r1.setDataSource(r2, r3, r5)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7e java.lang.SecurityException -> L81
        L71:
            if (r0 == 0) goto L76
            r0.close()
        L76:
            return
        L77:
            r8 = move-exception
            if (r0 == 0) goto L7d
            r0.close()
        L7d:
            throw r8
        L7e:
            if (r0 == 0) goto L86
            goto L83
        L81:
            if (r0 == 0) goto L86
        L83:
            r0.close()
        L86:
            java.lang.String r8 = com.kwai.video.player.kwai_player.KwaiMediaPlayer.TAG
            java.lang.String r0 = "Couldn't open file on client side, trying server side"
            android.util.Log.d(r8, r0)
            java.lang.String r8 = r9.toString()
            r7.setDataSource(r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.video.player.kwai_player.KwaiMediaPlayer.setDataSource(android.content.Context, android.net.Uri, java.util.Map):void");
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setDataSource(String str) {
        this.mDataSource = str;
        configUserAgent();
        _setDataSource(str, null, null);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setDataSource(String str, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            String str2 = map.get("Host");
            if (str2 != null) {
                setOption(4, "host", str2);
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                if (!TextUtils.isEmpty(entry.getValue())) {
                    sb.append(entry.getValue());
                }
                sb.append("\r\n");
            }
            setOption(1, "headers", sb.toString());
        }
        setDataSource(str);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setDataSource(FileDescriptor fileDescriptor) {
        this.mDataSource = fileDescriptor.toString();
        _setDataSourceFd(getNativeFd(fileDescriptor), 0L, 0L);
    }

    private int getNativeFd(FileDescriptor fileDescriptor) throws NoSuchFieldException {
        if (Build.VERSION.SDK_INT < 12) {
            try {
                Field declaredField = fileDescriptor.getClass().getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                return declaredField.getInt(fileDescriptor);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException(e2);
            }
        }
        return ParcelFileDescriptor.dup(fileDescriptor).getFd();
    }

    @Override // com.kwai.video.player.AbstractMediaPlayer, com.kwai.video.player.IMediaPlayer
    public final void setDataSource(IMediaDataSource iMediaDataSource) {
        _setDataSource(iMediaDataSource);
    }

    private void setDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        this.mDataSource = fileDescriptor.toString();
        _setDataSourceFd(getNativeFd(fileDescriptor), j, j2);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final String getDataSource() {
        return this.mDataSource;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void prepareAsync() {
        this.mAppQosLiveRealtimeWrapper.start(this.mDataSource);
        this.mAppQosLiveAdaptiveRealtimeWrapper.start();
        _prepareAsync();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void start() {
        stayAwake(true);
        _start();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void pause() {
        stayAwake(false);
        _pause();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void stop() {
        stopLiveStatTimerImmediately();
        stayAwake(false);
        stopDrawLoopTimer();
        _stop();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void shutdownWaitStop() {
        stopLiveStatTimerImmediately();
        stayAwake(false);
        stopDrawLoopTimer();
        _shutdownWaitStop();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void releaseAsync() {
        releaseAsync(null);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void releaseAsync(final OnPlayerReleaseListener onPlayerReleaseListener) {
        KwaiPlayerReleasePool.submit(new Runnable() { // from class: com.kwai.video.player.kwai_player.KwaiMediaPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                KwaiMediaPlayer.this.shutdownWaitStop();
                if (onPlayerReleaseListener != null) {
                    onPlayerReleaseListener.onRelease(KwaiMediaPlayer.this._getResultQos());
                }
                KwaiMediaPlayer.this.release();
            }
        });
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void release() {
        if (this.mIsVodAdaptive) {
            PlayerPreferrenceUtil.getInstance().saveVodAdaptiveData();
        }
        stayAwake(false);
        updateSurfaceScreenOn();
        _release();
        resetListeners();
        this.mAspectAwesomeCache.release();
        if (this.mIsVR) {
            SurfaceTextureRenderer surfaceTextureRenderer = this.mSurfaceTextureRender;
            if (surfaceTextureRenderer != null) {
                surfaceTextureRenderer.release();
            }
            KwaiVR kwaiVR = this.mKwaiVR;
            if (kwaiVR != null) {
                kwaiVR.release();
                this.mKwaiVR = null;
                Log.d(TAG, "release: mkwaivr release");
            }
        }
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer, com.kwai.video.player.IMediaPlayer
    public final void reset() {
        stayAwake(false);
        _reset();
        super.reset();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    public final int getSelectedTrack(int i) {
        long j_getPropertyLong;
        if (i == 1) {
            j_getPropertyLong = _getPropertyLong(20001, -1L);
        } else {
            if (i != 2) {
                return -1;
            }
            j_getPropertyLong = _getPropertyLong(20002, -1L);
        }
        return (int) j_getPropertyLong;
    }

    public final void selectTrack(int i) {
        _setStreamSelected(i, true);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setRepresentation(int i) {
        _setRepresentation(i);
    }

    public final void deselectTrack(int i) {
        _setStreamSelected(i, false);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setLooping(boolean z) {
        int i = !z ? 1 : 0;
        setOption(4, "loop", i);
        _setLoopCount(i);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final boolean isLooping() {
        return _getLoopCount() != 1;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setTone(int i) {
        _setTone(i);
    }

    public final void setOption(int i, String str, String str2) {
        _setOption(i, str, str2);
    }

    public final void setOption(int i, String str, long j) {
        _setOption(i, str, j);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final int getVideoDecoder() {
        return (int) _getPropertyLong(20003, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final float getVideoOutputFramesPerSecond() {
        return _getPropertyFloat(10002, 0.0f);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final String getCurPlayingUrl() {
        return _getPropertyString(PlayerProps.FFP_PROP_STRING_PLAYING_URL);
    }

    public final float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final long getVideoCachedDuration() {
        return _getPropertyLong(20005, 0L);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final long getAudioCachedDuration() {
        return _getPropertyLong(20006, 0L);
    }

    @Deprecated
    public final long getVideoCachedBytes() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_BYTES, 0L);
    }

    @Deprecated
    public final long getAudioCachedBytes() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_BYTES, 0L);
    }

    @Deprecated
    public final long getVideoCachedPackets() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_PACKETS, 0L);
    }

    @Deprecated
    public final long getAudioCachedPackets() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_PACKETS, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final MediaInfo getMediaInfo() {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mMediaPlayerName = AdLiveOfflineCompoImpl.SO_KWAI_PLAYER;
        String str_getVideoCodecInfo = _getVideoCodecInfo();
        if (!TextUtils.isEmpty(str_getVideoCodecInfo)) {
            String[] strArrSplit = str_getVideoCodecInfo.split(",");
            if (strArrSplit.length >= 2) {
                mediaInfo.mVideoDecoder = strArrSplit[0];
                mediaInfo.mVideoDecoderImpl = strArrSplit[1];
            } else if (strArrSplit.length > 0) {
                mediaInfo.mVideoDecoder = strArrSplit[0];
                mediaInfo.mVideoDecoderImpl = "";
            }
        }
        String str_getAudioCodecInfo = _getAudioCodecInfo();
        if (!TextUtils.isEmpty(str_getAudioCodecInfo)) {
            String[] strArrSplit2 = str_getAudioCodecInfo.split(",");
            if (strArrSplit2.length >= 2) {
                mediaInfo.mAudioDecoder = strArrSplit2[0];
                mediaInfo.mAudioDecoderImpl = strArrSplit2[1];
            } else if (strArrSplit2.length > 0) {
                mediaInfo.mAudioDecoder = strArrSplit2[0];
                mediaInfo.mAudioDecoderImpl = "";
            }
        }
        try {
            mediaInfo.mMeta = KsMediaMeta.parse(_getMediaMeta());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return mediaInfo;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final KsTrackInfo[] getTrackInfo() {
        KsMediaMeta ksMediaMeta;
        Bundle mediaMeta = getMediaMeta();
        if (mediaMeta == null || (ksMediaMeta = KsMediaMeta.parse(mediaMeta)) == null || ksMediaMeta.mStreams == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<KsMediaMeta.KSYStreamMeta> it = ksMediaMeta.mStreams.iterator();
        while (it.hasNext()) {
            KsMediaMeta.KSYStreamMeta next = it.next();
            KsTrackInfo ksTrackInfo = new KsTrackInfo(next);
            if (next.mType.equalsIgnoreCase("video")) {
                ksTrackInfo.setTrackType(1);
            } else if (next.mType.equalsIgnoreCase("audio")) {
                ksTrackInfo.setTrackType(2);
            }
            arrayList.add(ksTrackInfo);
        }
        return (KsTrackInfo[]) arrayList.toArray(new KsTrackInfo[arrayList.size()]);
    }

    private void notifyRepresentationChangeStart(int i, int i2) {
        IKwaiRepresentationListener iKwaiRepresentationListener = this.mKwaiRepresentationListener;
        if (iKwaiRepresentationListener != null) {
            iKwaiRepresentationListener.representationChangeStart(i, i2);
        }
    }

    private void notifyRepresentationChangeEnd(int i) {
        IKwaiRepresentationListener iKwaiRepresentationListener = this.mKwaiRepresentationListener;
        if (iKwaiRepresentationListener != null) {
            iKwaiRepresentationListener.representationChangeEnd(i);
        }
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public final void onReceivePostEvent(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i == 1) {
                notifyOnPrepared();
                return;
            }
            if (i == 2) {
                notifyOnCompletion();
                stayAwake(false);
                return;
            }
            if (i == 3) {
                notifyOnBufferingUpdate(message.arg1);
                return;
            }
            if (i == 4) {
                notifyOnSeekComplete();
                return;
            }
            if (i == 5) {
                int i2 = message.arg2;
                this.mVideoHeight = i2;
                if (this.mIsLive && this.mIsVR) {
                    this.mVideoWidth = (int) (i2 * 0.5625d);
                } else {
                    this.mVideoWidth = message.arg1;
                }
                notifyOnVideoSizeChanged(this.mVideoWidth, this.mVideoHeight, this.mVideoSarNum, this.mVideoSarDen);
                resizeVideo(this.mVideoWidth, this.mVideoHeight);
                return;
            }
            if (i != 99) {
                if (i == 100) {
                    Timber.e("MEDIA_ERROR, msg.arg1:%d, msg.arg2:%d", Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
                    if (!notifyOnError(message.arg1, message.arg2)) {
                        notifyOnCompletion();
                    }
                    stayAwake(false);
                    return;
                }
                if (i == 200) {
                    int i3 = message.arg1;
                    if (i3 == 701) {
                        this.mBufferingCount++;
                        this.mStartBufferingTime = System.currentTimeMillis();
                    } else if (i3 == 702) {
                        this.mTotalBufferingTime += (int) (System.currentTimeMillis() - this.mStartBufferingTime);
                    } else if (i3 == 10100) {
                        notifyOnSeekComplete();
                        return;
                    }
                    notifyOnInfo(message.arg1, message.arg2);
                    return;
                }
                if (i == 300) {
                    long j = (message.arg1 << 32) | message.arg2;
                    String kwaiLiveVoiceComment = getKwaiLiveVoiceComment(j);
                    Timber.i("MEDIA_LIVE_VC_TIME, vc_time:%d, voice_comment:%s", Long.valueOf(j), kwaiLiveVoiceComment);
                    IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener = this.mOnLiveVoiceCommentListener;
                    if (onLiveVoiceCommentListener != null) {
                        onLiveVoiceCommentListener.onLiveVoiceCommentChange(this, kwaiLiveVoiceComment);
                        return;
                    }
                    return;
                }
                if (i == 10001) {
                    this.mVideoSarNum = message.arg1;
                    int i4 = message.arg2;
                    this.mVideoSarDen = i4;
                    notifyOnVideoSizeChanged(this.mVideoWidth, this.mVideoHeight, this.mVideoSarNum, i4);
                    return;
                }
                if (i == 12001) {
                    notifyRepresentationChangeStart(message.arg1, message.arg2);
                } else if (i == 12002) {
                    notifyRepresentationChangeEnd(message.arg1);
                } else {
                    DebugLog.e(TAG, "Unknown message type " + message.what);
                }
            }
        }
    }

    final void setOnNativeInvokeListener(OnNativeInvokeListener onNativeInvokeListener) {
        this.mOnNativeInvokeListener = onNativeInvokeListener;
    }

    private static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        OnControlMessageListener onControlMessageListener;
        DebugLog.ifmt(TAG, "onNativeInvoke %d", Integer.valueOf(i));
        if (obj == null || !(obj instanceof WeakReference)) {
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        KwaiMediaPlayer kwaiMediaPlayer = (KwaiMediaPlayer) ((WeakReference) obj).get();
        if (kwaiMediaPlayer == null) {
            throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
        }
        OnNativeInvokeListener onNativeInvokeListener = kwaiMediaPlayer.mOnNativeInvokeListener;
        if (onNativeInvokeListener != null && onNativeInvokeListener.onNativeInvoke(i, bundle)) {
            return true;
        }
        if (i != 65536 || (onControlMessageListener = kwaiMediaPlayer.mOnControlMessageListener) == null) {
            return false;
        }
        int i2 = bundle.getInt("segment_index", -1);
        if (i2 < 0) {
            throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
        }
        String strOnControlResolveSegmentUrl = onControlMessageListener.onControlResolveSegmentUrl(i2);
        if (strOnControlResolveSegmentUrl == null) {
            throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
        }
        bundle.putString("url", strOnControlResolveSegmentUrl);
        return true;
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer, com.kwai.video.player.AbstractMediaPlayer
    public final void resetListeners() {
        super.resetListeners();
        _setProcessPCMBuffer(null);
        this.mProcessPCMBuffer = null;
        this.mKwaiRepresentationListener = null;
    }

    final void setupAspectNativeCache(boolean z) {
        this.mAspectAwesomeCache = new AspectAwesomeCache(this, z);
    }

    final void setEnableSegmentCache(boolean z) {
        setOption(4, "enable-segment-cache", z ? 1L : 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final AspectAwesomeCache getAspectAwesomeCache() {
        AspectAwesomeCache aspectAwesomeCache = this.mAspectAwesomeCache;
        if (aspectAwesomeCache != null) {
            return aspectAwesomeCache;
        }
        throw new NullPointerException("AspectAwesomeCache is not setup");
    }

    private void configHeaders(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        String str = map.get("Host");
        if (str != null) {
            setOption(4, "host", str);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            if (!TextUtils.isEmpty(entry.getValue())) {
                sb.append(entry.getValue());
            }
            sb.append("\r\n");
        }
        setOption(1, "headers", sb.toString());
    }

    private void configUserAgent() {
        String str = String.format("a/%s/%s/%s", KsMediaPlayerInitConfig.packageName, KsMediaPlayerInitConfig.packageVersion, getVersion());
        setOption(1, "user-agent", str);
        Timber.d("user-agent:%s", str);
    }

    final void reload(String str, boolean z) {
        _reload(str, z);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void stepFrame() {
        stayAwake(false);
        _step_frame();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final float getProbeFps() {
        return _getProbeFps();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setSpeed(float f) {
        _setSpeed(f);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final Bitmap getScreenShot() {
        int i;
        int i2 = this.mVideoWidth;
        if (i2 <= 0 || (i = this.mVideoHeight) <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.RGB_565);
        _getScreenShot(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setTag1(int i) {
        setOption(4, "tag1", i);
    }

    final void setHevcCodecName(String str) {
        _setHevcCodecName(str);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer, com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final boolean isMediaPlayerValid() {
        return _isMediaPlayerValid();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final boolean checkCanStartPlay() {
        return _checkCanStartPlay();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final int getDownloadedPercent() {
        return _getDownloadedPercent();
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final String getKwaiSign() {
        return _getKwaiSign();
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final String getXksCache() {
        return _getXksCache();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setVideoScalingMode(int i) {
        _setVideoScalingMode(i);
    }

    public final boolean setRotateDegree(int i) {
        return _setRotateDegree(i);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setEnableAudioSpectrum(boolean z) {
        setOption(4, "enable-audio-spectrum", z ? 1L : 0L);
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public final void enableVideoRawDataCallback(boolean z) {
        _enableVideoRawDataCallback(z);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void addVideoRawBuffer(byte[] bArr) {
        _addVideoRawBuffer(bArr);
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public final void initProcessPCMBuffer() {
        if (this.mProcessPCMBuffer == null) {
            int i_getPropertyLong = (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_BUF_SIZE, 0L);
            if (i_getPropertyLong <= 0) {
                this.mProcessPCMBuffer = ByteBuffer.allocate(176000);
            } else {
                this.mProcessPCMBuffer = ByteBuffer.allocate(i_getPropertyLong * 2);
            }
        }
        _setProcessPCMBuffer(this.mProcessPCMBuffer);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setLastTryFlag(boolean z) {
        _setLastTryFlag(z ? 1 : 0);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setCencKey(String str) {
        setOption(1, "decryption_key", str);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void enableLoopOnBlock(int i, int i2, long j) {
        _enableLoopOnBlock(i, i2, j);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final String getVodStatJson() {
        return _getVideoStatJson();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final String getBriefVodStatJson() {
        return _getBriefVideoStatJson();
    }

    final void setIsVodAdaptive(boolean z) {
        this.mIsVodAdaptive = z;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final String getVodAdaptiveUrl() {
        return _getVodAdaptiveUrl();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final String getVodAdaptiveCacheKey() {
        return _getVodAdaptiveCacheKey();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final int getVodAdaptiveRepID() {
        return (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_VOD_ADAPTIVE_REP_ID, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final String getVodAdaptiveHostName() {
        return _getVodAdaptiveHostName();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setIndexContent(String str, String str2, String str3, Map<String, String> map) {
        this.mDataSource = str;
        configHeaders(map);
        configUserAgent();
        _setDataSource(str, null, null);
        setOption(4, "input-data-type", 2L);
        setOption(4, "index-content.pre_path", str2);
        setOption(4, "index-content.content", str3);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setKwaiManifest(String str, String str2, Map<String, String> map) {
        this.mDataSource = str;
        configHeaders(map);
        configUserAgent();
        _setDataSource(str, null, null);
        setOption(4, "input-data-type", 3L);
        setOption(4, "index-content.content", str2);
    }

    final void setIsLive(boolean z) {
        this.mIsLive = z;
    }

    final void setupAspectLiveRealTimeReporter(boolean z, KwaiPlayerConfig kwaiPlayerConfig) {
        if (z) {
            AppQosLiveRealtimeWrapper appQosLiveRealtimeWrapper = new AppQosLiveRealtimeWrapper(this, kwaiPlayerConfig.getEnableQos());
            this.mAppQosLiveRealtimeWrapper = appQosLiveRealtimeWrapper;
            appQosLiveRealtimeWrapper.setTickDurationMs(kwaiPlayerConfig.getQosDuration());
            AppQosLiveAdaptiveRealtimeWrapper appQosLiveAdaptiveRealtimeWrapper = new AppQosLiveAdaptiveRealtimeWrapper(this, kwaiPlayerConfig.getEnableLiveAdaptiveQos());
            this.mAppQosLiveAdaptiveRealtimeWrapper = appQosLiveAdaptiveRealtimeWrapper;
            appQosLiveAdaptiveRealtimeWrapper.setEnableLiveAdaptiveAdditionalQosStat(kwaiPlayerConfig.getEnableLiveAdaptiveAdditionalQos());
            this.mAppQosLiveAdaptiveRealtimeWrapper.setTickDurationMs(kwaiPlayerConfig.getLiveAdaptiveQosDuration());
            return;
        }
        this.mAppQosLiveRealtimeWrapper = new AppQosLiveRealtimeWrapper(this, false);
        this.mAppQosLiveAdaptiveRealtimeWrapper = new AppQosLiveAdaptiveRealtimeWrapper(this, false);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setAppQosStatJson(JSONObject jSONObject) {
        _setLiveAppQosInfo(jSONObject.toString());
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void stopLiveStatTimerImmediately() {
        this.mAppQosLiveRealtimeWrapper.stop();
        this.mAppQosLiveAdaptiveRealtimeWrapper.stop();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setLiveOnQosStatListener(IMediaPlayer.OnQosStatListener onQosStatListener) {
        this.mAppQosLiveRealtimeWrapper.setOnQosStatListener(onQosStatListener);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setOnLiveInterActiveListener(IKwaiMediaPlayer.OnLiveInterActiveListener onLiveInterActiveListener) {
        if (onLiveInterActiveListener != null) {
            _setOnLiveInterActiveListener(new WeakReference(onLiveInterActiveListener));
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final int bufferEmptyCountOld() {
        return this.mBufferingCount;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long bufferEmptyDurationOld() {
        return this.mTotalBufferingTime;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setLiveManifestSwitchMode(int i) {
        _setLiveManifestSwitchMode(i);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setLiveOnPeriodicalLiveAdaptiveQosStatListener(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener) {
        this.mAppQosLiveAdaptiveRealtimeWrapper.setOnPeriodicalLiveAdaptiveQosStatListener(onLiveAdaptiveQosStatListener);
    }

    final void setupAspectKlv(boolean z) {
        this.mAspectKFlv = new AspectKFlv(this, z);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final AspectKFlv getAspectKFlv() {
        AspectKFlv aspectKFlv = this.mAspectKFlv;
        if (aspectKFlv != null) {
            return aspectKFlv;
        }
        throw new NullPointerException("AspectKFlv is not setup");
    }

    final void setupAspectKwaiVodAdaptive(boolean z) {
        this.mVodAdaptive = new AspectKwaiVodAdaptive(this, z);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final AspectKwaiVodAdaptive getAspectVodAdaptive() {
        AspectKwaiVodAdaptive aspectKwaiVodAdaptive = this.mVodAdaptive;
        if (aspectKwaiVodAdaptive != null) {
            return aspectKwaiVodAdaptive;
        }
        throw new NullPointerException("AspectKwaiVodAdaptive is not setup");
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void audioOnly(boolean z) {
        _audioOnly(z);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void disableSoftVideoDecode(boolean z) {
        _disableSoftVideoDecode(z);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setOnLiveVoiceCommentListener(IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener) {
        this.mOnLiveVoiceCommentListener = onLiveVoiceCommentListener;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final String getKwaiLiveVoiceComment(long j) {
        return _getKwaiLiveVoiceComment(j);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void updateCurrentWallClock(long j) {
        _updateCurrentWallClock(j);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void updateCurrentMaxWallClockOffset(long j) {
        _updateCurrentMaxWallClockOffset(j);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer, com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final String getLiveRealTimeQosJson(int i, int i2, long j, long j2, long j3) {
        return _getLiveRealTimeQosJson(i, i2, j, j2, j3);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final boolean isLiveManifest() {
        return this.mAspectKFlv.isLiveManifest();
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    @Deprecated
    public final String getKflvVideoPlayingUrl() {
        return getCurPlayingUrl();
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final AppLiveAdaptiveRealtimeInfo getAppLiveAdaptiveRealtimeInfo() {
        return AppLiveAdaptiveRealtimeInfo.from(_getAppLiveAdaptiveRealtimeInfo());
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final String getLiveStatJson() {
        return _getLiveStatJson();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer, com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final KwaiQosInfo getStreamQosInfo() {
        return KwaiQosInfo.fromBundle(_getQosInfo());
    }

    final void setConfig(KwaiPlayerConfig kwaiPlayerConfig) {
        if (kwaiPlayerConfig == null) {
            throw new IllegalStateException("method invoking failed pConfig ==null !");
        }
        setOption(4, "first-high-water-mark-ms", kwaiPlayerConfig.getFirstBufferTime());
        setOption(4, "next-high-water-mark-ms", kwaiPlayerConfig.getMinBufferTime());
        setOption(4, "last-high-water-mark-ms", kwaiPlayerConfig.getMaxBufferTime());
        setOption(4, "buffer-strategy", kwaiPlayerConfig.getBufferStrategy().getValue());
        setOption(4, "buffer-increment-step", kwaiPlayerConfig.getBufferIncrementStep());
        setOption(4, "buffer-smooth-time", kwaiPlayerConfig.getBufferSmoothTime());
        setOption(4, "max-buffer-dur-ms", kwaiPlayerConfig.getMaxBufferDuration());
    }

    @Override // com.kwai.player.debuginfo.KwaiPlayerDebugInfoProvider
    public final KwaiPlayerDebugInfo getDebugInfo() {
        if (TextUtils.isEmpty(this.mKwaiPlayerDebugInfo.mSdkVersion)) {
            this.mKwaiPlayerDebugInfo.mSdkVersion = getVersion();
        }
        if (!this.mKwaiPlayerDebugInfo.mPlayerApplyConfig.collectFinish) {
            _getPlayerConfigDebugInfo(this.mKwaiPlayerDebugInfo.mPlayerApplyConfig);
        }
        this.mKwaiPlayerDebugInfo.setIsLive(this.mIsLive);
        if (this.mIsLive) {
            if (this.mKwaiPlayerDebugInfo.mAppLiveQosDebugInfoNew == null) {
                this.mKwaiPlayerDebugInfo.mAppLiveQosDebugInfoNew = new AppLiveQosDebugInfoNew();
            }
            _getAppLiveQosDebugInfoNew(this.mKwaiPlayerDebugInfo.mAppLiveQosDebugInfoNew);
            this.mKwaiPlayerDebugInfo.mAppLiveQosDebugInfoNew.setWidth(getVideoWidth());
            this.mKwaiPlayerDebugInfo.mAppLiveQosDebugInfoNew.setHeight(getVideoHeight());
        } else {
            if (this.mKwaiPlayerDebugInfo.mAppVodQosDebugInfo == null) {
                this.mKwaiPlayerDebugInfo.mAppVodQosDebugInfo = new AppVodQosDebugInfoNew();
            }
            _getAppVodQosDebugInfoNew(this.mKwaiPlayerDebugInfo.mAppVodQosDebugInfo);
        }
        return this.mKwaiPlayerDebugInfo;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final AppLiveQosDebugInfo getAppLiveQosDebugInfo() {
        return AppLiveQosDebugInfo.from(_getAppLiveQosDebugInfo());
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final float getSpeed(float f) {
        return _getPropertyFloat(10003, 0.0f);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getDecodedDataSize() {
        return _getPropertyLong(PlayerProps.PROP_LONG_DECODED_SIZE, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getDownloadDataSize() {
        return _getPropertyLong(PlayerProps.PROP_LONG_DOWNLOAD_SIZE, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getDtsDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DTS_DURATION, 0L);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final String getServerAddress() {
        return _getPropertyString(PlayerProps.PROP_STRING_SERVER_IP);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public final String getStreamId() {
        return _getPropertyString(PlayerProps.FFP_PROP_STRING_STREAM_ID);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getVideoDecErrorCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_DEC_ERROR_COUNT, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getDroppedDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DROPPED_DURATION, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getReadVideoFrameCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_READ_VIDEO_FRAME_COUNT, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getDecodeVideoFrameCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DECODED_VIDEO_FRAME_COUNT, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getDisplayFrameCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DISPLAYED_FRAME_COUNT, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getSourceDeviceType() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_SOURCE_DEVICE_TYPE, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final float getAverageDisplayFps() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_AVERAGE_DISPLAYED_FPS, 0.0f);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final float getAudioRawLatencySeconds() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_AUDIO_RAW_LATENCY_SECONDS, 0.0f);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    @Deprecated
    public final int bufferEmptyCount() {
        return (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_BLOCKCNT, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    @Deprecated
    public final long bufferEmptyDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_BUFFERTIME, 0L);
    }

    @Deprecated
    public final long getCpuUsage() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_CPU, 0L);
    }

    @Deprecated
    public final long getMemorySize() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_MEMORY, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getBitrate() {
        return _getPropertyLong(20100, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final float getVideoAvgFps() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_VIDEO_AVG_FPS, 0.0f);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getDecodedVideoWidth() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_WIDTH, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getDecodedVideoHeight() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_HEIGHT, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final long getCurAbsTime() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_CURRENT_ABSOLUTE_TIME, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final float getBufferTimeMax() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_BUFFERSIZE_MAX, 0.0f);
    }

    @Deprecated
    final boolean isCacheEnabled() {
        return _isCacheEnabled();
    }

    final void setCodecFlag(int i) {
        if (i <= 0) {
            Log.w(TAG, "unsupported codec flag :0,replace the codec flag :0");
            i = 0;
        }
        _setCodecFlag(i);
    }

    public static String getColorFormatName(int i) {
        return _getColorFormatName(i);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setPlayerMute(boolean z) {
        _setPlayerMute(z ? 1 : 0);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setKwaiRepresentationListener(IKwaiRepresentationListener iKwaiRepresentationListener) {
        this.mKwaiRepresentationListener = iKwaiRepresentationListener;
        _setRepresentationListener(new WeakReference(this.mKwaiRepresentationListener));
    }

    @Deprecated
    private void setOnControlMessageListener(OnControlMessageListener onControlMessageListener) {
        this.mOnControlMessageListener = onControlMessageListener;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.mSurfaceHolder = null;
        _setSurfaceTexture(surfaceTexture);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void enableAudioMono(int i) {
        setOption(4, "audio-mono-type", i);
    }

    public final void setIsVR(boolean z) {
        this.mIsVR = z;
        setVR();
    }

    public final void setContext(Context context) {
        this.mContext = context;
    }

    public final void setStereoType(int i) {
        this.mStereoType = i;
    }

    public final void setAudioChannelMode(int i) {
        this.mAudioChannelMode = i;
    }

    public final void setVR() {
        if (this.mIsVR) {
            KwaiVR kwaiVRBuild = KwaiVR.builder().setInteractive(this.mInteractivemode).setPinchEnabled(true).setContext(this.mContext).setStereoType(this.mStereoType).build();
            this.mKwaiVR = kwaiVRBuild;
            if (!kwaiVRBuild.isSupport()) {
                Log.e(TAG, "setVR: not support stereoType" + this.mStereoType);
                return;
            }
            SurfaceTextureRenderer surfaceTextureRenderer = new SurfaceTextureRenderer(this.mContext);
            this.mSurfaceTextureRender = surfaceTextureRenderer;
            surfaceTextureRenderer.init();
            this.mSurfaceTextureRender.createTexture();
            this.mSurfaceTextureRender.setKwaiVR(this.mKwaiVR);
            if (this.mAudioChannelMode == 2) {
                this.mSurfaceTextureRender.setHeadTrackerListener(new IHeadTrackerListener() { // from class: com.kwai.video.player.kwai_player.KwaiMediaPlayer.2
                    @Override // com.kwai.video.player.kwai_player.KwaiMediaPlayer.IHeadTrackerListener
                    public void onHeadTracker(float f, float f2, float f3) {
                        KwaiMediaPlayer.this.setHeadTracker(f, f2, f3);
                    }
                });
            }
            setOption(4, "video-stereo-type", this.mStereoType);
            setOption(4, "audio-channel-mode", this.mAudioChannelMode);
        }
    }

    public final Surface openSurface() {
        SurfaceTextureRenderer surfaceTextureRenderer = this.mSurfaceTextureRender;
        if (surfaceTextureRenderer != null) {
            try {
                return surfaceTextureRenderer.getSurface();
            } catch (Exception unused) {
                this.mSurfaceTextureRender.release();
                this.mSurfaceTextureRender = null;
            }
        }
        return null;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void setInteractiveMode(int i) {
        this.mInteractivemode = i;
        KwaiVR kwaiVR = this.mKwaiVR;
        if (kwaiVR != null) {
            kwaiVR.setInteractiveMode(i);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final boolean handleTouchEvent(MotionEvent motionEvent) {
        KwaiVR kwaiVR = this.mKwaiVR;
        if (kwaiVR != null) {
            return kwaiVR.handleTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final int getOrientaionDegree() {
        KwaiVR kwaiVR = this.mKwaiVR;
        if (kwaiVR != null) {
            return kwaiVR.getOrientaionDegrees();
        }
        return 0;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void registerSensorEvent() {
        KwaiVR kwaiVR = this.mKwaiVR;
        if (kwaiVR != null) {
            kwaiVR.registerSensorEvent();
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public final void unRegisterSensorEvent() {
        KwaiVR kwaiVR = this.mKwaiVR;
        if (kwaiVR != null) {
            kwaiVR.unRegisterSensorEvent();
        }
    }

    public final void resizeVideo(int i, int i2) {
        SurfaceTextureRenderer surfaceTextureRenderer = this.mSurfaceTextureRender;
        if (surfaceTextureRenderer != null) {
            surfaceTextureRenderer.resizeVideo(i, i2);
        }
    }

    public final void stopDrawLoopTimer() {
        SurfaceTextureRenderer surfaceTextureRenderer = this.mSurfaceTextureRender;
        if (surfaceTextureRenderer != null) {
            surfaceTextureRenderer.stopDrawFrameLoop();
        }
    }

    public final void setHeadTracker(float f, float f2, float f3) {
        _setHeadTracker(f, f2, f3);
    }
}
