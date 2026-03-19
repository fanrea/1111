package com.fendasz.moku.planet.ui.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.interf.functions.Action;
import com.fendasz.moku.planet.ui.customview.MediaView;
import com.fendasz.moku.planet.utils.StatusBarUtils;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class VideoActivity extends Activity {
    private VideoActivity mContext;
    private MediaView mMediaView;
    private String mVideoUrl;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        super.onCreate(bundle);
        initLoad();
        initView();
        initData(bundle);
        initListener();
    }

    private void initListener() {
        MediaView mediaView = this.mMediaView;
        if (mediaView != null) {
            mediaView.setOnPreparedListener(new MediaView.OnPreparedListener() { // from class: com.fendasz.moku.planet.ui.activity.VideoActivity.1
                @Override // com.fendasz.moku.planet.ui.customview.MediaView.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                    if (VideoActivity.this.mMediaView != null) {
                        VideoActivity.this.mMediaView.start();
                    }
                }
            });
            this.mMediaView.setOnVideoVisible(new MediaView.OnVideoVisible() { // from class: com.fendasz.moku.planet.ui.activity.VideoActivity.2
                @Override // com.fendasz.moku.planet.ui.customview.MediaView.OnVideoVisible
                public void onVisible() throws IllegalStateException {
                    if (VideoActivity.this.mMediaView != null) {
                        VideoActivity.this.mMediaView.start();
                    }
                }
            });
            this.mMediaView.setOnVideoInvisible(new MediaView.OnVideoInvisible() { // from class: com.fendasz.moku.planet.ui.activity.VideoActivity.3
                @Override // com.fendasz.moku.planet.ui.customview.MediaView.OnVideoInvisible
                public void onInvisible() throws IllegalStateException {
                    if (VideoActivity.this.mMediaView != null) {
                        VideoActivity.this.mMediaView.pause();
                    }
                }
            });
            this.mMediaView.init(new Action() { // from class: com.fendasz.moku.planet.ui.activity.VideoActivity.4
                @Override // com.fendasz.moku.planet.interf.functions.Action
                public void run() throws Exception {
                    if (VideoActivity.this.mMediaView != null) {
                        VideoActivity.this.mMediaView.prepareAsync();
                    }
                }
            });
            this.mMediaView.setOnBackClicked(new MediaView.OnBackClicked() { // from class: com.fendasz.moku.planet.ui.activity.VideoActivity.5
                @Override // com.fendasz.moku.planet.ui.customview.MediaView.OnBackClicked
                public void onClicked() {
                    VideoActivity.this.mContext.finish();
                }
            });
        }
    }

    private void initData(Bundle bundle) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaView mediaView;
        if (bundle == null) {
            this.mVideoUrl = getIntent().getStringExtra(this.mContext.getString(R.string.moku_intent_extra__video_url));
        } else {
            this.mVideoUrl = bundle.getString(this.mContext.getString(R.string.moku_intent_extra__video_url));
        }
        if (TextUtils.isEmpty(this.mVideoUrl) || (mediaView = this.mMediaView) == null) {
            return;
        }
        mediaView.reSet();
        this.mMediaView.setDataSource(this.mVideoUrl);
    }

    private void initView() {
        setContentView(R.layout.moku_activity_video);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_content_view);
        VideoActivity videoActivity = this.mContext;
        StatusBarUtils.setStatusBarColor(videoActivity, videoActivity.getResources().getColor(R.color.black));
        MediaView mediaView = new MediaView(this.mContext);
        this.mMediaView = mediaView;
        relativeLayout.addView(mediaView);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mMediaView.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.addRule(13);
        this.mMediaView.setLayoutParams(layoutParams);
    }

    private void initLoad() {
        this.mContext = this;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MediaView mediaView = this.mMediaView;
        if (mediaView != null) {
            mediaView.release();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(this.mContext.getString(R.string.moku_intent_extra__video_url), this.mVideoUrl);
    }
}
