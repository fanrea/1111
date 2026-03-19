package com.fendasz.moku.planet.ui.customview;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.alipay.sdk.m.u.b;
import com.component.feed.a;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.interf.functions.Action;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasHelper;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MediaView extends RelativeLayout {
    public static final int STATUS_END = 9;
    public static final int STATUS_ERROR = 8;
    public static final int STATUS_IDLE = 0;
    public static final int STATUS_INITIALIZED = 1;
    public static final int STATUS_PAUSED = 5;
    public static final int STATUS_PLAYBACK_COMPLETED = 7;
    public static final int STATUS_PREPARED = 3;
    public static final int STATUS_PREPARING = 2;
    public static final int STATUS_STARTED = 4;
    public static final int STATUS_STOPPED = 6;
    public static final String TAG = "MediaView";
    private Context mContext;
    private int mCurrentStauts;
    private boolean mIsLooping;
    private boolean mIsShowControlView;
    private MediaPlayer mMediaPlayer;
    private OnBackClicked mOnBackClicked;
    private OnCompletionListener mOnCompletionListener;
    private OnErrorListener mOnErrorListener;
    private OnPreparedListener mOnPreparedListener;
    private OnVideoInvisible mOnVideoInvisible;
    private OnVideoVisible mOnVideoVisible;
    private PhoneScreenUtils mPhoneScreenUtils;
    private RelativeLayout mRlControlView;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceHolder.Callback mSurfaceHolderCallback;
    private SurfaceView mSurfaceView;

    public interface OnBackClicked {
        void onClicked();
    }

    public interface OnCompletionListener {
        void onCompletion(MediaPlayer mediaPlayer);
    }

    public interface OnErrorListener {
        boolean onError(MediaPlayer mediaPlayer, int i, int i2);
    }

    public interface OnPreparedListener {
        void onPrepared(MediaPlayer mediaPlayer);
    }

    public interface OnVideoInvisible {
        void onInvisible();
    }

    public interface OnVideoVisible {
        void onVisible();
    }

    private void initLoadingView() {
    }

    public MediaView(Context context) {
        super(context);
        this.mCurrentStauts = -1;
        this.mIsShowControlView = false;
        onLoad(context);
    }

    private void onLoad(Context context) {
        initLoad(context);
    }

    public void reSet() {
        if (this.mCurrentStauts != 9) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                this.mCurrentStauts = 0;
                LogUtils.log(TAG, "reSet");
                return;
            }
            return;
        }
        LogUtils.log(TAG, "you can not reSet");
    }

    public void setDataSource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (this.mCurrentStauts == 0) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.setDataSource(str);
                    this.mCurrentStauts = 1;
                    LogUtils.log(TAG, "setDataSource");
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        LogUtils.log(TAG, "you can not setDataSource");
    }

    public void prepareAsync() throws IllegalStateException {
        int i = this.mCurrentStauts;
        if (i == 1 || i == 6) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.prepareAsync();
                this.mCurrentStauts = 2;
                LogUtils.log(TAG, "prepareAsync");
                return;
            }
            return;
        }
        LogUtils.log(TAG, "you can not prepareAsync");
    }

    public void start() throws IllegalStateException {
        int i = this.mCurrentStauts;
        if (i == 3 || i == 4 || i == 5 || i == 7) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.mCurrentStauts = 4;
                LogUtils.log(TAG, "start");
                return;
            }
            return;
        }
        LogUtils.log(TAG, "you can not start");
    }

    public void pause() throws IllegalStateException {
        int i = this.mCurrentStauts;
        if (i == 4 || i == 5) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.pause();
                this.mCurrentStauts = 5;
                LogUtils.log(TAG, "pause");
                return;
            }
            return;
        }
        LogUtils.log(TAG, "you can not pause");
    }

    public void stop() throws IllegalStateException {
        int i = this.mCurrentStauts;
        if (i == 3 || i == 4 || i == 5 || i == 6 || i == 7) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.mCurrentStauts = 6;
                LogUtils.log(TAG, a.e);
                return;
            }
            return;
        }
        LogUtils.log(TAG, "you can not stop");
    }

    public void seekTo(int i) throws IllegalStateException {
        int i2 = this.mCurrentStauts;
        if (i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7) {
            if (this.mMediaPlayer != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.mMediaPlayer.seekTo(i, 0);
                } else {
                    this.mMediaPlayer.seekTo(i);
                }
                LogUtils.log(TAG, "seekTo");
                return;
            }
            return;
        }
        LogUtils.log(TAG, "you can not seekTo");
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
            this.mIsLooping = z;
        }
    }

    public void release() {
        SurfaceHolder.Callback callback;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null && (callback = this.mSurfaceHolderCallback) != null) {
            surfaceHolder.removeCallback(callback);
            String str = TAG;
            LogUtils.log(str, "SurfaceHolder removeCallback");
            Surface surface = this.mSurfaceHolder.getSurface();
            if (surface != null) {
                surface.release();
                LogUtils.log(str, "Surface release");
            }
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mCurrentStauts = 9;
            LogUtils.log(TAG, "MediaView release");
        }
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnVideoVisible(OnVideoVisible onVideoVisible) {
        this.mOnVideoVisible = onVideoVisible;
    }

    public void setOnVideoInvisible(OnVideoInvisible onVideoInvisible) {
        this.mOnVideoInvisible = onVideoInvisible;
    }

    public void setOnBackClicked(OnBackClicked onBackClicked) {
        this.mOnBackClicked = onBackClicked;
    }

    public void init(Action action) {
        initView();
        initData();
        initListener(action);
    }

    private void initListener(final Action action) {
        if (this.mSurfaceHolder != null) {
            SurfaceHolder.Callback callback = new SurfaceHolder.Callback() { // from class: com.fendasz.moku.planet.ui.customview.MediaView.1
                private boolean isInited = true;

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    if (MediaView.this.mMediaPlayer != null) {
                        MediaView.this.mMediaPlayer.setDisplay(MediaView.this.mSurfaceHolder);
                    }
                    if (!this.isInited) {
                        if (MediaView.this.mOnVideoVisible != null) {
                            MediaView.this.mOnVideoVisible.onVisible();
                            return;
                        }
                        return;
                    }
                    this.isInited = false;
                    Action action2 = action;
                    if (action2 != null) {
                        try {
                            action2.run();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    if (MediaView.this.mOnVideoInvisible != null) {
                        MediaView.this.mOnVideoInvisible.onInvisible();
                    }
                }
            };
            this.mSurfaceHolderCallback = callback;
            this.mSurfaceHolder.addCallback(callback);
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.fendasz.moku.planet.ui.customview.MediaView.2
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) {
                    MediaView.this.mCurrentStauts = 3;
                    float videoWidth = mediaPlayer2.getVideoWidth();
                    float videoHeight = mediaPlayer2.getVideoHeight();
                    float width = MediaView.this.getWidth();
                    float height = MediaView.this.getHeight();
                    if (videoWidth > 0.0f && videoHeight > 0.0f) {
                        float f = videoHeight / videoWidth >= height / width ? height / videoHeight : width / videoWidth;
                        int i = (int) (videoWidth * f);
                        int i2 = (int) (videoHeight * f);
                        if (MediaView.this.mSurfaceView != null) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) MediaView.this.mSurfaceView.getLayoutParams();
                            layoutParams.width = i;
                            layoutParams.height = i2;
                            layoutParams.addRule(13);
                            MediaView.this.mSurfaceView.setLayoutParams(layoutParams);
                        }
                    }
                    if (MediaView.this.mOnPreparedListener != null) {
                        MediaView.this.mOnPreparedListener.onPrepared(mediaPlayer2);
                    }
                }
            });
            this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.fendasz.moku.planet.ui.customview.MediaView.3
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                    MediaView.this.mCurrentStauts = 8;
                    if (MediaView.this.mOnErrorListener == null) {
                        return false;
                    }
                    MediaView.this.mOnErrorListener.onError(mediaPlayer2, i, i2);
                    return false;
                }
            });
            this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.fendasz.moku.planet.ui.customview.MediaView.4
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer2) {
                    if (MediaView.this.mCurrentStauts == 4 && !MediaView.this.mIsLooping) {
                        MediaView.this.mCurrentStauts = 7;
                    }
                    if (MediaView.this.mOnCompletionListener != null) {
                        MediaView.this.mOnCompletionListener.onCompletion(mediaPlayer2);
                    }
                }
            });
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.customview.MediaView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaView.this.mIsShowControlView) {
                    return;
                }
                MediaView.this.mRlControlView.setVisibility(0);
                MediaView.this.mIsShowControlView = true;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.fendasz.moku.planet.ui.customview.MediaView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaView.this.mRlControlView != null) {
                            MediaView.this.mRlControlView.setVisibility(8);
                            MediaView.this.mIsShowControlView = false;
                        }
                    }
                }, b.a);
            }
        });
    }

    private void initData() {
        SurfaceView surfaceView = this.mSurfaceView;
        if (surfaceView != null) {
            this.mSurfaceHolder = surfaceView.getHolder();
        }
    }

    private void initView() {
        setBackgroundColor(this.mContext.getResources().getColor(R.color.black));
        initVideoView();
        initControlView();
        initLoadingView();
    }

    private void initControlView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        this.mRlControlView = relativeLayout;
        addView(relativeLayout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRlControlView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.addRule(13);
        this.mRlControlView.setLayoutParams(layoutParams);
        this.mRlControlView.setBackgroundColor(this.mContext.getResources().getColor(R.color.moku_gray_masking));
        this.mRlControlView.setVisibility(8);
        ImageView imageView = new ImageView(this.mContext);
        this.mRlControlView.addView(imageView);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.addRule(9);
        layoutParams2.addRule(10);
        imageView.setLayoutParams(layoutParams2);
        ScreenAdaptationUtils.setSize(this.mContext, imageView, 120, 120);
        ScreenAdaptationUtils.setMarginLeft(this.mContext, imageView, 50);
        ScreenAdaptationUtils.setMarginTop(this.mContext, imageView, 50);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageBitmap(CanvasHelper.getBackBitmap(this.mContext.getResources().getColor(R.color.white), getScale(120.0f), getScale(120.0f)));
        initControlViewListener(imageView);
    }

    private void initControlViewListener(ImageView imageView) {
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.customview.MediaView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MediaView.this.mOnBackClicked != null) {
                        MediaView.this.mOnBackClicked.onClicked();
                    }
                }
            });
        }
    }

    private void initVideoView() {
        SurfaceView surfaceView = new SurfaceView(this.mContext);
        this.mSurfaceView = surfaceView;
        addView(surfaceView);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSurfaceView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.addRule(13);
        this.mSurfaceView.setLayoutParams(layoutParams);
    }

    private int getScale(float f) {
        PhoneScreenUtils phoneScreenUtils = this.mPhoneScreenUtils;
        if (phoneScreenUtils != null) {
            return phoneScreenUtils.getScale(this.mContext, f);
        }
        return 0;
    }

    private void initLoad(Context context) {
        this.mContext = context;
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        this.mMediaPlayer = new MediaPlayer();
        setLooping(false);
    }
}
