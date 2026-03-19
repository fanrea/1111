package com.kwad.components.ct.detail.photo.presenter;

import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageButton;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.detail.e.a;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.widget.KsAdFrameLayout;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.detail.b {
    private SlidePlayViewPager aok;
    private com.kwad.components.ct.detail.e.a aoz;
    private ImageButton avC;
    private com.kwad.sdk.widget.swipe.c avG;
    private KsAdFrameLayout ave;
    private GestureDetector mGestureDetector;
    private com.kwad.components.ct.hotspot.e aqP = new com.kwad.components.ct.hotspot.f() { // from class: com.kwad.components.ct.detail.photo.presenter.e.1
        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void zp() {
            e.this.bH(1);
            e.this.avC.setVisibility(4);
        }

        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void bB(int i) {
            e.this.bH(0);
        }
    };
    private b avD = new C0509e(this, 0);
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.presenter.e.2
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            e.this.Bb();
        }
    };
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.photo.presenter.e.3
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            e.this.Bc();
            e.this.Ba().a(new d(e.this, (byte) 0));
            e.a(e.this, false);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            e.this.Ba().a(new d(e.this, (byte) 0));
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            e.this.Ba().a(new c(e.this, (byte) 0));
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            e.this.Bb();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            e.this.Bb();
        }
    };
    private Runnable avE = new Runnable() { // from class: com.kwad.components.ct.detail.photo.presenter.e.4
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("PhotoVideoControlPresenter", "mAutoHidePauseButtonCallback run=" + e.this.avD);
            if (e.this.avD != null) {
                e.this.avD.a(new d(e.this, (byte) 0));
            }
        }
    };
    View.OnClickListener avF = new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.presenter.e.5
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.this.Bc();
            if (e.this.Ba() instanceof d) {
                e.this.Ba().Be();
            } else {
                e.this.Ba().Bd();
            }
        }
    };
    private boolean aps = false;
    private a.InterfaceC0507a apx = new a.InterfaceC0507a() { // from class: com.kwad.components.ct.detail.photo.presenter.e.6
        @Override // com.kwad.components.ct.detail.e.a.InterfaceC0507a
        public final boolean yM() {
            return e.this.aps;
        }
    };
    private GestureDetector.SimpleOnGestureListener avg = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.components.ct.detail.photo.presenter.e.7
        boolean avI = false;
        long avJ = 0;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            this.avJ = SystemClock.elapsedRealtime();
            return this.avI;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (AQ()) {
                return false;
            }
            e.this.Bc();
            if (e.this.avG != null && (e.this.aok.getSourceType() != 0 || e.this.avG.aqZ())) {
                e.this.avG.ara();
            } else {
                e.this.Ba().Be();
            }
            this.avI = false;
            this.avJ = 0L;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            this.avI = false;
            return true;
        }

        private boolean AQ() {
            return SystemClock.elapsedRealtime() - this.avJ < ((long) ViewConfiguration.getJumpTapTimeout());
        }
    };
    private com.kwad.sdk.widget.swipe.a aqH = new com.kwad.sdk.widget.swipe.b() { // from class: com.kwad.components.ct.detail.photo.presenter.e.8
        @Override // com.kwad.sdk.widget.swipe.b, com.kwad.sdk.widget.swipe.a
        public final void j(float f) {
            e.this.i(f);
        }
    };

    interface b {
        void Bd();

        void Be();

        void Bf();

        void a(b bVar);
    }

    static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.aps = false;
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.avC = (ImageButton) findViewById(R.id.ksad_video_control_button);
        KsAdFrameLayout ksAdFrameLayout = (KsAdFrameLayout) findViewById(R.id.ksad_video_container);
        this.ave = ksAdFrameLayout;
        ksAdFrameLayout.setClickable(true);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aps = false;
        this.aok = this.aop.aok;
        if (this.aop.aol != null) {
            this.avG = this.aop.aol.avG;
        }
        com.kwad.components.ct.detail.e.a aVar = this.aop.aoz;
        this.aoz = aVar;
        aVar.a(this.apx);
        this.aoz.c(this.mVideoPlayStateListener);
        this.aop.aoq.add(this.aoQ);
        Bb();
        this.avC.setOnClickListener(this.avF);
        GestureDetector gestureDetector = new GestureDetector(getContext(), this.avg);
        this.mGestureDetector = gestureDetector;
        this.ave.a(gestureDetector);
        if (com.kwad.components.ct.response.a.a.aV(this.aop.mAdTemplate)) {
            this.aop.a(this.aqP);
        }
        i(this.aok.getSourceType() == 0 ? 1.0f : 0.0f);
        this.aop.aot.add(this.aqH);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aoz.b(this.apx);
        this.aoz.d(this.mVideoPlayStateListener);
        this.avC.setOnClickListener(null);
        this.aop.aoq.remove(this.aoQ);
        this.ave.b(this.mGestureDetector);
        Bb();
        this.aop.b(this.aqP);
        this.aop.aot.remove(this.aqH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(float f) {
        this.avC.setAlpha(f);
        this.avC.setClickable(f == 1.0f);
    }

    public final b Ba() {
        if (this.avD == null) {
            this.avD = new d(this, (byte) 0);
        }
        return this.avD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bb() {
        Bc();
        this.avD = new C0509e(this, (byte) 0);
        bz(false);
        this.aps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(int i) {
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            boolean z = false;
            if (i == 1) {
                this.aps = true;
                aVar.pause();
                z = true;
            } else {
                this.aps = false;
                aVar.bC(true);
            }
            if (this.aop.aol.aHs != null) {
                this.aop.aol.aHs.aF(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(boolean z) {
        this.avC.setBackgroundResource(R.drawable.ksad_photo_video_play_icon_2);
        this.avC.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bc() {
        this.avC.removeCallbacks(this.avE);
    }

    abstract class a implements b {
        @Override // com.kwad.components.ct.detail.photo.presenter.e.b
        public void Bd() {
        }

        @Override // com.kwad.components.ct.detail.photo.presenter.e.b
        public void Be() {
        }

        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        @Override // com.kwad.components.ct.detail.photo.presenter.e.b
        public final void a(b bVar) {
            e.this.avD = bVar;
            bVar.Bf();
        }
    }

    /* renamed from: com.kwad.components.ct.detail.photo.presenter.e$e, reason: collision with other inner class name */
    class C0509e extends a {
        @Override // com.kwad.components.ct.detail.photo.presenter.e.a, com.kwad.components.ct.detail.photo.presenter.e.b
        public final void Be() {
        }

        private C0509e() {
            super(e.this, (byte) 0);
        }

        /* synthetic */ C0509e(e eVar, byte b) {
            this();
        }

        @Override // com.kwad.components.ct.detail.photo.presenter.e.b
        public final void Bf() {
            e.this.bz(false);
        }
    }

    class d extends a {
        private d() {
            super(e.this, (byte) 0);
        }

        /* synthetic */ d(e eVar, byte b) {
            this();
        }

        @Override // com.kwad.components.ct.detail.photo.presenter.e.b
        public final void Bf() {
            e.this.bz(false);
        }

        @Override // com.kwad.components.ct.detail.photo.presenter.e.a, com.kwad.components.ct.detail.photo.presenter.e.b
        public final void Be() {
            e.this.bH(1);
        }
    }

    class c extends a {
        private c() {
            super(e.this, (byte) 0);
        }

        /* synthetic */ c(e eVar, byte b) {
            this();
        }

        @Override // com.kwad.components.ct.detail.photo.presenter.e.b
        public final void Bf() {
            e.this.bz(true);
        }

        @Override // com.kwad.components.ct.detail.photo.presenter.e.a, com.kwad.components.ct.detail.photo.presenter.e.b
        public final void Bd() {
            e.this.bH(0);
        }

        @Override // com.kwad.components.ct.detail.photo.presenter.e.a, com.kwad.components.ct.detail.photo.presenter.e.b
        public final void Be() {
            e.this.bH(0);
        }
    }
}
