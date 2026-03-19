package com.bytedance.sdk.djx.core.vod;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.widget.FrameLayout;
import com.bytedance.sdk.djx.core.vod.layerevent.LayerEvent;
import com.bytedance.sdk.djx.core.vod.layerevent.LayerEventManager;
import com.bytedance.sdk.djx.core.vod.player.AbstractPlayer;
import com.bytedance.sdk.djx.core.vod.render.RenderFactory;
import com.bytedance.sdk.djx.core.vod.util.SRABConfig;
import com.bytedance.sdk.djx.model.ThumbM;
import com.bytedance.sdk.djx.model.Video;
import com.bytedance.sdk.djx.model.VideoM;
import com.bytedance.sdk.djx.model.VideoUrl;
import com.bytedance.sdk.djx.utils.service.ServiceManager;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXPlayerView extends FrameLayout implements IVideoController {
    public static final String HOST_NEWS_DETAIL_VIDEO_FRAG = "NewsDetailVideo";
    private static final String TAG = "DJXPlayerView";
    protected LayerContainer mBaseLayer;
    protected Context mContext;
    private final LayerEventManager mEventManager;
    private Object mHostTag;
    private boolean mIsLooping;
    private boolean mIsMute;
    private boolean mIsStarted;
    private boolean mIsStopped;
    private ILayerListener mLayerListener;
    private FrameLayout mLayoutVideo;
    protected AbstractPlayer mMediaPlayer;
    private IVideoListener mOuterVideoListener;
    protected IVideoRender mRenderView;
    private float mSpeed;
    private final IVideoListener mVideoListener;
    private final int[] mVideoSize;

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public Bitmap doScreenShot() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public void replay(boolean z) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public void setScreenScaleType(int i) {
    }

    public DJXPlayerView(Context context) {
        super(context);
        this.mEventManager = LayerEventManager.build();
        this.mVideoSize = new int[]{0, 0};
        this.mIsStarted = false;
        this.mIsStopped = false;
        this.mIsLooping = true;
        this.mIsMute = false;
        this.mSpeed = 1.0f;
        this.mVideoListener = new IVideoListener() { // from class: com.bytedance.sdk.djx.core.vod.DJXPlayerView.2
            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onPrepared() {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onPrepared();
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onPrepared();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onRenderFirstFrame() {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onRenderFirstFrame();
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onRenderFirstFrame();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onError(int i, String str, Throwable th) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onError(i, str, th);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onError(i, str, th);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onCompletion() {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onCompletion();
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onCompletion();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onInfo(int i, int i2) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onInfo(i, i2);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onInfo(i, i2);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onVideoSizeChanged(int i, int i2) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onVideoSizeChanged(i, i2);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onVideoSizeChanged(i, i2);
                }
                DJXPlayerView.this.mVideoSize[0] = i;
                DJXPlayerView.this.mVideoSize[1] = i2;
                if (DJXPlayerView.this.mRenderView != null) {
                    DJXPlayerView.this.mRenderView.setVideoSize(i, i2);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onDurationChange(long j) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onDurationChange(j);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onDurationChange(j);
                }
            }
        };
        this.mContext = context;
        initContainer();
        initRenderView();
        initPlayer();
    }

    public DJXPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEventManager = LayerEventManager.build();
        this.mVideoSize = new int[]{0, 0};
        this.mIsStarted = false;
        this.mIsStopped = false;
        this.mIsLooping = true;
        this.mIsMute = false;
        this.mSpeed = 1.0f;
        this.mVideoListener = new IVideoListener() { // from class: com.bytedance.sdk.djx.core.vod.DJXPlayerView.2
            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onPrepared() {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onPrepared();
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onPrepared();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onRenderFirstFrame() {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onRenderFirstFrame();
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onRenderFirstFrame();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onError(int i, String str, Throwable th) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onError(i, str, th);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onError(i, str, th);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onCompletion() {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onCompletion();
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onCompletion();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onInfo(int i, int i2) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onInfo(i, i2);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onInfo(i, i2);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onVideoSizeChanged(int i, int i2) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onVideoSizeChanged(i, i2);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onVideoSizeChanged(i, i2);
                }
                DJXPlayerView.this.mVideoSize[0] = i;
                DJXPlayerView.this.mVideoSize[1] = i2;
                if (DJXPlayerView.this.mRenderView != null) {
                    DJXPlayerView.this.mRenderView.setVideoSize(i, i2);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onDurationChange(long j) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onDurationChange(j);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onDurationChange(j);
                }
            }
        };
        this.mContext = context;
        initContainer();
        initRenderView();
        initPlayer();
    }

    public DJXPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEventManager = LayerEventManager.build();
        this.mVideoSize = new int[]{0, 0};
        this.mIsStarted = false;
        this.mIsStopped = false;
        this.mIsLooping = true;
        this.mIsMute = false;
        this.mSpeed = 1.0f;
        this.mVideoListener = new IVideoListener() { // from class: com.bytedance.sdk.djx.core.vod.DJXPlayerView.2
            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onPrepared() {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onPrepared();
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onPrepared();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onRenderFirstFrame() {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onRenderFirstFrame();
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onRenderFirstFrame();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onError(int i2, String str, Throwable th) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onError(i2, str, th);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onError(i2, str, th);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onCompletion() {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onCompletion();
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onCompletion();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onInfo(int i2, int i22) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onInfo(i2, i22);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onInfo(i2, i22);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onVideoSizeChanged(int i2, int i22) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onVideoSizeChanged(i2, i22);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onVideoSizeChanged(i2, i22);
                }
                DJXPlayerView.this.mVideoSize[0] = i2;
                DJXPlayerView.this.mVideoSize[1] = i22;
                if (DJXPlayerView.this.mRenderView != null) {
                    DJXPlayerView.this.mRenderView.setVideoSize(i2, i22);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onDurationChange(long j) {
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onDurationChange(j);
                }
                if (DJXPlayerView.this.mOuterVideoListener != null) {
                    DJXPlayerView.this.mOuterVideoListener.onDurationChange(j);
                }
            }
        };
        this.mContext = context;
        initContainer();
        initRenderView();
        initPlayer();
    }

    private void initContainer() {
        this.mEventManager.setListener(new LayerEventManager.Listener() { // from class: com.bytedance.sdk.djx.core.vod.DJXPlayerView.1
            @Override // com.bytedance.sdk.djx.core.vod.layerevent.LayerEventManager.Listener
            public void onLayerEvent(LayerEvent layerEvent) {
                if (DJXPlayerView.this.mLayerListener != null) {
                    DJXPlayerView.this.mLayerListener.onLayerEvent(layerEvent);
                }
                if (DJXPlayerView.this.mBaseLayer != null) {
                    DJXPlayerView.this.mBaseLayer.onLayerEvent(layerEvent);
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mLayoutVideo = frameLayout;
        addView(frameLayout, 0, new FrameLayout.LayoutParams(-1, -1));
        LayerContainer layerContainer = new LayerContainer(this.mContext);
        this.mBaseLayer = layerContainer;
        layerContainer.attach(this, this.mEventManager);
        addView(this.mBaseLayer.getView(), 1, new FrameLayout.LayoutParams(-1, -1));
    }

    public void reset() {
        release();
        initPlayer();
    }

    public void retryByInit() {
        reset();
    }

    public void send(LayerEvent layerEvent) {
        LayerEventManager layerEventManager;
        if (layerEvent == null || (layerEventManager = this.mEventManager) == null) {
            return;
        }
        layerEventManager.send(layerEvent);
    }

    public void setVideoListener(IVideoListener iVideoListener) {
        this.mOuterVideoListener = iVideoListener;
    }

    public void setLayerListener(ILayerListener iLayerListener) {
        this.mLayerListener = iLayerListener;
    }

    public void addLayer(IVideoLayer iVideoLayer) {
        LayerContainer layerContainer = this.mBaseLayer;
        if (layerContainer != null) {
            layerContainer.addLayer(iVideoLayer);
        }
    }

    public void toggle() {
        if (isPlaying()) {
            pause();
        } else {
            start();
        }
    }

    private void initPlayer() {
        AbstractPlayer abstractPlayerCreateTTPlayer = ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).createTTPlayer(this.mContext);
        this.mMediaPlayer = abstractPlayerCreateTTPlayer;
        abstractPlayerCreateTTPlayer.setPlayerEventListener(this.mVideoListener);
        this.mMediaPlayer.initPlayer();
        this.mMediaPlayer.setSpeed(this.mSpeed);
        this.mRenderView.attachPlayer(this.mMediaPlayer);
        this.mIsStarted = false;
    }

    private void initRenderView() {
        this.mRenderView = RenderFactory.createTexture(this.mContext);
        this.mLayoutVideo.addView(this.mRenderView.getView(), 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void setUrl(VideoM videoM) {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.setDataSource(videoM);
            setTag(R.id.djx_id_tt_player__media_source, videoM);
        }
    }

    public void setUrl(Video video) {
        VideoUrl videoUrl = video.getVideoUrls().get(0);
        if (this.mMediaPlayer != null) {
            HashMap map = new HashMap();
            map.put("file_hash", videoUrl.getFileHash());
            this.mMediaPlayer.setDataSource(videoUrl.getUrl(), map);
            setTag(R.id.djx_id_tt_player__media_source, new Pair(videoUrl.getUrl(), videoUrl.getFileHash()));
        }
    }

    public boolean hasVideoModel() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            return abstractPlayer.hasVideoModel();
        }
        return false;
    }

    public void setUrl(String str, String str2) {
        if (this.mMediaPlayer != null) {
            HashMap map = new HashMap();
            map.put("file_hash", str2);
            this.mMediaPlayer.setDataSource(str, map);
            setTag(R.id.djx_id_tt_player__media_source, new Pair(str, str2));
        }
    }

    public void release() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.release();
            this.mMediaPlayer = null;
        }
        this.mIsStarted = false;
    }

    public void releaseRenderView() {
        IVideoRender iVideoRender = this.mRenderView;
        if (iVideoRender != null) {
            iVideoRender.release();
        }
        this.mIsStarted = false;
    }

    public void stop() {
        release();
        this.mIsStarted = false;
        this.mIsStopped = true;
    }

    public void setLooping(boolean z) {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.setLooping(z);
            this.mIsLooping = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private void doAttachedTask() {
        if (this.mMediaPlayer == null) {
            initPlayer();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Object tag = getTag(R.id.djx_id_dpplayer_view_host);
        this.mHostTag = tag;
        if ((tag instanceof String) && TextUtils.equals((String) tag, HOST_NEWS_DETAIL_VIDEO_FRAG)) {
            return;
        }
        doDetachedTask();
    }

    private void doDetachedTask() {
        stop();
    }

    private void setPlayerData() {
        Object tag;
        if (this.mMediaPlayer == null || (tag = getTag(R.id.djx_id_tt_player__media_source)) == null) {
            return;
        }
        if (tag instanceof Pair) {
            try {
                Pair pair = (Pair) tag;
                HashMap map = new HashMap();
                map.put("file_hash", pair.second);
                this.mMediaPlayer.setDataSource((String) pair.first, map);
                return;
            } catch (Throwable unused) {
                Log.e(TAG, "DJXPlayerView play error1 :" + tag);
                return;
            }
        }
        if (tag instanceof VideoM) {
            try {
                this.mMediaPlayer.setDataSource((VideoM) tag);
            } catch (Throwable unused2) {
                Log.e(TAG, "DJXPlayerView play error2 :" + tag);
            }
        }
    }

    private void resumePlayerParams() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.setMute(this.mIsMute);
            this.mMediaPlayer.setLooping(this.mIsLooping);
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public void start() {
        if (this.mMediaPlayer == null && this.mIsStopped) {
            initPlayer();
            setPlayerData();
            resumePlayerParams();
            IVideoRender iVideoRender = this.mRenderView;
            if (iVideoRender != null) {
                iVideoRender.attachPlayer(this.mMediaPlayer);
            }
            this.mIsStopped = false;
        }
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.setSRResolution(SRABConfig.enableSR(), SRABConfig.abSRMultiple());
            this.mMediaPlayer.start();
            this.mIsStarted = true;
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public void pause() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.pause();
        }
        this.mIsStarted = false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public int getPlayerState() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer == null) {
            return 2;
        }
        abstractPlayer.getPlayerState();
        return 2;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public long getDuration() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            return abstractPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public long getCurrentPosition() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            return abstractPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public long getWatchedDuration() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            return abstractPlayer.getWatchedDuration();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public void seekTo(long j) {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.seekTo(j);
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public boolean isPlaying() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            return abstractPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public int getBufferedPercentage() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            return abstractPlayer.getBufferedPercentage();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public void setMute(boolean z) {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.setMute(z);
            this.mIsMute = z;
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public boolean isMute() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            return abstractPlayer.isMute();
        }
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public void setSpeed(float f) {
        this.mSpeed = f;
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.setSpeed(f);
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public float getSpeed() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            return abstractPlayer.getSpeed();
        }
        return 0.0f;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public int[] getVideoSize() {
        return this.mVideoSize;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public void setStartTime(int i) {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.setStartTime(i);
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public List<ThumbM> getThumbList() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            return abstractPlayer.getThumbList();
        }
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public boolean isSRMode() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        if (abstractPlayer != null) {
            return abstractPlayer.isSRMode();
        }
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoController
    public String getSRErrorMsg() {
        AbstractPlayer abstractPlayer = this.mMediaPlayer;
        return abstractPlayer != null ? abstractPlayer.getSRErrorMsg() : "-2";
    }

    public boolean isStarted() {
        return this.mIsStarted;
    }
}
