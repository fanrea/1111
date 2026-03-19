package com.kwad.components.core.widget.a;

import android.os.Message;
import android.view.View;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.cb;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a implements com.kwad.sdk.core.j.a, cb.a {
    private Set<com.kwad.sdk.core.j.c> alC;
    private final int alD;
    private final View mRootView;
    private final AtomicBoolean alB = new AtomicBoolean(false);
    protected final cb dC = new cb(this);

    public abstract boolean ai();

    public a(View view, int i) {
        this.mRootView = view;
        this.alD = i;
    }

    public void a(Message message) {
        if (message.what == 666) {
            wJ();
            this.dC.sendEmptyMessageDelayed(666, 500L);
        }
    }

    public final void wJ() {
        if (ai()) {
            km();
        } else {
            wN();
        }
    }

    public final void wK() {
        this.dC.removeMessages(666);
        this.dC.sendEmptyMessage(666);
    }

    public final void wL() {
        wJ();
        this.dC.removeCallbacksAndMessages(null);
    }

    public final boolean wM() {
        return ca.a(this.mRootView, this.alD, false);
    }

    private void km() {
        if (this.alB.getAndSet(true)) {
            return;
        }
        bi(true);
    }

    protected final void wN() {
        if (this.alB.getAndSet(false)) {
            bi(false);
        }
    }

    private void bi(boolean z) {
        Set<com.kwad.sdk.core.j.c> set = this.alC;
        if (set == null) {
            return;
        }
        for (com.kwad.sdk.core.j.c cVar : set) {
            if (cVar != null) {
                if (z) {
                    cVar.by();
                } else {
                    cVar.bz();
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.j.a
    public final boolean wO() {
        return this.alB.get();
    }

    @Override // com.kwad.sdk.core.j.a
    public final void a(final com.kwad.sdk.core.j.c cVar) {
        ap.checkUiThread();
        if (cVar == null) {
            return;
        }
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.core.widget.a.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (a.this.ai()) {
                    cVar.by();
                } else {
                    cVar.bz();
                }
            }
        });
        if (this.alC == null) {
            this.alC = new HashSet();
        }
        this.alC.add(cVar);
    }

    @Override // com.kwad.sdk.core.j.a
    public final void b(com.kwad.sdk.core.j.c cVar) {
        Set<com.kwad.sdk.core.j.c> set;
        ap.checkUiThread();
        if (cVar == null || (set = this.alC) == null) {
            return;
        }
        set.remove(cVar);
    }

    @Override // com.kwad.sdk.core.j.a
    public void release() {
        wL();
        Set<com.kwad.sdk.core.j.c> set = this.alC;
        if (set != null) {
            set.clear();
        }
    }
}
