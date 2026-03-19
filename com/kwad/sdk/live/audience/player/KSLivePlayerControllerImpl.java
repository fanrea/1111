package com.kwad.sdk.live.audience.player;

import android.text.TextUtils;
import android.view.Surface;
import com.component.a.f.d;
import com.kwad.sdk.live.audience.KSLiveInitModule;
import com.kwad.sdk.live.audience.Utils;
import com.kwad.sdk.live.audience.model.KSLivePlayConfig;
import com.kwad.sdk.live.audience.player.KSLivePlayerController;
import com.kwad.sdk.live.audience.test.KSLiveLogger;
import com.kwai.video.ksliveplayer.KSCoreLivePlayer;
import com.kwai.video.ksliveplayer.KSCoreLivePlayerBuilder;
import com.kwai.video.ksliveplayer.KSLiveVideoContext;
import com.kwai.video.player.IMediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLivePlayerControllerImpl implements KSLivePlayerController {
    private KSCoreLivePlayer mKSCoreLivePlayer;
    private final KSLivePlayConfig mKSLivePlayConfig;
    private int mVideoHeight;
    private int mVideoWidth;
    private KSLivePlayerState mState = KSLivePlayerState.IDLE;
    private List<KSLivePlayerController.RenderListener> mRenderListeners = new ArrayList();
    private List<KSLivePlayerController.BufferListener> mBufferListeners = new ArrayList();
    private List<KSLivePlayerController.VideoSizeListener> mVideoSizeListeners = new ArrayList();
    private List<KSLivePlayerController.ErrorListener> mErrorListeners = new ArrayList();
    private List<KSLivePlayerController.UrlSwitchListener> mUrlSwitchListeners = new ArrayList();
    private List<KSLivePlayerController.PreparedListener> mPreparedListeners = new ArrayList();

    public static KSLivePlayerController newInstance(KSLivePlayConfig kSLivePlayConfig, JSONObject jSONObject) {
        return new KSLivePlayerControllerImpl(kSLivePlayConfig, jSONObject);
    }

    KSLivePlayerControllerImpl(KSLivePlayConfig kSLivePlayConfig, JSONObject jSONObject) {
        this.mKSLivePlayConfig = kSLivePlayConfig;
        buildKSCoreLivePlayer(jSONObject);
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void prepare() {
        simpleLog(d.a);
        this.mKSCoreLivePlayer.prepareAsync();
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void setSurface(Surface surface) {
        simpleLog("setSurface " + surface);
        KSCoreLivePlayer kSCoreLivePlayer = this.mKSCoreLivePlayer;
        if (kSCoreLivePlayer != null) {
            kSCoreLivePlayer.setSurface(surface);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void pause() {
        simpleLog("pause");
        this.mKSCoreLivePlayer.releaseAsync();
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void resume() {
        simpleLog("resume");
        this.mKSCoreLivePlayer.restart();
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void release() {
        simpleLog("release");
        this.mKSCoreLivePlayer.setOnErrorListener(null);
        this.mKSCoreLivePlayer.setOnVideoSizeChangedListener(null);
        this.mKSCoreLivePlayer.setOnInfoListener(null);
        this.mKSCoreLivePlayer.setOnUrlSwitchListener(null);
        this.mKSCoreLivePlayer.releaseAsync();
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void setVolume(float f, float f2) {
        this.mKSCoreLivePlayer.setVolume(f, f2);
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public int getVideoWidth() {
        int i = this.mVideoWidth;
        return i == 0 ? this.mKSCoreLivePlayer.getVideoWidth() : i;
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public int getVideoHeight() {
        int i = this.mVideoHeight;
        return i == 0 ? this.mKSCoreLivePlayer.getVideoHeight() : i;
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public KSCoreLivePlayer getKSCoreLivePlayer() {
        return this.mKSCoreLivePlayer;
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public KSLivePlayerState getLivePlayerState() {
        return this.mState;
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void addRenderListener(KSLivePlayerController.RenderListener renderListener) {
        if (renderListener != null) {
            this.mRenderListeners.add(renderListener);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void removeRenderListener(KSLivePlayerController.RenderListener renderListener) {
        if (renderListener != null) {
            this.mRenderListeners.remove(renderListener);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void addBufferListener(KSLivePlayerController.BufferListener bufferListener) {
        if (bufferListener != null) {
            this.mBufferListeners.add(bufferListener);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void removeBufferListener(KSLivePlayerController.BufferListener bufferListener) {
        if (bufferListener != null) {
            this.mBufferListeners.remove(bufferListener);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void addVideoSizeListener(KSLivePlayerController.VideoSizeListener videoSizeListener) {
        if (videoSizeListener != null) {
            this.mVideoSizeListeners.add(videoSizeListener);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void removeVideoSizeListener(KSLivePlayerController.VideoSizeListener videoSizeListener) {
        if (videoSizeListener != null) {
            this.mVideoSizeListeners.remove(videoSizeListener);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void addErrorListener(KSLivePlayerController.ErrorListener errorListener) {
        if (errorListener != null) {
            this.mErrorListeners.add(errorListener);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void removeErrorListener(KSLivePlayerController.ErrorListener errorListener) {
        if (errorListener != null) {
            this.mErrorListeners.remove(errorListener);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void addUrlSwitchListener(KSLivePlayerController.UrlSwitchListener urlSwitchListener) {
        if (urlSwitchListener != null) {
            this.mUrlSwitchListeners.add(urlSwitchListener);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void removeUrlSwitchListener(KSLivePlayerController.UrlSwitchListener urlSwitchListener) {
        if (urlSwitchListener != null) {
            this.mUrlSwitchListeners.remove(urlSwitchListener);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void addPreparedListener(KSLivePlayerController.PreparedListener preparedListener) {
        if (preparedListener != null) {
            this.mPreparedListeners.add(preparedListener);
        }
    }

    @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController
    public void removePreparedListener(KSLivePlayerController.PreparedListener preparedListener) {
        if (preparedListener != null) {
            this.mPreparedListeners.remove(preparedListener);
        }
    }

    private void buildKSCoreLivePlayer(JSONObject jSONObject) {
        KSCoreLivePlayerBuilder kSCoreLivePlayerBuilder = new KSCoreLivePlayerBuilder(KSLiveInitModule.getInstance().getAppContext());
        if (!TextUtils.isEmpty(this.mKSLivePlayConfig.mLiveManifestJson)) {
            kSCoreLivePlayerBuilder.setDataManifest(this.mKSLivePlayConfig.mLiveManifestJson, null);
        } else if (!Utils.isEmpty(this.mKSLivePlayConfig.mPlayUrls)) {
            kSCoreLivePlayerBuilder.setMultiPlayUrls(Utils.getPlayUrls(this.mKSLivePlayConfig.mPlayUrls));
        }
        KSLiveVideoContext kSLiveVideoContext = new KSLiveVideoContext();
        kSLiveVideoContext.liveStreamId = this.mKSLivePlayConfig.mLiveStreamId;
        if (jSONObject != null) {
            kSLiveVideoContext.extra = jSONObject;
        }
        kSCoreLivePlayerBuilder.setLiveVideoContext(kSLiveVideoContext);
        this.mKSCoreLivePlayer = kSCoreLivePlayerBuilder.build();
        setKSCoreLivePlayerListeners();
    }

    private void setKSCoreLivePlayerListeners() {
        this.mKSCoreLivePlayer.setOnVideoSizeChangedListener(new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.kwad.sdk.live.audience.player.KSLivePlayerControllerImpl.1
            @Override // com.kwai.video.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
                KSLiveLogger.i("player onVideoSizeChanged");
                boolean z = (i == KSLivePlayerControllerImpl.this.mVideoWidth && i2 == KSLivePlayerControllerImpl.this.mVideoHeight) ? false : true;
                if (z) {
                    KSLivePlayerControllerImpl.this.mVideoWidth = i;
                    KSLivePlayerControllerImpl.this.mVideoHeight = i2;
                }
                if (!z || KSLivePlayerControllerImpl.this.mVideoSizeListeners.isEmpty()) {
                    return;
                }
                Iterator it = KSLivePlayerControllerImpl.this.mVideoSizeListeners.iterator();
                while (it.hasNext()) {
                    ((KSLivePlayerController.VideoSizeListener) it.next()).onVideoSizeChanged(i, i2);
                }
            }
        });
        this.mKSCoreLivePlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: com.kwad.sdk.live.audience.player.KSLivePlayerControllerImpl.2
            @Override // com.kwai.video.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                KSLiveLogger.i("player onPrepared");
                if (KSLivePlayerControllerImpl.this.mPreparedListeners != null) {
                    Iterator it = KSLivePlayerControllerImpl.this.mPreparedListeners.iterator();
                    while (it.hasNext()) {
                        ((KSLivePlayerController.PreparedListener) it.next()).onPrepared();
                    }
                }
            }
        });
        this.mKSCoreLivePlayer.setOnUrlSwitchListener(new KSCoreLivePlayer.OnUrlSwitchListener() { // from class: com.kwad.sdk.live.audience.player.KSLivePlayerControllerImpl.3
            @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer.OnUrlSwitchListener
            public void onUrlSwitch(KSCoreLivePlayer.UrlSwitchInfo urlSwitchInfo) {
                KSLiveLogger.i("player onUrlSwitch", "reason", Integer.valueOf(urlSwitchInfo.mSwitchReason), "liveStreamId", KSLivePlayerControllerImpl.this.getLiveStreamId());
            }

            @Override // com.kwai.video.ksliveplayer.KSCoreLivePlayer.OnUrlSwitchListener
            public void onRunOutOfUrls() {
                KSLivePlayerControllerImpl.this.simpleLog("onRunOutOfUrls");
                if (KSLivePlayerControllerImpl.this.mUrlSwitchListeners.isEmpty()) {
                    return;
                }
                Iterator it = KSLivePlayerControllerImpl.this.mUrlSwitchListeners.iterator();
                while (it.hasNext()) {
                    ((KSLivePlayerController.UrlSwitchListener) it.next()).onRunOutOfUrls();
                }
            }
        });
        this.mKSCoreLivePlayer.setOnErrorListener(new IMediaPlayer.OnErrorListener() { // from class: com.kwad.sdk.live.audience.player.KSLivePlayerControllerImpl.4
            @Override // com.kwai.video.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                KSLiveLogger.i("player onError", "what", Integer.valueOf(i), "extra", Integer.valueOf(i2), "liveStreamId", KSLivePlayerControllerImpl.this.getLiveStreamId());
                if (KSLivePlayerControllerImpl.this.mErrorListeners.isEmpty()) {
                    return false;
                }
                Iterator it = KSLivePlayerControllerImpl.this.mErrorListeners.iterator();
                while (it.hasNext()) {
                    ((KSLivePlayerController.ErrorListener) it.next()).onError(i, i2);
                }
                return false;
            }
        });
        this.mKSCoreLivePlayer.setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: com.kwad.sdk.live.audience.player.KSLivePlayerControllerImpl.5
            @Override // com.kwai.video.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                KSLivePlayerControllerImpl.this.dispatchInfoListener(i, i2);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchInfoListener(int i, int i2) {
        if (i == 3) {
            simpleLog("MEDIA_INFO_VIDEO_RENDERING_START");
            if (this.mRenderListeners.isEmpty()) {
                return;
            }
            Iterator<KSLivePlayerController.RenderListener> it = this.mRenderListeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoRenderStart();
            }
            return;
        }
        if (i == 10002) {
            simpleLog("MEDIA_INFO_AUDIO_RENDERING_START");
            if (this.mRenderListeners.isEmpty()) {
                return;
            }
            Iterator<KSLivePlayerController.RenderListener> it2 = this.mRenderListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onAudioRenderStart();
            }
            return;
        }
        if (i == 701) {
            simpleLog("MEDIA_INFO_BUFFERING_START");
            if (this.mBufferListeners.isEmpty()) {
                return;
            }
            Iterator<KSLivePlayerController.BufferListener> it3 = this.mBufferListeners.iterator();
            while (it3.hasNext()) {
                it3.next().onBufferStart();
            }
            return;
        }
        if (i != 702) {
            return;
        }
        simpleLog("MEDIA_INFO_BUFFERING_END");
        if (this.mBufferListeners.isEmpty()) {
            return;
        }
        Iterator<KSLivePlayerController.BufferListener> it4 = this.mBufferListeners.iterator();
        while (it4.hasNext()) {
            it4.next().onBufferEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void simpleLog(String str) {
        KSLiveLogger.i("player " + str, "liveStreamId", getLiveStreamId());
    }

    private void simpleLog(String str, Throwable th) {
        KSLiveLogger.e("player " + str, "liveStreamId", getLiveStreamId(), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLiveStreamId() {
        return this.mKSLivePlayConfig.getLiveStreamId();
    }
}
