package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface g {

    public static class b implements g {
        private Lifecycle.Event Yl;

        public b(Lifecycle.Event event) {
            this.Yl = event;
        }

        public final boolean b(Lifecycle.Event event) {
            return this.Yl.equals(event);
        }

        public final String toString() {
            return "PageEventItem{mEvent=" + this.Yl + '}';
        }
    }

    public static class a implements g {
        private long Ys;

        public a(long j) {
            this.Ys = j;
        }

        public final boolean K(long j) {
            return this.Ys > 0 && System.currentTimeMillis() - j >= this.Ys;
        }

        public final String toString() {
            return "DurationMoreThanItem{mDuration=" + this.Ys + '}';
        }
    }
}
