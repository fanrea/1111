package com.sigmob.sdk.videoplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends RelativeLayout implements h {
    private static final int u = 6000;
    i a;
    Class b;
    l c;
    public g d;
    public d e;
    private ViewGroup f;
    private int g;
    private Timer h;
    private C0747a i;
    private boolean j;
    private boolean k;
    private final Handler l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private float q;
    private k r;
    private int s;
    private String t;
    private boolean v;

    /* renamed from: com.sigmob.sdk.videoplayer.a$a, reason: collision with other inner class name */
    public class C0747a extends TimerTask {
        public C0747a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            long currentPositionWhenPlaying = a.this.getCurrentPositionWhenPlaying();
            long duration = a.this.getDuration();
            if (a.this.r == null) {
                return;
            }
            a.this.r.a(currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (a.this.e == d.STATE_PLAYING || a.this.e == d.STATE_PAUSE) {
                a.this.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.a$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a();
                    }
                });
            }
        }
    }

    public a(Context context) {
        super(context);
        this.e = d.STATE_IDLE;
        this.l = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.videoplayer.a.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                if (msg.what != 6000 || a.this.j || a.this.k) {
                    return;
                }
                a.this.j = true;
                a.this.setState(d.STATE_BUFFERING_START);
            }
        };
        FrameLayout frameLayout = new FrameLayout(context);
        this.f = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void s() {
        try {
            i iVar = this.a;
            if (iVar != null) {
                iVar.f();
            }
            Class cls = this.b;
            this.a = cls == null ? new j(this) : (i) cls.getConstructor(a.class).newInstance(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a() {
        SigmobLog.d("startVideo [" + hashCode() + "] ");
        try {
            s();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Window windowC = c.c(getContext());
        if (windowC != null) {
            windowC.setFlags(16777216, 16777216);
            windowC.addFlags(128);
        }
        m();
        b();
    }

    public void a(int seek) {
        if (this.e != d.STATE_PAUSE && this.e != d.STATE_PREPARED && this.e != d.STATE_AUTO_COMPLETE && this.e != d.STATE_PLAYING) {
            this.g = seek;
            return;
        }
        i iVar = this.a;
        if (iVar == null) {
            return;
        }
        iVar.a(seek);
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void a(int what, int extra) {
        this.s = what;
        this.t = "" + extra;
        setState(d.STATE_ERROR);
    }

    public void a(g videoPlayerDataSource, int screen) {
        this.d = videoPlayerDataSource;
        c();
    }

    public void b() {
        SigmobLog.d("onStatePreparing  [" + hashCode() + "] ");
        setState(d.STATE_PREPARING);
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void b(int what, int extra) {
        d dVar;
        SigmobLog.d("onInfo() called with: what = [" + what + "], extra = [" + extra + "]");
        if (what == 3) {
            if (!this.k) {
                this.k = true;
                this.l.removeMessages(6000);
            }
            if (!this.j) {
                return;
            } else {
                this.j = false;
            }
        } else if (what == 701) {
            dVar = d.STATE_BUFFERING_START;
            setState(dVar);
        } else if (what != 702) {
            return;
        }
        dVar = d.STATE_BUFFERING_END;
        setState(dVar);
    }

    public void c() {
        SigmobLog.d("onStateNormal stat" + this.e + " [" + hashCode() + "] ");
        setState(d.STATE_NORMAL);
        i iVar = this.a;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void c(int width, int height) {
        this.o = height;
        this.p = width;
        SigmobLog.d("onVideoSizeChanged  [" + hashCode() + "] ");
        l lVar = this.c;
        if (lVar == null) {
            return;
        }
        float f = this.q;
        if (f != 0.0f) {
            lVar.setRotation(f);
        }
        this.c.a(width, height);
    }

    public void d() {
        this.n = false;
        if (this.e == d.STATE_NORMAL || this.a == null) {
            a();
            return;
        }
        if (this.e == d.STATE_PAUSE || this.e == d.STATE_BUFFERING_END || this.e == d.STATE_AUTO_COMPLETE || this.e == d.STATE_PREPARED) {
            this.a.a();
            e();
        }
    }

    public void e() {
        SigmobLog.d("onStatePlaying  [" + hashCode() + "] ");
        if (this.e == d.STATE_PREPARED) {
            int i = this.g;
            if (i != 0) {
                this.a.a(i);
                this.g = 0;
            }
            if (!this.k) {
                this.l.sendEmptyMessageDelayed(6000, com.alipay.sdk.m.u.b.a);
            }
        }
        setState(d.STATE_PLAYING);
        f();
    }

    public void f() {
        SigmobLog.d("startProgressTimer:  [" + hashCode() + "] ");
        l();
        this.h = new Timer();
        C0747a c0747a = new C0747a();
        this.i = c0747a;
        this.h.schedule(c0747a, 0L, 300L);
    }

    public boolean g() {
        return this.v;
    }

    public long getCurrentPositionWhenPlaying() {
        if (this.e != d.STATE_PLAYING && this.e != d.STATE_PAUSE) {
            return 0L;
        }
        try {
            return this.a.g();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            i iVar = this.a;
            if (iVar != null) {
                return iVar.j();
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public int getErrorCode() {
        return this.s;
    }

    public String getErrorMessage() {
        return this.t;
    }

    public int getVideoHeight() {
        return this.o;
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public g getVideoPlayerDataSource() {
        return this.d;
    }

    public int getVideoWidth() {
        return this.p;
    }

    public void h() {
        SigmobLog.d("reset  [" + hashCode() + "] ");
        l();
        c();
        this.f.removeAllViews();
        Window windowC = c.c(getContext());
        if (windowC != null) {
            windowC.clearFlags(128);
        }
        i iVar = this.a;
        if (iVar != null) {
            iVar.f();
        }
    }

    public void i() {
        setState(d.STATE_STOP);
        h();
    }

    public void j() {
        if (this.e == d.STATE_NORMAL || this.e == d.STATE_PREPARING || this.e == d.STATE_ERROR) {
            h();
        } else {
            if (this.e == d.STATE_PAUSE || this.a == null) {
                return;
            }
            k();
            this.a.d();
        }
    }

    public void k() {
        SigmobLog.i("onStatePause  [" + hashCode() + "] ");
        setState(d.STATE_PAUSE);
        f();
    }

    public void l() {
        Timer timer = this.h;
        if (timer != null) {
            timer.cancel();
        }
        C0747a c0747a = this.i;
        if (c0747a != null) {
            c0747a.cancel();
        }
    }

    public void m() {
        SigmobLog.d("addTextureView [" + hashCode() + "] ");
        l lVar = this.c;
        if (lVar != null) {
            this.f.removeView(lVar);
        }
        l lVar2 = new l(getContext().getApplicationContext());
        this.c = lVar2;
        lVar2.setSurfaceTextureListener(this.a);
        this.f.addView(this.c, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void n() {
        this.n = true;
        a();
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void o() {
        SigmobLog.d("onPrepared  [" + hashCode() + "] ");
        setState(d.STATE_PREPARED);
        setMute(this.m);
        if (this.n) {
            return;
        }
        SigmobLog.d("mediaInterface start");
        e();
        this.a.a();
        this.n = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SigmobLog.d("onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void p() {
        setState(d.STATE_AUTO_COMPLETE);
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void q() {
    }

    public void r() {
        this.r = null;
        h();
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void setBufferProgress(int percent) {
    }

    public void setLooping(boolean looping) {
        i iVar = this.a;
        if (iVar == null) {
            return;
        }
        try {
            iVar.a(looping);
            this.v = looping;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void setMute(boolean isMute) {
        this.m = isMute;
        i iVar = this.a;
        if (iVar == null) {
            return;
        }
        iVar.a(isMute ? 0.0f : 1.0f);
    }

    public void setState(d state) {
        this.e = state;
        if (state == d.STATE_PLAYING) {
            c.f(com.sigmob.sdk.b.e());
        } else if (state == d.STATE_NORMAL || state == d.STATE_PAUSE || state == d.STATE_AUTO_COMPLETE || state == d.STATE_STOP) {
            c.g(com.sigmob.sdk.b.e());
        }
        k kVar = this.r;
        if (kVar == null) {
            return;
        }
        kVar.a(state);
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void setSurfaceTexture(SurfaceTexture saved_surface) {
        l lVar = this.c;
        if (lVar == null) {
            return;
        }
        lVar.setSurfaceTexture(saved_surface);
    }

    public void setTextureViewContainer(ViewGroup textureViewContainer) {
        this.f = textureViewContainer;
    }

    public void setUp(String url) {
        a(new g(url, (String) null), 0);
    }

    public void setVideoPlayerStatusListener(k listener) {
        this.r = listener;
    }
}
