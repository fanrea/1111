package com.kwad.components.ct.wallpaper.c;

import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.kwad.components.ct.widget.KsAdFrameLayout;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.b {
    private View aZH;
    private KsAdFrameLayout ave;
    private GestureDetector mGestureDetector;
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.wallpaper.c.a.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            a.this.aZH.setVisibility(0);
        }
    };
    private GestureDetector.SimpleOnGestureListener avg = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.components.ct.wallpaper.c.a.2
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
            this.avI = false;
            this.avJ = 0L;
            if (a.this.aZH.getVisibility() == 0) {
                a.this.aZH.setVisibility(8);
                return true;
            }
            a.this.aZH.setVisibility(0);
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

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAdFrameLayout ksAdFrameLayout = (KsAdFrameLayout) findViewById(R.id.ksad_video_container);
        this.ave = ksAdFrameLayout;
        ksAdFrameLayout.setClickable(true);
        this.aZH = findViewById(R.id.ksad_wallpaper_dismiss_layout);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aop.aoq.add(this.aoQ);
        this.aZH.setVisibility(0);
        GestureDetector gestureDetector = new GestureDetector(getContext(), this.avg);
        this.mGestureDetector = gestureDetector;
        this.ave.a(gestureDetector);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aZH.setVisibility(0);
        this.aop.aoq.remove(this.aoQ);
        this.ave.b(this.mGestureDetector);
    }
}
