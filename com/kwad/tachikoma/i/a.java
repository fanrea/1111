package com.kwad.tachikoma.i;

import android.content.Context;
import android.widget.FrameLayout;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.imageplayer.IImagePlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.e;
import com.tk.core.o.o;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends e<FrameLayout> {
    private g CA;
    private float CB;
    private float CC;
    private float CD;
    private float CE;
    private C0639a CF;
    private IImagePlayer Cv;
    private g Cw;
    private g Cx;
    private g Cy;
    private g Cz;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public FrameLayout n(Context context) {
        this.Cv = OfflineHostProvider.getApi().imagePlayer();
        this.CF = new C0639a(this, (byte) 0);
        this.Cv.registerMediaPlayStateListener(this.CF);
        return this.Cv.getImagePlayerView(context);
    }

    public final void b(V8Array v8Array) {
        this.Cv.setURLs(v8Array.getList());
    }

    public final void setDuration(long j) {
        this.Cv.setDuration(j);
    }

    public final void setImageResize(int i) {
        this.Cv.setImageResize(i);
    }

    public final void setVerticalGravity(int i) {
        this.Cv.setVerticalGravity(i);
    }

    public final void setHorizontalGravity(int i) {
        this.Cv.setHorizontalGravity(i);
    }

    public final void prepareToPlay() {
        this.Cv.prepareToPlay();
    }

    public final void play() {
        this.Cv.play();
    }

    public final void pause() {
        this.Cv.pause();
    }

    public final void resume() {
        this.Cv.resume();
    }

    public final void stop() {
        IImagePlayer iImagePlayer = this.Cv;
        if (iImagePlayer != null) {
            iImagePlayer.stop();
            this.Cv.destroy();
        }
    }

    public final void setEnableCache(boolean z) {
        this.Cv.setEnableCache(z);
    }

    public final void j(V8Function v8Function) {
        a(this.Cw);
        this.Cw = new g(v8Function, pO());
    }

    public final void k(V8Function v8Function) {
        a(this.Cx);
        this.Cx = new g(v8Function, pO());
    }

    public final void l(V8Function v8Function) {
        a(this.Cy);
        this.Cy = new g(v8Function, pO());
    }

    public final void m(V8Function v8Function) {
        a(this.Cz);
        this.Cz = new g(v8Function, pO());
    }

    public final void n(V8Function v8Function) {
        a(this.CA);
        this.CA = new g(v8Function, pO());
    }

    public final void setSpeed(float f) {
        IImagePlayer iImagePlayer = this.Cv;
        if (iImagePlayer == null || f <= 0.0f) {
            return;
        }
        iImagePlayer.setSpeed(f);
    }

    @Override // com.tk.core.component.e
    public final void bY(int i) {
        this.CB = o.eb(i);
        float f = this.CB;
        this.CC = f;
        this.CD = f;
        this.CE = this.CC;
        in();
    }

    @Override // com.tk.core.component.e
    public final void bZ(int i) {
        this.CB = o.eb(i);
        in();
    }

    @Override // com.tk.core.component.e
    public final void ca(int i) {
        this.CC = o.eb(i);
        in();
    }

    @Override // com.tk.core.component.e
    public final void cb(int i) {
        this.CD = o.eb(i);
        in();
    }

    @Override // com.tk.core.component.e
    public final void cc(int i) {
        this.CE = o.eb(i);
        in();
    }

    private void in() {
        this.Cv.setRadius(this.CB, this.CC, this.CE, this.CD);
    }

    private static void a(g gVar) {
        if (gVar != null) {
            gVar.destroy();
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        this.Cv.unregisterMediaPlayStateListener(this.CF);
        this.Cv.destroy();
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        a(this.Cw);
        a(this.Cx);
        a(this.Cy);
        a(this.Cz);
        a(this.CA);
    }

    /* renamed from: com.kwad.tachikoma.i.a$a, reason: collision with other inner class name */
    class C0639a implements OfflineMediaPlayStateListener {
        private int CG;

        @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
        public final void onMediaPreparing() {
        }

        private C0639a() {
        }

        /* synthetic */ C0639a(a aVar, byte b) {
            this();
        }

        @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
        public final void onMediaPrepared() {
            com.kwad.tachikoma.e.log().d("TKImagePlayer", "====++++ video onMediaPrepared");
            cd(1);
        }

        @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
        public final void onMediaPlayProgress(long j, long j2) {
            com.kwad.tachikoma.e.log().d("TKImagePlayer", "====++++ video onMediaPlayProgress: " + j2 + ", videoDuration: " + j);
            if (a.this.Cx != null) {
                g gVar = a.this.Cx;
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
            com.kwad.tachikoma.e.log().d("TKImagePlayer", "====++++ video start");
            if (a.this.Cw != null) {
                a.this.Cw.call(null, new Object[0]);
            }
        }

        @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
        public final void onMediaPlaying() {
            com.kwad.tachikoma.e.log().d("TKImagePlayer", "====++++ video playing");
            cd(3);
        }

        @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
        public final void onMediaPlayPaused() {
            com.kwad.tachikoma.e.log().d("TKImagePlayer", "====++++ video paused");
            cd(4);
        }

        @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
        public final void onMediaPlayCompleted() {
            com.kwad.tachikoma.e.log().d("TKImagePlayer", "====++++ video completed");
            cd(5);
            if (a.this.Cy != null) {
                a.this.Cy.call(null, new Object[0]);
            }
        }

        @Override // com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener
        public final void onMediaPlayError(int i, int i2) {
            cd(8);
            if (a.this.Cz != null) {
                a.this.Cz.call(null, Integer.valueOf(i), String.valueOf(i2));
            }
        }

        private void cd(int i) {
            if (this.CG == i) {
                return;
            }
            this.CG = i;
            if (a.this.CA != null) {
                a.this.CA.call(null, Integer.valueOf(i));
            }
        }
    }
}
