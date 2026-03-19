package com.sigmob.sdk.base.views;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c extends RelativeLayout implements MediaPlayer.OnBufferingUpdateListener, SurfaceHolder.Callback {
    SurfaceView a;
    private MediaPlayer b;
    private SurfaceHolder c;
    private String d;
    private int e;
    private int f;
    private int g;

    public c(Context context) {
        super(context);
        this.b = null;
        this.d = "";
        SurfaceView surfaceView = new SurfaceView(context);
        this.a = surfaceView;
        addView(surfaceView, new ViewGroup.LayoutParams(-1, -1));
        SurfaceHolder holder = this.a.getHolder();
        this.c = holder;
        holder.addCallback(this);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.b = mediaPlayer;
        mediaPlayer.setLooping(true);
        this.b.setOnBufferingUpdateListener(this);
    }

    private void g() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        try {
            this.b.reset();
            this.b.setDataSource(this.d);
            this.b.prepareAsync();
        } catch (IOException e) {
            SigmobLog.e(e.getMessage());
        }
    }

    public void a() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.b.pause();
        this.g = this.b.getCurrentPosition();
        com.sigmob.sdk.videoplayer.c.g(com.sigmob.sdk.b.e());
    }

    public void a(int position) throws IllegalStateException {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(position);
        }
    }

    public void a(int width, int height) {
        this.e = width;
        this.f = height;
    }

    public void a(boolean z) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            float f = !z ? 1 : 0;
            mediaPlayer.setVolume(f, f);
        }
    }

    public void b() throws IllegalStateException {
        if (this.b == null) {
            return;
        }
        if (r0.getCurrentPosition() == 0) {
            this.b.seekTo(this.g);
        }
        this.b.start();
        com.sigmob.sdk.videoplayer.c.f(com.sigmob.sdk.b.e());
    }

    public void c() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.stop();
        this.b.reset();
        this.b.release();
        this.b = null;
    }

    public void d() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        com.sigmob.sdk.videoplayer.c.f(com.sigmob.sdk.b.e());
    }

    public void e() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void f() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int defaultSize = getDefaultSize(0, widthMeasureSpec);
        int defaultSize2 = getDefaultSize(0, heightMeasureSpec);
        int i = this.f;
        int i2 = this.e;
        if (defaultSize2 > defaultSize) {
            if (i <= i2) {
                defaultSize2 = (int) (defaultSize * (i / i2));
            }
        } else if (i > i2) {
            defaultSize = (int) (defaultSize2 * (i2 / i));
        }
        int i3 = this.f;
        if (i3 != this.e) {
            setMeasuredDimension(defaultSize, defaultSize2);
        } else if (i3 == -1) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener listener) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(listener);
        }
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.b.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public void setVideoPath(String videoPath) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.d = videoPath;
        g();
    }

    public void setVolume(int i) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            float f = i;
            mediaPlayer.setVolume(f, f);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(holder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) throws IllegalStateException {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.b.stop();
        this.b.reset();
        this.b.release();
        com.sigmob.sdk.videoplayer.c.g(com.sigmob.sdk.b.e());
        this.b = null;
    }
}
