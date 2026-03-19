package com.bytedance.sdk.djx.core.business.budrama.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.rsp.VideoModelRsp;
import com.bytedance.sdk.djx.core.business.SpeedScopeType;
import com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHelper;
import com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2;
import com.bytedance.sdk.djx.core.business.reporter.DramaReporter;
import com.bytedance.sdk.djx.core.business.view.DJXDrawCoverView;
import com.bytedance.sdk.djx.core.business.view.DJXDrawLineBar;
import com.bytedance.sdk.djx.core.business.view.DJXDrawSeekLayout;
import com.bytedance.sdk.djx.core.business.view.DJXErrorView;
import com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerLayout2;
import com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerParam;
import com.bytedance.sdk.djx.core.business.view.controller.OnControllerClickListener;
import com.bytedance.sdk.djx.core.business.view.loading.DJXDmtLoadingLayout;
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
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.model.VideoM;
import com.bytedance.sdk.djx.model.ev.BEDismissOuterLoadingEvent;
import com.bytedance.sdk.djx.model.ev.BEDrawVideoLoad;
import com.bytedance.sdk.djx.model.ev.BESeekStart;
import com.bytedance.sdk.djx.model.ev.BEThumbCome;
import com.bytedance.sdk.djx.net.ImageTag;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.net.img.RequestCreator;
import com.bytedance.sdk.djx.net.io.ByteString;
import com.bytedance.sdk.djx.params.DJXWidgetDramaDetailParams;
import com.bytedance.sdk.djx.params.DJXWidgetDrawParams;
import com.bytedance.sdk.djx.utils.AudioUtils;
import com.bytedance.sdk.djx.utils.DeviceUtils;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.djx.utils.WeakHandler;
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
public class DrawHolderDrama extends LifecycleHolderBase<Feed> implements AudioUtils.IAudioFocusChangeListener, WeakHandler.IHandler {
    private static final int MAX_RETRY_TIMES = 1;
    public static final int SEEK_DRAG_HEIGHT = 24;
    private static final int SPEED_PLAY_1X = 1;
    private static final int SPEED_PLAY_2X = 2;
    private static final String TAG = "DrawHolderDrama";
    private final IBusListener mBusListener;
    private final String mCategory;
    private final DrawAdapter2.OnClickDrawListener mClickDrawListener;
    private final Map<String, Object> mCommonParams;
    private DJXDrawControllerLayout2 mControllerLayout;
    private int mCurrentRetry;
    private FrameLayout mCustomViewLayout;
    private Drama mDrama;
    private TextView mDramaDescHintView;
    private View mDramaEnterBg;
    private View mDramaEnterBtn;
    private ConstraintLayout mDramaEnterLayout;
    private TextView mDramaIndexHintView;
    private ConstraintLayout mDramaInfoLayout;
    private boolean mDramaTipsShown;
    private TextView mDramaTitleHintView;
    private final DrawLog mDrawLog;
    private DJXErrorView mErrorView;
    private final String mFeatureValues;
    private Feed mFeed;
    private final WeakHandler mHandler;
    private boolean mHasPaused;
    private ViewGroup mHolderContainer;
    private TextView mIcpTipsView;
    private DJXDrawCoverView mImgCover;
    private Animation mImgCoverAnimation;
    private ImageView mImgPlay;
    private Animation mImgPlayAnimation;
    private boolean mIsInSeeking;
    private boolean mIsPlaying;
    private boolean mIsThumbShow;
    private volatile boolean mIsVideoPrepared;
    private long mLastOverTime;
    private DJXDrawLineBar mLineBar;
    private DJXDmtLoadingLayout mLoadingLayout;
    private boolean mLongClickSpeedPlayEnable;
    private long mMaxPassTime;
    private float mPlaySpeed = 1.0f;
    private DJXPlayerView mPlayerView;
    private int mPosition;
    private boolean mResumed;
    private final Runnable mRetryBy499981;
    private TextView mScriptTipsView;
    private DJXDrawSeekLayout mSeekLayout;
    private ImageView mSpeedView;
    private long mStartTrackingTime;
    private final Runnable mTipsAction;
    private final IVideoListener mVideoListener;
    private final DJXWidgetDrawParams mWidgetDrawParams;

    public void handleMsg(Message message) {
    }

    public void lossTransientCanDuck() {
    }

    static /* synthetic */ int access$3308(DrawHolderDrama drawHolderDrama) {
        int i = drawHolderDrama.mCurrentRetry;
        drawHolderDrama.mCurrentRetry = i + 1;
        return i;
    }

