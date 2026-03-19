package com.kwad.components.ct.home;

import android.view.KeyEvent;
import android.view.View;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private final i aFo;
    private final View.OnKeyListener aGB = new View.OnKeyListener() { // from class: com.kwad.components.ct.home.c.1
        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                return c.this.aFo.Fs();
            }
            return false;
        }
    };
    private final Runnable aGC;
    private final View mRootView;

    public c(i iVar) {
        Runnable runnable = new Runnable() { // from class: com.kwad.components.ct.home.c.2
            @Override // java.lang.Runnable
            public final void run() {
                c cVar = c.this;
                cVar.Q(cVar.mRootView);
            }
        };
        this.aGC = runnable;
        this.aFo = iVar;
        View view = iVar.getView();
        this.mRootView = view;
        Q(view);
        bx.runOnUiThreadDelay(runnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(View view) {
        if (view != null) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnKeyListener(this.aGB);
        }
    }

    public final void release() {
        bx.d(this.aGC);
        View view = this.mRootView;
        if (view != null) {
            view.setFocusableInTouchMode(false);
            this.mRootView.setOnKeyListener(null);
        }
    }
}
