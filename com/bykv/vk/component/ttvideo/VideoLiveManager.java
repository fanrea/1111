package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.sdk.internal.ca;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.log.LiveLoggerService;
import com.bykv.vk.component.ttvideo.log.LogBundle;
import com.bykv.vk.component.ttvideo.log.MyLog;
import com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener;
import com.bykv.vk.component.ttvideo.medialoader.MediaLoaderWrapper;
import com.bykv.vk.component.ttvideo.model.LiveInfoSource;
import com.bykv.vk.component.ttvideo.model.LiveStreamInfo;
import com.bykv.vk.component.ttvideo.model.LiveURL;
import com.bykv.vk.component.ttvideo.network.DnsHelper;
import com.bykv.vk.component.ttvideo.network.LiveDataFetcher;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.player.TTPlayerConfiger;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.playerwrapper.PlayerSetting;
import com.bykv.vk.component.ttvideo.retry.RetryProcessor;
import com.bykv.vk.component.ttvideo.utils.LiveThreadPool;
import com.bykv.vk.component.ttvideo.utils.LiveUtils;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.tc.c.c;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.openadsdk.zw.an;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import com.kwai.video.player.misc.KsMediaFormat;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class VideoLiveManager implements ILivePlayer {
    private static final int AUDIOSTREAM = 1;
    private static final int AV_NO_SYNC_THRESHOLD = 10000;
    private static final int BITRATE_ABNORNAL = 1;
    private static final int BITRATE_NORMAL = 0;
    private static final int BOTHSTREAM = 2;
    private static final int CHECK_SEI_INTERVAL = 3000;
    private static final int DEFAULT_RTC_FALLBACK_THRESHOLD = 5000;
    private static final int DEFAULT_RTC_MIN_JITTER_BUFFER = 300;
    private static final String HTTP_FLV_ABR_PREFIX = "mem://llash/";
    private static final int INIT_MTU = 1200;
    public static final int KeyIsGetSeiDelay = 100;
    public static final int KeyIsGetStreamMaxBitrate = 0;
    private static final int LIVE_ABR_CHECK_DEFAULT_INTERVAL = 1000;
    private static final int MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE = 501;
    private static final int MSG_SEI_CHECK = 110;
    private static final int NOTIFY_ALL_SEI_THRESHOLD = 1000;
    private static final String RTC_LOG_PREFIX = "rtc_log_level";
    private static final int RTC_VENDER_TYPE_ALIBABA = 1;
    private static final int RTC_VENDER_TYPE_BYTE = 0;
    private static final int RTC_VENDER_TYPE_OTHERS = 3;
    private static final int RTC_VENDER_TYPE_TECENT = 2;
    private static final String SEI_PREFIX = "JSON";
    private static final int STALL_RECOVER_FROM_BUFFERINGEND = 1;
    private static final int STALL_RECOVER_FROM_RETRY = 2;
    private static final int STALl_NO_RECOVER = 0;
    private static final String TAG = "VideoLiveManager";
    public static final int TEX_LIVE = 1;
    public static final int TEX_VOD = 0;
    private static final int VIDEOSTREAM = 0;
    private static int mAudioRenderStallThreshold = 200;
    private static int mDecoderStallThreshold = 600;
    private static int mDemuxerStallThreshold = 900;
    private static int mFastOpenDuration = -1;
    private static boolean mIsSettingsUpdate = false;
    private static JSONObject mSettingsInfo = null;
    private static int mVideoRenderStallThreshold = 500;
    private int mABRBufferThreshold;
    private int mABRDisableAlgorithm;
    private int mABRMethod;
    private long mALogWriteAddr;
    private int mAVNoSyncThreshold;
    private int mAVPHAudioMaxDuration;
    private int mAVPHAudioProbesize;
    private int mAVPHAutoExit;
    private int mAVPHDnsParseEnable;
    private int mAVPHDnsTimeout;
    private int mAVPHEnableAutoReopen;
    private int mAVPHMaxAVDiff;
    private int mAVPHOpenVideoFirst;
    private int mAVPHReadErrorExit;
    private int mAVPHReadRetryCount;
    private int mAVPHVideoDiffThreshold;
    private int mAVPHVideoMaxDuration;
    private int mAVPHVideoProbesize;
    private String mAbrStrategy;
    private long mAudioLastRenderTime;
    private String mAudioOnly;
    private int mAudioTimescaleEnable;
    private float mAudioVolumeBalancePredelay;
    private float mAudioVolumeBalancePregain;
    private float mAudioVolumeBalanceRatio;
    private float mAudioVolumeBalanceThreshold;
    private int mBufferDataSeconds;
    private int mBufferTimeout;
    private int mByteVC1DecoderType;
    private int mCacheFileEnable;
    private String mCacheFileKey;
    private String mCacheFilePath;
    private boolean mCancelSDKDNSFailRetry;
    private float mCatchSpeed;
    private String mCdnAbrResolution;
    private String mCdnSessionPath;
    private int mCheckBufferingEndAdvanceEnable;
    private int mCheckBufferingEndIgnoreVideo;
    public boolean mCheckSupportSR;
    private boolean mCmafEnable;
    private final Context mContext;
    private String mCurrentIP;
    private String mCurrentPlayURL;
    private int mCurrentRetryCount;
    private int mDefaultCodecId;
    private int mDefaultResBitrate;
    private final DnsHelper mDnsParser;
    private int mEnableAbrStallDegradeImmediately;
    private int mEnableAudioVolumeBalance;
    private String mEnableAvLines;
    private int mEnableByteVC1HardwareDecode;
    private int mEnableCacheSei;
    private int mEnableCheckDropAudio;
    private int mEnableCheckFrame;
    private int mEnableCheckPacketCorrupt;
    private int mEnableCheckSEI;
    private int mEnableClosePlayRetry;
    private int mEnableCmafFastMode;
    private int mEnableCmafOptimizeRetry;
    private int mEnableDTSCheck;
    private int mEnableDecodeMultiSei;
    private int mEnableDecodeSeiOnce;
    private int mEnableDecoderStall;
    private int mEnableDemuxerStall;
    private boolean mEnableDns;
    private boolean mEnableDnsOptimizer;
    private int mEnableDroppingDTSRollFrame;
    private int mEnableFastOpenStream;
    private int mEnableFlvABR;
    private int mEnableFreeFlow;
    private int mEnableH264HardwareDecode;
    private int mEnableHttpPrepare;
    private int mEnableHttpkDegrade;
    private int mEnableHurryFlag;
    private int mEnableLLASHFastOpen;
    private int mEnableLiveAbrCheckEnhance;
    private int mEnableLiveIOP2P;
    private int mEnableLiveIOPlay;
    private int mEnableLowLatencyFLV;
    private int mEnableMediaCodecASYNCInit;
    private int mEnableNTP;
    private int mEnableNTPTask;
    private int mEnableNotifySeiImmediatelyBeforeFirstFrame;
    private int mEnableOpenLiveIO;
    private int mEnableOpenMDL;
    private int mEnableOptimizeBackup;
    private boolean mEnableOriginResolution;
    private int mEnableP2pUp;
    private int mEnablePreventDTSBack;
    private boolean mEnableQuicCertVerify;
    private int mEnableQuicDegrade;
    private int mEnableQuicMTUDiscovery;
    public int mEnableRadioLiveDisableRender;
    private int mEnableRenderStall;
    private int mEnableReportSessionStop;
    private boolean mEnableResolutionAutoDegrade;
    private int mEnableRtcPlay;
    private boolean mEnableSaveSCFG;
    private boolean mEnableSeiCheck;
    private int mEnableSharp;
    public int mEnableSharpen;
    private int mEnableSkipFindUnnecessaryStream;
    private int mEnableSkipFlvNullTag;
    private int mEnableSplitStream;
    private int mEnableStallCounter;
    private int mEnableStallRetryInstantly;
    private boolean mEnableSwitchMainAndBackupUrl;
    private int mEnableTcpFastOpen;
    private int mEnableTextureRender;
    private int mEnableTextureSR;
    private int mEnableUploadSei;
    private boolean mEnableUploadSessionSeries;
    private int mEnableUseLiveThreadPool;
    private int mEnableVideoMpdRefresh;
    private int mEnhancementType;
    private boolean mEnterStallRetryInstantly;
    private ExecutorService mExecutor;
    private LiveDataFetcher mFetcher;
    private int mForceDecodeMsGaps;
    private int mForceDecodeSwitch;
    private boolean mForceHttpDns;
    private int mForceRenderMsGaps;
    private long mFrameDroppingDTSMaxDiff;
    private Object mFrameMetaDataListener;
    private long mFrameTerminatedDTS;
    private int mFramesDrop;
    private long mGetSeiCurrentTime;
    private int mGopDuration;
    private int mHardwareDecodeEnable;
    private int mHardwareRTCDecodeEnable;
    private boolean mHasAbrInfo;
    private boolean mHasRetry;
    private boolean mHasSeiInfo;
    private int mHlsLiveStartIndex;
    private String mHttpDNSServerHost;
    private int mHurryTime;
    private int mHurryType;
    private MyInvocationHandler mInvocationHandler;
    private int mIsAlwaysDoAVSync;
    private boolean mIsCacheHasComplete;
    private int mIsInMainLooper;
    private boolean mIsLiveIOProtoRegister;
    private boolean mIsLocalURL;
    private boolean mIsMdlProtoRegister;
    private boolean mIsPlayWithLiveIO;
    private boolean mIsPlayWithMdl;
    private boolean mIsRequestCanceled;
    private boolean mIsRetrying;
    private boolean mIsStalling;
    private long mLatestAudioPacketDTS;
    private int mLayoutType;
    private String mLevel;
    private final ILiveListener mListener;
    private int mLiveABRCheckInterval;
    private int mLiveIOABGroupID;
    private LivePlayerState mLivePlayerState;
    private String mLocalURL;
    private LiveLoggerService mLogService;
    private boolean mLooping;
    private JSONObject mLowLatencyFLVStrategy;
    private int mMaxCacheSeconds;
    private int mMaxFileCacheSize;
    private int mMaxTextureHeight;
    private int mMaxTextureWidth;
    public boolean mMediaSupportSR;
    private boolean mMediaSupportSharpen;
    private String mMoudleIDToB;
    private final Handler mMyHandler;
    private final INetworkClient mNetworkClient;
    private int mNetworkTimeout;
    private int mNoSyncReportMinDuration;
    private int mNoSyncReportReportThres;
    private List<String> mNodeOptimizeResults;
    private int mOpenCheckSideData;
    private MediaPlayer mPlayer;
    private int mPlayerCache;
    private int mPlayerDegradeMode;
    private final PlayerSetting mPlayerSetting;
    private final int mPlayerType;
    private PlayerState mPrepareState;
    private int mQuicConfigOptimize;
    private boolean mQuicEnable;
    private int mQuicFixProcessTimer;
    private int mQuicFixStreamFinAndRst;
    private int mQuicFixWillingAndAbleToWrite;
    private int mQuicInitMTU;
    private int mQuicInitRtt;
    private int mQuicMaxAckDelay;
    private int mQuicMaxCryptoRetransmissionTimeMs;
    private int mQuicMaxCryptoRetransmissions;
    private int mQuicMaxRetransmissionTimeMs;
    private int mQuicMaxRetransmissions;
    private int mQuicMinReceivedBeforeAckDecimation;
    private int mQuicPadHello;
    private boolean mQuicPull;
    private int mQuicReadBlockMode;
    private int mQuicReadBlockTimeout;
    private int mQuicTimerVersion;
    private int mQuicVersion;
    private boolean mRedoDns;
    private String mReliable;
    public boolean mRenderStartEntered;
    public long mRenderStartNotifyTimeStamp;
    private int mRenderType;
    private String mResolution;
    private boolean mResolutionDisableSR;
    private int mResolutionIndex;
    private final RetryProcessor mRetryProcessor;
    private long mRetryStartTime;
    private int mRtcEarlyInitRender;
    private int mRtcEnableDtls;
    private int mRtcEnableRtcUninitLockFree;
    private int mRtcEnableSDKDns;
    private int mRtcFallbackThreshold;
    private int mRtcMaxJitterBuffer;
    private int mRtcMaxRetryCount;
    private int mRtcMinJitterBuffer;
    private int mRtcPlayFallBack;
    private int mRtcPlayLogInterval;
    private int mRtcSupportMiniSdp;
    private int mScaleType;
    private long mSeiDiffThres;
    private String mSessionId;
    private int mSessionNum;
    private int mSessionReceiveWindow;
    private long mSessionRenderStartTime;
    private long mSessionStartTime;
    private final ILiveSettingBundle mSettingsBundle;
    private float mSharpenAmount;
    private float mSharpenEdgeWeightGamma;
    private int mSharpenMaxHeight;
    private int mSharpenMaxWidth;
    private int mSharpenMode;
    private float mSharpenOverRatio;
    private int mSharpenPowerLevel;
    private int mSharpenSceneMode;
    private JSONObject mSharpenSdkParams;
    private boolean mShowedFirstFrame;
    private float mSlowPlaySpeed;
    private int mSlowPlayTime;
    private int mStallCount;
    private int mStallCountThresOfResolutionDegrade;
    private Handler mStallCounterHandler;
    private int mStallCounterInterval;
    private volatile boolean mStallCounterIsRunning;
    private final Object mStallCounterLock;
    private HandlerThread mStallCounterThread;
    public long mStallRetryTimeIntervalManager;
    private long mStallStartTime;
    private long mStallTotalTime;
    private int mStartDirectAfterPrepared;
    private long mStartPlayBufferThres;
    private String mStreamFormat;
    private int mStreamReceiveWindow;
    private String mSuggestProtocol;
    private boolean mSupportBackupIp;
    public int mSupportSRScene;
    private int mSupportSharpenScene;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private int mSwitchToB;
    private long mTargetOriginBitRate;
    private int mTestAction;
    private String mTextureRenderErrorMsg;
    private boolean mTextureRenderFirstFrame;
    private String mTextureSRBinPath;
    private String mTextureSRDspModuleName;
    public int mTextureSRMode;
    private String mTextureSROclModuleName;
    private String mTransportProtocol;
    private int mTslMinTimeShit;
    private int mTslTimeShift;
    private int mURLAbility;
    private String mURLHost;
    private String mURLProtocol;
    private final LiveInfoSource mURLSource;
    private int mUrlSettingMethod;
    private int mUseExternalDir;
    private boolean mUsePlayerRenderStart;
    private boolean mUserSwitchResoultion;
    private String mUuid;
    private long mVideoLastRenderTime;
    private String mVideoOnly;
    private final VideoStallCountTask mVideoStallCountTask;

    private enum LivePlayerState {
        IDLE,
        PLAYED,
        PAUSED,
        STOPPED
    }

    private enum PlayerState {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String convertCodecName(int i) {
        switch (i) {
            case 1:
                return "IOSHWCodec";
            case 2:
                return "hardware_codec";
            case 3:
                return "ff_H264_codec";
            case 4:
                return "ff_ByteVC1_codec";
            case 5:
                return "KS_ByteVC1_codec";
            case 6:
                return "JX_ByteVC1_codec";
            default:
                return "none_codec";
        }
    }

    private String prepareLiveIOURL(String str, String str2, Map<String, String> map) {
        return str;
    }

    void doResolutionChange(String str) {
    }

    public boolean getSRState() {
        return false;
    }

    public boolean getSharpenState() {
        return false;
    }

    public boolean isUsedSR() {
        return false;
    }

    public boolean isUsedSharpen() {
        return false;
    }

    public void releaseTextureRenderRef() {
    }

    public void setTextureRenderLogListener() {
    }

    public void setupTextureRender() {
    }

    static /* synthetic */ int access$4408(VideoLiveManager videoLiveManager) {
        int i = videoLiveManager.mStallCount;
        videoLiveManager.mStallCount = i + 1;
        return i;
    }

    private static class NamedThreadFactory implements ThreadFactory {
        private NamedThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            com.bytedance.sdk.component.tc.c.b bVar = new com.bytedance.sdk.component.tc.c.b(runnable, VideoLiveManager.TAG);
            bVar.setPriority(10);
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnCurrentThread(Runnable runnable) {
        this.mMyHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnCurrentThreadDelay(Runnable runnable, long j) {
        this.mMyHandler.postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnFrontCurrentThread(Runnable runnable) {
        this.mMyHandler.postAtFrontOfQueue(runnable);
    }

    private VideoLiveManager(Builder builder) {
        this.mMyHandler = new Handler(Looper.myLooper());
        this.mURLSource = new LiveInfoSource();
        this.mEnableTextureRender = 0;
        this.mEnableTextureSR = 0;
        this.mResolutionDisableSR = true;
        this.mTextureSRBinPath = "none";
        this.mTextureSROclModuleName = "test";
        this.mTextureSRDspModuleName = "test";
        this.mTextureRenderErrorMsg = null;
        this.mEnableOpenMDL = 0;
        this.mIsMdlProtoRegister = false;
        this.mIsPlayWithMdl = false;
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        this.mIsRequestCanceled = false;
        this.mShowedFirstFrame = false;
        this.mHasRetry = false;
        this.mLooping = false;
        this.mPlayerCache = 0;
        this.mEnhancementType = 0;
        this.mScaleType = 0;
        this.mLayoutType = 0;
        this.mRenderType = 3;
        this.mHardwareDecodeEnable = 0;
        this.mHardwareRTCDecodeEnable = 0;
        this.mCacheFileEnable = -1;
        this.mTestAction = -1;
        this.mUseExternalDir = -1;
        this.mMaxFileCacheSize = -1;
        this.mByteVC1DecoderType = 1;
        this.mBufferDataSeconds = -1;
        this.mBufferTimeout = -1;
        this.mNetworkTimeout = -1;
        this.mPlayerDegradeMode = 0;
        this.mEnableSharp = 0;
        this.mDefaultCodecId = -1;
        this.mEnableMediaCodecASYNCInit = 0;
        this.mHurryType = -1;
        this.mHurryTime = 0;
        this.mCatchSpeed = -1.0f;
        this.mSlowPlayTime = -1;
        this.mSlowPlaySpeed = -1.0f;
        this.mEnableHurryFlag = -1;
        this.mCacheFilePath = null;
        this.mCacheFileKey = null;
        this.mIsCacheHasComplete = false;
        this.mCurrentPlayURL = null;
        this.mCurrentIP = null;
        this.mStallCount = 0;
        this.mIsStalling = false;
        this.mEnableResolutionAutoDegrade = false;
        this.mAbrStrategy = LiveConfigKey.RAD;
        this.mHasAbrInfo = false;
        this.mDefaultResBitrate = -1;
        this.mStallCountThresOfResolutionDegrade = 4;
        this.mEnableSwitchMainAndBackupUrl = true;
        this.mEnableVideoMpdRefresh = 1;
        this.mEnableCmafFastMode = 0;
        this.mEnableCmafOptimizeRetry = 0;
        this.mEnableDTSCheck = 0;
        this.mEnablePreventDTSBack = 0;
        this.mFrameDroppingDTSMaxDiff = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        this.mFrameTerminatedDTS = -1L;
        this.mLatestAudioPacketDTS = -1L;
        this.mSessionId = null;
        this.mEnableCheckFrame = 0;
        this.mEnableCheckSEI = 0;
        this.mGopDuration = 4;
        this.mFrameMetaDataListener = null;
        this.mInvocationHandler = null;
        this.mLocalURL = null;
        this.mIsLocalURL = false;
        this.mALogWriteAddr = -1L;
        this.mResolution = LiveConfigKey.ORIGIN;
        this.mResolutionIndex = -1;
        this.mLevel = LiveConfigKey.MAIN;
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mSuggestProtocol = "none";
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mURLProtocol = "none";
        this.mEnableAvLines = "";
        this.mVideoOnly = "";
        this.mAudioOnly = "";
        this.mReliable = "";
        this.mForceDecodeSwitch = 0;
        this.mForceDecodeMsGaps = 0;
        this.mForceRenderMsGaps = 0;
        this.mFramesDrop = 15;
        this.mAVPHDnsParseEnable = 0;
        this.mAVPHDnsTimeout = 2000000;
        this.mAVPHVideoProbesize = 4096;
        this.mAVPHVideoMaxDuration = KSTubeParamInner.FREE_ALL;
        this.mAVPHAudioProbesize = 4096;
        this.mAVPHAudioMaxDuration = KSTubeParamInner.FREE_ALL;
        this.mAVPHOpenVideoFirst = 1;
        this.mAVPHMaxAVDiff = 10000;
        this.mAVPHAutoExit = 1;
        this.mAVPHEnableAutoReopen = 0;
        this.mAVPHVideoDiffThreshold = 15000;
        this.mAVPHReadRetryCount = 100;
        this.mAVPHReadErrorExit = 1;
        this.mEnableSkipFindUnnecessaryStream = 0;
        this.mEnableRenderStall = 1;
        this.mAudioLastRenderTime = -1L;
        this.mVideoLastRenderTime = -1L;
        this.mIsRetrying = false;
        this.mEnableDemuxerStall = 1;
        this.mEnableDecoderStall = 1;
        this.mEnableStallCounter = 0;
        this.mStallCounterInterval = 2000;
        this.mEnableClosePlayRetry = 0;
        this.mEnableCheckDropAudio = 0;
        this.mURLAbility = 1;
        this.mStallStartTime = 0L;
        this.mStallTotalTime = 0L;
        this.mRetryStartTime = 0L;
        this.mEnableNTP = 0;
        this.mEnableNTPTask = 0;
        this.mEnableDns = true;
        this.mEnableDnsOptimizer = false;
        this.mEnableUploadSessionSeries = false;
        this.mEnableH264HardwareDecode = 0;
        this.mEnableByteVC1HardwareDecode = 0;
        this.mMaxCacheSeconds = -1;
        this.mEnableSplitStream = 0;
        this.mOpenCheckSideData = 1;
        this.mEnableHttpkDegrade = 0;
        this.mEnableQuicDegrade = 1;
        this.mEnableFastOpenStream = 1;
        this.mEnableUploadSei = 1;
        this.mSeiDiffThres = 8000L;
        this.mEnableSeiCheck = false;
        this.mHasSeiInfo = false;
        this.mGetSeiCurrentTime = 0L;
        this.mStartPlayBufferThres = 0L;
        this.mCheckBufferingEndIgnoreVideo = 0;
        this.mStartDirectAfterPrepared = 0;
        this.mCheckBufferingEndAdvanceEnable = 0;
        this.mEnableTcpFastOpen = 0;
        this.mEnableCheckPacketCorrupt = 0;
        this.mEnableLowLatencyFLV = 0;
        this.mLowLatencyFLVStrategy = null;
        this.mEnableDroppingDTSRollFrame = 0;
        this.mIsInMainLooper = 1;
        this.mCmafEnable = false;
        this.mQuicEnable = false;
        this.mQuicVersion = 39;
        this.mEnableSaveSCFG = false;
        this.mEnableQuicCertVerify = false;
        this.mQuicInitMTU = 1200;
        this.mEnableQuicMTUDiscovery = 0;
        this.mQuicPadHello = 1;
        this.mQuicFixWillingAndAbleToWrite = 1;
        this.mQuicFixProcessTimer = 1;
        this.mQuicReadBlockTimeout = 100;
        this.mQuicReadBlockMode = 0;
        this.mQuicFixStreamFinAndRst = 0;
        this.mQuicConfigOptimize = 0;
        this.mQuicTimerVersion = 1;
        this.mQuicPull = false;
        this.mQuicInitRtt = 0;
        this.mQuicMaxCryptoRetransmissions = 0;
        this.mQuicMaxCryptoRetransmissionTimeMs = 0;
        this.mQuicMaxRetransmissions = 0;
        this.mQuicMaxRetransmissionTimeMs = 0;
        this.mQuicMaxAckDelay = 0;
        this.mQuicMinReceivedBeforeAckDecimation = 0;
        this.mSessionReceiveWindow = -1;
        this.mStreamReceiveWindow = -1;
        this.mAVNoSyncThreshold = 10000;
        this.mIsAlwaysDoAVSync = 0;
        this.mEnableFlvABR = 0;
        this.mEnableLLASHFastOpen = 0;
        this.mForceHttpDns = false;
        this.mHttpDNSServerHost = null;
        this.mCancelSDKDNSFailRetry = false;
        this.mUrlSettingMethod = -1;
        this.mUserSwitchResoultion = false;
        this.mEnterStallRetryInstantly = false;
        this.mEnableStallRetryInstantly = 1;
        this.mNodeOptimizeResults = null;
        this.mRedoDns = false;
        this.mEnableOptimizeBackup = 0;
        this.mSupportBackupIp = true;
        this.mTextureSRMode = 0;
        this.mRenderStartNotifyTimeStamp = 0L;
        this.mRenderStartEntered = false;
        this.mEnableAudioVolumeBalance = 0;
        this.mAudioVolumeBalancePregain = -1.0f;
        this.mAudioVolumeBalanceThreshold = -1.0f;
        this.mAudioVolumeBalanceRatio = -1.0f;
        this.mAudioVolumeBalancePredelay = -1.0f;
        this.mEnableCacheSei = 0;
        this.mEnableDecodeMultiSei = 0;
        this.mEnableDecodeSeiOnce = 0;
        this.mEnableSkipFlvNullTag = 0;
        this.mEnableNotifySeiImmediatelyBeforeFirstFrame = 1;
        this.mEnableLiveAbrCheckEnhance = 0;
        this.mLiveABRCheckInterval = 1000;
        this.mABRMethod = -1;
        this.mABRBufferThreshold = -1;
        this.mTslTimeShift = -1;
        this.mTslMinTimeShit = 60;
        this.mEnableOriginResolution = false;
        this.mTargetOriginBitRate = -1L;
        this.mEnableAbrStallDegradeImmediately = 1;
        this.mHlsLiveStartIndex = -3;
        this.mCdnSessionPath = null;
        this.mCdnAbrResolution = null;
        this.mAudioTimescaleEnable = -1;
        this.mStallRetryTimeIntervalManager = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        this.mMediaSupportSR = false;
        this.mSupportSRScene = 0;
        this.mCheckSupportSR = false;
        this.mStallCounterThread = null;
        this.mStallCounterHandler = null;
        this.mVideoStallCountTask = new VideoStallCountTask();
        this.mStallCounterLock = new Object();
        this.mStallCounterIsRunning = false;
        this.mEnableRtcPlay = 0;
        this.mRtcPlayFallBack = 0;
        this.mRtcFallbackThreshold = 5000;
        this.mRtcEnableDtls = 1;
        this.mRtcMinJitterBuffer = 300;
        this.mRtcMaxJitterBuffer = 2000;
        this.mRtcEnableSDKDns = 0;
        this.mRtcEarlyInitRender = 0;
        this.mRtcMaxRetryCount = 0;
        this.mRtcSupportMiniSdp = 0;
        this.mCurrentRetryCount = 0;
        this.mRtcPlayLogInterval = 5000;
        this.mRtcEnableRtcUninitLockFree = 0;
        this.mEnableRadioLiveDisableRender = 0;
        this.mSwitchToB = 0;
        this.mMoudleIDToB = "";
        this.mURLHost = "";
        this.mABRDisableAlgorithm = 0;
        this.mTextureRenderFirstFrame = false;
        this.mUsePlayerRenderStart = false;
        this.mMaxTextureWidth = 0;
        this.mMaxTextureHeight = 0;
        this.mEnableReportSessionStop = 0;
        this.mSessionNum = 0;
        this.mSessionStartTime = 0L;
        this.mSessionRenderStartTime = 0L;
        this.mIsLiveIOProtoRegister = false;
        this.mEnableOpenLiveIO = 0;
        this.mIsPlayWithLiveIO = false;
        this.mEnableLiveIOPlay = 0;
        this.mEnableLiveIOP2P = 0;
        this.mEnableHttpPrepare = 0;
        this.mEnableFreeFlow = 0;
        this.mEnableP2pUp = 0;
        this.mLiveIOABGroupID = 0;
        this.mNoSyncReportMinDuration = 5000;
        this.mNoSyncReportReportThres = 2000;
        this.mEnableUseLiveThreadPool = 0;
        this.mExecutor = null;
        this.mEnableSharpen = 0;
        this.mSharpenMode = 0;
        this.mMediaSupportSharpen = false;
        this.mSupportSharpenScene = -1;
        this.mSharpenMaxWidth = 1920;
        this.mSharpenMaxHeight = 1080;
        this.mSharpenPowerLevel = 0;
        this.mSharpenAmount = -1.0f;
        this.mSharpenOverRatio = -1.0f;
        this.mSharpenEdgeWeightGamma = 6.0f;
        this.mSharpenSceneMode = 1;
        this.mSharpenSdkParams = null;
        Context context = builder.mContext;
        this.mContext = context;
        ILiveListener iLiveListener = builder.mListener;
        this.mListener = iLiveListener;
        ILiveSettingBundle iLiveSettingBundle = builder.mSettingsBundle;
        this.mSettingsBundle = iLiveSettingBundle;
        builder.setStallRetryInterval(this.mStallRetryTimeIntervalManager);
        if (iLiveSettingBundle != null) {
            this.mEnableReportSessionStop = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_should_report_session_stop", 0)).intValue();
            this.mEnableUseLiveThreadPool = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_enable_use_live_threadpool", 0)).intValue();
        }
        if (this.mEnableUseLiveThreadPool == 1 && builder.mLiveThreadPool != null) {
            MyLog.i(TAG, "use live threadpool");
            this.mExecutor = builder.mLiveThreadPool;
            this.mLogService.mUseLiveThreadPool = 1;
        } else {
            MyLog.i(TAG, "create new threadpool");
            this.mExecutor = new c(1, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new NamedThreadFactory() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.1
            });
        }
        LiveLoggerService liveLoggerService = new LiveLoggerService(this, iLiveListener, builder.mUploadLogInterval, builder.mStallRetryTimeInterval, context, this.mEnableReportSessionStop);
        this.mLogService = liveLoggerService;
        liveLoggerService.setProjectKey(builder.mProjectKey);
        MediaLoaderWrapper.getDataLoader().setLogService(this.mLogService);
        this.mRetryProcessor = new RetryProcessor(new MyRetryListener(this), builder.mRetryTimeout, builder.mStallRetryTimeInterval, this.mLogService);
        this.mPlayerSetting = new PlayerSetting(context, null);
        boolean z = builder.mForceHttpDns;
        this.mForceHttpDns = z;
        this.mLogService.mEnableHttpDns = z;
        INetworkClient iNetworkClient = builder.mNetworkClient;
        this.mNetworkClient = iNetworkClient;
        DnsHelper dnsHelper = new DnsHelper(context, this.mExecutor, iNetworkClient);
        this.mDnsParser = dnsHelper;
        dnsHelper.updateDNSServerIP();
        this.mPlayerType = builder.mPlayerType;
        this.mStreamFormat = builder.mVideoFormat;
        this.mResolution = builder.mResolution;
        this.mStallCount = 0;
        this.mEnableResolutionAutoDegrade = builder.mEnableResolutionAutoDegrade;
        this.mEnableSwitchMainAndBackupUrl = builder.mEnableSwitchMainAndBackupUrl;
        this.mSeiDiffThres = builder.mSeiCheckTimeOut;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        checkMainLooper("setSurfaceHolder");
        this.mSurfaceHolder = surfaceHolder;
        if (this.mPlayer != null) {
            this.mLogService.mSetSurfaceTime = System.currentTimeMillis();
            this.mPlayer.setDisplay(surfaceHolder);
            this.mLogService.mSetSurfaceCost = System.currentTimeMillis() - this.mLogService.mSetSurfaceTime;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setSurface(Surface surface) {
        checkMainLooper("setSurface");
        MyLog.i(TAG, "setsurface: " + surface);
        this.mSurface = surface;
        if (this.mPlayer != null) {
            this.mLogService.mSetSurfaceTime = System.currentTimeMillis();
            this.mPlayer.setSurface(surface);
            this.mLogService.mSetSurfaceCost = System.currentTimeMillis() - this.mLogService.mSetSurfaceTime;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPlayURLs(LiveURL[] liveURLArr) {
        MyLog.i(TAG, "setPlayUrls, sdkParam:" + liveURLArr[0].sdkParams);
        checkMainLooper("setPlayURLS");
        this.mURLSource.setPlayURLs(liveURLArr);
        this.mUrlSettingMethod = 0;
        if (this.mCurrentPlayURL == null || this.mURLSource.getPlayLiveURL().mainURL == this.mCurrentPlayURL) {
            return;
        }
        _reset("setPlayURLs");
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean playResolution(String str) throws JSONException, NumberFormatException {
        MyLog.i(TAG, "playResolution:" + str);
        checkMainLooper("playResolution");
        if (this.mURLSource.getSourceType() != 2 || this.mPrepareState != PlayerState.PREPARED) {
            return false;
        }
        if (this.mResolution.equals(str)) {
            MyLog.i(TAG, "playResolution: same res=" + str);
            return true;
        }
        this.mRetryProcessor.reset();
        this.mResolutionIndex = -1;
        this.mStallCount = 0;
        this.mLogService.onSwitch(this.mCurrentPlayURL, "none", "setting_" + this.mResolution + "_to_" + str, 0);
        this.mLogService.mAbrSwitchInfo = "manual_abr_" + this.mResolution + "_to_" + str;
        saveCurrentResolution();
        this.mResolution = str;
        if (this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) || (this.mAbrStrategy.equals(LiveConfigKey.RAD) && !str.equals("auto"))) {
            String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mStreamFormat, this.mLevel);
            if (TextUtils.isEmpty(playURLForResolution)) {
                MyLog.w(TAG, str + " playUrl not exist");
                return false;
            }
            updateDownloadSizeStat();
            this.mLogService.onSessionStop();
            this.mIsRetrying = true;
            _stopPlayer();
            _resetPlayer();
            this.mLogService.onSwitchURL(playURLForResolution);
            this.mUserSwitchResoultion = true;
            this.mLogService.mSessionStartTime = System.currentTimeMillis();
            parsePlayDNS(playURLForResolution);
        }
        return true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setStreamInfo(String str) {
        JSONObject jSONObject;
        MyLog.i(TAG, "setStreamInfo:" + str);
        this.mLogService.mStreamData = str;
        checkMainLooper("setStreamInfo");
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            jSONObject = null;
            mq.d(e);
        }
        if (jSONObject == null) {
            return;
        }
        _reset("setStreamInfo");
        this.mURLSource.setStreamInfo(new LiveStreamInfo(jSONObject));
        this.mUrlSettingMethod = 1;
        _setLooseSync();
    }

    private void _setLooseSync() {
        LiveInfoSource liveInfoSource = this.mURLSource;
        if (liveInfoSource == null) {
            return;
        }
        String sDKParams = liveInfoSource.getSDKParams(this.mResolution, this.mLevel);
        if (TextUtils.isEmpty(sDKParams)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(sDKParams);
            if (jSONObject.has("ForceDecodeSwitch")) {
                this.mForceDecodeSwitch = jSONObject.optInt("ForceDecodeSwitch");
            }
            if (jSONObject.has("ForceDecodeMsGaps")) {
                this.mForceDecodeMsGaps = jSONObject.optInt("ForceDecodeMsGaps");
            }
            if (jSONObject.has("ForceRenderMsGaps")) {
                this.mForceRenderMsGaps = jSONObject.optInt("ForceRenderMsGaps");
            }
        } catch (JSONException e) {
            mq.d(e);
        }
    }

    private void _setStreamFormat() throws JSONException {
        String str;
        String suggestFormat = this.mURLSource.getSuggestFormat(this.mResolution, this.mLevel);
        if (suggestFormat != null) {
            if (suggestFormat.equals(LiveConfigKey.CMAF) && !this.mCmafEnable) {
                try {
                    LibraryLoader.loadLibrary("ttmcmaf");
                    this.mCmafEnable = true;
                    MyLog.i(TAG, "cmaf lib is load success");
                    str = suggestFormat;
                } catch (Throwable unused) {
                    this.mURLSource.setStreamInfoFlag(1);
                    str = this.mStreamFormat;
                    this.mCmafEnable = false;
                    MyLog.i(TAG, "cmaf lib is load failed. change default format");
                }
                this.mStreamFormat = str;
                this.mLogService.setFormatInfo(suggestFormat, str);
            } else if (suggestFormat.equals("lls")) {
                this.mEnableRtcPlay = 1;
                this.mLogService.mEnableRtcPlay = 1;
                try {
                    MyLog.i(TAG, "lls load bytertc library");
                    an.d("byteaudio");
                    an.d("bytenn");
                    an.d("bytertc");
                    MyLog.i(TAG, "lls load bytertc library done");
                    str = suggestFormat;
                } catch (Throwable unused2) {
                    this.mURLSource.setStreamInfoFlag(2);
                    str = this.mStreamFormat;
                    this.mEnableRtcPlay = 0;
                    this.mLogService.mEnableRtcPlay = 0;
                    MyLog.i(TAG, "bytertc lib is load failed. change default format");
                }
                this.mStreamFormat = str;
                this.mLogService.setFormatInfo(suggestFormat, str);
            } else {
                str = suggestFormat;
                this.mStreamFormat = str;
                this.mLogService.setFormatInfo(suggestFormat, str);
            }
        } else {
            this.mStreamFormat = LiveConfigKey.FLV;
            this.mLogService.setFormatInfo("none", LiveConfigKey.FLV);
        }
        if (!TextUtils.isEmpty(this.mStreamFormat) && this.mStreamFormat.equals(LiveConfigKey.FLV)) {
            _setAvLines();
            if (!this.mEnableAvLines.isEmpty() && !this.mVideoOnly.isEmpty() && !this.mAudioOnly.isEmpty() && this.mEnableAvLines.equals("true") && this.mVideoOnly.equals(LiveConfigKey.ONLYVIDEO) && this.mAudioOnly.equals(LiveConfigKey.ONLYAUDIO)) {
                this.mStreamFormat = LiveConfigKey.AVPH;
                this.mLogService.setFormatInfo(LiveConfigKey.AVPH, LiveConfigKey.AVPH);
            }
        }
        if (TextUtils.isEmpty(this.mStreamFormat) || !this.mStreamFormat.equals(LiveConfigKey.AVPH)) {
            return;
        }
        _configAvphNeqStrategy();
    }

    private void _setProtocol() {
        String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mStreamFormat, this.mLevel);
        if (playURLForResolution != null) {
            this.mLogService.setOriginUrl(playURLForResolution);
            if (playURLForResolution.startsWith(com.alipay.sdk.m.l.a.r)) {
                this.mTransportProtocol = LiveConfigKey.TCP;
            }
            if (playURLForResolution.startsWith("httpk")) {
                this.mTransportProtocol = LiveConfigKey.KCP;
            }
            if (playURLForResolution.startsWith("https")) {
                this.mTransportProtocol = LiveConfigKey.TLS;
            }
            this.mURLProtocol = this.mTransportProtocol;
        }
        String suggestProtocol = this.mURLSource.getSuggestProtocol(this.mResolution, this.mLevel);
        this.mSuggestProtocol = suggestProtocol;
        if (suggestProtocol != null) {
            if ((suggestProtocol.equals(LiveConfigKey.QUIC) || this.mSuggestProtocol.equals(LiveConfigKey.QUICU)) && !this.mQuicEnable) {
                try {
                    LibraryLoader.loadLibrary("ttquic");
                    this.mQuicEnable = true;
                    MyLog.i(TAG, "ttquic lib is load success");
                    this.mLogService.setQuicLibLoader(1);
                } catch (Throwable unused) {
                    suggestProtocol = this.mTransportProtocol;
                    this.mQuicEnable = false;
                    MyLog.i(TAG, "ttquic lib is load failed. change default protocol");
                    this.mLogService.setQuicLibLoader(0);
                }
            }
            this.mTransportProtocol = suggestProtocol;
            return;
        }
        this.mSuggestProtocol = "none";
    }

    private void _configAvphNeqStrategy() throws JSONException {
        JSONObject jSONObject;
        String str = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_low_latency_flv_default_strategy_map", "");
        if (str.length() > 0) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                mq.d(e);
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null && jSONObject.has("net_effective_connection_type_strategy")) {
            try {
                jSONObject.getJSONObject("net_effective_connection_type_strategy");
            } catch (JSONException e2) {
                mq.d(e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void _setAvLines() {
        /*
            r6 = this;
            java.lang.String r0 = "AudioOnly"
            java.lang.String r1 = "VideoOnly"
            java.lang.String r2 = "IsEnable"
            com.bykv.vk.component.ttvideo.model.LiveInfoSource r3 = r6.mURLSource
            java.lang.String r4 = r6.mResolution
            java.lang.String r5 = r6.mLevel
            java.lang.String r3 = r3.getAvLinesParams(r4, r5)
            if (r3 != 0) goto L13
            return
        L13:
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L42
            r5.<init>(r3)     // Catch: org.json.JSONException -> L42
            boolean r3 = r5.has(r2)     // Catch: org.json.JSONException -> L42
            if (r3 == 0) goto L24
            java.lang.String r2 = r5.optString(r2)     // Catch: org.json.JSONException -> L42
            goto L25
        L24:
            r2 = r4
        L25:
            boolean r3 = r5.has(r1)     // Catch: org.json.JSONException -> L3f
            if (r3 == 0) goto L30
            java.lang.String r1 = r5.optString(r1)     // Catch: org.json.JSONException -> L3f
            goto L31
        L30:
            r1 = r4
        L31:
            boolean r3 = r5.has(r0)     // Catch: org.json.JSONException -> L3d
            if (r3 == 0) goto L48
            java.lang.String r0 = r5.optString(r0)     // Catch: org.json.JSONException -> L3d
            r4 = r0
            goto L48
        L3d:
            r0 = move-exception
            goto L45
        L3f:
            r0 = move-exception
            r1 = r4
            goto L45
        L42:
            r0 = move-exception
            r1 = r4
            r2 = r1
        L45:
            com.bytedance.sdk.component.utils.mq.d(r0)
        L48:
            if (r2 == 0) goto L4c
            r6.mEnableAvLines = r2
        L4c:
            if (r1 == 0) goto L50
            r6.mVideoOnly = r1
        L50:
            if (r4 == 0) goto L54
            r6.mAudioOnly = r4
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager._setAvLines():void");
    }

    public String set_url_port_scheme(String str, String str2) {
        int iIndexOf;
        int iIndexOf2 = str.indexOf(".com");
        int iIndexOf3 = str.indexOf(".com:");
        StringBuilder sb = new StringBuilder(str);
        if (str2 != null) {
            if (iIndexOf3 != -1) {
                int i = iIndexOf3 + 5;
                int i2 = i + 1;
                while (i2 < sb.length() && sb.charAt(i2) - '0' >= 0 && sb.charAt(i2) - '0' <= 9) {
                    i2++;
                }
                sb.replace(i, i2, str2);
            } else if (iIndexOf2 != -1 && ((iIndexOf = str.indexOf("vhost")) == -1 || iIndexOf > iIndexOf2)) {
                sb.insert(iIndexOf2 + 4, ":" + str2);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int iIndexOf4 = sb2.indexOf("://");
        if (this.mURLSource.getSourceType() == 2) {
            if (this.mTransportProtocol.equals(LiveConfigKey.KCP)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, "httpk");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.QUIC) || this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, "httpq");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TLS)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, "https");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TCP) && iIndexOf4 != -1) {
                sb2.replace(0, iIndexOf4, com.alipay.sdk.m.l.a.r);
            }
        }
        return sb2.toString();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLocalURL(String str) {
        checkMainLooper("setLocalURL");
        if (str != null && !str.equals(this.mLocalURL) && this.mLocalURL != null) {
            reset();
        }
        this.mLocalURL = str;
        this.mIsLocalURL = true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLooping(boolean z) {
        this.mLooping = z;
        if (this.mPlayer == null || !this.mIsLocalURL || TextUtils.isEmpty(this.mLocalURL)) {
            return;
        }
        this.mPlayer.setLooping(this.mLooping);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPreviewFlag(boolean z) {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService != null) {
            liveLoggerService.setPreviewFlag(z);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setCommonFlag(String str) {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService != null) {
            liveLoggerService.setCommonFlag(str);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setProjectKey(String str) {
        this.mLogService.setProjectKey(str);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void openNTP() {
        this.mEnableNTPTask = 1;
        this.mLogService.openNTP();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void closeDNS() {
        this.mEnableDns = false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void enableUploadSessionSeries() {
        this.mEnableUploadSessionSeries = true;
        this.mLogService.mEnableUploadSessionSeries = true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void enableSeiCheck() {
        this.mEnableSeiCheck = true;
        this.mLogService.mEnableSeiCheck = true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void closeSeiCheck() {
        this.mEnableSeiCheck = false;
        this.mLogService.mEnableSeiCheck = false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public long getSeiDelay() {
        return this.mLogService.getInt64Value(100, 0L);
    }

    private void configPlayerEventHandler() {
        this.mPlayer.setOnPreparedListener(new MyPreparedListener(this));
        this.mPlayer.setOnErrorListener(new MyErrorListener(this));
        this.mPlayer.setOnInfoListener(new MyInfoListener(this));
        this.mPlayer.setOnCompletionListener(new MyCompletionListener(this));
        this.mPlayer.setOnVideoSizeChangedListener(new MyOnVideoSizeChangedListener(this));
    }

    private void configPlayerGlobalOption() {
        LiveURL playLiveURL;
        int i;
        int i2;
        MediaPlayer mediaPlayer;
        boolean z;
        int i3;
        this.mPlayer.setIntOption(9, this.mNetworkTimeout * 1000000);
        this.mPlayer.setIntOption(83, this.mTestAction);
        this.mPlayer.setIntOption(37, this.mEnhancementType);
        this.mPlayer.setIntOption(38, this.mScaleType);
        StringBuilder sb = new StringBuilder();
        this.mPlayer.setIntOption(325, 0);
        this.mPlayer.setIntOption(36, this.mLayoutType);
        this.mPlayer.setIntOption(110, 5000);
        this.mPlayer.setIntOption(64, 0);
        this.mPlayer.setIntOption(94, 1);
        this.mPlayer.setIntOption(56, this.mRenderType);
        _configLiveSettingBundle();
        _configWithSDKParams();
        configToBParams();
        this.mLogService.mEnableFastOpenStream = this.mEnableFastOpenStream;
        this.mPlayer.setIntOption(220, this.mEnableFastOpenStream);
        MyLog.i(TAG, "set fast open stream");
        this.mPlayer.setIntOption(56, this.mRenderType);
        this.mPlayer.setIntOption(340, this.mEnableCheckDropAudio);
        this.mPlayer.setIntOption(52, this.mEnableUploadSei);
        if (this.mEnableDTSCheck == 1 || this.mEnableCheckFrame == 1 || this.mEnableCheckSEI == 1) {
            this.mPlayer.setIntOption(640, 1);
        }
        this.mPlayer.setIntOption(641, 1);
        if (this.mEnableClosePlayRetry == 1) {
            this.mPlayer.setIntOption(197, 0);
            this.mPlayer.setIntOption(82, 0);
        }
        this.mLogService.mHasAbrInfo = this.mHasAbrInfo;
        this.mLogService.mAbrStrategy = this.mAbrStrategy;
        this.mLogService.mEnableResolutionAutoDegrade = this.mEnableResolutionAutoDegrade;
        this.mLogService.mStallCountThresOfResolutionDegrade = this.mStallCountThresOfResolutionDegrade;
        this.mLogService.mStallRetryTimeInterval = this.mStallRetryTimeIntervalManager;
        this.mRetryProcessor.setStallRetryTimeInterval(this.mStallRetryTimeIntervalManager);
        int i4 = this.mEnableSharp;
        if (i4 == 1) {
            this.mPlayer.setIntOption(189, i4);
            LiveLoggerService liveLoggerService = this.mLogService;
            if (liveLoggerService != null) {
                liveLoggerService.enableSharp();
            }
        }
        String vCodec = null;
        if (this.mURLSource.getSourceType() == 2) {
            vCodec = this.mURLSource.getVCodec(this.mResolution, this.mLevel);
        } else if (this.mURLSource.getSourceType() == 1 && (playLiveURL = this.mURLSource.getPlayLiveURL()) != null) {
            vCodec = playLiveURL.getVCodec();
        }
        if (vCodec != null) {
            if (vCodec != null && vCodec.equals(KsMediaFormat.CODEC_NAME_H264)) {
                this.mHardwareDecodeEnable = this.mEnableH264HardwareDecode;
                this.mDefaultCodecId = 0;
            } else if (vCodec != null && vCodec.equals("bytevc1")) {
                this.mHardwareDecodeEnable = this.mEnableByteVC1HardwareDecode;
                this.mDefaultCodecId = 1;
            } else {
                this.mHardwareDecodeEnable = 0;
            }
            LiveLoggerService liveLoggerService2 = this.mLogService;
            if (vCodec == null) {
                vCodec = "";
            }
            liveLoggerService2.mUrlAbility = vCodec;
        } else {
            this.mHardwareDecodeEnable = 0;
        }
        this.mHardwareDecodeEnable = 1;
        this.mEnableMediaCodecASYNCInit = 1;
        this.mPlayer.setIntOption(800, this.mEnableRtcPlay);
        if (this.mEnableRtcPlay == 1) {
            MyLog.i(TAG, "rtc close hardware decode");
            this.mPlayer.setIntOption(59, 0);
            this.mPlayer.setIntOption(181, 0);
            int i5 = (this.mHardwareRTCDecodeEnable == 1 && this.mHardwareDecodeEnable == 1) ? 1 : 0;
            MyLog.i(TAG, "rts decode mHardwareDecodeEnable:" + this.mHardwareDecodeEnable + ", mHardwareRTCDecodeEnable: " + this.mHardwareRTCDecodeEnable);
            MyLog.i(TAG, "rts decode  hardware decode " + (i5 == 1 ? "True" : "False"));
            this.mPlayer.setIntOption(880, i5);
        } else {
            this.mPlayer.setIntOption(59, this.mHardwareDecodeEnable);
            this.mLogService.enableHardDecode(this.mHardwareDecodeEnable == 1);
            if (this.mHardwareDecodeEnable == 1) {
                MyLog.i(TAG, "enable hardware decode");
                if (this.mDefaultCodecId != -1) {
                    MyLog.i(TAG, "set hardware async init");
                    this.mPlayer.setIntOption(181, this.mEnableMediaCodecASYNCInit);
                    this.mPlayer.setIntOption(182, this.mDefaultCodecId);
                    this.mLogService.mMediaCodecAsyncInit = this.mEnableMediaCodecASYNCInit;
                    this.mLogService.mDefaultCodecID = this.mDefaultCodecId;
                }
            }
            this.mPlayer.setIntOption(97, this.mHardwareDecodeEnable);
            this.mPlayer.setIntOption(536, 500000);
        }
        int i6 = this.mByteVC1DecoderType;
        if (i6 != -1 && this.mEnableByteVC1HardwareDecode != 1) {
            this.mPlayer.setIntOption(67, i6);
        }
        int i7 = this.mBufferTimeout;
        if (i7 != -1) {
            this.mPlayer.setIntOption(81, i7);
        }
        float f = this.mCatchSpeed;
        if (f > 0.0f) {
            this.mPlayer.setFloatOption(80, f);
            this.mLogService.mCatchSpeed = this.mCatchSpeed;
        }
        if (this.mCacheFileEnable == -1 && this.mCacheFilePath != null) {
            String string = new StringBuilder().append(System.currentTimeMillis()).toString();
            this.mCacheFileKey = string;
            this.mPlayer.setStringOption(17, string);
            this.mPlayer.setIntOption(14, 1);
            this.mPlayer.setCacheFile(this.mCacheFilePath, 1);
        }
        int i8 = this.mHurryType;
        if (i8 != -1) {
            this.mPlayer.setIntOption(84, i8);
            this.mLogService.mEnableHurry = true;
        }
        if (this.mHurryType == 0 && (i3 = this.mHurryTime) != 0) {
            this.mPlayer.setIntOption(15, i3);
            this.mLogService.mHurryTime = this.mHurryTime;
        }
        if (this.mIsLocalURL && !TextUtils.isEmpty(this.mLocalURL) && (z = this.mLooping)) {
            this.mPlayer.setLooping(z);
        }
        int i9 = this.mBufferDataSeconds;
        if (i9 != -1) {
            this.mPlayer.setIntOption(86, i9);
        }
        int i10 = this.mSlowPlayTime;
        if (i10 != -1) {
            this.mPlayer.setIntOption(190, i10);
            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
        }
        float f2 = this.mSlowPlaySpeed;
        if (f2 > 0.0f) {
            this.mPlayer.setFloatOption(191, f2);
            this.mLogService.mSlowSpeed = this.mSlowPlaySpeed;
        }
        int i11 = this.mMaxCacheSeconds;
        if (i11 != -1) {
            this.mPlayer.setIntOption(24, i11);
            this.mPlayer.setIntOption(198, this.mMaxCacheSeconds);
            this.mLogService.mMaxCacheSeconds = this.mMaxCacheSeconds;
        }
        int i12 = this.mEnableSplitStream;
        if (i12 != 0) {
            this.mPlayer.setIntOption(87, i12);
            this.mLogService.mEnableSplitStream = this.mEnableSplitStream;
        }
        long j = this.mStartPlayBufferThres;
        if (j > 0) {
            this.mPlayer.setLongOption(309, j);
            this.mLogService.mStartPlayBufferThres = this.mStartPlayBufferThres;
        }
        int i13 = this.mCheckBufferingEndIgnoreVideo;
        if (i13 == 1) {
            this.mPlayer.setIntOption(310, i13);
            this.mLogService.mCheckBufferingEndIgnoreVideo = this.mCheckBufferingEndIgnoreVideo;
        }
        int i14 = this.mStartDirectAfterPrepared;
        if (i14 == 1) {
            this.mPlayer.setIntOption(311, i14);
            this.mLogService.mStartDirectAfterPrepared = this.mStartDirectAfterPrepared;
        }
        int i15 = this.mCheckBufferingEndAdvanceEnable;
        if (i15 == 1) {
            this.mPlayer.setIntOption(313, i15);
            this.mLogService.mCheckBufferingEndAdvanceEnable = this.mCheckBufferingEndAdvanceEnable;
        }
        int i16 = this.mOpenCheckSideData;
        if (i16 == 1) {
            this.mPlayer.setIntOption(132, i16);
        }
        int i17 = this.mAudioTimescaleEnable;
        if (i17 != -1) {
            this.mPlayer.setIntOption(460, i17);
            this.mLogService.mAudioTimescaleEnable = this.mAudioTimescaleEnable;
        }
        this.mLogService.mEnableUploadSessionSeries = this.mEnableUploadSessionSeries;
        if (this.mEnableNTPTask == 1) {
            this.mLogService.openNTP();
        }
        if (this.mEnableOpenMDL == 1) {
            this.mLogService.mEnableOpenMDL = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8100);
            this.mLogService.mEnableP2P = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8101);
            this.mLogService.mMDLVersion = MediaLoaderWrapper.getDataLoader().getStringValueFromLoader(11);
            this.mLogService.mEnableMdlProto = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8102);
            MediaLoaderWrapper.getDataLoader().setListener(new MyMediaLoaderListener(this));
            if (!this.mIsMdlProtoRegister && MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8102) == 1) {
                long longValueFromLoader = MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(7218);
                if (longValueFromLoader != -1) {
                    this.mIsMdlProtoRegister = this.mPlayer.setLongOption(500, longValueFromLoader) == 0;
                }
                MyLog.i(TAG, "get mdl proto ret:" + longValueFromLoader + ", register ret:" + this.mIsMdlProtoRegister);
            }
        }
        this.mEnableOpenLiveIO = 0;
        this.mEnableLiveIOPlay = 0;
        this.mEnableRtcPlay = 0;
        long j2 = this.mALogWriteAddr;
        if (j2 != -1) {
            this.mPlayer.setLongOption(231, j2);
            this.mPlayer.setIntOption(223, 1);
        }
        String str = this.mStreamFormat;
        if (str != null) {
            this.mPlayer.setStringOption(315, str);
        }
        String str2 = this.mStreamFormat;
        if (str2 != null && str2.equals(LiveConfigKey.AVPH)) {
            prepareAvphPlay();
        }
        this.mPlayer.setIntOption(347, this.mAVNoSyncThreshold);
        this.mPlayer.setIntOption(348, this.mIsAlwaysDoAVSync);
        this.mPlayer.setIntOption(323, this.mEnableRenderStall);
        if (this.mEnableRenderStall == 1) {
            this.mPlayer.setIntOption(321, mAudioRenderStallThreshold);
            this.mPlayer.setIntOption(322, mVideoRenderStallThreshold);
        }
        this.mPlayer.setIntOption(360, this.mEnableDemuxerStall);
        this.mPlayer.setIntOption(461, this.mNoSyncReportReportThres);
        if (this.mEnableDemuxerStall == 1) {
            this.mPlayer.setIntOption(362, mDemuxerStallThreshold);
            this.mPlayer.setLongOption(364, -1L);
            this.mPlayer.setLongOption(365, -1L);
        }
        this.mPlayer.setIntOption(361, this.mEnableDecoderStall);
        if (this.mEnableDecoderStall == 1) {
            this.mPlayer.setIntOption(363, mDecoderStallThreshold);
            this.mPlayer.setLongOption(366, -1L);
            this.mPlayer.setLongOption(367, -1L);
        }
        this.mPlayer.setIntOption(380, this.mEnableStallCounter);
        int i18 = this.mEnableTcpFastOpen;
        if (i18 == 1 && this.mPlayer != null) {
            this.mLogService.mEnableTcpFastOpen = i18;
            this.mPlayer.setIntOption(316, this.mEnableTcpFastOpen);
            sb.append("live_enable_tcp_fast_open:1,");
        }
        MediaPlayer mediaPlayer2 = this.mPlayer;
        if (mediaPlayer2 != null) {
            int i19 = this.mEnableCmafFastMode;
            if (i19 == 1) {
                mediaPlayer2.setIntOption(611, i19);
                sb.append("live_enable_cmaf_fast_mode:1 ");
            }
            this.mPlayer.setIntOption(680, this.mEnableCmafOptimizeRetry);
        }
        MediaPlayer mediaPlayer3 = this.mPlayer;
        if (mediaPlayer3 != null) {
            mediaPlayer3.setIntOption(642, this.mEnableVideoMpdRefresh);
        }
        int i20 = this.mEnableCheckPacketCorrupt;
        if (i20 == 1 && (mediaPlayer = this.mPlayer) != null) {
            mediaPlayer.setIntOption(317, i20);
            sb.append("live_enable_check_packet_corrupt:1,");
        }
        if (this.mEnableResolutionAutoDegrade && this.mURLSource.getSourceType() == 2 && this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE)) {
            i = 1;
            if (this.mABRDisableAlgorithm == 1) {
                this.mPlayer.setIntOption(651, 1);
            }
        } else {
            i = 1;
        }
        if (this.mEnableFlvABR == i) {
            sb.append("live_enable_flv_abr:1,");
        }
        if (this.mEnableOptimizeBackup == i) {
            sb.append("live_enable_optimize_backup:1,");
        }
        if (this.mEnableStallRetryInstantly == i) {
            sb.append("live_enable_stall_retry_instantly:1 ");
        } else {
            sb.append("live_enable_stall_retry_instantly:0 ");
        }
        if (this.mEnableCacheSei == i) {
            sb.append("live_enable_sei_pts_sync:1 ");
            this.mPlayer.setIntOption(368, i);
            this.mPlayer.setIntOption(369, 1000);
        }
        if (this.mEnableDecodeMultiSei == i) {
            sb.append("live_enable_decode_multi_sei:1 ");
            this.mPlayer.setIntOption(372, i);
        }
        if (this.mEnableDecodeSeiOnce == i) {
            sb.append("live_enable_decode_sei_once:1 ");
            this.mPlayer.setIntOption(648, i);
        }
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            if (((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_super_resolution_enable", 0)).intValue() == i) {
                sb.append("live_sdk_super_resolution_enable:1 ");
            } else {
                sb.append("live_sdk_super_resolution_enable:0 ");
            }
        }
        if (this.mEnableTextureRender == i) {
            sb.append("live_sdk_texture_render_enable:1 ");
        } else {
            sb.append("live_sdk_texture_render_enable:0 ");
        }
        ILiveSettingBundle iLiveSettingBundle2 = this.mSettingsBundle;
        if (iLiveSettingBundle2 != null) {
            i2 = 1;
            if (((Integer) iLiveSettingBundle2.getSettingsValueForKey("live_sdk_sharpen_enable", 0)).intValue() == 1) {
                sb.append("live_sdk_sharpen_enable:1 ");
            } else {
                sb.append("live_sdk_sharpen_enable:0 ");
            }
        } else {
            i2 = 1;
        }
        if (this.mEnableOpenLiveIO == i2) {
            sb.append("live_sdk_enable_liveio:1 ");
        }
        if (this.mEnableAudioVolumeBalance == i2) {
            sb.append("live_sdk_audio_volume_balance_enable:1 ");
            if (this.mAudioVolumeBalancePregain != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_pregain:" + this.mAudioVolumeBalancePregain + " ");
            }
            if (this.mAudioVolumeBalanceThreshold != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_threshold:" + this.mAudioVolumeBalanceThreshold + " ");
            }
            if (this.mAudioVolumeBalanceRatio != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_ratio:" + this.mAudioVolumeBalanceRatio + " ");
            }
            if (this.mAudioVolumeBalancePredelay != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_predelay:" + this.mAudioVolumeBalancePredelay + " ");
            }
        }
        if (this.mEnableNotifySeiImmediatelyBeforeFirstFrame == 1) {
            sb.append("live_sdk_notifysei_immediately_before_firstframe:1 ");
            this.mPlayer.setIntOption(649, 1);
        }
        if (this.mEnableRadioLiveDisableRender == 1) {
            sb.append("live_sdk_enable_radiolive_disable_render:1 ");
        }
        if (this.mLogService.mHostNTPUrl != null) {
            sb.append("live_sdk_ntp_server_name:" + this.mLogService.mHostNTPUrl + " ");
        }
        if (this.mEnableReportSessionStop == 1) {
            sb.append("live_sdk_should_report_session_stop:1 ");
            this.mLogService.mEnableReportSessionStop = 1;
        }
        if (this.mUsePlayerRenderStart) {
            sb.append("live_sdk_texturerender_use_player_renderstart:1 ");
        }
        if (this.mEnableFreeFlow == 1) {
            sb.append("live_sdk_isfreeflow:1 ");
        }
        if (this.mEnableDroppingDTSRollFrame == 1) {
            sb.append("live_sdk_dropping_dts_rollback_frame_enabled:1 ");
            this.mPlayer.setIntOption(148, this.mEnableDroppingDTSRollFrame);
        }
        if (this.mEnableUseLiveThreadPool == 1) {
            sb.append("live_sdk_enable_use_live_threadpool:1 ");
        }
        this.mLogService.mIsInMainLooper = this.mIsInMainLooper;
        this.mLogService.mSettingsInfo = sb.length() == 0 ? "none" : sb.deleteCharAt(sb.length() - 1).toString();
        if (!TextUtils.isEmpty(this.mStreamFormat) && (this.mStreamFormat.equals(LiveConfigKey.HLS) || this.mStreamFormat.equals(LiveConfigKey.TSL))) {
            this.mPlayer.setIntOption(298, this.mHlsLiveStartIndex);
        }
        this.mLogService.mEnableLowLatencyFLV = this.mEnableLowLatencyFLV;
        this.mLogService.mFastOpenDuration = mFastOpenDuration;
    }

    private void configToBParams() {
        MediaPlayer mediaPlayer;
        if (this.mSwitchToB != 1 || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        mediaPlayer.setStringOption(509, this.mMoudleIDToB);
    }

    private void configPlayerInstanceOption() {
        String str;
        this.mLogService.setProtocolInfo(this.mSuggestProtocol, this.mTransportProtocol);
        this.mLogService.setSdkParams(this.mURLSource.getSDKParams(this.mResolution, this.mLevel));
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null && (str = this.mStreamFormat) != null) {
            mediaPlayer.setStringOption(315, str);
        }
        MediaPlayer mediaPlayer2 = this.mPlayer;
        if (mediaPlayer2 == null || this.mEnableAudioVolumeBalance != 1) {
            return;
        }
        mediaPlayer2.setIntOption(302, 1);
        float f = this.mAudioVolumeBalancePregain;
        if (f != -1.0f) {
            this.mPlayer.setFloatOption(303, f);
        }
        float f2 = this.mAudioVolumeBalanceThreshold;
        if (f2 != -1.0f) {
            this.mPlayer.setFloatOption(304, f2);
        }
        float f3 = this.mAudioVolumeBalanceRatio;
        if (f3 != -1.0f) {
            this.mPlayer.setFloatOption(305, f3);
        }
        float f4 = this.mAudioVolumeBalancePredelay;
        if (f4 != -1.0f) {
            this.mPlayer.setFloatOption(306, f4);
        }
    }

    private void _configLiveSettingBundle() {
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle == null) {
            return;
        }
        this.mEnableCheckDropAudio = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_enable_check_drop_audio", 0)).intValue();
        this.mRenderType = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_option_render_type", 3)).intValue();
        this.mEnableCmafFastMode = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_cmaf_fast_mode", 0)).intValue();
        this.mStartPlayBufferThres = ((Long) this.mSettingsBundle.getSettingsValueForKey("live_start_play_buffer_thres", 0L)).longValue();
        this.mCheckBufferingEndIgnoreVideo = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_check_buffering_end_ignore_video", 0)).intValue();
        this.mStartDirectAfterPrepared = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_direct_start_after_prepared", 0)).intValue();
        this.mCheckBufferingEndAdvanceEnable = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_check_buffering_end_advance", 0)).intValue();
        if (!this.mHasAbrInfo) {
            this.mEnableResolutionAutoDegrade = ((Boolean) this.mSettingsBundle.getSettingsValueForKey("live_enable_resolution_degrade", Boolean.FALSE)).booleanValue();
            this.mStallCountThresOfResolutionDegrade = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_stall_count_thres_for_degrade", 4)).intValue();
        }
        MyLog.i(TAG, "mEnableResolutionAutoDegrade:" + this.mEnableResolutionAutoDegrade + " mStallCountThresOfResolutionDegrade:" + this.mStallCountThresOfResolutionDegrade);
        this.mEnableOpenMDL = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_open_mdl_enable", 0)).intValue();
        MyLog.i(TAG, "enable mdl:" + this.mEnableOpenMDL);
        this.mEnableTcpFastOpen = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_tcp_fast_open", 0)).intValue();
        MyLog.i(TAG, "enable tfo:" + this.mEnableTcpFastOpen);
        this.mEnableCheckPacketCorrupt = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_check_packet_corrupt", 0)).intValue();
        this.mEnableFlvABR = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_flv_abr", 0)).intValue();
        this.mForceHttpDns = ((Boolean) this.mSettingsBundle.getSettingsValueForKey("live_sdk_http_dns_enabled", Boolean.FALSE)).booleanValue();
        this.mHttpDNSServerHost = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_http_dns_server_host", ILogConst.CACHE_PLAY_REASON_NULL);
        this.mLogService.mEnableHttpDns = this.mForceHttpDns;
        MyLog.i(TAG, "enable http dns:" + this.mForceHttpDns + " http dns server: " + this.mHttpDNSServerHost);
        this.mLogService.mHostNTPUrl = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_ntp_server_name", ILogConst.CACHE_PLAY_REASON_NULL);
        this.mCancelSDKDNSFailRetry = ((Boolean) this.mSettingsBundle.getSettingsValueForKey("live_sdk_cancel_sdk_dns_fail_retry", Boolean.FALSE)).booleanValue();
        this.mEnableClosePlayRetry = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_close_play_retry", 0)).intValue();
        this.mEnableOptimizeBackup = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_optimize_backup_enabled", 0)).intValue();
        MyLog.i(TAG, "enable optimize backup ip:" + this.mEnableOptimizeBackup);
        this.mEnableStallRetryInstantly = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_stall_retry_instantly_enabled", 1)).intValue();
        this.mEnableAudioVolumeBalance = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_enable", 0)).intValue();
        this.mAudioVolumeBalancePregain = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_pregain", Float.valueOf(-1.0f))).floatValue();
        this.mAudioVolumeBalanceThreshold = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_threshold", Float.valueOf(-1.0f))).floatValue();
        this.mAudioVolumeBalanceRatio = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_ratio", Float.valueOf(-1.0f))).floatValue();
        this.mAudioVolumeBalancePredelay = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_predelay", Float.valueOf(-1.0f))).floatValue();
        MyLog.i(TAG, "audio balance:" + this.mEnableAudioVolumeBalance + "," + this.mAudioVolumeBalancePregain + "," + this.mAudioVolumeBalanceThreshold + "," + this.mAudioVolumeBalanceRatio + "," + this.mAudioVolumeBalancePredelay);
        this.mEnableCacheSei = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_sei_pts_synced", 0)).intValue();
        MyLog.i(TAG, "enable sei pts sync:" + this.mEnableCacheSei);
        this.mStallRetryTimeIntervalManager = ((Long) this.mSettingsBundle.getSettingsValueForKey("stall_retry_time_interval_manager", Long.valueOf(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT))).longValue();
        this.mEnableDecodeMultiSei = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_decode_multi_sei", 0)).intValue();
        this.mEnableRadioLiveDisableRender = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_radiolive_disable_render", 0)).intValue();
        this.mEnableOpenLiveIO = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_liveio", 0)).intValue();
        this.mEnableDecodeSeiOnce = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_decode_sei_once", 0)).intValue();
        ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_notify_sei_immediately_before_first_frame_enabled", 0)).intValue();
        this.mEnableNotifySeiImmediatelyBeforeFirstFrame = 1;
        this.mEnableDroppingDTSRollFrame = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_dropping_dts_rollback_frame_enabled", 0)).intValue();
        String str = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_low_latency_flv_default_strategy_map", "");
        if (str.length() > 0) {
            try {
                this.mLowLatencyFLVStrategy = new JSONObject(str);
            } catch (JSONException e) {
                this.mLowLatencyFLVStrategy = null;
                mq.d(e);
                MyLog.e(TAG, "strategy settings invalid");
            }
        }
    }

    private void _configWithSDKParams() {
        ILiveSettingBundle iLiveSettingBundle;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String sDKParams = this.mURLSource.getSDKParams(this.mResolution, this.mLevel);
        if (sDKParams != null) {
            try {
                JSONObject jSONObject4 = new JSONObject(sDKParams);
                if (!this.mHasAbrInfo && jSONObject4.has("Auto") && (jSONObject2 = jSONObject4.getJSONObject("Auto")) != null) {
                    if (jSONObject2.has("Enable")) {
                        this.mEnableResolutionAutoDegrade = jSONObject2.optInt("Enable") == 1;
                    }
                    if (jSONObject2.has("Demotion") && (jSONObject3 = jSONObject2.getJSONObject("Demotion")) != null && jSONObject3.has("StallCount")) {
                        this.mStallCountThresOfResolutionDegrade = jSONObject3.getInt("StallCount");
                    }
                }
                if (jSONObject4.has("vbitrate")) {
                    this.mDefaultResBitrate = jSONObject4.optInt("vbitrate");
                }
                if (jSONObject4.has("FramesDrop")) {
                    this.mFramesDrop = jSONObject4.optInt("FramesDrop");
                }
                if (jSONObject4.has("AVPHDnsParseEnable")) {
                    this.mAVPHDnsParseEnable = jSONObject4.optInt("AVPHDnsParseEnable");
                }
                if (jSONObject4.has("AVPHDnsTimeout")) {
                    this.mAVPHDnsTimeout = jSONObject4.optInt("AVPHDnsTimeout");
                }
                if (jSONObject4.has("AVPHVideoProbesize")) {
                    this.mAVPHVideoProbesize = jSONObject4.optInt("AVPHVideoProbesize");
                }
                if (jSONObject4.has("AVPHVideoMaxDuration")) {
                    this.mAVPHVideoMaxDuration = jSONObject4.optInt("AVPHVideoMaxDuration");
                }
                if (jSONObject4.has("AVPHAudioProbesize")) {
                    this.mAVPHAudioProbesize = jSONObject4.optInt("AVPHAudioProbesize");
                }
                if (jSONObject4.has("AVPHAudioMaxDuration")) {
                    this.mAVPHAudioMaxDuration = jSONObject4.optInt("AVPHAudioMaxDuration");
                }
                if (jSONObject4.has("AVPHOpenVideoFirst")) {
                    this.mAVPHOpenVideoFirst = jSONObject4.optInt("AVPHOpenVideoFirst");
                }
                if (jSONObject4.has("AVPHMaxAVDiff")) {
                    this.mAVPHMaxAVDiff = jSONObject4.optInt("AVPHMaxAVDiff");
                }
                if (jSONObject4.has("AVPHAutoExit")) {
                    this.mAVPHAutoExit = jSONObject4.optInt("AVPHAutoExit");
                }
                if (jSONObject4.has("AVPHAutoReopen")) {
                    this.mAVPHEnableAutoReopen = jSONObject4.optInt("AVPHAutoReopen");
                }
                if (jSONObject4.has("AVPHVideoDiffThreshold")) {
                    this.mAVPHVideoDiffThreshold = jSONObject4.optInt("AVPHVideoDiffThreshold");
                }
                if (jSONObject4.has("AVPHReadRetryCount")) {
                    this.mAVPHReadRetryCount = jSONObject4.optInt("AVPHReadRetryCount");
                }
                if (jSONObject4.has("AVPHReadErrorExit")) {
                    this.mAVPHReadErrorExit = jSONObject4.optInt("AVPHReadErrorExit");
                }
                if (jSONObject4.has("EnableSkipFindUnnecessaryStream")) {
                    this.mEnableSkipFindUnnecessaryStream = jSONObject4.optInt("EnableSkipFindUnnecessaryStream");
                }
                if (jSONObject4.has("EnableRenderStall")) {
                    this.mEnableRenderStall = jSONObject4.optInt("EnableRenderStall");
                }
                if (jSONObject4.has("VideoRenderStallThreshold")) {
                    mVideoRenderStallThreshold = jSONObject4.optInt("VideoRenderStallThreshold");
                }
                if (jSONObject4.has("AudioRenderStallThreshold")) {
                    mAudioRenderStallThreshold = jSONObject4.optInt("AudioRenderStallThreshold");
                }
                if (jSONObject4.has("EnableDemuxerStall")) {
                    this.mEnableDemuxerStall = jSONObject4.optInt("EnableDemuxerStall");
                }
                if (jSONObject4.has("EnableDecoderStall")) {
                    this.mEnableDecoderStall = jSONObject4.optInt("EnableDecoderStall");
                }
                if (jSONObject4.has("DemuxerStallThreshold")) {
                    mDemuxerStallThreshold = jSONObject4.optInt("DemuxerStallThreshold");
                }
                if (jSONObject4.has("DecoderStallThreshold")) {
                    mDecoderStallThreshold = jSONObject4.optInt("DecoderStallThreshold");
                }
                if (jSONObject4.has("StallCounter") && (jSONObject = jSONObject4.getJSONObject("StallCounter")) != null) {
                    if (jSONObject.has("Enable")) {
                        this.mEnableStallCounter = jSONObject.optInt("Enable");
                    }
                    if (jSONObject.has("TimeInterval")) {
                        this.mStallCounterInterval = jSONObject.optInt("TimeInterval");
                    }
                }
                if (jSONObject4.has("DTSCheckEnabled")) {
                    this.mEnableDTSCheck = jSONObject4.optInt("DTSCheckEnabled");
                }
                if (jSONObject4.has("DroppingRepeatingDataEnabled")) {
                    this.mEnablePreventDTSBack = jSONObject4.optInt("DroppingRepeatingDataEnabled");
                }
                if (jSONObject4.has("DroppingRepeatingDataDTSMaxDiff")) {
                    this.mFrameDroppingDTSMaxDiff = jSONObject4.optLong("DroppingRepeatingDataDTSMaxDiff");
                }
                if (jSONObject4.has("EnableSaveSCFG")) {
                    this.mEnableSaveSCFG = jSONObject4.optInt("EnableSaveSCFG") == 1;
                }
                if (jSONObject4.has("EnableVideoMpdRefresh")) {
                    this.mEnableVideoMpdRefresh = jSONObject4.optInt("EnableVideoMpdRefresh");
                }
                if (jSONObject4.has("TransInfoCheck")) {
                    JSONObject jSONObjectOptJSONObject3 = jSONObject4.optJSONObject("TransInfoCheck");
                    if (jSONObjectOptJSONObject3.has("Enabled")) {
                        this.mEnableCheckFrame = jSONObjectOptJSONObject3.optInt("Enabled");
                    }
                }
                if (jSONObject4.has("SEICheck")) {
                    JSONObject jSONObjectOptJSONObject4 = jSONObject4.optJSONObject("SEICheck");
                    if (jSONObjectOptJSONObject4.has("Enabled")) {
                        this.mEnableCheckSEI = jSONObjectOptJSONObject4.optInt("Enabled");
                        if (jSONObjectOptJSONObject4.optInt("Enabled") == 1 || this.mLogService != null) {
                            this.mLogService.enableCheckSei();
                        }
                    }
                }
                if (jSONObject4.has("EnableCacheSei")) {
                    this.mEnableCacheSei = jSONObject4.optInt("EnableCacheSei");
                }
                if (jSONObject4.has("gop")) {
                    this.mGopDuration = jSONObject4.optInt("gop");
                }
                if (jSONObject4.has("EnableLLASHFastOpen")) {
                    this.mEnableLLASHFastOpen = jSONObject4.optInt("EnableLLASHFastOpen");
                }
                if (jSONObject4.has("EnableABRCheckEnhance")) {
                    this.mEnableLiveAbrCheckEnhance = jSONObject4.optInt("EnableABRCheckEnhance");
                }
                if (jSONObject4.has("ABRCheckInterval")) {
                    this.mLiveABRCheckInterval = jSONObject4.optInt("ABRCheckInterval");
                }
                if (jSONObject4.has("ABRMethod")) {
                    this.mABRMethod = jSONObject4.optInt("ABRMethod");
                }
                if (jSONObject4.has("ABRBufferThreshold")) {
                    this.mABRBufferThreshold = jSONObject4.optInt("ABRBufferThreshold");
                }
                if (jSONObject4.has("MaxCacheSeconds")) {
                    this.mMaxCacheSeconds = jSONObject4.optInt("MaxCacheSeconds");
                }
                if (jSONObject4.has("MainBackupSwitch")) {
                    JSONObject jSONObjectOptJSONObject5 = jSONObject4.optJSONObject("MainBackupSwitch");
                    if (jSONObjectOptJSONObject5.has("Enabled")) {
                        if (jSONObjectOptJSONObject5.optInt("Enabled") == 0) {
                            this.mEnableSwitchMainAndBackupUrl = false;
                        } else {
                            this.mEnableSwitchMainAndBackupUrl = true;
                        }
                    }
                }
                if (jSONObject4.has("MinTimeShift")) {
                    this.mTslMinTimeShit = jSONObject4.optInt("MinTimeShift");
                }
                if (jSONObject4.has("TargetOriginBitRate")) {
                    this.mTargetOriginBitRate = jSONObject4.optInt("TargetOriginBitRate");
                }
                if (jSONObject4.has("AbrStallDegradeImmediately")) {
                    this.mEnableAbrStallDegradeImmediately = jSONObject4.optInt("AbrStallDegradeImmediately");
                }
                if (jSONObject4.has("HASSessionPath")) {
                    this.mCdnSessionPath = jSONObject4.optString("HASSessionPath");
                }
                if (jSONObject4.has("DecodeSEIEnabled")) {
                    this.mEnableUploadSei = jSONObject4.optInt("DecodeSEIEnabled");
                }
                if (jSONObject4.has("NetworkAdapt")) {
                    JSONObject jSONObject5 = new JSONObject(jSONObject4.optString("NetworkAdapt"));
                    if (jSONObject5.has("Enabled")) {
                        int iOptInt = jSONObject5.optInt("Enabled");
                        this.mEnableHurryFlag = iOptInt;
                        if (iOptInt == 1) {
                            this.mHurryType = 0;
                        }
                        if (jSONObject5.has("HurryTime")) {
                            int iOptInt2 = jSONObject5.optInt("HurryTime");
                            this.mHurryTime = iOptInt2;
                            this.mPlayer.setIntOption(15, iOptInt2);
                        }
                        if (jSONObject5.has("HurryMillisecond")) {
                            int iOptInt3 = jSONObject5.optInt("HurryMillisecond");
                            this.mHurryTime = iOptInt3;
                            this.mPlayer.setIntOption(397, iOptInt3);
                        }
                        if (jSONObject5.has("HurrySpeed")) {
                            this.mCatchSpeed = Float.parseFloat(jSONObject5.optString("HurrySpeed"));
                        }
                        if (jSONObject5.has("SlowTime")) {
                            int iOptInt4 = jSONObject5.optInt("SlowTime");
                            this.mSlowPlayTime = iOptInt4;
                            this.mPlayer.setIntOption(190, iOptInt4);
                        }
                        if (jSONObject5.has("SlowMillisecond")) {
                            int iOptInt5 = jSONObject5.optInt("SlowMillisecond");
                            this.mSlowPlayTime = iOptInt5;
                            this.mPlayer.setIntOption(398, iOptInt5);
                        }
                        if (jSONObject5.has("SlowSpeed")) {
                            this.mSlowPlaySpeed = Float.parseFloat(jSONObject5.optString("SlowSpeed"));
                        }
                    }
                }
                if (jSONObject4.has("StartPlayAudioBufferThreshold")) {
                    this.mStartPlayBufferThres = jSONObject4.optInt("StartPlayAudioBufferThreshold");
                }
                if (jSONObject4.has("EnableCertVerify")) {
                    this.mEnableQuicCertVerify = jSONObject4.optInt("EnableCertVerify") == 1;
                }
                if (jSONObject4.has("EnableClosePlayRetry")) {
                    this.mEnableClosePlayRetry = jSONObject4.optInt("EnableClosePlayRetry");
                }
                if (jSONObject4.has("EnableDnsOptimizer")) {
                    boolean z = jSONObject4.optInt("EnableDnsOptimizer") == 1;
                    this.mEnableDnsOptimizer = z;
                    this.mLogService.openNodeOptimizer(z);
                }
                if (jSONObject4.has("EnableMTUDiscovery")) {
                    this.mEnableQuicMTUDiscovery = jSONObject4.optInt("EnableMTUDiscovery");
                }
                if (jSONObject4.has("InitMTU")) {
                    this.mQuicInitMTU = jSONObject4.optInt("InitMTU");
                }
                if (jSONObject4.has("InitRtt")) {
                    this.mQuicInitRtt = jSONObject4.optInt("InitRtt");
                }
                if (jSONObject4.has("MaxCryptoRetransmissions")) {
                    this.mQuicMaxCryptoRetransmissions = jSONObject4.optInt("MaxCryptoRetransmissions");
                }
                if (jSONObject4.has("MaxCryptoRetransmissionTimeMs")) {
                    this.mQuicMaxCryptoRetransmissionTimeMs = jSONObject4.optInt("MaxCryptoRetransmissionTimeMs");
                }
                if (jSONObject4.has("MaxRetransmissions")) {
                    this.mQuicMaxRetransmissions = jSONObject4.optInt("MaxRetransmissions");
                }
                if (jSONObject4.has("MaxRetransmissionTimeMs")) {
                    this.mQuicMaxRetransmissionTimeMs = jSONObject4.optInt("MaxRetransmissionTimeMs");
                }
                if (jSONObject4.has("MaxAckDelay")) {
                    this.mQuicMaxAckDelay = jSONObject4.optInt("MaxAckDelay");
                }
                if (jSONObject4.has("MinReceivedBeforeAckDecimation")) {
                    this.mQuicMinReceivedBeforeAckDecimation = jSONObject4.optInt("MinReceivedBeforeAckDecimation");
                }
                if (jSONObject4.has("QuicVersion")) {
                    this.mQuicVersion = jSONObject4.optInt("QuicVersion", 39);
                }
                if (jSONObject4.has("PadHello")) {
                    this.mQuicPadHello = jSONObject4.optInt("PadHello", 1);
                }
                if (jSONObject4.has("FixWillingAndAbleToWrite")) {
                    this.mQuicFixWillingAndAbleToWrite = jSONObject4.optInt("FixWillingAndAbleToWrite", 1);
                }
                if (jSONObject4.has("FixProcessTimer")) {
                    this.mQuicFixProcessTimer = jSONObject4.optInt("FixProcessTimer", 1);
                }
                if (jSONObject4.has("QuicReadBlockTimeout")) {
                    this.mQuicReadBlockTimeout = jSONObject4.optInt("QuicReadBlockTimeout", 100);
                }
                if (jSONObject4.has("QuicReadBlockMode")) {
                    this.mQuicReadBlockMode = jSONObject4.optInt("QuicReadBlockMode", 0);
                }
                if (jSONObject4.has("FixStreamFinAndRst")) {
                    this.mQuicFixStreamFinAndRst = jSONObject4.optInt("FixStreamFinAndRst", 0);
                }
                if (jSONObject4.has("QuicTimerVersion")) {
                    this.mQuicTimerVersion = jSONObject4.optInt("QuicTimerVersion", 1);
                }
                if (jSONObject4.has("QuicConfigOptimize")) {
                    this.mQuicConfigOptimize = jSONObject4.optInt("QuicConfigOptimize", 0);
                }
                if (jSONObject4.has("QuicSessionReceiveWindow")) {
                    this.mSessionReceiveWindow = jSONObject4.optInt("QuicSessionReceiveWindow", 1);
                }
                if (jSONObject4.has("QuicStreamReceiveWindow")) {
                    this.mStreamReceiveWindow = jSONObject4.optInt("QuicStreamReceiveWindow", 1);
                }
                if (jSONObject4.has("EnableCheckDropAudio")) {
                    this.mEnableCheckDropAudio = jSONObject4.optInt("EnableCheckDropAudio");
                }
                if (jSONObject4.has("AVNoSyncThreshold")) {
                    this.mAVNoSyncThreshold = jSONObject4.optInt("AVNoSyncThreshold");
                }
                if (jSONObject4.has("AlwaysDoAVSync")) {
                    this.mIsAlwaysDoAVSync = jSONObject4.optInt("AlwaysDoAVSync");
                }
                if (jSONObject4.has("StallRetryTimeIntervalManager")) {
                    this.mStallRetryTimeIntervalManager = jSONObject4.optLong("StallRetryTimeIntervalManager");
                }
                if (jSONObject4.has("FastOpenDuration")) {
                    mFastOpenDuration = jSONObject4.optInt("FastOpenDuration");
                }
                if (jSONObject4.has("LLSConfig") && (jSONObjectOptJSONObject2 = jSONObject4.optJSONObject("LLSConfig")) != null) {
                    if (jSONObjectOptJSONObject2.has("FallbackThreshold")) {
                        this.mRtcFallbackThreshold = jSONObjectOptJSONObject2.optInt("FallbackThreshold");
                    }
                    if (jSONObjectOptJSONObject2.has("EnableDtls")) {
                        this.mRtcEnableDtls = jSONObjectOptJSONObject2.optInt("EnableDtls");
                    }
                    if (jSONObjectOptJSONObject2.has("MinJitterBuffer")) {
                        this.mRtcMinJitterBuffer = jSONObjectOptJSONObject2.optInt("MinJitterBuffer");
                    }
                    if (jSONObjectOptJSONObject2.has("MaxJitterBuffer")) {
                        this.mRtcMaxJitterBuffer = jSONObjectOptJSONObject2.optInt("MaxJitterBuffer");
                    }
                    if (jSONObjectOptJSONObject2.has("EnableSDKDns")) {
                        this.mRtcEnableSDKDns = jSONObjectOptJSONObject2.optInt("EnableSDKDns");
                    }
                    if (jSONObjectOptJSONObject2.has("EnableEarlyInitRender")) {
                        this.mRtcEarlyInitRender = jSONObjectOptJSONObject2.optInt("EnableEarlyInitRender");
                    }
                    if (jSONObjectOptJSONObject2.has("MaxRetryCount")) {
                        this.mRtcMaxRetryCount = jSONObjectOptJSONObject2.optInt("MaxRetryCount");
                    }
                    if (jSONObjectOptJSONObject2.has("EnableRTCHWDecode")) {
                        this.mHardwareRTCDecodeEnable = jSONObjectOptJSONObject2.optInt("EnableRTCHWDecode");
                    }
                    if (jSONObjectOptJSONObject2.has("EnableMiniSdp")) {
                        this.mRtcSupportMiniSdp = jSONObjectOptJSONObject2.optInt("EnableMiniSdp");
                    }
                    if (jSONObjectOptJSONObject2.has("PlayingLogInterval")) {
                        int iOptInt6 = jSONObjectOptJSONObject2.optInt("PlayingLogInterval");
                        this.mRtcPlayLogInterval = iOptInt6;
                        LiveLoggerService liveLoggerService = this.mLogService;
                        if (liveLoggerService != null) {
                            liveLoggerService.setRtcPlayLogInterval(iOptInt6);
                        }
                    }
                    if (jSONObjectOptJSONObject2.has("EnableRTSFixDeadlock")) {
                        this.mRtcEnableRtcUninitLockFree = jSONObjectOptJSONObject2.optInt("EnableRTSFixDeadlock");
                    }
                }
                if (jSONObject4.has("NetWorkTimeoutMs")) {
                    this.mNetworkTimeout = jSONObject4.optInt("NetWorkTimeoutMs");
                }
                if (jSONObject4.has("EnableCheckPacketCorrupt")) {
                    this.mEnableCheckPacketCorrupt = jSONObject4.optInt("EnableCheckPacketCorrupt");
                }
                if (jSONObject4.has("AudioTimescaleEnable")) {
                    this.mAudioTimescaleEnable = jSONObject4.optInt("AudioTimescaleEnable");
                }
                if (jSONObject4.has("EnableTcpFastOpen")) {
                    this.mEnableTcpFastOpen = jSONObject4.optInt("EnableTcpFastOpen");
                }
                if (jSONObject4.has("HlsLiveStartIndex")) {
                    this.mHlsLiveStartIndex = jSONObject4.optInt("HlsLiveStartIndex");
                }
                if (jSONObject4.has("CmafOptimizeRetry")) {
                    this.mEnableCmafOptimizeRetry = jSONObject4.optInt("CmafOptimizeRetry");
                }
                if (jSONObject4.has("EnableFastOpen")) {
                    this.mEnableFastOpenStream = jSONObject4.optInt("EnableFastOpen");
                }
                if (jSONObject4.has("EnableLowLatencyFLV")) {
                    this.mEnableLowLatencyFLV = jSONObject4.optInt("EnableLowLatencyFLV");
                }
                if (jSONObject4.has("EnableSkipFlvNullTag")) {
                    this.mEnableSkipFlvNullTag = jSONObject4.optInt("EnableSkipFlvNullTag");
                }
                if (jSONObject4.has("LiveIOConfig") && (jSONObjectOptJSONObject = jSONObject4.optJSONObject("LiveIOConfig")) != null) {
                    if (jSONObjectOptJSONObject.has("EnableLiveIO")) {
                        this.mEnableLiveIOPlay = jSONObjectOptJSONObject.optInt("EnableLiveIO");
                    }
                    if (jSONObjectOptJSONObject.has("EnableP2P")) {
                        this.mEnableLiveIOP2P = jSONObjectOptJSONObject.optInt("EnableP2P");
                    }
                    if (jSONObjectOptJSONObject.has("EnableHttpPrepare")) {
                        this.mEnableHttpPrepare = jSONObjectOptJSONObject.optInt("EnableHttpPrepare");
                    }
                    if (jSONObjectOptJSONObject.has("EnableP2pUp")) {
                        this.mEnableP2pUp = jSONObjectOptJSONObject.optInt("EnableP2pUp");
                    }
                    if (jSONObjectOptJSONObject.has("LiveIOABGroupID")) {
                        this.mLiveIOABGroupID = jSONObjectOptJSONObject.optInt("LiveIOABGroupID");
                    }
                }
                if (jSONObject4.has("EnableNTPByApp")) {
                    int iOptInt7 = jSONObject4.optInt("EnableNTPByApp");
                    this.mEnableNTP = iOptInt7;
                    this.mLogService.mEnableNTP = iOptInt7;
                    if (this.mEnableNTP == 1 && (iLiveSettingBundle = this.mSettingsBundle) != null) {
                        this.mLogService.mTimeDiff = ((Long) iLiveSettingBundle.getSettingsValueForKey("time_diff_server_and_client", 0L)).longValue();
                    }
                }
                if (jSONObject4.has("NoSyncReportMinDuration")) {
                    this.mNoSyncReportMinDuration = jSONObject4.optInt("NoSyncReportMinDuration");
                }
                if (jSONObject4.has("NoSyncReportReportThres")) {
                    this.mNoSyncReportReportThres = jSONObject4.optInt("NoSyncReportReportThres");
                }
            } catch (JSONException e) {
                mq.d(e);
            }
        }
        this.mLogService.mDefaultResBitrate = this.mDefaultResBitrate;
    }

    private void _configWithLowLatencyFLVStrategy(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("net_effective_connection_type_strategy")) {
            try {
                jSONObject.getJSONObject("net_effective_connection_type_strategy");
            } catch (JSONException e) {
                mq.d(e);
            }
        }
    }

    private void _configFlvLowLatencyWithSDKParam() throws NumberFormatException {
        String sDKParams = this.mURLSource.getSDKParams(this.mResolution, this.mLevel);
        if (sDKParams != null) {
            try {
                JSONObject jSONObject = new JSONObject(sDKParams);
                if (jSONObject.has("NetworkAdapt")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("NetworkAdapt"));
                    if (jSONObject2.has("Enabled")) {
                        int iOptInt = jSONObject2.optInt("Enabled");
                        this.mEnableHurryFlag = iOptInt;
                        if (iOptInt == 1) {
                            this.mHurryType = 0;
                        }
                        if (jSONObject2.has("HurryTime")) {
                            int iOptInt2 = jSONObject2.optInt("HurryTime");
                            this.mHurryTime = iOptInt2;
                            this.mPlayer.setIntOption(15, iOptInt2);
                            this.mLogService.mHurryTime = this.mHurryTime;
                        }
                        if (jSONObject2.has("HurryMillisecond")) {
                            int iOptInt3 = jSONObject2.optInt("HurryMillisecond");
                            this.mHurryTime = iOptInt3;
                            this.mPlayer.setIntOption(397, iOptInt3);
                            this.mLogService.mHurryTime = this.mHurryTime;
                        }
                        if (jSONObject2.has("HurrySpeed")) {
                            float f = Float.parseFloat(jSONObject2.optString("HurrySpeed"));
                            this.mCatchSpeed = f;
                            this.mPlayer.setFloatOption(80, f);
                            this.mLogService.mCatchSpeed = this.mCatchSpeed;
                        }
                        if (jSONObject2.has("SlowTime")) {
                            int iOptInt4 = jSONObject2.optInt("SlowTime");
                            this.mSlowPlayTime = iOptInt4;
                            this.mPlayer.setIntOption(190, iOptInt4);
                            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
                        }
                        if (jSONObject2.has("SlowMillisecond")) {
                            int iOptInt5 = jSONObject2.optInt("SlowMillisecond");
                            this.mSlowPlayTime = iOptInt5;
                            this.mPlayer.setIntOption(398, iOptInt5);
                            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
                        }
                        if (jSONObject2.has("SlowSpeed")) {
                            float f2 = Float.parseFloat(jSONObject2.optString("SlowSpeed"));
                            this.mSlowPlaySpeed = f2;
                            this.mPlayer.setFloatOption(191, f2);
                            this.mLogService.mSlowSpeed = this.mSlowPlaySpeed;
                        }
                    }
                }
                if (jSONObject.has("FastOpenDuration")) {
                    mFastOpenDuration = jSONObject.optInt("FastOpenDuration");
                }
                if (jSONObject.has("EnableLowLatencyFLV")) {
                    this.mEnableLowLatencyFLV = jSONObject.optInt("EnableLowLatencyFLV");
                    this.mLogService.getStallTotalCount();
                    this.mLogService.getRetryTotalCount();
                }
            } catch (JSONException e) {
                mq.d(e);
            }
        }
    }

    private void _checkValidAbrResolution() {
        if (this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && this.mEnableResolutionAutoDegrade && !this.mURLSource.isEnableAdaptive(this.mResolution)) {
            for (int i = 0; i < LiveConfigKey.resolution.length; i++) {
                if (this.mURLSource.isEnableAdaptive(LiveConfigKey.resolution[i])) {
                    MyLog.i(TAG, "Abr res check.modify from " + this.mResolution + " to " + LiveConfigKey.resolution[i]);
                    this.mResolution = LiveConfigKey.resolution[i];
                    return;
                }
            }
        }
    }

    private void _requestSwitchUrlFromServer() {
        this.mLogService.mIsCdnAbrSwitch = true;
        if ((this.mURLSource.getSourceType() != 2 || this.mURLSource.isCodecSame(this.mLevel)) && !this.mExecutor.isShutdown()) {
            this.mExecutor.submit(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.2
                @Override // java.lang.Runnable
                public void run() throws JSONException {
                    VideoLiveManager.this._doRequestSwitchUrlFromServer();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _doRequestSwitchUrlFromServer() throws JSONException {
        MediaPlayer mediaPlayer;
        String stringOption;
        if (TextUtils.isEmpty(this.mCdnSessionPath) || TextUtils.isEmpty(this.mCdnAbrResolution) || this.mCdnAbrResolution.equals(this.mResolution) || (mediaPlayer = this.mPlayer) == null || (stringOption = mediaPlayer.getStringOption(335)) == null) {
            return;
        }
        MyLog.i(TAG, "responseHeaders: " + stringOption);
        String str = null;
        for (String str2 : stringOption.split("\r\n")) {
            if (str2.startsWith("X-Has-Token: ")) {
                str = str2.split(": ", 2)[1];
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.mLogService.mSessionId)) {
                jSONObject.put("live_stream_session_id", this.mLogService.mSessionId);
            }
            String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mCdnAbrResolution, LiveConfigKey.FLV, this.mLevel);
            if (TextUtils.isEmpty(playURLForResolution)) {
                return;
            }
            jSONObject.put("play_url", playURLForResolution);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(NetworkDefine.PARAM_TOKEN, str);
            }
            String strSubstring = playURLForResolution.substring(playURLForResolution.indexOf("//") + 2);
            String strSubstring2 = strSubstring.substring(strSubstring.indexOf("/"));
            if (!this.mCdnSessionPath.startsWith("/")) {
                this.mCdnSessionPath = "/" + this.mCdnSessionPath;
            }
            String str3 = playURLForResolution.substring(0, playURLForResolution.indexOf(strSubstring2)) + this.mCdnSessionPath;
            MyLog.i(TAG, "sending 'POST' request to URL : " + str3);
            MyLog.i(TAG, "httpBody: " + jSONObject);
            INetworkClient.Result resultDoPost = this.mNetworkClient.doPost(str3, jSONObject.toString());
            if (resultDoPost != null) {
                MyLog.i(TAG, "response: " + resultDoPost.response);
                MyLog.i(TAG, "code: " + resultDoPost.code);
                this.mLogService.mCdnAbrSwitchCode = resultDoPost.code;
                if (resultDoPost.code == 200 && resultDoPost.response.has("code")) {
                    this.mLogService.mCdnAbrSwitchCode = resultDoPost.response.optInt("code");
                    if (this.mLogService.mCdnAbrSwitchCode == 0) {
                        this.mResolution = this.mCdnAbrResolution;
                    }
                }
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }

    private void _checkStreamData() {
        LiveInfoSource liveInfoSource = this.mURLSource;
        if (liveInfoSource == null) {
            return;
        }
        liveInfoSource.setEnableOriginResolution(this.mEnableOriginResolution);
        if (this.mEnableResolutionAutoDegrade && this.mURLSource.getSourceType() == 2 && this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE)) {
            String defaultResolution = this.mURLSource.getDefaultResolution();
            if (!TextUtils.isEmpty(defaultResolution)) {
                if (!this.mEnableOriginResolution && defaultResolution.equals(LiveConfigKey.ORIGIN)) {
                    _smartResolveDefaultResolution(LiveConfigKey.UHD);
                } else {
                    _smartResolveDefaultResolution(defaultResolution);
                }
            }
            if (this.mURLSource.isABRListMatch() && this.mURLSource.isCodecSame(this.mLevel)) {
                return;
            }
            this.mResolution = this.mURLSource.getDefaultResolution();
            this.mAbrStrategy = LiveConfigKey.RAD;
            this.mEnableResolutionAutoDegrade = false;
            if (!this.mURLSource.isABRListMatch()) {
                this.mLogService.mABRListMatch = 0;
            }
            if (this.mURLSource.isCodecSame(this.mLevel)) {
                return;
            }
            this.mLogService.mCodecNotSame = 1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void _smartResolveDefaultResolution(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager._smartResolveDefaultResolution(java.lang.String):void");
    }

    private void _configAbrInfo() {
        JSONObject abrInfo = this.mURLSource.getAbrInfo();
        if (abrInfo != null) {
            boolean z = true;
            this.mHasAbrInfo = true;
            try {
                if (abrInfo.has("enable")) {
                    this.mEnableResolutionAutoDegrade = abrInfo.optInt("enable") == 1;
                }
                if (abrInfo.has("strategy")) {
                    this.mAbrStrategy = abrInfo.getString("strategy");
                }
                if (abrInfo.has("enable_origin_resolution")) {
                    if (abrInfo.optInt("enable_origin_resolution") != 1) {
                        z = false;
                    }
                    this.mEnableOriginResolution = z;
                }
                if (abrInfo.has("disable_algorithm")) {
                    this.mABRDisableAlgorithm = abrInfo.optInt("disable_algorithm");
                    return;
                }
                return;
            } catch (JSONException e) {
                mq.d(e);
                this.mHasAbrInfo = false;
                this.mEnableResolutionAutoDegrade = false;
                this.mAbrStrategy = LiveConfigKey.RAD;
                this.mEnableOriginResolution = false;
                this.mStallCountThresOfResolutionDegrade = 4;
                return;
            }
        }
        this.mHasAbrInfo = false;
        this.mEnableResolutionAutoDegrade = false;
        this.mEnableOriginResolution = false;
        this.mAbrStrategy = LiveConfigKey.RAD;
        this.mStallCountThresOfResolutionDegrade = 4;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setStringOption(int i, String str) {
        LiveInfoSource liveInfoSource;
        String str2 = "";
        if (i == 26) {
            str2 = "cacheFilePath:" + str;
            this.mCacheFilePath = str;
            if (this.mPlayer != null) {
                String string = new StringBuilder().append(System.currentTimeMillis()).toString();
                this.mCacheFileKey = string;
                this.mPlayer.setStringOption(17, string);
                this.mPlayer.setIntOption(14, 1);
                this.mPlayer.setCacheFile(str, 1);
            }
        } else if (i == 43) {
            str2 = "set resolution:" + str;
            saveCurrentResolution();
            this.mResolution = str;
            if (this.mPlayer != null && (liveInfoSource = this.mURLSource) != null && liveInfoSource.getSourceType() == 2) {
                long bitrate = this.mURLSource.getBitrate(this.mResolution, this.mLevel);
                if (bitrate > 0) {
                    this.mPlayer.setIntOption(650, (int) bitrate);
                    this.mLogService.mUseExpectBitrate = 1;
                }
            }
        } else if (i == 60) {
            str2 = "set stream format:" + str;
            this.mStreamFormat = str;
            this.mLogService.setFormatInfo(str, str);
            if (this.mPlayer != null && (this.mStreamFormat.equals(LiveConfigKey.AVPH) || this.mStreamFormat.equals(LiveConfigKey.CMAF))) {
                this.mPlayer.setStringOption(315, str);
            }
        } else if (i == 81) {
            str2 = "toB module id:" + str;
            this.mMoudleIDToB = str;
        } else if (i == 86) {
            str2 = "switch resolution of cdn abr:" + str;
            this.mCdnAbrResolution = str;
            _requestSwitchUrlFromServer();
        } else if (i != 89) {
            switch (i) {
                case 63:
                    this.mLogService.mEnterMethod = str;
                    break;
                case 64:
                    this.mLogService.mEnterAction = str;
                    break;
                case 65:
                    str2 = " abr strategy:" + str;
                    this.mAbrStrategy = str;
                    break;
                case 66:
                    str2 = "set transport protocol:" + str;
                    if (str.equals(LiveConfigKey.TCP) || str.equals(LiveConfigKey.QUIC)) {
                        this.mTransportProtocol = str;
                    }
                    this.mQuicPull = true;
                    break;
                default:
                    switch (i) {
                        case 72:
                            str2 = "set sr kernal bin path:" + str;
                            this.mTextureSRBinPath = str;
                            break;
                        case 73:
                            str2 = "set sr ocl module path:" + str;
                            this.mTextureSROclModuleName = str;
                            break;
                        case 74:
                            str2 = "set sr dsp module path:" + str;
                            this.mTextureSRDspModuleName = str;
                            break;
                    }
            }
        } else {
            str2 = "set_url_host:" + str;
            this.mURLHost = str;
        }
        MyLog.i(TAG, "setStringOption " + str2);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getStringOption(int i, String str) {
        if (i == 57) {
            str = this.mCurrentPlayURL;
        } else if (i == 58) {
            str = this.mResolution;
        } else if (i == 60) {
            str = this.mStreamFormat;
        } else if (i == 65) {
            str = this.mAbrStrategy;
        }
        MyLog.i(TAG, "getStringOption: " + str);
        return str;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setIntOption(int i, int i2) {
        String str = "";
        switch (i) {
            case 1:
                str = "image_enhancement:" + i2;
                this.mEnhancementType = i2;
                MediaPlayer mediaPlayer = this.mPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.setIntOption(37, i2);
                    break;
                }
                break;
            case 2:
                str = "image_scale:" + i2;
                this.mScaleType = i2;
                MediaPlayer mediaPlayer2 = this.mPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.setIntOption(38, i2);
                    break;
                }
                break;
            case 3:
                str = "forbid_os_player:" + i2;
                TTPlayerConfiger.setValue(11, i2);
                break;
            case 4:
                str = "image_layout:" + i2;
                this.mLayoutType = i2;
                MediaPlayer mediaPlayer3 = this.mPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer3.setIntOption(36, i2);
                    break;
                }
                break;
            case 5:
                str = "render_type:" + i2;
                this.mRenderType = i2;
                MediaPlayer mediaPlayer4 = this.mPlayer;
                if (mediaPlayer4 != null) {
                    mediaPlayer4.setIntOption(56, i2);
                    break;
                }
                break;
            case 7:
                str = "hard_decode:" + i2;
                this.mHardwareDecodeEnable = i2;
                MediaPlayer mediaPlayer5 = this.mPlayer;
                if (mediaPlayer5 != null) {
                    mediaPlayer5.setIntOption(59, i2);
                    break;
                }
                break;
            case 8:
                str = "enable_cache_file:" + i2;
                this.mCacheFileEnable = i2;
                MediaPlayer mediaPlayer6 = this.mPlayer;
                if (mediaPlayer6 != null) {
                    mediaPlayer6.setIntOption(14, 1);
                    break;
                }
                break;
            case 9:
                str = "bytevc1_decoder_type:" + i2;
                this.mByteVC1DecoderType = i2;
                MediaPlayer mediaPlayer7 = this.mPlayer;
                if (mediaPlayer7 != null) {
                    mediaPlayer7.setIntOption(67, i2);
                    break;
                }
                break;
            case 10:
                str = "buffering_millSeconds:" + i2;
                this.mBufferDataSeconds = i2;
                MediaPlayer mediaPlayer8 = this.mPlayer;
                if (mediaPlayer8 != null) {
                    mediaPlayer8.setIntOption(86, i2);
                    break;
                }
                break;
            case 11:
                str = "buffering_timeout:" + i2;
                this.mBufferTimeout = i2;
                MediaPlayer mediaPlayer9 = this.mPlayer;
                if (mediaPlayer9 != null) {
                    mediaPlayer9.setIntOption(81, i2);
                    break;
                }
                break;
            case 12:
                str = "network_timeout:" + i2;
                this.mNetworkTimeout = i2;
                MediaPlayer mediaPlayer10 = this.mPlayer;
                if (mediaPlayer10 != null) {
                    mediaPlayer10.setIntOption(9, i2 * 1000000);
                    break;
                }
                break;
            case 15:
                str = "use_external_dir:" + i2;
                this.mUseExternalDir = i2;
                break;
            case 16:
                str = "use_test_action:" + i2;
                this.mTestAction = i2;
                MediaPlayer mediaPlayer11 = this.mPlayer;
                if (mediaPlayer11 != null) {
                    mediaPlayer11.setIntOption(83, i2);
                    break;
                }
                break;
            case 17:
                if (this.mEnableLowLatencyFLV == 1) {
                    str = "invalid settings on low latency flv, hurry_time:" + i2;
                    break;
                } else {
                    str = "hurry_time:" + i2;
                    this.mHurryTime = i2;
                    MediaPlayer mediaPlayer12 = this.mPlayer;
                    if (mediaPlayer12 != null) {
                        mediaPlayer12.setIntOption(15, i2);
                        this.mLogService.mHurryTime = i2;
                        break;
                    }
                }
                break;
            case 18:
                str = "hurry_type:" + i2;
                this.mHurryType = i2;
                MediaPlayer mediaPlayer13 = this.mPlayer;
                if (mediaPlayer13 != null) {
                    mediaPlayer13.setIntOption(84, i2);
                    break;
                }
                break;
            case 21:
                if (this.mEnableLowLatencyFLV == 1) {
                    str = "invalid settings on low latency flv, slow_play_time:" + i2;
                    break;
                } else {
                    str = "slow_play_time:" + i2;
                    this.mSlowPlayTime = i2;
                    MediaPlayer mediaPlayer14 = this.mPlayer;
                    if (mediaPlayer14 != null) {
                        mediaPlayer14.setIntOption(190, i2);
                        this.mLogService.mSlowPlayTime = i2;
                        break;
                    }
                }
                break;
            case 22:
                str = "check side data" + i2;
                this.mOpenCheckSideData = i2;
                MediaPlayer mediaPlayer15 = this.mPlayer;
                if (mediaPlayer15 != null) {
                    mediaPlayer15.setIntOption(132, i2);
                    break;
                }
                break;
            case 25:
                str = "player_degrade_mode:" + i2;
                this.mPlayerDegradeMode = i2;
                break;
            case 31:
                str = "url_ability:" + i2;
                this.mURLAbility = i2;
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.mLogService.mUrlAbility = "bytevc1";
                        break;
                    }
                } else {
                    this.mLogService.mUrlAbility = KsMediaFormat.CODEC_NAME_H264;
                    break;
                }
                break;
            case 32:
                str = "enable_sharp:" + i2;
                this.mEnableSharp = i2;
                break;
            case 33:
                str = "asyncInit:" + i2;
                this.mEnableMediaCodecASYNCInit = i2;
                MediaPlayer mediaPlayer16 = this.mPlayer;
                if (mediaPlayer16 != null && this.mHardwareDecodeEnable == 1) {
                    mediaPlayer16.setIntOption(181, i2);
                    this.mLogService.mMediaCodecAsyncInit = i2;
                    break;
                }
                break;
            case 34:
                str = "defaultCodecID:" + i2;
                this.mDefaultCodecId = i2;
                MediaPlayer mediaPlayer17 = this.mPlayer;
                if (mediaPlayer17 != null) {
                    mediaPlayer17.setIntOption(182, i2);
                    this.mLogService.mDefaultCodecID = i2;
                    break;
                }
                break;
            case 35:
                str = "enable 264 hardware decode " + i2;
                this.mEnableH264HardwareDecode = i2;
                break;
            case 36:
                str = "enable bytevc1 hardware decode " + i2;
                this.mEnableByteVC1HardwareDecode = i2;
                break;
            case 37:
                str = "set max cache" + i2;
                this.mMaxCacheSeconds = i2;
                MediaPlayer mediaPlayer18 = this.mPlayer;
                if (mediaPlayer18 != null) {
                    mediaPlayer18.setIntOption(198, i2);
                    this.mLogService.mMaxCacheSeconds = i2;
                    break;
                }
                break;
            case 38:
                str = "enable test split " + i2;
                this.mEnableSplitStream = i2;
                MediaPlayer mediaPlayer19 = this.mPlayer;
                if (mediaPlayer19 != null) {
                    mediaPlayer19.setIntOption(87, i2);
                    this.mLogService.mEnableSplitStream = i2;
                    break;
                }
                break;
            case 39:
                str = "enable httpk degrade:" + i2;
                this.mEnableHttpkDegrade = i2;
                break;
            case 40:
                str = "enable fast open:" + i2;
                this.mEnableFastOpenStream = i2;
                break;
            case 41:
                str = "enable upload sei:" + i2;
                this.mEnableUploadSei = i2;
                break;
            case 42:
                str = "enable NTP:" + i2;
                this.mEnableNTPTask = i2;
                break;
            case 44:
                str = "set in main looper:" + i2;
                this.mIsInMainLooper = i2;
                break;
            case 46:
                str = "buffering end ignore video:" + i2;
                this.mCheckBufferingEndIgnoreVideo = i2;
                MediaPlayer mediaPlayer20 = this.mPlayer;
                if (mediaPlayer20 != null) {
                    mediaPlayer20.setIntOption(310, i2);
                    this.mLogService.mCheckBufferingEndIgnoreVideo = i2;
                    break;
                }
                break;
            case 47:
                str = "start direct:" + i2;
                this.mStartDirectAfterPrepared = i2;
                MediaPlayer mediaPlayer21 = this.mPlayer;
                if (mediaPlayer21 != null) {
                    mediaPlayer21.setIntOption(311, i2);
                    this.mLogService.mStartDirectAfterPrepared = i2;
                    break;
                }
                break;
            case 48:
                str = "enable mediaLoader:" + i2;
                this.mEnableOpenMDL = i2;
                break;
            case 54:
                str = "check buffering end advance:" + i2;
                this.mCheckBufferingEndAdvanceEnable = i2;
                MediaPlayer mediaPlayer22 = this.mPlayer;
                if (mediaPlayer22 != null) {
                    mediaPlayer22.setIntOption(313, i2);
                    this.mLogService.mCheckBufferingEndAdvanceEnable = i2;
                    break;
                }
                break;
            case 55:
                str = "set stall count thre:" + i2;
                this.mStallCountThresOfResolutionDegrade = i2;
                break;
            case 56:
                str = "enable resolution degrade:" + i2;
                this.mEnableResolutionAutoDegrade = i2 == 1;
                break;
            case 61:
                str = "enable tcp fast open:" + i2;
                this.mEnableTcpFastOpen = i2;
                MediaPlayer mediaPlayer23 = this.mPlayer;
                if (mediaPlayer23 != null) {
                    mediaPlayer23.setIntOption(316, i2);
                    break;
                }
                break;
            case 62:
                str = "enable check packet corrupt:" + i2;
                this.mEnableCheckPacketCorrupt = i2;
                MediaPlayer mediaPlayer24 = this.mPlayer;
                if (mediaPlayer24 != null) {
                    mediaPlayer24.setIntOption(317, i2);
                    break;
                }
                break;
            case 67:
                str = "enable flv abr:" + i2;
                this.mEnableFlvABR = i2;
                break;
            case 69:
                str = "enable texture render:" + i2;
                this.mEnableTextureRender = i2;
                break;
            case 70:
                str = "enable texture sr:" + i2;
                this.mEnableTextureSR = i2;
                break;
            case 77:
                str = "tsl time shift:" + i2;
                this.mTslTimeShift = i2;
                this.mLogService.mTslTimeShift = i2;
                break;
            case 80:
                str = "toB switch :" + i2;
                this.mSwitchToB = i2;
                break;
            case 82:
                str = "enable mult_sei:" + i2;
                this.mEnableDecodeMultiSei = i2;
                break;
            case 83:
                this.mHurryTime = i2;
                str = "hurry_time:" + i2;
                MediaPlayer mediaPlayer25 = this.mPlayer;
                if (mediaPlayer25 != null) {
                    mediaPlayer25.setIntOption(397, i2);
                    this.mLogService.mHurryTime = i2;
                    break;
                }
                break;
            case 84:
                str = "slow_play_time:" + i2;
                this.mSlowPlayTime = i2;
                MediaPlayer mediaPlayer26 = this.mPlayer;
                if (mediaPlayer26 != null) {
                    mediaPlayer26.setIntOption(398, i2);
                    this.mLogService.mSlowPlayTime = i2;
                    break;
                }
                break;
            case 85:
                str = "enable free flow:" + i2;
                this.mEnableFreeFlow = i2;
                break;
        }
        MyLog.i(TAG, "setIntOption " + str);
    }

    public long getIntOption(int i, long j) {
        if (i == 0) {
            MediaPlayer mediaPlayer = this.mPlayer;
            return mediaPlayer != null ? (mediaPlayer.getLongOption(63, 0L) * 8) / 1000 : j;
        }
        if (i == 68) {
            MediaPlayer mediaPlayer2 = this.mPlayer;
            return mediaPlayer2 != null ? (mediaPlayer2.getLongOption(63, 0L) * 8) / 1000 : j;
        }
        if (i != 78) {
            return i != 79 ? j : this.mTslMinTimeShit;
        }
        return this.mPlayer != null ? r9.getIntOption(379, 0) : j;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLongOption(int i, long j) {
        String str = "";
        if (i == 45) {
            str = "startPlayBufferThreshold:" + j;
            this.mStartPlayBufferThres = j;
            MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer != null && j > 0) {
                mediaPlayer.setLongOption(309, j);
                this.mLogService.mStartPlayBufferThres = j;
            }
        } else if (i == 59) {
            str = "set alog func:" + j;
            this.mALogWriteAddr = j;
        }
        MyLog.i(TAG, "setLongOptin " + str);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setFloatOption(int i, float f) {
        String str = "";
        if (i != 19) {
            if (i == 20) {
                if (this.mEnableLowLatencyFLV == 1) {
                    str = "invalid settings on low latency flv, slow_speed:" + f;
                } else {
                    str = "slow_speed:" + f;
                    this.mSlowPlaySpeed = f;
                    MediaPlayer mediaPlayer = this.mPlayer;
                    if (mediaPlayer != null) {
                        mediaPlayer.setFloatOption(191, f);
                        this.mLogService.mSlowSpeed = f;
                    }
                }
            }
        } else if (this.mEnableLowLatencyFLV == 1) {
            str = "invalid settings on low latency flv, catch_speed:" + f;
        } else {
            str = "catch_speed:" + f;
            this.mCatchSpeed = f;
            MediaPlayer mediaPlayer2 = this.mPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setFloatOption(80, f);
                this.mLogService.mCatchSpeed = f;
            }
        }
        MyLog.i(TAG, "setFloatOption " + str);
    }

    private void open() {
        TTPlayerConfiger.setValue(1, this.mPlayerType != 0);
        TTPlayerConfiger.setValue(2, this.mPlayerType == 2);
        TTPlayerConfiger.setValue(6, false);
        TTPlayerConfiger.setValue(11, true);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isOSPlayer() ^ (this.mPlayerType == 0)) {
                this.mPlayer.releaseAsync();
                this.mPlayer = null;
            }
        }
        if (this.mPlayer == null) {
            this.mPlayer = MediaPlayerWrapper.create(this.mContext, this.mPlayerDegradeMode);
            MediaLoaderWrapper.getDataLoader().setMediaPlayer(this.mPlayer);
            if (this.mPlayer.getPlayerType() != 1 && this.mPlayer.getPlayerType() != 2) {
                this.mHardwareDecodeEnable = 0;
                this.mEnableH264HardwareDecode = 0;
                this.mEnableByteVC1HardwareDecode = 0;
            }
            configPlayerGlobalOption();
            configPlayerEventHandler();
        }
        if (this.mPlayer.isOSPlayer()) {
            this.mLogService.setPlayerSdkVersion("-1");
        } else {
            this.mLogService.setPlayerSdkVersion(TTPlayerConfiger.getValue(14, "0"));
        }
        this.mDnsParser.configure(this.mForceHttpDns, this.mHttpDNSServerHost);
        if (this.mFetcher == null) {
            this.mFetcher = new LiveDataFetcher(this.mExecutor, this.mNetworkClient);
        }
        this.mPlayerSetting.setPlayer(this.mPlayer);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void pause() {
        MyLog.i(TAG, "pause");
        checkMainLooper("pause");
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mLivePlayerState = LivePlayerState.PAUSED;
        this.mPlayer.pause();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void play() throws JSONException, NumberFormatException {
        String str;
        this.mListener.onReportALog(4, "play start -- " + hashCode());
        checkMainLooper("play");
        if (this.mLivePlayerState == LivePlayerState.PLAYED) {
            this.mLogService.onIllegalAPICall("play");
            this.mListener.onReportALog(6, "illegal call: play -- " + hashCode());
            return;
        }
        if (this.mLivePlayerState == LivePlayerState.PAUSED) {
            this.mLivePlayerState = LivePlayerState.PLAYED;
            MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                return;
            }
            return;
        }
        MyLog.i(TAG, "play");
        if (this.mURLSource.getSourceType() == 2) {
            _configAbrInfo();
            _setStreamFormat();
            _setProtocol();
            _checkStreamData();
        }
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            this.mURLSource.setEnableSR(((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_super_resolution_enable", 0)).intValue());
            setIntOption(69, ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_texture_render_enable", 0)).intValue());
            if (((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_sharpen_enable", 0)).intValue() == 1) {
                JSONObject sharpenParams = this.mURLSource.getSharpenParams(this.mResolution, this.mLevel);
                this.mSharpenSdkParams = sharpenParams;
                if (sharpenParams != null) {
                    this.mEnableSharpen = sharpenParams.optInt("Enabled");
                }
            }
        }
        setIntOption(70, this.mURLSource.getSREnabled(this.mResolution, this.mLevel) ? 1 : 0);
        this.mLivePlayerState = LivePlayerState.PLAYED;
        this.mFrameTerminatedDTS = -1L;
        this.mLatestAudioPacketDTS = -1L;
        String playURLForResolution = null;
        LiveInfoSource liveInfoSource = this.mURLSource;
        if (liveInfoSource != null) {
            if (liveInfoSource.getSourceType() == 1 && this.mURLSource.getPlayLiveURL() != null) {
                playURLForResolution = this.mURLSource.getPlayLiveURL().mainURL;
                String str2 = this.mIsLocalURL ? this.mLocalURL : playURLForResolution;
                if (str2 != null) {
                    if (str2.startsWith(com.alipay.sdk.m.l.a.r)) {
                        this.mTransportProtocol = LiveConfigKey.TCP;
                    }
                    if (str2.startsWith("https")) {
                        this.mTransportProtocol = LiveConfigKey.TLS;
                    }
                    if (str2.startsWith("httpk")) {
                        this.mTransportProtocol = LiveConfigKey.KCP;
                    }
                    this.mURLProtocol = this.mTransportProtocol;
                }
                if (this.mQuicPull) {
                    try {
                        LibraryLoader.loadLibrary("ttquic");
                        this.mQuicEnable = true;
                        MyLog.i(TAG, "ttquic lib is load success");
                        this.mLogService.setQuicLibLoader(1);
                        str = LiveConfigKey.QUIC;
                    } catch (Throwable unused) {
                        String str3 = this.mTransportProtocol;
                        this.mQuicEnable = false;
                        MyLog.i(TAG, "ttquic lib is load failed. change default protocol");
                        this.mLogService.setQuicLibLoader(0);
                        str = str3;
                    }
                } else {
                    str = "";
                }
                if (str.isEmpty()) {
                    str = this.mTransportProtocol;
                }
                this.mTransportProtocol = str;
            } else if (this.mURLSource.getSourceType() == 2) {
                playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mStreamFormat, this.mLevel);
            }
        }
        if (this.mIsLocalURL) {
            playURLForResolution = this.mLocalURL;
        }
        if (playURLForResolution != null) {
            String sessionID = this.mURLSource.getSessionID();
            this.mUuid = sessionID;
            if (TextUtils.isEmpty(sessionID)) {
                this.mUuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            }
            this.mLogService.setProtocolInfo(this.mSuggestProtocol, this.mTransportProtocol);
            this.mLogService.reset();
            this.mLogService.mSessionId = this.mUuid + "." + System.currentTimeMillis();
            this.mLogService.mRuleIds = this.mURLSource.getRuleIds();
            this.mLogService.mResolution = this.mResolution;
            this.mLogService.mAutoUsingResolution = this.mURLSource.getDefaultResolution();
            this.mLogService.onPlay(this.mIsLocalURL ? this.mLocalURL : playURLForResolution, this.mDnsParser.getDNSServerIP());
            _play(playURLForResolution);
            this.mRetryProcessor.start();
        } else {
            HashMap map = new HashMap();
            map.put("url", "no playurl found while play");
            this.mRetryProcessor.onError(new LiveError(-100002, "playURL is null", map), this.mShowedFirstFrame);
        }
        if (this.mEnableStallCounter == 1) {
            startStallCounter();
        }
        this.mListener.onReportALog(4, "play end -- " + hashCode());
    }

    private void _play(String str) throws JSONException, NumberFormatException {
        if (this.mPrepareState == PlayerState.PREPARED && this.mPlayer != null) {
            MyLog.i(TAG, "_play resume");
            String str2 = this.mCurrentIP;
            if (str2 != null) {
                this.mLogService.setCdnIp(str2, false);
            }
            this.mPlayer.start();
        } else if (this.mPrepareState == PlayerState.IDLE || this.mPlayer == null) {
            MyLog.i(TAG, "_play start");
            open();
            this.mPrepareState = PlayerState.INITIALIZED;
            if (this.mIsLocalURL && !TextUtils.isEmpty(this.mLocalURL)) {
                this.mLogService.onCallPrepare();
                prepareToPlay(this.mLocalURL, null, null, null);
            } else {
                parsePlayDNS(str);
            }
        } else {
            configPlayerGlobalOption();
            if (this.mIsLocalURL && !TextUtils.isEmpty(this.mLocalURL)) {
                prepareToPlay(this.mLocalURL, null, null, null);
            } else {
                parsePlayDNS(str);
            }
        }
        this.mIsRequestCanceled = false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void stop() {
        MyLog.i(TAG, com.component.feed.a.e);
        this.mListener.onReportALog(4, "stop start -- " + hashCode());
        checkMainLooper(com.component.feed.a.e);
        _stop(true, com.component.feed.a.e);
        this.mRetryProcessor.stop();
        this.mListener.onReportALog(4, "stop end-- " + hashCode());
    }

    private void _stop(boolean z, String str) {
        MyLog.i(TAG, "_stop");
        if (this.mLivePlayerState != LivePlayerState.PLAYED && this.mLivePlayerState != LivePlayerState.PAUSED) {
            this.mLogService.onIllegalAPICall(str);
            this.mListener.onReportALog(6, "illegal call: " + str + " -- " + hashCode());
            return;
        }
        if (z) {
            _stopPlayer();
        } else {
            this.mPrepareState = PlayerState.INITIALIZED;
        }
        _stopLiveManager(str);
        this.mLivePlayerState = LivePlayerState.STOPPED;
        this.mSupportSRScene = 0;
        this.mTextureSRMode = 0;
        this.mEnableReportSessionStop = 0;
        this.mLogService.mMuteAudio = -1;
        this.mLogService.mVolumeSetting = -1.0f;
        this.mLogService.mPlayerVolumeSetting = -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _stopPlayer() {
        MyLog.i(TAG, "_stopPlayer");
        if (this.mPlayer != null && (this.mPrepareState == PlayerState.PREPARED || this.mPrepareState == PlayerState.PREPARING)) {
            LiveLoggerService liveLoggerService = this.mLogService;
            if (liveLoggerService != null) {
                liveLoggerService.getABRStreamInfo();
                this.mLogService.getAVPHStreamInfo();
                if (this.mEnableCheckFrame == 1 || this.mEnableCheckSEI == 1) {
                    this.mLogService.resetStreamCheckParams();
                }
            }
            if (this.mLivePlayerState != LivePlayerState.PAUSED) {
                this.mPlayer.stop();
            } else {
                this.mPlayer.reset();
            }
        }
        if (this.mIsPlayWithMdl && this.mSessionId != null) {
            MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(8018, this.mSessionId, 0);
        }
        this.mPrepareState = PlayerState.INITIALIZED;
        MyLog.i(TAG, "prepareState: " + this.mPrepareState);
    }

    private void _stopLiveManager(String str) {
        MyLog.i(TAG, "_stopLiveManager");
        LiveDataFetcher liveDataFetcher = this.mFetcher;
        if (liveDataFetcher != null) {
            liveDataFetcher.cancel();
        }
        DnsHelper dnsHelper = this.mDnsParser;
        if (dnsHelper != null) {
            dnsHelper.cancel();
        }
        if (this.mLivePlayerState == LivePlayerState.PLAYED || this.mLivePlayerState == LivePlayerState.PAUSED) {
            onRenderStallForRetryStop();
            if (this.mIsStalling) {
                this.mLogService.onStallEnd(0);
            }
            this.mLogService.close(str);
        }
        setIntOption(75, 0);
        this.mLogService.reset();
        this.mRetryProcessor.reset();
        if (str.equals("reset")) {
            this.mURLSource.reset();
        }
        this.mShowedFirstFrame = false;
        this.mRenderStartEntered = false;
        this.mResolutionDisableSR = true;
        this.mMediaSupportSR = false;
        this.mStallStartTime = 0L;
        this.mStallTotalTime = 0L;
        this.mStallCount = 0;
        this.mIsRequestCanceled = true;
        this.mLivePlayerState = LivePlayerState.STOPPED;
        this.mHasSeiInfo = false;
        this.mGetSeiCurrentTime = 0L;
        this.mIsStalling = false;
        this.mIsRetrying = false;
        this.mHasRetry = false;
        this.mSupportBackupIp = true;
        this.mUrlSettingMethod = -1;
        this.mEnableDTSCheck = 0;
        this.mEnablePreventDTSBack = 0;
        this.mEnableCheckFrame = 0;
        this.mEnterStallRetryInstantly = false;
        this.mEnableAvLines = "";
        this.mEnableSaveSCFG = false;
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mSuggestProtocol = "none";
        this.mEnableVideoMpdRefresh = 1;
        this.mEnableQuicCertVerify = false;
        this.mTextureSRMode = 0;
        this.mSupportSRScene = 0;
        this.mEnableTextureSR = 0;
        this.mEnableTextureRender = 0;
        this.mQuicVersion = 39;
        this.mQuicInitMTU = 1200;
        this.mEnableQuicMTUDiscovery = 0;
        this.mQuicInitRtt = 0;
        this.mQuicMaxCryptoRetransmissions = 0;
        this.mQuicMaxCryptoRetransmissionTimeMs = 0;
        this.mQuicMaxRetransmissions = 0;
        this.mQuicMaxRetransmissionTimeMs = 0;
        this.mQuicMaxAckDelay = 0;
        this.mQuicMinReceivedBeforeAckDecimation = 0;
        this.mQuicPadHello = 1;
        this.mQuicFixWillingAndAbleToWrite = 1;
        this.mQuicFixProcessTimer = 1;
        this.mQuicReadBlockTimeout = 100;
        this.mQuicReadBlockMode = 0;
        this.mQuicFixStreamFinAndRst = 0;
        this.mQuicConfigOptimize = 0;
        this.mEnableCheckDropAudio = 0;
        this.mIsPlayWithMdl = false;
        this.mAVNoSyncThreshold = 10000;
        this.mIsAlwaysDoAVSync = 0;
        this.mRedoDns = false;
        this.mEnableLiveAbrCheckEnhance = 0;
        this.mLiveABRCheckInterval = 1000;
        this.mABRMethod = -1;
        this.mRtcEnableDtls = 0;
        this.mRtcFallbackThreshold = 5000;
        this.mRtcMinJitterBuffer = 300;
        this.mRtcPlayFallBack = 0;
        this.mEnableRtcPlay = 0;
        this.mRtcEnableSDKDns = 0;
        this.mRtcEarlyInitRender = 0;
        this.mEnableFreeFlow = 0;
        this.mABRDisableAlgorithm = 0;
        this.mTextureRenderFirstFrame = false;
        this.mUsePlayerRenderStart = false;
        mFastOpenDuration = -1;
        this.mMyHandler.removeCallbacksAndMessages(null);
        if (this.mEnableStallCounter == 1) {
            stopStallCounter();
        }
        this.mNoSyncReportMinDuration = 5000;
        this.mNoSyncReportReportThres = 200;
    }

    private void startStallCounter() {
        synchronized (this.mStallCounterLock) {
            if (this.mStallCounterIsRunning) {
                return;
            }
            if (this.mStallCounterThread == null) {
                HandlerThread handlerThread = new HandlerThread("stallCounter");
                this.mStallCounterThread = handlerThread;
                handlerThread.start();
            }
            if (this.mStallCounterHandler == null) {
                this.mStallCounterHandler = new Handler(this.mStallCounterThread.getLooper());
            }
            this.mStallCounterHandler.post(this.mVideoStallCountTask);
            this.mStallCounterIsRunning = true;
        }
    }

    private void stopStallCounter() {
        synchronized (this.mStallCounterLock) {
            Handler handler = this.mStallCounterHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.mStallCounterIsRunning = false;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void reset() {
        MyLog.i(TAG, "reset");
        checkMainLooper("reset");
        if (this.mPlayer == null) {
            return;
        }
        _reset("reset");
        this.mLogService.reset();
        this.mCacheFileKey = null;
        this.mCacheFilePath = null;
        this.mEnableResolutionAutoDegrade = false;
        this.mEnableOriginResolution = false;
        this.mEnableSwitchMainAndBackupUrl = true;
        this.mEnableTextureSR = 0;
        this.mEnableTextureRender = 0;
        this.mTextureSRMode = 0;
        this.mResolution = LiveConfigKey.ORIGIN;
        this.mResolutionIndex = -1;
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mSuggestProtocol = "none";
        this.mLevel = LiveConfigKey.MAIN;
        this.mLocalURL = null;
        this.mIsLocalURL = false;
        this.mEnableHurryFlag = 0;
        this.mHurryType = -1;
        this.mEnableAvLines = "";
        this.mEnableSaveSCFG = false;
        this.mShowedFirstFrame = false;
        this.mEnableLLASHFastOpen = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _resetPlayer() {
        MyLog.i(TAG, "_resetPlayer");
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        this.mPrepareState = PlayerState.INITIALIZED;
    }

    private void _reset(String str) {
        MyLog.i(TAG, "_reset");
        _stopPlayer();
        _resetPlayer();
        _stopLiveManager(str);
        this.mResolutionIndex = -1;
        this.mLivePlayerState = LivePlayerState.IDLE;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void release() {
        MyLog.i(TAG, "release start");
        this.mListener.onReportALog(4, "release start -- " + hashCode());
        checkMainLooper("release");
        if (this.mLivePlayerState == LivePlayerState.PLAYED || this.mLivePlayerState == LivePlayerState.PAUSED) {
            _stop(true, "release");
        }
        releaseTextureRenderRef();
        this.mExecutor.shutdown();
        this.mMyHandler.removeCallbacksAndMessages(null);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.release();
        this.mPlayer = null;
        this.mLogService.reset();
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        MyLog.i(TAG, "release end");
        this.mListener.onReportALog(4, "release end -- " + hashCode());
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void releaseAsync() {
        this.mListener.onReportALog(4, "releaseAsync start -- " + hashCode());
        MyLog.i(TAG, "releaseAsync");
        checkMainLooper("releaseAsync");
        if (this.mLivePlayerState == LivePlayerState.PLAYED || this.mLivePlayerState == LivePlayerState.PAUSED) {
            _stop(false, "releaseAsync");
        }
        this.mExecutor.shutdown();
        this.mMyHandler.removeCallbacksAndMessages(null);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (this.mSurfaceHolder != null) {
            mediaPlayer.setDisplay(null);
        }
        releaseTextureRenderRef();
        MediaPlayer mediaPlayer2 = this.mPlayer;
        this.mPlayer = null;
        this.mLogService.reset();
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        LiveThreadPool.addExecuteTask(new MyReleaseRunnable(mediaPlayer2));
        MyLog.i(TAG, "releaseAsync end");
        this.mListener.onReportALog(4, "releaseAsync end -- " + hashCode());
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isOsPlayer() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isOSPlayer();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isIPPlayer() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.getPlayerType() == 2;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public int getVideoWidth() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public int getVideoHeight() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getMaxVolume() {
        return this.mPlayerSetting.getMaxVolume();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getVolume() {
        return this.mPlayerSetting.getVolume();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setVolume(float f) {
        this.mPlayerSetting.setVolume(f);
        this.mLogService.mVolumeSetting = f;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getPlayerVolume() {
        return this.mPlayerSetting.getPlayerVolume();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPlayerVolume(float f) {
        this.mPlayerSetting.setPlayerVolume(f);
        this.mLogService.mPlayerVolumeSetting = f;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setMute(Boolean bool) {
        this.mPlayerSetting.setMute(bool.booleanValue());
        this.mLogService.mMuteAudio = bool.booleanValue() ? 1 : 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setDisableVideoRender(Boolean bool) {
        MediaPlayer mediaPlayer;
        MyLog.i(TAG, "setDisableVideoRender: " + bool);
        this.mLogService.mDisableVideoRender = bool.booleanValue() ? 1 : 0;
        if (this.mEnableRadioLiveDisableRender != 1 || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        mediaPlayer.setIntOption(261, bool.booleanValue() ? 1 : 0);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setVideoFormat(String str) {
        this.mStreamFormat = str;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getPlayerErrorInfo() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null ? mediaPlayer.getStringOption(5002) : "none";
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getServerIP() {
        return this.mCurrentIP;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public JSONObject getStaticLog() {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService == null) {
            return null;
        }
        return liveLoggerService.getStaticLog();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setAsyncInit(int i) {
        String.format("setAsyncInit enable:%b", Integer.valueOf(i));
        this.mEnableMediaCodecASYNCInit = i;
    }

    public void getVideoCodecType() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null || this.mLogService == null) {
            return;
        }
        int intOption = mediaPlayer.getIntOption(141, -1);
        if (intOption == 0) {
            this.mLogService.setCodecType(KsMediaFormat.CODEC_NAME_H264);
        } else if (intOption == 1) {
            this.mLogService.setCodecType("bytevc1");
        }
    }

    public int getUrlSettingMethod() {
        return this.mUrlSettingMethod;
    }

    public long getNtpTimeDiff() {
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            return ((Long) iLiveSettingBundle.getSettingsValueForKey("time_diff_server_and_client", 0L)).longValue();
        }
        return 0L;
    }

    public int getEnableTexturerender() {
        return this.mEnableTextureRender;
    }

    public int getEnableSR() {
        return this.mEnableTextureSR;
    }

    public void getSessionlogInfo(LogBundle logBundle) {
        MediaPlayer mediaPlayer;
        if (logBundle == null || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        logBundle.playerDNSTimestamp = mediaPlayer.getLongOption(68, -1L);
        logBundle.tfoFallBackTime = this.mPlayer.getLongOption(318, -1L);
        logBundle.dropAudioPts = this.mPlayer.getLongOption(345, -1L);
        logBundle.dropAudioCostTime = this.mPlayer.getLongOption(346, -1L);
        logBundle.tcpConnectTimestamp = this.mPlayer.getLongOption(69, -1L);
        logBundle.tcpFirstPacketTimestamp = this.mPlayer.getLongOption(70, -1L);
        logBundle.videoPacketTimestamp = this.mPlayer.getLongOption(75, -1L);
        logBundle.audioPacketTimestamp = this.mPlayer.getLongOption(76, -1L);
        logBundle.videoDecodeTimestamp = this.mPlayer.getLongOption(77, -1L);
        logBundle.audioDecodeTimestamp = this.mPlayer.getLongOption(78, -1L);
        logBundle.videoDeviceOpenTime = this.mPlayer.getLongOption(155, -1L);
        logBundle.videoDeviceOpenedTime = this.mPlayer.getLongOption(162, -1L);
        logBundle.audioDeviceOpenTime = this.mPlayer.getLongOption(156, -1L);
        logBundle.audioDeviceOpenedTime = this.mPlayer.getLongOption(163, -1L);
        logBundle.downloadSpeed = (this.mPlayer.getLongOption(63, 0L) * 8) / 1000;
        logBundle.audioBufferTime = this.mPlayer.getLongOption(73, 0L);
        logBundle.videoBufferTime = this.mPlayer.getLongOption(72, 0L);
        logBundle.resolution = this.mResolution;
        logBundle.videoParamSendOutletTime = this.mPlayer.getLongOption(458, 0L);
        logBundle.firstVideoFrameSendOutletTime = this.mPlayer.getLongOption(459, 0L);
        logBundle.renderType = this.mPlayer.getVideoType();
        logBundle.streamInfoFindTime = this.mPlayer.getLongOption(624, 0L);
        logBundle.streamInfoFoundTime = this.mPlayer.getLongOption(338, 0L);
        logBundle.videoDeviceWaitStartTime = this.mPlayer.getLongOption(336, 0L);
        logBundle.videoDeviceWaitEndTime = this.mPlayer.getLongOption(337, 0L);
        logBundle.videoFirstPacketPos = this.mPlayer.getLongOption(341, -1L);
        logBundle.videoFirstPacketPts = this.mPlayer.getLongOption(343, -1L);
        logBundle.audioFirstPacketPos = this.mPlayer.getLongOption(342, -1L);
        logBundle.audioFirstPacketPts = this.mPlayer.getLongOption(344, -1L);
        logBundle.httpReqFinishTimestamp = this.mPlayer.getLongOption(821, 0L);
        logBundle.httpResFinishTimestamp = this.mPlayer.getLongOption(822, 0L);
        logBundle.downloadSize = this.mPlayer.getLongOption(45, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0403  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getLogInfo(com.bykv.vk.component.ttvideo.log.LogBundle r17, int r18) {
        /*
            Method dump skipped, instructions count: 1036
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager.getLogInfo(com.bykv.vk.component.ttvideo.log.LogBundle, int):void");
    }

    private void addRtcCodecInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.mLogService.mCodecName) || "none_codec".equals(this.mLogService.mCodecName)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("video_codec_impl_name")) {
                    String strOptString = jSONObject.optString("video_codec_impl_name");
                    if (!TextUtils.isEmpty(strOptString)) {
                        if ("MediaCodec".equals(strOptString)) {
                            this.mLogService.mCodecName = "hardware_codec";
                            this.mLogService.mHardDecodeEnable = true;
                        } else {
                            this.mLogService.mCodecName = "software_codec";
                            this.mLogService.mHardDecodeEnable = false;
                        }
                    }
                }
                if (jSONObject.has("video_codec_name")) {
                    String strOptString2 = jSONObject.optString("video_codec_name");
                    if (!TextUtils.isEmpty(strOptString2)) {
                        if ("ByteVC1".equalsIgnoreCase(strOptString2)) {
                            this.mLogService.mCodecType = "bytevc1";
                        } else {
                            this.mLogService.mCodecType = KsMediaFormat.CODEC_NAME_H264;
                        }
                    }
                }
                MyLog.i(TAG, "addRtcCodecInfo mCodecName:" + this.mLogService.mCodecName + ", mCodecType:" + this.mLogService.mCodecType + ",mHardDecodeEnable:" + this.mLogService.mHardDecodeEnable);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSessionFirstFrameInfo() {
        if (this.mLogService.mSessionLogBundle == null || this.mPlayer == null) {
            return;
        }
        this.mLogService.mSessionLogBundle.downloadSpeedOnFirstFrame = (this.mPlayer.getLongOption(63, 0L) * 8) / 1000;
        this.mLogService.mSessionLogBundle.videoBufferTimeOnFirstFrame = this.mPlayer.getLongOption(72, 0L);
        this.mLogService.mSessionLogBundle.audioBufferTimeOnFirstFrame = this.mPlayer.getLongOption(73, 0L);
    }

    private JSONObject extractAvphStreamInfo(String str) throws JSONException {
        String[] strArr;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9 = "audio_find_stream_info_cost";
        String str10 = "audio_open_input_cost";
        String str11 = "av_dts_diff";
        String str12 = "audio_cur_dts";
        String str13 = "video_last_dts";
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String str14 = "video_find_stream_info_cost";
            String[] strArrSplit = str.split(",");
            int length = strArrSplit.length;
            String str15 = "video_open_input_cost";
            int i = 0;
            while (i < length) {
                int i2 = length;
                String str16 = strArrSplit[i];
                if (str16.startsWith("video_key")) {
                    strArr = strArrSplit;
                    jSONObject.put("video_key", Integer.parseInt(str16.substring(10)));
                } else {
                    strArr = strArrSplit;
                    if (str16.startsWith(str13)) {
                        jSONObject.put(str13, Integer.parseInt(str16.substring(15)));
                    } else {
                        str2 = str13;
                        if (str16.startsWith("video_cur_dts")) {
                            jSONObject.put("video_cur_dts", Integer.parseInt(str16.substring(14)));
                        } else if (str16.startsWith("vv_dts_diff")) {
                            jSONObject.put("vv_dts_diff", Integer.parseInt(str16.substring(12)));
                        } else if (str16.startsWith(str12)) {
                            jSONObject.put(str12, Integer.parseInt(str16.substring(14)));
                        } else if (str16.startsWith(str11)) {
                            jSONObject.put(str11, Integer.parseInt(str16.substring(12)));
                        } else {
                            if (str16.startsWith("audio_first_pkt_ts")) {
                                str3 = str11;
                                str4 = str12;
                                jSONObject.put("audio_first_pkt_ts", Long.parseLong(str16.substring(19)));
                            } else {
                                str3 = str11;
                                str4 = str12;
                                if (str16.startsWith("audio_first_pkt_dts")) {
                                    jSONObject.put("audio_first_pkt_dts", Long.parseLong(str16.substring(20)));
                                } else if (str16.startsWith("video_first_pkt_ts")) {
                                    jSONObject.put("video_first_pkt_ts", Long.parseLong(str16.substring(19)));
                                } else if (str16.startsWith("video_first_pkt_dts")) {
                                    jSONObject.put("video_first_pkt_dts", Long.parseLong(str16.substring(20)));
                                } else if (str16.startsWith(str10)) {
                                    jSONObject.put(str10, Long.parseLong(str16.substring(22)));
                                } else if (str16.startsWith(str9)) {
                                    jSONObject.put(str9, Long.parseLong(str16.substring(28)));
                                } else {
                                    str5 = str15;
                                    if (str16.startsWith(str5)) {
                                        jSONObject.put(str5, Long.parseLong(str16.substring(22)));
                                        str7 = str9;
                                        str8 = str10;
                                        str6 = str14;
                                    } else {
                                        str6 = str14;
                                        if (str16.startsWith(str6)) {
                                            String strSubstring = str16.substring(28);
                                            str7 = str9;
                                            str8 = str10;
                                            jSONObject.put(str6, Long.parseLong(strSubstring));
                                        } else {
                                            str7 = str9;
                                            str8 = str10;
                                        }
                                    }
                                    i++;
                                    str15 = str5;
                                    str14 = str6;
                                    str9 = str7;
                                    str10 = str8;
                                    length = i2;
                                    str13 = str2;
                                    str11 = str3;
                                    str12 = str4;
                                    strArrSplit = strArr;
                                }
                            }
                            str7 = str9;
                            str8 = str10;
                            str6 = str14;
                            str5 = str15;
                            i++;
                            str15 = str5;
                            str14 = str6;
                            str9 = str7;
                            str10 = str8;
                            length = i2;
                            str13 = str2;
                            str11 = str3;
                            str12 = str4;
                            strArrSplit = strArr;
                        }
                        str7 = str9;
                        str8 = str10;
                        str3 = str11;
                        str4 = str12;
                        str6 = str14;
                        str5 = str15;
                        i++;
                        str15 = str5;
                        str14 = str6;
                        str9 = str7;
                        str10 = str8;
                        length = i2;
                        str13 = str2;
                        str11 = str3;
                        str12 = str4;
                        strArrSplit = strArr;
                    }
                }
                str8 = str10;
                str3 = str11;
                str4 = str12;
                str2 = str13;
                str6 = str14;
                str5 = str15;
                str7 = str9;
                i++;
                str15 = str5;
                str14 = str6;
                str9 = str7;
                str10 = str8;
                length = i2;
                str13 = str2;
                str11 = str3;
                str12 = str4;
                strArrSplit = strArr;
            }
            return jSONObject;
        } catch (JSONException e) {
            mq.d(e);
            return null;
        } catch (Exception e2) {
            mq.d(e2);
            return null;
        }
    }

    private JSONArray formatAVPHStreamInfoToJSONArray(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (str.contains(i.b)) {
            for (String str2 : str.split(i.b)) {
                JSONObject jSONObjectExtractAvphStreamInfo = extractAvphStreamInfo(str2);
                if (jSONObjectExtractAvphStreamInfo != null) {
                    arrayList.add(jSONObjectExtractAvphStreamInfo);
                }
            }
        } else {
            JSONObject jSONObjectExtractAvphStreamInfo2 = extractAvphStreamInfo(str);
            if (jSONObjectExtractAvphStreamInfo2 != null) {
                arrayList.add(jSONObjectExtractAvphStreamInfo2);
            }
        }
        return new JSONArray((Collection) arrayList);
    }

    private JSONArray formatABRStreamInfoToJSONArray(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (true) {
                JSONObject jSONObject = new JSONObject();
                int iIndexOf = str.indexOf("index:");
                int iIndexOf2 = str.indexOf(",pts_diff:");
                if (iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf < iIndexOf2) {
                    jSONObject.put("index", Integer.parseInt(str.substring(iIndexOf + 6, iIndexOf2)));
                    String strSubstring = str.substring(iIndexOf2);
                    int iIndexOf3 = strSubstring.indexOf(",drop_dur:");
                    if (iIndexOf3 >= 0 && 10 < iIndexOf3) {
                        jSONObject.put("pts_diff", Long.parseLong(strSubstring.substring(10, iIndexOf3)));
                        String strSubstring2 = strSubstring.substring(iIndexOf3);
                        int iIndexOf4 = strSubstring2.indexOf(",key:");
                        if (iIndexOf4 >= 0 && 10 < iIndexOf4) {
                            jSONObject.put("drop_dur", Long.parseLong(strSubstring2.substring(10, iIndexOf4)));
                            String strSubstring3 = strSubstring2.substring(iIndexOf4);
                            int iIndexOf5 = strSubstring3.indexOf(",index:");
                            if (iIndexOf5 != -1) {
                                if (5 >= iIndexOf5) {
                                    break;
                                }
                                jSONObject.put("key_frame", Integer.parseInt(strSubstring3.substring(5, iIndexOf5)));
                                arrayList.add(jSONObject);
                                str = strSubstring3.substring(iIndexOf5 + 1);
                            } else if (strSubstring3.length() != 0) {
                                String strSubstring4 = strSubstring3.substring(5);
                                jSONObject.put("key_frame", Integer.parseInt(strSubstring4));
                                arrayList.add(jSONObject);
                                mq.d(TAG, "key: " + strSubstring4);
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            return new JSONArray((Collection) arrayList);
        } catch (JSONException e) {
            mq.d(e);
            return null;
        }
    }

    private void parseResponseHeaders(LogBundle logBundle) {
        String stringOption = this.mPlayer.getStringOption(335);
        if (stringOption == null) {
            return;
        }
        for (String str : stringOption.split("\r\n")) {
            if (str.startsWith("X-Server-Ip: ")) {
                logBundle.headerXServerIP = str.split(": ", 2)[1];
            } else if (str.startsWith("Via: ")) {
                logBundle.headerVia = str.split(": ", 2)[1];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parsePlayDNS(final java.lang.String r9) throws org.json.JSONException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager.parsePlayDNS(java.lang.String):void");
    }

    private String prepareProxyURL(String str, String str2, String str3, Map<String, String> map) throws JSONException {
        MyLog.i(TAG, "prepareProxy play url: " + str + ", host: " + str3);
        if (!this.mTransportProtocol.equals(LiveConfigKey.TCP) || !this.mStreamFormat.equals(LiveConfigKey.FLV) || this.mEnableResolutionAutoDegrade || TextUtils.isEmpty(this.mSessionId)) {
            String str4 = "proxy not support format: " + this.mStreamFormat + ", proto: " + this.mTransportProtocol + ", abr: " + this.mEnableResolutionAutoDegrade + ", sessio id invalid: " + TextUtils.isEmpty(this.mSessionId);
            MyLog.i(TAG, str4);
            this.mLogService.mLiveIOErrorMsg = str4;
            return null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            try {
                URL url = new URL(str);
                String string = new URL(url.getProtocol(), str3, url.getPort() == -1 ? url.getDefaultPort() : url.getPort(), url.getFile()).toString();
                MyLog.i(TAG, "prepareProxy proxy url: " + string);
                MyLog.i(TAG, "enable liveio:" + this.mEnableOpenLiveIO + " enable liveio play:" + this.mEnableLiveIOPlay);
                MyLog.i(TAG, "live mdl enable_from_sdk:" + this.mEnableOpenMDL + " enable_from_app:" + MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8100) + " is_running:" + MediaLoaderWrapper.getDataLoader().isRunning());
                if (this.mEnableOpenMDL == 1 && MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8100) == 1 && MediaLoaderWrapper.getDataLoader().isRunning()) {
                    if (this.mALogWriteAddr != -1) {
                        MediaLoaderWrapper.getDataLoader().setLongValue(59, this.mALogWriteAddr);
                    }
                    this.mIsPlayWithMdl = true;
                    runOnCurrentThread(new PlayCacheSyncRunner(this, this.mSessionId, false));
                    MyLog.i(TAG, "setup mdl play cache sync runner of :" + this.mSessionId);
                    String proxyUrl = MediaLoaderWrapper.getDataLoader().getProxyUrl(string, Boolean.valueOf(this.mIsMdlProtoRegister));
                    MyLog.i(TAG, "proxyUrl: " + proxyUrl);
                    if (proxyUrl != null && !proxyUrl.isEmpty()) {
                        map.put("Stream-Type", ILivePush.ClickType.LIVE);
                        String str5 = this.mSessionId;
                        if (str5 != null) {
                            map.put("X-Tt-Traceid", str5);
                        }
                        if (str2 != null && !str2.equals("none")) {
                            if (str2.startsWith("[")) {
                                str2 = str2.substring(1, str2.length() - 1);
                            }
                            map.put("X-Given-IPs", str2);
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (proxyUrl != null) {
                                jSONObject.put("url", proxyUrl);
                            }
                            if (str2 != null) {
                                jSONObject.put("ip", str2);
                            }
                            String str6 = this.mSessionId;
                            if (str6 != null) {
                                jSONObject.put("traceId", str6);
                            }
                            MediaLoaderWrapper.getDataLoader().setStringValue(8017, jSONObject.toString());
                        } catch (Exception unused) {
                            MyLog.w(TAG, "set play info to mdl failed");
                        }
                        return proxyUrl;
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    private String packAvphHeader(String str, String str2, String str3) {
        if (!str.equals("")) {
            str = str + com.alipay.sdk.m.s.a.n;
        }
        return ((str + str2) + "=") + str3;
    }

    private void prepareAvphPlay() {
        this.mPlayer.setIntOption(159, this.mFramesDrop);
        this.mPlayer.setIntOption(653, this.mEnableSkipFindUnnecessaryStream);
        this.mPlayer.setIntOption(655, this.mAVPHDnsParseEnable);
        this.mPlayer.setIntOption(656, this.mAVPHDnsTimeout);
        this.mPlayer.setIntOption(326, this.mAVPHVideoProbesize);
        this.mPlayer.setIntOption(327, this.mAVPHVideoMaxDuration);
        this.mPlayer.setIntOption(328, this.mAVPHAudioProbesize);
        this.mPlayer.setIntOption(329, this.mAVPHAudioMaxDuration);
        this.mPlayer.setIntOption(330, this.mAVPHOpenVideoFirst);
        this.mPlayer.setIntOption(331, this.mAVPHMaxAVDiff);
        this.mPlayer.setIntOption(332, this.mAVPHEnableAutoReopen);
        this.mPlayer.setIntOption(712, this.mAVPHAutoExit);
        this.mPlayer.setIntOption(711, this.mAVPHVideoDiffThreshold);
        this.mPlayer.setIntOption(713, this.mAVPHReadRetryCount);
        this.mPlayer.setIntOption(714, this.mAVPHReadErrorExit);
        String str = new String();
        String str2 = new String();
        if (this.mAudioOnly.equals(LiveConfigKey.ONLYAUDIO)) {
            str = packAvphHeader(str, "only_audio", "1");
        }
        if (this.mVideoOnly.equals(LiveConfigKey.ONLYVIDEO)) {
            str2 = packAvphHeader(str2, "only_video", "1");
        }
        this.mPlayer.setStringOption(376, str);
        this.mPlayer.setStringOption(377, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0421 A[Catch: Exception -> 0x0775, TryCatch #5 {Exception -> 0x0775, blocks: (B:84:0x0399, B:86:0x039d, B:87:0x03a2, B:90:0x03ad, B:92:0x03b1, B:93:0x03c6, B:96:0x03d2, B:97:0x03d9, B:99:0x03e3, B:101:0x03f9, B:102:0x0402, B:104:0x0406, B:105:0x0419, B:107:0x0421, B:108:0x0428, B:110:0x0430, B:112:0x0434, B:114:0x043e, B:116:0x0447, B:118:0x044f, B:120:0x045f, B:122:0x046b, B:123:0x0470, B:128:0x04be, B:129:0x04c7, B:131:0x04d3, B:133:0x04d7, B:134:0x04de, B:136:0x04e3, B:137:0x04f9, B:139:0x04fd, B:140:0x0504, B:142:0x0508, B:144:0x0514, B:150:0x0540, B:152:0x0548, B:154:0x05ba, B:155:0x05cb, B:157:0x05d0, B:158:0x05e9, B:162:0x05ff, B:164:0x0607, B:166:0x063a, B:168:0x065c, B:170:0x0661, B:172:0x0665, B:176:0x068c, B:178:0x0693, B:180:0x06b7, B:181:0x06d5, B:185:0x06dd, B:187:0x0706, B:165:0x0623, B:167:0x0641, B:126:0x04ad), top: B:226:0x0399 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0430 A[Catch: Exception -> 0x0775, TryCatch #5 {Exception -> 0x0775, blocks: (B:84:0x0399, B:86:0x039d, B:87:0x03a2, B:90:0x03ad, B:92:0x03b1, B:93:0x03c6, B:96:0x03d2, B:97:0x03d9, B:99:0x03e3, B:101:0x03f9, B:102:0x0402, B:104:0x0406, B:105:0x0419, B:107:0x0421, B:108:0x0428, B:110:0x0430, B:112:0x0434, B:114:0x043e, B:116:0x0447, B:118:0x044f, B:120:0x045f, B:122:0x046b, B:123:0x0470, B:128:0x04be, B:129:0x04c7, B:131:0x04d3, B:133:0x04d7, B:134:0x04de, B:136:0x04e3, B:137:0x04f9, B:139:0x04fd, B:140:0x0504, B:142:0x0508, B:144:0x0514, B:150:0x0540, B:152:0x0548, B:154:0x05ba, B:155:0x05cb, B:157:0x05d0, B:158:0x05e9, B:162:0x05ff, B:164:0x0607, B:166:0x063a, B:168:0x065c, B:170:0x0661, B:172:0x0665, B:176:0x068c, B:178:0x0693, B:180:0x06b7, B:181:0x06d5, B:185:0x06dd, B:187:0x0706, B:165:0x0623, B:167:0x0641, B:126:0x04ad), top: B:226:0x0399 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0548 A[Catch: Exception -> 0x0775, TryCatch #5 {Exception -> 0x0775, blocks: (B:84:0x0399, B:86:0x039d, B:87:0x03a2, B:90:0x03ad, B:92:0x03b1, B:93:0x03c6, B:96:0x03d2, B:97:0x03d9, B:99:0x03e3, B:101:0x03f9, B:102:0x0402, B:104:0x0406, B:105:0x0419, B:107:0x0421, B:108:0x0428, B:110:0x0430, B:112:0x0434, B:114:0x043e, B:116:0x0447, B:118:0x044f, B:120:0x045f, B:122:0x046b, B:123:0x0470, B:128:0x04be, B:129:0x04c7, B:131:0x04d3, B:133:0x04d7, B:134:0x04de, B:136:0x04e3, B:137:0x04f9, B:139:0x04fd, B:140:0x0504, B:142:0x0508, B:144:0x0514, B:150:0x0540, B:152:0x0548, B:154:0x05ba, B:155:0x05cb, B:157:0x05d0, B:158:0x05e9, B:162:0x05ff, B:164:0x0607, B:166:0x063a, B:168:0x065c, B:170:0x0661, B:172:0x0665, B:176:0x068c, B:178:0x0693, B:180:0x06b7, B:181:0x06d5, B:185:0x06dd, B:187:0x0706, B:165:0x0623, B:167:0x0641, B:126:0x04ad), top: B:226:0x0399 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0641 A[Catch: Exception -> 0x0775, TryCatch #5 {Exception -> 0x0775, blocks: (B:84:0x0399, B:86:0x039d, B:87:0x03a2, B:90:0x03ad, B:92:0x03b1, B:93:0x03c6, B:96:0x03d2, B:97:0x03d9, B:99:0x03e3, B:101:0x03f9, B:102:0x0402, B:104:0x0406, B:105:0x0419, B:107:0x0421, B:108:0x0428, B:110:0x0430, B:112:0x0434, B:114:0x043e, B:116:0x0447, B:118:0x044f, B:120:0x045f, B:122:0x046b, B:123:0x0470, B:128:0x04be, B:129:0x04c7, B:131:0x04d3, B:133:0x04d7, B:134:0x04de, B:136:0x04e3, B:137:0x04f9, B:139:0x04fd, B:140:0x0504, B:142:0x0508, B:144:0x0514, B:150:0x0540, B:152:0x0548, B:154:0x05ba, B:155:0x05cb, B:157:0x05d0, B:158:0x05e9, B:162:0x05ff, B:164:0x0607, B:166:0x063a, B:168:0x065c, B:170:0x0661, B:172:0x0665, B:176:0x068c, B:178:0x0693, B:180:0x06b7, B:181:0x06d5, B:185:0x06dd, B:187:0x0706, B:165:0x0623, B:167:0x0641, B:126:0x04ad), top: B:226:0x0399 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0693 A[Catch: Exception -> 0x0775, TryCatch #5 {Exception -> 0x0775, blocks: (B:84:0x0399, B:86:0x039d, B:87:0x03a2, B:90:0x03ad, B:92:0x03b1, B:93:0x03c6, B:96:0x03d2, B:97:0x03d9, B:99:0x03e3, B:101:0x03f9, B:102:0x0402, B:104:0x0406, B:105:0x0419, B:107:0x0421, B:108:0x0428, B:110:0x0430, B:112:0x0434, B:114:0x043e, B:116:0x0447, B:118:0x044f, B:120:0x045f, B:122:0x046b, B:123:0x0470, B:128:0x04be, B:129:0x04c7, B:131:0x04d3, B:133:0x04d7, B:134:0x04de, B:136:0x04e3, B:137:0x04f9, B:139:0x04fd, B:140:0x0504, B:142:0x0508, B:144:0x0514, B:150:0x0540, B:152:0x0548, B:154:0x05ba, B:155:0x05cb, B:157:0x05d0, B:158:0x05e9, B:162:0x05ff, B:164:0x0607, B:166:0x063a, B:168:0x065c, B:170:0x0661, B:172:0x0665, B:176:0x068c, B:178:0x0693, B:180:0x06b7, B:181:0x06d5, B:185:0x06dd, B:187:0x0706, B:165:0x0623, B:167:0x0641, B:126:0x04ad), top: B:226:0x0399 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0704  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0706 A[Catch: Exception -> 0x0775, TRY_LEAVE, TryCatch #5 {Exception -> 0x0775, blocks: (B:84:0x0399, B:86:0x039d, B:87:0x03a2, B:90:0x03ad, B:92:0x03b1, B:93:0x03c6, B:96:0x03d2, B:97:0x03d9, B:99:0x03e3, B:101:0x03f9, B:102:0x0402, B:104:0x0406, B:105:0x0419, B:107:0x0421, B:108:0x0428, B:110:0x0430, B:112:0x0434, B:114:0x043e, B:116:0x0447, B:118:0x044f, B:120:0x045f, B:122:0x046b, B:123:0x0470, B:128:0x04be, B:129:0x04c7, B:131:0x04d3, B:133:0x04d7, B:134:0x04de, B:136:0x04e3, B:137:0x04f9, B:139:0x04fd, B:140:0x0504, B:142:0x0508, B:144:0x0514, B:150:0x0540, B:152:0x0548, B:154:0x05ba, B:155:0x05cb, B:157:0x05d0, B:158:0x05e9, B:162:0x05ff, B:164:0x0607, B:166:0x063a, B:168:0x065c, B:170:0x0661, B:172:0x0665, B:176:0x068c, B:178:0x0693, B:180:0x06b7, B:181:0x06d5, B:185:0x06dd, B:187:0x0706, B:165:0x0623, B:167:0x0641, B:126:0x04ad), top: B:226:0x0399 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0728  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x072c  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0737  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0741 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0790  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0742 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x051a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x039d A[Catch: Exception -> 0x0775, TryCatch #5 {Exception -> 0x0775, blocks: (B:84:0x0399, B:86:0x039d, B:87:0x03a2, B:90:0x03ad, B:92:0x03b1, B:93:0x03c6, B:96:0x03d2, B:97:0x03d9, B:99:0x03e3, B:101:0x03f9, B:102:0x0402, B:104:0x0406, B:105:0x0419, B:107:0x0421, B:108:0x0428, B:110:0x0430, B:112:0x0434, B:114:0x043e, B:116:0x0447, B:118:0x044f, B:120:0x045f, B:122:0x046b, B:123:0x0470, B:128:0x04be, B:129:0x04c7, B:131:0x04d3, B:133:0x04d7, B:134:0x04de, B:136:0x04e3, B:137:0x04f9, B:139:0x04fd, B:140:0x0504, B:142:0x0508, B:144:0x0514, B:150:0x0540, B:152:0x0548, B:154:0x05ba, B:155:0x05cb, B:157:0x05d0, B:158:0x05e9, B:162:0x05ff, B:164:0x0607, B:166:0x063a, B:168:0x065c, B:170:0x0661, B:172:0x0665, B:176:0x068c, B:178:0x0693, B:180:0x06b7, B:181:0x06d5, B:185:0x06dd, B:187:0x0706, B:165:0x0623, B:167:0x0641, B:126:0x04ad), top: B:226:0x0399 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03ad A[Catch: Exception -> 0x0775, TRY_ENTER, TryCatch #5 {Exception -> 0x0775, blocks: (B:84:0x0399, B:86:0x039d, B:87:0x03a2, B:90:0x03ad, B:92:0x03b1, B:93:0x03c6, B:96:0x03d2, B:97:0x03d9, B:99:0x03e3, B:101:0x03f9, B:102:0x0402, B:104:0x0406, B:105:0x0419, B:107:0x0421, B:108:0x0428, B:110:0x0430, B:112:0x0434, B:114:0x043e, B:116:0x0447, B:118:0x044f, B:120:0x045f, B:122:0x046b, B:123:0x0470, B:128:0x04be, B:129:0x04c7, B:131:0x04d3, B:133:0x04d7, B:134:0x04de, B:136:0x04e3, B:137:0x04f9, B:139:0x04fd, B:140:0x0504, B:142:0x0508, B:144:0x0514, B:150:0x0540, B:152:0x0548, B:154:0x05ba, B:155:0x05cb, B:157:0x05d0, B:158:0x05e9, B:162:0x05ff, B:164:0x0607, B:166:0x063a, B:168:0x065c, B:170:0x0661, B:172:0x0665, B:176:0x068c, B:178:0x0693, B:180:0x06b7, B:181:0x06d5, B:185:0x06dd, B:187:0x0706, B:165:0x0623, B:167:0x0641, B:126:0x04ad), top: B:226:0x0399 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03d2 A[Catch: Exception -> 0x0775, TRY_ENTER, TryCatch #5 {Exception -> 0x0775, blocks: (B:84:0x0399, B:86:0x039d, B:87:0x03a2, B:90:0x03ad, B:92:0x03b1, B:93:0x03c6, B:96:0x03d2, B:97:0x03d9, B:99:0x03e3, B:101:0x03f9, B:102:0x0402, B:104:0x0406, B:105:0x0419, B:107:0x0421, B:108:0x0428, B:110:0x0430, B:112:0x0434, B:114:0x043e, B:116:0x0447, B:118:0x044f, B:120:0x045f, B:122:0x046b, B:123:0x0470, B:128:0x04be, B:129:0x04c7, B:131:0x04d3, B:133:0x04d7, B:134:0x04de, B:136:0x04e3, B:137:0x04f9, B:139:0x04fd, B:140:0x0504, B:142:0x0508, B:144:0x0514, B:150:0x0540, B:152:0x0548, B:154:0x05ba, B:155:0x05cb, B:157:0x05d0, B:158:0x05e9, B:162:0x05ff, B:164:0x0607, B:166:0x063a, B:168:0x065c, B:170:0x0661, B:172:0x0665, B:176:0x068c, B:178:0x0693, B:180:0x06b7, B:181:0x06d5, B:185:0x06dd, B:187:0x0706, B:165:0x0623, B:167:0x0641, B:126:0x04ad), top: B:226:0x0399 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03e3 A[Catch: Exception -> 0x0775, TryCatch #5 {Exception -> 0x0775, blocks: (B:84:0x0399, B:86:0x039d, B:87:0x03a2, B:90:0x03ad, B:92:0x03b1, B:93:0x03c6, B:96:0x03d2, B:97:0x03d9, B:99:0x03e3, B:101:0x03f9, B:102:0x0402, B:104:0x0406, B:105:0x0419, B:107:0x0421, B:108:0x0428, B:110:0x0430, B:112:0x0434, B:114:0x043e, B:116:0x0447, B:118:0x044f, B:120:0x045f, B:122:0x046b, B:123:0x0470, B:128:0x04be, B:129:0x04c7, B:131:0x04d3, B:133:0x04d7, B:134:0x04de, B:136:0x04e3, B:137:0x04f9, B:139:0x04fd, B:140:0x0504, B:142:0x0508, B:144:0x0514, B:150:0x0540, B:152:0x0548, B:154:0x05ba, B:155:0x05cb, B:157:0x05d0, B:158:0x05e9, B:162:0x05ff, B:164:0x0607, B:166:0x063a, B:168:0x065c, B:170:0x0661, B:172:0x0665, B:176:0x068c, B:178:0x0693, B:180:0x06b7, B:181:0x06d5, B:185:0x06dd, B:187:0x0706, B:165:0x0623, B:167:0x0641, B:126:0x04ad), top: B:226:0x0399 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void prepareToPlay(java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28) throws org.json.JSONException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1950
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager.prepareToPlay(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abrDegradeResolution() throws JSONException, NumberFormatException {
        String playURLForResolution;
        int length = LiveConfigKey.resolution.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            }
            if (this.mURLSource.isSupportResolution(LiveConfigKey.resolution[length])) {
                break;
            }
            length--;
        }
        if (length == -1) {
            return false;
        }
        MyLog.i(TAG, "abrDegradeResolution, resolution: " + LiveConfigKey.resolution[length] + ", auto defalut resolution: " + this.mURLSource.getDefaultResolution());
        if (this.mURLSource.getDefaultResolution().equals(LiveConfigKey.resolution[length]) || (playURLForResolution = this.mURLSource.getPlayURLForResolution(LiveConfigKey.resolution[length], this.mStreamFormat, LiveConfigKey.MAIN)) == null) {
            return false;
        }
        String str = this.mCurrentPlayURL;
        this.mCurrentPlayURL = playURLForResolution;
        this.mResolutionIndex = length;
        this.mURLSource.setDefaultResolution(LiveConfigKey.resolution[length]);
        this.mLogService.mAutoUsingResolution = LiveConfigKey.resolution[length];
        saveCurrentResolution();
        this.mLogService.onSwitch(str, this.mCurrentPlayURL, "auto_" + this.mLogService.mLastResolution + "_to_" + this.mResolution, LiveError.PLAYER_STALL);
        this.mLogService.onSwitchURL(this.mCurrentPlayURL);
        this.mLevel = LiveConfigKey.MAIN;
        this.mStallCount = 0;
        parsePlayDNS(playURLForResolution);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean degradeResolution() throws JSONException, NumberFormatException {
        String playURLForResolution;
        if (this.mResolution == LiveConfigKey.LOW) {
            return false;
        }
        if (this.mResolutionIndex == -1) {
            int i = 0;
            while (true) {
                if (i >= LiveConfigKey.resolution.length) {
                    break;
                }
                if (LiveConfigKey.resolution[i].equals(this.mResolution)) {
                    this.mResolutionIndex = i;
                    break;
                }
                i++;
            }
        }
        int i2 = this.mResolutionIndex + 1;
        while (i2 < LiveConfigKey.resolution.length && !this.mURLSource.isSupportResolution(LiveConfigKey.resolution[i2])) {
            i2++;
        }
        if (i2 >= LiveConfigKey.resolution.length || (playURLForResolution = this.mURLSource.getPlayURLForResolution(LiveConfigKey.resolution[i2], this.mStreamFormat, this.mLevel)) == null) {
            return false;
        }
        String str = this.mCurrentPlayURL;
        this.mCurrentPlayURL = playURLForResolution;
        this.mResolutionIndex = i2;
        saveCurrentResolution();
        LiveLoggerService liveLoggerService = this.mLogService;
        String str2 = LiveConfigKey.resolution[i2];
        this.mResolution = str2;
        liveLoggerService.mResolution = str2;
        this.mLogService.onSwitch(str, this.mCurrentPlayURL, "auto_" + this.mLogService.mLastResolution + "_to_" + this.mResolution, LiveError.PLAYER_STALL);
        ILiveListener iLiveListener = this.mListener;
        if (iLiveListener != null) {
            iLiveListener.onResolutionDegrade(this.mResolution);
        }
        this.mLogService.onSwitchURL(this.mCurrentPlayURL);
        this.mStallCount = 0;
        parsePlayDNS(playURLForResolution);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean switchMainAndBackupUrl(int i) throws JSONException, NumberFormatException {
        if (this.mLevel.equals(LiveConfigKey.MAIN)) {
            String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, LiveConfigKey.FLV, LiveConfigKey.BACKUP);
            if (playURLForResolution != null) {
                updateDownloadSizeStat();
                this.mLogService.onSessionStop();
                this.mIsRetrying = true;
                this.mLogService.onSwitch(this.mCurrentPlayURL, playURLForResolution, "main_to_backup", i);
                this.mLogService.onSwitchURL(playURLForResolution);
                this.mCurrentPlayURL = playURLForResolution;
                this.mLevel = LiveConfigKey.BACKUP;
                _setStreamFormat();
                this.mRetryProcessor.reset();
                _resetPlayer();
                this.mSessionStartTime = System.currentTimeMillis();
                this.mRedoDns = true;
                parsePlayDNS(playURLForResolution);
                this.mStallCount = 0;
                return true;
            }
        } else if (this.mLevel.equals(LiveConfigKey.BACKUP)) {
            String playURLForResolution2 = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, LiveConfigKey.FLV, LiveConfigKey.MAIN);
            if (playURLForResolution2 != null) {
                updateDownloadSizeStat();
                this.mLogService.onSessionStop();
                this.mIsRetrying = true;
                this.mLogService.onSwitch(this.mCurrentPlayURL, playURLForResolution2, "backup_to_main", i);
                this.mLogService.onSwitchURL(playURLForResolution2);
                this.mCurrentPlayURL = playURLForResolution2;
                this.mLevel = LiveConfigKey.MAIN;
                _setStreamFormat();
                this.mRetryProcessor.reset();
                _resetPlayer();
                this.mSessionStartTime = System.currentTimeMillis();
                this.mRedoDns = true;
                parsePlayDNS(playURLForResolution2);
                this.mStallCount = 0;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bytevc1DegradeH264(int i) throws JSONException, NumberFormatException {
        String str;
        if (this.mURLAbility != 2 || (str = this.mURLSource.getPlayURLByCodec(KsMediaFormat.CODEC_NAME_H264).mainURL) == null) {
            return false;
        }
        updateDownloadSizeStat();
        this.mLogService.onSessionStop();
        this.mIsRetrying = true;
        this.mLogService.onSwitchURL(str);
        this.mLogService.onSwitch(this.mCurrentPlayURL, str, "bytevc1_to_h264", i);
        this.mCurrentPlayURL = str;
        this.mURLAbility = 1;
        this.mLogService.mUrlAbility = KsMediaFormat.CODEC_NAME_H264;
        if (this.mHardwareDecodeEnable != 1 && this.mEnableH264HardwareDecode == 1) {
            this.mHardwareDecodeEnable = 1;
            this.mDefaultCodecId = 0;
            this.mPlayer.setIntOption(59, 1);
            this.mLogService.enableHardDecode(this.mHardwareDecodeEnable == 1);
        }
        _resetPlayer();
        this.mSessionStartTime = System.currentTimeMillis();
        parsePlayDNS(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QuicDegrade(int i) throws JSONException, NumberFormatException {
        String strReplaceAll;
        if (this.mCurrentPlayURL == null) {
            return false;
        }
        if ((!TextUtils.equals(this.mTransportProtocol, LiveConfigKey.QUIC) && !TextUtils.equals(this.mTransportProtocol, LiveConfigKey.QUICU)) || i != -499499) {
            return false;
        }
        if (this.mURLProtocol.equals(LiveConfigKey.TLS)) {
            this.mTransportProtocol = LiveConfigKey.TLS;
            strReplaceAll = this.mCurrentPlayURL.replaceAll("httpq", "https");
        } else if (this.mURLProtocol.equals(LiveConfigKey.KCP)) {
            this.mTransportProtocol = LiveConfigKey.KCP;
            strReplaceAll = this.mCurrentPlayURL.replaceAll("httpq", "httpk");
        } else {
            this.mTransportProtocol = LiveConfigKey.TCP;
            strReplaceAll = this.mCurrentPlayURL.replaceAll("httpq", com.alipay.sdk.m.l.a.r);
        }
        String strReplaceAll2 = strReplaceAll.replaceAll(":(\\d+)/", "/");
        updateDownloadSizeStat();
        this.mLogService.onSessionStop();
        this.mIsRetrying = true;
        if (strReplaceAll2 != null) {
            this.mLogService.onSwitchURL(strReplaceAll2);
            this.mLogService.onSwitch(this.mCurrentPlayURL, strReplaceAll2, "quic_library_load_error", i);
            this.mCurrentPlayURL = strReplaceAll2;
            _stopPlayer();
            _resetPlayer();
            this.mSessionStartTime = System.currentTimeMillis();
            parsePlayDNS(this.mCurrentPlayURL);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HttpKDegradeHttp(int i) throws JSONException, NumberFormatException {
        String strReplaceAll;
        String str = this.mCurrentPlayURL;
        if (str == null || !str.startsWith("httpk") || (strReplaceAll = this.mCurrentPlayURL.replaceAll("httpk", com.alipay.sdk.m.l.a.r).replaceAll(":(\\d+)/", "/")) == null) {
            return false;
        }
        updateDownloadSizeStat();
        this.mLogService.onSessionStop();
        this.mIsRetrying = true;
        this.mLogService.onSwitchURL(strReplaceAll);
        this.mLogService.onSwitch(this.mCurrentPlayURL, strReplaceAll, "httpk_to_http", i);
        this.mCurrentPlayURL = strReplaceAll;
        _stopPlayer();
        _resetPlayer();
        this.mSessionStartTime = System.currentTimeMillis();
        parsePlayDNS(this.mCurrentPlayURL);
        return true;
    }

    private void checkMainLooper(String str) {
        LiveLoggerService liveLoggerService;
        if (this.mIsInMainLooper != 1 || Looper.myLooper() == Looper.getMainLooper() || (liveLoggerService = this.mLogService) == null) {
            return;
        }
        liveLoggerService.onCallNotInMainThread(str);
    }

    private String _addParamToURL(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str4 = str2 + "=" + str3;
        int iIndexOf = str.indexOf("?");
        if (iIndexOf == -1) {
            str4 = "?" + str4;
        } else if (iIndexOf != str.length() - 1) {
            str4 = com.alipay.sdk.m.s.a.n + str4;
        }
        return str + str4;
    }

    private String addSessionIdToURL(String str, long j) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) {
            return null;
        }
        String str2 = this.mUuid + "." + j;
        this.mLogService.mSessionId = str2;
        return !str.contains("_session_id") ? _addParamToURL(str, "_session_id", str2) : str;
    }

    public void onRenderStallForRetryStop() {
        if ((this.mIsStalling || this.mIsRetrying) && this.mEnableRenderStall == 1) {
            if (this.mAudioLastRenderTime != -1) {
                this.mLogService.onRenderStall((int) (System.currentTimeMillis() - this.mAudioLastRenderTime), 0, false, false);
            }
            if (this.mVideoLastRenderTime != -1) {
                this.mLogService.onRenderStall((int) (System.currentTimeMillis() - this.mVideoLastRenderTime), 0, true, false);
            }
        }
    }

    public void getLastRenderTime() {
        if (this.mIsRetrying || this.mIsStalling) {
            return;
        }
        this.mVideoLastRenderTime = this.mPlayer.getLongOption(320, -1L);
        this.mAudioLastRenderTime = this.mPlayer.getLongOption(319, -1L);
    }

    public boolean disableSR(int i, int i2) throws NumberFormatException {
        ArrayList arrayList = new ArrayList();
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            arrayList = (ArrayList) iLiveSettingBundle.getSettingsValueForKey("live_sdk_sr_resolution_block_list", new ArrayList());
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String[] strArrSplit = ((String) it.next()).split("x");
                if (strArrSplit.length < 2) {
                    return false;
                }
                int i3 = Integer.parseInt(strArrSplit[0]);
                int i4 = Integer.parseInt(strArrSplit[1]);
                if (i == i3 && i2 == i4) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadSizeStat() {
        long longOption = this.mPlayer.getLongOption(45, 0L);
        this.mLogService.mLastTotalDownloadSize += longOption;
        long j = this.mLogService.mLastDownloadSizeDelta;
        if (!this.mLogService.mHaveResetPlayer) {
            LiveLoggerService liveLoggerService = this.mLogService;
            liveLoggerService.mLastDownloadSizeDelta = longOption - liveLoggerService.getPlayingDownloadSize();
            this.mLogService.mHaveResetPlayer = true;
        } else {
            this.mLogService.mLastDownloadSizeDelta = longOption + j;
        }
    }

    private void saveCurrentResolution() {
        LiveLoggerService liveLoggerService;
        if (this.mLivePlayerState == LivePlayerState.IDLE || (liveLoggerService = this.mLogService) == null) {
            return;
        }
        liveLoggerService.mLastResolution = this.mResolution.equals("auto") ? this.mLogService.mAutoUsingResolution : this.mResolution;
    }

    private static final class MyPreparedListener implements MediaPlayer.OnPreparedListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyPreparedListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPrepareState != PlayerState.PREPARING || videoLiveManager.mPlayer == null) {
                return;
            }
            PlayerState unused = videoLiveManager.mPrepareState;
            videoLiveManager.mLogService.onPrepareEnd();
            videoLiveManager.mPrepareState = PlayerState.PREPARED;
            if (videoLiveManager.mStartDirectAfterPrepared == 0) {
                videoLiveManager.mPlayer.start();
            }
            videoLiveManager.mListener.onPrepared();
        }
    }

    private static final class MyErrorListener implements MediaPlayer.OnErrorListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyErrorListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            MyLog.e(VideoLiveManager.TAG, "onError ".concat(String.valueOf(i)));
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager != null && videoLiveManager.mPlayer != null) {
                if (i != 0) {
                    videoLiveManager.mLogService.onPrepare(i);
                }
                videoLiveManager.mListener.onError(new LiveError(i, "player on error", null));
                if (videoLiveManager.mIsLocalURL) {
                    return true;
                }
                if (videoLiveManager.mEnableQuicDegrade == 1 && videoLiveManager.QuicDegrade(i)) {
                    return true;
                }
                if (videoLiveManager.mEnableHttpkDegrade == 1 && videoLiveManager.HttpKDegradeHttp(i)) {
                    return true;
                }
                if (!(videoLiveManager.mEnableRtcPlay == 1 && videoLiveManager.mRtcPlayFallBack == 0) && videoLiveManager.mEnableSwitchMainAndBackupUrl && videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.switchMainAndBackupUrl(i)) {
                    return true;
                }
                if (videoLiveManager.mURLSource.getSourceType() == 1 && videoLiveManager.bytevc1DegradeH264(i)) {
                    return true;
                }
                HashMap map = new HashMap();
                map.put("internalCode", Integer.valueOf(i));
                map.put("internalExtra", Integer.valueOf(i2));
                map.put("playerType", Integer.valueOf(mediaPlayer.getPlayerType()));
                videoLiveManager.mRetryProcessor.onError(new LiveError(-100003, "player on error", map), videoLiveManager.mShowedFirstFrame);
            }
            return false;
        }
    }

    private static final class MyInfoListener implements MediaPlayer.OnInfoListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyInfoListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:123:0x04a6  */
        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnInfoListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onInfo(com.bykv.vk.component.ttvideo.player.MediaPlayer r19, int r20, int r21) {
            /*
                Method dump skipped, instructions count: 1680
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager.MyInfoListener.onInfo(com.bykv.vk.component.ttvideo.player.MediaPlayer, int, int):boolean");
        }
    }

    private static final class MyCompletionListener implements MediaPlayer.OnCompletionListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyCompletionListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) throws JSONException, NumberFormatException {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            MyLog.i(VideoLiveManager.TAG, "onCompletion");
            videoLiveManager.mListener.onCompletion();
            videoLiveManager.mLogService.onPrepare(LiveError.STREAM_DRYUP);
            videoLiveManager.mSupportBackupIp = false;
            if (videoLiveManager.mIsLocalURL) {
                return;
            }
            if (videoLiveManager.mEnableSwitchMainAndBackupUrl && videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.switchMainAndBackupUrl(LiveError.STREAM_DRYUP)) {
                return;
            }
            if (videoLiveManager.mURLSource.getSourceType() == 1 && videoLiveManager.bytevc1DegradeH264(LiveError.STREAM_DRYUP)) {
                return;
            }
            if (videoLiveManager.mCacheFileEnable == 1) {
                videoLiveManager.mListener.onCacheFileCompletion();
                videoLiveManager.mIsCacheHasComplete = true;
                if (!videoLiveManager.mLooping || TextUtils.isEmpty(videoLiveManager.mCacheFilePath)) {
                    return;
                }
                videoLiveManager.setLocalURL(videoLiveManager.mCacheFilePath);
                videoLiveManager.setLooping(true);
                videoLiveManager.parsePlayDNS(videoLiveManager.mCacheFilePath);
                return;
            }
            videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.STREAM_DRYUP, "live stream dry up, push stream may occur error", new HashMap()), videoLiveManager.mShowedFirstFrame);
        }
    }

    private static class MyOnVideoSizeChangedListener implements MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyOnVideoSizeChangedListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            MyLog.i(VideoLiveManager.TAG, "onVideoSizeChanged, width: " + i + ", height: " + i2);
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null || videoLiveManager.mListener == null) {
                return;
            }
            videoLiveManager.mListener.onVideoSizeChanged(i, i2);
            videoLiveManager.mLogService.onVideoSizeChanged(i, i2);
        }
    }

    private static final class MyRetryListener implements RetryProcessor.RetryListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyRetryListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRetryResetPlayer(boolean z) throws JSONException, NumberFormatException {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.updateDownloadSizeStat();
            videoLiveManager.mLogService.onSessionStop();
            videoLiveManager.getLastRenderTime();
            videoLiveManager.mIsRetrying = true;
            MyLog.i(VideoLiveManager.TAG, "onRetryResetPlayer ".concat(String.valueOf(z)));
            if (!videoLiveManager.mHasRetry) {
                videoLiveManager.mHasRetry = true;
                videoLiveManager.mLogService.setWaitTime(videoLiveManager.mPlayer.getLongOption(314, 0L));
            }
            videoLiveManager._stopPlayer();
            String playURLForResolution = null;
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                if (videoLiveManager.mURLSource.getPlayLiveURL() != null) {
                    playURLForResolution = videoLiveManager.mURLSource.getPlayLiveURL().mainURL;
                }
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                playURLForResolution = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            }
            MyLog.i(VideoLiveManager.TAG, "retry url: ".concat(String.valueOf(playURLForResolution)));
            videoLiveManager.mLogService.onSwitchURL(playURLForResolution);
            boolean z2 = false;
            if (videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && videoLiveManager.mResolution.equals("auto")) {
                z2 = true;
            }
            videoLiveManager.mRetryStartTime = System.currentTimeMillis();
            videoLiveManager.mLogService.mSessionStartTime = System.currentTimeMillis();
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                if (videoLiveManager.mEnableAbrStallDegradeImmediately == 1 || !z2 || (z2 && !videoLiveManager.abrDegradeResolution())) {
                    videoLiveManager.parsePlayDNS(playURLForResolution);
                    return;
                }
                return;
            }
            videoLiveManager._resetPlayer();
            if (videoLiveManager.mEnableAbrStallDegradeImmediately == 1 || !z2 || (z2 && !videoLiveManager.abrDegradeResolution())) {
                videoLiveManager.parsePlayDNS(playURLForResolution);
            }
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRetryNextPlayURL() throws JSONException, NumberFormatException {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            MyLog.i(VideoLiveManager.TAG, "onRetryNextPlayURL");
            videoLiveManager.updateDownloadSizeStat();
            videoLiveManager.mLogService.onSessionStop();
            videoLiveManager.mIsRetrying = true;
            String playURLForResolution = null;
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                playURLForResolution = videoLiveManager.mURLSource.getNextURL();
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                playURLForResolution = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            }
            videoLiveManager.mLogService.onSwitchURL(playURLForResolution);
            if (!videoLiveManager.mHasRetry) {
                videoLiveManager.mHasRetry = true;
                videoLiveManager.mLogService.setWaitTime(videoLiveManager.mPlayer.getLongOption(314, 0L));
            }
            videoLiveManager._stopPlayer();
            videoLiveManager.mLogService.mSessionStartTime = System.currentTimeMillis();
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                videoLiveManager.parsePlayDNS(playURLForResolution);
            } else {
                videoLiveManager._resetPlayer();
                videoLiveManager.parsePlayDNS(playURLForResolution);
            }
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onReportOutToApplication(LiveError liveError) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            MyLog.i(VideoLiveManager.TAG, "onReportOutToApplication");
            videoLiveManager.mListener.onError(liveError);
            videoLiveManager.mFetcher.cancel();
            videoLiveManager.mRetryProcessor.reset();
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRTCFallBack() throws JSONException, NumberFormatException {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mIsRetrying = true;
            MyLog.i(VideoLiveManager.TAG, "onRTCFallBack");
            videoLiveManager._stopPlayer();
            if (videoLiveManager.mCurrentRetryCount < videoLiveManager.mRtcMaxRetryCount) {
                videoLiveManager.mCurrentRetryCount++;
            } else {
                videoLiveManager.mRtcPlayFallBack = 1;
                videoLiveManager.mLogService.mRtcPlayFallBack = 1;
                videoLiveManager.mURLSource.setRtcFallback(1);
                if (!videoLiveManager.mShowedFirstFrame) {
                    if (videoLiveManager.mRtcSupportMiniSdp == 1) {
                        videoLiveManager.mRtcSupportMiniSdp = 0;
                        videoLiveManager.mLogService.mEnableMiniSdp = 0;
                    }
                    videoLiveManager.mLogService.mFallbackType = 1;
                } else {
                    videoLiveManager.mLogService.mFallbackType = 2;
                }
            }
            String playURLForResolution = null;
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                playURLForResolution = videoLiveManager.mURLSource.getNextURL();
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                playURLForResolution = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            }
            MyLog.i(VideoLiveManager.TAG, "onRTCFallBack url: " + playURLForResolution + ",mCurrentRetryCount:" + videoLiveManager.mCurrentRetryCount);
            videoLiveManager.mLogService.onSwitchURL(playURLForResolution);
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                videoLiveManager.parsePlayDNS(playURLForResolution);
            } else {
                videoLiveManager._resetPlayer();
                videoLiveManager.parsePlayDNS(playURLForResolution);
            }
        }
    }

    private static final class MyMediaLoaderListener implements MediaLoaderListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onLogInfo(int i, String str, JSONObject jSONObject) {
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onNotify(int i, long j, long j2, String str) {
        }

        public MyMediaLoaderListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onDataLoaderError(int i, String str) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mLogService.onLoaderError(i, str);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onSwitchLoaderType(int i, String str) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mLogService.onLoaderSwitch(i, str);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public long getInt64Value(int i, long j) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            return (videoLiveManager == null || videoLiveManager.mPlayer == null || i != 0) ? j : videoLiveManager.mLogService.getInt64Value(i, j);
        }
    }

    private static final class MyFetcherCompletionListener implements LiveDataFetcher.OnCompletionListener {
        private final String mLiveInfoAPI;
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyFetcherCompletionListener(VideoLiveManager videoLiveManager, String str) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
            this.mLiveInfoAPI = str;
        }

        @Override // com.bykv.vk.component.ttvideo.network.LiveDataFetcher.OnCompletionListener
        public void onCompletion(final LiveStreamInfo liveStreamInfo) {
            final VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThread(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.MyFetcherCompletionListener.1
                @Override // java.lang.Runnable
                public void run() throws JSONException, NumberFormatException {
                    if (videoLiveManager.mPlayer == null || videoLiveManager.mRetryProcessor == null) {
                        return;
                    }
                    if (liveStreamInfo != null) {
                        videoLiveManager.mURLSource.setStreamInfo(liveStreamInfo);
                        String playURLForResolution = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
                        if (playURLForResolution != null) {
                            videoLiveManager.parsePlayDNS(playURLForResolution);
                            return;
                        }
                        HashMap map = new HashMap();
                        map.put("liveAPI", MyFetcherCompletionListener.this.mLiveInfoAPI);
                        videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.LIVE_DATA_EMPTY, "play url is null", map), videoLiveManager.mShowedFirstFrame);
                        return;
                    }
                    HashMap map2 = new HashMap();
                    map2.put("liveAPI", MyFetcherCompletionListener.this.mLiveInfoAPI);
                    videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.LIVE_DATA_EMPTY, "live data is null", map2), videoLiveManager.mShowedFirstFrame);
                }
            });
        }

        @Override // com.bykv.vk.component.ttvideo.network.LiveDataFetcher.OnCompletionListener
        public void onError(final LiveError liveError) {
            final VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThread(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.MyFetcherCompletionListener.2
                @Override // java.lang.Runnable
                public void run() {
                    if (videoLiveManager.mPlayer == null || videoLiveManager.mRetryProcessor == null) {
                        return;
                    }
                    videoLiveManager.mRetryProcessor.onError(liveError, videoLiveManager.mShowedFirstFrame);
                }
            });
        }
    }

    private class PlayCacheSyncRunner implements Runnable {
        static final long CacheThreadshold = 5000;
        static final long LongDelay = 500;
        static final long ShortDelay = 300;
        boolean mIsLiveIO;
        String mMdlTaskSessionId;
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public PlayCacheSyncRunner(VideoLiveManager videoLiveManager, String str, boolean z) {
            this.mIsLiveIO = false;
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
            this.mMdlTaskSessionId = str;
            this.mIsLiveIO = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || (str = this.mMdlTaskSessionId) == null || !str.equals(videoLiveManager.mSessionId) || this.mMdlTaskSessionId.isEmpty()) {
                return;
            }
            if (videoLiveManager.mLivePlayerState != LivePlayerState.PLAYED) {
                nextround(LongDelay);
                return;
            }
            long playCache = getPlayCache();
            if (playCache == -1) {
                nextround(LongDelay);
                return;
            }
            if (!this.mIsLiveIO) {
                MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(7215, videoLiveManager.mSessionId, (int) playCache);
            }
            String unused = videoLiveManager.mSessionId;
            if (playCache > 5000) {
                nextround(LongDelay);
            } else {
                nextround(ShortDelay);
            }
        }

        private long getPlayCache() {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return -1L;
            }
            long longOption = videoLiveManager.mPlayer.getLongOption(73, -1L);
            long longOption2 = videoLiveManager.mPlayer.getLongOption(72, -1L);
            if (longOption >= 0 && longOption2 >= 0) {
                return Math.min(longOption, longOption2);
            }
            if (longOption >= 0) {
                return longOption;
            }
            if (longOption2 >= 0) {
                return longOption2;
            }
            return -1L;
        }

        private void nextround(long j) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThreadDelay(VideoLiveManager.this.new PlayCacheSyncRunner(videoLiveManager, this.mMdlTaskSessionId, this.mIsLiveIO), j);
        }
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    public static final class Builder {
        final Context mContext;
        boolean mEnableResolutionAutoDegrade;
        boolean mEnableSwitchMainAndBackupUrl;
        boolean mForceHttpDns;
        boolean mForceTTNetHttpDns;
        ILiveListener mListener;
        public ExecutorService mLiveThreadPool;
        INetworkClient mNetworkClient;
        int mPlayerType;
        String mProjectKey;
        public long mRTCUploadLogInterval;
        String mResolution;
        int mRetryTimeout;
        public long mSeiCheckTimeOut;
        ILiveSettingBundle mSettingsBundle;
        public long mStallRetryTimeInterval;
        public long mUploadLogInterval;
        String mVideoFormat;

        private Builder(Context context) {
            this.mForceHttpDns = false;
            this.mForceTTNetHttpDns = false;
            this.mRetryTimeout = 60000;
            this.mPlayerType = 1;
            this.mResolution = LiveConfigKey.ORIGIN;
            this.mVideoFormat = LiveConfigKey.FLV;
            this.mEnableResolutionAutoDegrade = false;
            this.mEnableSwitchMainAndBackupUrl = true;
            this.mStallRetryTimeInterval = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.mUploadLogInterval = 60000L;
            this.mRTCUploadLogInterval = 5000L;
            this.mSeiCheckTimeOut = 8000L;
            this.mLiveThreadPool = null;
            this.mContext = context;
        }

        public Builder setListener(ILiveListener iLiveListener) {
            this.mListener = iLiveListener;
            return this;
        }

        public Builder setPlayerType(int i) {
            this.mPlayerType = i;
            return this;
        }

        public Builder setProjectKey(String str) {
            this.mProjectKey = str;
            return this;
        }

        public Builder setNetworkClient(INetworkClient iNetworkClient) {
            this.mNetworkClient = iNetworkClient;
            return this;
        }

        public Builder setForceHttpDns(boolean z) {
            this.mForceHttpDns = z;
            return this;
        }

        public Builder setForceTTNetHttpDns(boolean z) {
            this.mForceTTNetHttpDns = z;
            return this;
        }

        public Builder setRetryTimeout(int i) {
            this.mRetryTimeout = i;
            return this;
        }

        public Builder setStallRetryInterval(long j) {
            this.mStallRetryTimeInterval = j;
            return this;
        }

        public Builder setResolution(String str) {
            this.mResolution = str;
            return this;
        }

        public Builder setVideoFormat(String str) {
            this.mVideoFormat = str;
            return this;
        }

        public Builder setEnableResolutionAutoDegrade(boolean z) {
            this.mEnableResolutionAutoDegrade = z;
            return this;
        }

        public Builder setEnableSwitchMainAndBackUpURL(boolean z) {
            this.mEnableSwitchMainAndBackupUrl = z;
            return this;
        }

        public Builder setSeiCheckTimeOut(long j) {
            this.mSeiCheckTimeOut = j;
            return this;
        }

        public Builder setSettingsBundle(ILiveSettingBundle iLiveSettingBundle) {
            this.mSettingsBundle = iLiveSettingBundle;
            return this;
        }

        public Builder setCustomThreadPool(ExecutorService executorService) {
            MyLog.i(VideoLiveManager.TAG, "setCustomThreadPool: ".concat(String.valueOf(executorService)));
            this.mLiveThreadPool = executorService;
            return this;
        }

        public VideoLiveManager build() {
            if (this.mContext == null) {
                throw new IllegalArgumentException("mContext should not be null");
            }
            if (this.mListener == null) {
                throw new IllegalArgumentException("mListener should not be null");
            }
            if (this.mNetworkClient == null) {
                throw new IllegalArgumentException("mNetworkClient should not be null");
            }
            return new VideoLiveManager(this);
        }
    }

    public static void setSettingsParam(Context context, Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap map2 = (HashMap) map;
        map2.put("live_pull_sdk_version", Integer.valueOf(LiveUtils.versionStringToInt("1.4.6.31-lite")));
        map2.put("ttm_version", Integer.valueOf(LiveUtils.versionStringToInt(TTPlayerConfiger.getValue(14, ""))));
    }

    public static void setAppInfo(Context context, Map map) {
        if (map == null || map.size() == 0) {
            return;
        }
        AppInfo.mContext = context;
        AppInfo.mAppName = (String) map.get("app_name");
        Object obj = map.get(com.alipay.sdk.m.k.b.D0);
        Integer num = (Integer) obj;
        MyLog.i(TAG, "set appid:" + num);
        if (obj != null) {
            AppInfo.mAppID = num.intValue();
            MyLog.i(TAG, "set appid:" + AppInfo.mAppID);
        }
        AppInfo.mAppChannel = (String) map.get("app_channel");
        AppInfo.mAppVersion = (String) map.get("app_version");
        AppInfo.mDeviceId = (String) map.get(com.baidu.mobads.upgrade.remote.gray.c.l);
    }

    public static void setDataLoaderListener(MediaLoaderListener mediaLoaderListener) {
        MediaLoaderWrapper.getDataLoader().setListener(mediaLoaderListener);
    }

    public static void startDataLoader(Context context) throws Exception {
        try {
            MediaLoaderWrapper.getDataLoader().start();
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean dataLoaderIsRunning() {
        return MediaLoaderWrapper.getDataLoader().isRunning();
    }

    public static void closeDataLoader() {
        MediaLoaderWrapper.getDataLoader().close();
    }

    public static void setIntValue(int i, int i2) {
        MediaLoaderWrapper.getDataLoader().setIntValue(i, i2);
    }

    public static void enableLoadLibrary() {
        MediaLoaderWrapper.getDataLoader().enableLoadLibrary();
    }

    private static class MyReleaseRunnable implements Runnable {
        private MediaPlayer mPlayer;

        public MyReleaseRunnable(MediaPlayer mediaPlayer) {
            this.mPlayer = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mPlayer != null) {
                try {
                    MyLog.i(VideoLiveManager.TAG, "MyReleaseRunnable release");
                    this.mPlayer.release();
                    this.mPlayer = null;
                } catch (Exception e) {
                    MyLog.i(VideoLiveManager.TAG, e.toString());
                }
            }
        }
    }

    public void updateFrameTerminatedDTS(int i, long j, long j2) {
        this.mFrameTerminatedDTS = j;
    }

    public void frameDTSNotify(int i, long j, long j2) {
        if (this.mEnableCheckFrame == 1 && i == 0 && this.mResolution.equals(LiveConfigKey.ORIGIN)) {
            this.mLogService.feedVideoDTS(j);
        }
        if (i == 1 && this.mEnableDTSCheck == 1) {
            if (this.mLogService.mFirstAudioPacketDTS < 0) {
                this.mLogService.mFirstAudioPacketDTS = j;
            } else {
                long j3 = this.mLatestAudioPacketDTS;
                if (j < j3) {
                    this.mLogService.onAudioDTSRollback(j3, j);
                }
            }
            this.mLatestAudioPacketDTS = j;
        }
    }

    public JSONObject liveInfoItems() throws JSONException {
        try {
            JSONObject liveInfoItems = this.mLogService.getLiveInfoItems();
            liveInfoItems.put("get_live_info_iterms", ca.k);
            return liveInfoItems;
        } catch (JSONException e) {
            mq.d(e);
            return null;
        }
    }

    private class VideoStallCountTask implements Runnable {
        private VideoStallCountTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (VideoLiveManager.this.mStallCounterLock) {
                if (VideoLiveManager.this.mStallCounterIsRunning && VideoLiveManager.this.mPlayer != null) {
                    long jUptimeMillis = SystemClock.uptimeMillis() + VideoLiveManager.this.mStallCounterInterval;
                    long longOption = VideoLiveManager.this.mPlayer.getLongOption(381, 0L);
                    long longOption2 = VideoLiveManager.this.mPlayer.getLongOption(382, 0L);
                    long longOption3 = VideoLiveManager.this.mPlayer.getLongOption(383, 0L);
                    long longOption4 = VideoLiveManager.this.mPlayer.getLongOption(384, 0L);
                    long longOption5 = VideoLiveManager.this.mPlayer.getLongOption(385, 0L);
                    long longOption6 = VideoLiveManager.this.mPlayer.getLongOption(386, 0L);
                    long longOption7 = VideoLiveManager.this.mPlayer.getLongOption(387, 0L);
                    if ((longOption != 0 || longOption2 != 0 || longOption3 != 0 || longOption4 != 0 || longOption5 != 0 || longOption6 != 0 || longOption7 != 0) && VideoLiveManager.this.mLogService != null) {
                        VideoLiveManager.this.mLogService.onVideoStallCounter(longOption, longOption2, longOption3, longOption4, longOption5, longOption6, longOption7);
                    }
                    if (VideoLiveManager.this.mStallCounterHandler != null) {
                        VideoLiveManager.this.mStallCounterHandler.postAtTime(this, jUptimeMillis);
                    }
                }
            }
        }
    }

    public boolean isRtcPlayAvailable() {
        return this.mEnableRtcPlay == 1 && this.mRtcPlayFallBack == 0;
    }
}