    DrawHolderDrama(DrawAdapter2.OnClickDrawListener onClickDrawListener, DJXWidgetDrawParams dJXWidgetDrawParams, String str, Map<String, Object> map, String str2) {
        DrawLog drawLog = new DrawLog();
        this.mDrawLog = drawLog;
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mCurrentRetry = 0;
        this.mIsVideoPrepared = false;
        this.mIsPlaying = false;
        this.mHasPaused = false;
        this.mMaxPassTime = 0L;
        this.mLastOverTime = -1L;
        this.mDramaTipsShown = false;
        this.mResumed = false;
        this.mIsInSeeking = false;
        this.mIsThumbShow = false;
        this.mLongClickSpeedPlayEnable = false;
        this.mBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.1
            public void onBusEvent(BusEvent busEvent) {
                if (DrawHolderDrama.this.mIsInSeeking && (busEvent instanceof BEThumbCome)) {
                    BEThumbCome bEThumbCome = (BEThumbCome) busEvent;
                    if (!bEThumbCome.checkOK(DrawHolderDrama.this.mDrama) || DrawHolderDrama.this.mSeekLayout == null) {
                        return;
                    }
                    DrawHolderDrama.this.mSeekLayout.setThumb(bEThumbCome.bitmap);
                    DrawHolderDrama.this.mIsThumbShow = true;
                }
            }
        };
        this.mTipsAction = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.7
            @Override // java.lang.Runnable
            public void run() {
                if (DrawHolderDrama.this.mScriptTipsView != null) {
                    DrawHolderDrama.this.mScriptTipsView.setVisibility(8);
                }
                if (DrawHolderDrama.this.mIcpTipsView != null) {
                    DrawHolderDrama.this.mIcpTipsView.setVisibility(8);
                }
                DrawHolderDrama.this.mDramaTipsShown = true;
            }
        };
        this.mVideoListener = new IVideoListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.10
            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onPrepared() {
                DrawHolderDrama.this.mIsVideoPrepared = true;
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onRenderFirstFrame() {
                LG.d(DrawHolderDrama.TAG, "renderFirstFrame, index = " + DrawHolderDrama.this.mDrama.index);
                if (!DrawHolderDrama.this.mDramaTipsShown) {
                    if (!TextUtils.isEmpty(DrawHolderDrama.this.mDrama.scriptAuthor) && !TextUtils.isEmpty(DrawHolderDrama.this.mDrama.scriptName)) {
                        DrawHolderDrama.this.mScriptTipsView.setVisibility(0);
                    }
                    if (!TextUtils.isEmpty(DrawHolderDrama.this.mDrama.icpNumber)) {
                        DrawHolderDrama.this.mIcpTipsView.setVisibility(0);
                    }
                    DrawHolderDrama.this.mHandler.postDelayed(DrawHolderDrama.this.mTipsAction, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                }
                if (DrawHolderDrama.this.mLoadingLayout != null) {
                    DrawHolderDrama.this.mLoadingLayout.setVisibility(4);
                }
                if (DrawHolderDrama.this.mClickDrawListener != null) {
                    DrawHolderDrama.this.mClickDrawListener.onRenderFirstFrame();
                }
                if (!DrawHolderDrama.this.mIsPlaying) {
                    DrawHolderDrama.this.mPlayerView.stop();
                    return;
                }
                if (DrawHolderDrama.this.mClickDrawListener != null) {
                    DrawHolderDrama.this.mClickDrawListener.onPlayStart(DrawHolderDrama.this.mFeed);
                }
                DrawHolderDrama.this.sendVideoPlayEvent();
                DrawHolderDrama.this.mHasPaused = false;
                DrawHolderDrama.this.mIsVideoPrepared = true;
                DrawHolderDrama.this.mLineBar.stopAnimation();
                DrawHolderDrama.this.mImgCover.clearAnimation();
                Animation imgCoverAnimation = DrawHolderDrama.this.getImgCoverAnimation();
                imgCoverAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.10.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        DrawHolderDrama.this.mImgCover.setVisibility(8);
                        DrawHolderDrama.this.mImgCover.clearAnimation();
                    }
                });
                DrawHolderDrama.this.mImgCover.startAnimation(imgCoverAnimation);
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onError(int i, String str3, Throwable th) {
                JSONObject original;
                boolean zIsErrorRetryable = ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).isErrorRetryable(i);
                try {
                    VideoM videoModel = DrawHolderDrama.this.mFeed.getVideoModel();
                    String strString = null;
                    if (videoModel != null && (original = videoModel.getOriginal()) != null) {
                        strString = ByteString.encodeUtf8(original.toString()).string(Charset.defaultCharset());
                    }
                    LG.i(DrawHolderDrama.TAG, "code = " + i + ", feed is null ? " + DrawHolderDrama.this.mFeed + ", videoModel = " + videoModel + ", data = " + strString);
                } catch (Exception unused) {
                }
                boolean z = DrawHolderDrama.this.mCurrentRetry < 1;
                if (!zIsErrorRetryable || !z) {
                    DrawHolderDrama.this.mErrorView.show(true);
                    DrawHolderDrama.this.sendVideoOverEvent();
                    return;
                }
                DrawHolderDrama.access$3308(DrawHolderDrama.this);
                if (!((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).isErrorCodec(i)) {
                    LG.i(DrawHolderDrama.TAG, "mCurrentRetry = " + DrawHolderDrama.this.mCurrentRetry + ", requestVideoWhenExpired()");
                    DrawHolderDrama.this.requestVideoWhenExpired();
                    return;
                }
                LG.d(DrawHolderDrama.TAG, "retry delay 500 by -499981");
                if (DrawHolderDrama.this.mErrorView != null) {
                    DrawHolderDrama.this.mErrorView.show(false);
                    DrawHolderDrama.this.mErrorView.postDelayed(DrawHolderDrama.this.mRetryBy499981, 500L);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onCompletion() {
                DrawHolderDrama.this.mMaxPassTime = 2147483647L;
                Map<String, Object> mapCreateParamsMap = DrawHolderDrama.createParamsMap(DrawHolderDrama.this.mFeed, DrawHolderDrama.this.mDrama);
                if (DrawHolderDrama.this.mWidgetDrawParams.mListener != null) {
                    DrawHolderDrama.this.mWidgetDrawParams.mListener.onDJXVideoCompletion(mapCreateParamsMap);
                    LG.d(DrawHolderDrama.TAG, "onDJXVideoCompletion map = " + mapCreateParamsMap);
                }
                if (DrawHolderDrama.this.mClickDrawListener != null) {
                    DrawHolderDrama.this.mClickDrawListener.onVideoCompletion(false);
                }
                DrawHolderDrama.this.mDrawLog.sendCompleteEvent(DrawHolderDrama.this.mFeed, DrawHolderDrama.this.mDrama);
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onInfo(int i, int i2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                if (i == -42) {
                    DrawHolderDrama.this.onVideoPauseResponse();
                    DrawHolderDrama.this.mHasPaused = true;
                } else if (i == -41 && DrawHolderDrama.this.mHasPaused) {
                    DrawHolderDrama.this.onVideoContinueResponse();
                } else if (i == -40) {
                    DrawHolderDrama.this.mIsVideoPrepared = false;
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onVideoSizeChanged(int i, int i2) {
                if (DrawHolderDrama.this.mImgCover != null) {
                    DrawHolderDrama.this.mImgCover.setVideoSize(i, i2);
                }
            }

            @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
            public void onDurationChange(long j) {
                if (DrawHolderDrama.this.mMaxPassTime < j && DrawHolderDrama.this.mMaxPassTime != 2147483647L) {
                    DrawHolderDrama.this.mMaxPassTime = j;
                }
                if (DrawHolderDrama.this.mSeekLayout != null) {
                    DrawHolderDrama.this.mSeekLayout.setProgress(Long.valueOf(j).intValue());
                }
                if (DrawHolderDrama.this.mWidgetDrawParams.mListener != null) {
                    DrawHolderDrama.this.mWidgetDrawParams.mListener.onDurationChange(j);
                }
            }
        };
        this.mRetryBy499981 = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.12
            @Override // java.lang.Runnable
            public void run() {
                if (DrawHolderDrama.this.mErrorView != null) {
                    DrawHolderDrama.this.mErrorView.performRetryClick();
                }
            }
        };
        this.mClickDrawListener = onClickDrawListener;
        this.mWidgetDrawParams = dJXWidgetDrawParams;
        this.mCategory = str;
        this.mCommonParams = map;
        this.mFeatureValues = str2;
        drawLog.setParams(str, map, str2);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_item_drama_holder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    public void createHolder(Feed feed, int i, View view) {
        this.mPosition = i;
        this.mFeed = feed;
        this.mDrama = feed.getDrama();
        this.mCurrentRetry = 0;
        this.mIsVideoPrepared = false;
        this.mIsPlaying = false;
        this.mMaxPassTime = 0L;
        this.mHolderContainer = (ViewGroup) view.findViewById(R.id.djx_drama_container);
        this.mErrorView = (DJXErrorView) view.findViewById(R.id.djx_draw_item_error);
        this.mPlayerView = (DJXPlayerView) view.findViewById(R.id.djx_draw_item_player);
        this.mSpeedView = (ImageView) view.findViewById(R.id.djx_draw_item_speed);
        this.mLineBar = (DJXDrawLineBar) view.findViewById(R.id.djx_draw_item_line_bar);
        this.mImgPlay = (ImageView) view.findViewById(R.id.djx_draw_item_play);
        this.mImgCover = (DJXDrawCoverView) view.findViewById(R.id.djx_draw_item_cover);
        this.mDramaInfoLayout = (ConstraintLayout) view.findViewById(R.id.djx_drama_info_layout);
        this.mDramaEnterLayout = (ConstraintLayout) view.findViewById(R.id.djx_drama_enter_layout);
        this.mCustomViewLayout = (FrameLayout) view.findViewById(R.id.djx_custom_view);
        DJXDrawSeekLayout dJXDrawSeekLayout = (DJXDrawSeekLayout) view.findViewById(R.id.djx_draw_item_seek_layout);
        this.mSeekLayout = dJXDrawSeekLayout;
        dJXDrawSeekLayout.setSeekBarStyle(this.mWidgetDrawParams.mProgressBarStyle);
        this.mSeekLayout.setSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (DrawHolderDrama.this.mIsInSeeking && DrawHolderDrama.this.isCanUseThumbFunction()) {
                    ThumbManager.getInstance().getThumb(DrawHolderDrama.this.mPlayerView.getThumbList(), DrawHolderDrama.this.mFeed != null ? DrawHolderDrama.this.mFeed.getDramaDetail() : null, seekBar.getProgress(), seekBar.getMax());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                new BESeekStart().setStart(true).send();
                DrawHolderDrama.this.mIsInSeeking = true;
                DrawHolderDrama.this.mIsThumbShow = false;
                DrawHolderDrama.this.hideUIBySeek(true);
                DrawHolderDrama.this.mStartTrackingTime = seekBar.getProgress();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                new BESeekStart().setStart(false).send();
                DrawHolderDrama.this.mIsInSeeking = false;
                DrawHolderDrama.this.hideUIBySeek(false);
                if (DrawHolderDrama.this.mIsVideoPrepared) {
                    DrawHolderDrama.this.start(false);
                    DrawHolderDrama.this.mPlayerView.seekTo(seekBar.getProgress());
                    if (DrawHolderDrama.this.mClickDrawListener != null && DrawHolderDrama.this.mClickDrawListener.getCurrentPosition() == DrawHolderDrama.this.mPosition && DrawHolderDrama.this.mWidgetDrawParams.mListener != null) {
                        DrawHolderDrama.this.mWidgetDrawParams.mListener.onDJXSeekTo(DrawHolderDrama.this.mPosition, seekBar.getProgress());
                    }
                }
                if (seekBar.getProgress() > (DrawHolderDrama.this.mPlayerView.getBufferedPercentage() / 100.0f) * seekBar.getMax() && !NetworkUtils.isActive(InnerManager.getContext())) {
                    ToastUtil.show(InnerManager.getContext(), seekBar.getResources().getString(R.string.djx_str_seek_net_tip));
                }
                DrawHolderDrama.this.mDrawLog.sendSeekBarStopTracking(DrawHolderDrama.this.mFeed, DrawHolderDrama.this.mStartTrackingTime, seekBar.getProgress());
                if (DrawHolderDrama.this.mIsThumbShow) {
                    DrawHolderDrama.this.mIsThumbShow = false;
                    DrawHolderDrama.this.mDrawLog.sendThumbShow(DrawHolderDrama.this.mFeed, DrawHolderDrama.this.mStartTrackingTime, seekBar.getProgress(), seekBar.getMax());
                }
            }
        });
        this.mLoadingLayout = (DJXDmtLoadingLayout) view.findViewById(R.id.djx_loading_view);
        this.mScriptTipsView = (TextView) view.findViewById(R.id.djx_script_tips);
        this.mIcpTipsView = (TextView) view.findViewById(R.id.djx_icp_tips);
        this.mDramaTitleHintView = (TextView) view.findViewById(R.id.djx_drama_title_hint);
        this.mDramaIndexHintView = (TextView) view.findViewById(R.id.djx_drama_index_hint);
        this.mDramaDescHintView = (TextView) view.findViewById(R.id.djx_drama_desc_hint);
        this.mDramaEnterBtn = view.findViewById(R.id.djx_drama_enter_btn);
        this.mDramaEnterBg = view.findViewById(R.id.djx_enter_bg);
        this.mControllerLayout = (DJXDrawControllerLayout2) view.findViewById(R.id.djx_draw_item_controller_layout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    public void bindHolder(boolean z, final Feed feed, int i, View view) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        super.bindHolder(z, (boolean) feed, i, view);
        DJXBus.getInstance().addListener(this.mBusListener);
        if (z) {
            this.mPlayerView.reset();
        }
        this.mPosition = i;
        this.mFeed = feed;
        this.mCurrentRetry = 0;
        this.mIsVideoPrepared = false;
        this.mIsPlaying = false;
        this.mIsInSeeking = false;
        this.mIsThumbShow = false;
        this.mMaxPassTime = 0L;
        this.mLastOverTime = -1L;
        this.mDrawLog.reset();
        this.mDrawLog.setParams(this.mCategory, this.mCommonParams, this.mFeatureValues);
        this.mDrama = this.mFeed.getDrama();
        if (this.mFeed.getVideoModel() != null) {
            this.mImgCover.setVideoSize(this.mFeed.getVideoModel().getWidth(), this.mFeed.getVideoModel().getHeight());
        }
        this.mErrorView.show(false);
        this.mImgPlay.clearAnimation();
        this.mImgCover.clearAnimation();
        this.mImgPlay.setVisibility(8);
        this.mImgCover.setVisibility(0);
        this.mLineBar.stopAnimation();
        this.mLoadingLayout.setVisibility(4);
        if (this.mDrama != null) {
            RequestCreator requestCreatorConfig = Picasso.with(view.getContext()).load(ImageUtil.getVideoFrame(this.mDrama.coverImages2, this.mFeed.getDramaDetail() != null ? this.mFeed.getDramaDetail().getFirstCovers() : null, this.mDrama.coverImage)).tag(ImageTag.TAG_DRAW_VIDEO).config(Bitmap.Config.RGB_565);
            VideoM videoModel = this.mFeed.getVideoModel();
            if (videoModel != null && videoModel.getWidth() > 0 && videoModel.getHeight() > 0) {
                requestCreatorConfig.resize(videoModel.getWidth() / 2, videoModel.getHeight() / 2).centerCrop();
            }
            requestCreatorConfig.into(this.mImgCover);
            this.mCustomViewLayout.removeAllViews();
            if (this.mWidgetDrawParams.mListener != null) {
                View viewCreateCustomView = this.mWidgetDrawParams.mListener.createCustomView(this.mCustomViewLayout, createParamsMap(this.mFeed, this.mDrama));
                if (viewCreateCustomView != null) {
                    this.mCustomViewLayout.addView(viewCreateCustomView);
                    this.mCustomViewLayout.setVisibility(0);
                } else {
                    this.mCustomViewLayout.setVisibility(8);
                }
            }
        }
        this.mDramaEnterBtn.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Drama dramaCopy = Drama.copy(DrawHolderDrama.this.mDrama);
                if (DrawHolderDrama.this.mDrama.index < DrawHolderDrama.this.mDrama.total) {
                    dramaCopy.index = DrawHolderDrama.this.mDrama.index + 1;
                }
                DrawHolderDrama.this.enterDramaDetail(dramaCopy, 0);
            }
        });
        this.mHolderContainer.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DrawHolderDrama.this.singleCLick();
            }
        });
        this.mErrorView.setRetryListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Context context = InnerManager.getContext();
                if (!NetworkUtils.isActive(context)) {
                    ToastUtil.show(context, context.getString(R.string.djx_str_no_network_tip));
                    return;
                }
                new BEDrawVideoLoad(DrawHolderDrama.this.mPosition, true).send();
                DrawHolderDrama.this.mPlayerView.retryByInit();
                DrawHolderDrama.this.setUrl(feed.getVideoModel());
                DrawHolderDrama.this.start(true);
            }
        });
        new BEDrawVideoLoad(this.mPosition, false).send();
        this.mPlayerView.setVideoListener(this.mVideoListener);
        setUrl(feed.getVideoModel());
        setDramaTips();
        this.mDramaTitleHintView.setText(this.mDrama.title);
        this.mDramaIndexHintView.setText(String.format(Locale.getDefault(), "第%d集", Integer.valueOf(this.mDrama.index)));
        this.mDramaDescHintView.setText(String.format(Locale.getDefault(), "共%d集 · %s ", Integer.valueOf(this.mDrama.total), this.mDrama.title));
        setBottomOffset();
        this.mSeekLayout.setDragHeight(24);
        this.mSeekLayout.setVisibility(0);
        this.mSeekLayout.setSeekEnabled(true);
        this.mSeekLayout.showDragState(false);
        this.mSeekLayout.setMax(feed.getVideoDuration() * 1000);
        this.mSeekLayout.setProgress(Long.valueOf(this.mPlayerView.getCurrentPosition()).intValue());
        this.mDramaInfoLayout.setVisibility(this.mWidgetDrawParams.mIsHideDramaInfo ? 8 : 0);
        this.mDramaEnterLayout.setVisibility(this.mWidgetDrawParams.mIsHideDramaEnter ? 8 : 0);
        if (z) {
            this.mControllerLayout.reset();
        }
        this.mControllerLayout.setDramaDetail(this.mFeed.getDramaDetail());
        this.mControllerLayout.setWidgetParam(new DJXDrawControllerParam(this.mWidgetDrawParams.mIsHideLikeButton, this.mWidgetDrawParams.mIsHideFavorButton));
        getLifecycle().addObserver(this.mControllerLayout);
        if (this.mWidgetDrawParams.mIsHideLikeButton || this.mWidgetDrawParams.mIsHideDoubleClickLike) {
            this.mControllerLayout.setLikeAnimVisible(false);
        }
        if (!this.mWidgetDrawParams.mIsHideLongClickSpeed && ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).isNewPlayer()) {
            this.mLongClickSpeedPlayEnable = true;
            this.mControllerLayout.setLongClickSpeedPlayEnable(true);
        }
        this.mControllerLayout.setClickListener(new OnControllerClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.6
            @Override // com.bytedance.sdk.djx.core.business.view.controller.OnControllerClickListener
            public void onDoubleTab() {
            }

            @Override // com.bytedance.sdk.djx.core.business.view.controller.OnControllerClickListener
            public void stopLongClick() {
                if (DrawHolderDrama.this.mLongClickSpeedPlayEnable) {
                    DrawHolderDrama.this.mPlayerView.setSpeed(DrawHolderDrama.this.mPlaySpeed);
                    DrawHolderDrama.this.mDrawLog.sendSpeedPlayEvent(1.0f, DrawHolderDrama.this.mFeed, DrawHolderDrama.this.mPlayerView.getCurrentPosition(), false, SpeedScopeType.LONG_PRESS);
                    DrawHolderDrama.this.mSpeedView.setVisibility(8);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.view.controller.OnControllerClickListener
            public void startLongClick() {
                if (DrawHolderDrama.this.mPlayerView.isPlaying() && DrawHolderDrama.this.mLongClickSpeedPlayEnable) {
                    DrawHolderDrama.this.mSpeedView.setVisibility(0);
                    DrawHolderDrama.this.mDrawLog.sendSpeedPlayEvent(2.0f, DrawHolderDrama.this.mFeed, DrawHolderDrama.this.mPlayerView.getCurrentPosition(), true, SpeedScopeType.LONG_PRESS);
                    DrawHolderDrama.this.mPlayerView.setSpeed(2.0f);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.view.controller.OnControllerClickListener
            public void onSingleTab() {
                DrawHolderDrama.this.singleCLick();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterDramaDetail(Drama drama, int i) {
        if (this.mIsVideoPrepared) {
            DJXDramaDetailConfig dJXDramaDetailConfig = this.mWidgetDrawParams.mDetailConfig;
            DramaReporter.reportClickContent("skit_mixed_feed", null, drama);
            DramaReporter.reportRecClick("skit_mixed_feed", drama);
            DramaDetailHelper.getInstance().start(drama, i, getCategory(), String.valueOf(this.mFeed.getGroupId()), dJXDramaDetailConfig, this.mWidgetDrawParams.mEnterDelegate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void singleCLick() {
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

    private DJXWidgetDramaDetailParams.DJXDramaEnterFrom getCategory() {
        if (this.mFeatureValues.equals("skit_only")) {
            return DJXWidgetDramaDetailParams.DJXDramaEnterFrom.SKIT_MIXED;
        }
        return DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DEFAULT;
    }

    private void setDramaTips() {
        this.mHandler.removeCallbacks(this.mTipsAction);
        if (!TextUtils.isEmpty(this.mDrama.scriptAuthor) && !TextUtils.isEmpty(this.mDrama.scriptName)) {
            this.mScriptTipsView.setText(String.format("改编自番茄小说《%s》\n（作者：%s）", this.mDrama.scriptName, this.mDrama.scriptAuthor));
        } else {
            this.mScriptTipsView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mDrama.icpNumber)) {
            this.mIcpTipsView.setText(String.format("备案号：%s", this.mDrama.icpNumber));
        } else {
            this.mIcpTipsView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(boolean z) {
        DJXDmtLoadingLayout dJXDmtLoadingLayout;
        this.mIsPlaying = true;
        this.mImgPlay.clearAnimation();
        this.mImgPlay.setVisibility(8);
        this.mErrorView.show(false);
        play();
        this.mLineBar.postDelayed(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.8
            @Override // java.lang.Runnable
            public void run() {
                if (DrawHolderDrama.this.mIsVideoPrepared) {
                    return;
                }
                DrawHolderDrama.this.mLineBar.startAnimation();
            }
        }, 300L);
        if (!z || (dJXDmtLoadingLayout = this.mLoadingLayout) == null) {
            return;
        }
        dJXDmtLoadingLayout.postDelayed(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.9
            @Override // java.lang.Runnable
            public void run() {
                if (DrawHolderDrama.this.mIsVideoPrepared) {
                    return;
                }
                new BEDismissOuterLoadingEvent().send();
                DrawHolderDrama.this.mLoadingLayout.setVisibility(0);
            }
        }, 300L);
    }

    private void play() {
        if (this.mFeed.getDramaDetail().getVideoModel() != null && !this.mPlayerView.hasVideoModel()) {
            setUrl(this.mFeed.getDramaDetail().getVideoModel());
        }
        this.mPlayerView.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(VideoM videoM) {
        if (videoM != null) {
            this.mPlayerView.setUrl(videoM);
        }
    }

    private void pause2() {
        sendVideoOverEvent();
        this.mIsPlaying = false;
        this.mPlayerView.stop();
        this.mImgPlay.clearAnimation();
        this.mImgCover.clearAnimation();
    }

    public void setSpeed(float f, SpeedScopeType speedScopeType) {
        this.mPlaySpeed = f;
        this.mPlayerView.setSpeed(f);
        this.mDrawLog.sendSpeedPlayEvent(f, this.mFeed, this.mPlayerView.getCurrentPosition(), false, speedScopeType);
    }

    private void pause3() {
        this.mIsPlaying = false;
        LG.i(TAG, "pause3 mIsPlaying = false, mIsPauseByHome = true");
        DJXPlayerView dJXPlayerView = this.mPlayerView;
        if (dJXPlayerView == null || !dJXPlayerView.isPlaying()) {
            return;
        }
        this.mPlayerView.pause();
        this.mImgPlay.clearAnimation();
        this.mImgCover.clearAnimation();
    }

    private void resume() {
        if (this.mPlayerView == null || this.mImgPlay.isShown()) {
            return;
        }
        start(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideUIBySeek(boolean z) {
        if (z) {
            this.mControllerLayout.setVisibility(8);
            this.mDramaInfoLayout.setVisibility(8);
            this.mDramaEnterLayout.setVisibility(8);
            this.mImgPlay.setVisibility(8);
            return;
        }
        this.mControllerLayout.setVisibility(0);
        if (!this.mWidgetDrawParams.mIsHideDramaEnter) {
            this.mDramaEnterLayout.setVisibility(0);
        }
        if (this.mWidgetDrawParams.mIsHideDramaInfo) {
            return;
        }
        this.mDramaInfoLayout.setVisibility(0);
    }

    private void setBottomOffset() {
        boolean z = this.mWidgetDrawParams.mBottomOffset >= 0;
        int iDp2px = UIUtil.dp2px(DJXDrawFragment.getBottomOffset(this.mWidgetDrawParams.mBottomOffset));
        if (iDp2px < 0) {
            iDp2px = 0;
        }
        int iMin = Math.min(iDp2px, UIUtil.getScreenHeight(InnerManager.getContext()) / 2);
        int iDp2px2 = UIUtil.dp2px(24.0f);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mControllerLayout.getLayoutParams();
        marginLayoutParams.bottomMargin = iDp2px2 + iMin;
        this.mControllerLayout.setLayoutParams(marginLayoutParams);
        int iMin2 = Math.min(UIUtil.dp2px(24.0f), DeviceUtils.getDeviceNavigationBarHeight(InnerManager.getContext()));
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mSeekLayout.getLayoutParams();
        marginLayoutParams2.bottomMargin = (z ? 0 : iMin2) + iMin;
        this.mSeekLayout.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.mLineBar.getLayoutParams();
        marginLayoutParams3.bottomMargin = iMin;
        this.mLineBar.setLayoutParams(marginLayoutParams3);
        if (this.mWidgetDrawParams.mIsHideDramaEnter) {
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.mDramaInfoLayout.getLayoutParams();
            marginLayoutParams4.bottomMargin = iMin + iMin2;
            this.mDramaInfoLayout.setLayoutParams(marginLayoutParams4);
        }
        ViewGroup.LayoutParams layoutParams = this.mDramaEnterBg.getLayoutParams();
        layoutParams.height = iMin + (z ? 0 : iMin2) + ((int) this.mDramaEnterBg.getContext().getResources().getDimension(R.dimen.djx_drama_enter_bg_default_height));
        this.mDramaEnterBg.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestVideoWhenExpired() {
        Feed feed = this.mFeed;
        if (feed == null || feed.getVideoId() == null || this.mFeed.getDrama() == null) {
            this.mErrorView.show(true);
            sendVideoOverEvent();
        } else {
            ApiManager.getInstance().videoModel(1, this.mFeed.getDrama().groupId, this.mFeed.getDrama().id, this.mFeed.getVideoId(), new IApiCallback<VideoModelRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawHolderDrama.11
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(VideoModelRsp videoModelRsp) {
                    try {
                        VideoM data = videoModelRsp.getData();
                        if (DrawHolderDrama.this.mFeed != null && data != null && data.getVideoId() != null && data.getOriginal() != null && (DrawHolderDrama.this.mFeed.getVideoModel() == null || TextUtils.isEmpty(DrawHolderDrama.this.mFeed.getVideoModel().getVideoId()) || data.getVideoId().equals(DrawHolderDrama.this.mFeed.getVideoModel().getVideoId()))) {
                            DrawHolderDrama.this.mFeed.setVideoModel(data);
                            new BEDrawVideoLoad(DrawHolderDrama.this.mPosition, true).send();
                            DrawHolderDrama.this.mPlayerView.retryByInit();
                            DrawHolderDrama drawHolderDrama = DrawHolderDrama.this;
                            drawHolderDrama.setUrl(drawHolderDrama.mFeed.getVideoModel());
                            DrawHolderDrama.this.mErrorView.show(false);
                            DrawHolderDrama.this.start(false);
                            DrawHolderDrama.this.mClickDrawListener.onVideoModelExpired(data);
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                    DrawHolderDrama.this.mErrorView.show(true);
                    DrawHolderDrama.this.sendVideoOverEvent();
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, VideoModelRsp videoModelRsp) {
                    DrawHolderDrama.this.mErrorView.show(true);
                    DrawHolderDrama.this.sendVideoOverEvent();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderShow() {
        super.onHolderShow();
        LG.d(TAG, "onHolderShow");
        this.mResumed = true;
        AudioUtils.getInstance().addFocusChangeListener(this);
        startBySendLog();
        this.mDrawLog.recShow(this.mCategory, this.mDrama, 1.0f);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderPause() {
        super.onHolderPause();
        LG.d(TAG, "onHolderPause");
        this.mResumed = false;
        pause3();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderStop() {
        super.onHolderStop();
        this.mResumed = false;
        AudioUtils.getInstance().removeFocusChangeListener(this);
        pause2();
        this.mHasPaused = false;
        this.mIsInSeeking = false;
        this.mIsThumbShow = false;
        this.mLastOverTime = -1L;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderResume() {
        super.onHolderResume();
        this.mResumed = true;
        resume();
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
        WeakHandler weakHandler = this.mHandler;
        if (weakHandler != null) {
            weakHandler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void seekTo(long j) {
        if (this.mIsVideoPrepared) {
            start(false);
            this.mPlayerView.seekTo(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVideoPlayEvent() {
        DrawAdapter2.OnClickDrawListener onClickDrawListener = this.mClickDrawListener;
        String videoPlayType = onClickDrawListener != null ? onClickDrawListener.getVideoPlayType(this.mFeed) : ILogConst.VIDEO_PLAY_TYPE_ONLINE_VIDEO;
        DrawAdapter2.OnClickDrawListener onClickDrawListener2 = this.mClickDrawListener;
        if (this.mDrawLog.sendPlayEvent(this.mFeed, this.mPosition, videoPlayType, onClickDrawListener2 != null ? onClickDrawListener2.getRootGid() : 0L, this.mDrama)) {
            Map<String, Object> mapCreateParamsMap = createParamsMap(this.mFeed, this.mDrama);
            if (this.mWidgetDrawParams.mListener != null) {
                this.mWidgetDrawParams.mListener.onDJXVideoPlay(mapCreateParamsMap);
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
        long j3 = duration == 0 ? 0L : j2;
        int iMin = Math.min(Float.valueOf((duration == 0 ? 0.0f : this.mMaxPassTime / duration) * 100.0f).intValue(), 100);
        DrawAdapter2.OnClickDrawListener onClickDrawListener = this.mClickDrawListener;
        String videoPlayType = onClickDrawListener != null ? onClickDrawListener.getVideoPlayType(this.mFeed) : ILogConst.VIDEO_PLAY_TYPE_ONLINE_VIDEO;
        String cachePlayReason = ILogConst.VIDEO_PLAY_TYPE_CACHE_VIDEO.equals(videoPlayType) ? this.mClickDrawListener.getCachePlayReason() : ILogConst.CACHE_PLAY_REASON_NULL;
        DrawAdapter2.OnClickDrawListener onClickDrawListener2 = this.mClickDrawListener;
        long rootGid = onClickDrawListener2 != null ? onClickDrawListener2.getRootGid() : 0L;
        this.mDrawLog.sendRecVideoDuration(this.mDrama, j3, iMin);
        if (this.mDrawLog.sendOverEvent(this.mFeed, this.mPosition, j3, iMin, videoPlayType, cachePlayReason, rootGid, this.mDrama, this.mPlayerView)) {
            Map<String, Object> mapCreateParamsMap = createParamsMap(this.mFeed, this.mDrama);
            if (this.mWidgetDrawParams.mListener != null) {
                this.mWidgetDrawParams.mListener.onDJXVideoOver(mapCreateParamsMap);
                LG.d(TAG, "onDJXVideoOver map = " + mapCreateParamsMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoPauseResponse() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        this.mSeekLayout.showDragState(true);
        this.mDrawLog.sendPauseEvent(this.mFeed);
        Map<String, Object> mapCreateParamsMap = createParamsMap(this.mFeed, this.mDrama);
        if (this.mWidgetDrawParams.mListener != null) {
            this.mWidgetDrawParams.mListener.onDJXVideoPause(mapCreateParamsMap);
            LG.d(TAG, "onDJXVideoPause map = " + mapCreateParamsMap);
        }
        sendVideoOverEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoContinueResponse() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        this.mSeekLayout.showDragState(false);
        this.mDrawLog.sendContinueEvent(this.mFeed);
        Map<String, Object> mapCreateParamsMap = createParamsMap(this.mFeed, this.mDrama);
        if (this.mWidgetDrawParams.mListener == null || this.mFeed == null) {
            return;
        }
        this.mWidgetDrawParams.mListener.onDJXVideoContinue(mapCreateParamsMap);
        LG.d(TAG, "onDJXVideoContinue map = " + mapCreateParamsMap);
    }

    public static Map<String, Object> createParamsMap(Feed feed, Drama drama) {
        Map<String, Object> map = drama.toMap();
        map.put("group_id", Long.valueOf(feed.getGroupId()));
        map.put("cover_list", feed.getCoverImages());
        map.put("video_duration", Integer.valueOf(feed.getVideoDuration()));
        map.put("video_size", Long.valueOf(feed.getVideoSize()));
        if (feed.getVideoModel() != null) {
            map.put("video_width", Integer.valueOf(feed.getVideoModel().getWidth()));
            map.put("video_height", Integer.valueOf(feed.getVideoModel().getHeight()));
        }
        return map;
    }

    public void startBySendLog() {
        this.mDrawLog.reset();
        start(true);
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
