package com.bykv.vk.openvk.component.video.d.c;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.component.utils.mq;
import com.sigmob.sdk.base.n;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends com.bykv.vk.openvk.component.video.d.c.d {
    private final Object an;
    private final d b;
    private com.bykv.vk.openvk.component.video.d.d.d c;
    private volatile boolean h;
    private final MediaPlayer hc;
    private Surface u;

    public hc() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.an = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.hc = mediaPlayer;
        }
        d(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "setAudioStreamType error: ", th);
        }
        this.b = new d(this);
        cb();
    }

    private void d(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.bykv.vk.openvk.component.video.api.b.getContext(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(objNewInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
            } catch (Throwable th) {
                try {
                    com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "subtitleInstance error: ", th);
                } finally {
                    declaredField.setAccessible(false);
                }
            }
        } catch (Throwable th2) {
            com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "setSubtitleController error: ", th2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void d(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.an) {
            try {
            } finally {
            }
            if (!this.h && surfaceHolder != null && surfaceHolder.getSurface() != null && this.d) {
                this.hc.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void d(Surface surface) {
        w();
        this.u = surface;
        this.hc.setSurface(surface);
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void d(com.bykv.vk.openvk.component.video.api.hc hcVar) throws Throwable {
        if (Build.VERSION.SDK_INT >= 23) {
            this.hc.setPlaybackParams(this.hc.getPlaybackParams().setSpeed(hcVar.d()));
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void d(String str) throws Throwable {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(n.z)) {
            this.hc.setDataSource(uri.getPath());
        } else {
            this.hc.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void d(FileDescriptor fileDescriptor) throws Throwable {
        this.hc.setDataSource(fileDescriptor);
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public synchronized void d(com.bykv.vk.openvk.component.video.api.b.c cVar) {
        this.c = com.bykv.vk.openvk.component.video.d.d.d.d(com.bykv.vk.openvk.component.video.api.b.getContext(), cVar);
        com.bykv.vk.openvk.component.video.d.d.hc.b.d(cVar);
        this.hc.setDataSource(this.c);
    }

    private void e() {
        com.bykv.vk.openvk.component.video.d.d.d dVar;
        if (Build.VERSION.SDK_INT < 23 || (dVar = this.c) == null) {
            return;
        }
        try {
            dVar.close();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "releaseMediaDataSource error: ", th);
        }
        this.c = null;
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void u() throws Throwable {
        this.hc.start();
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void an() throws Throwable {
        this.hc.stop();
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void h() throws Throwable {
        this.hc.pause();
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void gb() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.hc;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void hc(boolean z) throws Throwable {
        this.hc.setScreenOnWhilePlaying(z);
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void d(long j, int i) throws Throwable {
        if (Build.VERSION.SDK_INT < 26) {
            this.hc.seekTo((int) j);
            return;
        }
        if (i == 0) {
            this.hc.seekTo((int) j, 0);
            return;
        }
        if (i == 1) {
            this.hc.seekTo((int) j, 1);
            return;
        }
        if (i == 2) {
            this.hc.seekTo((int) j, 2);
        } else if (i == 3) {
            this.hc.seekTo((int) j, 3);
        } else {
            this.hc.seekTo((int) j);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public long tt() {
        try {
            return this.hc.getCurrentPosition();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public long tc() {
        try {
            return this.hc.getDuration();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void mk() throws Throwable {
        synchronized (this.an) {
            if (!this.h) {
                this.hc.release();
                this.h = true;
                w();
                e();
                d();
                cb();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void mq() throws Throwable {
        try {
            this.hc.reset();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "reset error: ", th);
        }
        e();
        d();
        cb();
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void b(boolean z) throws Throwable {
        this.hc.setLooping(z);
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void c(boolean z) throws Throwable {
        MediaPlayer mediaPlayer = this.hc;
        if (mediaPlayer == null) {
            return;
        }
        if (z) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public int uo() {
        MediaPlayer mediaPlayer = this.hc;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public int k() {
        MediaPlayer mediaPlayer = this.hc;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void u(boolean z) {
        try {
            MediaPlayer mediaPlayer = this.hc;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private void cb() {
        this.hc.setOnPreparedListener(this.b);
        this.hc.setOnBufferingUpdateListener(this.b);
        this.hc.setOnCompletionListener(this.b);
        this.hc.setOnSeekCompleteListener(this.b);
        this.hc.setOnVideoSizeChangedListener(this.b);
        this.hc.setOnErrorListener(this.b);
        this.hc.setOnInfoListener(this.b);
    }

    private static class d implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<hc> d;

        public d(hc hcVar) {
            this.d = new WeakReference<>(hcVar);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO", "onInfo: ");
                hc hcVar = this.d.get();
                if (hcVar != null) {
                    if (hcVar.hc(i, i2)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO", "onError: ", Integer.valueOf(i), Integer.valueOf(i2));
                hc hcVar = this.d.get();
                if (hcVar != null) {
                    if (hcVar.d(i, i2)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                hc hcVar = this.d.get();
                if (hcVar != null) {
                    hcVar.d(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                hc hcVar = this.d.get();
                if (hcVar != null) {
                    hcVar.c();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                hc hcVar = this.d.get();
                if (hcVar != null) {
                    hcVar.d(i);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                hc hcVar = this.d.get();
                if (hcVar != null) {
                    hcVar.b();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                hc hcVar = this.d.get();
                if (hcVar != null) {
                    hcVar.hc();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        w();
    }

    private void w() {
        try {
            Surface surface = this.u;
            if (surface != null) {
                surface.release();
                this.u = null;
            }
        } catch (Throwable unused) {
        }
    }
}
