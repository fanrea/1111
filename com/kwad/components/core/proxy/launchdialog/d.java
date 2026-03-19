package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    private final Lifecycle.Event Yl;
    private final long Ym = System.currentTimeMillis();

    public d(Lifecycle.Event event) {
        this.Yl = event;
    }

    public final String toString() {
        return "LifecycleStamp{mEvent=" + this.Yl + ", mEventTimestamp=" + this.Ym + '}';
    }

    public final Lifecycle.Event so() {
        return this.Yl;
    }

    public final long sp() {
        return this.Ym;
    }
}
