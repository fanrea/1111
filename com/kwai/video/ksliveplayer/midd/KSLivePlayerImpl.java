package com.kwai.video.ksliveplayer.midd;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.player.KwaiPlayerConfig;
import com.kwai.player.debuginfo.model.KwaiPlayerDebugInfo;
import com.kwai.video.ksliveplayer.KSCoreLivePlayer;
import com.kwai.video.ksliveplayer.KSCoreLivePlayerBuilder;
import com.kwai.video.ksliveplayer.KSLiveManifest;
import com.kwai.video.ksliveplayer.KSLivePlayer;
import com.kwai.video.ksliveplayer.KSLivePlayerBuilder;
import com.kwai.video.ksliveplayer.LiveTextureView;
import com.kwai.video.ksliveplayer.impl.KSLiveDataSourceType;
import com.kwai.video.ksliveplayer.model.KSLivePlayerConfigModel;
import com.kwai.video.ksliveplayer.model.KSLivePlayerConfigModel_JsonUtils;
import com.kwai.video.ksliveplayer.model.LiveRetryConfigModel;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder;
import com.kwai.video.player.kwai_player.KwaiPlayerLiveBuilder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLivePlayerImpl implements TextureView.SurfaceTextureListener, KSLivePlayer {
    public static final String TAG = "KSLivePlayer";
    private Context mContext;
    private KSCoreLivePlayer mCoreLivePlayer;
    private String mCurrentDataSource;
    private String mCurrentManifestContainerStr;
    private List<String> mCurrentMultiPlayUrls;
    private KSLiveDataSourceType mDataSourceType;
    private KSLivePlayer.OnLiveDataListener mLiveDataListener;
    private KSLivePlayer.OnErrorListener mLiveOnErrorListener;
    private KSLivePlayer.OnEventListener mLiveOnEventListener;
    private KSLivePlayer.OnPreparedListener mLiveOnPreparedListener;
    private KSLivePlayerConfigModel mLivePlayerConfig;
    private LiveTextureView mLiveTextureView;
    private KSLivePlayer.OnLiveVoiceCommentListener mOnLiveVoiceCommentListener;
    private KSLivePlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private int mVideoHeight;
    private int mVideoWidth;
    private final String KEY_KIT_NAME = "ksliveplayer";
    private final String KEY_CONFIG = "config";
    private Object mLock = new Object();
    private IMediaPlayer.OnPreparedListener mKwaiOnPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: com.kwai.video.ksliveplayer.midd.KSLivePlayerImpl.1
        @Override // com.kwai.video.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            if (KSLivePlayerImpl.this.mLiveOnPreparedListener != null) {
                KSLivePlayerImpl.this.mLiveOnPreparedListener.onPrepared();
            }
        }
    };
    private IMediaPlayer.OnErrorListener mKwaiOnErrorListener = new IMediaPlayer.OnErrorListener() { // from class: com.kwai.video.ksliveplayer.midd.KSLivePlayerImpl.2
        @Override // com.kwai.video.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (KSLivePlayerImpl.this.mLiveOnErrorListener == null) {
                return false;
            }
            KSLivePlayerImpl.this.mLiveOnErrorListener.onError(i, i2);
            return false;
        }
    };
    private IMediaPlayer.OnLiveEventListener mKwaiOnLiveEventListener = new IMediaPlayer.OnLiveEventListener() { // from class: com.kwai.video.ksliveplayer.midd.KSLivePlayerImpl.3
        @Override // com.kwai.video.player.IMediaPlayer.OnLiveEventListener
        public void onLiveEventChange(byte[] bArr) {
            if (KSLivePlayerImpl.this.mLiveDataListener != null) {
                KSLivePlayerImpl.this.mLiveDataListener.onLiveData(bArr);
            }
        }
    };
    private IMediaPlayer.OnVideoSizeChangedListener mKwaiOnVideoSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.kwai.video.ksliveplayer.midd.KSLivePlayerImpl.4
        @Override // com.kwai.video.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            KSLivePlayerImpl.this.mVideoWidth = i;
            KSLivePlayerImpl.this.mVideoHeight = i2;
            if (KSLivePlayerImpl.this.mLiveTextureView != null) {
                KSLivePlayerImpl.this.mLiveTextureView.setVideoSize(i, i2);
            }
            if (KSLivePlayerImpl.this.mOnVideoSizeChangedListener != null) {
                KSLivePlayerImpl.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i, i2);
            }
        }
    };
    private IMediaPlayer.OnLiveVoiceCommentListener mKwaiOnLiveVoiceCommentListener = new IMediaPlayer.OnLiveVoiceCommentListener() { // from class: com.kwai.video.ksliveplayer.midd.KSLivePlayerImpl.5
        @Override // com.kwai.video.player.IMediaPlayer.OnLiveVoiceCommentListener
        public void onLiveVoiceCommentChange(IMediaPlayer iMediaPlayer, String str) {
            if (KSLivePlayerImpl.this.mOnLiveVoiceCommentListener != null) {
                KSLivePlayerImpl.this.mOnLiveVoiceCommentListener.onLiveVoiceComment(str);
            }
        }
    };
    private IMediaPlayer.OnInfoListener mKwaiOnInfoListener = new IMediaPlayer.OnInfoListener() { // from class: com.kwai.video.ksliveplayer.midd.KSLivePlayerImpl.6
        @Override // com.kwai.video.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            int i3;
            if (i != 3) {
                i3 = i != 10002 ? i != 10102 ? i != 701 ? i != 702 ? -1 : 103 : 102 : 104 : 101;
            } else {
                i3 = 100;
                if (KSLivePlayerImpl.this.mLiveTextureView != null) {
                    KSLivePlayerImpl.this.mLiveTextureView.setVideoSize(KSLivePlayerImpl.this.mVideoWidth, KSLivePlayerImpl.this.mVideoHeight);
                }
            }
            if (KSLivePlayerImpl.this.mLiveOnEventListener == null || i3 <= 0) {
                return false;
            }
            KSLivePlayerImpl.this.mLiveOnEventListener.onEvent(i3, i2);
            return false;
        }
    };
    private IMediaPlayer.OnQosStatListener mKwaiQosListener = new IMediaPlayer.OnQosStatListener() { // from class: com.kwai.video.ksliveplayer.midd.KSLivePlayerImpl.7
        @Override // com.kwai.video.player.IMediaPlayer.OnQosStatListener
        public void onQosStat(IMediaPlayer iMediaPlayer, JSONObject jSONObject) {
        }
    };
    private IMediaPlayer.OnLiveAdaptiveQosStatListener mOnLiveAdaptiveQosStatListener = new IMediaPlayer.OnLiveAdaptiveQosStatListener() { // from class: com.kwai.video.ksliveplayer.midd.KSLivePlayerImpl.8
        @Override // com.kwai.video.player.IMediaPlayer.OnLiveAdaptiveQosStatListener
        public void onLiveAdaptiveQosStat(IMediaPlayer iMediaPlayer, JSONObject jSONObject) {
        }
    };

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public KSLivePlayerImpl(KSLivePlayerBuilder kSLivePlayerBuilder) {
        List<String> list;
        this.mContext = kSLivePlayerBuilder.mContext;
        this.mCurrentDataSource = kSLivePlayerBuilder.mDataSource;
        this.mCurrentManifestContainerStr = kSLivePlayerBuilder.mDataManifest;
        if (this.mContext == null || (TextUtils.isEmpty(this.mCurrentManifestContainerStr) && TextUtils.isEmpty(this.mCurrentDataSource) && ((list = this.mCurrentMultiPlayUrls) == null || list.isEmpty()))) {
            throw new IllegalArgumentException("Wrong Input Arguments! Context and play url can't be null!");
        }
        if (kSLivePlayerBuilder.mMultiPlayUrls != null && !kSLivePlayerBuilder.mMultiPlayUrls.isEmpty()) {
            this.mCurrentMultiPlayUrls = kSLivePlayerBuilder.mMultiPlayUrls;
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
        initLivePlayerConfig();
        this.mCoreLivePlayer = createCoreLivePlayer(kSLivePlayerBuilder);
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void setOnPreparedListener(KSLivePlayer.OnPreparedListener onPreparedListener) {
        this.mLiveOnPreparedListener = onPreparedListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void setOnEventListener(KSLivePlayer.OnEventListener onEventListener) {
        this.mLiveOnEventListener = onEventListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void setOnErrorListener(KSLivePlayer.OnErrorListener onErrorListener) {
        this.mLiveOnErrorListener = onErrorListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void setOnLiveDataListener(KSLivePlayer.OnLiveDataListener onLiveDataListener) {
        this.mLiveDataListener = onLiveDataListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void setOnVideoSizeChangedListener(KSLivePlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void setOnLiveVoiceCommentListener(KSLivePlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener) {
        this.mOnLiveVoiceCommentListener = onLiveVoiceCommentListener;
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void setLiveAdaptiveSwitchIndex(int i) {
        KSCoreLivePlayer kSCoreLivePlayer;
        if (TextUtils.isEmpty(this.mCurrentManifestContainerStr) || (kSCoreLivePlayer = this.mCoreLivePlayer) == null) {
            return;
        }
        kSCoreLivePlayer.setLiveAdaptiveSwitchIndex(i);
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public int getCurrentLiveAdaptiveIndex() {
        KSCoreLivePlayer kSCoreLivePlayer = this.mCoreLivePlayer;
        if (kSCoreLivePlayer != null) {
            return kSCoreLivePlayer.getCurrentLiveAdaptiveIndex();
        }
        return -1;
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void refreshDataSource(String str) {
        KSCoreLivePlayer kSCoreLivePlayer;
        if (str == null || (kSCoreLivePlayer = this.mCoreLivePlayer) == null) {
            return;
        }
        kSCoreLivePlayer.refreshDataSource(str, true);
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void refreshDataManifest(String str) {
        KSCoreLivePlayer kSCoreLivePlayer;
        if (str == null || (kSCoreLivePlayer = this.mCoreLivePlayer) == null) {
            return;
        }
        kSCoreLivePlayer.refreshDataManifest(str, true);
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void prepareAsync() {
        synchronized (this.mLock) {
            if (this.mCoreLivePlayer != null) {
                this.mCoreLivePlayer.prepareAsync();
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void setSurface(Surface surface) {
        synchronized (this.mLock) {
            this.mSurface = surface;
            if (this.mCoreLivePlayer != null) {
                this.mCoreLivePlayer.setSurface(this.mSurface);
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void setLiveTextureView(LiveTextureView liveTextureView) {
        this.mLiveTextureView = liveTextureView;
        LiveTextureView liveTextureView2 = this.mLiveTextureView;
        if (liveTextureView2 == null) {
            return;
        }
        liveTextureView2.setSurfaceTextureListener(this);
        this.mSurfaceTexture = this.mLiveTextureView.getSurfaceTexture();
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null || this.mCoreLivePlayer == null) {
            return;
        }
        this.mSurface = new Surface(surfaceTexture);
        this.mCoreLivePlayer.setSurface(this.mSurface);
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void setVideoScaleMode(int i) {
        LiveTextureView liveTextureView = this.mLiveTextureView;
        if (liveTextureView != null) {
            liveTextureView.setVideoScalingMode(i);
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public boolean isPlaying() {
        synchronized (this.mLock) {
            if (this.mCoreLivePlayer == null) {
                return false;
            }
            return this.mCoreLivePlayer.isPlaying();
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public KSLiveManifest getLiveManifestDetail() {
        KSCoreLivePlayer kSCoreLivePlayer = this.mCoreLivePlayer;
        if (kSCoreLivePlayer == null) {
            return null;
        }
        kSCoreLivePlayer.getLiveManifestDetail();
        return null;
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void setVolume(float f, float f2) {
        synchronized (this.mLock) {
            if (this.mCoreLivePlayer != null) {
                this.mCoreLivePlayer.setVolume(f, f2);
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void start() {
        synchronized (this.mLock) {
            if (this.mCoreLivePlayer != null) {
                this.mCoreLivePlayer.start();
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void release() {
        synchronized (this.mLock) {
            if (this.mCoreLivePlayer != null) {
                this.mCoreLivePlayer.release();
                this.mCoreLivePlayer = null;
            }
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSLivePlayer
    public void releaseAsync() {
        synchronized (this.mLock) {
            if (this.mCoreLivePlayer != null) {
                this.mCoreLivePlayer.releaseAsync();
                this.mCoreLivePlayer = null;
            }
        }
    }

    private void initLivePlayerConfig() {
        String config = Azeroth.get().getConfigManager().getConfig("ksliveplayer");
        if (TextUtils.isEmpty(config)) {
            this.mLivePlayerConfig = new KSLivePlayerConfigModel();
            return;
        }
        try {
            this.mLivePlayerConfig = KSLivePlayerConfigModel_JsonUtils.fromJson(new JSONObject(config).getString("config"));
            if (this.mLivePlayerConfig.liveRetryConfig == null) {
                this.mLivePlayerConfig.liveRetryConfig = new LiveRetryConfigModel();
            }
        } catch (JSONException unused) {
            this.mLivePlayerConfig = new KSLivePlayerConfigModel();
        }
    }

    private KSCoreLivePlayer createCoreLivePlayer(KSLivePlayerBuilder kSLivePlayerBuilder) {
        KSCoreLivePlayerBuilder kSCoreLivePlayerBuilder = new KSCoreLivePlayerBuilder(this.mContext);
        KwaiPlayerLiveBuilder kwaiPlayerLiveBuilder = new KwaiPlayerLiveBuilder(this.mContext);
        KwaiPlayerConfig.Builder builder = new KwaiPlayerConfig.Builder();
        kwaiPlayerLiveBuilder.setBufferTimeMaxSec(this.mLivePlayerConfig.bufferTimeMaxSec);
        kwaiPlayerLiveBuilder.setConfigJson(this.mLivePlayerConfig.configJson);
        kwaiPlayerLiveBuilder.setAsyncStreamOpen(this.mLivePlayerConfig.enableAsyncStreamOpen());
        kwaiPlayerLiveBuilder.setUseAlignedPts(this.mLivePlayerConfig.enableAlignedPts);
        int i = AnonymousClass9.$SwitchMap$com$kwai$video$ksliveplayer$impl$KSLiveDataSourceType[this.mDataSourceType.ordinal()];
        if (i == 1) {
            kSCoreLivePlayerBuilder.setDataManifest(this.mCurrentManifestContainerStr, kSLivePlayerBuilder.mLiveManifestConfig);
            kwaiPlayerLiveBuilder.setIsLiveManifest(true);
            builder.setMaxBufferDuration(10000);
        } else if (i == 2) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mCurrentDataSource);
            kSCoreLivePlayerBuilder.setMultiPlayUrls(arrayList);
        } else if (i == 3) {
            kSCoreLivePlayerBuilder.setMultiPlayUrls(this.mCurrentMultiPlayUrls);
        }
        builder.setQosDuration(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        builder.setEnableQos(true);
        builder.setMaxBufferTime(4000);
        kwaiPlayerLiveBuilder.setKwaiPlayerConfig(builder.build());
        kwaiPlayerLiveBuilder.setUseNatvieCache(true);
        kwaiPlayerLiveBuilder.setHevcDcoderName(KwaiPlayerBaseBuilder.HEVC_DECODER_NAME_KS265);
        kSCoreLivePlayerBuilder.mEnableUseLastSelectQualityType = kSLivePlayerBuilder.mEnableUseLastSelectQualityType;
        KSCoreLivePlayer kSCoreLivePlayerBuild = kSCoreLivePlayerBuilder.setKwaiLiveBuilder(kwaiPlayerLiveBuilder).setLiveVideoContext(kSLivePlayerBuilder.mLiveVideoContext).setLivePlayConfig(this.mLivePlayerConfig).build();
        kSCoreLivePlayerBuild.setOnPreparedListener(this.mKwaiOnPreparedListener);
        kSCoreLivePlayerBuild.setOnErrorListener(this.mKwaiOnErrorListener);
        kSCoreLivePlayerBuild.setOnVideoSizeChangedListener(this.mKwaiOnVideoSizeChangedListener);
        kSCoreLivePlayerBuild.setOnQosStatListener(this.mKwaiQosListener);
        kSCoreLivePlayerBuild.setOnLiveVoiceCommentListener(this.mKwaiOnLiveVoiceCommentListener);
        kSCoreLivePlayerBuild.setOnInfoListener(this.mKwaiOnInfoListener);
        kSCoreLivePlayerBuild.setOnLiveEventListener(this.mKwaiOnLiveEventListener);
        return kSCoreLivePlayerBuild;
    }

    /* renamed from: com.kwai.video.ksliveplayer.midd.KSLivePlayerImpl$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$com$kwai$video$ksliveplayer$impl$KSLiveDataSourceType = new int[KSLiveDataSourceType.values().length];

        static {
            try {
                $SwitchMap$com$kwai$video$ksliveplayer$impl$KSLiveDataSourceType[KSLiveDataSourceType.kManifest.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwai$video$ksliveplayer$impl$KSLiveDataSourceType[KSLiveDataSourceType.kSingleUrl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwai$video$ksliveplayer$impl$KSLiveDataSourceType[KSLiveDataSourceType.kMultiUrl.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.kwai.player.debuginfo.KwaiPlayerDebugInfoProvider
    public KwaiPlayerDebugInfo getDebugInfo() {
        IKwaiMediaPlayer kwaiMediaPlayer;
        KSCoreLivePlayer kSCoreLivePlayer = this.mCoreLivePlayer;
        if (kSCoreLivePlayer == null || (kwaiMediaPlayer = kSCoreLivePlayer.getKwaiMediaPlayer()) == null) {
            return null;
        }
        return kwaiMediaPlayer.getDebugInfo();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.mSurfaceTexture == null) {
            this.mSurfaceTexture = surfaceTexture;
            this.mSurface = new Surface(surfaceTexture);
            KSCoreLivePlayer kSCoreLivePlayer = this.mCoreLivePlayer;
            if (kSCoreLivePlayer != null) {
                kSCoreLivePlayer.setSurface(this.mSurface);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        KSCoreLivePlayer kSCoreLivePlayer = this.mCoreLivePlayer;
        if (kSCoreLivePlayer != null) {
            kSCoreLivePlayer.setSurface(null);
        }
        this.mSurfaceTexture = null;
        return true;
    }
}
