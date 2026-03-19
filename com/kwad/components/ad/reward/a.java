package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private final Set<com.kwad.components.ad.reward.e.j> sR;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.sR = new HashSet();
    }

    /* renamed from: com.kwad.components.ad.reward.a$a, reason: collision with other inner class name */
    static class C0431a {
        private static final a sV = new a(0);
    }

    public static a gl() {
        return C0431a.sV;
    }

    public final void a(com.kwad.components.ad.reward.e.j jVar) {
        if (jVar != null) {
            this.sR.add(jVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.j jVar) {
        this.sR.remove(jVar);
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, com.kwad.components.ad.reward.e.n nVar) {
        if (this.sR.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.sR.iterator();
        while (it.hasNext()) {
            it.next().a(playableSource, nVar);
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void c(final PlayableSource playableSource, final com.kwad.components.ad.reward.e.n nVar) {
        if (isMainThread()) {
            b(playableSource, nVar);
        } else {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.a.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    a.this.b(playableSource, nVar);
                }
            });
        }
    }

    public final void gm() {
        if (isMainThread()) {
            gn();
        } else {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.a.2
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    a.this.gm();
                }
            });
        }
    }

    public final void b(final PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.a.3
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    a.this.c(playableSource);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        if (this.sR.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.sR.iterator();
        while (it.hasNext()) {
            it.next().dq();
        }
    }

    private void gn() {
        if (this.sR.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.sR.iterator();
        while (it.hasNext()) {
            it.next().dp();
        }
    }
}
