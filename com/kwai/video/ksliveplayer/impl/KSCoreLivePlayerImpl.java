package com.kwai.video.ksliveplayer.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.player.KwaiPlayerConfig;
import com.kwai.player.qos.KwaiQosInfo;
import com.kwai.video.ksliveplayer.KSCoreLivePlayer;
import com.kwai.video.ksliveplayer.KSCoreLivePlayerBuilder;
import com.kwai.video.ksliveplayer.KSLiveManifest;
import com.kwai.video.ksliveplayer.KSLivePlayerLogUploader;
import com.kwai.video.ksliveplayer.KSLiveVideoContext;
import com.kwai.video.ksliveplayer.UseLastQualityTypeHelper;
import com.kwai.video.ksliveplayer.impl.LiveRetryHelper;
import com.kwai.video.ksliveplayer.log.LivePlayQualityStatistics;
import com.kwai.video.ksliveplayer.model.KSLivePlayerConfigModel;
import com.kwai.video.ksliveplayer.model.KSLivePlayerConfigModel_JsonUtils;
import com.kwai.video.ksliveplayer.model.KSLivePlayerSourceModel;
import com.kwai.video.ksliveplayer.model.KSLivePlayerSourceModel_JsonUtils;
import com.kwai.video.ksliveplayer.model.LiveAdaptionModel;
import com.kwai.video.ksliveplayer.model.LiveAdaptiveManifestModel;
import com.kwai.video.ksliveplayer.model.LiveRetryConfigModel;
import com.kwai.video.ksliveplayer.switcher.HostSwitcher;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder;
import com.kwai.video.player.kwai_player.KwaiPlayerLiveBuilder;
import com.kwai.video.player.kwai_player.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSCoreLivePlayerImpl implements KSCoreLivePlayer {
    public static final String TAG = "KSCoreLivePlayer";
    private Context mContext;
    private String mCurrentDataSource;
    private KSLiveManifestImpl mCurrentLiveManifest;
    private String mCurrentManifestContainerStr;
    private List<String> mCurrentMultiPlayUrls;
    private IKwaiMediaPlayer mCurrentPlayer;
    private KSLiveDataSourceType mDataSourceType;
    private HostSwitcher mHostSwitcher;
    private boolean mIsCoreIndependent;
    private KwaiPlayerLiveBuilder mKwaiPlayerLiveBuilder;
    private IMediaPlayer.OnLiveEventListener mLiveDataListener;
    private String mLiveManifestConfigStr;
    private IMediaPlayer.OnErrorListener mLiveOnErrorListener;
    private IMediaPlayer.OnPreparedListener mLiveOnPreparedListener;
    private LivePlayQualityStatistics mLivePlayQualityStatistics;
    private KSLivePlayerConfigModel mLivePlayerConfig;
    private KSLivePlayerSourceModel mLivePlayerSourceModel;
    private LiveRetryConfigModel mLiveRetryConfig;
    private LiveRetryHelper mLiveRetryHelper;
    private KSLiveVideoContext mLiveVideoContext;
    private Handler mMainHandler;
    private IMediaPlayer.OnCompletionListener mOnCompletionListener;
    private IMediaPlayer.OnLiveAdaptiveQosStatListener mOnLiveAdaptiveQosStatListener;
    private IMediaPlayer.OnInfoListener mOnLiveInfoListener;
    private IMediaPlayer.OnLogEventListener mOnLiveLogEventListener;
    private IMediaPlayer.OnQosStatListener mOnLiveQosStatListener;
    private IMediaPlayer.OnLiveVoiceCommentListener mOnLiveVoiceCommentListener;
    private KSCoreLivePlayer.OnTickQosListener mOnTickQosListener;
    private KSCoreLivePlayer.OnUrlSwitchListener mOnUrlSwitchListener;
    private IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private long mPlayStartTimeMs;
    private Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    private final String KEY_KIT_NAME = "ksliveplayer";
    private final String KEY_CONFIG = "config";
    private int mCurrentPlayingSwitchIndex = -1;
    private Object mLock = new Object();
    private int mLastRetryCount = 0;
    private IMediaPlayer.OnPreparedListener mKwaiOnPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.1
        @Override // com.kwai.video.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(final IMediaPlayer iMediaPlayer) {
            KSCoreLivePlayerImpl.this.mLiveRetryHelper.setEnable(true);
            if (KSCoreLivePlayerImpl.this.mLiveOnPreparedListener != null) {
                KSCoreLivePlayerImpl.this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KSCoreLivePlayerImpl.this.mLiveOnPreparedListener != null) {
                            KSCoreLivePlayerImpl.this.mLiveOnPreparedListener.onPrepared(iMediaPlayer);
                        }
                    }
                });
            }
            KSCoreLivePlayerImpl.this.retrySuccessAndCallbackIfNeed();
        }
    };
    private IMediaPlayer.OnErrorListener mKwaiOnErrorListener = new IMediaPlayer.OnErrorListener() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.2
        @Override // com.kwai.video.player.IMediaPlayer.OnErrorListener
        public boolean onError(final IMediaPlayer iMediaPlayer, final int i, final int i2) {
            if (!Util.isCriticalErrorInMediaPlayer(i, i2)) {
                if (KSCoreLivePlayerImpl.this.mLiveOnErrorListener == null) {
                    return false;
                }
                KSCoreLivePlayerImpl.this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KSCoreLivePlayerImpl.this.mLiveOnErrorListener != null) {
                            KSCoreLivePlayerImpl.this.mLiveOnErrorListener.onError(iMediaPlayer, i, i2);
                        }
                    }
                });
                return false;
            }
            iMediaPlayer.setOnErrorListener(null);
            KSCoreLivePlayerImpl.this.mLiveRetryHelper.handleCriticalPlayerError(i, i2);
            return true;
        }
    };
    private IMediaPlayer.OnLiveEventListener mKwaiOnLiveEventListener = new IMediaPlayer.OnLiveEventListener() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.3
        @Override // com.kwai.video.player.IMediaPlayer.OnLiveEventListener
        public void onLiveEventChange(final byte[] bArr) {
            if (KSCoreLivePlayerImpl.this.mLiveDataListener != null) {
                KSCoreLivePlayerImpl.this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KSCoreLivePlayerImpl.this.mLiveDataListener != null) {
                            KSCoreLivePlayerImpl.this.mLiveDataListener.onLiveEventChange(bArr);
                        }
                    }
                });
            }
        }
    };
    private IMediaPlayer.OnVideoSizeChangedListener mKwaiOnVideoSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.4
        @Override // com.kwai.video.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(final IMediaPlayer iMediaPlayer, final int i, final int i2, final int i3, final int i4) {
            KSCoreLivePlayerImpl.this.mVideoWidth = i;
            KSCoreLivePlayerImpl.this.mVideoHeight = i2;
            if (KSCoreLivePlayerImpl.this.mOnVideoSizeChangedListener != null) {
                KSCoreLivePlayerImpl.this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KSCoreLivePlayerImpl.this.mOnVideoSizeChangedListener != null) {
                            KSCoreLivePlayerImpl.this.mOnVideoSizeChangedListener.onVideoSizeChanged(iMediaPlayer, i, i2, i3, i4);
                        }
                    }
                });
            }
        }
    };
    private IMediaPlayer.OnLiveVoiceCommentListener mKwaiOnLiveVoiceCommentListener = new IMediaPlayer.OnLiveVoiceCommentListener() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.5
        @Override // com.kwai.video.player.IMediaPlayer.OnLiveVoiceCommentListener
        public void onLiveVoiceCommentChange(final IMediaPlayer iMediaPlayer, final String str) {
            if (KSCoreLivePlayerImpl.this.mOnLiveVoiceCommentListener != null) {
                KSCoreLivePlayerImpl.this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KSCoreLivePlayerImpl.this.mOnLiveVoiceCommentListener != null) {
                            KSCoreLivePlayerImpl.this.mOnLiveVoiceCommentListener.onLiveVoiceCommentChange(iMediaPlayer, str);
                        }
                    }
                });
            }
        }
    };
    private IMediaPlayer.OnLogEventListener mKwaiOnLogEventListener = new IMediaPlayer.OnLogEventListener() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.6
        @Override // com.kwai.video.player.IMediaPlayer.OnLogEventListener
        public void onLogEvent(final IMediaPlayer iMediaPlayer, final String str) {
            if (KSCoreLivePlayerImpl.this.mOnLiveLogEventListener != null) {
                KSCoreLivePlayerImpl.this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KSCoreLivePlayerImpl.this.mOnLiveLogEventListener != null) {
                            KSCoreLivePlayerImpl.this.mOnLiveLogEventListener.onLogEvent(iMediaPlayer, str);
                        }
                    }
                });
            }
        }
    };
    private IMediaPlayer.OnInfoListener mKwaiOnInfoListener = new IMediaPlayer.OnInfoListener() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.7
        @Override // com.kwai.video.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(final IMediaPlayer iMediaPlayer, final int i, final int i2) {
            if (i == 3) {
                KSCoreLivePlayerImpl.this.mLivePlayQualityStatistics.logRenderEndTimeIfNeed();
                KSCoreLivePlayerImpl.this.mLivePlayQualityStatistics.logEndBufferTimeThenAddIfNeed();
            }
            if (KSCoreLivePlayerImpl.this.mOnLiveInfoListener == null) {
                return false;
            }
            KSCoreLivePlayerImpl.this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.7.1
                @Override // java.lang.Runnable
                public void run() {
                    if (KSCoreLivePlayerImpl.this.mOnLiveInfoListener != null) {
                        KSCoreLivePlayerImpl.this.mOnLiveInfoListener.onInfo(iMediaPlayer, i, i2);
                    }
                }
            });
            return false;
        }
    };
    private IMediaPlayer.OnQosStatListener mKwaiQosListener = new IMediaPlayer.OnQosStatListener() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.8
        @Override // com.kwai.video.player.IMediaPlayer.OnQosStatListener
        public void onQosStat(IMediaPlayer iMediaPlayer, JSONObject jSONObject) throws JSONException {
            KSCoreLivePlayerImpl.this.postLivePlayerQos(iMediaPlayer, jSONObject);
        }
    };
    private IMediaPlayer.OnLiveAdaptiveQosStatListener mKwaiAdaptiveQosStatListener = new IMediaPlayer.OnLiveAdaptiveQosStatListener() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.9
        @Override // com.kwai.video.player.IMediaPlayer.OnLiveAdaptiveQosStatListener
        public void onLiveAdaptiveQosStat(final IMediaPlayer iMediaPlayer, final JSONObject jSONObject) {
            if (KSCoreLivePlayerImpl.this.mOnLiveAdaptiveQosStatListener != null) {
                KSCoreLivePlayerImpl.this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KSCoreLivePlayerImpl.this.mOnLiveAdaptiveQosStatListener != null) {
                            KSCoreLivePlayerImpl.this.mOnLiveAdaptiveQosStatListener.onLiveAdaptiveQosStat(iMediaPlayer, jSONObject);
                        }
                    }
                });
            }
        }
    };
    private IMediaPlayer.OnCompletionListener mKwaiOnCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.10
        @Override // com.kwai.video.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(final IMediaPlayer iMediaPlayer) {
            if (KSCoreLivePlayerImpl.this.mOnCompletionListener != null) {
                KSCoreLivePlayerImpl.this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KSCoreLivePlayerImpl.this.mOnCompletionListener != null) {
                            KSCoreLivePlayerImpl.this.mOnCompletionListener.onCompletion(iMediaPlayer);
                        }
                    }
                });
            }
        }
    };
    private KSCoreLivePlayer.OnTickQosListener mInnerTickQosListener = new KSCoreLivePlayer.OnTickQosListener() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.11
        @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer.OnTickQosListener
        public void onTick(KwaiQosInfo kwaiQosInfo) {
            if (KSCoreLivePlayerImpl.this.mOnTickQosListener != null) {
                KSCoreLivePlayerImpl.this.mOnTickQosListener.onTick(kwaiQosInfo);
            }
        }
    };

    public KSCoreLivePlayerImpl(KSCoreLivePlayerBuilder kSCoreLivePlayerBuilder) {
        List<String> list;
        this.mContext = kSCoreLivePlayerBuilder.mContext;
        this.mKwaiPlayerLiveBuilder = kSCoreLivePlayerBuilder.mKwaiPlayerLiveBuilder;
        this.mCurrentDataSource = kSCoreLivePlayerBuilder.mDataSource;
        this.mCurrentManifestContainerStr = kSCoreLivePlayerBuilder.mDataManifest;
        this.mIsCoreIndependent = kSCoreLivePlayerBuilder.isCoreIndependent;
        this.mLivePlayerConfig = kSCoreLivePlayerBuilder.mConfigModel;
        if (kSCoreLivePlayerBuilder.mMultiPlayUrls != null && !kSCoreLivePlayerBuilder.mMultiPlayUrls.isEmpty()) {
            this.mCurrentMultiPlayUrls = kSCoreLivePlayerBuilder.mMultiPlayUrls;
        }
        if (this.mContext == null || (TextUtils.isEmpty(this.mCurrentManifestContainerStr) && TextUtils.isEmpty(this.mCurrentDataSource) && ((list = this.mCurrentMultiPlayUrls) == null || list.isEmpty()))) {
            Log.e(TAG, "Wrong Input Arguments! Context and play url can't be null!");
            return;
        }
        if (!TextUtils.isEmpty(this.mCurrentDataSource) && !TextUtils.isEmpty(this.mCurrentManifestContainerStr)) {
            Log.e(TAG, "Wrong Input Arguments! DataSource and DataManifest can't be set at same time!");
            return;
        }
        if (this.mIsCoreIndependent) {
            initLivePlayerConfig();
        }
        if (!TextUtils.isEmpty(this.mCurrentManifestContainerStr)) {
            this.mDataSourceType = KSLiveDataSourceType.kManifest;
        } else {
            List<String> list2 = this.mCurrentMultiPlayUrls;
            if (list2 != null && !list2.isEmpty()) {
                this.mDataSourceType = KSLiveDataSourceType.kMultiUrl;
            } else {
                this.mDataSourceType = KSLiveDataSourceType.kSingleUrl;
            }
        }
        if (this.mKwaiPlayerLiveBuilder == null) {
            this.mKwaiPlayerLiveBuilder = buildDefaultKwaiPlayerLiveBuilder();
        }
        this.mPlayStartTimeMs = System.currentTimeMillis();
        this.mLiveVideoContext = kSCoreLivePlayerBuilder.mLiveVideoContext;
        this.mLiveManifestConfigStr = kSCoreLivePlayerBuilder.mLiveManifestConfig;
        UseLastQualityTypeHelper.enable(kSCoreLivePlayerBuilder.mEnableUseLastSelectQualityType);
        if (this.mLiveVideoContext == null) {
            this.mLiveVideoContext = new KSLiveVideoContext();
            if (this.mLiveVideoContext.clickTimeMs == 0) {
                this.mLiveVideoContext.clickTimeMs = System.currentTimeMillis();
            }
        }
        this.mLivePlayQualityStatistics = new LivePlayQualityStatistics();
        this.mLivePlayQualityStatistics.logStart(this.mLiveVideoContext);
        this.mLivePlayQualityStatistics.setHost(this.mLiveVideoContext.liveStreamHost);
        this.mHostSwitcher = new HostSwitcher();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        initConfig();
        this.mCurrentPlayer = createKwaiPlayerInternal();
        this.mLiveRetryHelper = new LiveRetryHelper(this.mCurrentPlayer);
        this.mLiveRetryHelper.setLiveRetryConfig(this.mLiveRetryConfig);
        this.mLiveRetryHelper.setOnTickQosListener(this.mInnerTickQosListener);
        this.mLiveRetryHelper.setRetryCallback(new LiveRetryHelper.RetryCallback() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.12
            @Override // com.kwai.video.ksliveplayer.impl.LiveRetryHelper.RetryCallback
            public void onRetry(KSCoreLivePlayer.UrlSwitchInfo urlSwitchInfo) {
                KSCoreLivePlayerImpl.this.switchHostAndRebuildPlayer(urlSwitchInfo);
            }
        });
        this.mLiveRetryHelper.start();
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mLiveOnPreparedListener = onPreparedListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mLiveOnErrorListener = onErrorListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnLiveInfoListener = onInfoListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnLiveEventListener(IMediaPlayer.OnLiveEventListener onLiveEventListener) {
        this.mLiveDataListener = onLiveEventListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnLiveVoiceCommentListener(IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener) {
        this.mOnLiveVoiceCommentListener = onLiveVoiceCommentListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setLiveAdaptiveSwitchIndex(int i) {
        if (TextUtils.isEmpty(this.mCurrentManifestContainerStr)) {
            return;
        }
        int iMin = Math.min(5, Math.max(-1, i));
        UseLastQualityTypeHelper.recordIfNeed(this.mCurrentLiveManifest, iMin);
        this.mCurrentPlayingSwitchIndex = iMin;
        synchronized (this.mLock) {
            if (this.mCurrentPlayer != null) {
                this.mCurrentPlayer.setLiveManifestSwitchMode(iMin);
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public int getCurrentLiveAdaptiveIndex() {
        return this.mCurrentPlayingSwitchIndex;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void refreshDataSource(String str, boolean z) {
        if (str == null) {
            return;
        }
        synchronized (this.mLock) {
            this.mCurrentDataSource = str;
            this.mCurrentManifestContainerStr = null;
            this.mDataSourceType = KSLiveDataSourceType.kSingleUrl;
            initDataSource();
            if (z) {
                rebuildPlayer();
                if (str.equalsIgnoreCase(this.mCurrentDataSource)) {
                    this.mLivePlayQualityStatistics.addRetryCount();
                }
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void refreshMultiPlayUrls(List<String> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        synchronized (this.mLock) {
            this.mCurrentMultiPlayUrls = list;
            this.mCurrentDataSource = null;
            this.mCurrentManifestContainerStr = null;
            this.mDataSourceType = KSLiveDataSourceType.kMultiUrl;
            initDataSource();
            if (z) {
                this.mLivePlayQualityStatistics.addRetryCount();
                rebuildPlayer();
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void refreshDataManifest(String str, boolean z) {
        if (str == null) {
            return;
        }
        synchronized (this.mLock) {
            this.mCurrentManifestContainerStr = str;
            this.mCurrentDataSource = null;
            this.mDataSourceType = KSLiveDataSourceType.kManifest;
            initDataSource();
            if (z) {
                if (str.equalsIgnoreCase(this.mCurrentManifestContainerStr)) {
                    this.mLivePlayQualityStatistics.addRetryCount();
                }
                rebuildPlayer();
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void prepareAsync() {
        synchronized (this.mLock) {
            if (this.mCurrentPlayer != null) {
                this.mCurrentPlayer.prepareAsync();
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setSurface(Surface surface) {
        synchronized (this.mLock) {
            this.mSurface = surface;
            if (this.mCurrentPlayer != null) {
                this.mCurrentPlayer.setSurface(this.mSurface);
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public boolean isPlaying() {
        synchronized (this.mLock) {
            if (this.mCurrentPlayer == null) {
                return false;
            }
            return this.mCurrentPlayer.isPlaying();
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public KSLiveManifest getLiveManifestDetail() {
        return this.mCurrentLiveManifest;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setVolume(float f, float f2) {
        synchronized (this.mLock) {
            if (this.mCurrentPlayer != null) {
                this.mCurrentPlayer.setVolume(f, f2);
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnCompletedListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnLiveAdaptiveQosStatListener(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener) {
        this.mOnLiveAdaptiveQosStatListener = onLiveAdaptiveQosStatListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnQosStatListener(IMediaPlayer.OnQosStatListener onQosStatListener) {
        this.mOnLiveQosStatListener = onQosStatListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnLogEventListener(IMediaPlayer.OnLogEventListener onLogEventListener) {
        this.mOnLiveLogEventListener = onLogEventListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnTickQosListener(KSCoreLivePlayer.OnTickQosListener onTickQosListener) {
        this.mOnTickQosListener = onTickQosListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void setOnUrlSwitchListener(KSCoreLivePlayer.OnUrlSwitchListener onUrlSwitchListener) {
        this.mOnUrlSwitchListener = onUrlSwitchListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void start() {
        synchronized (this.mLock) {
            if (this.mCurrentPlayer != null) {
                this.mCurrentPlayer.start();
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void restart() {
        synchronized (this.mLock) {
            if (this.mCurrentPlayer == null) {
                initConfig();
                this.mCurrentPlayer = createKwaiPlayerInternal();
                this.mCurrentPlayer.prepareAsync();
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void release() {
        synchronized (this.mLock) {
            uploadLivePlayQualityStat();
            this.mLiveRetryHelper.stop();
            if (this.mCurrentPlayer != null) {
                this.mCurrentPlayer.stop();
                this.mCurrentPlayer.release();
                this.mCurrentPlayer = null;
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public void releaseAsync() {
        synchronized (this.mLock) {
            uploadLivePlayQualityStat();
            this.mLiveRetryHelper.stop();
            if (this.mCurrentPlayer != null) {
                this.mCurrentPlayer.stop();
                this.mCurrentPlayer.releaseAsync();
                this.mCurrentPlayer = null;
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer
    public IKwaiMediaPlayer getKwaiMediaPlayer() {
        return this.mCurrentPlayer;
    }

    private void initConfig() {
        initDataSource();
        initSwitcher();
    }

    private void initLivePlayerConfig() {
        String config = Azeroth.get().getConfigManager().getConfig("ksliveplayer");
        if (TextUtils.isEmpty(config)) {
            this.mLivePlayerConfig = new KSLivePlayerConfigModel();
            this.mLiveRetryConfig = this.mLivePlayerConfig.liveRetryConfig;
        } else {
            try {
                this.mLivePlayerConfig = KSLivePlayerConfigModel_JsonUtils.fromJson(new JSONObject(config).getString("config"));
                this.mLiveRetryConfig = this.mLivePlayerConfig.liveRetryConfig == null ? new LiveRetryConfigModel() : this.mLivePlayerConfig.liveRetryConfig;
            } catch (JSONException unused) {
                this.mLivePlayerConfig = new KSLivePlayerConfigModel();
            }
        }
    }

    private void initDataSource() {
        if (this.mDataSourceType == KSLiveDataSourceType.kManifest) {
            this.mLivePlayerSourceModel = KSLivePlayerSourceModel_JsonUtils.fromJson(this.mCurrentManifestContainerStr);
            if (!TextUtils.isEmpty(this.mLivePlayerSourceModel.mLiveAdaptiveConfig) && TextUtils.isEmpty(this.mLiveManifestConfigStr)) {
                this.mLiveManifestConfigStr = this.mLivePlayerSourceModel.mLiveAdaptiveConfig;
            }
            if (!TextUtils.isEmpty(this.mLivePlayerSourceModel.mLiveStreamId) && TextUtils.isEmpty(this.mLiveVideoContext.liveStreamId)) {
                this.mLiveVideoContext.liveStreamId = this.mLivePlayerSourceModel.mLiveStreamId;
            }
            if (this.mLivePlayerSourceModel.mAdaptiveManifestList != null) {
                int i = 0;
                LiveAdaptiveManifestModel liveAdaptiveManifestModel = this.mLivePlayerSourceModel.mAdaptiveManifestList.get(0);
                if (liveAdaptiveManifestModel.mAdaptationSet != null && liveAdaptiveManifestModel.mAdaptationSet.mRepresentation != null) {
                    Iterator<LiveAdaptionModel> it = liveAdaptiveManifestModel.mAdaptationSet.mRepresentation.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (it.next().mIsDefaultSelect) {
                            this.mCurrentPlayingSwitchIndex = i;
                            break;
                        }
                        i++;
                    }
                }
            }
        } else if (this.mDataSourceType == KSLiveDataSourceType.kMultiUrl) {
            this.mHostSwitcher.initMultiPlayUrlsSwitcher(this.mCurrentMultiPlayUrls);
        } else {
            this.mHostSwitcher.initUrlSwitcher(this.mCurrentDataSource);
        }
        this.mLivePlayQualityStatistics.setLiveStreamId(this.mLiveVideoContext.liveStreamId);
    }

    private void initSwitcher() {
        if (this.mDataSourceType == KSLiveDataSourceType.kManifest) {
            this.mHostSwitcher.initAdaptiveManifestSwitcher(this.mLivePlayerSourceModel.mAdaptiveManifestList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ef A[Catch: IOException -> 0x0101, TRY_LEAVE, TryCatch #0 {IOException -> 0x0101, blocks: (B:24:0x00e5, B:26:0x00eb, B:27:0x00ef), top: B:37:0x00e5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kwai.video.player.IKwaiMediaPlayer createKwaiPlayerInternal() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.createKwaiPlayerInternal():com.kwai.video.player.IKwaiMediaPlayer");
    }

    private void setLivePlayerJsonToKwaiPlayer(IKwaiMediaPlayer iKwaiMediaPlayer) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("play_start_time", this.mPlayStartTimeMs);
            jSONObject.put("stream_id", this.mLiveVideoContext.liveStreamId);
            jSONObject.put("domain", this.mLivePlayQualityStatistics.getHost());
            iKwaiMediaPlayer.setAppQosStatJson(jSONObject);
        } catch (JSONException unused) {
        }
    }

    private Map<String, String> getManifestHeader() {
        String str;
        HashMap map = new HashMap();
        LiveAdaptiveManifestModel manifestModel = this.mCurrentLiveManifest.getManifestModel();
        if (TextUtils.isEmpty(manifestModel.mHost)) {
            str = null;
        } else {
            if (TextUtils.isEmpty(this.mLiveVideoContext.liveStreamHost)) {
                this.mLivePlayQualityStatistics.setHost(manifestModel.mHost);
            }
            str = manifestModel.mHost;
        }
        if (str != null) {
            map.put("Host", str);
        }
        return map;
    }

    private Map<String, String> getUrlHeader() {
        HashMap map = new HashMap();
        HostSwitcher.ResolvedUrl currentResolvedUrl = this.mHostSwitcher.getCurrentResolvedUrl();
        if (!TextUtils.isEmpty(currentResolvedUrl.host)) {
            map.put("Host", currentResolvedUrl.host);
        }
        if (TextUtils.isEmpty(this.mLiveVideoContext.liveStreamHost)) {
            this.mLivePlayQualityStatistics.setHost(currentResolvedUrl.host);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchHostAndRebuildPlayer(KSCoreLivePlayer.UrlSwitchInfo urlSwitchInfo) {
        this.mLivePlayQualityStatistics.setRetryReason(urlSwitchInfo.mSwitchReason);
        if (this.mHostSwitcher.isLast()) {
            this.mLiveRetryHelper.setEnable(false);
            if (this.mOnUrlSwitchListener != null) {
                this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KSCoreLivePlayerImpl.this.mOnUrlSwitchListener != null) {
                            KSCoreLivePlayerImpl.this.mOnUrlSwitchListener.onRunOutOfUrls();
                        }
                    }
                });
                return;
            }
            return;
        }
        IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
        if (iKwaiMediaPlayer != null) {
            iKwaiMediaPlayer.stopLiveStatTimerImmediately();
        }
        retryStartAndCallback(urlSwitchInfo);
        this.mHostSwitcher.moveToNext();
        synchronized (this.mLock) {
            this.mLivePlayQualityStatistics.addRetryCount();
            rebuildPlayer();
        }
    }

    private void retryStartAndCallback(final KSCoreLivePlayer.UrlSwitchInfo urlSwitchInfo) {
        this.mLiveRetryHelper.setRetryState(1);
        if (this.mOnUrlSwitchListener != null) {
            this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.14
                @Override // java.lang.Runnable
                public void run() {
                    if (KSCoreLivePlayerImpl.this.mOnUrlSwitchListener != null) {
                        KSCoreLivePlayerImpl.this.mOnUrlSwitchListener.onUrlSwitch(urlSwitchInfo);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retrySuccessAndCallbackIfNeed() {
        if (this.mLiveRetryHelper.getRetryState() != 1) {
            return;
        }
        this.mLiveRetryHelper.setRetryState(2);
    }

    private void rebuildPlayer() throws JSONException {
        addLivePlayQualityStatSlice();
        this.mLivePlayQualityStatistics.logEndBufferTimeThenAddIfNeed();
        this.mLivePlayQualityStatistics.logStartBufferTime();
        IKwaiMediaPlayer iKwaiMediaPlayerCreateKwaiPlayerInternal = createKwaiPlayerInternal();
        iKwaiMediaPlayerCreateKwaiPlayerInternal.prepareAsync();
        IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
        if (iKwaiMediaPlayer != null) {
            iKwaiMediaPlayer.releaseAsync();
            this.mCurrentPlayer = null;
        }
        this.mCurrentPlayer = iKwaiMediaPlayerCreateKwaiPlayerInternal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postLivePlayerQos(final IMediaPlayer iMediaPlayer, final JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        try {
            jSONObject.put("retry_cnt", Math.max(0, this.mLivePlayQualityStatistics.getRetryCount() - this.mLastRetryCount));
            jSONObject.put("retry_reason", this.mLivePlayQualityStatistics.getRetryReason());
            this.mLastRetryCount = this.mLivePlayQualityStatistics.getRetryCount();
            this.mLivePlayQualityStatistics.setRetryReason(0);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("qos", jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        KSLiveVideoContext kSLiveVideoContext = this.mLiveVideoContext;
        if (kSLiveVideoContext != null && (jSONObject2 = kSLiveVideoContext.extra) != null) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("stats_extra", jSONObject2.toString());
                jSONObject3.put("stats", jSONObject4.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        KSLivePlayerLogUploader.logEvent("VP_KWAI_PLAYER_QOS", jSONObject3.toString());
        if (this.mOnLiveQosStatListener != null) {
            this.mMainHandler.post(new Runnable() { // from class: com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl.15
                @Override // java.lang.Runnable
                public void run() {
                    if (KSCoreLivePlayerImpl.this.mOnLiveQosStatListener != null) {
                        KSCoreLivePlayerImpl.this.mOnLiveQosStatListener.onQosStat(iMediaPlayer, jSONObject);
                    }
                }
            });
        }
    }

    private void uploadLivePlayQualityStat() throws JSONException {
        this.mLivePlayQualityStatistics.logEnd();
        IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
        if (iKwaiMediaPlayer != null) {
            this.mLivePlayQualityStatistics.addTraffic(iKwaiMediaPlayer.getDownloadDataSize()).fillDroppedFieldsWithStreamQosInfo(this.mCurrentPlayer.getStreamQosInfo()).setPlayerQosJson(this.mCurrentPlayer.getLiveStatJson()).addBufferTime(this.mCurrentPlayer.bufferEmptyDuration()).addBlockCount(this.mCurrentPlayer.bufferEmptyCount()).logEndBufferTimeThenAddIfNeed().upload();
        }
    }

    private void addLivePlayQualityStatSlice() {
        IKwaiMediaPlayer iKwaiMediaPlayer = this.mCurrentPlayer;
        if (iKwaiMediaPlayer != null) {
            this.mLivePlayQualityStatistics.addTraffic(iKwaiMediaPlayer.getDownloadDataSize()).fillDroppedFieldsWithStreamQosInfo(this.mCurrentPlayer.getStreamQosInfo()).addBufferTime(this.mCurrentPlayer.bufferEmptyDuration()).addBlockCount(this.mCurrentPlayer.bufferEmptyCount());
        }
    }

    private KwaiPlayerLiveBuilder buildDefaultKwaiPlayerLiveBuilder() {
        KwaiPlayerLiveBuilder kwaiPlayerLiveBuilder = new KwaiPlayerLiveBuilder(this.mContext);
        KwaiPlayerConfig.Builder builder = new KwaiPlayerConfig.Builder();
        kwaiPlayerLiveBuilder.setBufferTimeMaxSec(this.mLivePlayerConfig.bufferTimeMaxSec);
        kwaiPlayerLiveBuilder.setConfigJson(this.mLivePlayerConfig.configJson);
        kwaiPlayerLiveBuilder.setAsyncStreamOpen(this.mLivePlayerConfig.enableAsyncStreamOpen());
        kwaiPlayerLiveBuilder.setUseAlignedPts(this.mLivePlayerConfig.enableAlignedPts);
        if (this.mDataSourceType == KSLiveDataSourceType.kManifest) {
            kwaiPlayerLiveBuilder.setIsLiveManifest(true);
            builder.setLiveAdaptiveQosDuration(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            builder.setEnableLiveAdaptiveQos(true);
            builder.setEnableLiveAdaptiveAdditionalQos(true);
            builder.setMaxBufferDuration(10000);
        }
        builder.setQosDuration(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        builder.setEnableQos(true);
        builder.setMaxBufferTime(4000);
        kwaiPlayerLiveBuilder.setKwaiPlayerConfig(builder.build());
        kwaiPlayerLiveBuilder.setUseNatvieCache(true);
        kwaiPlayerLiveBuilder.setHevcDcoderName(KwaiPlayerBaseBuilder.HEVC_DECODER_NAME_KS265);
        return kwaiPlayerLiveBuilder;
    }
}
