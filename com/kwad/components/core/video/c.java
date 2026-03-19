package com.kwad.components.core.video;

import java.util.Stack;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c {
    private static volatile c aci;
    private int acj = 0;
    private Stack<g> ack = new Stack<>();

    private c() {
    }

    public static c ub() {
        if (aci == null) {
            synchronized (c.class) {
                if (aci == null) {
                    aci = new c();
                }
            }
        }
        return aci;
    }

    public final void a(g gVar) {
        com.kwad.sdk.core.d.c.d("DetailPlayControlManager", "registerPlayerController ");
        if (!com.kwad.sdk.core.config.e.Yn() || gVar == null || this.ack.contains(gVar)) {
            return;
        }
        if (this.ack.isEmpty()) {
            int iUc = gVar.uc();
            int i = this.acj;
            if (iUc < i) {
                gVar.bk(i);
            }
        } else {
            g gVarPop = this.ack.pop();
            if (gVarPop != null) {
                gVarPop.ut();
            }
            this.ack.clear();
        }
        this.acj = 0;
        this.ack.push(gVar);
    }

    public final void b(g gVar) {
        com.kwad.sdk.core.d.c.d("DetailPlayControlManager", "unRegisterPlayerController ");
        if (com.kwad.sdk.core.config.e.Yn() && !this.ack.isEmpty()) {
            if (this.ack.contains(gVar)) {
                gVar.ut();
                this.ack.clear();
            }
            this.acj = 0;
        }
    }

    public final void resumeCurrentPlayer() {
        if (com.kwad.sdk.core.config.e.Yn()) {
            com.kwad.sdk.core.d.c.d("DetailPlayControlManager", "resumeCurrentPlayer ");
            if (this.ack.isEmpty()) {
                com.kwad.sdk.core.d.c.d("DetailPlayControlManager", "resumeCurrentPlayer is empty");
                return;
            }
            g gVarPeek = this.ack.peek();
            if (gVarPeek == null || gVarPeek.uc() > 2) {
                return;
            }
            gVarPeek.bk(1);
            gVarPeek.resume();
        }
    }

    public final void pauseCurrentPlayer() {
        com.kwad.sdk.core.d.c.d("DetailPlayControlManager", "pauseCurrentPlayer ");
        if (com.kwad.sdk.core.config.e.Yn()) {
            if (this.ack.isEmpty()) {
                this.acj = 2;
                return;
            }
            g gVarPeek = this.ack.peek();
            if (gVarPeek == null || gVarPeek.uc() > 2) {
                return;
            }
            gVarPeek.bk(2);
            gVarPeek.pause();
        }
    }

    private int uc() {
        g gVarPeek;
        if (!com.kwad.sdk.core.config.e.Yn()) {
            return 0;
        }
        if (!this.ack.isEmpty() && (gVarPeek = this.ack.peek()) != null) {
            return gVarPeek.uc();
        }
        int i = this.acj;
        if (i != 0) {
            return i;
        }
        return 0;
    }

    private boolean ud() {
        int iUc = uc();
        return iUc == 2 || iUc == 1;
    }

    public final int ue() {
        return ud() ? 1 : 0;
    }
}
