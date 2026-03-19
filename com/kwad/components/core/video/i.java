package com.kwad.components.core.video;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i extends com.kwad.sdk.core.video.a.a {
    private static AtomicBoolean acK = new AtomicBoolean(false);
    private final a acI;
    private IAdWaynePlayerPlayModule acJ;
    private boolean acL;
    private boolean acM;
    private AdTemplate mAdTemplate;
    private String mDataSource;
    private final Object mInitLock;
    private boolean mIsReleased;

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 3;
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

    static /* synthetic */ boolean a(i iVar, boolean z) {
        iVar.acM = true;
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule;
        synchronized (this.mInitLock) {
            if (!this.mIsReleased && (iAdWaynePlayerPlayModule = this.acJ) != null) {
                iAdWaynePlayerPlayModule.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        if (this.acJ != null) {
            this.mDataSource = str;
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(com.sigmob.sdk.base.n.z)) {
                this.acJ.setDataSource(uri.getPath(), false);
            } else {
                this.acJ.setDataSource(str, false);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(com.kwad.sdk.contentalliance.a.a.b bVar) {
        if (this.acJ != null) {
            if (!TextUtils.isEmpty(bVar.manifest)) {
                this.mDataSource = bVar.manifest;
                this.acJ.setDataSource(bVar.manifest, true);
            } else {
                this.mDataSource = bVar.videoUrl;
                this.acJ.setDataSource(bVar.videoUrl, false);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.mDataSource;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule;
        if (!this.acL && (iAdWaynePlayerPlayModule = this.acJ) != null) {
            try {
                this.acL = true;
                boolean zPrepareAsync = iAdWaynePlayerPlayModule.prepareAsync();
                acC();
                com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "prepareAsync result: " + zPrepareAsync);
                return zPrepareAsync;
            } catch (IllegalStateException e) {
                com.kwad.sdk.core.d.c.e("KwaiWaynePlayer", "prepareAsync failed ", e);
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        if (this.acJ != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "start");
            this.acJ.start();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean uv() {
        return prepareAsync();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        if (this.acJ != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", com.component.feed.a.e);
            this.acJ.stop();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        if (this.acJ != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "pause");
            this.acJ.pause();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getVideoWidth();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getVideoHeight();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        return iAdWaynePlayerPlayModule != null ? iAdWaynePlayerPlayModule.getCurrentPlayingUrl() : "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.isPlaying();
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.seekTo(j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getDuration();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            this.mIsReleased = true;
            iAdWaynePlayerPlayModule.release();
            try {
                resetListeners();
                uw();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.acL = false;
        try {
            IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
            if (iAdWaynePlayerPlayModule != null) {
                iAdWaynePlayerPlayModule.reset();
                resetListeners();
                attachInternalListeners();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setVolume(f, f2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        try {
            IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
            if (iAdWaynePlayerPlayModule != null) {
                iAdWaynePlayerPlayModule.setSpeed(f);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getAudioSessionId();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setLooping(z);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.isLooping();
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSurface(Surface surface) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setSurface(surface);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setAudioStreamType(i);
        }
    }

    private void attachInternalListeners() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setOnPreparedListener(this.acI);
            this.acJ.setOnCompletionListener(this.acI);
            this.acJ.setOnBufferingUpdateListener(this.acI);
            this.acJ.setOnSeekCompleteListener(this.acI);
            this.acJ.setOnVideoSizeChangedListener(this.acI);
            this.acJ.setOnErrorListener(this.acI);
            this.acJ.setOnInfoListener(this.acI);
            this.acJ.setOnVseReportListener(this.acI);
        }
    }

    private void uw() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.acJ;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setOnPreparedListener(null);
            this.acJ.setOnCompletionListener(null);
            this.acJ.setOnBufferingUpdateListener(null);
            this.acJ.setOnSeekCompleteListener(null);
            this.acJ.setOnVideoSizeChangedListener(null);
            this.acJ.setOnErrorListener(null);
            this.acJ.setOnInfoListener(null);
            this.acJ.setOnVseReportListener(null);
        }
    }

    public final void n(String str, String str2) {
        final com.kwad.components.core.video.a.e eVar = new com.kwad.components.core.video.a.e();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            eVar.setAdTemplate(adTemplate);
        }
        eVar.aV(str);
        eVar.aW(str2);
        com.kwad.sdk.utils.h.execute(new bh() { // from class: com.kwad.components.core.video.i.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.t(eVar);
            }
        });
    }

    static class a implements IAdWaynePlayerPlayModule.OnBufferingUpdateListener, IAdWaynePlayerPlayModule.OnCompletionListener, IAdWaynePlayerPlayModule.OnErrorListener, IAdWaynePlayerPlayModule.OnInfoListener, IAdWaynePlayerPlayModule.OnPreparedListener, IAdWaynePlayerPlayModule.OnSeekCompleteListener, IAdWaynePlayerPlayModule.OnVideoSizeChangedListener, IAdWaynePlayerPlayModule.OnVseReportListener {
        final WeakReference<i> mWeakMediaPlayer;

        private i ux() {
            return this.mWeakMediaPlayer.get();
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnPreparedListener
        public final void onPrepared() {
            i iVarUx = ux();
            if (iVarUx != null) {
                iVarUx.notifyOnPrepared();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnInfoListener
        public final boolean onInfo(int i, int i2) {
            i iVarUx = ux();
            if (iVarUx == null) {
                return false;
            }
            if (i == 3) {
                if (iVarUx.acM) {
                    return false;
                }
                i.a(iVarUx, true);
                return iVarUx.notifyOnInfo(i, i2);
            }
            return iVarUx.notifyOnInfo(i, i2);
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnErrorListener
        public final boolean onError(int i, int i2) {
            i iVarUx = ux();
            if (iVarUx != null) {
                return iVarUx.notifyOnError(i, i2);
            }
            return false;
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(int i, int i2) {
            i iVarUx = ux();
            if (iVarUx != null) {
                iVarUx.H(i, i2);
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnSeekCompleteListener
        public final void onSeekComplete() {
            i iVarUx = ux();
            if (iVarUx != null) {
                iVarUx.notifyOnSeekComplete();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnBufferingUpdateListener
        public final void onBufferingUpdate(int i) {
            i iVarUx = ux();
            if (iVarUx != null) {
                iVarUx.notifyOnBufferingUpdate(i);
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnCompletionListener
        public final void onCompletion() {
            i iVarUx = ux();
            if (iVarUx != null) {
                iVarUx.notifyOnCompletion();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnVseReportListener
        public final void onVseReport(String str, String str2) {
            i iVarUx = ux();
            if (iVarUx != null) {
                iVarUx.n(str, str2);
            }
        }
    }
}
