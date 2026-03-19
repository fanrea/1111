package com.kwad.sdk.core.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwad.sdk.service.ServiceProvider;
import com.sigmob.sdk.base.n;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b extends com.kwad.sdk.core.video.a.a {
    private boolean acM;
    private final a bIq;
    private String mDataSource;
    private final Object mInitLock;
    private final MediaPlayer mInternalMediaPlayer;
    private boolean mIsReleased;
    private MediaDataSource mMediaDataSource;

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        return "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 1;
    }

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.acM = true;
        return true;
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.mInitLock = obj;
        this.acM = false;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.mInternalMediaPlayer = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.bIq = new a(this);
        attachInternalListeners();
        setLooping(false);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.mInitLock) {
            if (!this.mIsReleased) {
                this.mInternalMediaPlayer.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSurface(Surface surface) {
        this.mInternalMediaPlayer.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.mInternalMediaPlayer.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.mDataSource = str;
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(n.z)) {
            this.mInternalMediaPlayer.setDataSource(uri.getPath());
        } else {
            this.mInternalMediaPlayer.setDataSource(str);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(com.kwad.sdk.contentalliance.a.a.b bVar) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (bVar.isNoCache) {
            HashMap map = new HashMap();
            map.put("Content-Type", "video/mp4");
            map.put("Accept-Ranges", "bytes");
            map.put("Status", "206");
            map.put("Cache-control", "no-cache");
            setDataSource(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext(), Uri.parse(bVar.videoUrl), map);
            return;
        }
        setDataSource(bVar.videoUrl);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.mDataSource;
    }

    private void releaseMediaDataSource() {
        MediaDataSource mediaDataSource = this.mMediaDataSource;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.mMediaDataSource = null;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() throws IllegalStateException {
        this.mInternalMediaPlayer.prepareAsync();
        acC();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean uv() throws IllegalStateException {
        this.mInternalMediaPlayer.prepareAsync();
        acC();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() throws IllegalStateException {
        this.mInternalMediaPlayer.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() throws IllegalStateException {
        this.mInternalMediaPlayer.stop();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() throws IllegalStateException {
        this.mInternalMediaPlayer.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.mInternalMediaPlayer.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) throws IllegalStateException {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInternalMediaPlayer.seekTo((int) j, 3);
        } else {
            this.mInternalMediaPlayer.seekTo((int) j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.mInternalMediaPlayer.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.mInternalMediaPlayer.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        try {
            this.mIsReleased = true;
            this.mInternalMediaPlayer.release();
            releaseMediaDataSource();
            resetListeners();
            uw();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        try {
            this.mInternalMediaPlayer.reset();
            this.acM = false;
        } catch (IllegalStateException unused) {
        }
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        this.mInternalMediaPlayer.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        this.mInternalMediaPlayer.setVolume(f, f2);
        L(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                PlaybackParams playbackParams = this.mInternalMediaPlayer.getPlaybackParams();
                if (playbackParams == null) {
                    playbackParams = new PlaybackParams();
                }
                playbackParams.setSpeed(f);
                this.mInternalMediaPlayer.setPlaybackParams(playbackParams);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
        this.mInternalMediaPlayer.setAudioStreamType(i);
    }

    private void attachInternalListeners() {
        this.mInternalMediaPlayer.setOnPreparedListener(this.bIq);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.bIq);
        this.mInternalMediaPlayer.setOnCompletionListener(this.bIq);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(this.bIq);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.bIq);
        this.mInternalMediaPlayer.setOnErrorListener(this.bIq);
        this.mInternalMediaPlayer.setOnInfoListener(this.bIq);
        this.mInternalMediaPlayer.setOnTimedTextListener(this.bIq);
    }

    private void uw() {
        this.mInternalMediaPlayer.setOnPreparedListener(null);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(null);
        this.mInternalMediaPlayer.setOnCompletionListener(null);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(null);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(null);
        this.mInternalMediaPlayer.setOnErrorListener(null);
        this.mInternalMediaPlayer.setOnInfoListener(null);
        this.mInternalMediaPlayer.setOnTimedTextListener(null);
    }

    static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        final WeakReference<b> mWeakMediaPlayer;

        a(b bVar) {
            this.mWeakMediaPlayer = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar == null) {
                return false;
            }
            if (i == 3) {
                if (bVar.acM) {
                    return false;
                }
                b.a(bVar, true);
                return bVar.notifyOnInfo(i, i2);
            }
            return bVar.notifyOnInfo(i, i2);
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnError(i, i2);
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.H(i, i2);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnBufferingUpdate(i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.b(timedText);
            }
        }
    }
}
