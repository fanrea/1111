package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ip extends TextureView implements com.qq.e.comm.plugin.va.m.p, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnInfoListener, TextureView.SurfaceTextureListener {
    private String a;
    private final com.qq.e.comm.plugin.va.m.q b;
    private volatile MediaPlayer c;
    private volatile SurfaceTexture d;
    private volatile Surface e;
    private final AtomicBoolean f;
    private final AtomicBoolean g;
    private final AtomicBoolean h;
    private final AtomicBoolean i;
    private Handler j;

    private String b() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            return "# null id";
        }
        return "# " + looperMyLooper.getThread().getId();
    }

    @Override // com.qq.e.comm.plugin.jj
    public int getPlayerVersion() {
        return 1;
    }

    @Override // com.qq.e.comm.plugin.va.m.p
    public int getT() {
        return 0;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        mediaPlayer.getCurrentPosition();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // com.qq.e.comm.plugin.jj
    public void setSpeed(float f) {
        try {
            if (Build.VERSION.SDK_INT >= 23 && this.c != null) {
                PlaybackParams playbackParams = this.c.getPlaybackParams();
                playbackParams.setSpeed(f);
                this.c.setPlaybackParams(playbackParams);
            }
        } catch (Exception unused) {
        }
    }

    public ip(Context context, com.qq.e.comm.plugin.va.m.q qVar) {
        super(context);
        this.a = "ip";
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = new AtomicBoolean(false);
        b();
        this.b = qVar;
        setSurfaceTextureListener(this);
    }

    private void k() {
        Handler handler = this.j;
        if (handler == null) {
            return;
        }
        handler.post(new a());
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            ip.this.play();
        }
    }

    @Override // com.qq.e.comm.plugin.jj
    public void play() throws IllegalStateException {
        this.g.set(true);
        if (this.i.get() && this.f.get() && this.c != null) {
            this.c.start();
            this.b.onP();
        }
    }

    @Override // com.qq.e.comm.plugin.jj
    public void pause() throws IllegalStateException {
        if (this.c == null) {
            return;
        }
        this.c.pause();
    }

    @Override // com.qq.e.comm.plugin.jj
    public void seekTo(int i) throws IllegalStateException {
        if (this.c == null) {
            return;
        }
        this.c.seekTo(i);
    }

    @Override // com.qq.e.comm.plugin.jj
    public boolean isPlaying() {
        if (this.c == null) {
            return false;
        }
        return this.c.isPlaying();
    }

    @Override // com.qq.e.comm.plugin.jj
    public int getDuration() {
        if (this.c != null && this.i.get()) {
            return this.c.getDuration();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.jj
    public int getCurrentPosition() {
        if (this.c == null) {
            return 0;
        }
        return this.c.getCurrentPosition();
    }

    @Override // com.qq.e.comm.plugin.jj
    public void free() {
        a(true);
    }

    @Override // com.qq.e.comm.plugin.va.m.p
    public void relea() {
        a(false);
        this.h.set(false);
    }

    @Override // com.qq.e.comm.plugin.va.m.p
    public void resto() {
        if (this.c == null) {
            initP();
        } else {
            l();
        }
        m();
    }

    private void m() {
        this.i.set(false);
        this.g.set(false);
    }

    private void a(boolean z) {
        if (this.c != null) {
            this.c.release();
            this.c = null;
        } else if (z) {
            this.d = null;
        }
    }

    @Override // com.qq.e.comm.plugin.va.m.p
    public void res() {
        try {
            if (this.c == null) {
                return;
            }
            this.c.reset();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.qq.e.comm.plugin.va.m.p
    public boolean isV() {
        return this.c != null;
    }

    @Override // com.qq.e.comm.plugin.jj
    public void setDataSource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        m();
        try {
            if (this.c == null) {
                return;
            }
            l();
            this.c.setDataSource(str);
            this.h.set(true);
            this.c.prepareAsync();
        } catch (Exception e) {
            e.getMessage();
            this.b.onE(5003, e);
        }
    }

    private void l() {
        try {
            if (this.c == null) {
                return;
            }
            this.c.reset();
        } catch (Throwable unused) {
            initP();
        }
    }

    @Override // com.qq.e.comm.plugin.va.m.p
    public void initP() {
        b();
        this.c = new MediaPlayer();
        this.c.setOnPreparedListener(this);
        this.c.setOnCompletionListener(this);
        this.c.setOnErrorListener(this);
        this.c.setOnSeekCompleteListener(this);
        this.c.setOnVideoSizeChangedListener(this);
        this.c.setOnInfoListener(this);
    }

    @Override // com.qq.e.comm.plugin.va.m.p
    public void setV(float f, float f2) {
        try {
            if (this.c == null) {
                return;
            }
            this.c.setVolume(f, f2);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.b.onPre(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        this.i.set(true);
        if (this.g.get() && this.f.get()) {
            k();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.b.onC();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.b.onE(i, new Exception(i2 + ""));
        return true;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.b.onCha(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 701) {
            this.b.onStar();
            return false;
        }
        if (i != 702) {
            return false;
        }
        this.b.onEnd();
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        b();
        if (this.d == null) {
            this.d = surfaceTexture;
        } else if (Build.VERSION.SDK_INT >= 16) {
            setSurfaceTexture(this.d);
        } else {
            this.d.release();
            this.d = surfaceTexture;
            if (this.e != null) {
                this.e.release();
            }
            this.e = new Surface(this.d);
        }
        this.b.onAva();
        Handler handler = this.j;
        if (handler == null) {
            return;
        }
        handler.post(new b());
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ip.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.d == null || this.c == null) {
            return;
        }
        if (this.e == null) {
            this.e = new Surface(this.d);
        }
        this.c.setSurface(this.e);
        this.f.set(true);
        if (this.h.get() && this.g.get() && this.i.get()) {
            k();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.b.onDes();
        this.g.set(false);
        this.f.set(false);
        return this.d == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.d = surfaceTexture;
    }

    @Override // com.qq.e.comm.plugin.va.m.p
    public void setWor(Handler handler) {
        this.j = handler;
    }

    @Override // com.qq.e.comm.plugin.va.m.p
    public boolean isDa() {
        return this.h.get();
    }
}
