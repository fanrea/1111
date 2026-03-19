package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private final Set<com.kwad.components.ad.reward.e.l> sW;

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.sW = new HashSet();
    }

    static class a {
        private static final b sY = new b(0);
    }

    public static b gp() {
        return a.sY;
    }

    public final void a(com.kwad.components.ad.reward.e.l lVar) {
        if (lVar != null) {
            this.sW.add(lVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.l lVar) {
        this.sW.remove(lVar);
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private void gq() {
        if (this.sW.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.l> it = this.sW.iterator();
        while (it.hasNext()) {
            it.next().onRewardVerify();
        }
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            gq();
        } else {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.b.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b.this.notifyRewardVerify();
                }
            });
        }
    }
}
