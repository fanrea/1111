package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.component.feed.a;
import com.kwai.player.OnPlayerReleaseListener;
import com.kwai.player.qos.KwaiPlayerResultQos;
import com.kwai.video.cache.AcCallBackInfo;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.ksvodplayerkit.HttpDns.HostSwitcher;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodPlayerBuilder;
import com.kwai.video.ksvodplayerkit.Logger.KSVodLogger;
import com.kwai.video.ksvodplayerkit.Logger.KSVodPlayerLogUploader;
import com.kwai.video.ksvodplayerkit.MultiRate.HlsAdaptationModel;
import com.kwai.video.ksvodplayerkit.MultiRate.HlsAdaptationModel_JsonUtils;
import com.kwai.video.ksvodplayerkit.MultiRate.HlsRepresentation;
import com.kwai.video.ksvodplayerkit.MultiRate.KwaiMediaManifest_JsonUtils;
import com.kwai.video.ksvodplayerkit.MultiRate.VideoAdaptationModel_JsonUtils;
import com.kwai.video.ksvodplayerkit.Utils.NetworkUtils;
import com.kwai.video.ksvodplayerkit.Utils.VodMediaCodecConfig;
import com.kwai.video.ksvodplayerkit.Utils.VodPlayerUtils;
import com.kwai.video.ksvodplayerkit.prefetcher.KSPrefetcher;
import com.kwai.video.ksvodplayerkit.prefetcher.PrefetchReportInfo;
import com.kwai.video.ksvodplayerkit.prefetcher.PrefetchReportInfo_JsonUtils;
import com.kwai.video.kwaiplayer_debug_tools.debuginfo.KwaiPlayerDebugInfoView;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.PlayerSettingConstants;
import com.kwai.video.player.kwai_player.AspectAwesomeCache;
import com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder;
import com.kwai.video.player.kwai_player.KwaiPlayerVodBuilder;
import com.kwai.video.player.kwai_player.ProductContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSVodPlayer implements IKSVodPlayer {
    private static final String SDK_NAME = "KSVodPlayerKit";
    private static final String TAG = "KSVodPlayer";
    private AwesomeCacheListener mAwesomeCacheListener;
    private KSVodPlayerBuilder mBuilder;
    private CacheListener mCacheSessionListener;
    private long mCallPrepareTimestamp;
    private long mCallStartTimestamp;
    private IKwaiMediaPlayer mCurrentPlayer;
    private Map<String, String> mHeaders;
    private HostSwitcher mHostSwitcher;
    private boolean mLoop;
    private IKwaiMediaPlayer mNextPlayer;
    private IKSVodPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private IKSVodPlayer.OnErrorListener mOnErrorListener;
    private IKSVodPlayer.OnEventListener mOnEventListener;
    private IKSVodPlayer.OnPreparedListener mOnPreparedListener;
    private HlsRepresentation mPreferRepresentation;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private String mUrl;
    private IKSVodPlayer.OnVideoSizeChangedListener mVideoSizeChangedListener;
    KwaiPlayerDebugInfoView mVodDebugInfoView;
    private final Object mLock = new Object();
    private int mScalingMode = 0;
    private long mRealFirstScreenTime = -1;
    private boolean mIsPaused = true;
    private float mLeftVolume = 1.0f;
    private float mRightVolume = 1.0f;
    private boolean mIsUserSeeking = false;
    private boolean mIsPlayToEnd = false;
    private AtomicInteger mState = new AtomicInteger();
    private boolean mIsEnableCronet = false;
    private AtomicInteger mRetryCount = new AtomicInteger();
    private boolean mIsReported = false;
    private IMediaPlayer.OnSeekCompleteListener mKwaiOnSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.kwai.video.ksvodplayerkit.KSVodPlayer.1
        @Override // com.kwai.video.player.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            if (KSVodPlayer.this.mOnEventListener != null) {
                KSVodPlayer.this.mOnEventListener.onEvent(10100, 0);
            }
        }
    };
    private IMediaPlayer.OnInfoListener mKwaiOnInfoListener = new IMediaPlayer.OnInfoListener() { // from class: com.kwai.video.ksvodplayerkit.KSVodPlayer.2
        @Override // com.kwai.video.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (i == 3) {
                synchronized (KSVodPlayer.this.mLock) {
                    if (KSVodPlayer.this.mBuilder.mVideoContext != null) {
                        KSVodPlayer.this.mRealFirstScreenTime = System.currentTimeMillis() - KSVodPlayer.this.mBuilder.mVideoContext.mClickTime;
                    }
                }
                if (KSVodPlayer.this.mOnEventListener != null) {
                    KSVodPlayer.this.mOnEventListener.onEvent(KSVodConstants.KSVOD_PLAYER_INFO_PLAY_STARTED, 0);
                }
                i = 3;
            } else if (i == 10101) {
                if (KSVodPlayer.this.mState.get() != 6 && KSVodPlayer.this.mOnEventListener != null) {
                    KSVodPlayer.this.mOnEventListener.onEvent(KSVodConstants.KSVOD_PLAYER_INFO_PLAY_FINISHED, 0);
                    KSVodPlayer.this.mIsPlayToEnd = true;
                }
                KSVodPlayer.this.mState.set(6);
                i = 10101;
            } else if (i == 10103) {
                KSVodPlayer.this.mIsPaused = i2 == 5;
                if (i2 == 6 && KSVodPlayer.this.mState.get() != 6) {
                    if (KSVodPlayer.this.mOnEventListener != null) {
                        KSVodPlayer.this.mOnEventListener.onEvent(KSVodConstants.KSVOD_PLAYER_INFO_PLAY_FINISHED, 0);
                    }
                    KSVodPlayer.this.mIsPlayToEnd = true;
                }
                KSVodPlayer.this.mState.set(i2);
            } else if (i == 701) {
                i = 701;
            } else if (i != 702) {
                switch (i) {
                    case 10001:
                        i = 10001;
                        break;
                    case 10002:
                        i = 10002;
                        break;
                    case 10003:
                        i = 10003;
                        if (!KSVodPlayer.this.mIsUserSeeking && KSVodPlayer.this.mIsPlayToEnd && KSVodPlayer.this.mOnEventListener != null) {
                            KSVodPlayer.this.mOnEventListener.onEvent(KSVodConstants.KSVOD_PLAYER_INFO_PLAY_STARTED, 0);
                            KSVodPlayer.this.mIsPlayToEnd = false;
                        }
                        KSVodPlayer.this.mIsUserSeeking = false;
                        break;
                    case 10004:
                        i = 10004;
                        break;
                }
            } else {
                i = 702;
            }
            if (KSVodPlayer.this.mOnEventListener != null) {
                KSVodPlayer.this.mOnEventListener.onEvent(i, i2);
            }
            return false;
        }
    };
    private IMediaPlayer.OnErrorListener mKwaiOnErrorListener = new IMediaPlayer.OnErrorListener() { // from class: com.kwai.video.ksvodplayerkit.KSVodPlayer.3
        @Override // com.kwai.video.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            boolean zRetryOnErrorIfNeed;
            KSVodPlayer.this.mState.set(9);
            if (i == -23120 && i2 == -3120) {
                zRetryOnErrorIfNeed = KSVodPlayer.this.retryOnErrorIfNeed();
                Log.e(KSVodPlayer.TAG, "onError what: " + i + " extra: " + i2 + " retry: " + zRetryOnErrorIfNeed + " retryCount: " + KSVodPlayer.this.mRetryCount.get());
            } else {
                zRetryOnErrorIfNeed = false;
            }
            if (KSVodPlayer.this.mOnErrorListener != null && !zRetryOnErrorIfNeed) {
                KSVodPlayer.this.mOnErrorListener.onError(i, i2);
            }
            return false;
        }
    };
    private IMediaPlayer.OnPreparedListener mKwaiOnPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: com.kwai.video.ksvodplayerkit.KSVodPlayer.4
        @Override // com.kwai.video.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            boolean z;
            if (KSVodPlayer.this.mState.get() == 9) {
                return;
            }
            synchronized (KSVodPlayer.this.mLock) {
                if (KSVodPlayer.this.mNextPlayer == null || KSVodPlayer.this.mCurrentPlayer == null) {
                    z = false;
                } else {
                    if (!KSVodPlayer.this.mIsPaused && KSVodPlayer.this.mBuilder.mRetryAutoPlay) {
                        KSVodPlayer.this.mCurrentPlayer.start();
                    }
                    KSVodPlayer.this.mNextPlayer = null;
                    if (KSVodPlayer.this.mSurface != null) {
                        KSVodPlayer.this.mCurrentPlayer.setSurface(KSVodPlayer.this.mSurface);
                    }
                    if (KSVodPlayer.this.mSurfaceHolder != null) {
                        KSVodPlayer.this.mCurrentPlayer.setDisplay(KSVodPlayer.this.mSurfaceHolder);
                    }
                    z = true;
                    if (KSVodPlayer.this.mVodDebugInfoView != null && KSVodPlayerConfig.get().isEnableDebugInfo()) {
                        KSVodPlayer.this.mVodDebugInfoView.stopMonitor();
                        KSVodPlayer.this.mVodDebugInfoView.startMonitor(KSVodPlayer.this.mCurrentPlayer);
                    }
                }
            }
            if (z || KSVodPlayerConfig.get().isRecordHistory() || KSVodPlayer.this.mBuilder.mUrlType == 2) {
                String currentPlayCDNUrl = KSVodPlayer.this.mUrl;
                if (KSVodPlayer.this.mHostSwitcher != null && KSVodPlayer.this.mHostSwitcher.getCurrentPlayCDNUrl() != null) {
                    currentPlayCDNUrl = KSVodPlayer.this.mHostSwitcher.getCurrentPlayCDNUrl();
                }
                long playPosition = KSVodPlayStatManager.getInstance().getPlayPosition(currentPlayCDNUrl);
                if (playPosition > 0) {
                    KSVodLogger.d(KSVodPlayer.TAG, "createKwaiMediaPlayer use record history progress, seekto:" + playPosition);
                    KSVodPlayer.this.mCurrentPlayer.seekTo(playPosition);
                }
            }
            if (z && KSVodPlayer.this.mOnEventListener != null) {
                KSVodPlayer.this.mOnEventListener.onEvent(KSVodConstants.KSVOD_PLAYER_INFO_HOST_SWITCH_END, 0);
            }
            if (KSVodPlayer.this.mOnPreparedListener != null && (!z || KSVodPlayer.this.mState.get() <= 2)) {
                KSVodPlayer.this.mState.set(3);
                KSVodPlayer.this.mOnPreparedListener.onPrepared();
            }
            KSVodPlayer.this.mState.set(3);
        }
    };
    private IMediaPlayer.OnVideoSizeChangedListener mKwaiOnVideoSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.kwai.video.ksvodplayerkit.KSVodPlayer.5
        @Override // com.kwai.video.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            if (KSVodPlayer.this.mVideoSizeChangedListener != null) {
                KSVodPlayer.this.mVideoSizeChangedListener.onVideoSizeChanged(i, i2, i3, i4);
            }
        }
    };
    private IMediaPlayer.OnBufferingUpdateListener mKwaiOnBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.kwai.video.ksvodplayerkit.KSVodPlayer.6
        @Override // com.kwai.video.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            if (KSVodPlayer.this.mOnBufferingUpdateListener != null) {
                KSVodPlayer.this.mOnBufferingUpdateListener.onBufferingUpdate(i);
            }
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class VideoContext {
        public long mClickTimeStamp;
        public long mClickToFirstFrame;
        public String mEnterAction;
        public String mExtra;
        public long mPrepareTimestamp;
        public long mStartTimestamp;
        public String mVideoId;
        public String mVideoProfile;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void enableAegon(boolean z) {
    }

    public KSVodPlayer(KSVodPlayerBuilder kSVodPlayerBuilder) {
        this.mState.set(0);
        this.mBuilder = kSVodPlayerBuilder;
        this.mUrl = kSVodPlayerBuilder.mUrl;
        this.mHeaders = this.mBuilder.mHeaders;
        this.mRetryCount.set(0);
        if (TextUtils.isEmpty(this.mUrl) && ((this.mBuilder.mUrlList == null || this.mBuilder.mUrlList.isEmpty() || TextUtils.isEmpty(this.mBuilder.mUrlList.get(0))) && (this.mBuilder.mVodAdaptationModel == null || this.mBuilder.mVodAdaptationModel.vodAdaptationSets == null || this.mBuilder.mVodAdaptationModel.vodAdaptationSets.isEmpty()))) {
            throw new IllegalArgumentException("Wrong Input Arguments! Play url can't be null!");
        }
        if (this.mHeaders == null) {
            this.mHeaders = new HashMap();
        }
        if (this.mBuilder.mExtraHeaders != null) {
            this.mHeaders.putAll(this.mBuilder.mExtraHeaders);
        }
        if (this.mBuilder.mUrlType == 1 && this.mBuilder.mVodAdaptationModel != null) {
            HostSwitcher hostSwitcher = new HostSwitcher(this.mBuilder.mVodAdaptationModel);
            this.mHostSwitcher = hostSwitcher;
            try {
                this.mUrl = VideoAdaptationModel_JsonUtils.toJson(hostSwitcher.getModel());
            } catch (Exception e) {
                KSVodLogger.e(TAG, "Wrong Input Arguments", e);
            }
            this.mUrl = VideoAdaptationModel_JsonUtils.toJson(this.mHostSwitcher.getModel());
        } else if (this.mBuilder.mUrlType == 2) {
            HostSwitcher hostSwitcher2 = new HostSwitcher(this.mUrl);
            this.mHostSwitcher = hostSwitcher2;
            HlsAdaptationModel hlsManifestModel = hostSwitcher2.getHlsManifestModel();
            try {
                this.mUrl = HlsAdaptationModel_JsonUtils.toJson(hlsManifestModel);
            } catch (Exception e2) {
                KSVodLogger.e(TAG, "Wrong Input Arguments", e2);
            }
            this.mHeaders.put("Host", hlsManifestModel.host);
        } else if (this.mBuilder.mUrlType == 3) {
            HostSwitcher hostSwitcher3 = new HostSwitcher(this.mUrl, 3);
            this.mHostSwitcher = hostSwitcher3;
            try {
                this.mUrl = KwaiMediaManifest_JsonUtils.toJson(hostSwitcher3.getKwaiManifestModel());
            } catch (Exception e3) {
                KSVodLogger.e(TAG, "Wrong Input Arguments", e3);
            }
        } else {
            String str = this.mUrl;
            str = str == null ? this.mBuilder.mUrlList.get(0) : str;
            this.mUrl = str;
            if (VodPlayerUtils.isNetworkPlayUrl(str) && !KSVodPlayStatManager.getInstance().getCacheStatus(this.mUrl)) {
                ArrayList arrayList = new ArrayList();
                if (this.mBuilder.mUrlList != null && !this.mBuilder.mUrlList.isEmpty()) {
                    arrayList.addAll(this.mBuilder.mUrlList);
                } else {
                    arrayList.add(this.mUrl);
                }
                HostSwitcher hostSwitcher4 = new HostSwitcher(arrayList);
                this.mHostSwitcher = hostSwitcher4;
                if (hostSwitcher4.getCurrent() != null && !TextUtils.isEmpty(this.mHostSwitcher.getCurrent().mUrl)) {
                    this.mUrl = this.mHostSwitcher.getCurrent().mUrl;
                    this.mHeaders.put("Host", this.mHostSwitcher.getCurrentHost());
                }
            }
        }
        if (this.mUrl == null) {
            KSVodLogger.e(TAG, "Wrong Input Arguments", new Exception("new KSVodPlayer"));
        }
        this.mCurrentPlayer = createKwaiMediaPlayer(this.mBuilder.builder());
        this.mState.set(1);
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setDataSource(String str, Map<String, String> map) {
        throw new UnsupportedOperationException("KSVodPlayer does not support this call for now");
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public int prepareAsync() {
        synchronized (this.mLock) {
            if (this.mCurrentPlayer == null || !(this.mState.get() == 1 || this.mState.get() == 7)) {
                KSVodLogger.e(TAG, "prepareAsync error, playback state:" + this.mState.get() + ",mCurrentPlayer == null:" + (this.mCurrentPlayer == null), new Exception("prepareAsync"));
                return -1;
            }
            if (this.mCallPrepareTimestamp == 0) {
                this.mCallPrepareTimestamp = System.currentTimeMillis();
            }
            KSVodLogger.d(TAG, "prepareAsync");
            this.mState.set(2);
            this.mCurrentPlayer.prepareAsync();
            if (this.mBuilder.mVodAdaptationModel != null || this.mBuilder.mUrlType == 3) {
                this.mHostSwitcher.setCurrentPlayCDNUrl(this.mCurrentPlayer.getVodAdaptiveUrl());
                if (KSVodPlayerConfig.get().isRecordHistory()) {
                    long playPosition = KSVodPlayStatManager.getInstance().getPlayPosition(this.mCurrentPlayer.getVodAdaptiveUrl());
                    if (playPosition > 0) {
                        KSVodLogger.d(TAG, "prepareAsync, multi rate use history play progress");
                        this.mCurrentPlayer.seekTo(playPosition);
                    }
                }
            }
            return 0;
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setSurface(Surface surface) {
        synchronized (this.mLock) {
            this.mSurface = surface;
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer != null) {
                iKwaiMediaPlayer.setSurface(surface);
            }
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            return;
        }
        synchronized (this.mLock) {
            this.mSurfaceHolder = surfaceHolder;
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer != null) {
                iKwaiMediaPlayer.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public boolean isPlaying() {
        synchronized (this.mLock) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer == null) {
                return false;
            }
            return iKwaiMediaPlayer.isPlaying();
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public boolean isPrepared() {
        return this.mState.get() == 3;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public long getCurrentPosition() {
        synchronized (this.mLock) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer == null) {
                return 0L;
            }
            return iKwaiMediaPlayer.getCurrentPosition();
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public long getDuration() {
        synchronized (this.mLock) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer == null) {
                return -1L;
            }
            return iKwaiMediaPlayer.getDuration();
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public String getCurrentPlayUrl() {
        HostSwitcher hostSwitcher = this.mHostSwitcher;
        if (hostSwitcher != null) {
            return hostSwitcher.getCurrentPlayCDNUrl();
        }
        return this.mUrl;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void start() {
        synchronized (this.mLock) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer != null && !iKwaiMediaPlayer.isPlaying()) {
                if (this.mCallStartTimestamp == 0) {
                    this.mCallStartTimestamp = System.currentTimeMillis();
                }
                if (this.mVodDebugInfoView != null && KSVodPlayerConfig.get().isEnableDebugInfo()) {
                    this.mVodDebugInfoView.startMonitor(this.mCurrentPlayer);
                }
                KSVodLogger.d(TAG, "start");
                this.mCurrentPlayer.start();
            }
        }
        if (KSVodNativeCache.isFullyCached(this.mUrl)) {
            notifyCanPreloadNext();
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void seekTo(long j) {
        synchronized (this.mLock) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer != null) {
                this.mIsUserSeeking = true;
                iKwaiMediaPlayer.seekTo(j);
            }
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setLooping(boolean z) {
        synchronized (this.mLock) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer != null) {
                this.mLoop = z;
                iKwaiMediaPlayer.setLooping(z);
            }
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setVolume(float f, float f2) {
        synchronized (this.mLock) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer != null) {
                iKwaiMediaPlayer.setVolume(f, f2);
            }
            this.mLeftVolume = f;
            this.mRightVolume = f2;
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void updateVideoContext(KSVodVideoContext kSVodVideoContext) {
        synchronized (this.mLock) {
            this.mBuilder.mVideoContext = kSVodVideoContext;
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void pause() {
        synchronized (this.mLock) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer != null && iKwaiMediaPlayer.isPlaying()) {
                KSVodLogger.d(TAG, "pause");
                this.mCurrentPlayer.pause();
            }
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void stop() {
        synchronized (this.mLock) {
            KSVodLogger.d(TAG, a.e);
            KSVodPlayStatManager kSVodPlayStatManager = KSVodPlayStatManager.getInstance();
            HostSwitcher hostSwitcher = this.mHostSwitcher;
            String currentPlayCDNUrl = hostSwitcher != null ? hostSwitcher.getCurrentPlayCDNUrl() : null;
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            kSVodPlayStatManager.updatePlayPosition(currentPlayCDNUrl, iKwaiMediaPlayer != null ? iKwaiMediaPlayer.getCurrentPosition() : 0L);
            IKwaiMediaPlayer iKwaiMediaPlayer2 = this.mCurrentPlayer;
            if (iKwaiMediaPlayer2 != null) {
                iKwaiMediaPlayer2.stop();
            }
            if (this.mVodDebugInfoView != null && KSVodPlayerConfig.get().isEnableDebugInfo()) {
                this.mVodDebugInfoView.stopMonitor();
            }
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public boolean retryPlayback() throws JSONException {
        String json;
        if (this.mState.get() != 9) {
            KSVodLogger.e(TAG, "refreshDataSource failed! last player not finish!");
            return false;
        }
        HostSwitcher hostSwitcher = this.mHostSwitcher;
        if (hostSwitcher != null) {
            hostSwitcher.refreshUrlList(true);
            if (this.mHostSwitcher.size() > 0) {
                if (this.mBuilder.mVodAdaptationModel != null) {
                    json = VideoAdaptationModel_JsonUtils.toJson(this.mHostSwitcher.getModel());
                } else {
                    if (this.mHeaders == null) {
                        this.mHeaders = new HashMap();
                    }
                    this.mHeaders.put("Host", this.mHostSwitcher.getCurrentHost());
                    json = this.mHostSwitcher.getCurrent().mUrl;
                }
                if (json != null && refreshDataSource(json)) {
                    KSVodLogger.d(TAG, "refreshDataSource success!");
                    return true;
                }
                KSVodLogger.e(TAG, "refreshDataSource failed! dns url error:" + json);
            }
        }
        KSVodLogger.e(TAG, "refreshDataSource failed, dns failed or already try all urls!");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean refreshDataSource(String str) {
        synchronized (this.mLock) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer != null) {
                iKwaiMediaPlayer.setOnErrorListener(null);
                this.mCurrentPlayer.setOnPreparedListener(null);
                this.mCurrentPlayer.setOnVideoSizeChangedListener(null);
                this.mCurrentPlayer.setOnInfoListener(null);
                this.mCurrentPlayer.setOnBufferingUpdateListener(null);
                this.mCurrentPlayer.releaseAsync();
                this.mCurrentPlayer = null;
            }
            this.mUrl = str;
            IKwaiMediaPlayer iKwaiMediaPlayerCreateKwaiMediaPlayer = createKwaiMediaPlayer(this.mBuilder.builder());
            this.mNextPlayer = iKwaiMediaPlayerCreateKwaiMediaPlayer;
            float f = this.mLeftVolume;
            if (f != 1.0f || this.mRightVolume != 1.0f) {
                iKwaiMediaPlayerCreateKwaiMediaPlayer.setVolume(f, this.mRightVolume);
            }
            int i = this.mScalingMode;
            if (i != 0) {
                this.mNextPlayer.setVideoScalingMode(i);
            }
            this.mState.set(2);
            this.mNextPlayer.prepareAsync();
            this.mCurrentPlayer = this.mNextPlayer;
        }
        IKSVodPlayer.OnEventListener onEventListener = this.mOnEventListener;
        if (onEventListener == null) {
            return true;
        }
        onEventListener.onEvent(KSVodConstants.KSVOD_PLAYER_INFO_HOST_SWITCH_START, 0);
        return true;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void releaseAsync(IKSVodPlayer.OnVodPlayerReleaseListener onVodPlayerReleaseListener) {
        releaseAsync(true, onVodPlayerReleaseListener);
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void releaseAsync(final boolean z, final IKSVodPlayer.OnVodPlayerReleaseListener onVodPlayerReleaseListener) {
        KSVodLogger.d(TAG, "releaseAsync,needReportQos:" + z);
        this.mState.set(9);
        OnPlayerReleaseListener onPlayerReleaseListener = new OnPlayerReleaseListener() { // from class: com.kwai.video.ksvodplayerkit.KSVodPlayer.7
            @Override // com.kwai.player.OnPlayerReleaseListener
            public void onRelease(KwaiPlayerResultQos kwaiPlayerResultQos) {
                synchronized (KSVodPlayer.this.mLock) {
                    if (!KSVodPlayer.this.mIsReported) {
                        KSVodPlayer.this.mIsReported = true;
                        IKSVodPlayer.OnVodPlayerReleaseListener onVodPlayerReleaseListener2 = onVodPlayerReleaseListener;
                        if (onVodPlayerReleaseListener2 != null) {
                            onVodPlayerReleaseListener2.onPlayerRelease();
                        }
                        if (z) {
                            try {
                                KSVodPlayer.this.logVideoStatJson(kwaiPlayerResultQos);
                                return;
                            } catch (JSONException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    KSVodLogger.w(KSVodPlayer.TAG, "logVideoStatJson already reported!");
                }
            }
        };
        synchronized (this.mLock) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer != null) {
                iKwaiMediaPlayer.setOnPreparedListener(null);
                this.mCurrentPlayer.setOnInfoListener(null);
                this.mCurrentPlayer.setOnErrorListener(null);
                this.mCurrentPlayer.setOnVideoSizeChangedListener(null);
                this.mCurrentPlayer.setOnSeekCompleteListener(null);
                this.mCurrentPlayer.setOnBufferingUpdateListener(null);
                this.mCurrentPlayer.releaseAsync(onPlayerReleaseListener);
                this.mCurrentPlayer = null;
            }
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public IKwaiMediaPlayer getKwaiMediaPlayer() {
        IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
        if (iKwaiMediaPlayer != null) {
            return iKwaiMediaPlayer;
        }
        return null;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setOnPreparedListener(IKSVodPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setOnEventListener(IKSVodPlayer.OnEventListener onEventListener) {
        this.mOnEventListener = onEventListener;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setVideoSizeChangedListener(IKSVodPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setOnErrorListener(IKSVodPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setCacheSessionListener(CacheListener cacheListener) {
        this.mCacheSessionListener = cacheListener;
        if (this.mCurrentPlayer != null && cacheListener != null) {
            AwesomeCacheListener awesomeCacheListener = this.mAwesomeCacheListener;
            if (awesomeCacheListener != null) {
                awesomeCacheListener.setListener(cacheListener);
            } else {
                this.mAwesomeCacheListener = new AwesomeCacheListener(this.mCacheSessionListener);
            }
            this.mCurrentPlayer.getAspectAwesomeCache().setAwesomeCacheCallback(this.mAwesomeCacheListener);
        }
        if (cacheListener == null) {
            this.mAwesomeCacheListener = null;
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setBufferingUpdateListener(IKSVodPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setVodDebugView(KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView) {
        this.mVodDebugInfoView = kwaiPlayerDebugInfoView;
        if (KSVodPlayerConfig.get().isEnableDebugInfo()) {
            this.mVodDebugInfoView.setVisibility(0);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void removeVodDebugView() {
        KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView = this.mVodDebugInfoView;
        if (kwaiPlayerDebugInfoView != null) {
            kwaiPlayerDebugInfoView.stopMonitor();
            this.mVodDebugInfoView = null;
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer
    public void setSpeed(float f) {
        synchronized (this.mLock) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
            if (iKwaiMediaPlayer != null) {
                iKwaiMediaPlayer.setSpeed(f);
            }
        }
    }

    public void setPreferBandWidth(int i) {
        HlsAdaptationModel hlsManifestModel;
        synchronized (this.mLock) {
            if (this.mBuilder.mUrlType == 2 && (hlsManifestModel = this.mHostSwitcher.getHlsManifestModel()) != null && hlsManifestModel.adaptationSet != null) {
                Iterator<HlsRepresentation> it = hlsManifestModel.adaptationSet.representation.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HlsRepresentation next = it.next();
                    if (next.averageBandwidth == i) {
                        this.mPreferRepresentation = next;
                        break;
                    }
                }
                if (this.mPreferRepresentation == null) {
                    this.mPreferRepresentation = hlsManifestModel.adaptationSet.representation.get(0);
                }
                HlsRepresentation hlsRepresentation = this.mPreferRepresentation;
                if (hlsRepresentation != null) {
                    this.mHostSwitcher.setCurrentPlayCDNUrl(hlsRepresentation.url);
                }
            }
        }
    }

    private IKwaiMediaPlayer createKwaiMediaPlayer(KwaiPlayerVodBuilder kwaiPlayerVodBuilder) {
        int i;
        int i2;
        kwaiPlayerVodBuilder.setUseNatvieCache(true).setStartOnPrepared(false).setOverlayFormat(PlayerSettingConstants.SDL_FCC_RV32).setEnableAccurateSeek(true).setStartOnPrepared(this.mBuilder.mStartOnPrepared).setHevcDcoderName(KwaiPlayerBaseBuilder.HEVC_DECODER_NAME_KS265);
        if (KSVodPlayerConfig.get().isUseKS265Decoder()) {
            kwaiPlayerVodBuilder.setKs265DecExtraParams("use_pthread=1");
        }
        if (this.mBuilder.mSeekAtStart > 0) {
            kwaiPlayerVodBuilder.seekAtStart(this.mBuilder.mSeekAtStart);
        }
        if (this.mBuilder.mProductName != null) {
            kwaiPlayerVodBuilder.setProductContext(new ProductContext.Builder().setBizType(this.mBuilder.mProductName).setPlayIndex(this.mRetryCount.get()).build());
        }
        if (this.mBuilder.mEnterType == KSVodPlayerBuilder.VodPlayEnterType.CLICK) {
            kwaiPlayerVodBuilder.setMaxBufferStrategy(1).setMaxBufferTimeBspMs(KSVodPlayerConfig.get().getMaxBufferTimeBspMs()).setStartPlayBlockBufferMs(KSVodPlayerConfig.get().getStartPlayBlockBufferMs(), KSVodPlayerConfig.get().getMaxBufferCostMs());
        } else if (this.mBuilder.mEnterType == KSVodPlayerBuilder.VodPlayEnterType.SLIDE) {
            kwaiPlayerVodBuilder.setPreLoadDurationMs(1, KSVodPlayerConfig.get().getPreloadDuration());
        }
        if (KSVodPlayerConfig.get().isEnableH264HW()) {
            kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(1);
        }
        if (KSVodPlayerConfig.get().isEnableH265HW()) {
            kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(2);
        }
        if (this.mBuilder.mMediaCodecConfig != null) {
            VodMediaCodecConfig vodMediaCodecConfig = this.mBuilder.mMediaCodecConfig;
            kwaiPlayerVodBuilder.setUseMediaCodecByteBuffer(vodMediaCodecConfig.useMediaCodecByteBuffer);
            if (vodMediaCodecConfig.supportAvcMediaCodec) {
                kwaiPlayerVodBuilder.setMediaCodecAvcHeightLimit(vodMediaCodecConfig.mediaCodecAvcHeightLimit);
                kwaiPlayerVodBuilder.setMediaCodecAvcWidthLimit(vodMediaCodecConfig.mediaCodecAvcWidthLimit);
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(1);
            }
            if (vodMediaCodecConfig.supportHevcMediaCodec) {
                kwaiPlayerVodBuilder.setMediaCodecHevcHeightLimit(vodMediaCodecConfig.mediaCodecAvcHeightLimit);
                kwaiPlayerVodBuilder.setMediaCodecHevcWidthLimit(vodMediaCodecConfig.mediaCodecAvcWidthLimit);
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(2);
            }
            if (vodMediaCodecConfig.supportAvcMediaCodec && vodMediaCodecConfig.supportHevcMediaCodec) {
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(4096);
            }
            if (vodMediaCodecConfig.mediaCodecMaxNum > 0) {
                kwaiPlayerVodBuilder.setMediaCodecMaxNum(vodMediaCodecConfig.mediaCodecMaxNum);
            }
        }
        if ((this.mBuilder.mUrlType == 1 && this.mBuilder.mVodAdaptationModel != null) || (this.mBuilder.mUrlType == 3 && this.mUrl != null)) {
            i = 3;
            i2 = 2;
            kwaiPlayerVodBuilder.setVodManifest(NetworkUtils.getAdaptiveNetType(this.mBuilder.mContext), VodPlayerUtils.getScreenWidth(this.mBuilder.mContext), VodPlayerUtils.getScreenHeight(this.mBuilder.mContext), KSVodPlayerConfig.get().getVodAdaptive(), KSVodPlayerConfig.get().isLowDevice(), 0);
            kwaiPlayerVodBuilder.setManifestType(this.mBuilder.mUrlType == 3 ? 1 : 0);
        } else {
            i = 3;
            i2 = 2;
            if (this.mBuilder.mUrlType == 2) {
                kwaiPlayerVodBuilder.setEnableAccurateSeek(false).setEnableSegmentCache(true).setEnableSeekForwardOffset(true);
                if (this.mBuilder.mPreferBandWidth >= 0) {
                    setPreferBandWidth(this.mBuilder.mPreferBandWidth);
                }
            } else {
                kwaiPlayerVodBuilder.setCacheKey(KSVodPlayStatManager.getInstance().add(this.mUrl));
            }
        }
        if (KSVodPlayerConfig.get().isRecordHistory() && this.mBuilder.mUrlType == 0) {
            long playPosition = KSVodPlayStatManager.getInstance().getPlayPosition(this.mUrl);
            if (playPosition > 0) {
                KSVodLogger.d(TAG, "createKwaiMediaPlayer use record history progress, seekto:" + playPosition);
                kwaiPlayerVodBuilder.seekAtStart(playPosition);
            }
        }
        if (VodPlayerUtils.isM3u8(this.mUrl)) {
            kwaiPlayerVodBuilder.setEnableAccurateSeek(false);
        }
        IKwaiMediaPlayer iKwaiMediaPlayerBuild = kwaiPlayerVodBuilder.build();
        iKwaiMediaPlayerBuild.setLooping(this.mLoop);
        AspectAwesomeCache aspectAwesomeCache = iKwaiMediaPlayerBuild.getAspectAwesomeCache();
        aspectAwesomeCache.setCacheDownloadReadTimeoutMs(KSVodPlayerConfig.get().getCacheDownloadReadTimeoutMs());
        aspectAwesomeCache.setCacheDownloadConnectTimeoutMs(KSVodPlayerConfig.get().getCacheDownloadConnectTimeoutMs());
        aspectAwesomeCache.setBufferedDataSourceSizeKB(KSVodPlayerConfig.get().getBufferedDataSourceSizeKB());
        AwesomeCacheListener awesomeCacheListener = new AwesomeCacheListener(this.mCacheSessionListener);
        this.mAwesomeCacheListener = awesomeCacheListener;
        aspectAwesomeCache.setAwesomeCacheCallback(awesomeCacheListener);
        if (KSVodPlayerConfig.get().isEnableAsync()) {
            aspectAwesomeCache.setDataSourceType(0);
        }
        if (VodPlayerUtils.isM3u8(this.mUrl)) {
            aspectAwesomeCache.setDataSourceType(i2);
        }
        if (KSVodPlayerConfig.get().getSocketBufferSizeKB() > 0) {
            aspectAwesomeCache.setCacheSocketBufferSizeKb(KSVodPlayerConfig.get().getSocketBufferSizeKB());
        }
        iKwaiMediaPlayerBuild.setOnPreparedListener(this.mKwaiOnPreparedListener);
        iKwaiMediaPlayerBuild.setOnInfoListener(this.mKwaiOnInfoListener);
        iKwaiMediaPlayerBuild.setOnErrorListener(this.mKwaiOnErrorListener);
        iKwaiMediaPlayerBuild.setOnVideoSizeChangedListener(this.mKwaiOnVideoSizeChangedListener);
        iKwaiMediaPlayerBuild.setOnSeekCompleteListener(this.mKwaiOnSeekCompleteListener);
        iKwaiMediaPlayerBuild.setOnBufferingUpdateListener(this.mKwaiOnBufferingUpdateListener);
        if (!TextUtils.isEmpty(this.mUrl)) {
            try {
                if (this.mBuilder.mUrlType == i2) {
                    HlsRepresentation hlsRepresentation = this.mPreferRepresentation;
                    iKwaiMediaPlayerBuild.setKwaiManifest(hlsRepresentation != null ? hlsRepresentation.url : "no_prefer_url", this.mUrl, this.mHeaders);
                } else if (this.mBuilder.mUrlType == i) {
                    HostSwitcher hostSwitcher = this.mHostSwitcher;
                    if (hostSwitcher != null) {
                        iKwaiMediaPlayerBuild.setDataSource(KwaiMediaManifest_JsonUtils.toJson(hostSwitcher.getKwaiManifestModel()));
                    } else {
                        KSVodLogger.e(TAG, "setDataSource error", new Exception("setDataSource"));
                    }
                } else {
                    iKwaiMediaPlayerBuild.setDataSource(this.mUrl, this.mHeaders);
                }
                KSVodLogger.d(TAG, "createKwaiMediaPlayer, url:" + this.mUrl);
            } catch (IOException e) {
                e.printStackTrace();
                KSVodLogger.e(TAG, "setDataSource error", new Exception("setDataSource"));
            }
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            iKwaiMediaPlayerBuild.setSurface(surface);
        }
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            iKwaiMediaPlayerBuild.setDisplay(surfaceHolder);
        }
        return iKwaiMediaPlayerBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logVideoStatJson(KwaiPlayerResultQos kwaiPlayerResultQos) throws JSONException {
        String str = kwaiPlayerResultQos.videoStatJson;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("qos", str);
        if (this.mBuilder.mVideoContext != null) {
            VideoContext videoContext = new VideoContext();
            videoContext.mVideoId = this.mBuilder.mVideoContext.mVideoId;
            videoContext.mEnterAction = this.mBuilder.mVideoContext.mEnterAction;
            videoContext.mVideoProfile = this.mBuilder.mVideoContext.mVideoProfile;
            videoContext.mExtra = this.mBuilder.mVideoContext.mExtra;
            videoContext.mClickToFirstFrame = this.mRealFirstScreenTime;
            videoContext.mPrepareTimestamp = this.mCallPrepareTimestamp;
            videoContext.mStartTimestamp = this.mCallStartTimestamp;
            videoContext.mClickTimeStamp = this.mBuilder.mVideoContext.mClickTime;
            jSONObject.put("stats", VideoContext_JsonUtils.toJson(videoContext));
            PrefetchReportInfo reportInfoByVideoId = KSPrefetcher.getInstance().getReportInfoByVideoId(this.mBuilder.mVideoContext.mVideoId);
            if (reportInfoByVideoId != null) {
                jSONObject.put("prefetch", PrefetchReportInfo_JsonUtils.toJson(reportInfoByVideoId));
            }
        }
        String string = jSONObject.toString();
        KSVodLogger.i(TAG, "logVideoStatJson VP_PLAYFINISHED；" + string);
        KSVodPlayerLogUploader.logQosFinished(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logCdnStatJson(String str) throws JSONException {
        if (str == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("qos", str);
            JSONObject jSONObject2 = new JSONObject();
            HostSwitcher hostSwitcher = this.mHostSwitcher;
            jSONObject2.put("rank", hostSwitcher != null ? hostSwitcher.getCurrentPosition() : 0);
            jSONObject.put("stats", jSONObject2.toString());
            jSONObject.put("resource_type", "video");
            String string = jSONObject.toString();
            KSVodLogger.i(TAG, "logVideoStatJson VP_CDN_RESOURCE：" + string);
            KSVodPlayerLogUploader.logCdnStatJson(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCanPreloadNext() {
        IKSVodPlayer.OnEventListener onEventListener = this.mOnEventListener;
        if (onEventListener != null) {
            onEventListener.onEvent(KSVodConstants.KSVOD_PLAYER_INFO_PLAY_CAN_LOAD_NEXT, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean retryOnErrorIfNeed() {
        if (!NetworkUtils.isNetworkConnected(this.mBuilder.mContext) || this.mRetryCount.addAndGet(1) >= KSVodPlayerConfig.get().getMaxRetryCount()) {
            return false;
        }
        return retryPlayback();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class AwesomeCacheListener extends AwesomeCacheCallback {
        private CacheListener mListener;
        private CacheReceipt mReceipt = new CacheReceipt();
        private boolean mCompletedCalled = false;

        AwesomeCacheListener(CacheListener cacheListener) {
            this.mListener = cacheListener;
        }

        public void setListener(CacheListener cacheListener) {
            this.mListener = cacheListener;
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            CacheListener cacheListener;
            this.mReceipt.mTotalBytesOfResponse = acCallBackInfo.contentLength;
            this.mReceipt.mTotalBytesOfSource = acCallBackInfo.totalBytes;
            this.mReceipt.mIp = acCallBackInfo.ip;
            this.mReceipt.mInitAvailableBytesOfCache = acCallBackInfo.cachedBytes;
            this.mReceipt.mBytesReadFromSource = acCallBackInfo.progressPosition;
            if (this.mReceipt.mBytesReadFromSource <= 0 && acCallBackInfo.cachedBytes > 0) {
                this.mReceipt.mBytesReadFromSource = acCallBackInfo.cachedBytes;
            }
            CacheListener cacheListener2 = this.mListener;
            if (cacheListener2 != null) {
                cacheListener2.onProgress(this.mReceipt);
            }
            if (acCallBackInfo.progressPosition >= acCallBackInfo.totalBytes && (cacheListener = this.mListener) != null && !this.mCompletedCalled) {
                this.mCompletedCalled = true;
                cacheListener.onCompleted(this.mReceipt);
                this.mReceipt.mFragmentIndex++;
                this.mListener.onFragmentCompleted(this.mReceipt);
            }
            KSVodLogger.i(KSVodPlayer.TAG, "onSessionProgress ,cachedBytes:" + this.mReceipt.mBytesReadFromSource + ",mPreloadThresholdBytes:" + KSVodPlayerConfig.get().getPreloadThreshold());
            if (KSVodPlayer.this.mOnEventListener == null || !this.mReceipt.reachPreloadThreshold()) {
                return;
            }
            KSVodLogger.i(KSVodPlayer.TAG, "notifyCanPreloadNext ,cachedBytes:" + this.mReceipt.mBytesReadFromSource + ",mTotalBytesOfSource:" + this.mReceipt.mTotalBytesOfSource);
            KSVodPlayer.this.notifyCanPreloadNext();
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) throws JSONException {
            CacheListener cacheListener;
            String json;
            this.mReceipt.mHost = acCallBackInfo.host;
            this.mReceipt.mUrl = acCallBackInfo.currentUri;
            this.mReceipt.mReadSourceFinishTimeMills = acCallBackInfo.transferConsumeMs;
            this.mReceipt.mSignature = acCallBackInfo.kwaiSign;
            this.mReceipt.mXKsHttpHeader = acCallBackInfo.xKsCache;
            this.mReceipt.mCdnStatJson = acCallBackInfo.cdnStatJson;
            this.mReceipt.mSessionUUID = acCallBackInfo.sessionUUID;
            this.mReceipt.mDownloadUUID = acCallBackInfo.downloadUUID;
            this.mReceipt.mCdnStatJson = acCallBackInfo.cdnStatJson;
            this.mReceipt.mHttpResponseCode = acCallBackInfo.httpResponseCode;
            this.mReceipt.mErrorCode = acCallBackInfo.errorCode;
            this.mReceipt.mStopReason = acCallBackInfo.stopReason;
            this.mReceipt.mReadSourceTimeCostMills = acCallBackInfo.transferConsumeMs;
            int i = acCallBackInfo.stopReason;
            if (i == 1) {
                if (this.mListener != null && !this.mCompletedCalled) {
                    this.mReceipt.mFragmentIndex++;
                    this.mListener.onFragmentCompleted(this.mReceipt);
                }
                if (acCallBackInfo.progressPosition >= acCallBackInfo.totalBytes && (cacheListener = this.mListener) != null && !this.mCompletedCalled) {
                    this.mCompletedCalled = true;
                    cacheListener.onCompleted(this.mReceipt);
                }
                KSVodPlayer.this.notifyCanPreloadNext();
                KSVodPlayer.this.logCdnStatJson(acCallBackInfo.cdnStatJson);
                return;
            }
            if (i != 2) {
                KSVodPlayer.this.logCdnStatJson(acCallBackInfo.cdnStatJson);
                String str = acCallBackInfo.currentUri;
                String json2 = null;
                if (KSVodPlayer.this.mBuilder.mUrlType == 2) {
                    str = KSVodPlayer.this.mPreferRepresentation != null ? KSVodPlayer.this.mPreferRepresentation.url : null;
                }
                KSVodPlayStatManager.getInstance().updatePlayPosition(str, KSVodPlayer.this.mCurrentPlayer != null ? KSVodPlayer.this.mCurrentPlayer.getCurrentPosition() : 0L);
                if (NetworkUtils.isNetworkConnected(KSVodPlayer.this.mBuilder.mContext) && KSVodPlayer.this.mHostSwitcher != null) {
                    KSVodPlayer.this.mHostSwitcher.refreshUrlList(false);
                    if (KSVodPlayer.this.mHostSwitcher.size() > 0 && !KSVodPlayer.this.mHostSwitcher.isLastUrl() && KSVodPlayer.this.mRetryCount.addAndGet(1) < KSVodPlayerConfig.get().getMaxRetryCount() && KSVodPlayer.this.mHostSwitcher.switchHost()) {
                        if (KSVodPlayer.this.mBuilder.mUrlType == 1) {
                            json = VideoAdaptationModel_JsonUtils.toJson(KSVodPlayer.this.mHostSwitcher.getModel());
                        } else if (KSVodPlayer.this.mBuilder.mUrlType == 2) {
                            HlsAdaptationModel hlsManifestModel = KSVodPlayer.this.mHostSwitcher.getHlsManifestModel();
                            if (hlsManifestModel != null) {
                                json2 = HlsAdaptationModel_JsonUtils.toJson(hlsManifestModel);
                                KSVodPlayer.this.mHeaders.put("Host", hlsManifestModel.host);
                            }
                            json = json2;
                        } else {
                            KSVodPlayer.this.mHeaders.put("Host", KSVodPlayer.this.mHostSwitcher.getCurrentHost());
                            json = KSVodPlayer.this.mHostSwitcher.getCurrent().mUrl;
                        }
                        if (json != null && KSVodPlayer.this.refreshDataSource(json)) {
                            KSVodLogger.e(KSVodPlayer.TAG, "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + " refreshDataSource count:" + KSVodPlayer.this.mRetryCount.get() + ", new url:" + json);
                            return;
                        }
                    }
                }
                KSVodPlayer.this.mState.set(9);
                KSVodLogger.e(KSVodPlayer.TAG, "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + ", already retry all urls, stop play");
                CacheListener cacheListener2 = this.mListener;
                if (cacheListener2 != null) {
                    cacheListener2.onFailed(this.mReceipt);
                    return;
                }
                return;
            }
            CacheListener cacheListener3 = this.mListener;
            if (cacheListener3 != null) {
                cacheListener3.onCancelled(this.mReceipt);
            }
            KSVodPlayer.this.logCdnStatJson(acCallBackInfo.cdnStatJson);
        }
    }
}
