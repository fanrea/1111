package com.bytedance.sdk.djx.core.business.budrama.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.rsp.VideoModelRsp;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHelper;
import com.bytedance.sdk.djx.core.business.view.DJXDrawCoverView;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.util.ImageUtil;
import com.bytedance.sdk.djx.core.vod.DJXPlayerView;
import com.bytedance.sdk.djx.core.vod.IVideoListener;
import com.bytedance.sdk.djx.core.vod.IVideoService;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.VideoM;
import com.bytedance.sdk.djx.model.ev.BEDismissOuterLoadingEvent;
import com.bytedance.sdk.djx.model.ev.BEDramaCard;
import com.bytedance.sdk.djx.net.ImageTag;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.net.io.ByteString;
import com.bytedance.sdk.djx.params.DJXWidgetDramaCardParams;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;
import com.bytedance.sdk.djx.utils.service.ServiceManager;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class DJXDramaCardView extends FrameLayout {
    private static final int MAX_RETRY_TIMES = 1;
    private static final String TAG = "DJXDramaCardView";
    private static final float VIEW_SCALE = 1.7777778f;
    private final IBusListener mBusListener;
    private int mCurrentRetry;
    private DramaDetail mDramaDetail;
    private boolean mHasPaused;
    private DJXDrawCoverView mImgCover;
    private ImageView mImgReplay;
    private boolean mIsMute;
    private volatile boolean mIsVideoPrepared;
    private long mLastOverTime;
    private long mMaxPassTime;
    private long mMaxShowTime;
    private DJXPlayerView mPlayerView;
    private final DramaCardReporter mReporter;
    private ImageView mSpeakerIcon;
    private final IVideoListener mVideoListener;
    private ViewGroup mViewContainer;
    private int mViewHeight;
    private int mViewWidth;
    private DJXWidgetDramaCardParams mWidgetParams;

    static /* synthetic */ int access$1008(DJXDramaCardView dJXDramaCardView) {
        int i = dJXDramaCardView.mCurrentRetry;
        dJXDramaCardView.mCurrentRetry = i + 1;
        return i;
    }

    public DJXDramaCardView(Context context) {
        super(context);
        this.mMaxShowTime = 0L;
        this.mMaxPassTime = 0L;
        this.mLastOverTime = -1L;
        this.mReporter = new DramaCardReporter();
        this.mBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DJXDramaCardView.1
            public void onBusEvent(BusEvent busEvent) {
                if (busEvent instanceof BEDramaCard) {
                    DJXDramaCardView.this.setMute(((BEDramaCard) busEvent).isMute());
                }
            }
        };
        this.mVideoListener = new IVideoListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DJXDramaCardView.5
            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onPrepared() {
                DJXDramaCardView.this.mIsVideoPrepared = true;
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onRenderFirstFrame() {
                LG.d(DJXDramaCardView.TAG, "renderFirstFrame, index = " + DJXDramaCardView.this.mDramaDetail.getIndex());
                if (!DJXDramaCardView.this.mPlayerView.isStarted()) {
                    DJXDramaCardView.this.stopBySendLog(false);
                    return;
                }
                DJXDramaCardView.this.sendVideoAutoPlayEvent();
                DJXDramaCardView.this.mImgReplay.setVisibility(8);
                DJXDramaCardView.this.mImgCover.setVisibility(8);
                DJXDramaCardView.this.mHasPaused = false;
                DJXDramaCardView.this.mIsVideoPrepared = true;
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onError(int i, String str, Throwable th) {
                JSONObject original;
                boolean zIsErrorRetryable = ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).isErrorRetryable(i);
                try {
                    VideoM videoModel = DJXDramaCardView.this.mDramaDetail.getVideoModel();
                    String strString = null;
                    if (videoModel != null && (original = videoModel.getOriginal()) != null) {
                        strString = ByteString.encodeUtf8(original.toString()).string(Charset.defaultCharset());
                    }
                    LG.i(DJXDramaCardView.TAG, "code = " + i + ", feed is null ? " + DJXDramaCardView.this.mDramaDetail + ", videoModel = " + videoModel + ", data = " + strString);
                } catch (Exception unused) {
                }
                boolean z = DJXDramaCardView.this.mCurrentRetry < 1;
                if (!zIsErrorRetryable || !z) {
                    DJXDramaCardView.this.mImgCover.setVisibility(0);
                    DJXDramaCardView.this.sendVideoAutoOverEvent();
                } else {
                    DJXDramaCardView.access$1008(DJXDramaCardView.this);
                    DJXDramaCardView.this.requestVideoWhenExpired();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onCompletion() {
                DJXDramaCardView.this.mMaxPassTime = 2147483647L;
                Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(DJXDramaCardView.this.mDramaDetail, null);
                if (DJXDramaCardView.this.mWidgetParams != null && DJXDramaCardView.this.mWidgetParams.mListener != null) {
                    DJXDramaCardView.this.mWidgetParams.mListener.onDJXVideoCompletion(mapCreateParamsMap);
                    LG.d(DJXDramaCardView.TAG, "onDJXVideoCompletion map = " + mapCreateParamsMap);
                }
                if (DJXDramaCardView.this.mWidgetParams != null && !DJXDramaCardView.this.mWidgetParams.mIsLooping && !DJXDramaCardView.this.mWidgetParams.mHideReplayButton) {
                    DJXDramaCardView.this.mImgReplay.setVisibility(0);
                }
                DJXDramaCardView.this.sendVideoAutoOverEvent();
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onInfo(int i, int i2) {
                if (i == -42) {
                    DJXDramaCardView.this.onVideoPauseResponse();
                    DJXDramaCardView.this.mHasPaused = true;
                } else if (i == -41 && DJXDramaCardView.this.mHasPaused) {
                    DJXDramaCardView.this.onVideoContinueResponse();
                } else if (i == -40) {
                    DJXDramaCardView.this.mIsVideoPrepared = false;
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onVideoSizeChanged(int i, int i2) {
                if (DJXDramaCardView.this.mImgCover != null) {
                    DJXDramaCardView.this.mImgCover.setVideoSize(i, i2);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onDurationChange(long j) {
                if (DJXDramaCardView.this.mMaxPassTime >= j || DJXDramaCardView.this.mMaxPassTime == 2147483647L) {
                    return;
                }
                DJXDramaCardView.this.mMaxPassTime = j;
            }
        };
    }

    public DJXDramaCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxShowTime = 0L;
        this.mMaxPassTime = 0L;
        this.mLastOverTime = -1L;
        this.mReporter = new DramaCardReporter();
        this.mBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DJXDramaCardView.1
            public void onBusEvent(BusEvent busEvent) {
                if (busEvent instanceof BEDramaCard) {
                    DJXDramaCardView.this.setMute(((BEDramaCard) busEvent).isMute());
                }
            }
        };
        this.mVideoListener = new IVideoListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DJXDramaCardView.5
            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onPrepared() {
                DJXDramaCardView.this.mIsVideoPrepared = true;
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onRenderFirstFrame() {
                LG.d(DJXDramaCardView.TAG, "renderFirstFrame, index = " + DJXDramaCardView.this.mDramaDetail.getIndex());
                if (!DJXDramaCardView.this.mPlayerView.isStarted()) {
                    DJXDramaCardView.this.stopBySendLog(false);
                    return;
                }
                DJXDramaCardView.this.sendVideoAutoPlayEvent();
                DJXDramaCardView.this.mImgReplay.setVisibility(8);
                DJXDramaCardView.this.mImgCover.setVisibility(8);
                DJXDramaCardView.this.mHasPaused = false;
                DJXDramaCardView.this.mIsVideoPrepared = true;
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onError(int i, String str, Throwable th) {
                JSONObject original;
                boolean zIsErrorRetryable = ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).isErrorRetryable(i);
                try {
                    VideoM videoModel = DJXDramaCardView.this.mDramaDetail.getVideoModel();
                    String strString = null;
                    if (videoModel != null && (original = videoModel.getOriginal()) != null) {
                        strString = ByteString.encodeUtf8(original.toString()).string(Charset.defaultCharset());
                    }
                    LG.i(DJXDramaCardView.TAG, "code = " + i + ", feed is null ? " + DJXDramaCardView.this.mDramaDetail + ", videoModel = " + videoModel + ", data = " + strString);
                } catch (Exception unused) {
                }
                boolean z = DJXDramaCardView.this.mCurrentRetry < 1;
                if (!zIsErrorRetryable || !z) {
                    DJXDramaCardView.this.mImgCover.setVisibility(0);
                    DJXDramaCardView.this.sendVideoAutoOverEvent();
                } else {
                    DJXDramaCardView.access$1008(DJXDramaCardView.this);
                    DJXDramaCardView.this.requestVideoWhenExpired();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onCompletion() {
                DJXDramaCardView.this.mMaxPassTime = 2147483647L;
                Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(DJXDramaCardView.this.mDramaDetail, null);
                if (DJXDramaCardView.this.mWidgetParams != null && DJXDramaCardView.this.mWidgetParams.mListener != null) {
                    DJXDramaCardView.this.mWidgetParams.mListener.onDJXVideoCompletion(mapCreateParamsMap);
                    LG.d(DJXDramaCardView.TAG, "onDJXVideoCompletion map = " + mapCreateParamsMap);
                }
                if (DJXDramaCardView.this.mWidgetParams != null && !DJXDramaCardView.this.mWidgetParams.mIsLooping && !DJXDramaCardView.this.mWidgetParams.mHideReplayButton) {
                    DJXDramaCardView.this.mImgReplay.setVisibility(0);
                }
                DJXDramaCardView.this.sendVideoAutoOverEvent();
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onInfo(int i, int i2) {
                if (i == -42) {
                    DJXDramaCardView.this.onVideoPauseResponse();
                    DJXDramaCardView.this.mHasPaused = true;
                } else if (i == -41 && DJXDramaCardView.this.mHasPaused) {
                    DJXDramaCardView.this.onVideoContinueResponse();
                } else if (i == -40) {
                    DJXDramaCardView.this.mIsVideoPrepared = false;
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onVideoSizeChanged(int i, int i2) {
                if (DJXDramaCardView.this.mImgCover != null) {
                    DJXDramaCardView.this.mImgCover.setVideoSize(i, i2);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onDurationChange(long j) {
                if (DJXDramaCardView.this.mMaxPassTime >= j || DJXDramaCardView.this.mMaxPassTime == 2147483647L) {
                    return;
                }
                DJXDramaCardView.this.mMaxPassTime = j;
            }
        };
    }

    public DJXDramaCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxShowTime = 0L;
        this.mMaxPassTime = 0L;
        this.mLastOverTime = -1L;
        this.mReporter = new DramaCardReporter();
        this.mBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DJXDramaCardView.1
            public void onBusEvent(BusEvent busEvent) {
                if (busEvent instanceof BEDramaCard) {
                    DJXDramaCardView.this.setMute(((BEDramaCard) busEvent).isMute());
                }
            }
        };
        this.mVideoListener = new IVideoListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DJXDramaCardView.5
            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onPrepared() {
                DJXDramaCardView.this.mIsVideoPrepared = true;
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onRenderFirstFrame() {
                LG.d(DJXDramaCardView.TAG, "renderFirstFrame, index = " + DJXDramaCardView.this.mDramaDetail.getIndex());
                if (!DJXDramaCardView.this.mPlayerView.isStarted()) {
                    DJXDramaCardView.this.stopBySendLog(false);
                    return;
                }
                DJXDramaCardView.this.sendVideoAutoPlayEvent();
                DJXDramaCardView.this.mImgReplay.setVisibility(8);
                DJXDramaCardView.this.mImgCover.setVisibility(8);
                DJXDramaCardView.this.mHasPaused = false;
                DJXDramaCardView.this.mIsVideoPrepared = true;
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onError(int i2, String str, Throwable th) {
                JSONObject original;
                boolean zIsErrorRetryable = ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).isErrorRetryable(i2);
                try {
                    VideoM videoModel = DJXDramaCardView.this.mDramaDetail.getVideoModel();
                    String strString = null;
                    if (videoModel != null && (original = videoModel.getOriginal()) != null) {
                        strString = ByteString.encodeUtf8(original.toString()).string(Charset.defaultCharset());
                    }
                    LG.i(DJXDramaCardView.TAG, "code = " + i2 + ", feed is null ? " + DJXDramaCardView.this.mDramaDetail + ", videoModel = " + videoModel + ", data = " + strString);
                } catch (Exception unused) {
                }
                boolean z = DJXDramaCardView.this.mCurrentRetry < 1;
                if (!zIsErrorRetryable || !z) {
                    DJXDramaCardView.this.mImgCover.setVisibility(0);
                    DJXDramaCardView.this.sendVideoAutoOverEvent();
                } else {
                    DJXDramaCardView.access$1008(DJXDramaCardView.this);
                    DJXDramaCardView.this.requestVideoWhenExpired();
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onCompletion() {
                DJXDramaCardView.this.mMaxPassTime = 2147483647L;
                Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(DJXDramaCardView.this.mDramaDetail, null);
                if (DJXDramaCardView.this.mWidgetParams != null && DJXDramaCardView.this.mWidgetParams.mListener != null) {
                    DJXDramaCardView.this.mWidgetParams.mListener.onDJXVideoCompletion(mapCreateParamsMap);
                    LG.d(DJXDramaCardView.TAG, "onDJXVideoCompletion map = " + mapCreateParamsMap);
                }
                if (DJXDramaCardView.this.mWidgetParams != null && !DJXDramaCardView.this.mWidgetParams.mIsLooping && !DJXDramaCardView.this.mWidgetParams.mHideReplayButton) {
                    DJXDramaCardView.this.mImgReplay.setVisibility(0);
                }
                DJXDramaCardView.this.sendVideoAutoOverEvent();
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onInfo(int i2, int i22) {
                if (i2 == -42) {
                    DJXDramaCardView.this.onVideoPauseResponse();
                    DJXDramaCardView.this.mHasPaused = true;
                } else if (i2 == -41 && DJXDramaCardView.this.mHasPaused) {
                    DJXDramaCardView.this.onVideoContinueResponse();
                } else if (i2 == -40) {
                    DJXDramaCardView.this.mIsVideoPrepared = false;
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onVideoSizeChanged(int i2, int i22) {
                if (DJXDramaCardView.this.mImgCover != null) {
                    DJXDramaCardView.this.mImgCover.setVideoSize(i2, i22);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onDurationChange(long j) {
                if (DJXDramaCardView.this.mMaxPassTime >= j || DJXDramaCardView.this.mMaxPassTime == 2147483647L) {
                    return;
                }
                DJXDramaCardView.this.mMaxPassTime = j;
            }
        };
    }

    public static DJXDramaCardView createDramaCard(Context context, DJXWidgetDramaCardParams dJXWidgetDramaCardParams, DramaDetail dramaDetail) {
        DJXDramaCardView dJXDramaCardView = new DJXDramaCardView(context);
        dJXDramaCardView.create(dJXWidgetDramaCardParams, dramaDetail);
        return dJXDramaCardView;
    }

    private void create(DJXWidgetDramaCardParams dJXWidgetDramaCardParams, DramaDetail dramaDetail) {
        this.mWidgetParams = dJXWidgetDramaCardParams;
        this.mDramaDetail = dramaDetail;
        this.mViewHeight = UIUtil.dp2px(dJXWidgetDramaCardParams.mWidth * VIEW_SCALE);
        this.mViewWidth = UIUtil.dp2px(this.mWidgetParams.mWidth);
        this.mIsMute = this.mWidgetParams.mIsMuteDefault;
        this.mIsVideoPrepared = false;
        this.mCurrentRetry = 0;
        DJXBus.getInstance().addListener(this.mBusListener);
        init();
    }

    private void init() {
        initView();
        initData();
    }

    private void initView() {
        View.inflate(InnerManager.getContext(), R.layout.djx_drama_card_layout, this);
        this.mViewContainer = (ViewGroup) findViewById(R.id.djx_drama_card_container);
        this.mImgReplay = (ImageView) findViewById(R.id.djx_drama_card_replay);
        this.mImgCover = (DJXDrawCoverView) findViewById(R.id.djx_drama_card_cover);
        this.mPlayerView = (DJXPlayerView) findViewById(R.id.djx_drama_card_player);
        this.mSpeakerIcon = (ImageView) findViewById(R.id.djx_drama_card_speaker);
        resizeView();
        this.mImgReplay.setVisibility(8);
        this.mImgReplay.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DJXDramaCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DJXDramaCardView.this.start();
            }
        });
        this.mImgCover.setVideoSize(this.mViewWidth, this.mViewHeight);
        DramaDetail dramaDetail = this.mDramaDetail;
        if (dramaDetail != null) {
            Picasso.with(getRootView().getContext()).load(ImageUtil.getVideoFrame(dramaDetail.getDrama() != null ? this.mDramaDetail.getDrama().coverImages2 : null, this.mDramaDetail.getFirstCovers(), this.mDramaDetail.getDrama().coverImage)).tag(ImageTag.TAG_DRAMA_CARD).config(Bitmap.Config.RGB_565).resize(this.mViewWidth, this.mViewHeight).centerCrop().into(this.mImgCover);
        }
        this.mImgCover.setVisibility(0);
        if (this.mWidgetParams.mHideSoundButton) {
            this.mSpeakerIcon.setVisibility(8);
        }
        this.mSpeakerIcon.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DJXDramaCardView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DJXDramaCardView.this.setMute(!DJXDramaCardView.this.mIsMute);
            }
        });
        this.mViewContainer.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DJXDramaCardView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDramaCardView.this.mWidgetParams.mClickListener != null) {
                    DJXDramaCardView.this.mWidgetParams.mClickListener.onClick();
                }
                LG.d(DJXDramaCardView.TAG, "View has been clicked");
            }
        });
    }

    private void resizeView() {
        ViewGroup.LayoutParams layoutParams = this.mViewContainer.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.mViewWidth, this.mViewHeight);
        } else {
            layoutParams.width = this.mViewWidth;
            layoutParams.height = this.mViewHeight;
        }
        this.mViewContainer.setLayoutParams(layoutParams);
    }

    private void initData() {
        this.mPlayerView.setVideoListener(this.mVideoListener);
        this.mPlayerView.setUrl(this.mDramaDetail.getVideoModel());
        this.mPlayerView.setLooping(this.mWidgetParams.mIsLooping);
        setMute(this.mWidgetParams.mIsMuteDefault);
        this.mReporter.setParams(ILogConst.CATEGORY_EXTERNAL_COMPONENT, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVideoAutoPlayEvent() {
        if (this.mReporter.sendAutoPlayEvent(this.mDramaDetail)) {
            Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(this.mDramaDetail, null);
            DJXWidgetDramaCardParams dJXWidgetDramaCardParams = this.mWidgetParams;
            if (dJXWidgetDramaCardParams == null || dJXWidgetDramaCardParams.mListener == null) {
                return;
            }
            this.mWidgetParams.mListener.onDJXVideoPlay(mapCreateParamsMap);
            LG.d(TAG, "onDJXVideoPlay map = " + mapCreateParamsMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVideoAutoOverEvent() {
        if (this.mMaxPassTime < this.mPlayerView.getCurrentPosition() && this.mMaxPassTime != 2147483647L) {
            this.mMaxPassTime = this.mPlayerView.getCurrentPosition();
        }
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        long duration = dJXPlayerView != null ? dJXPlayerView.getDuration() : 0L;
        DJXPlayerView dJXPlayerView2 = this.mPlayerView;
        long watchedDuration = dJXPlayerView2 != null ? dJXPlayerView2.getWatchedDuration() : 0L;
        long j = this.mLastOverTime;
        long j2 = (j <= -1 || watchedDuration <= 0) ? watchedDuration : watchedDuration - j;
        this.mLastOverTime = watchedDuration;
        if (this.mReporter.sendAutoOverEvent(this.mDramaDetail, duration != 0 ? j2 : 0L, Math.min(Float.valueOf((duration == 0 ? 0.0f : this.mMaxPassTime / duration) * 100.0f).intValue(), 100))) {
            Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(this.mDramaDetail, null);
            DJXWidgetDramaCardParams dJXWidgetDramaCardParams = this.mWidgetParams;
            if (dJXWidgetDramaCardParams == null || dJXWidgetDramaCardParams.mListener == null) {
                return;
            }
            this.mWidgetParams.mListener.onDJXVideoOver(mapCreateParamsMap);
            LG.d(TAG, "onDJXVideoOver map = " + mapCreateParamsMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestVideoWhenExpired() {
        DramaDetail dramaDetail = this.mDramaDetail;
        if (dramaDetail == null || dramaDetail.getVideoId() == null) {
            this.mImgCover.setVisibility(0);
            sendVideoAutoOverEvent();
        } else {
            ApiManager.getInstance().videoModel(1, this.mDramaDetail.getGroupId(), this.mDramaDetail.getSkitId(), this.mDramaDetail.getVideoId(), new IApiCallback<VideoModelRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DJXDramaCardView.6
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(VideoModelRsp videoModelRsp) {
                    try {
                        VideoM data = videoModelRsp.getData();
                        if (DJXDramaCardView.this.mDramaDetail != null && data != null && data.getVideoId() != null && data.getOriginal() != null && (DJXDramaCardView.this.mDramaDetail.getVideoModel() == null || TextUtils.isEmpty(DJXDramaCardView.this.mDramaDetail.getVideoModel().getVideoId()) || data.getVideoId().equals(DJXDramaCardView.this.mDramaDetail.getVideoModel().getVideoId()))) {
                            DJXDramaCardView.this.mDramaDetail.setVideoModel(data);
                            DJXDramaCardView.this.mPlayerView.retryByInit();
                            DJXDramaCardView.this.mImgCover.setVisibility(8);
                            DJXDramaCardView.this.start();
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                    DJXDramaCardView.this.mImgCover.setVisibility(0);
                    DJXDramaCardView.this.sendVideoAutoOverEvent();
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, VideoModelRsp videoModelRsp) {
                    DJXDramaCardView.this.mImgCover.setVisibility(8);
                    DJXDramaCardView.this.sendVideoAutoOverEvent();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoPauseResponse() {
        Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(this.mDramaDetail, null);
        DJXWidgetDramaCardParams dJXWidgetDramaCardParams = this.mWidgetParams;
        if (dJXWidgetDramaCardParams == null || dJXWidgetDramaCardParams.mListener == null) {
            return;
        }
        this.mWidgetParams.mListener.onDJXVideoPause(mapCreateParamsMap);
        LG.d(TAG, "onDJXVideoPause map = " + mapCreateParamsMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoContinueResponse() {
        Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(this.mDramaDetail, null);
        DJXWidgetDramaCardParams dJXWidgetDramaCardParams = this.mWidgetParams;
        if (dJXWidgetDramaCardParams == null || dJXWidgetDramaCardParams.mListener == null || this.mDramaDetail == null) {
            return;
        }
        this.mWidgetParams.mListener.onDJXVideoContinue(mapCreateParamsMap);
        LG.d(TAG, "onDJXVideoContinue map = " + mapCreateParamsMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopBySendLog(boolean z) {
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView != null) {
            dJXPlayerView.stop();
            if (z) {
                sendVideoAutoOverEvent();
            }
        }
    }

    public void start() {
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView != null) {
            dJXPlayerView.start();
        }
        DJXDrawCoverView dJXDrawCoverView = this.mImgCover;
        if (dJXDrawCoverView != null) {
            dJXDrawCoverView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DJXDramaCardView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (DJXDramaCardView.this.mIsVideoPrepared) {
                        return;
                    }
                    new BEDismissOuterLoadingEvent().send();
                    DJXDramaCardView.this.mImgCover.setVisibility(0);
                }
            }, 300L);
        }
    }

    public void pause() {
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView == null || !dJXPlayerView.isPlaying()) {
            return;
        }
        this.mPlayerView.pause();
    }

    public void stop() {
        stopBySendLog(true);
    }

    public Boolean isPlaying() {
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView != null) {
            return Boolean.valueOf(dJXPlayerView.isPlaying());
        }
        return null;
    }

    public void setMute(boolean z) {
        this.mSpeakerIcon.setSelected(z);
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView != null) {
            if (dJXPlayerView.isMute() != z) {
                this.mPlayerView.setMute(z);
            }
            this.mIsMute = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView == null || dJXPlayerView.isPlaying() || !this.mWidgetParams.mIsAutoPlay) {
            return;
        }
        start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView == null || !dJXPlayerView.isPlaying()) {
            return;
        }
        stop();
    }

    public void destroy() {
        DJXBus.getInstance().removeListener(this.mBusListener);
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView != null) {
            dJXPlayerView.setVideoListener(null);
            this.mPlayerView.release();
            this.mPlayerView.releaseRenderView();
        }
        DJXDrawCoverView dJXDrawCoverView = this.mImgCover;
        if (dJXDrawCoverView != null) {
            dJXDrawCoverView.setVisibility(8);
            this.mImgCover.setImageDrawable(null);
        }
    }

    public void reportShow(long j) {
        long jMax = Math.max(j, this.mMaxShowTime);
        this.mMaxShowTime = jMax;
        this.mReporter.clientShow(this.mDramaDetail, j, jMax);
    }
}
