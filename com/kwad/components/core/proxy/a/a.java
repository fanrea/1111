package com.kwad.components.core.proxy.a;

import android.os.SystemClock;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private String Yt;
    private long Yu;
    private long Yv;
    private long Yw;
    private boolean Yx;
    private c Yy;

    public a(c cVar) {
        this.Yy = cVar;
    }

    public final void aH(String str) {
        this.Yt = str;
    }

    public final void L(long j) {
        this.Yu = j;
        this.Yv = SystemClock.uptimeMillis();
    }

    public final void sr() {
        if (this.Yx) {
            return;
        }
        this.Yx = true;
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.proxy.a.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.Yw = SystemClock.uptimeMillis();
                a.this.report();
            }
        });
    }

    public final void a(PageCreateStage pageCreateStage) {
        c cVar = this.Yy;
        if (cVar != null) {
            cVar.onCreateStageChange(pageCreateStage);
        }
    }

    public final void report() {
        b bVar = new b();
        bVar.Yt = this.Yt;
        long j = this.Yu;
        bVar.YB = j != 0 ? this.Yv - j : 0L;
        long j2 = this.Yv;
        bVar.YC = j2 != 0 ? this.Yw - j2 : 0L;
        long j3 = this.Yu;
        bVar.YA = j3 != 0 ? this.Yw - j3 : 0L;
        com.kwad.components.core.q.a.ss().a(bVar);
        com.kwad.sdk.core.d.c.d("PageMonitor", bVar.toString());
    }
}
