package com.bytedance.sdk.djx.core.business.budrama.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.mobads.container.adrequest.g;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.rsp.VideoModelRsp;
import com.bytedance.sdk.djx.core.business.SpeedScopeType;
import com.bytedance.sdk.djx.core.business.budrama.DramaLog;
import com.bytedance.sdk.djx.core.business.budrama.DramaManager;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter;
import com.bytedance.sdk.djx.core.business.view.DJXDrawCoverView;
import com.bytedance.sdk.djx.core.business.view.DJXDrawLineBar;
import com.bytedance.sdk.djx.core.business.view.DJXDrawSeekLayout;
import com.bytedance.sdk.djx.core.business.view.DJXErrorView;
import com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerLayout2;
import com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerParam;
import com.bytedance.sdk.djx.core.business.view.controller.OnControllerClickListener;
import com.bytedance.sdk.djx.core.business.view.loading.DJXDmtLoadingLayout;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.util.ImageUtil;
import com.bytedance.sdk.djx.core.util.ThumbHelper;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import com.bytedance.sdk.djx.core.vod.DJXPlayerView;
import com.bytedance.sdk.djx.core.vod.IVideoListener;
import com.bytedance.sdk.djx.core.vod.IVideoService;
import com.bytedance.sdk.djx.core.vod.thumb.ThumbManager;
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.VideoM;
import com.bytedance.sdk.djx.model.ev.BEDetailVideoLoad;
import com.bytedance.sdk.djx.model.ev.BEDismissOuterLoadingEvent;
import com.bytedance.sdk.djx.model.ev.BESeekStart;
import com.bytedance.sdk.djx.model.ev.BEThumbCome;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.net.img.RequestCreator;
import com.bytedance.sdk.djx.net.io.ByteString;
import com.bytedance.sdk.djx.utils.AudioUtils;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;
import com.bytedance.sdk.djx.utils.service.ServiceManager;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class DramaDetailHolder extends DramaDetailHolderBase<DramaDetail> implements AudioUtils.IAudioFocusChangeListener {
    private static final int MAX_RETRY_TIMES = 1;
    public static final int MIN_SEEK_LENGTH = 15;
    public static final int SEEK_DRAG_HEIGHT = 24;
    private static final int SPEED_PLAY_1X = 1;
    private static final int SPEED_PLAY_2X = 2;
    private static final String TAG = "DramaDetailHolder";
    private final String mCategory;
    private final Map<String, Object> mCommonParams;
    private DJXDrawControllerLayout2 mControllerLayout;
    private FrameLayout mCustomViewLayout;
    private final DJXDramaDetailConfig mDetailConfig;
    private Drama mDrama;
    private TextView mDramaDesc;
    private DramaDetail mDramaDetail;
    private TextView mDramaTitle;
    private RelativeLayout mDramaTitleLayout;
    private final DramaDetailAdapter.OnDrawListener mDrawListener;
    private DJXErrorView mErrorView;
    private final String mFromCategory;
    private final String mFromGid;
    private ViewGroup mHolderContainer;
    private DJXDrawCoverView mImgCover;
    private Animation mImgCoverAnimation;
    private ImageView mImgPlay;
    private Animation mImgPlayAnimation;
    private DJXDrawLineBar mLineBar;
    private DJXDmtLoadingLayout mLoadingLayout;
    private String mPlaySource;
    private DJXPlayerView mPlayerView;
    private int mPosition;
    private DJXDrawSeekLayout mSeekLayout;
    private ImageView mSpeedPlaying;
    private long mStartTrackingTime;
    private float mPlaySpeed = 1.0f;
    private final DramaLog mDramaLog = new DramaLog();
    private int mCurrentRetry = 0;
    private int resumeDuration = -1;
    private long mMaxPassTime = 0;
    private long mLastOverTime = -1;
    private volatile boolean mIsVideoPrepared = false;
    private volatile boolean mIsPlayingBeforeInvisible = false;
    private boolean mIsPlaying = false;
    private boolean mHasPaused = false;
    private boolean mIsInSeeking = false;
    private boolean mIsThumbShow = false;
    private boolean mResumed = false;
    private boolean mLongClickSpeedPlayEnable = false;
    private final IBusListener mBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.1
        public void onBusEvent(BusEvent busEvent) {
            if (DramaDetailHolder.this.mIsInSeeking && (busEvent instanceof BEThumbCome)) {
                BEThumbCome bEThumbCome = (BEThumbCome) busEvent;
                if (!bEThumbCome.checkOK(DramaDetailHolder.this.mDramaDetail) || DramaDetailHolder.this.mSeekLayout == null) {
                    return;
                }
                DramaDetailHolder.this.mSeekLayout.setThumb(bEThumbCome.bitmap);
                DramaDetailHolder.this.mIsThumbShow = true;
            }
        }
    };
    private final IVideoListener mVideoListener = new IVideoListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.9
        @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
        public void onPrepared() {
            DramaDetailHolder.this.mIsVideoPrepared = true;
        }

        @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
        public void onRenderFirstFrame() {
            LG.d(DramaDetailHolder.TAG, "renderFirstFrame, index = " + DramaDetailHolder.this.mDramaDetail.getIndex());
            if (DramaDetailHolder.this.mLoadingLayout != null) {
                DramaDetailHolder.this.mLoadingLayout.setVisibility(4);
            }
            DramaDetailHolder.this.mDrawListener.onRenderFirstFrame();
            if (!DramaDetailHolder.this.mPlayerView.isStarted()) {
                DramaDetailHolder.this.mPlayerView.stop();
                return;
            }
            DramaDetailHolder.this.mDrawListener.onPlayStart(DramaDetailHolder.this.mDramaDetail);
            DramaDetailHolder.this.sendVideoPlayEvent();
            DramaDetailHolder.this.mHasPaused = false;
            DramaDetailHolder.this.mIsVideoPrepared = true;
            DramaDetailHolder.this.mLineBar.stopAnimation();
            DramaDetailHolder.this.mImgCover.clearAnimation();
            Animation imgCoverAnimation = DramaDetailHolder.this.getImgCoverAnimation();
            imgCoverAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.9.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DramaDetailHolder.this.mImgCover.setVisibility(8);
                    DramaDetailHolder.this.mImgCover.clearAnimation();
                }
            });
            DramaDetailHolder.this.mImgCover.startAnimation(imgCoverAnimation);
        }

        @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
        public void onError(int i, String str, Throwable th) {
            JSONObject original;
            boolean zIsErrorRetryable = ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).isErrorRetryable(i);
            try {
                VideoM videoModel = DramaDetailHolder.this.mDramaDetail.getVideoModel();
                String strString = null;
                if (videoModel != null && (original = videoModel.getOriginal()) != null) {
                    strString = ByteString.encodeUtf8(original.toString()).string(Charset.defaultCharset());
                }
                LG.i(DramaDetailHolder.TAG, "code = " + i + ", feed is null ? " + DramaDetailHolder.this.mDramaDetail + ", videoModel = " + videoModel + ", data = " + strString);
            } catch (Exception unused) {
            }
            if (!DramaDetailHolder.this.mDrawListener.isBlock(DramaDetailHolder.this.mDramaDetail) || DramaDetailHolder.this.mDramaDetail.getVideoModel() != null) {
                boolean z = DramaDetailHolder.this.mCurrentRetry < 1;
                if (!zIsErrorRetryable || !z) {
                    DramaDetailHolder.this.mErrorView.show(true);
                    DramaDetailHolder.this.sendVideoOverEvent();
                    return;
                }
                DramaDetailHolder.access$2608(DramaDetailHolder.this);
                if (!((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).isErrorCodec(i)) {
                    LG.i(DramaDetailHolder.TAG, "mCurrentRetry = " + DramaDetailHolder.this.mCurrentRetry + ", requestVideoWhenExpired()");
                    DramaDetailHolder.this.requestVideoWhenExpired();
                    return;
                }
                LG.d(DramaDetailHolder.TAG, "retry delay 500 by -499981");
                if (DramaDetailHolder.this.mErrorView != null) {
                    DramaDetailHolder.this.mErrorView.show(false);
                    DramaDetailHolder.this.mErrorView.postDelayed(DramaDetailHolder.this.mRetryBy499981, 500L);
                    return;
                }
                return;
            }
            LG.d(DramaDetailHolder.TAG, "IVideoListener onError by isBlock");
        }

        @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
        public void onCompletion() {
            DramaDetailHolder.this.mMaxPassTime = 2147483647L;
            Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(DramaDetailHolder.this.mDramaDetail, DramaDetailHolder.this.mDrama);
            if (DramaDetailHolder.this.mDetailConfig.getListener() != null) {
                DramaDetailHolder.this.mDetailConfig.getListener().onDJXVideoCompletion(mapCreateParamsMap);
                LG.d(DramaDetailHolder.TAG, "onDJXVideoCompletion map = " + mapCreateParamsMap);
            }
            DramaDetailHolder.this.mDrawListener.onVideoCompletion(false);
            DramaDetailHolder.this.mDramaLog.sendCompleteEvent(DramaDetailHolder.this.mDramaDetail, DramaManager.getInstance().getHistoryIndex(DramaDetailHolder.this.mDrama.id));
        }

        @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
        public void onInfo(int i, int i2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            if (i == -42) {
                DramaDetailHolder.this.onVideoPauseResponse();
                DramaDetailHolder.this.mHasPaused = true;
            } else if (i == -41 && DramaDetailHolder.this.mHasPaused) {
                DramaDetailHolder.this.onVideoContinueResponse();
            } else if (i == -40) {
                DramaDetailHolder.this.mIsVideoPrepared = false;
            }
        }

        @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
        public void onVideoSizeChanged(int i, int i2) {
            if (DramaDetailHolder.this.mImgCover != null) {
                DramaDetailHolder.this.mImgCover.setVideoSize(i, i2);
            }
        }

        @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
        public void onDurationChange(long j) {
            if (!DramaDetailHolder.this.mResumed) {
                DramaDetailHolder.this.pause3();
            }
            if (DramaDetailHolder.this.mMaxPassTime < j && DramaDetailHolder.this.mMaxPassTime != 2147483647L) {
                DramaDetailHolder.this.mMaxPassTime = j;
            }
            if (DramaDetailHolder.this.mSeekLayout != null) {
                DramaDetailHolder.this.mSeekLayout.setProgress(Long.valueOf(j).intValue());
            }
            if (DramaDetailHolder.this.mDetailConfig.getListener() != null) {
                DramaDetailHolder.this.mDetailConfig.getListener().onDurationChange(j);
            }
        }
    };
    private final Runnable mRetryBy499981 = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.10
        @Override // java.lang.Runnable
        public void run() {
            if (DramaDetailHolder.this.mErrorView != null) {
                DramaDetailHolder.this.mErrorView.performRetryClick();
            }
        }
    };

    public void lossTransientCanDuck() {
    }

    static /* synthetic */ int access$2608(DramaDetailHolder dramaDetailHolder) {
        int i = dramaDetailHolder.mCurrentRetry;
        dramaDetailHolder.mCurrentRetry = i + 1;
        return i;
    }

    public DramaDetailHolder(DramaDetailAdapter.OnDrawListener onDrawListener, DJXDramaDetailConfig dJXDramaDetailConfig, String str, Map<String, Object> map, String str2, String str3, String str4) {
        this.mPlaySource = ILogConst.PLAY_SOURCE_DEFAULT;
        this.mDetailConfig = dJXDramaDetailConfig;
        this.mDrawListener = onDrawListener;
        this.mCategory = str;
        this.mCommonParams = map;
        this.mFromCategory = str2;
        this.mFromGid = str3;
        this.mPlaySource = str4;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_item_drama_holder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    public void createHolder(DramaDetail dramaDetail, int i, View view) {
        this.mCurrentRetry = 0;
        this.mPosition = i;
        this.mMaxPassTime = 0L;
        this.mIsVideoPrepared = false;
        this.mIsPlaying = false;
        this.mHolderContainer = (ViewGroup) view.findViewById(R.id.djx_drama_container);
        this.mErrorView = (DJXErrorView) view.findViewById(R.id.djx_draw_item_error);
        this.mPlayerView = (DJXPlayerView) view.findViewById(R.id.djx_draw_item_player);
        this.mLineBar = (DJXDrawLineBar) view.findViewById(R.id.djx_draw_item_line_bar);
        this.mImgPlay = (ImageView) view.findViewById(R.id.djx_draw_item_play);
        this.mImgCover = (DJXDrawCoverView) view.findViewById(R.id.djx_draw_item_cover);
        this.mDramaTitleLayout = (RelativeLayout) view.findViewById(R.id.djx_drama_title_layout);
        this.mDramaTitle = (TextView) view.findViewById(R.id.djx_drama_title);
        this.mDramaDesc = (TextView) view.findViewById(R.id.djx_drama_desc);
        this.mCustomViewLayout = (FrameLayout) view.findViewById(R.id.djx_custom_view);
        this.mSpeedPlaying = (ImageView) view.findViewById(R.id.djx_draw_item_speed);
        DJXDrawSeekLayout dJXDrawSeekLayout = (DJXDrawSeekLayout) view.findViewById(R.id.djx_draw_item_seek_layout);
        this.mSeekLayout = dJXDrawSeekLayout;
        UIUtil.expandViewTouchDelegate(dJXDrawSeekLayout, UIUtil.dp2px(200.0f), UIUtil.dp2px(2.0f), 0, 0);
        this.mLoadingLayout = (DJXDmtLoadingLayout) view.findViewById(R.id.djx_loading_view);
        this.mSeekLayout.setSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (DramaDetailHolder.this.mIsInSeeking && DramaDetailHolder.this.isCanUseThumbFunction()) {
                    ThumbManager.getInstance().getThumb(DramaDetailHolder.this.mPlayerView.getThumbList(), DramaDetailHolder.this.mDramaDetail, seekBar.getProgress(), seekBar.getMax());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                new BESeekStart().setStart(true).send();
                DramaDetailHolder.this.mIsInSeeking = true;
                DramaDetailHolder.this.mIsThumbShow = false;
                DramaDetailHolder.this.hideUIBySeek(true);
                DramaDetailHolder.this.mStartTrackingTime = seekBar.getProgress();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                ThumbManager.getInstance().cancelTask(DramaDetailHolder.this.mDramaDetail);
                new BESeekStart().setStart(false).send();
                DramaDetailHolder.this.mIsInSeeking = false;
                DramaDetailHolder.this.hideUIBySeek(false);
                if (DramaDetailHolder.this.mIsVideoPrepared) {
                    DramaDetailHolder.this.start(false);
                    DramaDetailHolder.this.mPlayerView.seekTo(seekBar.getProgress());
                    if (DramaDetailHolder.this.mDrawListener.getCurrentPosition() == DramaDetailHolder.this.mPosition && DramaDetailHolder.this.mDetailConfig.getListener() != null) {
                        DramaDetailHolder.this.mDetailConfig.getListener().onDJXSeekTo(DramaDetailHolder.this.mPosition, seekBar.getProgress());
                    }
                }
                if (seekBar.getProgress() > (DramaDetailHolder.this.mPlayerView.getBufferedPercentage() / 100.0f) * seekBar.getMax() && !NetworkUtils.isActive(InnerManager.getContext())) {
                    ToastUtil.show(InnerManager.getContext(), seekBar.getResources().getString(R.string.djx_str_seek_net_tip));
                }
                DramaDetailHolder.this.mDramaLog.sendSeekBarStopTracking(DramaDetailHolder.this.mDramaDetail, DramaDetailHolder.this.mStartTrackingTime, seekBar.getProgress());
                if (DramaDetailHolder.this.mIsThumbShow) {
                    DramaDetailHolder.this.mIsThumbShow = false;
                    DramaDetailHolder.this.mDramaLog.sendThumbShow(DramaDetailHolder.this.mDramaDetail, DramaDetailHolder.this.mStartTrackingTime, seekBar.getProgress(), seekBar.getMax());
                }
            }
        });
        this.mControllerLayout = (DJXDrawControllerLayout2) view.findViewById(R.id.djx_draw_item_controller_layout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    public void bindHolder(boolean z, DramaDetail dramaDetail, int i, View view) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        super.bindHolder(z, (boolean) dramaDetail, i, view);
        DJXBus.getInstance().addListener(this.mBusListener);
        if (z) {
            this.mPlayerView.reset();
        }
        this.mDrama = dramaDetail.getDrama();
        this.mCurrentRetry = 0;
        this.mPosition = i;
        this.mMaxPassTime = 0L;
        this.mLastOverTime = -1L;
        this.mDramaLog.reset();
        this.mDramaLog.setParams(this.mCategory, this.mFromCategory, this.mFromGid, this.mCommonParams);
        this.mDramaLog.setDramaParams(this.mDetailConfig.getFreeSet());
        this.mDramaDetail = dramaDetail;
        this.mIsVideoPrepared = false;
        this.mIsPlaying = false;
        this.mIsInSeeking = false;
        this.mIsThumbShow = false;
        if (this.mDramaDetail.getVideoModel() != null) {
            this.mImgCover.setVideoSize(this.mDramaDetail.getVideoModel().getWidth(), this.mDramaDetail.getVideoModel().getHeight());
        }
        this.mErrorView.show(false);
        this.mImgPlay.clearAnimation();
        this.mImgCover.clearAnimation();
        this.mImgPlay.setVisibility(8);
        this.mImgCover.setVisibility(0);
        this.mLineBar.stopAnimation();
        this.mLoadingLayout.setVisibility(4);
        this.mDramaTitleLayout.setVisibility(this.mDetailConfig.isHideBottomInfo() ? 8 : 0);
        Drama drama = this.mDrama;
        if (drama != null) {
            RequestCreator requestCreatorConfig = Picasso.with(view.getContext()).load(ImageUtil.getVideoFrame(drama.coverImages2, this.mDramaDetail.getFirstCovers(), this.mDrama.coverImage)).tag("drama_detail").config(Bitmap.Config.RGB_565);
            VideoM videoModel = this.mDramaDetail.getVideoModel();
            if (videoModel != null && videoModel.getWidth() > 0 && videoModel.getHeight() > 0) {
                requestCreatorConfig.resize(videoModel.getWidth() / 2, videoModel.getHeight() / 2).centerCrop();
            }
            requestCreatorConfig.into(this.mImgCover);
        }
        setBottomOffset();
        this.mSeekLayout.setVisibility(dramaDetail.getVideoDuration() > 15 ? 0 : 8);
        this.mSeekLayout.setSeekEnabled(dramaDetail.getVideoDuration() > 15);
        this.mSeekLayout.showDragState(false);
        this.mSeekLayout.setMax(dramaDetail.getVideoDuration() * 1000);
        this.mSeekLayout.setProgress(Long.valueOf(this.mPlayerView.getCurrentPosition()).intValue());
        this.mSeekLayout.setDragHeight(24);
        this.mDramaTitle.setText(this.mDramaDetail.getSkitName());
        TextView textView = this.mDramaDesc;
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = this.mDramaDetail.getSkitName();
        objArr[1] = this.mDramaDetail.getStatus() == 0 ? "已完结" : "未完结";
        objArr[2] = Integer.valueOf(this.mDramaDetail.getSkitTotal());
        textView.setText(String.format(locale, "《%s》%s共%d集 | 选集 >", objArr));
        this.mDramaTitleLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DramaDetailHolder.this.mDrawListener.onClickDramaTitle(view2, DramaDetailHolder.this.mDramaDetail);
            }
        });
        this.mHolderContainer.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DramaDetailHolder.this.onSingleClick();
            }
        });
        this.mErrorView.setRetryListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Context context = InnerManager.getContext();
                if (!NetworkUtils.isActive(context)) {
                    ToastUtil.show(context, context.getString(R.string.djx_str_no_network_tip));
                    return;
                }
                new BEDetailVideoLoad(DramaDetailHolder.this.mPosition, true).send();
                DramaDetailHolder.this.mPlayerView.retryByInit();
                DramaDetailHolder dramaDetailHolder = DramaDetailHolder.this;
                dramaDetailHolder.setUrl(dramaDetailHolder.mDramaDetail.getVideoModel());
                DramaDetailHolder.this.start(true);
            }
        });
        new BEDetailVideoLoad(this.mPosition, false).send();
        this.mPlayerView.setVideoListener(this.mVideoListener);
        setUrl(this.mDramaDetail.getVideoModel());
        this.mCustomViewLayout.removeAllViews();
        if (this.mDetailConfig.getListener() != null) {
            View viewCreateCustomView = this.mDetailConfig.getListener().createCustomView(this.mCustomViewLayout, DramaDetailHelper.createParamsMap(this.mDramaDetail, this.mDrama));
            if (viewCreateCustomView != null) {
                this.mCustomViewLayout.addView(viewCreateCustomView);
                this.mCustomViewLayout.setVisibility(0);
            } else {
                this.mCustomViewLayout.setVisibility(8);
            }
        }
        if (z) {
            this.mControllerLayout.reset();
        }
        setupView(dramaDetail, false);
        getLifecycle().addObserver(this.mControllerLayout);
        this.mControllerLayout.setClickListener(new OnControllerClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.6
            @Override // com.bytedance.sdk.djx.core.business.view.controller.OnControllerClickListener
            public void onDoubleTab() {
            }

            @Override // com.bytedance.sdk.djx.core.business.view.controller.OnControllerClickListener
            public void stopLongClick() {
                if (DramaDetailHolder.this.mLongClickSpeedPlayEnable) {
                    DramaDetailHolder dramaDetailHolder = DramaDetailHolder.this;
                    dramaDetailHolder.longClick(dramaDetailHolder.mPlaySpeed);
                    DramaDetailHolder.this.mDramaLog.sendSpeedPlay(1.0f, DramaDetailHolder.this.mDramaDetail, DramaDetailHolder.this.mPlayerView.getCurrentPosition(), false, SpeedScopeType.LONG_PRESS);
                    DramaDetailHolder.this.mSpeedPlaying.setVisibility(8);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.view.controller.OnControllerClickListener
            public void startLongClick() {
                if (DramaDetailHolder.this.mPlayerView.isPlaying() && DramaDetailHolder.this.mLongClickSpeedPlayEnable) {
                    DramaDetailHolder.this.longClick(2.0f);
                    DramaDetailHolder.this.mDramaLog.sendSpeedPlay(2.0f, DramaDetailHolder.this.mDramaDetail, DramaDetailHolder.this.mPlayerView.getCurrentPosition(), true, SpeedScopeType.LONG_PRESS);
                    DramaDetailHolder.this.mSpeedPlaying.setVisibility(0);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.view.controller.OnControllerClickListener
            public void onSingleTab() {
                DramaDetailHolder.this.onSingleClick();
            }
        });
        if (this.mDetailConfig.isHideLikeButton() || this.mDetailConfig.isHideDoubleClick()) {
            this.mControllerLayout.setLikeAnimVisible(false);
        }
        if (this.mDetailConfig.ismHideLongClickSpeed() || !((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).isNewPlayer()) {
            return;
        }
        this.mLongClickSpeedPlayEnable = true;
        this.mControllerLayout.setLongClickSpeedPlayEnable(true);
    }

    private void setupView(DramaDetail dramaDetail, Boolean bool) {
        this.mControllerLayout.setWidgetParam(new DJXDrawControllerParam(this.mDetailConfig.isHideLikeButton(), this.mDetailConfig.isHideFavorButton()));
        this.mControllerLayout.setDramaDetail(dramaDetail);
        if (bool.booleanValue()) {
            this.mControllerLayout.updateUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSingleClick() {
        if (this.mIsVideoPrepared) {
            this.mImgPlay.clearAnimation();
            if (this.mPlayerView.isPlaying()) {
                this.mImgPlay.setVisibility(0);
                this.mImgPlay.startAnimation(getImgPlayAnimation());
                this.mPlayerView.pause();
                LG.d(TAG, "click to pause ");
                return;
            }
            this.mImgPlay.setVisibility(8);
            play();
            LG.d(TAG, "click to start ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void longClick(float f) {
        this.mPlayerView.setSpeed(f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    public void updateHolder(DramaDetail dramaDetail, int i) {
        this.mDrama = dramaDetail.getDrama();
        this.mPosition = i;
        this.mDramaDetail = dramaDetail;
        setupView(dramaDetail, true);
    }

    private void setBottomOffset() {
        int iDp2px = UIUtil.dp2px(DJXDramaDetailFragment.getBottomOffset(this.mDetailConfig.getBottomOffset()));
        if (iDp2px < 0) {
            iDp2px = 0;
        }
        int iMin = Math.min(iDp2px, UIUtil.getScreenHeight(InnerManager.getContext()) / 2);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mDramaTitleLayout.getLayoutParams();
        marginLayoutParams.bottomMargin = UIUtil.dp2px(54.0f) + iMin;
        this.mDramaTitleLayout.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mSeekLayout.getLayoutParams();
        marginLayoutParams2.bottomMargin = iMin;
        this.mSeekLayout.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.mLineBar.getLayoutParams();
        marginLayoutParams3.bottomMargin = iMin;
        this.mLineBar.setLayoutParams(marginLayoutParams3);
        int iDp2px2 = UIUtil.dp2px(24.0f);
        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.mControllerLayout.getLayoutParams();
        marginLayoutParams4.bottomMargin = iMin + iDp2px2;
        this.mControllerLayout.setLayoutParams(marginLayoutParams4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideUIBySeek(boolean z) {
        if (z) {
            this.mImgPlay.setVisibility(8);
            this.mDramaTitleLayout.setVisibility(8);
            this.mControllerLayout.setVisibility(8);
        } else {
            if (!this.mDetailConfig.isHideBottomInfo()) {
                this.mDramaTitleLayout.setVisibility(0);
            }
            this.mControllerLayout.setVisibility(0);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    protected void destroy() {
        super.destroy();
        DJXBus.getInstance().removeListener(this.mBusListener);
        getLifecycle().removeObserver(this.mControllerLayout);
        AudioUtils.getInstance().removeFocusChangeListener(this);
        DJXErrorView dJXErrorView = this.mErrorView;
        if (dJXErrorView != null) {
            dJXErrorView.removeCallbacks(this.mRetryBy499981);
        }
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView != null) {
            dJXPlayerView.setVideoListener(null);
            this.mPlayerView.release();
            this.mPlayerView.releaseRenderView();
        }
        ImageView imageView = this.mImgPlay;
        if (imageView != null) {
            imageView.clearAnimation();
            this.mImgPlay.setVisibility(8);
        }
        DJXDrawCoverView dJXDrawCoverView = this.mImgCover;
        if (dJXDrawCoverView != null) {
            dJXDrawCoverView.clearAnimation();
            this.mImgCover.setVisibility(8);
            this.mImgCover.setImageDrawable(null);
        }
        DJXDrawLineBar dJXDrawLineBar = this.mLineBar;
        if (dJXDrawLineBar != null) {
            dJXDrawLineBar.onDestroyView();
        }
        DJXDmtLoadingLayout dJXDmtLoadingLayout = this.mLoadingLayout;
        if (dJXDmtLoadingLayout != null) {
            dJXDmtLoadingLayout.setVisibility(4);
        }
        DJXDrawControllerLayout2 dJXDrawControllerLayout2 = this.mControllerLayout;
        if (dJXDrawControllerLayout2 != null) {
            dJXDrawControllerLayout2.setClickListener(null);
        }
    }

    private Animation getImgPlayAnimation() {
        if (this.mImgPlayAnimation == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.mImgPlayAnimation = scaleAnimation;
            scaleAnimation.setFillAfter(true);
            this.mImgPlayAnimation.setDuration(150L);
            this.mImgPlayAnimation.setInterpolator(new AccelerateInterpolator());
        }
        return this.mImgPlayAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getImgCoverAnimation() {
        if (this.mImgCoverAnimation == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.mImgCoverAnimation = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.mImgCoverAnimation.setDuration(300L);
        }
        return this.mImgCoverAnimation;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolderBase, com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderShow() {
        super.onHolderShow();
        LG.d(TAG, "onHolderShow");
        this.mResumed = true;
        boolean zIsBlock = this.mDrawListener.isBlock(this.mDramaDetail);
        if (zIsBlock) {
            this.mDrawListener.unlockFlowStart(this.mDramaDetail);
        } else {
            AudioUtils.getInstance().addFocusChangeListener(this);
            startBySendLog();
        }
        BLogAgent.build(this.mCategory, ILogConst.E_SKIT_AD_CHECK, null).putInt("need_block", zIsBlock ? 1 : 0).putString(g.o, this.mDramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putString("from_gid", this.mFromGid).putLong(ILogConst.Keys.KEY_SKIT_ID, this.mDramaDetail.getSkitId()).send();
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolderBase, com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderPause() {
        super.onHolderPause();
        LG.d(TAG, "onHolderPause");
        this.mResumed = false;
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView != null) {
            this.mIsPlayingBeforeInvisible = dJXPlayerView.isStarted();
        } else {
            this.mIsPlayingBeforeInvisible = true;
        }
        pause3();
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolderBase, com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderStop() {
        super.onHolderStop();
        this.mResumed = false;
        AudioUtils.getInstance().removeFocusChangeListener(this);
        pause2();
        this.mHasPaused = false;
        this.mLastOverTime = -1L;
        this.mIsInSeeking = false;
        this.mIsThumbShow = false;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolderBase, com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderResume() {
        super.onHolderResume();
        this.mResumed = true;
        if (this.mIsPlayingBeforeInvisible) {
            resume();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolderBase
    public DramaDetail getData() {
        return this.mDramaDetail;
    }

    public void startBySendLog() {
        this.mDramaLog.reset();
        start(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(boolean z) {
        DJXDmtLoadingLayout dJXDmtLoadingLayout;
        if (this.mResumed) {
            this.mIsPlaying = true;
            this.mImgPlay.clearAnimation();
            this.mImgPlay.setVisibility(8);
            this.mErrorView.show(false);
            play();
            this.mLineBar.postDelayed(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.7
                @Override // java.lang.Runnable
                public void run() {
                    if (DramaDetailHolder.this.mIsVideoPrepared) {
                        return;
                    }
                    DramaDetailHolder.this.mLineBar.startAnimation();
                }
            }, 300L);
            if (!z || (dJXDmtLoadingLayout = this.mLoadingLayout) == null) {
                return;
            }
            dJXDmtLoadingLayout.postDelayed(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.8
                @Override // java.lang.Runnable
                public void run() {
                    if (DramaDetailHolder.this.mIsVideoPrepared) {
                        return;
                    }
                    new BEDismissOuterLoadingEvent().send();
                    DramaDetailHolder.this.mLoadingLayout.setVisibility(0);
                }
            }, 300L);
        }
    }

    private void pause2() {
        sendVideoOverEvent();
        this.mIsPlaying = false;
        this.mPlayerView.stop();
        this.mImgPlay.clearAnimation();
        this.mImgCover.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pause3() {
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView != null) {
            if (dJXPlayerView.isPlaying() || this.mIsPlaying) {
                this.mPlayerView.pause();
                this.mIsPlaying = false;
                LG.i(TAG, "pause3 mIsPlaying = false");
                this.mImgPlay.clearAnimation();
                this.mImgCover.clearAnimation();
            }
        }
    }

    private void resume() {
        if (this.mPlayerView == null || this.mImgPlay.isShown()) {
            return;
        }
        start(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVideoPlayEvent() {
        if (this.mDramaLog.sendPlayEvent(this.mDramaDetail, this.mDrawListener.isRefreshFirst(), this.mPlaySource)) {
            Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(this.mDramaDetail, this.mDrama);
            if (this.mDetailConfig.getListener() != null) {
                this.mDetailConfig.getListener().onDJXVideoPlay(mapCreateParamsMap);
                LG.d(TAG, "onDJXVideoPlay map = " + mapCreateParamsMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVideoOverEvent() {
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
        long j3 = duration != 0 ? j2 : 0L;
        int iMin = Math.min(Float.valueOf((duration == 0 ? 0.0f : this.mMaxPassTime / duration) * 100.0f).intValue(), 100);
        this.mDramaLog.sendRecVideoDuration(this.mDramaDetail, j3, iMin, this.mDrawListener.getSourceRecMap());
        if (this.mDramaLog.sendOverEvent(this.mDramaDetail, this.mDrawListener.isRefreshFirst(), j3, iMin, this.mPlaySource, this.mPlayerView)) {
            Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(this.mDramaDetail, this.mDrama);
            if (this.mDetailConfig.getListener() != null) {
                this.mDetailConfig.getListener().onDJXVideoOver(mapCreateParamsMap);
                LG.d(TAG, "onDJXVideoOver map = " + mapCreateParamsMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestVideoWhenExpired() {
        DramaDetail dramaDetail = this.mDramaDetail;
        if (dramaDetail == null || dramaDetail.getVideoId() == null) {
            this.mErrorView.show(true);
            sendVideoOverEvent();
        } else {
            ApiManager.getInstance().videoModel(this.mDetailConfig.getFreeSet(), this.mDramaDetail.getGroupId(), this.mDramaDetail.getSkitId(), this.mDramaDetail.getVideoId(), new IApiCallback<VideoModelRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolder.11
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(VideoModelRsp videoModelRsp) {
                    try {
                        VideoM data = videoModelRsp.getData();
                        if (DramaDetailHolder.this.mDramaDetail != null && data != null && data.getVideoId() != null && data.getOriginal() != null && (DramaDetailHolder.this.mDramaDetail.getVideoModel() == null || TextUtils.isEmpty(DramaDetailHolder.this.mDramaDetail.getVideoModel().getVideoId()) || data.getVideoId().equals(DramaDetailHolder.this.mDramaDetail.getVideoModel().getVideoId()))) {
                            DramaDetailHolder.this.mDramaDetail.setVideoModel(data);
                            new BEDetailVideoLoad(DramaDetailHolder.this.mPosition, true).send();
                            DramaDetailHolder.this.mPlayerView.retryByInit();
                            DramaDetailHolder dramaDetailHolder = DramaDetailHolder.this;
                            dramaDetailHolder.setUrl(dramaDetailHolder.mDramaDetail.getVideoModel());
                            DramaDetailHolder.this.mErrorView.show(false);
                            DramaDetailHolder.this.start(false);
                            DramaDetailHolder.this.mDrawListener.onVideoModelExpired(data);
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                    DramaDetailHolder.this.mErrorView.show(true);
                    DramaDetailHolder.this.sendVideoOverEvent();
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, VideoModelRsp videoModelRsp) {
                    DramaDetailHolder.this.mErrorView.show(true);
                    DramaDetailHolder.this.sendVideoOverEvent();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoPauseResponse() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        this.mSeekLayout.showDragState(true);
        this.mDramaLog.sendPauseEvent(this.mDramaDetail);
        Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(this.mDramaDetail, this.mDrama);
        if (this.mDetailConfig.getListener() != null) {
            this.mDetailConfig.getListener().onDJXVideoPause(mapCreateParamsMap);
            LG.d(TAG, "onDJXVideoPause map = " + mapCreateParamsMap);
        }
        sendVideoOverEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoContinueResponse() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        this.mSeekLayout.showDragState(false);
        this.mDramaLog.sendContinueEvent(this.mDramaDetail);
        Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(this.mDramaDetail, this.mDrama);
        if (this.mDetailConfig.getListener() == null || this.mDramaDetail == null) {
            return;
        }
        this.mDetailConfig.getListener().onDJXVideoContinue(mapCreateParamsMap);
        LG.d(TAG, "onDJXVideoContinue map = " + mapCreateParamsMap);
    }

    public void seekTo(long j) {
        if (this.mIsVideoPrepared) {
            start(false);
            this.mPlayerView.seekTo(j);
        }
    }

    public void setResumeDuration(int i) {
        this.resumeDuration = i;
    }

    public void setSpeed(float f, SpeedScopeType speedScopeType) {
        this.mPlaySpeed = f;
        this.mPlayerView.setSpeed(f);
        this.mDramaLog.sendSpeedPlay(f, this.mDramaDetail, this.mPlayerView.getCurrentPosition(), true, speedScopeType);
    }

    public void play() {
        if (!this.mPlayerView.hasVideoModel() && this.mDramaDetail.getVideoModel() != null) {
            setUrl(this.mDramaDetail.getVideoModel());
        }
        int i = this.resumeDuration;
        if (i >= 0) {
            if (i >= this.mDramaDetail.getVideoDuration() * 1000) {
                this.resumeDuration = 0;
            }
            this.mPlayerView.setStartTime(this.resumeDuration);
            this.resumeDuration = -1;
        }
        this.mPlayerView.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(VideoM videoM) {
        if (videoM != null) {
            this.mPlayerView.setUrl(videoM);
        }
    }

    public void gain() {
        if (this.mPlayerView.isPlaying() || !this.mResumed) {
            return;
        }
        this.mImgPlay.clearAnimation();
        this.mImgPlay.setVisibility(8);
        play();
    }

    public void loss() {
        if (this.mPlayerView.isPlaying()) {
            this.mImgPlay.setVisibility(0);
            this.mImgPlay.startAnimation(getImgPlayAnimation());
            this.mPlayerView.pause();
        }
    }

    public void lossTransient() {
        if (this.mPlayerView.isPlaying()) {
            this.mPlayerView.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCanUseThumbFunction() {
        return ThumbHelper.isThumbCanEnable();
    }
}
