package com.kwad.components.ct.emotion.a;

import com.kwad.components.ct.emotion.model.EmotionPackage;
import com.kwad.sdk.utils.ax;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends a {
    private final com.kwad.components.ct.emotion.c aBE;
    private final EmotionPackage aBF;
    private final Runnable aBJ;
    private final AtomicInteger aBG = new AtomicInteger(0);
    private final AtomicInteger aBH = new AtomicInteger(0);
    private final Object aBI = new Object();
    private boolean aBK = true;

    b(EmotionPackage emotionPackage, com.kwad.components.ct.emotion.c cVar, Runnable runnable) {
        this.aBE = cVar;
        this.aBF = emotionPackage;
        this.aBJ = runnable;
    }

    final void Dy() {
        if (this.aBG.incrementAndGet() < Dx() || this.aBH.get() < Dx() || !this.aBK) {
            return;
        }
        DA();
    }

    final void Dz() {
        if (this.aBH.incrementAndGet() < Dx() || this.aBG.get() < Dx() || !this.aBK) {
            return;
        }
        DA();
    }

    private void DA() {
        if (this.aBK) {
            synchronized (this.aBI) {
                if (this.aBK) {
                    com.kwad.components.ct.emotion.c cVar = this.aBE;
                    if (cVar != null) {
                        cVar.a(this.aBF);
                    }
                    this.aBK = false;
                    DC();
                }
            }
        }
    }

    final void DB() {
        if (this.aBK) {
            synchronized (this.aBI) {
                if (this.aBK) {
                    com.kwad.components.ct.emotion.c cVar = this.aBE;
                    if (cVar != null) {
                        EmotionPackage emotionPackage = this.aBF;
                        new IllegalStateException("download all cdn fail.");
                        cVar.b(emotionPackage);
                    }
                    this.aBK = false;
                    DC();
                }
            }
        }
    }

    private void DC() {
        try {
            this.aBJ.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.components.ct.emotion.a.a
    public final int Dx() {
        if (ax.f(this.aBF, "未成功初始化emoji package但调用了get总数.") == null) {
            return 0;
        }
        ax.f(this.aBF.emotions, "未成功初始化emoji package但调用了get总数.");
        return this.aBF.emotions.size();
    }
}
