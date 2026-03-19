package com.kwad.components.core.p.b.c;

import android.media.TimedText;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.n;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    public static com.kwad.sdk.contentalliance.a.a.b a(PlayVideoInfo playVideoInfo) {
        if (playVideoInfo == null) {
            return null;
        }
        return new b.a(playVideoInfo.videoUrl).ex(playVideoInfo.manifest).b(a(playVideoInfo.ksplayerLogParams)).a(playVideoInfo.videoPlayerStatus).cu(playVideoInfo.isNoCache).WR();
    }

    public static com.kwad.sdk.contentalliance.a.a.a a(KsPlayerLogParams ksPlayerLogParams) {
        if (ksPlayerLogParams == null) {
            return null;
        }
        com.kwad.sdk.contentalliance.a.a.a aVar = new com.kwad.sdk.contentalliance.a.a.a();
        aVar.photoId = ksPlayerLogParams.photoId;
        aVar.clickTime = ksPlayerLogParams.clickTime;
        aVar.adStyle = ksPlayerLogParams.adStyle;
        aVar.contentType = ksPlayerLogParams.contentType;
        return aVar;
    }

    public static c.e a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener == null) {
            return null;
        }
        return new c.e() { // from class: com.kwad.components.core.p.b.c.d.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    onPreparedListener.onPrepared(iMediaPlayer);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
    }

    public static c.b a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener == null) {
            return null;
        }
        return new c.b() { // from class: com.kwad.components.core.p.b.c.d.4
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void qY() {
                onCompletionListener.onCompletion(iMediaPlayer);
            }
        };
    }

    public static c.a a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener == null) {
            return null;
        }
        return new c.a() { // from class: com.kwad.components.core.p.b.c.d.5
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void aQ(int i) {
                onBufferingUpdateListener.onBufferingUpdate(iMediaPlayer, i);
            }
        };
    }

    public static c.g a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener == null) {
            return null;
        }
        return new c.g() { // from class: com.kwad.components.core.p.b.c.d.6
            @Override // com.kwad.sdk.core.video.a.c.g
            public final void qZ() {
                onSeekCompleteListener.onSeekComplete(iMediaPlayer);
            }
        };
    }

    public static c.i a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return null;
        }
        return new c.i() { // from class: com.kwad.components.core.p.b.c.d.7
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void m(int i, int i2) {
                onVideoSizeChangedListener.onVideoSizeChanged(iMediaPlayer, i, i2);
            }
        };
    }

    public static c.InterfaceC0592c a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener == null) {
            return null;
        }
        return new c.InterfaceC0592c() { // from class: com.kwad.components.core.p.b.c.d.8
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0592c
            public final boolean n(int i, int i2) {
                return onErrorListener.onError(iMediaPlayer, i, i2);
            }
        };
    }

    public static c.d a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener == null) {
            return null;
        }
        return new c.d() { // from class: com.kwad.components.core.p.b.c.d.9
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean o(int i, int i2) {
                return onInfoListener.onInfo(iMediaPlayer, i, i2);
            }
        };
    }

    public static c.h a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener == null) {
            return null;
        }
        return new c.h() { // from class: com.kwad.components.core.p.b.c.d.10
            @Override // com.kwad.sdk.core.video.a.c.h
            public final void a(TimedText timedText) {
                onTimedTextListener.onTimedText(iMediaPlayer, timedText);
            }
        };
    }

    public static n a(final OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        if (offlineVideoPlayStateListener == null) {
            return null;
        }
        return new n() { // from class: com.kwad.components.core.p.b.c.d.11
            @Override // com.kwad.components.core.video.k
            public final void onMediaPreparing() {
                offlineVideoPlayStateListener.onMediaPreparing();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPrepared() {
                offlineVideoPlayStateListener.onMediaPrepared();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlayProgress(long j, long j2) {
                offlineVideoPlayStateListener.onMediaPlayProgress(j, j2);
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                offlineVideoPlayStateListener.onMediaPlayStart();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlaying() {
                offlineVideoPlayStateListener.onMediaPlaying();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlayPaused() {
                offlineVideoPlayStateListener.onMediaPlayPaused();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                offlineVideoPlayStateListener.onMediaPlayCompleted();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                offlineVideoPlayStateListener.onMediaPlayError(i, i2);
            }

            @Override // com.kwad.components.core.video.n
            public final void onVideoPlayBufferingPlaying() {
                offlineVideoPlayStateListener.onVideoPlayBufferingPlaying();
            }

            @Override // com.kwad.components.core.video.n
            public final void onVideoPlayBufferingPaused() {
                offlineVideoPlayStateListener.onVideoPlayBufferingPaused();
            }
        };
    }

    public static k a(final OfflineMediaPlayStateListener offlineMediaPlayStateListener) {
        if (offlineMediaPlayStateListener == null) {
            return null;
        }
        return new k() { // from class: com.kwad.components.core.p.b.c.d.2
            @Override // com.kwad.components.core.video.k
            public final void onMediaPreparing() {
                offlineMediaPlayStateListener.onMediaPreparing();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPrepared() {
                offlineMediaPlayStateListener.onMediaPrepared();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlayProgress(long j, long j2) {
                offlineMediaPlayStateListener.onMediaPlayProgress(j, j2);
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                offlineMediaPlayStateListener.onMediaPlayStart();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlaying() {
                offlineMediaPlayStateListener.onMediaPlaying();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlayPaused() {
                offlineMediaPlayStateListener.onMediaPlayPaused();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                offlineMediaPlayStateListener.onMediaPlayCompleted();
            }

            @Override // com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                offlineMediaPlayStateListener.onMediaPlayError(i, i2);
            }
        };
    }

    public static b.a a(final ReleaseCallback releaseCallback) {
        if (releaseCallback == null) {
            return null;
        }
        return new b.a() { // from class: com.kwad.components.core.p.b.c.d.3
            @Override // com.kwad.components.core.video.b.a
            public final void onReleaseSuccess() {
                releaseCallback.onReleaseSuccess();
            }
        };
    }
}
