package com.kwad.components.ct.detail.photo.newui.d;

import android.os.SystemClock;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private final int auI;
    private a auJ;
    private boolean auK;
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.photo.newui.d.e.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            long jAJ = e.this.auL.AJ();
            if (e.this.auK || 100 * jAJ <= e.this.auI * j || e.this.auJ == null) {
                return;
            }
            e.this.auJ.l(j, jAJ);
            e.this.auK = true;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            com.kwad.sdk.core.d.c.d("PlayRateHelper", "onVideoPlayStart()");
            if (e.this.auL.AI()) {
                e.this.auL.reset();
            }
            e.this.auK = false;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            com.kwad.sdk.core.d.c.d("PlayRateHelper", "onVideoPlaying()");
            if (e.this.auL.AI()) {
                e.this.auL.AG();
            } else {
                e.this.auL.startTiming();
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            com.kwad.sdk.core.d.c.d("PlayRateHelper", "onVideoPlayPaused()");
            e.this.auL.AH();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            e.this.auL.AH();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            com.kwad.sdk.core.d.c.d("PlayRateHelper", "onVideoPlayPaused()");
            e.this.auL.AH();
        }
    };
    private b auL = new b();

    interface a {
        void l(long j, long j2);
    }

    public class b {
        private long auN;
        private long auO;
        private boolean auP;

        public b() {
            reset();
        }

        public final void startTiming() {
            reset();
            this.auP = true;
            this.auO = SystemClock.elapsedRealtime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.auN = 0L;
            this.auO = -1L;
        }

        public final void AG() {
            if (this.auP && this.auO < 0) {
                this.auO = SystemClock.elapsedRealtime();
            }
        }

        public final void AH() {
            if (this.auP && this.auO > 0) {
                this.auN += SystemClock.elapsedRealtime() - this.auO;
                this.auO = -1L;
            }
        }

        public final boolean AI() {
            return this.auP;
        }

        public final long AJ() {
            if (this.auP && this.auO > 0) {
                return (this.auN + SystemClock.elapsedRealtime()) - this.auO;
            }
            return 0L;
        }
    }

    public e(a aVar) {
        this.auJ = aVar;
        int iAx = c.Aw().Ax();
        this.auI = iAx;
        com.kwad.sdk.core.d.c.d("PlayRateHelper", "rate=" + iAx);
    }

    public final void a(com.kwad.components.ct.detail.e.a aVar) {
        if (aVar != null) {
            aVar.d(this.mVideoPlayStateListener);
        }
    }

    public final void b(com.kwad.components.ct.detail.e.a aVar) {
        if (aVar != null) {
            aVar.c(this.mVideoPlayStateListener);
        }
    }
}
