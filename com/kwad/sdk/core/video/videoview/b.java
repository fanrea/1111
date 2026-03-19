package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b extends RelativeLayout {
    private Runnable abK;
    protected final c bIR;

    protected abstract void onPlayStateChanged(int i);

    public void p(int i, int i2) {
    }

    protected abstract void reset();

    protected abstract void tR();

    public b(Context context, c cVar) {
        super(context);
        this.bIR = cVar;
    }

    protected final void tX() {
        tY();
        if (this.abK == null) {
            this.abK = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.tR();
                    if (b.this.abK != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.abK, 1000L);
                    }
                }
            };
        }
        post(this.abK);
    }

    protected final void tY() {
        Runnable runnable = this.abK;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.abK = null;
        }
    }
}
