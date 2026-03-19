package com.alliance.ssp.ad.video;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.SeekBar;
import com.alliance.ssp.ad.video.VideoController;

/* compiled from: VideoController.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends Handler {
    public final /* synthetic */ VideoController a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(VideoController videoController, Looper looper) {
        super(looper);
        this.a = videoController;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        MediaPlayer mediaPlayer;
        Handler handler;
        MediaPlayer mediaPlayer2;
        synchronized (this.a.A) {
            try {
                switch (message.what) {
                    case 65537:
                        VideoController videoController = this.a;
                        videoController.a = VideoController.VIDEO_STATE.PREPARED;
                        videoController.k = (Handler) message.obj;
                        MediaPlayer mediaPlayer3 = videoController.w;
                        if (mediaPlayer3 != null) {
                            mediaPlayer3.setLooping(videoController.p);
                            VideoController videoController2 = this.a;
                            if (videoController2.e) {
                                videoController2.w.setVolume(0.0f, 0.0f);
                                this.a.B = 0.0f;
                            } else {
                                videoController2.w.setVolume(1.0f, 1.0f);
                                this.a.B = 1.0f;
                            }
                            VideoController videoController3 = this.a;
                            videoController3.f = videoController3.e;
                            VideoController videoController4 = this.a;
                            if (videoController4.b == VideoController.VIDEO_STATE.PLAYING) {
                                videoController4.i();
                            }
                            VideoController videoController5 = this.a;
                            videoController5.y[0] = videoController5.w.getVideoWidth();
                            VideoController videoController6 = this.a;
                            videoController6.y[1] = videoController6.w.getVideoHeight();
                            VideoController videoController7 = this.a;
                            if (!videoController7.o && videoController7.a(videoController7.z)) {
                                VideoController videoController8 = this.a;
                                if (videoController8.a(videoController8.y)) {
                                    this.a.a();
                                    break;
                                }
                            }
                        }
                        break;
                    case 65538:
                        if (this.a.e()) {
                            VideoController videoController9 = this.a;
                            if (videoController9.a == VideoController.VIDEO_STATE.PLAYING && (handler = videoController9.H) != null) {
                                handler.sendEmptyMessage(0);
                            }
                        }
                        VideoController videoController10 = this.a;
                        videoController10.a = VideoController.VIDEO_STATE.COMPLETED;
                        SeekBar seekBar = videoController10.x;
                        if (seekBar != null && (mediaPlayer = videoController10.w) != null) {
                            seekBar.setProgress(mediaPlayer.getDuration());
                            break;
                        }
                        break;
                    case 65542:
                        int iIntValue = ((Integer) message.obj).intValue();
                        SeekBar seekBar2 = this.a.x;
                        if (seekBar2 != null) {
                            seekBar2.setProgress(iIntValue);
                            break;
                        }
                        break;
                    case 65543:
                        VideoController videoController11 = this.a;
                        videoController11.a = VideoController.VIDEO_STATE.PLAYING;
                        SeekBar seekBar3 = videoController11.x;
                        if (seekBar3 != null && (mediaPlayer2 = videoController11.w) != null) {
                            try {
                                seekBar3.setMax(mediaPlayer2.getDuration());
                            } catch (Exception unused) {
                            }
                        }
                        this.a.i.a();
                        break;
                    case 65545:
                        VideoController videoController12 = this.a;
                        videoController12.a = VideoController.VIDEO_STATE.ERROR;
                        videoController12.g();
                        break;
                }
            } catch (Exception unused2) {
            }
        }
    }
}
