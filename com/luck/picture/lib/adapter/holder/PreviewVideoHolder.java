package com.luck.picture.lib.adapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luck.picture.lib.R;
import com.luck.picture.lib.engine.MediaPlayerEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPlayerListener;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.utils.IntentUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PreviewVideoHolder extends BasePreviewHolder {
    private boolean isPlayed;
    public ImageView ivPlayButton;
    private final OnPlayerListener mPlayerListener;
    public ProgressBar progress;
    public View videoPlayer;

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void findViews(View view) {
    }

    public PreviewVideoHolder(View view) {
        super(view);
        this.isPlayed = false;
        this.mPlayerListener = new OnPlayerListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewVideoHolder.5
            @Override // com.luck.picture.lib.interfaces.OnPlayerListener
            public void onPlayerError() {
                PreviewVideoHolder.this.playerDefaultUI();
            }

            @Override // com.luck.picture.lib.interfaces.OnPlayerListener
            public void onPlayerReady() {
                PreviewVideoHolder.this.playerIngUI();
            }

            @Override // com.luck.picture.lib.interfaces.OnPlayerListener
            public void onPlayerLoading() {
                PreviewVideoHolder.this.progress.setVisibility(0);
            }

            @Override // com.luck.picture.lib.interfaces.OnPlayerListener
            public void onPlayerEnd() {
                PreviewVideoHolder.this.playerDefaultUI();
            }
        };
        this.ivPlayButton = (ImageView) view.findViewById(R.id.iv_play_video);
        this.progress = (ProgressBar) view.findViewById(R.id.progress);
        this.ivPlayButton.setVisibility(this.selectorConfig.isPreviewZoomEffect ? 8 : 0);
        if (this.selectorConfig.videoPlayerEngine == null) {
            this.selectorConfig.videoPlayerEngine = new MediaPlayerEngine();
        }
        View viewOnCreateVideoPlayer = this.selectorConfig.videoPlayerEngine.onCreateVideoPlayer(view.getContext());
        this.videoPlayer = viewOnCreateVideoPlayer;
        if (viewOnCreateVideoPlayer == null) {
            throw new NullPointerException("onCreateVideoPlayer cannot be empty,Please implement " + VideoPlayerEngine.class);
        }
        if (viewOnCreateVideoPlayer.getLayoutParams() == null) {
            this.videoPlayer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.indexOfChild(this.videoPlayer) != -1) {
            viewGroup.removeView(this.videoPlayer);
        }
        viewGroup.addView(this.videoPlayer, 0);
        this.videoPlayer.setVisibility(8);
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void loadImage(LocalMedia localMedia, int i, int i2) {
        if (this.selectorConfig.imageEngine != null) {
            String availablePath = localMedia.getAvailablePath();
            if (i == -1 && i2 == -1) {
                this.selectorConfig.imageEngine.loadImage(this.itemView.getContext(), availablePath, this.coverImageView);
            } else {
                this.selectorConfig.imageEngine.loadImage(this.itemView.getContext(), this.coverImageView, availablePath, i, i2);
            }
        }
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void onClickBackPressed() {
        this.coverImageView.setOnViewTapListener(new OnViewTapListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewVideoHolder.1
            @Override // com.luck.picture.lib.photoview.OnViewTapListener
            public void onViewTap(View view, float f, float f2) {
                if (PreviewVideoHolder.this.mPreviewEventListener != null) {
                    PreviewVideoHolder.this.mPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void onLongPressDownload(final LocalMedia localMedia) {
        this.coverImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewVideoHolder.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (PreviewVideoHolder.this.mPreviewEventListener == null) {
                    return false;
                }
                PreviewVideoHolder.this.mPreviewEventListener.onLongPressDownload(localMedia);
                return false;
            }
        });
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public void bindData(LocalMedia localMedia, int i) {
        super.bindData(localMedia, i);
        setScaleDisplaySize(localMedia);
        this.ivPlayButton.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewVideoHolder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PreviewVideoHolder.this.selectorConfig.isPauseResumePlay) {
                    PreviewVideoHolder.this.dispatchPlay();
                } else {
                    PreviewVideoHolder.this.startPlay();
                }
            }
        });
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewVideoHolder.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PreviewVideoHolder.this.selectorConfig.isPauseResumePlay) {
                    PreviewVideoHolder.this.dispatchPlay();
                } else if (PreviewVideoHolder.this.mPreviewEventListener != null) {
                    PreviewVideoHolder.this.mPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPlay() {
        if (this.isPlayed) {
            if (isPlaying()) {
                onPause();
                return;
            } else {
                onResume();
                return;
            }
        }
        startPlay();
    }

    private void onResume() {
        this.ivPlayButton.setVisibility(8);
        if (this.selectorConfig.videoPlayerEngine != null) {
            this.selectorConfig.videoPlayerEngine.onResume(this.videoPlayer);
        }
    }

    public void onPause() {
        this.ivPlayButton.setVisibility(0);
        if (this.selectorConfig.videoPlayerEngine != null) {
            this.selectorConfig.videoPlayerEngine.onPause(this.videoPlayer);
        }
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public boolean isPlaying() {
        return this.selectorConfig.videoPlayerEngine != null && this.selectorConfig.videoPlayerEngine.isPlaying(this.videoPlayer);
    }

    public void startPlay() {
        if (this.selectorConfig.isUseSystemVideoPlayer) {
            IntentUtils.startSystemPlayerVideo(this.itemView.getContext(), this.media.getAvailablePath());
            return;
        }
        if (this.videoPlayer == null) {
            throw new NullPointerException("VideoPlayer cannot be empty,Please implement " + VideoPlayerEngine.class);
        }
        if (this.selectorConfig.videoPlayerEngine != null) {
            this.progress.setVisibility(0);
            this.ivPlayButton.setVisibility(8);
            this.mPreviewEventListener.onPreviewVideoTitle(this.media.getFileName());
            this.isPlayed = true;
            this.selectorConfig.videoPlayerEngine.onStarPlayer(this.videoPlayer, this.media);
        }
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void setScaleDisplaySize(LocalMedia localMedia) {
        super.setScaleDisplaySize(localMedia);
        if (this.selectorConfig.isPreviewZoomEffect || this.screenWidth >= this.screenHeight) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.videoPlayer.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = this.screenWidth;
            layoutParams2.height = this.screenAppInHeight;
            layoutParams2.gravity = 17;
            return;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams3.width = this.screenWidth;
            layoutParams3.height = this.screenAppInHeight;
            layoutParams3.addRule(13);
            return;
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams4.width = this.screenWidth;
            layoutParams4.height = this.screenAppInHeight;
            layoutParams4.gravity = 17;
            return;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams5.width = this.screenWidth;
            layoutParams5.height = this.screenAppInHeight;
            layoutParams5.topToTop = 0;
            layoutParams5.bottomToBottom = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playerDefaultUI() {
        this.isPlayed = false;
        this.ivPlayButton.setVisibility(0);
        this.progress.setVisibility(8);
        this.coverImageView.setVisibility(0);
        this.videoPlayer.setVisibility(8);
        if (this.mPreviewEventListener != null) {
            this.mPreviewEventListener.onPreviewVideoTitle(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playerIngUI() {
        this.progress.setVisibility(8);
        this.ivPlayButton.setVisibility(8);
        this.coverImageView.setVisibility(8);
        this.videoPlayer.setVisibility(0);
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public void onViewAttachedToWindow() {
        if (this.selectorConfig.videoPlayerEngine != null) {
            this.selectorConfig.videoPlayerEngine.onPlayerAttachedToWindow(this.videoPlayer);
            this.selectorConfig.videoPlayerEngine.addPlayListener(this.mPlayerListener);
        }
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public void onViewDetachedFromWindow() {
        if (this.selectorConfig.videoPlayerEngine != null) {
            this.selectorConfig.videoPlayerEngine.onPlayerDetachedFromWindow(this.videoPlayer);
            this.selectorConfig.videoPlayerEngine.removePlayListener(this.mPlayerListener);
        }
        playerDefaultUI();
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public void resumePausePlay() {
        if (isPlaying()) {
            onPause();
        } else {
            onResume();
        }
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public void release() {
        if (this.selectorConfig.videoPlayerEngine != null) {
            this.selectorConfig.videoPlayerEngine.removePlayListener(this.mPlayerListener);
            this.selectorConfig.videoPlayerEngine.destroy(this.videoPlayer);
        }
    }
}
