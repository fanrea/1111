package com.kwad.tachikoma.u;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.VideoMuteStateChangeListener;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.e;
import com.tk.core.o.o;
import com.tkruntime.v8.V8Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends e<BaseKsMediaPlayerView> implements OfflineVideoPlayStateListener, VideoMuteStateChangeListener {
    private float CB;
    private float CC;
    private float CD;
    private float CE;
    private int CG;
    private boolean EY;
    private boolean EZ;
    private long Fa;
    private long Fb;
    private IKsMediaPlayer Fc;
    private IMediaPlayer.OnPreparedListener Fd;
    protected g Fe;
    protected g Ff;
    protected g Fg;
    protected g Fh;
    protected g Fi;
    protected g Fj;
    private Context mContext;

    @Override // com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener
    public final void onVideoPlayBufferingPaused() {
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.EY = true;
        return true;
    }

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.EY = false;
        this.EZ = false;
        this.CG = 0;
        jc();
    }

    private void jc() {
        this.Fc = OfflineHostProvider.getApi().video().createMediaPlayer(getView());
        this.Fc.registerVideoPlayStateListener(this);
        this.Fc.registerVideoMuteStateListener(this);
        this.Fc.setTKPlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public BaseKsMediaPlayerView n(Context context) {
        this.mContext = context;
        return OfflineHostProvider.getApi().video().createMediaPlayerView(context);
    }

    @Override // com.tk.core.component.e
    public final void bY(int i) {
        this.CB = o.eb(i);
        float f = this.CB;
        this.CC = f;
        this.CD = f;
        this.CE = this.CC;
    }

    @Override // com.tk.core.component.e
    public final void bZ(int i) {
        this.CB = o.eb(i);
    }

    @Override // com.tk.core.component.e
    public final void ca(int i) {
        this.CC = o.eb(i);
    }

    @Override // com.tk.core.component.e
    public final void cb(int i) {
        this.CD = o.eb(i);
    }

    @Override // com.tk.core.component.e
    public final void cc(int i) {
        this.CE = o.eb(i);
    }

    public final void O(String str) {
        if (this.Fc == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.kwad.tachikoma.e.log().e("TKVideoPlayer", "videoUrl is null");
            return;
        }
        this.Fc.setRadius(this.CB, this.CC, this.CE, this.CD);
        try {
            if (str.startsWith(UriUtils.FILE_PREFIX)) {
                this.Fc.initMediaPlayer(new PlayVideoInfo.Builder(str).build(), getView());
                return;
            }
            String preCacheUrl = OfflineHostProvider.getApi().cache().getPreCacheUrl(str);
            if (TextUtils.isEmpty(preCacheUrl)) {
                return;
            }
            this.Fc.initMediaPlayer(new PlayVideoInfo.Builder(preCacheUrl).build(), getView());
        } catch (Exception e) {
            com.kwad.tachikoma.e.log().printStackTrace(e);
        }
    }

    public final void jd() {
        getView();
    }

    public final void setVideoAdaptStrategy(int i) {
        this.Fc.setVideoAdaptStrategy(i);
    }

    public final void setMuted(boolean z) {
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer != null) {
            iKsMediaPlayer.setAudioEnabled(!z);
        }
    }

    public final void seekTo(long j) {
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer == null || !iKsMediaPlayer.isPlaying()) {
            return;
        }
        this.Fc.seekTo(j);
    }

    public final void p(V8Function v8Function) {
        g gVar = this.Fi;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fi = new g(v8Function, pO());
    }

    public final void j(V8Function v8Function) {
        g gVar = this.Fh;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fh = new g(v8Function, pO());
    }

    public final void l(V8Function v8Function) {
        g gVar = this.Fg;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fg = new g(v8Function, pO());
    }

    public final void m(V8Function v8Function) {
        g gVar = this.Ff;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Ff = new g(v8Function, pO());
    }

    public final void n(V8Function v8Function) {
        g gVar = this.Fj;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fj = new g(v8Function, pO());
    }

    public final void y(V8Function v8Function) {
        g gVar = new g(v8Function, pO());
        gVar.call(null, new Object[0]);
        gVar.destroy();
    }

    public final void prepareToPlay() {
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer != null) {
            iKsMediaPlayer.prepareAsync();
        }
        if (this.Fd == null) {
            this.Fd = new IMediaPlayer.OnPreparedListener() { // from class: com.kwad.tachikoma.u.a.1
                @Override // com.kwad.components.offline.api.core.video.IMediaPlayer.OnPreparedListener
                public final void onPrepared(IMediaPlayer iMediaPlayer) {
                    if (a.this.Fc == null || !a.this.EZ) {
                        return;
                    }
                    a.a(a.this, true);
                    a.this.Fc.start();
                }
            };
            this.Fc.addOnPreparedListener(this.Fd);
        }
    }

    public final void play() {
        this.EZ = true;
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer == null) {
            return;
        }
        this.EY = true;
        iKsMediaPlayer.start();
    }

    public final void je() {
        this.EZ = true;
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer == null) {
            return;
        }
        this.EY = true;
        iKsMediaPlayer.restart();
    }

    public final void pause() {
        this.EZ = false;
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer != null) {
            iKsMediaPlayer.pause();
        }
    }

    public final void resume() {
        this.EZ = true;
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer != null) {
            if (this.EY) {
                iKsMediaPlayer.resume();
            } else {
                play();
            }
        }
    }

    public final void stop() {
        this.EZ = false;
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer != null) {
            iKsMediaPlayer.releaseAsync();
        }
    }

    public final void setForceGetAudioFocus(boolean z) {
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer != null) {
            iKsMediaPlayer.setForceGetAudioFocus(z);
        }
    }

    public final void setSpeed(float f) {
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer == null || f <= 0.0f) {
            return;
        }
        iKsMediaPlayer.setSpeed(f);
    }

    public final void setIsAlphaVideoPlayer(boolean z) {
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer != null) {
            iKsMediaPlayer.setIsAlphaVideoPlayer(z);
        }
    }

    public final boolean getAlphaVideoValid() {
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer != null) {
            return iKsMediaPlayer.getAlphaVideoValid();
        }
        return false;
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        g gVar = this.Fe;
        if (gVar != null) {
            gVar.destroy();
        }
        g gVar2 = this.Ff;
        if (gVar2 != null) {
            gVar2.destroy();
        }
        g gVar3 = this.Fg;
        if (gVar3 != null) {
            gVar3.destroy();
        }
        g gVar4 = this.Fh;
        if (gVar4 != null) {
            gVar4.destroy();
        }
        g gVar5 = this.Fj;
        if (gVar5 != null) {
            gVar5.destroy();
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        IKsMediaPlayer iKsMediaPlayer = this.Fc;
        if (iKsMediaPlayer != null) {
            iKsMediaPlayer.releaseAsync();
        }
    }

    private void cd(int i) {
        if (this.CG == i) {
            return;
        }
        this.CG = i;
        g gVar = this.Fj;
        if (gVar != null) {
            gVar.call(null, Integer.valueOf(i));
        }
    }

    public final void k(V8Function v8Function) {
        g gVar = this.Fe;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fe = new g(v8Function, pO());
    }

    @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
    public final void onMediaPreparing() {
        com.kwad.tachikoma.e.log().d("TKVideoPlayer", "====++++ video preparing");
    }

    @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
    public final void onMediaPrepared() {
        com.kwad.tachikoma.e.log().d("TKVideoPlayer", "====++++ video prepared");
        cd(1);
    }

    @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
    public final void onMediaPlayProgress(long j, long j2) {
        com.kwad.tachikoma.e.log().d("TKVideoPlayer", "====++++ video progress:" + j + ":" + j2);
        if (this.Fa == j && j2 == this.Fb) {
            return;
        }
        this.Fa = j;
        this.Fb = j2;
        g gVar = this.Fe;
        if (gVar != null) {
            double d = j2;
            Double.isNaN(d);
            double d2 = j;
            Double.isNaN(d2);
            double d3 = d2 / 1000.0d;
            gVar.call(null, Double.valueOf(d / 1000.0d), Double.valueOf(d3), Double.valueOf(d3));
        }
    }

    @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
    public final void onMediaPlayStart() {
        com.kwad.tachikoma.e.log().d("TKVideoPlayer", "====++++ video play start");
        g gVar = this.Fh;
        if (gVar != null) {
            gVar.call(null, new Object[0]);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
    public final void onMediaPlaying() {
        com.kwad.tachikoma.e.log().d("TKVideoPlayer", "====++++ video playing");
        cd(3);
    }

    @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
    public final void onMediaPlayPaused() {
        com.kwad.tachikoma.e.log().d("TKVideoPlayer", "====++++ video paused");
        cd(4);
    }

    @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
    public final void onMediaPlayCompleted() {
        com.kwad.tachikoma.e.log().d("TKVideoPlayer", "====++++ video completed");
        cd(5);
        g gVar = this.Fg;
        if (gVar != null) {
            gVar.call(null, new Object[0]);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
    public final void onMediaPlayError(int i, int i2) {
        cd(8);
        g gVar = this.Ff;
        if (gVar != null) {
            gVar.call(null, Integer.valueOf(i), String.valueOf(i2));
        }
    }

    @Override // com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener
    public final void onVideoPlayBufferingPlaying() {
        cd(6);
    }

    @Override // com.kwad.components.offline.api.core.video.listener.VideoMuteStateChangeListener
    public final void onMuteStateChanged(boolean z) {
        g gVar = this.Fi;
        if (gVar != null) {
            gVar.call(null, Boolean.valueOf(z));
        }
    }
}
