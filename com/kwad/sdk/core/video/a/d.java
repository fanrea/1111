package com.kwad.sdk.core.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d extends com.kwad.sdk.core.video.a.a {
    private static volatile boolean bIu = false;
    private static final Queue<d> bIv = new ConcurrentLinkedQueue();
    private final String TAG;
    private com.kwad.sdk.contentalliance.a.a.b abL;
    private boolean acL;
    private final KSVodPlayerWrapper bIr;
    private final a bIs;
    private boolean bIt;
    private boolean bIw;
    private String mDataSource;
    private final Object mInitLock;
    private boolean mIsReleased;
    private MediaDataSource mMediaDataSource;
    private int mSarDen;
    private int mSarNum;

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
    }

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.acL = false;
        return false;
    }

    public d(int i) {
        Object obj = new Object();
        this.mInitLock = obj;
        this.acL = false;
        this.bIw = true;
        synchronized (obj) {
            this.bIr = new KSVodPlayerWrapper(m.arl());
        }
        String str = "KSMediaPlayer[" + i + "]";
        this.TAG = str;
        this.bIs = new a(this, str);
        attachInternalListeners();
        setLooping(false);
        com.kwad.sdk.core.d.c.i(str, "create KwaiMediaPlayer");
    }

    public static synchronized boolean acD() {
        return bIu;
    }

    public final void cB(boolean z) {
        this.bIw = z;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.mInitLock) {
            if (!this.mIsReleased) {
                this.bIr.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(com.kwad.sdk.contentalliance.a.a.b bVar) {
        this.abL = bVar;
        a(bVar.buO);
        f fVar = (f) ServiceProvider.get(f.class);
        if (!TextUtils.isEmpty(bVar.manifest) && fVar != null && fVar.wQ()) {
            setDataSource(bVar.manifest, (Map<String, String>) null);
        } else {
            setDataSource(bVar.videoUrl, (Map<String, String>) null);
        }
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        if (this.bIr == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.WQ();
        this.bIr.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSurface(Surface surface) {
        this.bIr.setSurface(surface);
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.mDataSource = str;
        this.bIr.setDataSource(str, null);
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
    public final boolean prepareAsync() {
        if (this.bIw) {
            Queue<d> queue = bIv;
            if (!queue.contains(this)) {
                queue.offer(this);
            }
            int size = queue.size();
            if (size == 1) {
                com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync first");
                acE();
                return true;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync pending size: " + size);
            return false;
        }
        acE();
        return true;
    }

    private void acE() {
        com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare hasCallPrepare: " + this.acL);
        if (this.acL) {
            return;
        }
        try {
            this.acL = true;
            int iPrepareAsync = this.bIr.prepareAsync();
            acC();
            com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare result: " + iPrepareAsync);
        } catch (IllegalStateException e) {
            com.kwad.sdk.core.d.c.e(this.TAG, "realPrepare failed ", e);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean uv() {
        com.kwad.sdk.core.d.c.i(this.TAG, "forcePrepareAsync");
        acE();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        com.kwad.sdk.core.d.c.i(this.TAG, "start");
        this.bIr.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.bIr.stop();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.bIr.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.bIr.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.bIr.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.bIr;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.bIr.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        this.bIr.seekTo((int) j);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.bIr.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.bIr.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        Queue<d> queue = bIv;
        com.kwad.sdk.core.d.c.i(this.TAG, "release remote player ret: " + queue.remove(this) + ", player list size: " + queue.size());
        this.mIsReleased = true;
        this.bIr.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.1
            @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer.OnVodPlayerReleaseListener
            public final void onPlayerRelease() {
                com.kwad.sdk.core.d.c.i(d.this.TAG, "onPlayerRelease");
            }
        });
        try {
            releaseMediaDataSource();
            resetListeners();
            uw();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.acL = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.bIr.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        this.bIt = z;
        this.bIr.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.bIt;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        this.bIr.setVolume(f, f2);
        L(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.bIr.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        this.bIr.setSpeed(f);
    }

    private void attachInternalListeners() {
        this.bIr.setOnPreparedListener(this.bIs);
        this.bIr.setBufferingUpdateListener(this.bIs);
        this.bIr.setOnEventListener(this.bIs);
        this.bIr.setVideoSizeChangedListener(this.bIs);
        this.bIr.setOnErrorListener(this.bIs);
    }

    private void uw() {
        this.bIr.setOnPreparedListener(null);
        this.bIr.setBufferingUpdateListener(null);
        this.bIr.setOnEventListener(null);
        this.bIr.setVideoSizeChangedListener(null);
        this.bIr.setOnErrorListener(null);
    }

    static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        final String TAG;
        final WeakReference<d> mWeakMediaPlayer;

        a(d dVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
            this.TAG = str;
        }

        private d acG() {
            return this.mWeakMediaPlayer.get();
        }

        @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer.OnEventListener
        public final void onEvent(int i, int i2) {
            com.kwad.sdk.core.d.c.i(this.TAG, "onEvent, what: " + i);
            try {
                d dVarAcG = acG();
                if (dVarAcG != null) {
                    if (i == 10100) {
                        dVarAcG.notifyOnSeekComplete();
                    } else {
                        if (i == 10101) {
                            dVarAcG.notifyOnCompletion();
                            return;
                        }
                        if (i == 10209) {
                            dVarAcG.acF();
                        }
                        dVarAcG.notifyOnInfo(i, i2);
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(int i) {
            d dVarAcG = acG();
            if (dVarAcG != null) {
                dVarAcG.notifyOnBufferingUpdate(i);
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer.OnErrorListener
        public final void onError(int i, int i2) {
            d dVarAcG = acG();
            if (dVarAcG != null) {
                d.a(dVarAcG, false);
                dVarAcG.notifyOnError(i, i2);
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer.OnPreparedListener
        public final void onPrepared() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPrepared");
            d dVarAcG = acG();
            if (dVarAcG != null) {
                dVarAcG.notifyOnPrepared();
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            com.kwad.sdk.core.d.c.i(this.TAG, "onVideoSizeChanged width: " + i + ", height: " + i2 + ", sarNum:" + i3 + ", sarDen:" + i4);
            d dVarAcG = acG();
            if (dVarAcG != null) {
                dVarAcG.H(i, i2);
                dVarAcG.mSarNum = i3;
                dVarAcG.mSarDen = i4;
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.IKSVodPlayer.OnVodPlayerReleaseListener
        public final void onPlayerRelease() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPlayerRelease");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acF() {
        Iterator<d> it = bIv.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i++;
            }
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "preloadNextPlayer next player index: " + i);
        int i2 = i + 1;
        if (i2 < bIv.size()) {
            com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepare next player----------------");
            for (int i3 = 0; i3 < i2; i3++) {
                bIv.poll();
            }
            Queue<d> queue = bIv;
            d dVarPoll = queue.poll();
            queue.clear();
            if (dVarPoll != null) {
                dVarPoll.prepareAsync();
            } else {
                com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }
}
