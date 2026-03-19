package com.alliance.ssp.ad.api;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.video.VideoController;
import com.alliance.ssp.ad.x.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class NMPlayerView extends View {
    private View container;
    private boolean hasReportVideoPrepared;
    private boolean isVideoPrepared;
    private SAAllianceAdData mAdData;
    public NMAPAdNativeVideoViewListener mListener;
    private c mNMNativeFeedAdImpl;
    private int[] mediaPlaySize;
    private Handler showVideoPlayer;
    private VideoController videoController;
    private View videoView;

    public interface NMAPAdNativeVideoViewListener {
        void onVideoCompleted();

        void onVideoError(int i);

        void onVideoLoading();

        void onVideoPause();

        void onVideoReady();

        void onVideoResume();

        void onVideoStart();

        void onVideoStop();
    }

    public NMPlayerView(Context context, c cVar, SAAllianceAdData sAAllianceAdData, VideoController videoController) {
        super(context);
        this.mListener = null;
        this.mNMNativeFeedAdImpl = null;
        this.mAdData = null;
        this.mediaPlaySize = new int[2];
        this.showVideoPlayer = new Handler(Looper.getMainLooper()) { // from class: com.alliance.ssp.ad.api.NMPlayerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                NMPlayerView.this.videoView.setVisibility(0);
            }
        };
        this.hasReportVideoPrepared = false;
        this.isVideoPrepared = false;
        this.mNMNativeFeedAdImpl = cVar;
        this.mAdData = sAAllianceAdData;
        this.videoController = videoController;
    }

    public long getVideoCurrentPosition() {
        int currentPosition;
        VideoController videoController = this.videoController;
        if (videoController == null) {
            return 0L;
        }
        MediaPlayer mediaPlayer = videoController.w;
        if (mediaPlayer == null) {
            currentPosition = 0;
        } else {
            try {
                currentPosition = mediaPlayer.getCurrentPosition();
            } catch (Exception unused) {
            }
        }
        return currentPosition;
    }

    public long getVideoDuration() {
        int duration;
        VideoController videoController = this.videoController;
        if (videoController == null) {
            return 0L;
        }
        MediaPlayer mediaPlayer = videoController.w;
        if (mediaPlayer == null) {
            duration = 0;
        } else {
            try {
                duration = mediaPlayer.getDuration();
            } catch (Exception unused) {
            }
        }
        return duration;
    }

    public float getVolume() {
        VideoController videoController = this.videoController;
        if (videoController == null) {
            return 0.0f;
        }
        if (videoController.w == null) {
            return -1.0f;
        }
        return videoController.B;
    }

    /* renamed from: lambda$pauseVideo$1$com-alliance-ssp-ad-api-NMPlayerView, reason: not valid java name */
    /* synthetic */ void m298lambda$pauseVideo$1$comalliancesspadapiNMPlayerView() {
        this.mListener.onVideoPause();
    }

    /* renamed from: lambda$resumeVideo$2$com-alliance-ssp-ad-api-NMPlayerView, reason: not valid java name */
    /* synthetic */ void m299lambda$resumeVideo$2$comalliancesspadapiNMPlayerView() {
        this.mListener.onVideoResume();
    }

    /* renamed from: lambda$startVideo$0$com-alliance-ssp-ad-api-NMPlayerView, reason: not valid java name */
    /* synthetic */ void m300lambda$startVideo$0$comalliancesspadapiNMPlayerView() {
        this.mListener.onVideoStart();
    }

    /* renamed from: lambda$stopVideo$3$com-alliance-ssp-ad-api-NMPlayerView, reason: not valid java name */
    /* synthetic */ void m301lambda$stopVideo$3$comalliancesspadapiNMPlayerView() {
        this.mListener.onVideoStop();
    }

    /* renamed from: lambda$videoIsPrepared$4$com-alliance-ssp-ad-api-NMPlayerView, reason: not valid java name */
    /* synthetic */ void m302lambda$videoIsPrepared$4$comalliancesspadapiNMPlayerView() {
        this.mListener.onVideoReady();
    }

    public boolean pauseVideo() throws IllegalStateException {
        VideoController videoController = this.videoController;
        if (videoController == null) {
            return false;
        }
        boolean zF = videoController.f();
        if (this.mListener != null && zF) {
            n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.api.NMPlayerView$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m298lambda$pauseVideo$1$comalliancesspadapiNMPlayerView();
                }
            });
        }
        return zF;
    }

    public void replayVideo() {
        VideoController videoController = this.videoController;
        if (videoController != null) {
            videoController.h();
        }
    }

    @Deprecated
    public void resizeWithContainer(int[] iArr, View view) {
        try {
            if (this.videoController == null || view == null || view.getWidth() <= 0 || view.getHeight() <= 0) {
                return;
            }
            this.videoController.a(view.getWidth(), view.getHeight());
        } catch (Exception unused) {
        }
    }

    public void resumeVideo() throws IllegalStateException {
        VideoController videoController = this.videoController;
        if (videoController != null) {
            boolean zI = videoController.i();
            if (this.mListener == null || !zI) {
                return;
            }
            n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.api.NMPlayerView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m299lambda$resumeVideo$2$comalliancesspadapiNMPlayerView();
                }
            });
        }
    }

    public void setNMApAdNativeVideoviewListener(NMAPAdNativeVideoViewListener nMAPAdNativeVideoViewListener) {
        this.mListener = nMAPAdNativeVideoViewListener;
        if (this.isVideoPrepared) {
            videoIsPrepared();
        }
    }

    public void setVideoMute(boolean z) {
        VideoController videoController = this.videoController;
        if (videoController != null) {
            if (z) {
                videoController.b(0.0f);
            } else {
                videoController.b(1.0f);
            }
        }
    }

    public void setVideoPlayerSize(int[] iArr) {
        this.mediaPlaySize = iArr;
    }

    public void setVideoView(View view) {
        this.videoView = view;
    }

    public void setVolume(float f) {
        SAAllianceAdData sAAllianceAdData;
        VideoController videoController = this.videoController;
        if (videoController != null) {
            videoController.b(f);
            c cVar = this.mNMNativeFeedAdImpl;
            if (cVar == null || (sAAllianceAdData = this.mAdData) == null) {
                return;
            }
            if (f == 0.0f) {
                cVar.j("", "", sAAllianceAdData);
            } else {
                cVar.o("", "", sAAllianceAdData);
            }
        }
    }

    public void setVolumeWithoutReport(float f) {
        VideoController videoController = this.videoController;
        if (videoController != null) {
            videoController.b(f);
        }
    }

    public void showVideo(View view) {
        this.container = view;
        if (view == null || this.videoView == null) {
            return;
        }
        resizeWithContainer(this.mediaPlaySize, view);
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.removeAllViews();
        if (this.videoView.getParent() == null) {
            viewGroup.addView(this.videoView);
        }
        this.videoView.setVisibility(4);
        Handler handler = this.showVideoPlayer;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, 400L);
        } else {
            this.videoView.setVisibility(0);
        }
    }

    public boolean startVideo() throws IllegalStateException {
        VideoController videoController = this.videoController;
        if (videoController == null) {
            return false;
        }
        boolean zI = videoController.i();
        if (this.mListener != null && zI) {
            n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.api.NMPlayerView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m300lambda$startVideo$0$comalliancesspadapiNMPlayerView();
                }
            });
        }
        return zI;
    }

    public void stopVideo() throws IllegalStateException {
        VideoController videoController = this.videoController;
        if (videoController != null) {
            videoController.j();
            if (this.mListener != null) {
                n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.api.NMPlayerView$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m301lambda$stopVideo$3$comalliancesspadapiNMPlayerView();
                    }
                });
            }
        }
    }

    public void videoIsPrepared() {
        this.isVideoPrepared = true;
        if (this.hasReportVideoPrepared || this.mListener == null) {
            return;
        }
        n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.api.NMPlayerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m302lambda$videoIsPrepared$4$comalliancesspadapiNMPlayerView();
            }
        });
        this.hasReportVideoPrepared = true;
    }

    public NMPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mListener = null;
        this.mNMNativeFeedAdImpl = null;
        this.mAdData = null;
        this.mediaPlaySize = new int[2];
        this.showVideoPlayer = new Handler(Looper.getMainLooper()) { // from class: com.alliance.ssp.ad.api.NMPlayerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                NMPlayerView.this.videoView.setVisibility(0);
            }
        };
        this.hasReportVideoPrepared = false;
        this.isVideoPrepared = false;
    }

    public NMPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mListener = null;
        this.mNMNativeFeedAdImpl = null;
        this.mAdData = null;
        this.mediaPlaySize = new int[2];
        this.showVideoPlayer = new Handler(Looper.getMainLooper()) { // from class: com.alliance.ssp.ad.api.NMPlayerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                NMPlayerView.this.videoView.setVisibility(0);
            }
        };
        this.hasReportVideoPrepared = false;
        this.isVideoPrepared = false;
    }
}
